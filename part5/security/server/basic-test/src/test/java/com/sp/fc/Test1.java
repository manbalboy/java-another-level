package com.sp.fc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Test1 {

    @DisplayName("1. 테스트 1")
    @Test
    void test_1() {
        Assertions.assertEquals("test", "test");
    }

}