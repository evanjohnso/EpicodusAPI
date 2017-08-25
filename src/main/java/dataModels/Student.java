package dataModels;

public class Student {
    private int id;
    private String gender;
    private int age;
    private boolean enrolled;

    //Constructor
    public Student() {
    }

    public Student(String gender, int age, boolean enrolled) {
        this.gender = gender;
        this.age = age;
        this.enrolled = enrolled;
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
    public boolean isEnrolled() {
        return enrolled;
    }
    public void setEnrolled(boolean enrolled) {
        this.enrolled = enrolled;
    }

    //Unique Equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (enrolled != student.enrolled) return false;
        return gender.equals(student.gender);
    }
    @Override
    public int hashCode() {
        int result = gender.hashCode();
        result = 31 * result + age;
        result = 31 * result + (enrolled ? 1 : 0);
        return result;
    }
}
