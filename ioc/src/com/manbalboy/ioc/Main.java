package com.manbalboy.ioc;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String url = "www.naver.com/books/it?page=10&size=20&name=spirng-boot";

        //Base64 Encoder
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);


    }
}
