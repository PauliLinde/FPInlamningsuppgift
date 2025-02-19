import com.mongodb.client.*;
import org.bson.Document;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class MongoDBAtlasDownloadExample {

    MovieFunctions mf = new MovieFunctions();
    public MongoDBAtlasDownloadExample() {

        //Skriv in rätt url!
        String uri = "mongodb+srv://paulinde:SecretPassword2025@cluster0.nibxg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            //Get all movies from 1975
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
            System.out.println("Actors that playes in more than 1 movie: " + mf.getAmountOfActorsThatPlayedInMoreThanOneMovie(movieList));
            System.out.println("The actor that played in most movies: " + mf.getNameOfActorThatPlayedInMostMovies(movieList));
            System.out.println("Amount of languages: " + mf.getAmountOfUniqueLanguages(movieList));
            System.out.println("There are movies with same title: " + mf.moreThanOneMovieWithSameTitle(movieList));



            //Här gör du anrop till alla dina funktioner som ska skriva ut svaren på frågorna som
            //efterfrågas i uppgiften


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MongoDBAtlasDownloadExample m = new MongoDBAtlasDownloadExample();
    }
}