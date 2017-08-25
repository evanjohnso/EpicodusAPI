package dataModels;

public class Track{
    private int trackId;
    private String focus;
    private String description;
    private int cost;
    private String duration;
    private String commitment;

    public Track(String focus, String description, int cost, String duration, String commitment) {
        this.focus = focus;
        this.description = description;
        this.cost = cost;
        this.duration = duration;
        this.commitment = commitment;
    }

    //Getters && Setters
    public int getTrackId() {
        return trackId;
    }
    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }
    public String getFocus() {
        return focus;
    }
    public void setFocus(String focus) {
        this.focus = focus;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getCommitment() {
        return commitment;
    }
    public void setCommitment(String commitment) {
        this.commitment = commitment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;

        Track track = (Track) o;

        if (trackId != track.trackId) return false;
        if (cost != track.cost) return false;
        if (!focus.equals(track.focus)) return false;
        if (!description.equals(track.description)) return false;
        if (!duration.equals(track.duration)) return false;
        return commitment != null ? commitment.equals(track.commitment) : track.commitment == null;
    }

    @Override
    public int hashCode() {
        int result = trackId;
        result = 31 * result + focus.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + cost;
        result = 31 * result + duration.hashCode();
        result = 31 * result + (commitment != null ? commitment.hashCode() : 0);
        return result;
    }

}
