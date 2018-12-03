package com.epam.training.marketing;


import static com.epam.training.marketing.Employee.members;
import static com.epam.training.marketing.Employee.printAllFollowers;

public class Main {

    public static void main(String[] args) {
        Employee first = new Employee();
        first.addFollower();
        first.addFollower();
        first.addFollower();
        first.addFollower();

        first.getFollower(2).addFollower();

        members.get(4).addFollower();
        members.get(4).addFollower();
        members.get(4).addFollower();

        members.get(3).addFollower();

        members.get(5).addFollower();

        members.get(2).addFollower();
        System.out.println();

        printAllFollowers(members.get(2));
        System.out.println();

        Employee twelve = members.get(12);
        twelve.printOrigin();
        System.out.println();

        first.printNextLevelFollowers();
    }
}
