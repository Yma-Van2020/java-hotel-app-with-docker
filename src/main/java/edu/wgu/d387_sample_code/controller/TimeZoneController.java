package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/time")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeZoneController {

    @GetMapping("/convert")
    public String[] convertTimeZones() {
        return D387SampleCodeApplication.convertAndDisplayTimeZones(LocalDateTime.now());
    }
}