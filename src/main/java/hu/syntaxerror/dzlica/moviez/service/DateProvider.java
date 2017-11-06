package hu.syntaxerror.dzlica.moviez.service;

import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateProvider {
    @Autowired
    MoviezRepo moviezRepo;

    public LocalDate newdate(String dateInString) {
        LocalDate localDate = LocalDate.parse(dateInString);
        return localDate;
    }
}
