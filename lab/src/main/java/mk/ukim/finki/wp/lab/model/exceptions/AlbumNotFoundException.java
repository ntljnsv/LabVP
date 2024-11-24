package mk.ukim.finki.wp.lab.model.exceptions;

public class AlbumNotFoundException extends RuntimeException {
    public AlbumNotFoundException(Long albumId) {
      super(String.format("The album with id %d does not exist", albumId));
    }
}
