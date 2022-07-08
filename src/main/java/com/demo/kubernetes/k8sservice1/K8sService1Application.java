package com.demo.kubernetes.k8sservice1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class K8sService1Application {
    @Value("${HOSTNAME:default}")
    private String hostname;

    public static void main(String[] args) {
        SpringApplication.run(K8sService1Application.class, args);
    }

    @GetMapping("/hostname")
    public String helloWorld() {
        return hostname;
    }
}
