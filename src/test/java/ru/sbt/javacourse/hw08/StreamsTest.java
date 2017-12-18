package ru.sbt.javacourse.hw08;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class StreamsTest {
    @Test
    public void test01() throws Exception {
//        List<Integer> list = Arrays.asList(3, 5, 7, 9, 11);
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
        assertEquals("Mr. Bbb", map.get("Mr. Bbb").getName());
        assertEquals(32, map.get("Mr. Bbb").getAge());
        assertEquals("Mr. Ccc", map.get("Mr. Ccc").getName());
        assertEquals(43, map.get("Mr. Ccc").getAge());
    }

    @Test
    public void test02() {

        List<Postman> list = Arrays.asList(
                new Postman("Aaa", 11, "Micro", 100, "New Moscow"),
                new Postman("Bbb", 22, "Macro", 200, "Moscow"),
                new Pochtaclerk("Ccc", 33, "Micro", 150, "Khimki", "14"));

        Map<String, Person> map = null;
//        Map<Integer, String> map = null;

        Streams.of(list).filter(p -> p.getSalary() > 100);
        map = Streams.of(list)
                .transform(p -> new Employee(p.getName(), p.getAge(), p.getCompany(), p.getSalary()))
                .toMap(e -> e.getName(), e -> e);

//        Streams.of(list).transform(e -> e.getAge()).toMap(e -> e, e -> e.toString());
//        map = Streams.of(list).transform(e -> e.getAge()).toMap(e -> e, e -> e.toString());
        System.out.println(map.toString());
    }
}
