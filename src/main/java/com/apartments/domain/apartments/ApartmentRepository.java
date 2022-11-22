package com.apartments.domain.apartments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface ApartmentRepository extends Repository<ApartmentEntity, Long> {

    void save(ApartmentEntity entity);

    Page<ApartmentEntity> findAll(Pageable pageable);

    @Query("select a from ApartmentEntity a " +
            "where lower(a.name) like lower(concat('%', :filterText, '%')) " +
            "or lower(a.location) like lower(concat('%', :filterText, '%')) " +
            "or lower(a.price) like lower(concat('%', :filterText, '%'))")
    List<ApartmentEntity> search(String filterText);

    List<ApartmentEntity> findAll();

    Optional<ApartmentEntity> findById(long id);

    void deleteById(long id);
}
