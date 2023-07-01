package com;

public class Lib1 {

    private double dividend;
    private double divisor;
    protected double remainder;

    public Lib1(){
        dividend = 100;
        divisor = 5;
        remainder = dividend % divisor;
    }

    public Lib1(double dividend, double divisor){
        this.dividend = dividend;
        this.divisor = divisor;
        remainder = dividend % divisor;
    }

    public double intDiv(){
        return (dividend - remainder)/divisor;
    }

    public int intDiv(int a, int b){
        return (int)(a/b);
    }
}

class test{
    public void checkingProtectedVarAccess(){
        System.out.println("Accessing protected variable in test class: " + new Lib1().remainder); 
    }
}