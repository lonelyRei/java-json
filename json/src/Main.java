import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void getFilmsByPlaces(List<String> arr, String value, List<String> values) {
        arr.addAll(values);
        arr.add(value);
    }

    public static void main(String[] args) throws IOException {
        List<Film> films = new ArrayList<>();

        Director director1 = new Director("director1");
        Director director2 = new Director("director2");
        Director director3 = new Director("director3");
        Director director4 = new Director("director4");
        Director director5 = new Director("director5");
        Director director6 = new Director("director6");
        Director director7 = new Director("director7");
        Director director8 = new Director("director8");
        Director director9 = new Director("director9");
        Director director10 = new Director("director10");
        Director director11 = new Director("director11");
        Director director12 = new Director("director12");

        List<Director> directors = new ArrayList<>();
        directors.add(director1);
        directors.add(director2);
        directors.add(director3);
        directors.add(director4);
        directors.add(director5);
        directors.add(director6);
        directors.add(director7);
        directors.add(director8);
        directors.add(director9);
        directors.add(director10);
        directors.add(director11);
        directors.add(director12);

        List<Director> directorsWithOne = new ArrayList<>();
        directorsWithOne.add(director2);

        List<String> producers = new ArrayList<>();
        producers.add("Продюсер 1");
        producers.add("Продюсер 2");
        producers.add("Продюсер 3");

        List<String> countries = new ArrayList<>();
        countries.add("Russia");
        countries.add("USA");
        countries.add("France");
        countries.add("Romania");

        List<String> places1 = new ArrayList<>();
        places1.add("Norway");
        places1.add("Poland");

        List<String> places2 = new ArrayList<>();
        places2.add("Norway");
        places2.add("Russia");

        HashMap<String, String> actors = new HashMap<>();
        actors.put("actor1", "role1");
        actors.put("actor2", "role2");
        actors.put("actor3", "role3");



        Film film1 = new Film("film1", 2000, countries, places1, actors, "teaser 1", directors, producers);
        films.add(film1);

        Film film2 = new Film("film2", 1999, countries, places2, actors, "teaser 2", directors, producers);
        films.add(film2);

        Film film3 = new Film("film3", 1998, countries, places2, actors, "teaser 3", directorsWithOne, producers);
        films.add(film3);

        Film film4 = new Film("film4", 2001, countries, places1, actors, "teaser 4", directors, producers);
        films.add(film4);

        Film film5 = new Film("film5", 2006, countries, places2, actors, "teaser 5", directors, producers);
        films.add(film5);

        Film film6 = new Film("film6", 2010, countries, places1, actors, "teaser 6", directors, producers);
        films.add(film6);

        Film film7 = new Film("film7", 2016, countries, places2, actors, "teaser 7", directorsWithOne, producers);
        films.add(film7);

        Film film8 = new Film("film8", 2010, countries, places1, actors, "teaser 8", directors, producers);
        films.add(film8);

        Film film9 = new Film("film9", 2020, countries, places2, actors, "teaser 9", directors, producers);
        films.add(film9);

        Film film10 = new Film("film10", 2023, countries, places2, actors, "teaser 10", directors, producers);
        films.add(film10);

        Film film11 = new Film("film11", 1996, countries, places1, actors, "teaser 11", directors, producers);
        films.add(film11);

        Film film12 = new Film("film12", 2005, countries, places1, actors, "teaser 12", directors, producers);
        films.add(film12);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("films.json"), films);

        String result = objectMapper.writeValueAsString(films);
        System.out.println(result);

        byte[] jsonData = Files.readAllBytes(Paths.get("films.json"));
        ObjectMapper mapperBack = new ObjectMapper();

        Film[] res = mapperBack.readValue(jsonData, Film[].class);
        System.out.println("\nФильмы из файла:");
        for (Film film :res)
            System.out.println(film);

        System.out.println("\n===========================================================================\n");

        // 1 - мест съемки всех фильмов ( без повторений)
        Set<String> res1 = new HashSet<>();
        films.forEach(film -> res1.addAll(film.getPlaces()));
        System.out.println("Уникальные места съемки:");
        System.out.println(res1);

        // 2 - мест съемки всех фильмов с указанием списка фильмов, снятых там
        System.out.println("\nМеста съемки и фильмы:");
        List<List<String>> res2 = new ArrayList<>();
        films.forEach(film -> film.getPlaces().forEach(place -> res2.add(new ArrayList<>(){{add(place); add(film.getName());}})));
        var r2 = res2.stream().collect(Collectors.groupingBy(f -> f.get(0)));
        System.out.println(r2);

        // 3 - фильмов одного режиссера
        System.out.println("\nФильмы одного режисера:");
        var result3 = films.stream().filter(film -> film.getDirectors().size() == 1).toList();
        for(Film film: result3) {
            System.out.println(film);
        }


        // 4 - фильмов, в тизере которых встречаются определенные слова
        String substring = "teaser 1";
        System.out.println("\nФильмы, в тизере которых встречается: " + substring + ":");
        var result4 = films.stream().filter(film -> film.getTeaser().contains(substring)).toList();
        for(Film film: result4) {
            System.out.println(film);
        }

    }
}