package com.manbalboy.jpa.bookmanaber.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@EntityListeners(value = {UserEntityListener.class, AuditingEntityListener.class})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    // DB에 접근하지 않은 값을 할떄
    @Transient
    private String testData;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        System.out.println(">>>>>>>>> prePersist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println(">>>>>>>> postPersist");
    }


    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
        System.out.println(">>>>>>>>>>> preUpdate");
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println(">>>>>>>>>>> postUpdate");
    }

    @PreRemove
    public void preRemove() {
        System.out.println(">>>>>>>>>>> preRemove");
    }

    @PostRemove
    public void postRemove() {
        System.out.println(">>>>>>>>>>> postRemove");
    }

    @PostLoad
    public void postLoad() {
        System.out.println(">>>>>>>>>>> postLoad");
    }

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> addresses;

}
