package com.example.springdiioc;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class UrlEncoder implements IEncoder {


    @Override
    public String encoder(String message) throws UnsupportedEncodingException {
        return URLEncoder.encode(message, "UTF-8");
    }
}
