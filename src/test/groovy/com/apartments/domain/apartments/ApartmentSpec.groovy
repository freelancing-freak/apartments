package com.apartments.domain.apartments

import org.springframework.data.domain.Pageable
import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap

class ApartmentSpec extends Specification {

    private ApartmentFacade apartmentFacade

    private ConcurrentHashMap<Long, ApartmentEntity> db

    def setup() {
        db = new ConcurrentHashMap<>()
        apartmentFacade = new ApartmentModuleConfiguration().apartmentFacade(db)
    }

    def 'Should save apartment'() {
        when:
        apartmentFacade.save(new Apartment('apartment',
                'some desc',
                'barcelona',
                'some src',
                56,
                2,
                '55500',
                'img1',
                Set.of('img1', 'img2')))

        then:
        db.size() == 1
    }

    def 'Should find all apartments'() {
        given:
        apartmentFacade.save(new Apartment('apartment',
                'some desc',
                'barcelona',
                'some src',
                56,
                2,
                '55500',
                'img1',
                Set.of('img1', 'img2')))

        when:
        def apartments = apartmentFacade.findAll(Pageable.unpaged())

        then:
        !apartments.isEmpty() && apartments.size == 1
    }
}
