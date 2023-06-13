import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Film {
    private String name;
    private Number year;
    private List<String> producersCountry;
    private List<String> places;
    private HashMap<String, String> actors;
    private String teaser;

    private List<String> producers;

    private List<Director> directors;

    public Film() {
        super();
    }

    public Film(String name,
         Number year,
         List<String> producersCountry,
         List<String> places,
         HashMap<String, String> actors,
         String teaser, List<Director> directors, List<String> producers) {
        this.name = name;
        this.actors = actors;
        this.places = places;
        this.teaser = teaser;
        this.year = year;
        this.producersCountry = producersCountry;
        this.directors = directors;
        this.producers = producers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getYear() {
        return year;
    }

    public void setYear(Number year) {
        this.year = year;
    }

    public List<String> getProducersCountry() {
        return producersCountry;
    }

    public void setProducersCountry(List<String> producersCountry) {
        this.producersCountry = producersCountry;
    }

    public List<String> getPlaces() {
        return places;
    }

    public void setPlaces(List<String> places) {
        this.places = places;
    }

    public HashMap<String, String> getActors() {
        return actors;
    }

    public void setActors(HashMap<String, String> actors) {
        this.actors = actors;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String toString() {
        return "Название: " + this.name + ", " +
                "Год выпуска " + this.year + ", " +
                "Актеры: " + this.actors.toString() + ", " +
                "Места: " + this.places + ", " +
                "Режисеры: " + this.directors + ", " +
                "Продюсеры: " + this.producers + ", " +
                "Страны: " + this.producersCountry + ", " +
                "Тизер: " + this.teaser;

    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<String> getProducers() {
        return producers;
    }

    public void setProducers(List<String> producers) {
        this.producers = producers;
    }
}
