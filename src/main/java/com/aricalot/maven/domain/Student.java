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
    private int school_id=0;
    private String school_name=null;

    public Student(String name, int age, int grade, int school_id) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school_id = school_id;
    }

    public Student(int id, String name, int age, int grade, String school_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school_name = school_name;
    }

    @Override
    public String toString() {
        return "Student Id:" + id + ", " +
                "Student Name:" + name + ", " +
                "Student Age:" + age + ", " +
                "Student Class:" + grade + ", " +
                "School Name:" + school_name;
    }
}

