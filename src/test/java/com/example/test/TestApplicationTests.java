package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class TestApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> t1 = map(Arrays.asList("lambdas", "in", "action"), (String s) -> s.length());
        System.out.println("t1 : " + t1);

        ConcreteClassEx concreteClassEx = new ConcreteClassEx();
        List<Integer> t2 = map(Arrays.asList("lambdas", "in", "action"), concreteClassEx);
        System.out.println("t2 : " + t2);

    }

    public <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    @Test
    void test1() {
        System.out.println(((Function<Number, String>) n -> n.getNumber()).getClass());

        List<Number> numberList = Arrays.asList(Number.One, Number.Two, null);
        numberList.stream().map(n -> n.getNumber()).forEach(System.out::println);
    }

    enum Number {
        One("1"), Two("2"), Three("3");

        private final String number;

        Number(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }
    }

}
