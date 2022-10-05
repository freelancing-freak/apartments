package com.apartments.domain.apartments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

interface ApartmentRepository extends Repository<ApartmentEntity, Long> {

    void save(ApartmentEntity entity);

    Page<ApartmentEntity> findAll(Pageable pageable);
}
