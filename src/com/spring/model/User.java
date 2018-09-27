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
import com.spring.model.*;                                                                                                                                                       
@SuppressWarnings("unused")                                                                                                                                                
@Entity                                                                                                                                                                    
@Table(name="User")                                                                                                                                                        
public class User                                                                                                                                                          
{                                                                                                                                                                          
	@Id                                                                                                                                                                    
	@GeneratedValue(strategy = GenerationType.IDENTITY)                                                                                                                    
	@Column(name="id")                                                                                                                                                     
	private Integer id;                                                                                                                                                    
	                                                                                                                                                                       
	@Column(name="user_name")                                                                                                                                              
	private String userName;                                                                                                                                               
	                                                                                                                                                                       
	@Column(name="password")                                                                                                                                               
	private String password;                                                                                                                                               
	                                                                                                                                                                       
	@Column(name="mobile_number")                                                                                                                                          
	private String mobileNumber;  
	
	@ManyToOne
	@ForeignKey(name="interest")
	@Autowired
	private Interest interest;
	                                                                                                                                                                       
	public Interest getInterest() {
		return interest;
	}
	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	
	
	public User(Integer id, String userName, String password, String mobileNumber, Interest interest) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.interest = interest;
	}
	public User( String userName, String password, String mobileNumber, Interest interest) {
		super();
		this.userName = userName;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.interest = interest;
	}
	public User(Integer id, String userName, String password, String mobileNumber) {                                                                                       
	                                                                                                                                                                       
		this.id = id;                                                                                                                                                      
		this.userName = userName;                                                                                                                                          
		this.password = password;                                                                                                                                          
		this.mobileNumber = mobileNumber;                                                                                                                                  
	}           
	public User() {}
	public User(String userName, String password, String mobileNumber) {                                                                                                   
	                                                                                                                                                                       
		this.userName = userName;                                                                                                                                          
		this.password = password;                                                                                                                                          
		this.mobileNumber = mobileNumber;                                                                                                                                  
	}                                                                                                                                                                      
	public User(String userName, String password) {                                                                                                   
        
		this.userName = userName;                                                                                                                                          
		this.password = password;                                                                                                                                          
	}                                                                                                                                                                                                                                                                                    
	public Integer getId() {                                                                                                                                               
		return id;                                                                                                                                                         
	}                                                                                                                                                                      
	public void setId(Integer id) {                                                                                                                                        
		this.id = id;                                                                                                                                                      
	}                                                                                                                                                                      
                                                                                                                                                                           
	public String getUserName() {                                                                                                                                          
		return userName;                                                                                                                                                   
	}                                                                                                                                                                      
                                                                                                                                                                           
	public void setUserName(String userName) {                                                                                                                             
		this.userName = userName;                                                                                                                                          
	}                                                                                                                                                                      
                                                                                                                                                                           
	public String getPassword() {                                                                                                                                          
		return password;                                                                                                                                                   
	}                                                                                                                                                                      

	public void setPassword(String password) {                                                                                                                             
		this.password = password;                                                                                                                                          
	}                                                                                                                                                                      
                                                                                                                                                                           
	public String getMobileNumber() {                                                                                                                                      
		return mobileNumber;                                                                                                                                               
	}                                                                                                                                                                      
                                                                                                                                                                           
	public void setMobileNumber(String mobileNumber) {                                                                                                                     
		this.mobileNumber = mobileNumber;                                                                                                                                  
	}                                                                                                                                                                      
	                                                                                                                                                                       
	                                                                                                                                                                       
                                                                                                                                                                           
}                                                                                                                                                                          
                                                                                                                                                                           