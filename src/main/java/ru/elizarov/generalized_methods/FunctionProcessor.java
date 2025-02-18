package ru.elizarov.generalized_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionProcessor {

    public static void fillList(List<? super Integer> list) {
        list.clear();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

    public static <T, P> List<P> applyFunction(List<T> values, Function<T, P> function) {
        return values.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static <T> T reduce(List<T> values, T identity, BinaryOperator<T> accumulator) {
        return values.stream()
                .reduce(identity, accumulator);
    }

    public static <T, P> P collect(List<T> source, Supplier<P> collectionFactory, Function<List<T>, P> collector) {
        return collector.apply(source);
    }
}