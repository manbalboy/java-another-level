package com.manbalboy.springjunittest.controller;

import com.manbalboy.springjunittest.component.ICalculator;
import com.manbalboy.springjunittest.dto.Req;
import com.manbalboy.springjunittest.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {
    private final ICalculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        this.calculator.init();
        return this.calculator.sum(x, y);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        this.calculator.init();
        return this.calculator.minus(x, y);
    }

    @PostMapping("/minus/post")
    public Res postMinus(@RequestBody Req req) {
        this.calculator.init();
        int result = this.calculator.minus(req.getX(), req.getX());


        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());

        return res;
    }
}
