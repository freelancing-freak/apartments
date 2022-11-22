package com.apartments.domain.apartments

import java.time.ZonedDateTime

trait ApartmentFixture {

    Apartment create(def name = 'Złota 44',
                     def id = new Random().nextLong(),
                     def description = 'desc',
                     def location = 'barcelona',
                     def locationSrc = 'barcelona google maps src',
                     def measurement = 56,
                     def numberOfRooms = 3,
                     def price = '56500',
                     def mainImage = 'url to image',
                     def images = List.of('url to image1', 'url to image2')) {
        Apartment apartment = new Apartment()
        apartment.id = id
        apartment.createdDate = ZonedDateTime.now()
        apartment.name = name
        apartment.description = description
        apartment.location = location
        apartment.locationSrc = locationSrc
        apartment.measurement = measurement
        apartment.numberOfRooms = numberOfRooms
        apartment.price = price
        apartment.mainImage = mainImage
        apartment.images = images
        return apartment
    }
}
