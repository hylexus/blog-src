package cn.hylexus.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hylexus
 * createdAt 2017/12/25
 **/
public class CollectorTest {

    static class ToListCollector<T> implements Collector<T, List<T>, List<T>> {


        @Override
        public Supplier<List<T>> supplier() {
            return () -> Lists.newArrayList();
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return (list, e) -> list.add(e);
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            return (acc1, acc2) -> {
                acc1.addAll(acc2);
                return acc1;
            };
        }

        @Override
        public Function<List<T>, List<T>> finisher() {
            return (acc) -> acc;
        }

        @Override
        public Set<Characteristics> characteristics() {
            Set<Characteristics> ret = new HashSet<>();
            ret.add(Characteristics.CONCURRENT);
            ret.add(Characteristics.IDENTITY_FINISH);
            return Collections.unmodifiableSet(ret);
        }
    }


    static class ToListCollector2<T> implements Collector<T, List<T>, List<T>> {

        @Override
        public Supplier<List<T>> supplier() {
            return ArrayList::new;
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            return List::add;
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            return (acc1, acc2) -> {
                acc1.addAll(acc2);
                return acc1;
            };
        }

        @Override
        public Function<List<T>, List<T>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.unmodifiableSet(
                    EnumSet.of(
                            Characteristics.CONCURRENT,
                            Characteristics.IDENTITY_FINISH
                    )
            );
        }
    }

    @Test
    public void testListCollector() {
        List<Integer> list = IntStream.rangeClosed(1, 5).boxed().collect(new ToListCollector<>());
        System.out.println(list);

        List<Integer> list2 = Stream.iterate(1, i -> i + 1).limit(5).collect(new ToListCollector2<>());
        System.out.println(list2);

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

    static class GroupByCollector<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

        Function<T, K> classifier;

        public GroupByCollector(Function<T, K> classifier) {
            this.classifier = classifier;
        }

        @Override
        public Supplier<Map<K, List<T>>> supplier() {
            return () -> new HashMap<>();
        }

        @Override
        public BiConsumer<Map<K, List<T>>, T> accumulator() {
            return (map, e) -> {
                K key = classifier.apply(e);
                List<T> value = map.get(key);
                if (map.get(key) == null) {
                    map.put(key, Lists.newArrayList());
                }

                map.get(key).add(e);
            };
        }

        @Override
        public BinaryOperator<Map<K, List<T>>> combiner() {
            return (map1, map2) -> {
                map2.forEach((k, v) -> {
                    if (map1.get(k) == null) {
                        map1.put(k, v);
                    } else {
                        map1.get(k).addAll(v);
                    }
                });
                return map1;
            };
        }

        @Override
        public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return CH_ID;
        }
    }

    static class GroupByCollector2<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {
        Function<T, K> classifier;

        public GroupByCollector2(Function<T, K> classifier) {
            this.classifier = classifier;
        }

        @Override
        public Supplier<Map<K, List<T>>> supplier() {
            return HashMap::new;
        }

        @Override
        public BiConsumer<Map<K, List<T>>, T> accumulator() {
            return (map, e) -> {
                K key = classifier.apply(e);
                List<T> value = Optional.ofNullable(map).map(m -> m.get(key)).orElse(Lists.newArrayList());
                value.add(e);
                map.put(key, value);
            };
        }

        @Override
        public BinaryOperator<Map<K, List<T>>> combiner() {
            return (m1, m2) -> {
                m2.forEach((k, v) -> {
                    List<T> value = Optional.ofNullable(m1).map(m -> m.get(k)).orElse(Lists.newArrayList());
                    value.addAll(v);
                    m1.put(k, value);
                });

                return m1;
            };
        }

        @Override
        public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
            return Function.identity();
        }

        @Override
        public Set<Characteristics> characteristics() {
            return CH_ID;
        }
    }

    static class GroupByCollector3<K, T, R> implements Collector<T, Map<K, List<T>>, Map<K, List<R>>> {

        Function<T, K> classifier;
        Function<T, R> finisher;

        public GroupByCollector3(Function<T, K> classifier, Function<T, R> finisher) {
            this.classifier = classifier;
            this.finisher = finisher;
        }

        @Override
        public Supplier<Map<K, List<T>>> supplier() {
            return HashMap::new;
        }

        @Override
        public BiConsumer<Map<K, List<T>>, T> accumulator() {
            return (map, e) -> {
                K key = classifier.apply(e);
                List<T> val = Optional.ofNullable(map).map(m -> m.get(key)).orElse(Lists.newArrayList());
                val.add(e);
                map.put(key, val);
            };
        }

        @Override
        public BinaryOperator<Map<K, List<T>>> combiner() {
            return (m1, m2) -> {
                m2.forEach((k, v) -> {
                    List<T> val = Optional.ofNullable(m1).map(m -> m.get(k)).orElse(Lists.newArrayList());
                    val.addAll(v);
                });
                return m1;
            };
        }

        @Override
        public Function<Map<K, List<T>>, Map<K, List<R>>> finisher() {
            Function<Map<K, List<T>>, Map<K, List<R>>> function = map -> {
                Map<K, List<R>> ret = new HashMap<>();

                map.entrySet().stream().forEach(e -> {
                    List<R> v = e.getValue().stream().map(finisher).collect(Collectors.toList());
                    ret.put(e.getKey(), v);
                });
                return ret;
            };
            return function;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }

    static final Set<Collector.Characteristics> CH_ID
            = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH));

    @Test
    public void test2() {
        Map<Integer, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getGender));
        printUserMap(map);

        map = users.stream().collect(new GroupByCollector<>(User::getGender));
        printUserMap(map);

        map = users.stream().collect(new GroupByCollector2<>(User::getGender));
        printUserMap(map);

        Map<Integer, List<Integer>> collect = users.stream().collect(new GroupByCollector3<>(User::getGender, User::getId));
        collect.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("\t" + v);
        });
    }

    void printUserMap(Map<Integer, List<User>> map) {
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("\t" + v);
        });
    }

    @Test
    public void testMapMerge() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "apache");
        map.put("s", "scala");

        System.out.println(map);
        map.merge("a", "apache2", (v1, v2) -> v1 + "--" + v2);
        System.out.println(map);
        map.merge("s", "s2", (v1, v2) -> v1 + "----" + v2);
        System.out.println(map);
        map.merge("abc", "xxx", (v1, v2) -> v1);
        System.out.println(map);
        map.merge("abc", "a", (v1, v2) -> null);
        System.out.println(map);
    }


    static class CityInfo {
        private Integer cityId;
        private String cityName;
        private Integer cityLevel;

        public CityInfo(Integer cityId, String cityName, Integer cityLevel) {
            this.cityId = cityId;
            this.cityName = cityName;
            this.cityLevel = cityLevel;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Integer getCityLevel() {
            return cityLevel;
        }

        public void setCityLevel(Integer cityLevel) {
            this.cityLevel = cityLevel;
        }

        @Override
        public String toString() {
            return "CityInfo{" +
                    "cityId=" + cityId +
                    ", cityName='" + cityName + '\'' +
                    ", cityLevel=" + cityLevel +
                    '}';
        }
    }

    List<CityInfo> cities = Lists.newArrayList(
            new CityInfo(604, "北京", 1),
            new CityInfo(605, "上海", 1),
            new CityInfo(616, "西安", 2),
            new CityInfo(622, "长沙", 2)
    );

    @Test
    public void test3() {
        Map<Integer, List<CityInfo>> groupByLevel = cities.stream().collect(Collectors.groupingBy(CityInfo::getCityLevel));
        printCity(groupByLevel);

        groupByLevel = cities.stream().collect(Collectors.groupingBy(CityInfo::getCityLevel, Collectors.toList()));
        printCity(groupByLevel);

        Map<Integer, List<String>> collect = cities.stream().collect(
                Collectors.groupingBy(
                        CityInfo::getCityLevel,
                        Collectors.mapping(
                                CityInfo::getCityName, Collectors.toList()
                        )
                )
        );

        collect.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(c -> System.out.println("\t" + c));
            System.out.println("=================");
        });

        Map<Integer, CityInfo> collect1 = cities.stream().collect(
                Collectors.groupingBy(
                        CityInfo::getCityLevel,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(CityInfo::getCityId,Comparator.reverseOrder())
                                ),
                                Optional::get
                        ))

        );

        collect1.forEach((k, v) -> {
            System.out.println(k);
            System.out.println("\t" + v);
        });
    }

    private void printCity(Map<Integer, List<CityInfo>> map) {
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(c -> System.out.println("\t" + c));
        });
        System.out.println("=================");
    }
}
