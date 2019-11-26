package com.jonas.one.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-alpha")
public interface DeltaService {
    @GetMapping( value = "/")
    String getHealth();
}
