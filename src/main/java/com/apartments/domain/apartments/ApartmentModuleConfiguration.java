package com.apartments.domain.apartments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
class ApartmentModuleConfiguration {

    @Bean
    ApartmentFacade apartmentFacade(ApartmentRepository repository) {
        return new ApartmentFacade(repository);
    }

    ApartmentFacade apartmentFacade(ConcurrentHashMap<Long, ApartmentEntity> db) {
        ApartmentInMemoryRepository repository = new ApartmentInMemoryRepository(db);
        return new ApartmentFacade(repository);
    }
}
