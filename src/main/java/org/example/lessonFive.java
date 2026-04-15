package org.example;
import java.util.List;
import java.util.*;

public class lessonFive {

    public static class Student {
        private final String name;
        private final String group;
        private int course;
        private final List<Integer> grades;

        public Student(String name, String group, int course, List<Integer> grades) {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = grades;
        }

        public String getName() {
            return name;
        }

        public String getGroup() {
            return group;
        }

        public int getCourse() {
            return course;
        }

        public List<Integer> getGrades() {
            return grades;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public double calculateAverageGrade() {
            if (grades == null || grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group='" + group + '\'' +
                    ", course=" + course +
                    ", grades=" + grades +
                    ", average=" + String.format("%.2f", calculateAverageGrade()) +
                    '}';
        }
    }

    public static class StudentManager {

        public static void removeStudentsWithLowGrade(Set<Student> students) {
            students.removeIf(student -> student.calculateAverageGrade() < 3.0);
        }

        public static void promoteStudentsToNextCourse(Set<Student> students) {
            for (Student student : students) {
                if (student.calculateAverageGrade() >= 3.0) {
                    student.setCourse(student.getCourse() + 1);
                }
            }
        }

        public static void printStudents(Set<Student> students, int course) {
            System.out.println("Студенты " + course + " курса:");
            boolean found = false;
            for (Student student : students) {
                if (student.getCourse() == course) {
                    System.out.println("- " + student.getName());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("На курсе " + course + " нет студентов.");
            }
        }
    }

    public static void main(String[] args) {
            Set<Student> students = new HashSet<>();

            students.add(new Student("Алена", "ИНС-631", 1, Arrays.asList(4, 5, 4, 3)));
            students.add(new Student("Виктор", "ИСП-632", 1, Arrays.asList(2, 2, 3, 2)));
            students.add(new Student("Владимир", "ИНС-601", 2, Arrays.asList(5, 4, 5, 4)));
            students.add(new Student("Виктрия", "ИНБ-603", 2, Arrays.asList(3, 3, 4, 3)));
            students.add(new Student("Дмитрий", "ИСП-592", 3, Arrays.asList(2, 1, 2, 3)));

            System.out.println("=== Исходные студенты ===");
            students.forEach(System.out::println);

            StudentManager.removeStudentsWithLowGrade(students);
            System.out.println("\n=== После удаления неуспевающих ===");
            students.forEach(System.out::println);


            StudentManager.promoteStudentsToNextCourse(students);
            System.out.println("\n=== После перевода на следующий курс ===");
            students.forEach(System.out::println);

            System.out.println();
            StudentManager.printStudents(students, 1);
            StudentManager.printStudents(students, 2);
            StudentManager.printStudents(students, 3);
            StudentManager.printStudents(students, 4);
        }

}
