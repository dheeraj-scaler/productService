package com.scaler.demoproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class SampleTest {

    @Test
    void testAddMethod() {
        int x = 1+2;
        int y = 2*4;

//        assert x == 2; //(if x == 2, then test case pass else fail)

        assertEquals(3,x);
        assertEquals(7,y);
    }
}

/*
A test case is nothing but a method

AAA
Arrange : Create the input params
Act : Call the required function
Assert : Check the function responses wrt expected value
 */
