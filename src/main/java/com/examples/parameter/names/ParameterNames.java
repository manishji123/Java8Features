package com.examples.parameter.names;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ParameterNames {

    public static void main(final String[] args) throws NoSuchMethodException {
        Method method = Parameter.class.getMethod("main", String[].class);
        /*for (final Parameter parameter : method.getParameters()) {
            System.out.println("Parameter: " + parameter.getName());
        }*/
        Arrays.stream(method.getParameters()).map(p->p.getName()).forEach(System.out::println);
    }
}
