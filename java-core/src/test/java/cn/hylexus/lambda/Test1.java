package cn.hylexus.lambda;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * @author hylexus
 * createdAt 2017/12/17
 **/
public class Test1 {


    private final List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5);

    @Test
    public void testSumByReduce() {

        Integer sum = numbers.stream().reduce(0, (i, j) -> i + j);
        Assert.assertNotNull(sum);
        Assert.assertTrue(sum.equals(15));

        sum = numbers.stream().reduce(0, Integer::sum);
        Assert.assertNotNull(sum);
        Assert.assertTrue(sum.equals(15));
    }

    @Test
    public void testMaxByReduce() {
        numbers.stream()
                .reduce((i, j) -> i > j ? i : j)
                .ifPresent(System.out::println);

        numbers.stream().reduce(Math::max).ifPresent(System.out::println);
    }

    @Test
    public void testGetLengthOfStreamByReduce() {
        Integer length = numbers.stream().map(i -> 1).reduce(0, Integer::sum);
        System.out.println(length);
    }

    @Test
    public void testIterate() {
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
                .limit(10)
                .map(arr -> arr[0])
                .forEach(System.out::println);
    }

    static class User {
        private Integer id;
        private String name;
        private Integer gender;
        private Integer age;

        User(Integer id, String name, Integer gender, Integer age) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }
    }

    List<User> users = Lists.newArrayList(
            new User(1, "java", 1, 25),
            new User(2, "C", 1, 22),
            new User(3, "scala", 0, 23),
            new User(4, "C++", 0, 11),
            new User(5, "Spark", 1, 25),
            new User(6, "PHP", 0, 45),
            new User(7, "Python", 1, 89),
            new User(8, "JavaScript", 0, 110),
            new User(9, "C#", 1, 33)
    );

    BiConsumer<Integer, List<User>> userInfoPrinter = (k, v) -> {
        System.out.println(k);
        v.forEach(u -> System.out.println("\t" + u));
    };

    @Test
    public void test1() {
        users.stream()
                .collect(Collectors.groupingBy(User::getGender))
                .forEach((k, v) -> {
                    System.out.println(k);
                    v.forEach(u -> System.out.println("\t" + u));
                });

        Map<Integer, Optional<User>> maxAge = users.stream()
                .collect(
                        Collectors.groupingBy(
                                User::getGender,
                                Collectors.maxBy(Comparator
                                        .comparing(User::getAge)
                                        .thenComparing(User::getId)
                                )
                        )
                );

        maxAge.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("\t" + v);
        });

        Map<Integer, User> maxAge1 = users.stream()
                .collect(
                        groupingBy(
                                User::getGender,
                                collectingAndThen(maxBy(comparing(User::getAge)), Optional::get)
                        )
                );
        maxAge1.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("\t" + v);
        });
    }

    @Test
    public void test2() {
        List<Integer> list = IntStream.rangeClosed(1, 5).boxed().collect(new ListCollector<>());
        System.out.println(list);
    }

    static class ListCollector<T> implements Collector<T, List<T>, List<T>> {

        @Override
        public Supplier<List<T>> supplier() {
            return () -> Lists.newArrayList();
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return (list, e) -> list.add(e);
        }

        @Override
        public Function<List<T>, List<T>> finisher() {
            return list -> list;
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            return (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }


        @Override
        public Set<Characteristics> characteristics() {

            HashSet<Characteristics> set = new HashSet<>();
            set.add(Characteristics.IDENTITY_FINISH);
            set.add(Characteristics.CONCURRENT);
            return Collections.unmodifiableSet(set);
        }
    }
}
