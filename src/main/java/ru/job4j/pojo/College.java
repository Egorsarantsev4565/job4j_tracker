package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Sarantsev Egor");
        student.setGroup("Inter");
        student.setDate("24 june 2020");
        System.out.println(student.getFIO() + " - " + student.getGroup() + " group - " + student.getDate());
    }
}
