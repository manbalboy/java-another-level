package com.manbalboy.jpa.bookmanaber.domain;

import com.manbalboy.jpa.bookmanaber.domain.code.Gender;
import com.manbalboy.jpa.bookmanaber.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@EntityListeners(value = {UserEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories;

    // DB에 접근하지 않은 값을 할떄
    @Transient
    private String testData;

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews;

}
