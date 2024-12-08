package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SongNotFoundException;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final AlbumService albumService;
    private final ArtistService artistService;

    public SongServiceImpl(SongRepository songRepository, AlbumService albumService, ArtistService artistService, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumService = albumService;
        this.artistService = artistService;
    }


    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Long artistId, Long trackId) {
        Song song = songRepository.findById(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }
        Artist artist = artistService.findById(artistId);
        song.addArtist(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findByTrackId(Long trackId) {
        Song song = songRepository.findById(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }
        return song;
    }

    @Override
    public Song addSong(String title, String genre, int releaseYear, Long albumId) {
        if(title.isEmpty() || genre.isEmpty() || albumId == null) {
            return null;
        }
        Album album = albumService.findByAlbumId(albumId);
        Song song = new Song(title, genre, releaseYear, album);
        return songRepository.save(song);
    }

    @Override
    public Song editSong(Long trackId, String title, String genre, int releaseYear, Long albumId) {
        Album album = albumService.findByAlbumId(albumId);
        Song song = songRepository.findById(trackId).orElse(null);
        if(song == null) {
            throw new SongNotFoundException(trackId);
        }

        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(album);

        return songRepository.save(song);
    }

    @Override
    public boolean deleteSong(Long trackId) {
        songRepository.deleteById(trackId);
        return true;
    }
}
