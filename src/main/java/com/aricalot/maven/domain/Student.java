package com.aricalot.maven.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Student{
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

    @Override
    public String toString() {
        return "Id:" + id + ", " +
                "Name:" + name + ", " +
                "Age:" + age + ", " +
                "Class:" + grade + ", " +
                "School:" + school;
    }
}

