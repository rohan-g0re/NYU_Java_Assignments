package PartII;

import java.util.Arrays;

public class Student {
    private static int nextId = 1; // Static counter for unique IDs
    private int id;
    private String name;
    private int[] grades = new int[5];

    // Constructor: assigns name and auto-generates ID. Initializes grades to -1.
    public Student(String name) {
        this.name = name;
        this.id = nextId++;
        Arrays.fill(grades, -1);
    }

    // Returns the unique ID for this student
    public int getId() {
        return id;
    }

    // Returns the name of the student
    public String getName() {
        return name;
    }

    // Returns a copy of the grades array for safety (encapsulation)
    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    // Sets a grade if index is in [0,4] and grade is in [0,100]
    public void setGrades(int assignmentIndex, int grade) {
    	
    	
/*this if case in unnecessarily complex --> but this is because we are making it act as a
 * ERROR HANDLER such that 
 * if the logic of editing grade in Gradebook is flawed 
 * still it would not edit the grades in actual objects
  */  	
    	
        if (assignmentIndex >= 0 && assignmentIndex < grades.length && grade >= 0 && grade <= 100) {
            grades[assignmentIndex] = grade;
        }
    }

    // Computes average for valid grades (ignoring -1)
    public double getAverage() {
        int sum = 0, count = 0;
        for (int g : grades) {
        	
/* The following if case checks the case in state in doc 
 * This can possible happen when there are5 grades in general for all students
 * but due to some reason a student might not have a particular grade (maybe he was absent for that test)
 * 
 * IN such a case we are not supposed to count the -1 while calculating average
 * 
 * In this way we would be counting it as a ZERO -- which is how it should/and works in real life too. 
 * 
 * 
 * 
 *  
 * */        	
        	
            if (g != -1) {
                sum += g;
                count++;
            }
        }
        
        
/*
 * PROBLEM:
 * 
 * DOUBT --> But one thing I dont understand is that the COUNT should have stayed zero
 * as it happens in real life - avergae of a student will fall down if he was absent for a test
 * 
 * DIRECTLY CONSIDERING THAT HE HAS NOT TAKEN UP THAT COURSE 
 * 
 * Therefore in a cleaner logic we would have had different identifiers when 
 * 		- student was absent 
 * 		- student has not taken up the course
 * */        			
        
        return count > 0 ? (double) sum / count : 0.0;
    }

    
    
    
    
    
    // Returns readable student info --> 
/*    
    I GUESS <toString> is a RESERVED KEYWORD FOR A FUNCTION
    which converts an object into string 
    
    This should only happen if we explicitly write the code for formatting it 
    or else it would be doing something  by its own.
    
*/    
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', grades=" + Arrays.toString(grades) +
                ", avg=" + String.format("%.2f", getAverage()) + "}";
    }
}
