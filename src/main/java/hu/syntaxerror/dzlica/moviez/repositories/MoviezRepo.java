package hu.syntaxerror.dzlica.moviez.repositories;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviezRepo extends CrudRepository<Moviez, Long> {
    List<Moviez> findAllByTitleIsLikeOrGenreIsLike(String title, String genre);
    List<Moviez> findAllByWatchedIsTrue();

}
