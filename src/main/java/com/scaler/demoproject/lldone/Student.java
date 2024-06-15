package com.scaler.demoproject.lldone;

import org.springframework.data.jpa.repository.query.JSqlParserUtils;

public class Student {
    public int age;
    public String name;
    public String batch;

    public void pauseCourse() {
        System.out.println("Course is paused");
    }

    public void attendClass() {
        // some behaviour over here
    }
}
