package com.apartments.domain.apartments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
class ApartmentModuleConfiguration {

    @Bean
    ApartmentFacade apartmentFacade(ApartmentRepository repository) {
        ApartmentValidator validator = new ApartmentValidator();
        return new ApartmentFacade(repository, validator);
    }

    ApartmentFacade apartmentFacade(ConcurrentHashMap<String, ApartmentEntity> db) {
        ApartmentValidator validator = new ApartmentValidator();
        ApartmentInMemoryRepository repository = new ApartmentInMemoryRepository(db);
        return new ApartmentFacade(repository, validator);
    }
}
