package com.example.springdiioc;

import java.io.UnsupportedEncodingException;

public interface IEncoder {
    String encoder(String message) throws UnsupportedEncodingException;
}
