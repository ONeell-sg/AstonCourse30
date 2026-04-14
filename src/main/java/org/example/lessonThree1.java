package org.example;

public class lessonThree1 {

    public static abstract class Animals {
        protected static int totalAnimals = 0;
        protected String name;

        public Animals(String name) {
            this.name = name;
            totalAnimals++;
        }

        public abstract void run(int distance);
        public abstract void swim(int distance);

        public static int getTotalAnimals() {
            return totalAnimals;
        }
    }

    public static class Dog extends Animals {
        private static int totalDogs = 0;
        private final int MAX_RUN = 500;
        private final int MAX_SWIM = 10;

        public Dog(String name) {
            super(name);
            totalDogs++;
        }

        public void run(int distance) {
            if (distance <= MAX_RUN) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не может пробежать " + distance +
                        " м. (максимум: " + MAX_RUN + " м.)");
            }
        }

        public void swim(int distance) {
            if (distance <= MAX_SWIM) {
                System.out.println(name + " проплыл " + distance + " м.");
            } else {
                System.out.println(name + " не может проплыть " + distance +
                        " м. (максимум: " + MAX_SWIM + " м.)");
            }
        }

        public static int getTotalDogs() {
            return totalDogs;
        }
    }

    public static class Cat extends Animals {
        private static int totalCats = 0;
        private final int MAX_RUN = 200;
        private boolean full = false;

        public Cat(String name) {
            super(name);
            totalCats++;
        }

        public void run(int distance) {
            if (distance <= MAX_RUN) {
                System.out.println(name + " пробежал " + distance + " м.");
            } else {
                System.out.println(name + " не может пробежать " + distance +
                        " м. (максимум: " + MAX_RUN + " м.)");
            }
        }

        public void swim(int distance) {
            System.out.println(name + " не умеет плавать!");
        }

        public boolean Eat(Dish dish, int amount) {
            if (dish.takeFood(amount)) {
                full = true;
                System.out.println(name + " поел и теперь сыт.");
                return true;
            } else {
                System.out.println(name + " не смог поесть — недостаточно еды в миске.");
                return false;
            }
        }

        public boolean isFull() {
            return full;
        }

        public static int getTotalCats() {
            return totalCats;
        }
    }

    public static class Dish {
        private int foodAmount;

        public Dish(int initQuantity) {
            this.foodAmount = initQuantity;
        }

        public boolean takeFood(int amount) {
            if (amount > 0 && foodAmount >= amount) {
                foodAmount -= amount;
                return true;
            }
            return false;
        }

        public void addFood(int amount) {
            if (amount > 0) {
                foodAmount += amount;
                System.out.println("В миску добавлено " + amount + " единиц еды.");
            } else {
                System.out.println("Нельзя добавить отрицательное количество еды!");
            }
        }

        public int getFoodAmount() {
            return foodAmount;
        }
    }

    public static void main(String[] args) {
        Dog shaine= new Dog("Шейн");
        Dog bobic = new Dog("Бобик");
        Cat miisa = new Cat("Миса");
        Cat barsik = new Cat("Барсик");

        // Тестируем действия животных
        System.out.println("=== ТЕСТИРОВАНИЕ ДЕЙСТВИЙ ЖИВОТНЫХ ===");
        bobic.run(150);
        shaine.run(600);
        miisa.run(100);
        barsik.swim(5);
        shaine.swim(8);

        // Подсчёт животных
        System.out.println("=== ПОДСЧЁТ ЖИВОТНЫХ ===");
        System.out.println("Всего животных: " + Animals.getTotalAnimals());
        System.out.println("Всего собак: " + Dog.getTotalDogs());
        System.out.println("Всего котов: " + Cat.getTotalCats());

        // Кормление котов
        System.out.println("=== КОРМЛЕНИЕ КОТОВ ===");
        Dish dish = new Dish(15);

        Cat[] cats = {miisa, barsik, new Cat("Масик")};

        System.out.println("Начальное количество еды в миске: " + dish.getFoodAmount());

        // Первый раунд кормления
        for (Cat cat : cats) {
            cat.Eat(dish, 10);
        }

        System.out.println("Осталось еды в миске: " + dish.getFoodAmount());

        // Добавляем еду и кормим снова
        dish.addFood(20);

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.Eat(dish, 10);
            }
        }

        // Вывод информации о сытости котов
        System.out.println("=== ИНФОРМАЦИЯ О СЫТОСТИ КОТОВ ===");
        for (Cat cat : cats) {
            System.out.println(cat.name + " сыт: " + cat.isFull());
        }
    }
}
