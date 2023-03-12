package com.zict.lianxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        Set<String> collect = list.stream().filter(p -> p.equals("3")).collect(Collectors.toSet());
        collect.forEach(p-> System.out.println("p："+p));
    }
}
