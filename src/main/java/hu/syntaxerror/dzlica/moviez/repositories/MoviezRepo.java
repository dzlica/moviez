package hu.syntaxerror.dzlica.moviez.repositories;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import org.springframework.data.repository.CrudRepository;

public interface MoviezRepo extends CrudRepository<Moviez, Long> {

}
