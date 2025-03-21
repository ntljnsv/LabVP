package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.model.exceptions.AlbumNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findByAlbumId(Long albumId) {
        Album album = albumRepository.findById(albumId).orElse(null);
        if(album == null) {
            throw new AlbumNotFoundException(albumId);
        }
        return album;
    }
}
