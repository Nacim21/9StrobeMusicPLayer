package Player;

import com.mpatric.mp3agic.*;
import java.io.IOException;

public class Track {
    private String title;
    private String artist;
    private String album;
    private String filePath;
    private String duration;


    public Track(String filePath) throws InvalidDataException, UnsupportedTagException, IOException {
        this.filePath = filePath;

        Mp3File mp3File = new Mp3File(filePath);

        if (mp3File.hasId3v2Tag()) {
            ID3v2 id3v2Tag = mp3File.getId3v2Tag();
            this.album = id3v2Tag.getAlbum();
            this.duration = generateDuration();
            this.title = id3v2Tag.getTitle();
            this.artist = id3v2Tag.getArtist();
        }

        else if (mp3File.hasId3v1Tag()) {
            ID3v1 id3v1Tag = mp3File.getId3v1Tag();
            this.album = id3v1Tag.getAlbum();
            this.duration = generateDuration();
            this.title = id3v1Tag.getTitle();
            this.artist = id3v1Tag.getArtist();
        }

        else{
            this.album = null;
            this.duration = null;
            this.title = null;
            this.artist = null;
        }
    }
    private String generateDuration() throws InvalidDataException, UnsupportedTagException, IOException {
        Mp3File mp3File = new Mp3File(filePath);
        long durationInSeconds = mp3File.getLengthInSeconds();

        long hours = durationInSeconds / 3600;
        long minutes = (durationInSeconds % 3600) / 60;
        long seconds = durationInSeconds % 60;

        if (hours > 0){
            return hours+":"+minutes+":"+seconds;
        }
        else{
            return minutes+":"+seconds;
        }
    }


    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString(){
        return "Title:"+ this.title+"\n"+"Artist:"+ this.artist+"\n"+"Album:"+ this.album+"\n"+"Duration:"+ this.duration+"\n";
    }
}
