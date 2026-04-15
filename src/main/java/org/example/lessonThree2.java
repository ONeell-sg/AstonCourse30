package org.example;

public class lessonThree2 {

    public  interface GeometricShape {
         double getPerimeter();
         double getArea();

            // Дефолтные методы для расчёта периметра
        default double calculateCirclePerimeter(double radius) {
                return 2 * Math.PI * radius;
            }

        default double calculateRectanglePerimeter(double width, double height) {
                return 2 * (width + height);
            }

        default double calculateTrianglePerimeter(double a, double b, double c) {
                return a + b + c;
            }
             String getFillColor();
            String getBorderColor();

            // Универсальный метод вывода информации
        default void displayInfo() {
                System.out.printf("Фигура: %s | Периметр: %.2f | Площадь: %.2f | Цвет фона: %s | Цвет границы: %s%n",
                        this.getClass().getSimpleName(),
                        getPerimeter(),
                        getArea(),
                        getFillColor(),
                        getBorderColor());
            }
        }

    public enum Color {
            RED("Красный"),
            BLUE("Синий"),
            GREEN("Зелёный"),
            YELLOW("Жёлтый"),
            PURPLE("Фиолетовый"),
            ORANGE("Оранжевый");

            private final String russianName;

            Color(String russianName) {
                this.russianName = russianName;
            }

            @Override
        public String toString() {
                return russianName;
            }
        }

    public static class Circle implements GeometricShape {
            private final double radius;
            private final Color fillColor;
            private final Color borderColor;

        public Circle(double radius, Color fillColor, Color borderColor) {
                if (radius <= 0) {
                    throw new IllegalArgumentException("Радиус должен быть положительным числом");
                }
                this.radius = radius;
                this.fillColor = fillColor;
                this.borderColor = borderColor;
            }

            @Override
        public double getPerimeter() {
                return calculateCirclePerimeter(radius);
            }

            @Override
        public double getArea() {
                return Math.PI * radius * radius;
            }

            @Override
        public String getFillColor() {
                return fillColor != null ? fillColor.toString() : "Не задан";
            }

            @Override
        public String getBorderColor() {
                return borderColor != null ? borderColor.toString() : "Не задан";
            }
        }

    public static class Rectangle implements GeometricShape {
            private final double width;
            private final double height;
            private final Color fillColor;
            private final Color borderColor;

        public Rectangle(double width, double height, Color fillColor, Color borderColor) {
                if (width <= 0 || height <= 0) {
                    throw new IllegalArgumentException("Ширина и высота должны быть положительными числами");
                }
                this.width = width;
                this.height = height;
                this.fillColor = fillColor;
                this.borderColor = borderColor;
            }

            @Override
        public double getPerimeter() {
                return calculateRectanglePerimeter(width, height);
            }

            @Override
        public double getArea() {
                return width * height;
            }

            @Override
        public String getFillColor() {
                return fillColor != null ? fillColor.toString() : "Не задан";
            }

            @Override
        public String getBorderColor() {
                return borderColor != null ? borderColor.toString() : "Не задан";
            }
        }

    public static class Triangle implements GeometricShape {
            private final double sideA;
            private final double sideB;
            private final double sideC;
            private final Color fillColor;
            private final Color borderColor;

        public Triangle(double sideA, double sideB, double sideC, Color fillColor, Color borderColor) {
                if (!isValidTriangle(sideA, sideB, sideC)) {
                    throw new IllegalArgumentException("Треугольник с такими сторонами не существует! Условия: a+b>c, a+c>b, b+c>a");
                }
                this.sideA = sideA;
                this.sideB = sideB;
                this.sideC = sideC;
                this.fillColor = fillColor;
                this.borderColor = borderColor;
            }

            private boolean isValidTriangle(double a, double b, double c) {
                return (a + b > c) && (a + c > b) && (b + c > a) &&
                        (a > 0) && (b > 0) && (c > 0);
            }

            @Override
        public double getPerimeter() {
                return calculateTrianglePerimeter(sideA, sideB, sideC);
            }

            @Override
        public double getArea() {
                double semiPerimeter = getPerimeter() / 2;
                double areaSquared = semiPerimeter *
                        (semiPerimeter - sideA) *
                        (semiPerimeter - sideB) *
                        (semiPerimeter - sideC);
                return areaSquared >= 0 ? Math.sqrt(areaSquared) : 0;
            }

            @Override
        public String getFillColor() {
                return fillColor != null ? fillColor.toString() : "Не задан";
            }

            @Override
        public String getBorderColor() {
                return borderColor != null ? borderColor.toString() : "Не задан";
            }
        }


        public static void main(String[] args) {
                // Создаём коллекцию фигур
                GeometricShape[] shapes = {
                        new Circle(5.0, Color.RED, Color.BLUE),
                        new Rectangle(4.0, 6.0, Color.GREEN, Color.YELLOW),
                        new Triangle(3.0, 4.0, 5.0, Color.PURPLE, Color.ORANGE)
                };

                // Выводим информацию о всех фигурах
                System.out.println("=== РАСЧЁТ ГЕОМЕТРИЧЕСКИХ ФИГУР ===");
                for (GeometricShape shape : shapes) {
                    shape.displayInfo();
                }

                // Дополнительно выводим суммарные характеристики
                System.out.println("=== СУММАРНЫЕ ХАРАКТЕРИСТИКИ ===");
                double totalPerimeter = 0;
                double totalArea = 0;

            for (GeometricShape shape : shapes) {
                totalPerimeter += shape.getPerimeter();
                totalArea += shape.getArea();
            }

            System.out.printf("Суммарный периметр: %.2f%n", totalPerimeter);
            System.out.printf("Суммарная площадь: %.2f%n", totalArea);
        }


}
