package com.spring.model;

import javax.persistence.CascadeType;                                                                                                                                      
import javax.persistence.Column;                                                                                                                                           
import javax.persistence.Entity;                                                                                                                                           
import javax.persistence.GeneratedValue;                                                                                                                                   
import javax.persistence.GenerationType;                                                                                                                                   
import javax.persistence.Id;                                                                                                                                               
import javax.persistence.ManyToOne;                                                                                                                                        
import javax.persistence.Table;                                                                                                                                            
import javax.validation.constraints.Min;                                                                                                                                   
import javax.validation.constraints.NotNull;                                                                                                                               
import javax.validation.constraints.Pattern;                                                                                                                               
import org.hibernate.annotations.ForeignKey;                                                                                                                               
                                                                                                                                                                           
import org.springframework.beans.factory.annotation.Autowired;                                                                                                             
import com.spring.*;                                                                                                                                                       
@SuppressWarnings("unused")                                                                                                                                                
@Entity                                                                                                                                                                    
@Table(name="Location")    
public class Location 
{
	@Id                                                                                                                                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	
	@Column(name="id")                                                                                                                                                     
	private Integer id;                                                                                                                                                    
	                                                                                                                                                                       
	@Column(name="source")                                                                                                                                              
	private String source;   
	
	@Column(name="destination")
	private String destination;
	
	@ManyToOne
	@ForeignKey(name="user")
	@Autowired
	private User user;

	public Location(Integer id, String source, String destination, User user) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.user = user;
	}
	public Location( String source, String destination, User user) {
		this.source = source;
		this.destination = destination;
		this.user = user;
	}
	public Location() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}