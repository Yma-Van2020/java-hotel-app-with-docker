package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.D387SampleCodeApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
@CrossOrigin(origins = "http://localhost:4200")
public class WelcomeController {

    @GetMapping("/en")
    public String getEnglishWelcomeMessage() {
        return D387SampleCodeApplication.displayWelcomeMessage("welcome_en_US.properties");
    }

    @GetMapping("/fr")
    public String getFrenchWelcomeMessage() {
        return D387SampleCodeApplication.displayWelcomeMessage("welcome_fr_CA.properties");
    }
}