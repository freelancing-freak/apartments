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
    }

    public Apartment from() {
        Apartment apartment = new Apartment();
        apartment.setId(this.getId());
        apartment.setCreatedDate(this.getCreatedDate());
        apartment.setName(this.name);
        apartment.setDescription(this.description);
        apartment.setLocation(this.location);
        apartment.setLocationSrc(this.locationSrc);
        apartment.setMeasurement(this.measurement);
        apartment.setNumberOfRooms(this.numberOfRooms);
        apartment.setPrice(this.price);
        apartment.setMainImage(this.mainImage);
        setImages(apartment);
        return apartment;
    }

    private void setImages(Apartment apartment) {
        if (isIndexExists(0)) apartment.setImage1(this.images.get(0));
        if (isIndexExists(1)) apartment.setImage2(this.images.get(1));
        if (isIndexExists(2)) apartment.setImage3(this.images.get(2));
        if (isIndexExists(3)) apartment.setImage4(this.images.get(3));
        if (isIndexExists(4)) apartment.setImage5(this.images.get(4));
        if (isIndexExists(5)) apartment.setImage6(this.images.get(5));
        if (isIndexExists(6)) apartment.setImage7(this.images.get(6));
        if (isIndexExists(7)) apartment.setImage8(this.images.get(7));
        if (isIndexExists(8)) apartment.setImage9(this.images.get(8));
    }

    private boolean isIndexExists(int index) {
        if (this.images == null || this.images.isEmpty()) {
            return false;
        }
        return this.images.size() > index;
    }
}
