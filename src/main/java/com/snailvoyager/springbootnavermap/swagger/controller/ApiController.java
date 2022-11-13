package com.snailvoyager.springbootnavermap.swagger.controller;

import com.snailvoyager.springbootnavermap.swagger.dto.User;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello(@RequestParam String world) {
        return world;
    }

    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user;
    }

    @PostMapping("/response")
    public ResponseEntity<User> response(@RequestBody User user) {        //ResponseEntity로 응답에 명확한 데이터 전달
        return ResponseEntity
                .status(HttpStatus.CREATED)      //201
                .body(user);
    }

}
