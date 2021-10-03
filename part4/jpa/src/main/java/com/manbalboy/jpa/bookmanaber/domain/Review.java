package com.manbalboy.jpa.bookmanaber.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private float score;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;
}
