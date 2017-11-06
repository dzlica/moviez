package hu.syntaxerror.dzlica.moviez;

import hu.syntaxerror.dzlica.moviez.model.Moviez;
import hu.syntaxerror.dzlica.moviez.repositories.MoviezRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviezApplication implements CommandLineRunner {

	@Autowired
    MoviezRepo moviezRepo;


    public static void main(String[] args) {
		SpringApplication.run(MoviezApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		moviezRepo.save(new Moviez("Star Trek Discovery", "sci-fi", false));
//        moviezRepo.save(new Moviez("Designated survivor", "drama", false));
//        moviezRepo.save(new Moviez("Blade Runner", "sci-fi", true));
//        moviezRepo.save(new Moviez("Blade Runner 2049", "sci-fi", false));
//        moviezRepo.save(new Moviez("Aladdin", "animation", true));

	}
}
