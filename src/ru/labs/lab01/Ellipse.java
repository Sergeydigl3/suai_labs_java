package ru.labs.lab01;

//создать класс Ellipse для работы с фигурой эллипс
//        Методы
//        bool isInside(int x, int y) --- находится ли точка внутри фигуры
//        void zoom(int factor) --- увеличение фигуры
//        фигура хранится координатами центра и двумя радиусами

public class Ellipse {
    private int x;
    private int y;
    private int radius1;
    private int radius2;

    public Ellipse(int x, int y, int radius1, int radius2) {
        this.x = x;
        this.y = y;
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public boolean isInside(int x, int y) {
        return (Math.pow(x - this.x, 2) / Math.pow(this.radius1, 2) + Math.pow(y - this.y, 2) / Math.pow(this.radius2, 2)) <= 1;
    }

    public void zoom(int value_increase) {
        this.radius1 *= value_increase;
        this.radius2 *= value_increase;
    }

    public String toString() {
        return "Ellipse: x=" + this.x + ", y=" + this.y + ", radius1=" + this.radius1 + ", radius2=" + this.radius2;
    }
}
