package com.manbalboy.restaurant.wishlist.entity;

import com.manbalboy.restaurant.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishListEntity extends MemoryDbEntity {
    private String title;                       //음식명, 장소명
    private String category;                    // 카테고리
    private String address;                     // 주소
    private String roadAddress;                 // 도로명
    private String homePageLink;                // 홈페이지 주소
    private String imageLink;                   // 이미지 주소
    private boolean isVisit;                    // 방문여부
    private int visitCount;                     // 방문카운트
    private LocalDateTime lastVisitDate;        //마지막 방문일자
}
