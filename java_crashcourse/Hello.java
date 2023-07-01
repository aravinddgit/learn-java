import java.io.StreamCorruptedException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.w3c.dom.css.Counter;

import com.*; // Importing all files under {current_directory}/com. Does not include folders (* denotes files). Also note that within the library files, the line "package <current dir name>" should be specified at the top. There are many other default import statements that are implicitly present in any java file (Eg. import java.lang.*)
import com.domainname.*; // Importing all files under {current_directory}/com/domainname. Does not include folders. Also note that within the library files, the line "package <current dir name>" should be specified at the top.
class Calculator{
    int a;
    public int add(int a, int b){
        return a + b;
    };

    // Method overloading
    public double add(int a, double b){
        return a + b;
    }
}

class Student{
    int rollno;
    String name;
    double marks;
}

class Mobile {
    String brand;
    Double price;
    static String category;


    static {
        category = "Android";
        System.out.println("Inside static block");
    }

    public Mobile(){
        brand = "Apple";
        price = 500.0;
        System.out.println("Inside Constructor");
    }

    public void show(){
        System.out.println(brand + " : " + price + " : " + category);
    }

    public static void show1(Mobile obj){
        // Only static variables can be directly used inside static methods. Non-static methods need to be referenced to be used properly.
        System.out.println(obj.brand + " : " + obj.price + " : " + category);
    }
}

class Mobile2 {
    String brand;
    Double price;
    static String category;


    static {
        category = "Android";
        System.out.println("Inside static block");
    }

    public Mobile2(){
        brand = "Apple";
        price = 500.0;
        System.out.println("Inside Constructor");
    }

   

    public void show(){
        System.out.println(brand + " : " + price + " : " + category);
    }

    public static void show1(Mobile obj){
        // Only static variables can be directly used inside static methods. Non-static methods need to be referenced to be used properly.
        System.out.println(obj.brand + " : " + obj.price + " : " + category);
    }
}

class Human {
    private String name;
    private int age;
    private String info;

    // Default constructor
    public Human(){
        name = "Default name";
        age = 10;
        info = "Default info";
    }

    // Parametrized constructor - 1
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    
    public Human(int age) {
        this.name = "Default name"; // Even is the parametrized constructor has only one param ,it is good practice to set default values for other instance variables.
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name; // Here, this keyword refers to the current object. We could bypass "this" keyword using the implementation of the function shoown below.
    }

    public void setInfo(String info, Human obj1){ // Showing an implementation without using "this" keyword to achieve the same results as the above function.
        obj1.info = info;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // public void setDetails(String name1, int age1){
    //     name = name1;
    //     age = age1;
    // };

    // public String getName(){
    //     return name;
    // }

    // public int getAge(){
    //     return age;
    // }

}

class AnonymousObject {
    public AnonymousObject(){
        System.out.println("Created Object");
    }

    public void show(){
        System.out.println("Inside show function!");
    }
}

class A extends Object{
    public A(){
        super(); // Which is the super class of A? Again, the super class of a parent class is not explicity specified but it is always the "Object" class whose constructor is empty.
        System.out.println("In A");
    }
    public A(int n){
        super();
        //  this();
        System.out.println("In A int");
    }
}

class B extends A {
    public B(){
        super(); // In every constructor (default/parametrized) of a Java class, the super method is present even if we don't specify it explicitly. It calls the constructor of a parent/super class. We could mmodify this to call any parametrized constructor of the super class instead of the default constructor like given in the next line. But by default, the default constructor is called.
        // super(5);
        System.out.println("In B");
    }
    public B(int n){
        // super(); 
        // super(n)
        this(); // this method can be called to call the default constructor with the same class!
        System.out.println("In B int");
    }
}

class AdvLib1 extends Lib1 { // lib1 is present inside com/Lib1.java

    public AdvLib1(){}
    public AdvLib1(double dividend, double divisor){
        super(dividend, divisor);
    }
    public void printRemainder(){
        System.out.println("Remainder : " + remainder); // Here, AdvLib1 class uses the protected variable that is present in another package - com.Lib1.java
    }
}

class P {
    public void show(){
        System.out.println("In P show");
    }

    public static void show1(){ // static method
        System.out.println("In P show1");
    }
}

class Q extends P{
    public void show(){
        System.out.println("In Q show");
    }
    
    public static void show1(){ // static method
        System.out.println("In Q show1");
    }
}

class R extends P{
    public void show(){
        System.out.println("In R show");
    }
}

class Computer{
    final int test = 0;
    // test = 99; This can't be done as the variable is final/constant
    final public void show(){
        System.out.println("In computer show");
    }
}

final class Laptop extends Computer{  
    // public void show(){                 // This can't be done as the method being overidden has final keyword and hence cannot be overridden
    //     System.out.println("In Laptop show");
    // }
}

// class Hp extends Laptop{ //  This can't be done as the parent is final and therefore doesn't support inheritance.

// }


class TestHashCodeGenerators {
    public String name;
    public int value;

}

class TestHashCodeGenerators2 {
    public String name;
    public int value;

    public String toString(){
        return "Well, Hello there!";
    }

    public Boolean equals2(TestHashCodeGenerators2 that){
        return this.name.equals(that.name) && (this.value == that.value);
    }
}

class AutoGenerate {
    public String name;
    public int value;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AutoGenerate other = (AutoGenerate) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (value != other.value)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AutoGenerate [name=" + name + ", value=" + value + "]";
    }
    
}

class P1 {
    public void show1(){
        System.out.println("In Parent show");
    }

    public void tell(){
        System.out.println("In Parent tell");
    }
}

class C1 extends P1{
    public void show2(){
        System.out.println("In Child show");
    }

    public void tell(){
        System.out.println("In Child tell");
    }
}

abstract class Car{ // This is an abstract class
    public abstract void laneDetector();
    public abstract void camera();

    public void drive(){
        System.out.println("Driving a car!");
    }
}

abstract class HondaCity extends Car{ // This is an abstract class
    public void laneDetector(){
        System.out.println("Detecting Lane");
    }
}

class HondaCityUpdated extends HondaCity{ // This is a concrete class
    public void camera(){
        System.out.println("Implementing Camera!");
    }
}

class Outer {
    public void show(){
        System.out.println("Inside outer show");
    }

    class Inner{
        public void show(){
            System.out.println("Inside inner show");
        }
    }

    static class InnerStat{
        public void show(){
            System.out.println("Inside inner static show");
        }
    }
}

abstract class Computer1 {
    public abstract void code();
}

class Laptop1 extends Computer1{
    public void code(){
        System.out.println("Compile and execute: slow");
    }
}

class Desktop1 extends Computer1{
    public void code(){
        System.out.println("Compile and execute: fast");
    }
}

class Developer{
    public void develop(Computer1 obj){
        System.out.println("Executing developer");
        obj.code();
    }
}

class Developer2{
    public void develop(Computer2 obj){
        System.out.println("Executing developer 2");
        obj.code();
        obj.test();
        obj.deploy();
    }

    public void run(SubInterface obj){
        obj.run();
        obj.run2();
    }
}

interface SuperInterface{
    void run();
}

interface SubInterface extends SuperInterface{
    void run2();
}

interface Computer2 {
    double piValue = 3.14; // All variables are public, static and final by default.

    void code(); // All methods are public and abstract by default
    void test(); 
    default void deploy(){ 
        System.out.println("Deploying code - Default. Public, static, final interface variable value: " + piValue );
    }
}

class Laptop2 implements Computer2{
    public void code(){
        System.out.println("Compile and execute: slow");
    }
    public void test(){
        System.out.println("Testing code in Laptop");
    }
    public void deploy(){
        System.out.println("Deploying code using Laptop. Public, static, final interface variable value: " + piValue );
    }
}

class Desktop2 implements Computer2, SubInterface{
    public void code(){
        System.out.println("Compile and execute: fast");
    }
    public void test(){
        System.out.println("Testing code in desktop. Public, static, final interface variable value: " + piValue );
    }
    public void run(){
        System.out.println("Implementing run required for SuperInterface");
    }
    public void run2(){
        System.out.println("Implementing run required for SubInterface");
    }
}

enum Status{
    Pending, Running, Success, Failed;
}

enum CompLaptop{

    Macbook(2000), XPS(1900), Surface, ThinkPad(1800);  // All these elements are basically just objects of CompLaptop Class. So we can have default and parametrized constructors too. By default, default constructors are available. But when we specify parametrized constructors, then the class would require us to specify the default constructors explicitly. Also, since the objects are created within the class itself, the constructor can be private. Since the variuables and constructors are private, we could use getters and setters to get/set the price.

    private double price;

    private CompLaptop(){
        price = 500;
    }

    private CompLaptop(double price){
        this.price = price;
        System.out.println("In Laptop: " + this.name()); // Here, this.name would give us the name of the object. 
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}


class Parent20{
    public void showTheCurrentLocation(){
        System.out.println("In Parent Class");
    }
}

class Child20 extends Parent20{
    @Override
    public void showTheCurrentLocation(){
        System.out.println("In Child Class");
    }
}

@FunctionalInterface
interface FuncInter{ // A functional interface should have only one method. Declaring more than one abstract method would result in a compiler error. Uncomment the second method to find out the error.
    void show(int i);
    // void test();
}

class ChildFuncInter implements FuncInter{ // Instead of this we could also impkement an anonymous inner class
    public void show(int i){
        System.out.println("Implementing parent class for Functional Interface demo " + i);
    }
}

@FunctionalInterface
interface FuncInter2{
    int add(int a, int b);
}

class MyCustomException extends RuntimeException{ // Here, we are extending the parent class of Runtime Exception to handle the message given to the custom exceptions' constructor. Also, we could also extend "Exception" instead of "RuntimeException".
    public MyCustomException(String s){
        super(s); // Calling the constructor of the super class.
    }
}

class DuckExceptionDemo{ // Just a class that has a method thbat throws classNotFoundException to demonstrate exception ducking
    public void show() throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
}

class ThreadDemo1 extends Thread{
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("Hi");
            try {
                Thread.sleep(5); // we can also induce a sleep in every thread to manage their invokations/optimize it. To use, we'd have to handle InterruptedException 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ThreadDemo2 extends Thread{
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("Hello");
            try {
                Thread.sleep(2); // we can also induce a sleep in every thread to manage their invokations/optimize it. To use, we'd have to handle InterruptedException 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ParentDemo{
    public void dummy(){
        System.out.println("Dummy");
    }
}

class SubClassThread1 extends ParentDemo implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println("Hello");
        }
    }
}

class SubClassThread2 extends ParentDemo implements Runnable{
    public void run(){
        for(int j=0; j<10; j++){
            System.out.println("Hi");
        }
    }
}

class Counter1{
    public int count = 0;
    public void increment(){
        ++count;
    }
    // public synchronized void increment(){  // Use this method with the "synchronized" keyword to escape race condition.
    //     ++count;
    // }
}

class Student1{
    public int age;
    public String name;

    public Student1(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() { 
        return "Student1 [age=" + age + ", name=" + name + "]";
    }

}

class Student2 implements Comparable<Student2>{
    public int age;
    public String name;

    public Student2(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() { 
        return "Student1 [age=" + age + ", name=" + name + "]";
    }
    
    public int compareTo(Student2 objStudent2){
        if(this.age > objStudent2.age)
            return 1; // return 1 for swapping
        else if(this.age < objStudent2.age)
            return -1; // negative number for not swapping
        else
            return 0; // 0 is the values are the same.
    }
}


sealed class A1 permits B1, C2, D1{ } // Sealed class can be used if we want to restrcit the classes inheriting the current class. The classes inheriting a sealed class should be explicitly "premitted". The inheriting classes can be either sealed, non-sealed or final. 

non-sealed class B1 extends A1{ } // If the inheriting class should inturn be inheritable by any class, then, it should be labelled as non-sealed

sealed class C2 extends A1 permits F1{ } // the imheriting class can also restrict its child classes by using sealed again. Also, a sealed class must have a subclass.

final class D1 extends A1{ } // As we already know, final classes cannot be inherited by any other class.

class E1 extends B1{ } // The classes inheriting a non-sealed class need not be one among sealed, non-sealed or final.

final class F1 extends C2{ }

sealed interface Z1 permits Z2,Y1{ } // Sealed keyword can also be used by interfaces. The only difference is that the ineriting interfaces would have to be either sealed or non-sealed. Note: interfaces cannot be FINAL.

sealed interface Y1 extends Z1 permits Y2{ }

final class Z2 implements Z1{ }

final class Y2 implements Y1{ }

//Record classes
record RecordClass(int id, String name){

    // Do note that all variables inside a record class are private and final. Any non-static instance variable that needs to be defined would have to be defined as an argument to this record class. 
    // int testIns = 10; // We cannot do this as this is non-static
    static int test = 100;

    public RecordClass(){
        this(99, "Default"); // Calling this method will call the actual default constructor of the record class. This is not advisable.
    }
    
    // The following constructor is available by default. We need not mention that explicitly. This type of constructor that takes in the same number/type of arguments as the record class is called a canonical constructor.
    // public RecordClass(int id, String name){
    //     this.id = id;
    //     this.name = name;
    // }

    // The parametrized constructor can be initialized as a compact canonical constructor. In the parametrized constrcutor, we can remove the arguments and the assignment of arguments as well. The following is actually the parametrized constructor in compact canonical form.
    public RecordClass{ // THIS method calls this constructor. 
        if(id == 0)
            System.out.println("ID should not be 0");
        else
            System.out.println("ID: " + id + " Name: " + name);
    }


    // We can define other methods as required
    public void show(){
        System.out.println("ID: " + id + " Name: " + name);
    }

    public static void showStatic(){
        System.out.println(" Static variable: " + test);
    }

}


public class Hello {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        System.out.println("Hello World");
    
        int x = 9;
        int y = 8;
        int z = 10;

        int n = 5;
        int result = 0;
        
        if(x>y && x>z){
            System.out.println("x is greater");
        }else if (y>z){ // if the control comes here it means that x is not the greatest. So It's between either y or z
            System.out.println("y is greater");
        }else{
            System.out.println("z is greater");
        }

        result = (n % 2 == 0)? 10:20;
        System.out.println("Result: " + result);

        System.out.println("Switch statements -----------------------------");

        int dayNum = 1;
        switch(dayNum){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Not a valid value");
        }

        int dayNum1 = 1;
        // Switch expressions - 1
        String day = switch (dayNum1) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid Option";
        };

        System.out.println("Day:" + day);

        // Switch expressions - 2
        String day1;
        switch (dayNum1) {
            case 1, 2, 3, 4, 5 -> day1 = "Weekday";
            case 6, 7 -> day1 = "Weekend";
            default -> day1 = "Invalid Option";
        };

        System.out.println("Day:" + day1);

        // Switch expressions - 3
        
        String day2 = switch (dayNum1) {
            case 1, 2, 3, 4, 5 : yield "Weekday";
            case 6, 7 : yield "Weekend";
            default : yield "Invalid Option";
        };

        System.out.println("Day:" + day2);

        // WHILE LOOPS
        int j = 2;
        while(j <= 5){
            System.out.println("Hello!");
            j++;
        }

        // Do-while loops
        int k = 5;
        do{
            System.out.println("k: " + k);
            k++;
        }while(k < 8);

        for(int m=0; m<2; m++){
            System.out.println("M: " + m);
        }


        // Classes and Objects
        int num1 = 26;
        int num2 = 38;
        double num3 = 28.5;
        Calculator calc = new Calculator();
        int result1 = calc.add(num1, num2);
        double result2 = calc.add(num1, num3);
        System.out.println("Results: " + result1 + " " + result2);

        int nums[] = {1,2,3,4};
        System.out.println("First Element" + nums[0]);

        // Dynamic arrays
        int dynNums[] = new int[4];
        dynNums[0] = 10;
        dynNums[1] = 20;
        dynNums[2] = 30;

        for(int i = 0; i<4; i++){
            System.out.println("Values:" + dynNums[i]);
        }


        // 2D-array
        int arr2[][] = new int[3][4];
        for(int i=0; i<3; i++){
            for(int t=0; t<4; t++){
                // Populating 2-d array by first multiplying the double value obtained from random func by 10 and then type casting the decmial value to int to just obtain a single digit whole number
                arr2[i][t] = (int)(Math.random() * 10);
            }
        }
        
        // Enhanced looping
        for(int[] elem : arr2){
            for(int item: elem){
                System.out.print(item + " ");
            }
            System.out.println();
        }

        System.out.println("Jagged Array");

        // // Jagged arrays
        // A jagged array in Java is a multidimensional array where the member arrays can have different sizes. It is also known as a ragged array or an array of arrays. In a jagged array, each element is an array itself, and these sub-arrays can have different lengths or sizes.
        int jagArr[][] = new int[3][];
        
        jagArr[0] = new int[3];
        jagArr[1] = new int[2];
        jagArr[2] = new int[5];

        for(int arr[] : jagArr){
            for(int s=0; s<arr.length; s++){
                arr[s] = (int) (Math.random() * 10);
                System.out.print(arr[s] + " ");
            }
            System.out.println();
        }


        // Array of objects
        Student s1 = new Student();
        s1.rollno = 1;
        s1.name = "Aravind";
        s1.marks = 96.1;

        Student s2 = new Student();
        s2.rollno = 2;
        s2.name = "Vandana";
        s2.marks = 95.3;

        Student s3 = new Student();
        s3.rollno = 3;
        s3.name = "Chandra";
        s3.marks = 92.8;

        Student students[] = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        

        for(Student elem: students){
            System.out.println(elem.name + " : " + elem.marks);
        }
        
        // String is not a datatype but a special class
        String str = new String("Baby ladki");
        // Here "Baby" is passed to the contructor of the string class. 
        // Contructors are used to initialize the object instances of a class. It sets the properties of the class or performs functions as defined in the constructor of the class. Contructor name is same as the class name. Constructor overloading is possible.

        System.out.println("String -------------------------------------------");
        System.out.println(str.charAt(1));
        System.out.println(str.concat(", Hello"));
        System.out.println(str.contains("Baby"));
        System.out.println(str.endsWith("y"));
        System.out.println(str.equals("Baby"));
        System.out.println(str.equalsIgnoreCase("Baby"));
        System.out.println(str.indexOf("y"));
        System.out.println(str.isEmpty());
        System.out.println(str.length());
        System.out.println(str.replace("Baby", "Pyaari"));
        System.out.println(str.substring(1, 3));
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());
        System.out.println(str.hashCode());
        System.out.println(str.getClass());
        System.out.println(str.getClass().getName());
        System.out.println(str.getClass().getSimpleName());
        System.out.println(str.getClass().getPackage());
        System.out.println(str.getClass().getPackage().getName());

        System.out.println("Value in the string object reference is: " + str);
        System.out.println("Hashcode: " + str.hashCode());

        String str2 = new String();
        System.out.println("Value of an empty string: " + str2);

        // Instead of this, the JVM allows the usaage of the String class like a dataype:

        String str1 = "Pyaari";
        System.out.println("The value of the string reference is: " + str1);

        // String constannt pool - String literals are created in something called the "String constant pool" within the heap memory. So, any string literal (case sensitive) is stored in the pool and any reference to that exact string would merely refer the same memorylocation within the string constant pool. 
        /*
         * That is -> String s1 = "Aravind"; and String s2 = "Aravind"; will refer the same memory space. so (s1 == s2) is true.
         */
        /*
         * Also String are immutable. Any old string that is appended with a new string will actually create the entire new string (old + appended) in memory and the old one will be garbeage collected if it does not have any other reference to it.
         */


        // To prevent the creation of a completely new string on appending a string, we could use StringBuffer instead of String. This saves time and memory.
        StringBuffer sb = new StringBuffer("Vandana");
        System.out.println("Size of string buffer: " + sb.capacity());
        System.out.println("Length of string buffer: " + sb.length());
        sb.append(" Gupta1234567891");
        System.out.println("Size of string buffer: " + sb.capacity());
        System.out.println("Length of string buffer: " + sb.length());
        sb.append("a"); // Going above available capacity
        System.out.println("Final String = " + sb);
        System.out.println("Size of string buffer: " + sb.capacity());
        System.out.println("Length of string buffer: " + sb.length());
        sb.ensureCapacity(50); // Hover over function to know more about it
        // Ensures that the capacity is at least equal to the specified minimum. If the current capacity is less than the argument, then a new internal array is allocated with greater capacity. The new capacity is the larger of:
        // The minimumCapacity argument and 
        // Twice the old capacity, plus 2.
        // If the minimumCapacity argument is nonpositive, this method takes no action and simply returns. Note that subsequent operations on this object can reduce the actual capacity below that requested here.
        System.out.println("Size of string buffer: " + sb.capacity());
        System.out.println("Length of string buffer: " + sb.length());
        sb.setLength(25);
        System.out.println("Size of string buffer: " + sb.capacity());
        System.out.println("Length of string buffer: " + sb.length());
        System.out.println("Char at index 24: " + sb.charAt(24));

        // String Buffer is thread-safe but String Builder is not. - To be discussed later.
        System.out.println();

        System.out.println("Static Variables and Methods -------------------------------------------");
        // Static variables
        Mobile mobObj1 = new Mobile();
        mobObj1.brand = "Apple";
        mobObj1.price = 999.99;
        mobObj1.category = "iOS Smartphone";

        System.out.println("Object 1:");
        mobObj1.show();

        Mobile mobObj2 = new Mobile();
        mobObj2.brand = "Mi";
        mobObj2.price = 599.00;
        mobObj2.category = "Android Smartphone";

        System.out.println("Object 1:");
        mobObj1.show();

        System.out.println("Object 2:");
        mobObj2.show();

        // This is the correct way to access static variables (using class name directly). Static variables are present in a separate memory location. If we access static variables using object references instead of the class name, it will edit the same value. 
        Mobile.category = "NotSoSmartPhone";

        System.out.println("Object 1:");
        mobObj1.show();

        System.out.println("Object 2:");
        mobObj2.show();

        // Static methods
        // Only static variables can be directly used inside static methods. Non-static methods need to be referenced to be used properly.
        // Static methods are usually used for utility functions, conversion functions and other common functions etc. Static methods are often used to create utility functions that don't depend on the state of an object. The main method in Java is also static, which allows it to be run by the Java Virtual Machine (JVM) without instantiating an instance of the main class.
        // Too early to know, but try to figure it out: If the same static class method is defined in a subclass as well, when the method is invoked through an abject instance, the superclass method will get executed instead of the subclass method irrespective of whether the object is an instance of subclass or superclass. However, the correct method can be executed if the method is directly called using the classname - to be explained later.
        // Static methods cannot be overridden by child classes
        Mobile.show1(mobObj1);


        // Static blocks - When we try to instantiate a static variable, it is alright to do it within a constructor. But, when done so, static variables will be initialized every time an object is created. So, instead of doing this, we could instantiate static variables in something called a static block! This block is initialized when a class is loaded. 
        // It is important to note that, in a java program, when an object is being created (like in the lines below), a class loads and then its objects are created. But note that classes are loaded only once. and class loading happens inside something called a "class loader". Classes are loaded only during the first object creation. 
        Mobile2 obj5 = new Mobile2();
        Mobile2 obj6 = new Mobile2();

        // There is another way to load a class without object creation (Comment the above lines for object creation and uncomment the following line to check if class loads without object creation). To use use this, we need to add "throws ClassNotFoundException" to the current main class - More on this later.
        // Class.forName("Mobile2");
        
        System.out.println("Encapsulation-------------------------------------------------");
        // Encapsulation - In the class Human, the variables - name and age are made private. This allows the variables to only be used within that class (Human) itself. To access (set or get) the variables, we access the public methods given by the class. These public methods are usually called getters and setters. We can directly generate this in most IDEs. In VS CODE, it is right-click inside the class (with instance variables) -> Source Action -> Generate getters and setters -> Select all required variables - This will automatically generate the getter and setter functions.
        Human objHuman = new Human(); 
        objHuman.setName("Karthik");
        objHuman.setAge(55);
        int ageHuman = objHuman.getAge();
        String nameHuman = objHuman.getName();
        System.out.println(nameHuman + " : " + ageHuman);
        
        // this keyword - this keyword refers to the current object. We could bypass "this" keyword using an implementation of the function "info" shown in the class definition, by passing the created object and referring to instance variables using that. But to remove this hassle, Java has provided us with "this" keyword.
        objHuman.setInfo("tall", objHuman);

        System.out.println("Constructors--------------------------------------------------");
        //Constructor in Java
        Human obj10 = new Human();
        System.out.println(obj10.getName() + " : " + obj10.getAge()); // This will print null : 0 (If there are no default values for the instance variables)
        // We could instatiate the variables directly but that is not good practice. Contructors can be used to define a stable state of an object.

        // We could also have different parametrized constructors.
        Human obj11 = new Human("Nitheesh", 24);
        Human obj12 = new Human(26);
        
        // Naming conventions
        // Camel casing

        // Class and interfaces - Calc, Runnable
        // Variable and method - marks, show()
        // Constants - PIE, BRAND
        // Constructors - Human()

        System.out.println("Anonymous Objects-------------------------------------------------------");
        // Anonymous objects
        // We could directly create an object without actually creating a corresponding reference variable. 
        new AnonymousObject(); // This just creates an object in heap memory. But there is no reference for it. So, how do we use it?
        new AnonymousObject().show(); // ThIS CREATEs an object in heap again. and executes show method.


        System.out.println("Inheritance------------------------------------------------------------");
        // Inheritance
        // Constructing a class by Inheriting features from a parent class. Can be called as Parent/Child, Super/Sub or base/derived class.
        AdvCalc objAdvCalc = new AdvCalc(); // AdvCalc and VeryAdvCalc definitions are available as separate class files with in the same directory,
        System.out.println(objAdvCalc.add(15, 5));
        System.out.println(objAdvCalc.sub(15, 5));
        System.out.println(objAdvCalc.mul(15, 5));
        System.out.println(objAdvCalc.div(15, 5));

        // Multiple inheritance is not supported in Java. i.e A subclass c cannot inherit from both a class A and a Class B. This is done to address ambiguity. If a function with the same name is present in both class A and Class B, it would result in ambiguity i.e  Class C would not know which function to execute. 
        // But multi-level inheritance is supported. i.e Class B can extend Class A. and Class C can extend Class B.
        VeryAdvCalc objVeryAdvCalc = new VeryAdvCalc();
        System.out.println(objVeryAdvCalc.add(15, 5));
        System.out.println(objVeryAdvCalc.sub(15, 5));
        System.out.println(objVeryAdvCalc.mul(15, 5));
        System.out.println(objVeryAdvCalc.div(15, 5));
        System.out.println(objVeryAdvCalc.power(2, 3));

        System.out.println("this and super method-----------------------------------------------------");
        //This and super method
        // This and super method are available by default but are not explicitly written. Go to class definition for futher explanation
        B objB1 = new B();
        B objB2 = new B(5);

        System.out.println("Method overriding-----------------------------------------------------------");
        // Method overriding
        AdvCalc objAdvCalc2 = new AdvCalc(); // the add method in AdvCalc overrides the add method in its parent class. Unlike method overloading, overriding can make methods have the same function signature (name, no. of arguments, type of arguments, return type). 
        System.out.println("Overridden add method outupt: " + objAdvCalc2.add(5, 6));

        // Packages
        // Check out the import statements at the top for explanations.

        AdvLib1 objLib1 = new AdvLib1();
        System.out.println("Output from package: " + objLib1.intDiv(1234, 5));

        System.out.println("Access modifiers------------------------------------------------------------");
        // Access Modifiers
        // Public - can be accessed anywhere within the project (outside/inside the package)
        // Private - can only be accessed within the class. Even a subclass cannot access the private entities.
        // Protected - can only be accessed by a subclass outside the current package (directory)
        // Also the general rule is this - methods are generally public, instance variables are private. If needed to be accessed in a subclass outside the package, use protected. Also classes are present in individual files. Java does not allow us to defined 2 public classes in the same file. Do not use default access modifier - when we do not specify any access modifier - it allows the variables to be accessed from anywhere within the same package (directory). Default - private protected - more on this later.
        AdvLib1 objLib12 = new AdvLib1(555, 7);
        System.out.println("Output of division after setting instance variables: " + objLib12.intDiv());
        objLib12.printRemainder();

        System.out.println("Polymorphism-----------------------------------------");
        // Polymorphism
        // 2 types of polymorphism - 1. Compile-time polymorphism - Function overloading (During compile time, the compiler knows which function would get executed for which calls) 2. Run-time polymorphism - Function overriding (It is only when the object is created, that we know that the overridden function is going to get executed.)
        // Run time polymorphism is also called dynamic method dispatch
        // Here P is the parent, Q and R extends P. There is amethod called "show" in all these class - P,Q and R.
        P objP = new P();
        objP.show();

        // Reference of parent type (P) is assigned the object of Q. Here, method overriding occurs. A variable of a particular class type can only see the methods of that class type. If the method in that class is overridden by a child class, yes, the execution will follow the new definition. But if the ref var is of parent type and the object being assigned is a child and if the child has a completely new function, the ref var cannot see this new function.
        objP = new Q(); // Here Q's show method overrides P's show method.
        objP.show();

        // Reference of parent type (P) is assigned the object of R. Here method overriding occurs.
        objP = new R();
        objP.show();

        // Note: Static methods in the parent class cannot be overridden by child classes. Even if a reference variable of parent type is pointing to a child object, and the same static method is defined in both the child and the parent, when the parent's reference variable is used to execute the static method, the parent's implementation will get executed. But for normal methods, the child's method will get executed due to function overriding. Therefore, static methods do not exibit polymorphism and do not participate in function overriding.

        P objP5 = new Q();
        objP5.show1(); // Parent's implementation of show1 is executed. That is why it is always recommended to use static methods using the classname.

        System.out.println("Final Keyword----------------------------------------------");
        // Final keyword
        // Final keyword can be used with a variable to make it a constant, with a method to stop method overriding and with a class to stop inheritance.
        //  Check out Computer, Laptop and Hp class for explanations.

        System.out.println("Hashcodes, toString methods and equals methods -------------------------------- ");
        // Generating hashcodes, toString and equals. Value of object itself.
        TestHashCodeGenerators objCodeGenerators = new TestHashCodeGenerators();
        System.out.println("Printing the value of an object " + objCodeGenerators); // Directly printing the value of an object prints -> "Classname" + "@" + "hashcode of the class". It is also important to note that the parent class of any class is the "Object" class. It applies toString() on top of the generated String of "Classname" + "@" + "hashcode of the class". So, we could actually override the toString() method to generate our own value.

        TestHashCodeGenerators2 objCodeGenerators2 = new TestHashCodeGenerators2();
        System.out.println("Printing the value of an object with overridden methods: " + objCodeGenerators2); // After overriding the toString methods.

        TestHashCodeGenerators2 objCodeGenerators3 = new TestHashCodeGenerators2();

        //Setting the values of all variables within both the objects of TestHashCodeGenerators2 class to be equal. 
        objCodeGenerators2.name = "Babe";
        objCodeGenerators2.value = 100;

        objCodeGenerators3.name = "Babe";
        objCodeGenerators3.value = 100;

    
        System.out.println("Checking if both the objects are equal: " + objCodeGenerators2.equals(objCodeGenerators3));
        // Although all the instance variables are equal, the above result gives false because, the default equals method generates a unique hashcode using all the values. Basically, if it is not the same object, it will return false.Sooo, let's implement our own equals method.

        System.out.println("Checking if both the objects are equal - 2 : " + objCodeGenerators2.equals2(objCodeGenerators3));

        // There is a better way to check equals and hashcodes and object value printing. that is given by default within IDEs. Go to class -> right click -> Source Action -> Generate hascodes/equals and Generate toString(). See implementation in the class below:
        
        AutoGenerate objAutoGenerate1 = new AutoGenerate();
        AutoGenerate objAutoGenerate2 = new AutoGenerate();

        objAutoGenerate1.name = "Aravind";
        objAutoGenerate1.value = 10;

        objAutoGenerate2.name = "Aravind";
        objAutoGenerate2.value = 10;

        System.out.println("to string method: " + objAutoGenerate1);
        System.out.println("Equals check: " + objAutoGenerate1.equals(objAutoGenerate2));

        System.out.println("Upcasting and downcasting--------------------------------");
        // Upcasting and Downcasting
        // If we have the same method (same signature) in a parent and a child class, if the reference variable is of type child/parent, the method that will actually get executed depends on the object type. But do note that this is possible only if the method name and signature are the same.
        // If the reference type is of parent, we cannot execute the child's methods (when there are different methods (with diff names and signatures)). To do that, you have to create a new reference of the child type and type cast the parent's reference variable to the child's type. Basically, the type of the reference variable determines the methods that we could access. Parent's reference variable will only see parent's scope of methods. A child's reference variable will be able to see the child's scope of methods. Here we could argue that we can assign a parent object to a child's reference variable. But NO, we cannot assign a parent's object to a child's reference variable because the child's reference type should be able to execute all child methods and variables, but if we assign a parent object to it, the child reference will not be able to find the implementation of all the child's methods. Hence, Java does not even allow us to do this.
        P1 objP1 = new P1();
        objP1.show1();
        objP1.tell();

        P1 objP2 = new C1(); // When we do this, implicit typecasting is performed. Implicitly, the C1's object is type casted to P1. - Upcasting
        objP2.show1();
        objP2.tell();

        // Typecasting parent object to child
        C1 objC1 = (C1) objP2; // Downcasting
        objC1.show1();
        objC1.show2();
        objC1.tell();

        // C1 objC2 = new P1(); // As discussed before, we cannot assign a parent object to a child's reference variables.
        // objC2.show1();
        // objC2.show2();
        // objC2.tell();

        System.out.println("Boxing and Unboxing ---------------------------------------");
        // Boxing and Unboxing 
        int no1 = 5;
        // Integer objInteger = new Integer(5); // This is deprecated (and hence will produce a warning). Nonetheless, assigning a primitive type to a (wrapper) object is called boxing.
        Integer objInteger1 = no1; // This also achieves boxing and is called "auto-boxing".

        int no2 = objInteger1.intValue(); // Getting a primitive value from an object - Unboxing
        int no3 = objInteger1; // Same as above, but called "auto-unboxing"

        String s11 = "12"; // Number stored as string
        int no4 = Integer.parseInt(s11);

        System.out.println("Parsed Integer: " + no4);
        
        System.out.println("Abstract Keyword ---------------------------------------------");
        // Abstract Keyword
        // If we do not want/can't define a method within a class, we can simply declare an abstract method and make the class abstract as well. Do note that abstract classes need not have abstract methods. But if there is going to be an abstract method defined in a class, the class must be abstract. Also, we cannot create an object out of an abstract class (Except if we are implementing anonymous classes - more on this later.). We have to create a non-abstract concrete class by extending an abstract class to create an object out of it.
        // Car objCar = new Car(); - Cannot instiate an abstract class! 
        HondaCityUpdated car1 = new HondaCityUpdated();
        car1.drive();
        car1.laneDetector();
        car1.camera();
        
        System.out.println("Inner class --------------------------------------------------");
        // Inner class
        Outer objOuter = new Outer();
        objOuter.show();

        Outer.Inner objInner = objOuter.new Inner(); // To use an inner class, the reference variables should be of type outer.inner instead of inner. To access any item of a class, we need referenceVariableOfObject.(entity), right? Similarly, to create an object of the inner class, prepend the object creation with "Reference variable of outer class."
        objInner.show();

        Outer.InnerStat objStaticInner = new Outer.InnerStat(); // Static class can be accessed directly using the classname instead of the reference variable of its object.
        objStaticInner.show();

        System.out.println("Anonymous classes ---------------------------------------------------");
        // Anonymous classes 
        // Instead of creating a another class to override the methods of a parent class, if it just a one-time use, we could override the methods of the parent class using anonymous classes.
        Outer objOuter2 = new Outer(){
            public void show(){
                System.out.println("Overriding the show method of outer class.");
            }
        };

        objOuter2.show();

        
        // Using anonymous classes with abstract classes
        Car objCar = new Car() { // Here, we are creating an anonymous class to instantiate an abstract class by defining the abstract methods within the class.
            public void laneDetector(){
                System.out.println("Lane detection logic");
            }

            public void camera(){
                System.out.println("Camera logic");
            }
        };

        objCar.laneDetector();
        objCar.camera();


        System.out.println("Interfaces ------------------------------------------------");
        // Need for Interfaces
        // Here, we have implemented a class called developer. It has a method called "develop". A developer needs a laptop or a desktop to develop. If we pass - a reference to the laptop or desktop object - that is of type laptop or desktop, then we would have to accept the reference of that particular type inside the method definition as well. So, essentially , we would be binding the type to the class. To avoid that, we have created the reference to the parent's type - Computer so that we could pass Laptop or Desktop to the develop method. In such cases where the type needs to be common, we could implement interfaces. Refer the next example.
        Computer1 lap = new Laptop1();
        Computer1 desk = new Desktop1();

        Developer dev1 = new Developer();
        dev1.develop(desk);
        dev1.develop(lap);
        

        // Interfaces
        // Things to note: All the methods declared within an interface are, by default, public and abstract. Methods are not usually defined. If they need to be defined, it will be prefixed with the 'default' keyword. Any class that is implementing the interface could override the default implementation of the method. Static methods can also be defined within an interface. Remember - static methods cannot be overridden.  All the variables defined within an interface are public, static and final. This means that they can be accessed directly using the classname but they cannot be modified. They are basically constants. 
        // Essentially the interfaces are merely contracts that are extended to its implementing classes that state that all abstract methods must be defined in the implementing classses and the variables cannot be modified in the implementing classes. Also, default methods we introduced only from Java 8.
        // One interface can extend another interface. But again - only abstract methods and static, final vars can be declared. 
        // One class can implement mulitple interfaces. (But one class cannot extend muliple classes.). If a class is implementing multiple interfaces, then, according to the contract, it must define all the abstract methods of that interface and its parent interface.
        Computer2 objLaptop2 = new Laptop2();
        Computer2 objDesktop2 = new Desktop2();

        Developer2 objDeveloper2 = new Developer2();
        objDeveloper2.develop(objLaptop2);
        objDeveloper2.develop(objDesktop2);


        SubInterface objDesktop3 = new Desktop2();
        Developer2 objDeveloper22 = new Developer2();
        objDeveloper22.run(objDesktop3);

        Desktop2 objDesktop4 = new Desktop2();
        objDesktop4.code();
        objDesktop4.deploy();
        objDesktop4.test();
        objDesktop4.run();
        objDesktop4.run2();

        /*
         * When should we use an abstract class and when should we use an interface?
         * The choice between using an abstract class and an interface depends on the specific requirements and design considerations of your application. 
         * 
         * Here are some scenarios where an abstract class is more suitable:

            - Inheritance and common implementation: If you want to provide a common base class implementation to derived classes, an abstract class is a good choice. Abstract classes can define common behavior and state that can be inherited by the subclasses. This promotes code reuse and provides a structured approach to class hierarchies.
            - Partial implementation: Abstract classes can have non-abstract methods with an implementation. This allows you to provide default behavior that can be inherited by the subclasses. Subclasses can choose to override these methods if needed, but they are not required to do so. This is useful when you want to provide a default implementation that can be optionally customized by the subclasses.
            - Adding new methods in the future: If you anticipate the need to add new methods to your abstraction in the future, an abstract class is a better choice. Adding a new method to an abstract class does not require changes to the existing implementations. However, if you add a new method to an interface, all classes implementing that interface will need to provide an implementation for the new method.
            - Versioning and backward compatibility: Abstract classes allow better forward compatibility. You can add new methods to an abstract class without breaking the existing code that extends the class. On the other hand, interfaces cannot be changed once created. If a new version of an interface is required, a whole new interface must be created.

            Interfaces, on the other hand, are more suitable in the following scenarios:

            - Providing common functionality to unrelated classes: If you want to define a common set of methods that can be implemented by unrelated classes, an interface is the way to go. Interfaces allow classes from different inheritance hierarchies to share a common behavior.
            - Achieving full abstraction: Interfaces provide full abstraction as all methods are abstract and do not have any implementation. This allows for loose coupling and flexibility in the design of classes.
            - Multiple inheritance-like behavior: Since a class can implement multiple interfaces, interfaces provide a way to achieve a form of multiple inheritance in Java. This allows a class to inherit and implement behavior from multiple unrelated sources.
            - Designing small, concise functionality: If you are designing small, concise bits of functionality, interfaces are more appropriate. Interfaces provide a way to define a contract for a specific behavior without specifying any implementation details.
         */

         /*
          * Also note that we could create an abstract class that implements the interface and provides default implementations for some of the methods. Then, any subclass of this abstract class will be required to implement the remaining methods of the interface.
          */

        // Enum - Enum is like a class and the elements in it are its objects.
        System.out.println("");
        System.out.println("Value of current status: " + Status.Running);

        Status s = Status.Failed;
        Status[] statusList = Status.values();
        for(Status stat: statusList){
            System.out.println("Stat value: " + stat + " : " + stat.ordinal());
        } 
        
        if(s == Status.Running){
            System.out.println("All good baby!");
        }else if(s == Status.Failed){
            System.out.println("It has Failed!");
        }else if(s == Status.Pending){
            System.out.println("Wait for some more time!");
        }else{
            System.out.println("Success");
        };

        switch(s){
            case Failed:
                System.out.println("It has failed!");
                break;
            case Running:
                System.out.println("All good baby!");
                break;
            case Pending:
                System.out.println("Wait please");
                break;
            default:
                System.out.println("Success");
        };

        // More on Enums
        System.out.println("Default Price value from default constructor: " + CompLaptop.Surface.getPrice());
        for(CompLaptop compLap: CompLaptop.values()){
            System.out.println("Laptop name: " + compLap + ". Price: " + compLap.getPrice());
        }

        System.out.println("Setting price for Macbook...");
        CompLaptop.Macbook.setPrice(2500);
        System.out.println("New Macbook price: " + CompLaptop.Macbook.getPrice());

        System.out.println("");

        // Annotations
        // Annotations help us by using the copmiler to let us know a few things during compile time. For example, if we use @Overrise above a child method that is supposed to override a parent method, then, if we, say, accidentally specify the incorrect method name in the child class, the compiler would immediately let us know about that issue. This is also useful during code maintenance. 
        Child20 objChild20 = new Child20();
        objChild20.showTheCurrentLocation(); // Now try changing the method name of the child class. Compiler should give an error right away. VSCode would also detect it.


        // Functional interface
        // Functional interface is an interface with just one method. We have an annotation for that as well.
        FuncInter objFuncInter = new ChildFuncInter();
        objFuncInter.show(10);
        FuncInter objFuncInter2 = new FuncInter() { // Instead of the above line where a child overrides the parent's method's implementation, we could also use anonymous inner class as shown below. But the most effective way to define and override a method in the case of functional interfaces is Lambda Expressions.
            public void show(int i){
                System.out.println("Implementing an anonymous inner class for the method in a functional interface " + i);
            }
        };
        objFuncInter2.show(5);

        // Lambda expressions
        FuncInter objFuncInter3 = (int i) -> { // The above implementation using anonymous inner classes can be easily executed using lambda expression as shown here. Here we have removed the object creation part and the method name since all this is easily inferred as there is only one method and to create an anonymous class we would have to initiate the actual parent object. Lambda expression help us by skipping all these. 
            System.out.println("Inside lambda expression " + i);
        };

        objFuncInter3.show(25);

        // In fact the above code can be written in the following manner:
        FuncInter objFuncInter4 = i -> System.out.println("Inside Lambda expression 2: " + i); // As u can see, data types are not required.
        objFuncInter4.show(50);

        // Let us now see how we could express multiple arguments and return statements in lambda expressions.
        FuncInter2 objFuncInter21 = (a,b) -> a+b; 
        int funcInter2Result = objFuncInter21.add(10,20);
        System.out.println("Result from lambda expression with functional interface: " + funcInter2Result);

        // Types of interfaces
        /*
         * 1. Normal Interface - More than 1 abstract method
         * 2. Functional interface (SAM) - Single Abstract Method interface - a single abstract method
         * 3. Marker interface - By implementing a marker interface, a class can indicate that it belongs to a specific category or has a particular behaviour.
         */

        System.out.println("");

        //  Types of Errors:
        /*
         * 1. Compile-time errors 
         * 2. Run-time errors - Exceptions
         * 3. Logical errors
         */

        int p = 5;
        int q = 35;
        int r;

        int except[] = new int[5];
        String str20 = null;

        try {
            r = q/p;    
        //    System.out.println("Length: " + str20.length());
        //    System.out.println(except[5]);
            System.out.println("Successful! ");
        } catch(ArithmeticException e){ // All these exceptions are derived from the class "RunTimeException" whose parent is "Exception" whose parent is "throwable"
            System.out.println("Do not divide by 0: " + e);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Out of limits: " + e);
        }catch(NullPointerException e){
            System.out.println("Operations on Null pointer: " + e);
        }catch (Exception e) { // Always have the last exception in the end or else this will get caught before other specific catch blocks.
            System.out.println("Something's fishy here!... " + e);
        }
        
        System.out.println("Some sentence after try-catch block");

        /*
         * Exceptions:
         * 
         * Every class in Java extends object class
         * Below this we have "throwable". Most of the entities that end in "able" in Java are interfaces. But in this case, it is a class.
         * There are 2 children below throwable -> 
         * 1. Error - It will simply stop the execution (can;t be handled) - Thread death, OOM error, Virtual machine error, IO ERROR
         * 2. Exception - 
         *  2.1 Unchecked exception - Runtime exception - Arithmetic, ArrayIndexOutOfBounds, Null Pointer etc. - We can handle it based on our choice.
         *  2.2 Checked exception - SQLException, IO Exception etc. - We are made to forcefully handle the exception by the compiler.
         * 
         * 
         */

        //  throwing exceptions

        try {
            r = q/p;
            if(r == 7){
                throw new ArithmeticException("Just trying to throw exception intentionally");
            }
        } catch(ArithmeticException e){
            System.out.println("Arithmetic exception encountered: " + e); 
        }catch (Exception e) {
            System.out.println("Other exceptions: " + e);
        }


        // Custom exceptions
        try {
            throw new MyCustomException("Testing my custom exception");
        }catch(MyCustomException e){
            System.out.println("Got my custom exception: " + e);
        }catch (Exception e) {
            System.out.println("Other exceptions: " + e);
        }


        //Ducking Exceptions
        // Ducking exception is nothing but avoiding exception and let the parent method/class to handle the thrown exception. If a method is ducking an exception, then, the method name should have the suffix - throws <exception_name>.
        // Make sure that the main method does not duck exceptions coz the ducked expections from main method is forwarded to the JVM and it simply stops the execution and prints the exception in the console.
        // Here, we use "throws", not "throw"
        DuckExceptionDemo objDuckExceptionDemo = new DuckExceptionDemo();
        try{
            objDuckExceptionDemo.show();
        }catch(ClassNotFoundException e){
            System.out.println("Exception - Class not Found!: " + e);
        }

        /*
         * Interesting things about System.out.println -> println is a method inside a class called "PrintStream". out is an object of the PrintStream Class. out is initiated as a static variable/object within the System class. 
         */
        // ************************ Uncomment start - User input***************************************
        // System.out.println("Enter a number: "); 
        // int userInput = System.in.read(); // When we use this, we would have to catch or duck a checked exception - IOException
        // System.out.println("Input read from user: " + userInput); //Provides the ASCII value of the user input.
        // System.out.println("Input read from user: " + (userInput - 48)); // Trying to determine the actual value from the ASCII value. But only character at a time.

        // while(System.in.available() != 0){
        //     System.in.read();
        // }
        // // System.in.close(); - Do not close the input stream yet. We are going to use it again for other methods of reading user input.
        // System.out.println("Enter a number: "); 
        // // System.in.read is just for reading one char at a time. But the one below is for reading streams of input. 
        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in);

        // int inputNum = Integer.parseInt(bf.readLine()); // the read line method of the bufferedStream class reads a line until the first new line of carriage return. The returned output is a string. So we parse it using wrapper class methods to convert it to int. aa
        // System.out.println("Obtained input from buffered reader: " + inputNum);
        
        // // There is still a better way to read user input.
        // System.out.println("Enter a number: "); 
        // Scanner sc = new Scanner(System.in);
        // int numScan = sc.nextInt(); // The nextInt method does not consume the newline characted leaving it in the input stram. When we subsequently call nextLine(), it reads the remaining newline character as an empty string and moves to the next line. 
        // System.out.println("Obtained input from scanner: " + numScan);

        // sc.nextLine();

        // System.out.println("Enter a string:");
        // String text = sc.nextLine();
        // System.out.println("Text: " + text);

        // sc.close(); 
        // bf.close(); // Closing the bufferred reader closes the underlying inpout stream. Always close the input stream only after all required scanning is done.
        // ************************ Uncomment end - User input***************************************

        // Try-catch-finally
        // BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     System.out.println("Enter some string: ");
        //     String test = bf1.readLine();
        //     System.out.println("Input entered: " + test);
        // }catch(Exception e){
        //     System.out.println("Caught an exception: " + e);
        // }finally{
        //     System.out.println("Something to be executed no matter what if an exception is caught or not!");
        //     bf1.close(); // Finally is usually used to close open resources.
        // }

        // We could execute the above code in a different manner
        // System.out.println("Enter a string: ");
        // try(BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in));){ // We can instantiate any resource who parent is AutoCloseable here.
        //     String test1 = bf2.readLine();
        //     System.out.println("Input entered: " + test1);
        //     bf2.close();
        // }catch(Exception e){
        //     System.out.println("Exception caught: " + e);
        // }

        // Threads
        // A thread is basically the smallest unit of a software.
        // For a class to become a thread, we would have to extend the Thread class and then create a method called run() inside the 'Thread' (class). The thread is started by invoking using Classname.start() - This will invoke the run method. Threads are run by the "scheduler" within the OS. 
        ThreadDemo1 objThreadDemo11 = new ThreadDemo1();
        ThreadDemo2 objThreadDemo21 = new ThreadDemo2();
        
        System.out.println("Thread priority: " + objThreadDemo11.getPriority()); // Every thread has a priority. Priority ranges from 1-10. By default, the priority is set to 5. 
        objThreadDemo21.setPriority(Thread.MAX_PRIORITY); // We can also set a thread's priority using this method that takes an integer as input. The values are available as predefined variables to the Thread class. This is merely a suggestion to the scheduler. It is not necessary for the scheduler to prioritize this above all threads. But if multiple threads arrive at the exact some momemt, the scheduler will give a higher priority to the thread with a high priority.
        // objThreadDemo11.setPriority(9); 

        // Uncomment to test threads
        // objThreadDemo11.start();
        // objThreadDemo21.start();

        System.out.println("*****************************************************");
        // The above method extends a class called Thread to create a Thread. But, what if we need to create a Thread out of a subclass. A subclass already extends another class. Mulitple inheritance is not supported in Java. So, a subclass cannot extend 2 classes at the same time. Enter - Interface - Runnable
        // There are mulitple ways of executing threads actually. We could use an predefined interface called Runnable. The Thread class itself, implements the Runnable interface. Also, there is a constructor within the Thread class that takes in the Runnable object as an input.
        Runnable objRunnable1 = new SubClassThread1();
        Runnable objRunnable2 = new SubClassThread2();

        Thread objThreadRunnable1 = new Thread(objRunnable1);
        Thread objThreadRunnable2 = new Thread(objRunnable2);

        // Uncomment to test threads
        // objThreadRunnable1.start();
        // objThreadRunnable2.start();
        
        // There is actually another way to do this! - Using anonymous classes. Note that the Runnable interface is a functional interface. We could also convert the anonymous class to a lambda expression.
        Runnable objRunnableNext1 = new Runnable() { // without using lambda expression
            public void run(){
                for(int i=0; i<10; i++){
                    System.out.println("Hi");
                }
            }
        };

        Runnable objRunnableNext2 = () -> { // Using lambda expressions.
                for(int i=0; i<10; i++){
                    System.out.println("Hello");
                }
            };

        Thread objThreadNext1 = new Thread(objRunnableNext1);
        Thread objThreadNext2 = new Thread(objRunnableNext2);

        objThreadNext1.start();
        objThreadNext2.start();

        // Race condition
        // Here the counter is being called 1000 times by each thread. So, ideally it should be called 2000 times.

        Counter1 counter1 = new Counter1();
        Runnable objRace1 = () -> { 
            for(int i=0; i<1000; i++){
                counter1.increment();
            }
        };

        Runnable objRace2 = () -> { 
            for(int i=0; i<1000; i++){
                counter1.increment();
            }
        };

        Thread objThreadRace1 = new Thread(objRace1);
        Thread objThreadRace2 = new Thread(objRace2);

        objThreadRace1.start();
        objThreadRace2.start();

        try{
            objThreadRace1.join(); // This is done so that the count value that it printed after this try-catch is printed after the execution of both of the threads.
            objThreadRace2.join();
        }catch(InterruptedException e){
            System.out.println("Exception found: " +e);
        }

        System.out.println("Count value: " + counter1.count);

        /*
         * The counter in the above code is not consistently called 2000 times because of a race condition. A race condition occurs when multiple threads access and modify shared data concurrently, leading to unpredictable and inconsistent results.

            In the above code, two threads (objThreadRace1 and objThreadRace2) are incrementing the counter (counter.increment()) in a loop. However, due to the concurrent execution of these threads, the following scenario can happen:

            Thread 1 reads the current value of the counter (let's say it's 0) into its local memory.
            Thread 2 reads the current value of the counter (still 0) into its local memory.
            Both threads increment their local copy of the counter (Thread 1 increments from 0 to 1, Thread 2 also increments from 0 to 1).
            Both threads write their incremented value back to the counter.
            The final value of the counter is 1 instead of 2.
            This race condition leads to an inconsistent count, and you may observe different results each time you run the code.

            To fix this issue and ensure the counter is called exactly 2000 times, you need to synchronize access to the shared Counter method. Synchronization ensures that only one thread can access the shared resource at a time, avoiding race conditions. 
            To enable synchronized access to a method, prefix the method declaration with "synchronized".
         */

        //  Thread states
        /*
         * 1. New - When a new thread is created
         * 2. Runnable - On thread.start() but before the scheduler start the thread's execution
         * 3. Running - When the scheduler starts the execution
         * 4. Waiting - When wait or sleep is called. From here, it will again go into Runnable state before going into running state
         * 5. Dead - After the thread's execution or when stop() is called when the thread is in running or runnable state. Stop is deprecated - DO NOT USE.
         */

        /**
         * Collection API - Collection APIs are a list of APIs available to use data structures
         * Collection - Interface
         * Collections - Classes
         * 
         * The collection interface is extended by a few other interfaces namely:
         * 1. List:
         *     Class implementations:
         *      1. ArrayList
         *      2. LinkedList
         * 2. Queue:
         *      Class implementations:
         *      1. DeQueue
         * 3. Set:
         *      Class implementations:
         *      1. HashSet
         *      2. Linked HashSet
         *  4. Map 
         *
         *  */         

        Collection numsCollection = new ArrayList();
        numsCollection.add(1);
        numsCollection.add(5);
        numsCollection.add(25);
        numsCollection.add(35);
        // numsCollection.add("45"); // This will give us a runtime error "HERE"
        
        
        System.out.println("Arraylist: " + numsCollection);
        for(Object objItem: numsCollection){
            int num = (Integer)objItem; // Runtime exception "HERE" because String cannot be cast to an integer.
            System.out.println("Object typecast to an integer: " + num);
        }
        
        // To avoid the above issue generics were used. By mentioning the datatype of the elements in a collection beforehand, we can make sure that the issue, if any, occurs during compile time. Also, the type need not be specified on the right side (near object creation since Java 1.7). But it is always better to specify it coz if we are creating anonymous classes, it is necessary to mention it. So, to avoud confusion, specify it always.

        Collection<Integer> numsCollection1 = new ArrayList<Integer>();
        numsCollection1.add(1);
        numsCollection1.add(5);
        numsCollection1.add(25);
        numsCollection1.add(35);
        //numsCollection1.add("45"); // This will give us a compile time issue since we are trying to push a string in the place of an integer. 
        
        
        System.out.println("Arraylist: " + numsCollection1);
        for(int numInCollection: numsCollection1){
            System.out.println("Integer: " + numInCollection);
        }

        // But the above will not let us perform normal array operations using an index. For this, instead of collections, we could use the List interface

        List<Integer> numsList = new ArrayList<Integer>();
        numsList.add(1);
        numsList.add(5);
        numsList.add(25);
        numsList.add(35);
        //numsList.add("45"); // This will give us a compile time issue since we are trying to push a string in the place of an integer. 
        
        
        System.out.println("Arraylist: " + numsList);

        System.out.println("Index of 5: " + numsList.indexOf(5));
        System.out.println("Num at index 3: " + numsList.get(3));

        for(int numInList: numsList){
            System.out.println("Integer: " + numInList);
        }

        // Sets - hashset - No duplicate values, but not sorted
        Set<Integer> numsSet = new HashSet<Integer>();
        numsSet.add(11);
        numsSet.add(52);
        numsSet.add(25);
        numsSet.add(36);
        numsSet.add(11);

        for(int setElem: numsSet){
            System.out.println("HashSet elements: " + setElem);
        }
        
        // Sets - hashset - No duplicate values, also sorted
        Set<Integer> numsTreeSet = new TreeSet<Integer>();
        numsTreeSet.add(11);
        numsTreeSet.add(52);
        numsTreeSet.add(25);
        numsTreeSet.add(36);
        numsTreeSet.add(11);

        Iterator<Integer> values =  numsTreeSet.iterator(); // We can use an iterator to loop through 

        // for(int setElem: numsTreeSet){
        //     System.out.println("HashSet elements: " + setElem);
        // }
        // Another way to iterate through s set of any kind:
        while(values.hasNext()){
            System.out.println("TreeSet Elements: " + values.next());
        }

        // Note: in sets, we cannot work with indices.

        System.out.println("HashMap:");
        // HashMap and HashTable
        Map<String, Integer> studentsMap = new HashMap<>();

        studentsMap.put("Aravind", 91);
        studentsMap.put("Kaavyan", 96);
        studentsMap.put("Vandana", 98);
        studentsMap.put("Sanjana", 93);

        System.out.println("Map details: " + studentsMap);

        System.out.println("Map keys: " + studentsMap.keySet()); // keySet method is used to get the list of keys in a map
        System.out.println("Map values: " + studentsMap.values()); // Values function is used to obtain the list of values present in the map's keys.

        System.out.println("Marks obtained by Aravind: " + studentsMap.get("Aravind"));

        for(String key: studentsMap.keySet()){
            System.out.println(key + " : " + studentsMap.get(key));
        }

        System.out.println("Hashtable: ");
        // Hashtable is a form of synchronized hashmap(). Remember - synchronized methods for threads.
        Map<String, Integer> students1 = new Hashtable<>();

        students1.put("Aravind", 91);
        students1.put("Kaavyan", 96);
        students1.put("Vandana", 98);
        students1.put("Sanjana", 93);

        System.out.println("Map details: " + students1);

        System.out.println("Map keys: " + students1.keySet());
        System.out.println("Map values: " + students1.values());

        System.out.println("Marks obtained by Aravind: " + students1.get("Aravind"));

        for(String key: students1.keySet()){ 
            System.out.println(key + " : " + students1.get(key));
        }

        // Sorting a list using collections class
        List<Integer> objList1 = new ArrayList<Integer>();
        objList1.add(38);
        objList1.add(25);
        objList1.add(100);
        objList1.add(7);

        Collections.sort(objList1);
        System.out.println("Sorted Integer List: " + objList1);
        Collections.reverse(objList1);
        System.out.println("Reversed Integer List: " + objList1);

        // Using comparator to create a custom sorting function for a list of objects.
        List<Student1> studList = new ArrayList<Student1>();
        studList.add(new Student1(29, "Aravind"));
        studList.add(new Student1(35, "Vandana"));
        studList.add(new Student1(26, "Santosh"));
        studList.add(new Student1(23, "Shiva"));

        // Comparator<Student1> com = new Comparator<Student1>() {
        //     public int compare(Student1 stud1, Student1 stud2){ // It is necessary to override the compare method and define a custom sorting function. In this method, we just need to mention a condition that returns 1 when it is required to swap when comparing 2 elements and returns -1 when the swap is not required.
        //         if(stud1.age > stud2.age)
        //             return 1;
        //         return -1;
        //     }
        // };

        // The above method can also be written in the following manner:
        Comparator<Student1> com = (stud1, stud2) -> (stud1.age > stud2.age)?1:-1;

        Collections.sort(studList, com);

        System.out.println("Student List: " + studList);

        for(Student1 stud: studList){
            System.out.println("Student details: " + stud); // Directly printing the Object to get the custom return value. Remember that overriding the toString method within a class allows us to return anything on printing the object.
        }

        // But note that we'd have to create a custom sorting method and pass the object of that class(comparator) to the Collections class to actually sort the objects. But while sorting an integer list, we did not pass any such object. We simply did -> Collections.sort(list). To do the same for an ArrayList containing a list of objects, we could use a class called comparable.

        List<Student2> studList2 = new ArrayList<Student2>();
        studList2.add(new Student2(29, "Aravind"));
        studList2.add(new Student2(35, "Vandana"));
        studList2.add(new Student2(26, "Santosh"));
        studList2.add(new Student2(23, "Shiva"));

        System.out.println("List before sorting using comparable: " + studList2);

        for(Student2 stud2:studList2){
            System.out.println(stud2.name + " : " + stud2.age);
        }

        Collections.sort(studList2);

        System.out.println("List after sorting using comparable: " + studList2);

        for(Student2 stud2:studList2){
            System.out.println(stud2.name + " : " + stud2.age);
        }

        // Stream API
        // We can define an array in the following manner instead of using ArrayList
        List<Integer> list1 = Arrays.asList(4,5,7,3,2,6);

        // We could use a normal or enhanced for-loop to iterate through the array. There is another option - forEach. Let's explore that
        
        Consumer<Integer> con = new Consumer<Integer>() { // Consumer is an interface that is used to define methods to be passed as arguments or assigned to variables. It is a functional interface. So, the only method that needs definition is accept. It accepts an argument and does not return any value. 
            public void accept(Integer n){
                System.out.println(n);
            }
        };

        list1.forEach(con); // The forEach method takes a "consumer" object. 

        System.out.println("Same, but in a different implementation: ");
        // The above implementation can also be written in the following manner using lambda expressions and by replcaing the con object with its actual implementation inside the forEach method.
        list1.forEach(itm -> System.out.println(itm));

        // Streams
        // Streams are used to create a temporary stream of data. Once we have worked on a stream, we cannot re-use it.
        // Streams encourage a functional programming style that is extremely useful for comprehension. 
        Stream<Integer> stream1 = list1.stream();
        Stream<Integer> stream2 = stream1.filter(elem -> elem%2==0);
        Stream<Integer> stream3 = stream2.map(elem1 -> elem1*2);
        int streamResult = stream3.reduce(0, (c,e) -> (c+e));

        System.out.println("The result of stream: " + streamResult);

        // We coud re-write the above code in the following manner:
        int streamResult1 = list1.stream()
                                        .filter(elem -> elem%2==0) // The function inside should return a boolean
                                        .map(elem1 -> elem1*2) // The function inside should return an expression/value.
                                        .reduce(0, (c,e) -> (c+e)); // First argument: Initial value. Second Argument: Function that takes in two elements at a time and returns a value for after evaluating the required pair of values.

        System.out.println("Result of chaining methods of Stream API: " + streamResult1);

        // Just like the case of forEach, each of the above methods - Filter, map and reduce take special (usually functional) interfaces as arguments. The implementation of these interfaces and passing the object references to these interfaces will yield the same result as shown above as the above implementation is just a reduction of their respective interfaces implementation. 
        // Do note that filter and map will work on the same stream but the reduce method returns a value of a certain type.
        
        // There is a stream method to sort elements as well.
        Stream<Integer> streamList = list1.stream()
                                            .filter(elem2 -> elem2%2==0)
                                            .sorted();

        streamList.forEach(ele -> System.out.println(ele));

        // We can even create mutiple threads to use the stream methods but beware coz sorting generally requires the entire list ot work with. If methods execute on multiple parallel streams, those streams will be individually sorted.

        Stream<Integer> stream4 = list1.parallelStream()
                                        .sorted();

        System.out.println("Sorted parallel stream (bound to errors): ");                                    
        stream4.forEach(arrElem -> System.out.println(arrElem));

        Stream<Integer> stream5 = list1.stream()
                                        .sorted();

        System.out.println("Sorted non-parallel stream (works): ");                                    
        stream5.forEach(arrElem -> System.out.println(arrElem));


        // Var Keyword - available from Java 10.
        // It should used only for local variables (where the variables are used for processing). Cannot be used for instance variables. 

        var test = 10;
        var temp = 12.456;
        var resp = "Thank you";
        
        // var test; // We cannot declare variables using var without initializing it with a value.

        int numsArr[] = new int[20];

        // var numsArr1[] = new int[10]; // We cannot include [] as a suffix to a var variable.
        var numsArr1 = new int[10];

        var objStudent99 = new Student(); // We can use a var to even assing a class object to it.

        // Sealed classes - Available from Java 17
        // Basically, using sealed classes, we can restrict the classes that can inherit a parent class. 
        // Checkout class definitions for - A1, B1, C2, D1, E1, F1, Z1, Y1

        // Record classes - Record classes are also called data carrier classes. In a normal class, we would have to create getters/setters, toString method to print object values and equals method to evaluate just the values of the objects based on the values of the instance variables. But record classes offer all this by default.
        // Record classes provide us with parametrized constructors without even defining one. Go to the class definition to checkout how diffrently it's defined. 
        RecordClass objRecordClass1 = new RecordClass(1, "Aravind");
        RecordClass objRecordClass2 = new RecordClass(1, "Aravind");

        System.out.println(objRecordClass1.equals(objRecordClass2));
        System.out.println(objRecordClass2); // A default toString method is also provided by the record class.

        // We can also defined a default constructor (with no parameters) inside a record class. 
        RecordClass objRecordClass3 = new RecordClass();

        RecordClass objRecordClass4 = new RecordClass(0, "Vandu");
        

                            
    }
}