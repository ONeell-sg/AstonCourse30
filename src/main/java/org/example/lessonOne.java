package org.example;

public class lessonOne {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkSumInRange(5, 7));
        System.out.println(checkSumInRange(2, 3));
        printNumberSign(0);
        printNumberSign(100);
        printNumberSign(-50);
        System.out.println(isNegative(8));
        System.out.println(isNegative(-7));
        System.out.println(isNegative(0));
        printStringMultipleTimes("Lesson", 5);
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(1900));
        System.out.println(isLeapYear(2024));

        // задание 14
        int[] array1 = createArray(5, 0);
        printArray(array1);

        int[] array2 = createArray(3, 10);
        printArray(array2);

        int[] array3 = createArray(4, -1);
        printArray(array3);

        // задание 10
        int[] array4 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Исходный массив:");
        printArray(array4);

        for (int i = 0; i < array1.length; i++) {
            if (array4[i] == 0) {
                array4[i] = 1;
            } else {
                array4[i] = 0;
            }
        }

        System.out.println("Массив после замены:");
        printArray(array4);

        // задание 11
        int[] array5 = new int[100];

        for (int i = 0; i < array5.length; i++) {
            array5[i] = i + 1;
        }

        System.out.println("Первые 10 элементов массива:");
        for (int i = 0; i < 10; i++) {
            System.out.print(array5[i] + " ");
        }
        System.out.println();

        System.out.println("Последний элемент: " + array5[99]);

        // задание 12
        int[] array6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("Исходный массив:");
        printArray(array6);

        for (int i = 0; i < array6.length; i++) {
            if (array6[i] < 6) {
                array6[i] *= 2;
            }
        }

        System.out.println("Массив после обработки:");
        printArray(array6);

        // задание 13
        int size = 5;
        int[][] array7 = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    array7[i][j] = 1;
                } else {
                    array7[i][j] = 0;
                }
            }
        }

        printArray(array7);
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = -28;  // можно задать любые значения
        int b = 34;

        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 101;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else { // value > 100
            System.out.println("Зелёный");
        }
    }

    public static void compareNumbers() {
        int a = 24;
        int b = 15;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringMultipleTimes(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return year % 4 == 0;
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();


    }

    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
