package com.apartments.domain.apartments;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class ApartmentFacade {

    private final ApartmentRepository repository;

    public void save(Apartment apartment) {
        repository.save(ApartmentEntityFactory.create(apartment));
    }

    public Page<ApartmentVO> findAll(Pageable pageable) {
        final var apartments = repository.findAll(pageable);
        return new PageImpl<>(apartments
                .stream()
                .map(ApartmentVO::from)
                .sorted(Comparator.comparing(ApartmentVO::id))
                .toList(), pageable, apartments.getTotalElements());
    }

    public List<Apartment> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return repository.findAll()
                    .stream()
                    .map(ApartmentEntity::from)
                    .sorted(Comparator.comparing(Apartment::getId))
                    .toList();
        }
        return repository.search(filterText)
                .stream()
                .map(ApartmentEntity::from)
                .sorted(Comparator.comparing(Apartment::getId))
                .toList();
    }

    @Transactional
    public void update(Apartment apartment) {
        repository.findById(apartment.getId()).ifPresent(foundApartment -> foundApartment.update(apartment));
    }

    @Transactional
    public void delete(Apartment apartment) {
        repository.deleteById(apartment.getId());
    }
}
