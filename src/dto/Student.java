package dto;

import java.util.List;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int age;
    private String dept;
    private String city;
    private List<String> contacts;
    private int rank;

    public Student(int id, String name, int age, String dept, String city, List<String> contacts, int rank) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.city = city;
        this.contacts = contacts;
        this.rank = rank;
    }
    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && age == student.age && rank == student.rank && Objects.equals(name, student.name) && Objects.equals(dept, student.dept) && Objects.equals(city, student.city) && Objects.equals(contacts, student.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, dept, city, rank, contacts);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                ", contacts=" + contacts +
                ", rank=" + rank +
                '}';
    }
}
