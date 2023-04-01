package ru.labs.lab02;

public class MainFraction {
    public static void main(String[] args) {
        FractionMatrix mFraction1 = new FractionMatrix(2, 2);
        FractionMatrix mFraction2 = new FractionMatrix(2, 2);

        mFraction1.setElement(0, 0, new Fraction(4, 2));
        mFraction1.setElement(0, 1, new Fraction(6, 2));
        mFraction1.setElement(1, 0, new Fraction(9, 3));
        mFraction1.setElement(1, 1, new Fraction(12, 4));

        mFraction2.setElement(0, 0, new Fraction(3, 1));
        mFraction2.setElement(0, 1, new Fraction(4, 2));
        mFraction2.setElement(1, 0, new Fraction(2, 1));
        mFraction2.setElement(1, 1, new Fraction(16, 2));

        System.out.println(mFraction1);
        System.out.println(mFraction2);

        FractionMatrix mFraction3 = mFraction1.product(mFraction2);
        System.out.println(mFraction3);


    }
}
