package hu.syntaxerror.dzlica.moviez.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String password;

    @ManyToMany(mappedBy = "users")
    private Set<Moviez> moviezs;

    public Set<Moviez> getMoviezs() {
        return moviezs;
    }

    public void setMoviezs(Set<Moviez> moviezs) {
        this.moviezs = moviezs;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
