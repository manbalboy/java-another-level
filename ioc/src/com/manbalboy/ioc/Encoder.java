package com.manbalboy.ioc;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encoder {
    private IEncoder iEncoder;

    public Encoder(IEncoder encoder) {
        this.iEncoder = encoder;
    }


    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes(StandardCharsets.UTF_8));
    }
}
