package com.example.springdiioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class Encoder {
    private IEncoder iEncoder;

    public Encoder(@Qualifier("base64Encoder") IEncoder encoder) {
        this.iEncoder = encoder;
    }


    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;

    }


    public String encode(String message) throws UnsupportedEncodingException {
        return iEncoder.encoder(message);
    }
}
