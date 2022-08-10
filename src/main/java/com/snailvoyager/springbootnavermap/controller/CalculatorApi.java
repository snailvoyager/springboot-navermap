package com.snailvoyager.springbootnavermap.controller;

import com.snailvoyager.springbootnavermap.component.Calculator;
import com.snailvoyager.springbootnavermap.dto.Req;
import com.snailvoyager.springbootnavermap.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
@RequiredArgsConstructor
public class CalculatorApi {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req) {
        int result = calculator.minus(req.getX(), req.getY());
        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;
    }
}
