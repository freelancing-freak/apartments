package com.apartments.domain.apartments;

import com.apartments.shared.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

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
    private Set<String> images;
}
