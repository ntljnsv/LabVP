package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;

    public Song(String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(String title, String genre, int releaseYear, Album album) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = new ArrayList<>();
    }

    public Artist addArtist(Artist artist) {
        performers.add(artist);
        return artist;
    }

}
