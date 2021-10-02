package com.manbalboy.jpa.bookmanaber.domain;

import com.manbalboy.jpa.bookmanaber.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

    private Gender gender;


    // DB에 접근하지 않은 값을 할떄
    @Transient
    private String testData;
}
