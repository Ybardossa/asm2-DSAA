/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm2.ArrayList;

public class StudentManagement {

    private asm2.ArrayList.ArrayList<Student> students;
    private final java.util.Scanner scanner;

    public StudentManagement() {
        this.students = new asm2.ArrayList.ArrayList<>();
        this.scanner = new java.util.Scanner(System.in);
    }

    private String readLine() {
        return scanner.nextLine().trim();
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(readLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
            }
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }

    public void addStudent() {
        try {
            int studentId;
            while (true) {
                System.out.print("Enter Student ID: ");
                studentId = readInt();

                boolean idExists = false;
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getStudentId() == studentId) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    System.out.println("Error: Student ID already exists. Please enter a different ID.");
                } else {
                    break;
                }
            }

            String fullName;
            while (true) {
                System.out.print("Enter Student Full Name: ");
                fullName = readLine();
                if (!fullName.matches(".*\\d.*")) {
                    break;
                }
                System.out.println("Invalid name. Name cannot contain numbers. Please enter a valid name.");
            }

            double marks;
            while (true) {
                System.out.print("Enter Student Marks: ");
                marks = readDouble();
                if (marks >= 0 && marks <= 10) {
                    break;
                }
                System.out.println("Invalid marks. Please enter marks between 0 and 10.");
            }

            students.add(new Student(studentId, fullName, marks));
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the student: " + e);
        }
    }

    public void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            int studentId = readInt();
            Student student = null;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId() == studentId) {
                    student = students.get(i);
                    break;
                }
            }

            if (student != null) {
                String fullName;
                while (true) {
                    System.out.print("Enter new Full Name: ");
                    fullName = readLine();
                    if (!fullName.matches(".*\\d.*")) {
                        break;
                    }
                    System.out.println("Invalid name. Name cannot contain numbers. Please enter a valid name.");
                }

                double marks;
                while (true) {
                    System.out.print("Enter new Marks: ");
                    marks = readDouble();
                    if (marks >= 0 && marks <= 10) {
                        break;
                    }
                    System.out.println("Invalid marks! Please enter marks between 0 and 10.");
                }

                student.setFullName(fullName);
                student.setMarks(marks);
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while editing the student: " + e);
        }
    }

    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int studentId = readInt();
            boolean removed = false;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId() == studentId) {
                    students.remove(students.get(i));
                    removed = true;
                    break;
                }
            }

            if (removed) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the student: " + e);
        }
    }

    public void sortStudents() {
        try {
            students.sort();
            System.out.println("Students sorted by marks!");
        } catch (Exception e) {
            System.out.println("An error occurred while sorting the students: " + e);
        }
    }

    public void searchStudentById() {
        try {
            System.out.print("Enter Student ID to search: ");
            int studentId = readInt();
            Student student = null;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId() == studentId) {
                    student = students.get(i);
                    break;
                }
            }

            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while searching for the student: " + e);
        }
    }

    public void displayAllStudents() {
        if (students.size() == 0) {
            System.out.println("No students to display.");
            return;
        }

        students.printAll();
    }

    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();
        system.addStudent();
        system.addStudent();
        system.displayAllStudents();
        system.editStudent();
        system.displayAllStudents();
        system.deleteStudent();
        system.displayAllStudents();
        system.sortStudents();
        system.displayAllStudents();
        system.searchStudentById();
    }
}
