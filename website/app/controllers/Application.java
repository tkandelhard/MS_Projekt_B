package controllers;

import java.util.List;

import models.*;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Update;

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

}