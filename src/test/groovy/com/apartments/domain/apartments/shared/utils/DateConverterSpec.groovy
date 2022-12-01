package com.apartments.domain.apartments.shared.utils

import com.apartments.shared.utils.DateConverter
import spock.lang.Specification

import java.time.ZoneId
import java.time.ZonedDateTime

class DateConverterSpec extends Specification {

    def 'Should convert ZonedDateTime to PL format'() {
        given:
        def dateToConvert = ZonedDateTime.of(1997, 1, 4, 0, 0, 0, 0, ZoneId.systemDefault())

        when:
        def convertedDate = DateConverter.convert(dateToConvert)

        then:
        convertedDate == '4 stycznia 1997'
    }
}
