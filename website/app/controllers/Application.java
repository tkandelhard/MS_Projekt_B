package controllers;

import java.util.List;

import models.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Update;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbDiscover;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static List<Movie> movies = Ebean.find(Movie.class).findList();
	static List<User> users = Ebean.find(User.class).findList(); 

    public static Result index() {
        return ok(index.render("Your new application is ready.", movies, users));
    }
    
    public static Result addMovie() {
    	Form<Movie> form = Form.form(Movie.class).bindFromRequest();
    	Movie movie = form.get();
    	movie.save();
    	movies = Ebean.find(Movie.class).findList();
    	return redirect(routes.Application.index());
    }
    
    public static Result addUser() {
    	Form<User> form = Form.form(User.class).bindFromRequest();
    	User user = form.get();
    	user.save();
    	users = Ebean.find(User.class).findList();
    	return redirect(routes.Application.index());
    }
    
    public static Result allMovies() {
    	List<Movie> movies = Ebean.find(Movie.class).findList();
    	return ok(Json.toJson(movies));
    }
    
    //noch nicht komplett
    public static Result searchTmdbMovie() {
    	TmdbMovies movies = new TmdbApi("d6478dc62b65b51cbde03570490a69cc").getMovies();
    	MovieDb movie = movies.getMovie(5353, "en");
    	System.out.println(movie.getOriginalTitle());
    	return redirect(routes.Application.index());
    }
    
    public static Result discoverTmdbMovies() {
    	TmdbDiscover discovers = new TmdbApi("d6478dc62b65b51cbde03570490a69cc").getDiscover();
    	MovieResultsPage results = discovers.getDiscover(new Discover());
    	System.out.println(results.getResults());   	
    	return redirect(routes.Application.index());
    }
    
    public static Result addMovieRatingOne() {
    	Movie.rateMovieWithOne(1L, 1L);
    	return redirect(routes.Application.index());
    }
    
public static Result allRatedOne() {
    	
    	return redirect(routes.Application.index());
    }
    

}