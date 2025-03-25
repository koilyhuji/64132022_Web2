package com.pgq.Models;

public class Student {
    private int id;
    private String name;
    private String grade;
    
    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getGrade() {
        return grade;
    }
}
