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

    private final ConcurrentHashMap<Long, ApartmentEntity> db;

    private static long idCounter = 0;

    @Override
    public void save(ApartmentEntity entity) {
        entity.setId(++idCounter);
        db.put(idCounter, entity);
    }

    @Override
    public Page<ApartmentEntity> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(db.values()), pageable, db.values().size());
    }

    @Override
    public List<ApartmentEntity> findAll() {
        return null;
    }

    @Override
    public Optional<ApartmentEntity> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }
}
