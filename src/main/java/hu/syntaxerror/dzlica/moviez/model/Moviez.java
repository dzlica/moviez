package hu.syntaxerror.dzlica.moviez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moviez {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    boolean watched;
    String type;

    public Moviez() {
    }

    public Moviez(long id, String title, String type, boolean watched) {
        this.id = id;
        this.title = title;
        this.watched = watched;
        this.type = type;
    }

    public Moviez(String title, Type type, boolean watched) {
        this.title = title;
        this.watched = watched;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
