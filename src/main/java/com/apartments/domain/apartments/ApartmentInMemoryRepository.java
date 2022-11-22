package com.apartments.domain.apartments;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
public class ApartmentInMemoryRepository implements ApartmentRepository {

    private final ConcurrentHashMap<String, ApartmentEntity> db;

    @Override
    public void save(ApartmentEntity entity) {
        db.put(entity.getName(), entity);
    }

    @Override
    public Page<ApartmentEntity> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(db.values()), pageable, db.values().size());
    }

    @Override
    public List<ApartmentEntity> search(String filterText) {
        return db.values()
                .stream()
                .filter(apartment -> {
                    boolean filterByName = apartment.getName().toLowerCase().contains(filterText.toLowerCase());
                    boolean filterByLocation = apartment.getLocation().toLowerCase().contains(filterText.toLowerCase());
                    boolean filterByPrice = apartment.getPrice().toLowerCase().contains(filterText.toLowerCase());
                    return filterByName || filterByLocation || filterByPrice;
                })
                .toList();
    }

    @Override
    public List<ApartmentEntity> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public Optional<ApartmentEntity> findById(long id) {
        return db.values()
                .stream()
                .filter(apartment -> apartment.getId() == id)
                .findFirst();
    }

    @Override
    public void deleteById(long id) {
        db.values().removeIf(apartment -> apartment.getId() == id);
    }
}
