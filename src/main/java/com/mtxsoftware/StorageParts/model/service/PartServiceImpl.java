package com.mtxsoftware.StorageParts.model.service;

import com.mtxsoftware.StorageParts.model.entity.Part;
import com.mtxsoftware.StorageParts.model.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PartServiceImpl implements PartService {


    private PartRepository partRepository;

    @Autowired
    public void setPartRepository(PartRepository partRepository) {
        this.partRepository = partRepository;
    }


    @Override
    public Part getPartById(Long id) {
        Optional<Part> optionalPart = partRepository.findById(id);
        return optionalPart.get();
    }

    @Override
    public void savePart(Part part) {
        partRepository.save(part);
    }

    @Override
    public void updatePart(Long id, String name, Integer count, Boolean necessary) {
        Part findPart = this.getPartById(id);
        findPart.setCount(count);
        findPart.setName(name);
        findPart.setNecessary(necessary);
        partRepository.save(findPart);

    }

    @Override
    public void deletePart(Long id) {
        partRepository.deleteById(id);
    }


    @Override
    public Page<Part> findAll(Pageable pageable) {
        //List<Part> lstPart = new ArrayList<>();
       // Iterable<Part> iterator = partRepository.findAll(pageable);
       // iterator.forEach(part -> lstPart.add(part));
        return partRepository.findAll(pageable);
    }

    @Override
    public Page<Part> findByName(String name, Pageable pageable) {
        return partRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Part> findAllNecessary(Boolean necessary, Pageable pageable){
        return partRepository.findByNecessary(necessary, pageable);
    }

    @Override
    public Part findFirstByNecessaryOrderByCountAsc(Boolean necessary){
        return partRepository.findFirstByNecessaryOrderByCountAsc(necessary);
    }
}
