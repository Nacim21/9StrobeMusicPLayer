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
        String bruh = scnr.nextLine();

        ArrayList<Track> tracks = trackList.fetchFiles(bruh);

        System.out.println(tracks);
        System.out.println("Select a track to play");

//        int trackID = scnr.nextInt();
//        tracks.get(trackID).play();

        System.out.println("Search by title: ");
        String search = scnr.nextLine();

        ArrayList<Track> results = new ArrayList<Track>();

        for (int i = 0; i < tracks.size(); i++) {
            if(search.equals(tracks.get(i).getTitle())){
                results.add(tracks.get(i));
            }
        }

        if(results.size() == 1){
            results.get(0).play();
        }

        else{
            System.out.println("Select a song to play:");
            System.out.println(results);
            int trackID = scnr.nextInt();
            results.get(trackID-1).play();
        }




    }
}
