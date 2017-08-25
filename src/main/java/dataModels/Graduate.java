package dataModels;


public class Graduate extends Student {
    private int id;
    private int studentId;
    private String jobTitle;
    private int salary;
    private boolean employed;

    //Constructor
    //overload to make testing easier
    public Graduate() {
    }
    public Graduate(int trackId, int studentId, String gender, int age, String jobTitle, int salary, boolean employed) {
        super(trackId, gender, age, false);
        this.studentId = studentId;
        this.salary = salary;
        this.employed = employed;
    }

    //Getters && Setters
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public boolean isEmployed() {
        return employed;
    }
    public void setEmployed(boolean employed) {
        this.employed = employed;
    }

    //Unique equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graduate)) return false;
        if (!super.equals(o)) return false;

        Graduate graduate = (Graduate) o;

        if (id != graduate.id) return false;
        if (studentId != graduate.studentId) return false;
        if (salary != graduate.salary) return false;
        if (employed != graduate.employed) return false;
        return jobTitle.equals(graduate.jobTitle);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + id;
        result = 31 * result + studentId;
        result = 31 * result + jobTitle.hashCode();
        result = 31 * result + salary;
        result = 31 * result + (employed ? 1 : 0);
        return result;
    }
}
