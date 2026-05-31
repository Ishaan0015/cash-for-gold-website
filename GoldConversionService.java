// Sample Java Spring Boot controller showing a conversion endpoint
// This is a demo snippet only; not wired into the static site.

package com.cashforgold.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldConversionService {

    public static class ConvertRequest {
        public double grams;
        public double perGramRate;
        public double purity; // 1.0 = 24K
    }

    public static class ConvertResponse {
        public double actualAmount;
        public String currency = "INR";
    }

    @PostMapping("/api/convert")
    public ConvertResponse convert(@RequestBody ConvertRequest req) {
        ConvertResponse res = new ConvertResponse();
        double value = req.grams * req.perGramRate * req.purity;
        res.actualAmount = Math.round(value * 100.0) / 100.0;
        return res;
    }
}
