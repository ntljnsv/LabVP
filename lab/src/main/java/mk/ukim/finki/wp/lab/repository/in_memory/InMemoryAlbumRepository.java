package mk.ukim.finki.wp.lab.repository.in_memory;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryAlbumRepository {
    public List<Album> findAll() {
        return DataHolder.albums;
    }

    public Optional<Album> findByAlbumId(Long albumId) {
        return DataHolder.albums.stream().filter(a -> a.getId().equals(albumId)).findFirst();
    }
}
