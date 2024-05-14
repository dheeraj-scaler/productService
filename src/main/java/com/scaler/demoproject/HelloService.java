package com.scaler.demoproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World Dheeraj";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getSpecificUser(@PathVariable("id") String id) {
        return "I am going to update the user " + id;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateSpecificUser(@PathVariable("id") String id) {
        return "I am going to update the user " + id;
    }
}
