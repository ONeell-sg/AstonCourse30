package org.example;

public class lessonFour1 {

    public static class ArrayValidator {

        public static class MyArraySizeException extends Exception {
            public MyArraySizeException(String message) {
                super(message);
            }
        }

        public static void validateArraySize(String[][] array) throws MyArraySizeException {
            // Проверяем, что массив не null
            if (array == null) {
                throw new MyArraySizeException("Массив не может быть null");
            }

            // Проверяем количество строк
            if (array.length != 4) {
                throw new MyArraySizeException(
                        "Неверный размер массива: ожидается 4 строки, получено " + array.length);
            }

            // Проверяем каждую строку на длину 4
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    throw new MyArraySizeException("Строка " + i + " массива равна null");
                }
                if (array[i].length != 4) {
                    throw new MyArraySizeException(
                            "Неверный размер строки " + i + ": ожидается 4 столбца, получено " + array[i].length);
                }
            }
        }

        // Пример использования
        public static void main(String[] args) {
            // Корректный массив 4x4
            String[][] correctArray = {
                    {"a", "b", "c", "d"},
                    {"e", "f", "g", "h"},
                    {"i", "j", "k", "l"},
                    {"m", "n", "o", "p"}
            };

            // Некорректный массив 3x4
            String[][] wrongSizeArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"}
            };

            try {
                validateArraySize(correctArray);
                System.out.println("Корректный массив прошёл проверку!");

                validateArraySize(wrongSizeArray);
            } catch (MyArraySizeException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }

}
