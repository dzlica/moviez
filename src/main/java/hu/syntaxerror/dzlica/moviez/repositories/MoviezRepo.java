package hu.syntaxerror.dzlica.moviez.repositories;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviezRepo extends CrudRepository<Moviez, Long> {
    List<Moviez> findAllByTitleIsLikeOrGenreIsLikeOrTypeIsLike(String title, String genre, String type);
    List<Moviez> findAllByWatchedIsTrue();

}
