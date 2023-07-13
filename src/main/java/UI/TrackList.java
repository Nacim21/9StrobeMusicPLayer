package UI;

import Player.Track;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class TrackList {

    public ArrayList<Track> fetchFiles(String directoryPath){
        Path path = Paths.get(directoryPath);

        ArrayList<Track> compatibleTracks= new ArrayList<Track>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if(entry.toString().endsWith(".mp3")){
                    Track track = new Track(entry.toString());
                    compatibleTracks.add(track);
                }

            }
        } catch (IOException | InvalidDataException | UnsupportedTagException e) {
            e.printStackTrace();
        }

        return compatibleTracks;
    }
}
