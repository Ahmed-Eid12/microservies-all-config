package com.ahmedeid.departmentservice.controller;

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
public class DeptServiceController {

    private final Tracer tracer;

    @GetMapping("/deptServices")
    public ResponseEntity<Info> getDeptServices() {
        return ResponseEntity.ok(new Info("Department Services",
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