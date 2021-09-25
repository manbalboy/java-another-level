package com.manbalboy.restaurant.naver;

import com.manbalboy.restaurant.naver.dto.SearchImageReq;
import com.manbalboy.restaurant.naver.dto.SearchImageRes;
import com.manbalboy.restaurant.naver.dto.SearchLocalReq;
import com.manbalboy.restaurant.naver.dto.SearchLocalRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpMethod.GET;

@Component
public class NaverClient {
    @Value("${naver.client.id}")
    private String naverClientId;

    @Value("${naver.client.secret}")
    private String naverClientSecret;

    @Value("${naver.url.search.local}")
    private String naverLocalSearchUrl;

    @Value("${naver.url.search.image}")
    private String naverImageSearchUrl;


    public SearchLocalRes searchLocal(SearchLocalReq searchLocalReq) {
        var uri = UriComponentsBuilder
                .fromUriString(naverLocalSearchUrl)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();


        var header = new HttpHeaders();
        header.set("X-Naver-Client-Id", naverClientId);
        header.set("X-Naver-Client-Secret", naverClientSecret);

        var httpEntity = new HttpEntity<>(header);
        var responseType = new ParameterizedTypeReference<SearchLocalRes>() {
        };

        var responseEntity
                = new RestTemplate().exchange(uri, GET, httpEntity, responseType);


        return responseEntity.getBody();

    }

    public SearchImageRes searchImage(SearchImageReq searchImageReq) {
        var uri = UriComponentsBuilder
                .fromUriString(naverImageSearchUrl)
                .queryParams(searchImageReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();


        var header = new HttpHeaders();
        header.set("X-Naver-Client-Id", naverClientId);
        header.set("X-Naver-Client-Secret", naverClientSecret);

        var httpEntity = new HttpEntity<>(header);
        var responseType = new ParameterizedTypeReference<SearchImageRes>() {
        };

        var responseEntity
                = new RestTemplate().exchange(uri, GET, httpEntity, responseType);


        return responseEntity.getBody();
    }

}
