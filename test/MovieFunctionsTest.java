import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieFunctionsTest {

    MovieDAOforTest dao = new MovieDAOforTest();
    List<Movie> moviesForTest = dao.getMovieList();
    MovieFunctions mf = new MovieFunctions();


    @Test
    public final void getAmountOfMoviesTest(){
        assertEquals(10, mf.getAmountOfMovies(moviesForTest));
    }

    @Test
    public final void getLongestMovieTest(){
        assertEquals(201, mf.getLongestMovie(moviesForTest));
    }

    @Test
    public final void getAmountOfUniqeGenresTest(){
        assertEquals(8, mf.getAmountOfUniqeGenres(moviesForTest));
    }

    @Test
    public final void getListOfActorsWithHighestIMDBRateTest(){
        String cast = mf.getListOfActorsWithHighestIMDBRate(moviesForTest);

        assertTrue(cast.contains("Tim Robbins"));
        assertTrue(cast.contains("Morgan Freeman"));
        assertTrue(cast.contains("Bob Gunton"));
    }

    @Test
    public final void getTitleofMovieWithLowestAmountOfActorsTest(){

        assertTrue(mf.getTitleofMovieWithLowestAmountOfActors(moviesForTest).contains("Pulp Fiction"));
    }

    @Test
    public final void getAmountOfActorsThatPlayedInMoreThanOneMovieTest(){

        assertEquals(2, mf.getAmountOfActorsThatPlayedInMoreThanOneMovie(moviesForTest));
    }

    @Test
    public final void getNameOfActorThatPlayedInMostMoviesTest(){
        String theActor = mf.getNameOfActorThatPlayedInMostMovies(moviesForTest);

        assertTrue(theActor.contains("Elijah Wood") ||
                theActor.contains("Ian McKellen"));
    }

    @Test
    public final void getAmountOfUniqueLanguagesTest(){

        assertEquals(9, mf.getAmountOfUniqueLanguages(moviesForTest));
    }

    @Test
    public final void moreThanOneMovieWithSameTitleTest(){

        assertFalse(mf.moreThanOneMovieWithSameTitle(moviesForTest));
    }
}
