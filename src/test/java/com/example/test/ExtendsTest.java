package com.example.test;

public class ExtendsTest implements G {
    @Override
    public <A extends Exception> String m() throws A {
        return null;
    }
}
