package ru.sbt.javacourse.hw08;

/**
 * Created by user on 08.12.2017.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Employee extends Person {
    private String company;
    private int salary;

    public Employee(String name, int age, String company, int salary) {
        super(name, age);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }
}


class Postman extends Employee {
    private String region;

    public Postman(String name, int age, String company, int salary, String region) {
        super(name, age, company, salary);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }
}

class Pochtaclerk extends Postman {
    private String zip;

    public Pochtaclerk(String name, int age, String company, int salary, String region, String zip) {
        super(name, age, company, salary, region);
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }
}
