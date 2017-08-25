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

    //Unique Equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campus)) return false;

        Campus campus = (Campus) o;

        if (id != campus.id) return false;
        return location.equals(campus.location);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + location.hashCode();
        return result;
    }
}
