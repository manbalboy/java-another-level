package com.manbalboy.jpa.bookmanaber.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @ManyToMany
    @Builder.Default
    @ToString.Exclude
    private List<Book> books = new ArrayList<>();


    public void addBooks(Book... book) {
        Collections.addAll(this.books, book);
    }


}
