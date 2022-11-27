package com.apartments.domain.apartments

import org.springframework.data.domain.Pageable
import spock.lang.Specification

import java.util.concurrent.ConcurrentHashMap

class ApartmentSpec extends Specification implements ApartmentFixture {

    private ApartmentFacade apartmentFacade

    private ConcurrentHashMap<String, ApartmentEntity> db

    def setup() {
        db = new ConcurrentHashMap<>()
        apartmentFacade = new ApartmentModuleConfiguration().apartmentFacade(db)
    }

    def 'Should save apartment'() {
        given:
        def name = 'Złota 44'
        def apartment = create(name)

        when:
        apartmentFacade.save(apartment)

        then:
        db.get(name) != null
    }

    def 'Should find all apartments as pageable'() {
        given:
        apartmentFacade.save(create())

        when:
        def apartments = apartmentFacade.findAll(Pageable.unpaged())

        then:
        !apartments.isEmpty() && apartments.size() == 1
    }

    def 'Should find all apartments'() {
        given:
        apartmentFacade.save(create())

        when:
        def apartments = apartmentFacade.findAll("")

        then:
        !apartments.isEmpty() && apartments.size() == 1
    }

    def 'Should find all apartments by filter text'() {
        given:
        def filterText = 'Złota'
        def apartment1 = create(filterText + ' 44')
        def apartment2 = create(filterText + ' 22')
        def apartment3 = create('Barcelona')

        apartmentFacade.save(apartment1)
        apartmentFacade.save(apartment2)
        apartmentFacade.save(apartment3)

        when:
        def apartments = apartmentFacade.findAll(filterText)

        then:
        !apartments.isEmpty() && apartments.size() == 2
    }

    def 'Should find apartment by id'() {
        given:
        def id = 0L
        def apartment = create('Złota 44', id)

        apartmentFacade.save(apartment)

        when:
        def foundApartment = apartmentFacade.findById(apartment.id)

        then:
        foundApartment != null
    }

    def 'Should throw exception when cannot find apartment by id'() {
        when:
        apartmentFacade.findById(-1L)

        then: 'exception is thrown'
        RuntimeException exception = thrown()
        exception.message == 'Cannot find apartment by id'
    }

    def 'Should update apartment'() {
        given:
        def name = 'Złota 44'
        def id = 0L
        def apartment = create(name, id)

        apartmentFacade.save(apartment)

        and:
        def newDesc = 'new desc'
        def newLocation = 'new location'
        def newLocationSrc = 'new location src'
        def newMeasurement = 1
        def newNumberOfRooms = 1
        def newPrice = 'new price'
        def newMainImage = 'new url to host image'
        def newImage1 = 'new url to host image1'
        def newImage2 = 'new url to host image2'
        def newImages = List.of(newImage1, newImage2)

        def apartmentToUpdate = create(name,
                id,
                newDesc,
                newLocation,
                newLocationSrc,
                newMeasurement,
                newNumberOfRooms,
                newPrice,
                newMainImage,
                newImages)

        when:
        apartmentFacade.update(apartmentToUpdate)

        then:
        def apartmentAfterUpdate = db.get(name)

        apartmentAfterUpdate.name == name
        apartmentAfterUpdate.description == newDesc
        apartmentAfterUpdate.location == newLocation
        apartmentAfterUpdate.locationSrc == newLocationSrc
        apartmentAfterUpdate.measurement == newMeasurement
        apartmentAfterUpdate.numberOfRooms == newNumberOfRooms
        apartmentAfterUpdate.price == newPrice
        apartmentAfterUpdate.mainImage == newMainImage
        apartmentAfterUpdate.images.get(0) == newImage1
        apartmentAfterUpdate.images.get(1) == newImage2
    }

    def 'Should delete apartment by id'() {
        given:
        def name = 'Złota 44'
        def id = 0L
        create(name, id)

        when:
        db.get(name) != null

        and:
        apartmentFacade.deleteById(id)

        then:
        db.get(name) == null
    }
}
