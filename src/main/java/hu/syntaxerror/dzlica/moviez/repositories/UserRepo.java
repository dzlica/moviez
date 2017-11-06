package hu.syntaxerror.dzlica.moviez.repositories;

import hu.syntaxerror.dzlica.moviez.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
