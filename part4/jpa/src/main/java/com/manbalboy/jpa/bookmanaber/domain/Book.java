package com.manbalboy.jpa.bookmanaber.domain;

import com.manbalboy.jpa.bookmanaber.domain.listener.Auditable;
import com.manbalboy.jpa.bookmanaber.domain.listener.MyEntityListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(value = MyEntityListener.class)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    
}
