import java.util.List;

public class MovieDAOforTest {
    List<Movie> moviesTest = List.of(
            new Movie(
                    "tt0111161",
                    "The Shawshank Redemption",
                    1994,
                    142,
                    List.of("Drama"),
                    "Frank Darabont",
                    List.of("Tim Robbins", "Morgan Freeman", "Bob Gunton"),
                    9.3,
                    List.of("English")
            ),
            new Movie(
                    "tt0068646",
                    "The Godfather",
                    1972,
                    175,
                    List.of("Crime", "Drama"),
                    "Francis Ford Coppola",
                    List.of("Marlon Brando", "Al Pacino", "James Caan"),
                    9.2,
                    List.of("English", "Italian", "Latin")
            ),
            new Movie(
                    "tt0468569",
                    "The Dark Knight",
                    2008,
                    152,
                    List.of("Action", "Crime", "Drama", "Thriller"),
                    "Christopher Nolan",
                    List.of("Christian Bale", "Heath Ledger", "Aaron Eckhart"),
                    9.0,
                    List.of("English", "Mandarin")
            ),
            new Movie(
                    "tt1375666",
                    "Inception",
                    2010,
                    148,
                    List.of("Action", "Adventure", "Sci-Fi", "Thriller"),
                    "Christopher Nolan",
                    List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Elliot Page"),
                    8.8,
                    List.of("English", "Japanese", "French")
            ),
            new Movie(
                    "tt0109830",
                    "Forrest Gump",
                    1994,
                    142,
                    List.of("Drama", "Romance"),
                    "Robert Zemeckis",
                    List.of("Tom Hanks", "Robin Wright", "Gary Sinise"),
                    8.8,
                    List.of("English")
            ),
            new Movie(
                    "tt0120737",
                    "The Lord of the Rings: The Fellowship of the Ring",
                    2001,
                    178,
                    List.of("Adventure", "Drama", "Fantasy"),
                    "Peter Jackson",
                    List.of("Elijah Wood", "Ian McKellen", "Orlando Bloom"),
                    8.8,
                    List.of("English", "Sindarin", "Quenya")
            ),
            new Movie(
                    "tt0167260",
                    "The Lord of the Rings: The Return of the King",
                    2003,
                    201,
                    List.of("Adventure", "Drama", "Fantasy"),
                    "Peter Jackson",
                    List.of("Elijah Wood", "Viggo Mortensen", "Ian McKellen"),
                    8.9,
                    List.of("English", "Sindarin", "Quenya")
            ),
            new Movie(
                    "tt7286456",
                    "Joker",
                    2019,
                    122,
                    List.of("Crime", "Drama", "Thriller"),
                    "Todd Phillips",
                    List.of("Joaquin Phoenix", "Robert De Niro", "Zazie Beetz"),
                    8.4,
                    List.of("English")
            ),
            new Movie(
                    "tt0816692",
                    "Interstellar",
                    2014,
                    169,
                    List.of("Adventure", "Drama", "Sci-Fi"),
                    "Christopher Nolan",
                    List.of("Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"),
                    8.6,
                    List.of("English")
            ),
            new Movie(
                    "tt0110912",
                    "Pulp Fiction",
                    1994,
                    154,
                    List.of("Crime", "Drama"),
                    "Quentin Tarantino",
                    List.of("John Travolta"/*, "Uma Thurman", "Samuel L. Jackson"*/),
                    8.9,
                    List.of("English", "Spanish", "French")
            )
    );

    public List<Movie> getMovieList(){
        return moviesTest;
    }
}
