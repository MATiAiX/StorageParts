package com.mtxsoftware.StorageParts.model.repository;

import com.mtxsoftware.StorageParts.model.entity.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PartRepository extends PagingAndSortingRepository<Part,Long> {

    Page<Part> findByNecessary(Boolean necessary, Pageable pageable);
    Page<Part> findByNameContaining(String name, Pageable pageable);
    Part findFirstByNecessaryOrderByCountAsc(Boolean necessary);
}
