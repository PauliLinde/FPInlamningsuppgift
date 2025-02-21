import com.mongodb.client.*;
import org.bson.Document;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class MongoDBAtlasDownloadExample {

    MovieFunctions mf = new MovieFunctions();

    MovieTypeSearcher language = l -> l.stream().map(Movie::getLanguages).flatMap(value -> value.stream());
    MovieTypeSearcher genre = l -> l.stream().map(Movie::getGenres).flatMap(value -> value.stream());

    MovieTypeSearcher2 language2 = l -> l.getLanguages();
    MovieTypeSearcher2 genre2 = l -> l.getGenres();

    ActorSearcher actorsPlayedInMoreThanOneMovie = f -> f.filter(v -> v.getValue() > 1).count();
    ActorSearcher actorPlayedInMostMovies = f -> f.max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).get().toString();

    public MongoDBAtlasDownloadExample() {

        String uri = "mongodb+srv://paupau:SecretPassword2025@cluster0.nibxg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            List<Movie> movieList = new ArrayList<>();
            for (Document doc : moviesCollection.find(new Document("year", 1975))) {
                {
                    movieList.add(Movie.fromDocument(doc));
                }
            }

            System.out.println("Amount of movies: " + mf.getAmountOfMovies(movieList));
            System.out.println("The longest movie in minutes: " + mf.getLongestMovie(movieList));
            System.out.println("Amount of genres: " + mf.getAmountOfUniqeGenres(movieList));
            System.out.println("The cast in highest rated movie: " + mf.getListOfActorsWithHighestIMDBRate(movieList));
            System.out.println("The movie with lowest amount of actors: " + mf.getTitleofMovieWithLowestAmountOfActors(movieList));
            System.out.println("Actors that played in more than 1 movie: " + mf.getAmountOfActorsThatPlayedInMoreThanOneMovie(movieList));
            System.out.println("The actor that played in most movies: " + mf.getNameOfActorThatPlayedInMostMovies(movieList));
            System.out.println("Amount of languages: " + mf.getAmountOfUniqueLanguages(movieList));
            System.out.println("There are movies with same title: " + mf.moreThanOneMovieWithSameTitle(movieList));

            System.out.println();

            System.out.println("Amount of languages(högre ordningens funktion): " + mf.getAmountOfUniqueType(movieList, language));
            System.out.println("Amount of genres(högre ordningens funktion): " + mf.getAmountOfUniqueType(movieList, genre));
            System.out.println("Actors that played in more than 1 movie(högre ordningens funktion): " + mf.actorsPlayedInMoreThanOneMovie(movieList, actorsPlayedInMoreThanOneMovie));
            System.out.println("The actor that played in most movies(högre ordningens funktion): " + mf.actorsPlayedInMoreThanOneMovie(movieList, actorPlayedInMostMovies));
            System.out.println("Amount of languages(högre ordningens funktion, andra försöket): " + mf.getAmountOfUniqueType2(movieList, language2));
            System.out.println("Amount of genres(högre ordningens funktion, andra försöket): " + mf.getAmountOfUniqueType2(movieList, genre2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MongoDBAtlasDownloadExample m = new MongoDBAtlasDownloadExample();
    }
}