package com.company;

import java.util.Objects;

public class User {
    public String firstName, lastName, email, gender, city, state;
    public int age;

    public User(String firstName, String lastName, int age, String email, String gender, String city, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format(
                "User { firstName: \"%s\", lastName: \"%s\", age: %d, email: \"%s\", gender: \"%s\", city: \"%s\", state: \"%s\" }",
                this.firstName, this.lastName, this.age, this.email, this.gender, this.city, this.state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return age == user.age
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(email, user.email)
                && Objects.equals(gender, user.gender)
                && Objects.equals(city, user.city)
                && Objects.equals(state, user.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, email, gender, city, state);
    }
}
