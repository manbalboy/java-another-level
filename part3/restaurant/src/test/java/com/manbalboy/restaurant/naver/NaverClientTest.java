package com.manbalboy.restaurant.naver;

import com.manbalboy.restaurant.naver.dto.SearchImageReq;
import com.manbalboy.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NaverClientTest {
    @Autowired
    NaverClient naverClient;

    @Test
    void localSearchTest() {
        var search = new SearchLocalReq();
        search.setQuery("엄지네");

        var result = naverClient.searchLocal(search);

        System.out.println(result);
    }


    @Test
    void imageSearchTest() {
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.searchImage(search);

        System.out.println(result);
    }
}