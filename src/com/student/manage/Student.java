package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;

public class Student {
    private int sid;
    private String sname;
    private String sphone;
    private String sdept;

    public Student(int sid, String sname, String sphone, String sdept) {
        this.sid = sid;
        this.sname = sname;
        this.sphone = sphone;
        this.sdept = sdept;
    }

    public Student(String sname, String sphone, String sdept) {
        this.sname = sname;
        this.sphone = sphone;
        this.sdept = sdept;
    }

    public Student(){
        super();
    }

    public Student(int sid) {
    }

    public int getSid() {
        return this.sid;
    }

    public String getSname() {
        return this.sname;
    }

    public String getSphone() {
        return this.sphone;
    }

    public String getSdept() {
        return this.sdept;
    }

    public static Student studentInfo(BufferedReader read) throws IOException {
        System.out.println("Enter Username: ");
        String name = read.readLine();

        System.out.println("Enter Phone No: ");
        String phone = read.readLine();

        System.out.println("Enter the Dept: ");
        String dept = read.readLine();

        return new Student(name, phone, dept);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sphone='" + sphone + '\'' +
                ", sdept='" + sdept + '\'' +
                '}';
    }
}
