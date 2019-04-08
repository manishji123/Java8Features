package com.examples.interfaces.functional;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}
