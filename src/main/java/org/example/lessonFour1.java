package org.example;

public class lessonFour1 {

    public static class ArrayValidator {

        public static class MyArraySizeException extends Exception {
            public MyArraySizeException(String message) {
                super(message);
            }
        }

        public static class MyArrayDataException extends Exception {
            public MyArrayDataException(String message) {
                super(message);
            }
        }

        public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
            // Проверка размера массива
            if (array == null) {
                throw new MyArraySizeException("Массив не может быть null");
            }

            if (array.length != 4) {
                throw new MyArraySizeException(
                        "Неверный размер массива: ожидается 4 строки, получено " + array.length);
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    throw new MyArraySizeException("Строка " + i + " массива равна null");
                }
                if (array[i].length != 4) {
                    throw new MyArraySizeException(
                            "Неверный размер строки " + i + ": ожидается 4 столбца, получено " + array[i].length);
                }
            }

            // Суммирование элементов
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(
                                "Ошибка преобразования в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "' не является числом");
                    }
                }
            }
            return sum;
        }

        public static void demonstrateArrayIndexOutOfBounds() {
            int[] numbers = {1, 2, 6, 4, 5};
            System.out.println("Демонстрация ArrayIndexOutOfBoundsException:");

            try {
                // Попытка доступа к несуществующему элементу
                System.out.println("Элемент с индексом 10: " + numbers[8]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Пойман ArrayIndexOutOfBoundsException: " + e.getMessage());
                System.err.println("Это происходит при попытке доступа к элементу за пределами массива");
            } finally {
                System.out.println("Блок finally выполнен — программа продолжает работу\n");
            }
        }

        public static void main(String[] args) {
            demonstrateArrayIndexOutOfBounds();

            // Тестовый массив 4x4 с корректными данными
            String[][] correctArray = {
                    {"1", "2", "3", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };

            // Массив с некорректными данными
            String[][] invalidDataArray = {
                    {"1", "2", "qwe", "4"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}
            };

            // Массив неправильного размера
            String[][] wrongSizeArray = {
                    {"1", "2", "3"},
                    {"4", "5", "6"},
                    {"7", "8", "9"}
            };

            // Обработка корректного массива
            try {
                int result = processArray(correctArray);
                System.out.println("Сумма элементов корректного массива: " + result);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.err.println("Ошибка обработки массива: " + e.getMessage());
            }

            // Обработка массива с некорректными данными
            try {
                int result = processArray(invalidDataArray);
                System.out.println("Сумма элементов массива с некорректными данными: " + result);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.err.println("Ошибка обработки массива: " + e.getMessage());
            }

            // Обработка массива неправильного размера
            try {
                int result = processArray(wrongSizeArray);
                System.out.println("Сумма элементов массива неправильного размера: " + result);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.err.println("Ошибка обработки массива: " + e.getMessage());
            }
        }
    }
}
