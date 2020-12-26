package ru.job4j.builder;

public class Sotrudnik {

    private String name;
    private String surname;
    private byte age;
    private String city;
    private String profession;
    private double salary;

    @Override
    public String toString() {
        return "Sotrudnik{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", profession='" + profession + '\'' +
                ", salary=" + salary +
                '}';
    }


    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String city;
        private String profession;
        private double salary;


        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildCity(String city) {
            this.city = city;
            return this;
        }

        Builder buildProfession(String profession) {
            this.profession = profession;
            return this;
        }

        Builder buildSalary(double salary) {
            this.salary = salary;
            return this;
        }


        Sotrudnik build() {
            Sotrudnik sotrudnik = new Sotrudnik();
            sotrudnik.name = name;
            sotrudnik.surname = surname;
            sotrudnik.age = age;
            sotrudnik.city = city;
            sotrudnik.profession = profession;
            sotrudnik.salary = salary;
            return sotrudnik;
        }

        public static void main(String[] args) {
            Sotrudnik sotrudnik = new Builder()
                    .buildName("Danil")
                    .buildSurname("Ivanov")
                    .buildAge((byte) 28)
                    .buildCity("Novosibirsk")
                    .buildProfession("Teacher")
                    .buildSalary(30000)
                    .build();
            System.out.println(sotrudnik);
        }
    }
}





