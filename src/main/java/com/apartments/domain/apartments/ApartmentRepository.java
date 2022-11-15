package com.apartments.domain.apartments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ApartmentRepository extends Repository<ApartmentEntity, Long> {

    void save(ApartmentEntity entity);

    Page<ApartmentEntity> findAll(Pageable pageable);

    List<ApartmentEntity> findAll();

    Optional<ApartmentEntity> findById(long id);

    void deleteById(long id);
}
