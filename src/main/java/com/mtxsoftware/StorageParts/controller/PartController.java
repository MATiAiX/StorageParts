package com.mtxsoftware.StorageParts.controller;

import com.mtxsoftware.StorageParts.model.PagerModel;
import com.mtxsoftware.StorageParts.model.entity.Part;
import com.mtxsoftware.StorageParts.model.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PartController {

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 10;
    public static final String[] ALL_TYPES = {"All", "Only necessary", "Only optional"};
    private Part assemblyPC;
    private String filterIndex = "All";
    private String searchName = "";

    @Autowired
    private PartService partService;


    @GetMapping("/")
    public ModelAndView homepage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                 @RequestParam("page") Optional<Integer> page) {


        ModelAndView modelAndView = new ModelAndView("index");

        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Part> parts;
        if (filterIndex.equals("Only necessary")) {
            parts = partService.findAllNecessary(true, new PageRequest(evalPage, evalPageSize));
        } else if (filterIndex.equals("Only optional")) {
            parts = partService.findAllNecessary(false, new PageRequest(evalPage, evalPageSize));
        } else if (filterIndex.equals("All"))
            parts = partService.findAll(new PageRequest(evalPage, evalPageSize));
        else
            parts = partService.findByName(searchName, new PageRequest(evalPage, evalPageSize));

        assemblyPC = partService.findFirstByNecessaryOrderByCountAsc(true);

        PagerModel pager = new PagerModel(parts.getTotalPages(), parts.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("parts", parts);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("assemblyPC", assemblyPC);
        return modelAndView;
    }
    /*
    public void setPartService(PartService partService) {
        this.partService = partService;
    }*/

    //@GetMapping("/")
    //public String list(Model model) {
    //    List<Part> parts = partService.findAll();
    //    model.addAttribute("parts",parts);
    //     return "index";
    // }

    @GetMapping("/new")
    public String newPart() {
        return "new";
    }

    @PostMapping("/save")
    public String updatePart(@RequestParam String name, @RequestParam Integer count, @RequestParam(value = "necessary", required = false) Boolean necessary) {
        if (necessary == null)
            necessary = false;
        partService.savePart(new Part(name, count, necessary));
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Part part = partService.getPartById(id);
        model.addAttribute("part", part);
        return "edit";
    }


    @GetMapping("/filter")
    public String viewFilter(Model model) {
        List<String> filters = new ArrayList<>();
        filters.add("All");
        filters.add("Only necessary");
        filters.add("Only optional");
        model.addAttribute("filterIndex", filterIndex);
        model.addAttribute("filters", filters);
        return "filter";
    }

    @GetMapping("/search")
    public String searchByName(Model model) {
        return "search";
    }

    @PostMapping("/setsearch")
    public String setSearch(@RequestParam String name) {
        filterIndex="findName";
        this.searchName = name;
        return "redirect:/";
    }


    @PostMapping("/setfilter")
    public String setFilterIndex(@RequestParam String radioName) {
        filterIndex=radioName;
        return "redirect:/";
    }

    @PostMapping("/update")
    public String savePart(@RequestParam Long id, @RequestParam String name, @RequestParam Integer count, @RequestParam(value = "necessary", required = false) Boolean necessary) {
        if (necessary == null)
            necessary = false;
        partService.updatePart(id, name, count, necessary);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        partService.deletePart(id);
        return "redirect:/";
    }


}
