package com.jaydev.ecommerce.Health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthCheck {

    @GetMapping("/health")
    public String Healthverify()
    {
        return "Health is Okay";
    }

}
