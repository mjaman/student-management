package com.aricalot.maven.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class School {
    private int id;
    final String name;
    final String address;
    final int contact;
    final String logo;

    public School(String name, String address, int contact, String logo) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.logo = logo;
    }

    public School(int id, String name, String address, int contact, String logo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "School Id:" + id + ", " +
                "School Name:" + name + ", " +
                "School Address:" + address + ", " +
                "School Contact:" + contact + ", " +
                "School Logo:" + logo;
    }
}
