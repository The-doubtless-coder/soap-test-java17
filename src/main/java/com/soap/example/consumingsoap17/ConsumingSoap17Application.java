package com.soap.example.consumingsoap17;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/soap/v1")
@RequiredArgsConstructor
public class ConsumingSoap17Application {

private final Client client;

    public static void main(String[] args) {
        SpringApplication.run(ConsumingSoap17Application.class, args);
    }
@RequestMapping(value = "/test", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, params = {"one", "two"})
    public ResponseEntity<Object> getValue(@RequestParam(required = true, value = "one") String one,
                                           @RequestParam(required = true, value = "two") String two){
        return ResponseEntity.ok(client.getValue(one, two));
    }
}
