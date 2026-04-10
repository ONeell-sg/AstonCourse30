package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class lessonTwo {

    public static void main(String[] args) {
            Product1 product01 = new Product1(
                    "Смартфон Samsung Galaxy S24",
                    LocalDate.of(2024, 3, 15),
                    "Samsung Electronics",
                    "Южная Корея",
                    89999.99,
                    true
            );

            Product1 product02 = new Product1(
                    "Чай чёрный Richard Royal Blueberry",
                    LocalDate.of(2024, 1, 10),
                    "RICHARD",
                    "Россия",
                    399.50,
                    false
            );

            product01.information1();
            product02.information1();

        Product2[] productsArray = new Product2[5];

        productsArray[0] = new Product2(
                "Samsung S25 Ultra",
                LocalDate.of(2025, 2, 1),
                "Samsung Corp.",
                "Korea",
                5599.0,
                true
        );

        productsArray[1] = new Product2(
                "iPhone 16 Pro ",
                LocalDate.of(2024, 11, 15),
                "Apple Inc.",
                "USA",
                109999.99,
                false
        );

        productsArray[2] = new Product2(
                "Xiaomi 15",
                LocalDate.of(2024, 9, 20),
                "Xiaomi Corp.",
                "China",
                64999.90,
                true
        );

        productsArray[3] = new Product2(
                "Sony MH-1000XM5",
                LocalDate.of(2024, 6, 10),
                "Sony Corporation",
                "Japan",
                28990.0,
                false
        );

        productsArray[4] = new Product2(
                "Dell XPS 13",
                LocalDate.of(2024, 3, 5),
                "Dell Technologies",
                "USA",
                89990.75,
                true
        );

        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].information2();
        }

        Park centralPark = new Park("Центральный парк развлечений", "г. Москва, ул. Парковая, 15");

        // Добавляем аттракционы через метод addAttraction
        centralPark.addAttraction("Американские горки", "10:00–22:00", 500.0);
        centralPark.addAttraction("Колесо обозрения", "09:00–23:00", 300.50);
        centralPark.addAttraction("Карусель", "11:00–21:00", 200.75);
        centralPark.addAttraction("Комната страха", "12:00–24:00", 450.25);

        // Выводим информацию обо всех аттракционах парка
        centralPark.displayAllAttractions();

        // Можно также получить доступ к конкретному аттракциону
        List<Park.Attraction> attractions = centralPark.attractions;
        if (!attractions.isEmpty()) {
            attractions.get(0).displayInfo(); // Информация о первом аттракционе
        }

        }



    public static class Product1 {
        // Поля класса
        private String title1;
        private LocalDate prodDate1;
        private String manufacturer1;
        private String country1;
        private double price1;
        private boolean reserv1;

        // Конструктор для заполнения всех полей при создании объекта
        public Product1(String title1, LocalDate prodDate1, String manufacturer1,
                        String country1, double price1, boolean reserv1) {
            this.title1 = title1;
            this.prodDate1 = prodDate1;
            this.manufacturer1 = manufacturer1;
            this.country1 = country1;
            this.price1 = price1;
            this.reserv1 = reserv1;
        }

        // Метод для вывода информации об объекте в консоль
        public void information1() {
            System.out.println("=== Информация о товаре ===");
            System.out.println("Название: " + title1);
            System.out.println("Дата производства: " + prodDate1);
            System.out.println("Производитель: " + manufacturer1);
            System.out.println("Страна происхождения: " + country1);
            System.out.println("Цена: " + price1 + " руб.");
            System.out.println("Состояние бронирования: " +
                    (reserv1 ? "Забронирован" : "Не забронирован"));
            System.out.println("==========================");
        }

    }

    //задание 2

    public static class Product2 {
        private String title2;
        private LocalDate prodDate2;
        private String manufacturer2;
        private String country2;
        private double price2;
        private boolean reserv2;

        // Конструктор
        public Product2(String title2, LocalDate prodDate2, String manufacturer2,
                        String country2, double price2, boolean reserv2) {
            this.title2 = title2;
            this.prodDate2 = prodDate2;
            this.manufacturer2 = manufacturer2;
            this.country2 = country2;
            this.price2 = price2;
            this.reserv2 = reserv2;
        }

        // Метод для вывода информации
        public void information2() {
            System.out.println("=== Информация о товаре ===");
            System.out.println("Название: " + title2);
            System.out.println("Дата производства: " + prodDate2);
            System.out.println("Производитель: " + manufacturer2);
            System.out.println("Страна происхождения: " + country2);
            System.out.println("Цена: " + price2 + " руб.");
            System.out.println("Состояние бронирования: " +
                    (reserv2 ? "Забронирован" : "Не забронирован"));
            System.out.println("==========================");
        }
    }

    //задание 3

    public static class Park {
        private String name;
        private String location;

        private List<Attraction> attractions;

        public class Attraction {
            private String name;
            private String workingHours;
            private double price;

            public Attraction(String name, String workingHours, double price) {
                this.name = name;
                this.workingHours = workingHours;
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public String getWorkingHours() {
                return workingHours;
            }

            public double getPrice() {
                return price;
            }


            public void setName(String name) {
                this.name = name;
            }

            public void setWorkingHours(String workingHours) {
                this.workingHours = workingHours;
            }

            public void setPrice(double price) {
                this.price = price;
            }


            public void displayInfo() {
                System.out.printf("Аттракцион: %s%n", name);
                System.out.printf("Время работы: %s%n", workingHours);
                System.out.printf("Стоимость: %.2f руб.%n", price);
                System.out.println("------------------------");
            }
        }


        public Park(String name, String location) {
            this.name = name;
            this.location = location;
            this.attractions = new ArrayList<>();
        }


        public void addAttraction(String name, String workingHours, double price) {
            Attraction attraction = new Attraction(name, workingHours, price);
            attractions.add(attraction);
        }


        public void displayAllAttractions() {
            System.out.println("=== Аттракционы парка '" + name + "' ===");
            System.out.println("Расположение: " + location);
            System.out.println();

            if (attractions.isEmpty()) {
                System.out.println("В парке пока нет аттракционов.");
            } else {
                for (Attraction attraction : attractions) {
                    attraction.displayInfo();
                }
            }
            System.out.println("======================================");
        }


        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }


        public void setName(String name) {
            this.name = name;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
