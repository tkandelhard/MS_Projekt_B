package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;
@Entity
public class User extends Model{
	
	@Id
	public Long userId;
	
	@Constraints.Required
	public String name;
	
	@Constraints.Email
	public String email;
	
	@ManyToMany(cascade=CascadeType.ALL)
	public Movie movieScoreOne;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
