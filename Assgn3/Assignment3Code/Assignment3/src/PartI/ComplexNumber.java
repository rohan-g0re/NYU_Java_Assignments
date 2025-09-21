package PartI;

public class ComplexNumber {
    // Private fields
    private double real;
    private double imaginary;

    // Constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

 /*


1. ------->>>> INSTANCE METHOD INVOCATION <<<<<<------

- When we write c1.add(c2), the method has access to all data inside c1 (via "this")
	and uses c2 for additional data.

- c1.add(c2) means “call the add method on the c1 object, using c2 as an argument.”

- This is called ------->>>> INSTANCE METHOD INVOCATION <<<<<<------
	where each object gets its own copy of methods to work with its internal
 
 
 *******
 
 2. Can You Pass Objects in Functions in OOP (Java and C++)?

- Yes! In Java, object references are passed as arguments to methods.
	For example, add(ComplexNumber addend) means
	“pass another ComplexNumber object to this method - which will be called as <addend> throughout this method”

- In C++, you do this too, either by value, reference, or pointer.


*/
      
    
    
    
    
    // Add method
    public ComplexNumber add(ComplexNumber addend) {
        return new ComplexNumber(this.real + addend.real, this.imaginary + addend.imaginary);
    }

    
    
    // Subtract method
    public ComplexNumber subtract(ComplexNumber subtrahend) {
        return new ComplexNumber(this.real - subtrahend.real, this.imaginary - subtrahend.imaginary);
    }

    
    
    // Multiply method
    public ComplexNumber multiply(ComplexNumber factor) {
        double newReal = (this.real * factor.real) - (this.imaginary * factor.imaginary);
        double newImaginary = (this.real * factor.imaginary) + (this.imaginary * factor.real);
        return new ComplexNumber(newReal, newImaginary);
    }
    
    

    // Extra credit: Divide method
    public ComplexNumber divide(ComplexNumber divisor) {
        double denominator = (divisor.real * divisor.real) + (divisor.imaginary * divisor.imaginary);
        double newReal = ((this.real * divisor.real) + (this.imaginary * divisor.imaginary)) / denominator;
        double newImaginary = ((this.imaginary * divisor.real) - (this.real * divisor.imaginary)) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    

//    ***********************************

    // Magnitude method
    public double magnitude() {
        return Math.sqrt((this.real * this.real) + (this.imaginary * this.imaginary));
    }

    
    
    // Getter and setter for real
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    
    
    // Getter and setter for imaginary
    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    
    
    
    // toString method
    @Override
    public String toString() {
        return real + " + i" + imaginary;
    }
    
    
    
    

    // Main method for testing
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(7.5, 4.2);
        ComplexNumber c2 = new ComplexNumber(8.2, 9.4);

        ComplexNumber sum = c1.add(c2);
        ComplexNumber difference = c1.subtract(c2);
        ComplexNumber product = c1.multiply(c2);
        ComplexNumber quotient = c1.divide(c2); // Extra credit

        System.out.println("The Complex Numbers are --> c1 is: " + c1.toString() + " and c2 is: " + c2.toString());
       
        System.out.println();

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Product = " + product);
        System.out.println("Quotient = " + quotient); // Extra credit
        
        System.out.println();

        System.out.println("Magnitude of c1 and c2 is --> " + c1.magnitude() + " and " + c2.magnitude() + " respectively.");
        
        System.out.println("Real part of c1 and c2 is --> " + c1.getReal() + " and " + c2.getReal() + "  respectively.");
        
        System.out.println("Imaginary part of c1 and c2 is --> " + c1.getImaginary() + " and " + c2.getImaginary() + "  respectively.");
        
        System.out.println();
        
        System.out.println("Setting the real and imaginary part of the numbers as 69");
        
        c1.setReal(69);
        c2.setReal(69);

        c1.setImaginary(69);
        c2.setImaginary(69);
        
        System.out.println("The Complex Numbers after change are --> c1 is: " + c1.toString() + " and c2 is: " + c2.toString());

    }
}
