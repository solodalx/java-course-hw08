package ru.sbt.javacourse.hw08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


public class Streams<T> {

    private final List<? extends T> list;

    private Streams(List<? extends T> list) {
        this.list = list;
    }

    public static<T> Streams<T> of(List<? extends T> list) {
        return new Streams<>(list);
    }

    Streams<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t: list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return new Streams<>(result);
    }

    public<K> Streams<K> transform(Function<? super T, ? extends K> function) {
        List<K> result = new ArrayList<>();
        for (T t: list) {
            result.add(function.apply(t));
        }
        return new Streams<>(result);
    }

    public<K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<>();
        for (T t: list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }
}



