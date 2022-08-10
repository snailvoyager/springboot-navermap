package com.snailvoyager.springbootnavermap.controller;

import com.snailvoyager.springbootnavermap.component.Calculator;
import com.snailvoyager.springbootnavermap.dto.Req;
import com.snailvoyager.springbootnavermap.dto.Res;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api
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

    @GetMapping("/plus/{x}")
    public int plus(@ApiParam(value = "x값", defaultValue = "20") @PathVariable int x,
                    @ApiParam(value = "y값", defaultValue = "5") @RequestParam int y) {
        return x+y;
    }

    @ApiImplicitParams(
            {@ApiImplicitParam(name = "x", value = "x값", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "y", value = "y값", required = true, dataType = "int")}
    )
    @GetMapping("/plus2/{x}")
    public int plus2(@PathVariable int x, @RequestParam int y) {
        return x+y;
    }

    @ApiResponse(code = 502, message = "x - y < 0")
    @ApiOperation(value = "x - y 결과 값")
    @GetMapping("/minus")
    public Res minus2(Req req) {
        int result = calculator.minus(req.getX(), req.getY());
        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;
    }

}
