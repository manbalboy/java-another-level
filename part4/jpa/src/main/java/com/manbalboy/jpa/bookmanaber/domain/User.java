package com.manbalboy.jpa.bookmanaber.domain;

import com.manbalboy.jpa.bookmanaber.domain.code.Gender;
import com.manbalboy.jpa.bookmanaber.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;

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

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;


    // DB에 접근하지 않은 값을 할떄
    @Transient
    private String testData;


//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//        System.out.println(">>>>>>>>> prePersist");
//    }
//
//    @PostPersist
//    public void postPersist() {
//        System.out.println(">>>>>>>> postPersist");
//    }
//
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//        System.out.println(">>>>>>>>>>> preUpdate");
//    }
//
//    @PostUpdate
//    public void postUpdate() {
//        System.out.println(">>>>>>>>>>> postUpdate");
//    }
//
//    @PreRemove
//    public void preRemove() {
//        System.out.println(">>>>>>>>>>> preRemove");
//    }
//
//    @PostRemove
//    public void postRemove() {
//        System.out.println(">>>>>>>>>>> postRemove");
//    }
//
//    @PostLoad
//    public void postLoad() {
//        System.out.println(">>>>>>>>>>> postLoad");
//    }

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> addresses;

}
