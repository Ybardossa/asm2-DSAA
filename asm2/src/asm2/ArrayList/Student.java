/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2.ArrayList;
/**
 */
class Student implements Comparable<Student> {
    private int studentId;
    private String fullName;
    private double marks;

    public Student(int studentId, String fullName, double marks) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public double getMarks() {
        return marks;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + fullName + ", Marks: " + marks;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.marks, other.marks);
    }
}
