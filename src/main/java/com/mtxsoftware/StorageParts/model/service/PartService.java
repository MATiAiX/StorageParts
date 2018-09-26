package com.mtxsoftware.StorageParts.model.service;

import com.mtxsoftware.StorageParts.model.entity.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PartService {
    Part getPartById(Long id);
    void savePart(Part part);
    void updatePart(Long id, String name,Integer count, Boolean necessary);
    void deletePart(Long id);
    Page<Part> findAll(Pageable pageable);
    Page<Part> findAllNecessary(Boolean necessary, Pageable pageable);
    Page<Part> findByName(String name, Pageable pageable);
    Part findFirstByNecessaryOrderByCountAsc(Boolean necessary);
}
