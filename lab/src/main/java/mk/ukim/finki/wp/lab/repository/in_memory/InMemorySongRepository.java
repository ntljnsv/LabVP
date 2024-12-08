package mk.ukim.finki.wp.lab.repository.in_memory;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SongNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemorySongRepository {

    public List<Song> findAll() {
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(Long trackId) {
        return DataHolder.songs.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Long trackId) {
        Song song = findByTrackId(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }
        if(!song.getPerformers().contains(artist)) {
            return song.addArtist(artist);
        }
        return artist;
    }

    public Song addSong(String title, String genre, int releaseYear, Album album) {
        Song song = new Song(title, genre, releaseYear, album);
        DataHolder.songs.add(song);
        return song;
    }

    public boolean deleteSong(Long trackId) {
        Song song = findByTrackId(trackId).orElse(null);
        if(song == null) {
            return false;
        }
        DataHolder.songs.remove(song);
        return true;
    }

    public Song editSong(Long trackId, String title, String genre, int releaseYear, Album album) {
        Song song = findByTrackId(trackId).orElse(null);
        if (song == null) {
            throw new SongNotFoundException(trackId);
        }
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);
        return song;
    }
}
