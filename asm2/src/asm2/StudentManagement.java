/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2;

public class StudentManagement {

    private Node head;

    public StudentManagement() {
        this.head = null;
    }

    private String readLine() {
        byte[] buffer = new byte[100];
        int count = 0;
        try {
            while (true) {
                int read = System.in.read();
                if (read == '\n') {
                    break;
                }
                buffer[count++] = (byte) read;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(buffer, 0, count).trim();
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

                Node current = head;
                boolean idExists = false;
                while (current != null) {
                    if (current.student.getStudentId() == studentId) {
                        idExists = true;
                        break;
                    }
                    current = current.next;
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

            Student student = new Student(studentId, fullName, marks);
            Node newNode = new Node(student);

            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.out.println("An error occurred while adding the student: " + e.getMessage());
        }
    }

    public void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            int studentId = readInt();
            Node current = head;

            while (current != null && current.student.getStudentId() != studentId) {
                current = current.next;
            }

            if (current != null) {
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

                current.student.setFullName(fullName);
                current.student.setMarks(marks);
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while editing the student: " + e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            int studentId = readInt();

            if (head == null) {
                System.out.println("No students to delete.");
                return;
            }

            if (head.student.getStudentId() == studentId) {
                head = head.next;
                System.out.println("Student deleted successfully!");
                return;
            }

            Node current = head;
            Node previous = null;

            while (current != null && current.student.getStudentId() != studentId) {
                previous = current;
                current = current.next;
            }

            if (current != null) {
                previous.next = current.next;
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting the student: " + e.getMessage());
        }
    }

    public void sortStudentsByBubbleSort() {
        try {
            if (head == null || head.next == null) {
                System.out.println("No need to sort, insufficient number of students.");
                return;
            }

            boolean swapped;
            do {
                Node current = head;
                Node previous = null;
                Node next = head.next;
                swapped = false;

                while (next != null) {
                    if (current.student.getMarks() > next.student.getMarks()) {
                        swapped = true;

                        if (previous == null) {
                            Node temp = next.next;
                            next.next = current;
                            current.next = temp;
                            head = next;
                        } else {
                            Node temp = next.next;
                            next.next = current;
                            current.next = temp;
                            previous.next = next;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (swapped);

            System.out.println("Students sorted by marks using Bubble Sort!");
        } catch (Exception e) {
            System.out.println("An error occurred while sorting the students: " + e.getMessage());
        }
    }

    public void sortStudentsByQuickSort() {
        try {
            if (head == null || head.next == null) {
                System.out.println("No need to sort, insufficient number of students.");
                return;
            }

            head = quickSort(head, null);
            System.out.println("Students sorted by marks using Quick Sort!");
        } catch (Exception e) {
            System.out.println("An error occurred while sorting the students: " + e.getMessage());
        }
    }

    private Node quickSort(Node start, Node end) {
        if (start == end || start == null || start.next == end) {
            return start;
        }

        Node[] result = partition(start, end);
        Node pivotPrev = result[0];
        Node pivot = result[1];
        Node tail = result[2];

        if (pivotPrev != null && pivotPrev != start) {
            Node temp = start;
            while (temp.next != pivotPrev) {
                temp = temp.next;
            }
            temp.next = null;
            start = quickSort(start, temp);
            temp.next = pivotPrev;
        }

        pivot.next = quickSort(pivot.next, end);

        return start;
    }

    private Node[] partition(Node start, Node end) {
        Node pivotPrev = start;
        Node curr = start;
        Node pivot = end;

        double pivotMarks = pivot.student.getMarks();

        while (start != pivot) {
            if (start.student.getMarks() < pivotMarks) {
                pivotPrev = curr;
                double tempMarks = curr.student.getMarks();
                int tempId = curr.student.getStudentId();
                String tempName = curr.student.getFullName();

                curr.student.setMarks(start.student.getMarks());
                curr.student.setStudentId(start.student.getStudentId());
                curr.student.setFullName(start.student.getFullName());

                start.student.setMarks(tempMarks);
                start.student.setStudentId(tempId);
                start.student.setFullName(tempName);

                curr = curr.next;
            }
            start = start.next;
        }

        double tempMarks = curr.student.getMarks();
        int tempId = curr.student.getStudentId();
        String tempName = curr.student.getFullName();

        curr.student.setMarks(pivot.student.getMarks());
        curr.student.setStudentId(pivot.student.getStudentId());
        curr.student.setFullName(pivot.student.getFullName());

        pivot.student.setMarks(tempMarks);
        pivot.student.setStudentId(tempId);
        pivot.student.setFullName(tempName);

        return new Node[]{pivotPrev, curr, pivot};
    }

    public void searchStudentById() {
        try {
            System.out.print("Enter Student ID to search: ");
            int studentId = readInt();
            Node current = head;

            while (current != null) {
                if (current.student.getStudentId() == studentId) {
                    System.out.println(current.student);
                    return;
                }
                current = current.next;
            }

            System.out.println("Student not found!");
        } catch (Exception e) {
            System.out.println("An error occurred while searching for the student: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
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
        system.sortStudentsByBubbleSort();
        system.displayAllStudents();
        system.sortStudentsByQuickSort();
        system.displayAllStudents();
        system.searchStudentById();
    }

    // Linked list node for student management
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
}