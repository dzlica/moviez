package hu.syntaxerror.dzlica.moviez.model;

import java.util.ArrayList;
import java.util.Arrays;

public class Type {
    public static ArrayList<String> genres = new ArrayList<>(Arrays.asList("sci-fi", "drama", "comedy", "animation", "historical", "horror", "children", "family", "romance", "documentary"));

    public static ArrayList<String> types = new ArrayList<>(Arrays.asList("movie", "serial", "documentary"));

    public Type() {
    }
}
