package hu.syntaxerror.dzlica.moviez.repositories;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import hu.syntaxerror.dzlica.moviez.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

}

