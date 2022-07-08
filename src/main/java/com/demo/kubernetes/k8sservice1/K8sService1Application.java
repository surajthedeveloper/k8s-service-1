package com.demo.kubernetes.k8sservice1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class K8sService1Application {
    @Value("${HOSTNAME:service1}")
    private String hostname;

    @Value("${MESSAGE:}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(K8sService1Application.class, args);
    }

    @GetMapping("/config")
    public Config helloWorld() {
        return new Config(hostname,message);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {
        private String hostname;
        private String message;
    }
}
