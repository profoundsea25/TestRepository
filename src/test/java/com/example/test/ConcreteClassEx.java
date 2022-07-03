package com.example.test;

import java.util.function.Function;

public class ConcreteClassEx implements Function<String, Integer> {

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
