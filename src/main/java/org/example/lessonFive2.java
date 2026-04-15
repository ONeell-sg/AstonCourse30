package org.example;
import java.util.*;

public class lessonFive2 {

    public static class PhoneDirectory {

        private final Map<String, List<String>> directory;

        public PhoneDirectory() {
            directory = new HashMap<>();
        }
        
        public void add(String surname, String phoneNumber) {
            if (directory.containsKey(surname)) {
                directory.get(surname).add(phoneNumber);
            } else {
                List<String> phoneList = new ArrayList<>();
                phoneList.add(phoneNumber);
                directory.put(surname, phoneList);
            }
        }
        
        public List<String> get(String surname) {
            return directory.getOrDefault(surname, new ArrayList<>());
        }
    }
    
        public static void main(String[] args) {
            PhoneDirectory phoneBook = new PhoneDirectory();

            phoneBook.add("Романов", "8-999-123-45-67");
            phoneBook.add("Петров", "8-987-654-32-10");
            phoneBook.add("Васильков", "8-912-345-67-89");

            phoneBook.add("Романов", "8-900-987-65-43");
            phoneBook.add("Романов", "8-950-111-22-33");

            phoneBook.add("Петров", "8-922-333-44-55");

            System.out.println("Номера Романова: " + phoneBook.get("Романов"));
            System.out.println("Номера Петрова: " + phoneBook.get("Петров"));
            System.out.println("Номера Василькова: " + phoneBook.get("Васильков"));
            System.out.println("Номера Рбанова: " + phoneBook.get("Рбанов")); 
        }

}
