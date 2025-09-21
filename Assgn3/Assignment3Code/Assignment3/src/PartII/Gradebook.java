package PartII;

import java.util.Random;

public class Gradebook {
    private Student[] students;

    // Constructor: initializes array of Students with given capacity
    public Gradebook(int capacity) {
        students = new Student[capacity];
    }

    // Adds student to the first available null slot
    public void addStudent(Student s) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                return;
            }
        }
    }

    // Finds student by id, returns null if not found
    public Student findById(int id) {
        for (Student s : students) {
            if (s != null && s.getId() == id) return s;
        }
        return null;
    }

    // Returns student with highest average
    public Student getTopStudent() {
        Student top = null;
        double maxAvg = -1;
        for (Student s : students) {
            if (s != null) {
                double avg = s.getAverage();
                if (avg > maxAvg) {
                    maxAvg = avg;
                    top = s;
                }
            }
        }
        return top;
    }

    // Prints all student info
    public void printAll() {
        for (Student s : students) {
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Gradebook gb = new Gradebook(5);

        // Create and add 5 students
        String[] names = {"Alice", "Bob", "Carol", "Dan", "Eva"};
        for (String n : names) {
            gb.addStudent(new Student(n));
        }

        // Set random grades for each assignment for each student
        Random rand = new Random();
        for (Student s : gb.students) {
            for (int i = 0; i < 5; i++) {
                int grade = rand.nextInt(101); // 0 to 100
                s.setGrades(i, grade);
            }
        }

        // Print all students
        System.out.println("All students info:");
        gb.printAll();

        // Print top student
        Student top = gb.getTopStudent();
        System.out.println("\nTop student:");
        if (top != null) System.out.println(top);
    }
}
