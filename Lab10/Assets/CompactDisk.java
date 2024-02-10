public class CompactDisk extends Asset {
    private String artist;
    private int numberOfTracks;

    public CompactDisk(String name, String SerialNumber, String artist, int numberOfTracks) {
        super(name, SerialNumber);
        this.artist = artist;
        this.numberOfTracks = numberOfTracks;
    }

    public void setArtist(String artist) { this.artist = artist; }
    public String getArtist() { return artist; }

    public void setNumberOfTracks(int numberOfTracks) { this.numberOfTracks = numberOfTracks; }
    public int getNumberOfTracks() { return numberOfTracks; }

    public String toString() {
        return "CompactDisk: " + getName() + " by " + artist + " has " + numberOfTracks + " tracks";
    }


}
