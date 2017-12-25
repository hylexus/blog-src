package cn.hylexus.lambda;

import org.junit.Test;

import java.util.Optional;

/**
 * @author hylexus
 * createdAt 2017/12/20
 **/
public class OptionalTest {
    static class Person {
        private String name;
        private City address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public City getAddress() {
            return address;
        }

        public void setAddress(City address) {
            this.address = address;
        }
    }

    static class City {
        private String name;
        private Street street;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }
    }

    static class Street {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Test
    public void test1() {
        Person person = null;
        String street = Optional.ofNullable(person)
                .map(Person::getAddress)
                .map(City::getStreet)
                .map(Street::getName)
                .orElse("not found");
        System.out.println(street);

    }

    boolean locationMatched(Optional<Person> person, Optional<City> city) {
        if (person.isPresent() && city.isPresent()) {
            return person.map(Person::getAddress).get().equals(city.get());
        }
        return false;
    }

    boolean locationMatched2(Optional<Person> person, Optional<City> city) {
        return false;
    }
}
