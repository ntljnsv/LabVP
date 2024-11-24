package mk.ukim.finki.wp.lab.model.exceptions;

public class SongNotFoundException extends RuntimeException {

    public SongNotFoundException(Long trackId) {
        super(String.format("Song with id %d does not exit", trackId));
    }
}
