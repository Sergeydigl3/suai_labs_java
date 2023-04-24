package ru.labs.lab01;

public class EllipseMain {
    public static void main(String[] args) {
        Ellipse ellipse = new Ellipse(0, 0, 5, 5);
        System.out.println(ellipse);
        ellipse.zoom(2);
        System.out.println(ellipse);
        System.out.println(ellipse.isInside(0, 0));
        System.out.println(ellipse.isInside(3, 4));
        System.out.println(ellipse.isInside(0, 11));

    }
}
