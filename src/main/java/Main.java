import Player.Track;
import UI.TrackList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        TrackList trackList = new TrackList();
        System.out.println("Please enter a filepath");
        String fp = scnr.nextLine();
        ArrayList<Track> tracks = trackList.fetchFiles(fp);

        System.out.println(tracks);


        System.out.println("Search by title: ");
        String search = scnr.nextLine();

        ArrayList<Track> results = new ArrayList<Track>();

        for (Track track : tracks) {
            if (search.equalsIgnoreCase(track.getTitle())) {
                results.add(track);
            }
        }


        if(results.size() == 1){
            System.out.println("Now playing: "+"\n\n"+results.get(0).toString());
            results.get(0).play();
        }
        else{
            System.out.println("Select a song to play:");
            System.out.println(results);
            int trackID = scnr.nextInt()-1;
            System.out.println("Now playing: "+"\n\n"+results.get(trackID).toString());
            results.get(trackID).play();
        }

    }
}
