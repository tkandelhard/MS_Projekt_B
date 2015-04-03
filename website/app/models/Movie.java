package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	public User movieScoreOne;
	
	public User getMovieScoreOne() {
		return movieScoreOne;
	}
	public void setMovieScoreOne(User movieScoreOne) {
		this.movieScoreOne = movieScoreOne;
	}
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
	
	
}
