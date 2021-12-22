package com.aricalot.usingMaven.domain;

public class Student {
    private int id;
    final String name;
    final int age;
    final int grade;
    final String school;

    public Student(String name, int age, int grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    public Student(int id, String name, int age, int grade, String school) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public String getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Id:" + id + ", " +
                "Name:" + name + ", " +
                "Age:" + age + ", " +
                "Class:" + grade + ", " +
                "School:" + school;
    }
}

