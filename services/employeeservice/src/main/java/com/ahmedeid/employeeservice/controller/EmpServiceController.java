package com.ahmedeid.employeeservice.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmpServiceController {

    private final Tracer tracer;

    @GetMapping("/empservices")
    public ResponseEntity<Info> getEmpServices() {
        return ResponseEntity.ok(new Info("Employee Services",
                tracer.currentSpan().context().traceId(),
                tracer.currentSpan().context().spanId()));
    }
}

@Getter
@Setter
@AllArgsConstructor
class Info {
    private String serviceDescription;
    private String traceId;
    private String spanId;
}
