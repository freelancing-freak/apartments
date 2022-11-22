package com.apartments.domain.apartments;

import com.apartments.shared.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "apartment", schema = "public")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentEntity extends BaseEntity {

    private String name;
    private String description;
    private String location;
    private String locationSrc;
    private int measurement;
    private int numberOfRooms;
    private String price;
    private String mainImage;
    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private List<String> images;

    public void update(Apartment apartment) {
        this.name = apartment.getName();
        this.description = apartment.getDescription();
        this.location = apartment.getLocation();
        this.locationSrc = apartment.getLocationSrc();
        this.measurement = apartment.getMeasurement();
        this.numberOfRooms = apartment.getNumberOfRooms();
        this.price = apartment.getPrice();
        this.mainImage = apartment.getMainImage();
        this.images = apartment.getImages();
    }

    public Apartment from() {
        Apartment apartment = new Apartment();
        apartment.setId(this.getId());
        apartment.setCreatedDate(this.getCreatedDate().toLocalDate().toString());
        apartment.setName(this.name);
        apartment.setDescription(this.description);
        apartment.setLocation(this.location);
        apartment.setLocationSrc(this.locationSrc);
        apartment.setMeasurement(this.measurement);
        apartment.setNumberOfRooms(this.numberOfRooms);
        apartment.setPrice(this.price);
        apartment.setMainImage(this.mainImage);
        apartment.setImages(this.images);
        return apartment;
    }
}
