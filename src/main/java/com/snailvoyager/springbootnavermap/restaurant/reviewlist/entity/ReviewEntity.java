package com.snailvoyager.springbootnavermap.restaurant.reviewlist.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "REVIEW_LIST")
@SequenceGenerator(name="REVIEW_SEQ_GEN", sequenceName = "REVIEW_SEQ", initialValue = 1, allocationSize = 1)
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REVIEW_SEQ_GEN")
    private Long id;

    private int wishListId;
    private String writer;
    private String comment;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
