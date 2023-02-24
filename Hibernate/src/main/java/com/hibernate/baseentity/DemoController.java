package com.hibernate.baseentity;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/create-employee")
    public ResponseEntity<Void> createEmployee(@RequestBody CreateEmployeeRequest request) {
        demoService.createEmployee(request.getName());

        return ResponseEntity.ok().build();
    }
}
