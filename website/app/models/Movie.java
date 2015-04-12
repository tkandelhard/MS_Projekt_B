package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints;
import play.db.ebean.Model;
@Entity
public class Movie extends Model{

	@Id
	public Long movieId;
	
	@Constraints.Required
	public String title;
	
	public String summary;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String genre;
	public String ratingOverall;

	@ManyToMany(cascade=CascadeType.ALL)
	List<User> userRatingOne;
	
	@ManyToMany(cascade=CascadeType.ALL)
	List<User> userRatingTwo;
	
	@ManyToMany(cascade=CascadeType.ALL)
	List<User> userRatingThree;
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRatingOverall() {
		return ratingOverall;
	}
	public void setRatingOverall(String ratingOverall) {
		this.ratingOverall = ratingOverall;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	public static Finder<Long,Movie> find = new Finder<Long,Movie>(Long.class, Movie.class);
	
	public static void rateMovieWithOne(Long movieId, Long userId) {
		Movie movie = Ebean.find(Movie.class, movieId);
		User user = Ebean.find(User.class, userId);
		
		List<Movie> userRatingOneList = user.getMoviesRatedOne();
		
		userRatingOneList.add(movie);
		
		Ebean.save(user);

	}
	
}
