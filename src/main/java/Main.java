import Player.Track;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvalidDataException, UnsupportedTagException, IOException {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter a mp3 file path to play");
        String filePath = scnr.nextLine();

        Track track = new Track(filePath);

        System.out.println(track.toString());



    }
}
