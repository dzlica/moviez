package hu.syntaxerror.dzlica.moviez.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Moviez {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    boolean watched;
    String type;
    String genre;
    int score;

    LocalDate date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate duedate;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Moviez() {
        this.date = LocalDate.now();
        this.duedate = duedate;
    }

    public Moviez(String title, LocalDate date) {
        this.date = LocalDate.now();

    }

    public Moviez(long id, String title, String type, String genre, boolean watched) {
        this.id = id;
        this.title = title;
        this.watched = watched;
        this.type = type;
        this.genre = genre;
        this.date = LocalDate.now();
    }

    public Moviez(String title, String type, String genre, boolean watched, LocalDate date, LocalDate duedate, int score) {
        this.title = title;
        this.watched = watched;
        this.type = type;
        this.genre = genre;
        this.date = LocalDate.now();
        this.duedate = duedate;
        this.score = score;
    }

    public Moviez(LocalDate duedate) {
        this.duedate = duedate;
        this.date = LocalDate.now();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
