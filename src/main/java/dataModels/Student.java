package dataModels;

public class Student {
    private int id;
    private String gender;
    private int age;
    private boolean graduated;

    //Constructor
    public Student() {
    }

    public Student(String gender, int age, boolean graduated) {
        this.gender = gender;
        this.age = age;
        this.graduated = graduated;
    }

    //Getters && Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isGraduated() {
        return graduated;
    }
    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    //Unique Equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (graduated != student.graduated) return false;
        return gender.equals(student.gender);
    }
    @Override
    public int hashCode() {
        int result = gender.hashCode();
        result = 31 * result + age;
        result = 31 * result + (graduated ? 1 : 0);
        return result;
    }
}
