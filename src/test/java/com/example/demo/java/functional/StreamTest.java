package com.example.demo.java.functional;

import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;

public class StreamTest {

    @Test
    void createStreamTest() {
        Stream<String> streamEmpty = Stream.empty();

        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();

        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);

        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
    }

    @Test
    void streamPipelineTest() {
        String result = IntStream.range(1, 100) //stream creation
                .filter(i -> i % 2 == 0)        //intermediate operation
                .mapToObj(String::valueOf)      //intermediate operation
                .collect(Collectors.joining()); //stream termination


        Set<Integer> books = Stream.of(new User())
                .filter(User::isActive)
                .filter(u -> u.getAge() > 25)
                .map(User::getBooks)
                .filter(CollectionUtils::isNotEmpty)
                .flatMap(Collection::stream)
                .map(User.Book::getId)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Test
    void reduceTest() {
        String joined = IntStream.range(0, 100).boxed()
                .reduce("", (res, i) -> res + i.toString(), (a, b) -> a + b);

        System.out.println(joined);
    }

    @Test
    void collectTest() {
        Map<Boolean, List<Integer>> collect = IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        Map<Integer, Set<String>> collectedToStringSet = IntStream.range(0, 100).boxed()
                .collect(Collectors.groupingBy(i -> i % 3, mapping(String::valueOf, Collectors.toSet())));

        List<Integer> collected = IntStream.range(0, 100)
                .boxed()
                .collect(
                        () -> new ArrayList<>(),
                        (list, el) -> list.add(el),
                        (list1, list2) -> list1.addAll(list2));
    }

    public class User {
        int age;
        boolean active;
        List<Book> books;

        public class Book {
            int id;

            public int getId() {
                return id;
            }
        }

        public int getAge() {
            return age;
        }

        public boolean isActive() {
            return active;
        }

        public List<Book> getBooks() {
            return books;
        }
    }


}
