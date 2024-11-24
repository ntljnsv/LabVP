package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Name1", "LName1", "bio1"));
        artists.add(new Artist("Name2", "LName2", "bio2"));
        artists.add(new Artist("Name3", "LName3", "bio3"));
        artists.add(new Artist("Name4", "LName4", "bio4"));
        artists.add(new Artist("Name5", "LName5", "bio5"));

        albums = new ArrayList<>();
        albums.add(new Album("Album1", "Rock", "2024"));
        albums.add(new Album("Album2", "Pop", "2023"));
        albums.add(new Album("Album3", "Rap", "2022"));
        albums.add(new Album("Album4", "Jazz", "2021"));
        albums.add(new Album("Album5", "Blues", "2020"));

        songs = new ArrayList<>();
        songs.add(new Song("Title1", "Rock", 2024, new ArrayList<>(List.of(artists.get(0), artists.get(1))), albums.get(0)));
        songs.add(new Song("Title2", "Rock", 2024, new ArrayList<>(List.of(artists.get(1), artists.get(2))), albums.get(0)));
        songs.add(new Song("Title3", "Rap", 2022, new ArrayList<>(List.of(artists.get(2), artists.get(3))), albums.get(2)));
        songs.add(new Song("Title4", "Jazz", 2021, new ArrayList<>(List.of(artists.get(3), artists.get(4))), albums.get(3)));
        songs.add(new Song("Title5", "Blues", 2020, new ArrayList<>(List.of(artists.get(4), artists.get(0))), albums.get(4)));
    }
}