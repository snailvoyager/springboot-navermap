package com.snailvoyager.springbootnavermap.restaurant.wishlist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "WishList")
@SequenceGenerator(name="RES_SEQ_GEN", sequenceName = "RES_SEQ", initialValue = 1, allocationSize = 1)
public class WishListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_SEQ_GEN")
    private Integer index;

    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String homePageLink;
    private String imageLink;
    private boolean isVisit;
    private int visitCount;
    @UpdateTimestamp
    private LocalDateTime lastVisitDate;
    private int sameFieldName;
}
