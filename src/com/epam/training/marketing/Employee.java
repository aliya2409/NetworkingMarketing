package com.epam.training.marketing;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements Comparable<Employee> {
    private int id;
    private int parentId = 0;
    private String firstName;
    private String lastName;

    private Set<Employee> followers = new TreeSet<>();
    private static final AtomicInteger count = new AtomicInteger(0);
    public static Map<Integer, Employee> members = new HashMap<>();

    public Employee() {
        this.id = count.incrementAndGet();
        this.firstName = generateName();
        this.lastName = generateName();
        addEmployeeToMap();
    }

    public void addFollower() {
        Employee follower = new Employee();
        follower.parentId = this.id;
        followers.add(follower);
    }


    public void printOrigin() {
        Employee currentEmployee = this;
        int upperLevelId = currentEmployee.getParentId();
        while (!(upperLevelId == 0)) {
            currentEmployee = members.get(upperLevelId);
            System.out.println(members.get(upperLevelId));
            upperLevelId = currentEmployee.getParentId();
        }

    }

    public static void printAllFollowers(Employee employee) {
        if (!employee.getFollowers().isEmpty()) {
            for (Employee insideEmployee : employee.getFollowers()) {
                System.out.print(insideEmployee + "\n");
                printAllFollowers(insideEmployee);
            }
            System.out.println();
        }
    }

    public Employee getFollower(int id) {
        for (Employee employee : followers) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void printNextLevelFollowers() {
        for(Employee employee : followers){
            System.out.println(employee);
        }
    }

    public int getId() {
        return id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Employee> getFollowers() {
        return followers;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.getId();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }

    private String generateName() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        final int N = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }
        String randomName = sb.toString().toUpperCase();
        return randomName;
    }

    private void addEmployeeToMap() {
        members.put(this.id, this);
    }
}
