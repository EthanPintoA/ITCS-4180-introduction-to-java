package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Question 1 - fizzBuzz");
        Main.fizzBuzz();

        System.out.println("\nQuestion 2 - isEven");
        var numbers = new Integer[] { 17, 43, 191, 310, 477, 642, 648, 738, 782, 869 };

        for (var num : numbers) {
            if (Main.isEven(num)) {
                System.out.println(num + " is even.");
            } else {
                System.out.println(num + " is odd.");
            }
        }

        System.out.println("\nQuestion 3 - getMinimum");
        System.out.println(Main.getMinimum(numbers));
        System.out.println(Main.getMinimum(new Integer[] {}));

        System.out.println("\nQuestion 4 - getParsedUsers");
        var users = Main.getParsedUsers(Data.users);
        System.out.println(users);

        System.out.println("\nQuestion 5 - printUsers_OMN");
        Main.printUsers_OMN(users);

        System.out.println("\nQuestion 6 - printUsersSortedByAge");
        Main.printUsersSortedByAge(users);

        System.out.println("\nQuestion 7 - printUsersOldest10");
        Main.printUsersOldest10(users);

        System.out.println("\nQuestion 8 - printUserStateStats");
        Main.printUserStateStats(users);

        System.out.println("\nQuestion 9 - getWordOverlap");
        var overlaps = Main.getWordOverlap(Data.words_1, Data.words_2);
        System.out.println(overlaps);

        System.out.println("\nQuestion 10 - getUserOverlap");
        var otherUsers = Main.getParsedUsers(Data.otherUsers);

        var userOverlap = Main.getUserOverlap(users, otherUsers);
        System.out.println(userOverlap);

    }

    // Question 1
    public static void fizzBuzz() {
        for (int i = 1; i <= 20; i++) {
            var s = new StringBuilder();

            if (i % 3 == 0) {
                s.append("Fizz");
            }
            if (i % 5 == 0) {
                s.append("Buzz");
            }

            if (s.isEmpty()) {
                System.out.println(i);
            } else {
                System.out.println(s);
            }
        }
    }

    // Question 2
    public static boolean isEven(Integer num) {
        return num % 2 == 0;
    }

    // Question 3
    public static Integer getMinimum(Integer[] numbers) {
        if (numbers.length == 0) {
            return null;
        }

        var min = Integer.MAX_VALUE;

        for (var number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    // Question 4
    public static ArrayList<User> getParsedUsers(String[] strings) {
        var users = new ArrayList<User>();

        for (var user : strings) {
            var props = user.split(",");
            var age = Integer.parseInt(props[2]);

            var newUser = new User(props[0], props[1], age, props[3], props[4], props[5], props[6]);
            users.add(newUser);
        }

        return users;
    }

    // Question 5
    public static void printUsers_OMN(ArrayList<User> users) {
        for (var user : users) {
            switch (user.firstName.charAt(0)) {
                case 'O', 'M', 'N' -> System.out.println(user);
            }
        }
    }

    // Question 6
    public static void printUsersSortedByAge(ArrayList<User> users) {
        users.sort(Comparator.comparingInt(u -> u.age));

        for (var user : users) {
            System.out.println(user);
        }
    }

    // Question 7
    public static void printUsersOldest10(ArrayList<User> users) {
        users.sort((a, b) -> b.age - a.age);
        var oldestTen = users.subList(0, Integer.min(10, users.size()));

        for (var user : oldestTen) {
            System.out.println(user.firstName + " is " + user.age + " years old.");
        }
    }

    // Question 8
    public static void printUserStateStats(ArrayList<User> users) {
        var states_count = new HashMap<String, Integer>();

        for (var user : users) {
            var count = states_count.getOrDefault(user.state, 0);
            states_count.put(user.state, count + 1);
        }

        for (String state : states_count.keySet()) {
            System.out.println(state + ": " + states_count.get(state));
        }
    }

    // Question 9
    public static Set<String> getWordOverlap(String[] listA, String[] listB) {
        var setA = new HashSet<>(Arrays.asList(listA));
        var setB = new HashSet<>(Arrays.asList(listB));

        setA.retainAll(setB);

        return setA;
    }

    // Question 10
    public static ArrayList<User> getUserOverlap(ArrayList<User> usersA,
            ArrayList<User> usersB) {
        var setA = new HashSet<>(usersA);
        var setB = new HashSet<>(usersB);

        setA.retainAll(setB);

        return new ArrayList<>(setA);

    }
}
