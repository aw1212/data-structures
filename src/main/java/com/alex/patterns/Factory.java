package com.alex.patterns;

public class Factory {

//    In Factory pattern, we create an object without exposing the creation logic to the client
//    and refer to the newly created object using a common interface (in this case Runnable).
    public Runnable getInstance(Shape type) {
        switch (type) {
            case CIRCLE: {
                return new Circle();
            }
            case SQUARE: {
                return new Square();
            }
            case TRINGLE: {
                return new Triangle();
            }
        }

        return null;
    }

    class Circle implements Runnable {
        @Override
        public void run() {
            System.out.println("Circle");
        }
    }

    class Square implements Runnable {
        @Override
        public void run() {
            System.out.println("Square");
        }
    }

    class Triangle implements Runnable {
        @Override
        public void run() {
            System.out.println("Rectangle");
        }
    }

    enum Shape {
        CIRCLE, SQUARE, TRINGLE
    }
}
