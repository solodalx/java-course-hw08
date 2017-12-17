package ru.sbt.javacourse.hw08;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamsTest {
    @Test
    public void test01() throws Exception {

        List<Integer> list = Arrays.asList(3, 5, 7, 9, 11);

        List<Person> persons = Arrays.asList(
                new Person("Aaa", 11),
                new Person("Bbb", 22),
                new Person("Ccc", 33));

        Map<String, Person> map = null;

        map = Streams.of(persons)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person("Mr. " + p.getName(), p.getAge() + 10))
                .toMap(p -> p.getName(), p -> p);

        for (String s : map.keySet()) {
            Person p = map.get(s);
            System.out.println(p.getName() + " " + p.getAge());
        }


    }
}