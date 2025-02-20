import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

@FunctionalInterface
    public interface MovieTypeSearcher {
    Stream getMovieType(List<Movie> movies);
};

