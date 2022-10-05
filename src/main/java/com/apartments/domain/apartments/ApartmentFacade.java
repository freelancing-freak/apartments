package com.apartments.domain.apartments;

import com.apartments.application.api.dto.ApartmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class ApartmentFacade {

    private final ApartmentRepository repository;

    public void save(ApartmentRequest request) {
        repository.save(ApartmentEntityFactory.create(request));
    }

    public Page<Apartment> findAll(Pageable pageable) {
        final var apartments = repository.findAll(pageable);
        return new PageImpl<>(apartments
                .stream()
                .map(Apartment::from)
                .toList(), pageable, apartments.getTotalElements());
    }
}
