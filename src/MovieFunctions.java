import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MovieFunctions {


    public int getAmountOfMovies(List<Movie> m) {
        return m.size();
    }

    public int getLongestMovie(List<Movie> m) {
        return m.stream().map(Movie::getRuntime).max(Integer::compareTo).get();

    }

    public int getAmountOfUniqeGenres(List<Movie> m) {
        return (int) m.stream().map(Movie::getGenres).flatMap(value -> value.stream()).distinct().count();
    }

    public String getListOfActorsWithHighestIMDBRate(List<Movie> m) {
        return m.stream().max(Comparator.comparing(Movie::getImdbRating)).map(Movie::getCast).stream().flatMap(value -> value.stream())
                .collect(Collectors.joining(", ")).toString();
    }

    public String getTitleofMovieWithLowestAmountOfActors(List<Movie> m) {
        return m.stream().min(Comparator.comparing(c -> ((Integer)c.getCast().size()))).map(Movie::getTitle).get().toString();
    }

    public int getAmountOfActorsThatPlayedInMoreThanOneMovie(List<Movie> m) {
        List<String> actors = m.stream().map(Movie::getCast).flatMap(value -> value.stream()).toList();
        Map<String, Long> mapActors = actors.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return (int) mapActors.entrySet().stream().filter(v -> v.getValue() > 1).count();
    }

    public String getNameOfActorThatPlayedInMostMovies(List<Movie> m) {
        List<String> actors = m.stream().map(Movie::getCast).flatMap(value -> value.stream()).toList();
        Map<String, Long> mapActors = actors.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return mapActors.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).get().toString();
    }

    public int getAmountOfUniqueLanguages(List<Movie> m) {
        return (int) m.stream().map(Movie::getLanguages).flatMap(value -> value.stream()).distinct().count();
    }

    public boolean moreThanOneMovieWithSameTitle(List<Movie> m) {
        List<String> movieTitles = m.stream().map(Movie::getTitle).toList();
        Map<String, Long> mapTitles = movieTitles.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return mapTitles.entrySet().stream().anyMatch(v -> v.getValue() > 1);
    }

    //Högre ordningens funktioner
    public int getAmountOfUniqueType(List<Movie> m, MovieTypeSearcher s) {
        return (int) s.getMovieType(m).distinct().count();
    }

    public Object actorsPlayedInMoreThanOneMovie(List<Movie> m, ActorSearcher aa){
        List<String> actors = m.stream().map(Movie::getCast).flatMap(value -> value.stream()).toList();
        Map<String, Long> mapActors = actors.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return aa.getActors(mapActors.entrySet().stream());
    }

    public int getAmountOfUniqueType2(List<Movie> m, MovieTypeSearcher2 s) {
        //return (int) m.stream().map(mo -> s.getMovieType(mo)).distinct().count();
        return (int) m.stream().map(mo -> s.getMovieType(mo)).flatMap(value -> value.stream()).distinct().count();
    }

}