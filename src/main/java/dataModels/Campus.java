package dataModels;

public class Campus {
    private int id;
    private String location;

    public Campus(String location) {
        this.location = location;
    }

    //Getters && Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
