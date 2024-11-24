package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Long artistId, Long trackId);
    Song findByTrackId(Long trackId);
    Song addSong(String title, String genre, int releaseYear, Long albumId);
    Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId);
    boolean deleteSong(Long trackId);
}
