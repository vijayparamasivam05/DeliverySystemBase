package com.spring.controller;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.*;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.ModelMap;

import com.ibm.icu.text.SimpleDateFormat;
import com.spring.model.*;
import com.spring.services.*;
@SessionAttributes("user")
@SuppressWarnings({ "unused", "serial" })
@Controller
public class UserController extends ExtendedModelMap {

	private HttpSession session;
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping("/index")
	public String index() 
	{
		return "login";
	}
	@RequestMapping("/login")
	public String login() 
	{
		return "login";
	}
	@RequestMapping("/sign")
	public String signup() 
	{
		return "signup";
	}
	@RequestMapping("/signup")
	public ModelAndView sign(@RequestParam("un") String un,@RequestParam("pw") String pw,@RequestParam("mn") String mn) 
	{	
		if(un==""||pw==""||mn=="")
			return new ModelAndView("signup","status","Enter details properly");
		else {
		User u=new User(un,pw,mn);
		userDao.signup(u);
		return new ModelAndView("login");
		}
	}

	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(@RequestParam("un") String un,@RequestParam("pw") String pw,ModelMap model)
	{
		User u=new User(un,pw);
		User user=userDao.getUser(u);
		
		if(user != null)
		{
			model.addAttribute(user);
			return new ModelAndView("home","name",u.getUserName());
		}
		else
		{
			return new ModelAndView("error");
		}
	}
	@RequestMapping("/offer")
	public String offer()
	{
		return "offer";
	}
	@RequestMapping("/insert")
	public ModelAndView insert(@RequestParam("src") String src,@RequestParam("des") String des,User user)
	{
		if((src!= "")&&(des!=""))
		{	Location l = new Location(src,des,user);
			userDao.insert(l);
			return new ModelAndView("offer","status",src+" to "+des+" is successfully registered!");
		}
		else
			return new ModelAndView("offer","status","Enter the source and Destination properly");
	}
	@RequestMapping("/find")
	public String find()
	{
		return "find";
	}
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("src") String src,@RequestParam("des") String des,@ModelAttribute("user") User user)
	{
		List<Location> l=userDao.getLocation(src,des);
		if (l.isEmpty())
			return new ModelAndView("find","status","No results found!");
		else
			return new ModelAndView("find","list",l);
	}
	@RequestMapping("/view")
	public ModelAndView view(@ModelAttribute("user") User user,@RequestParam("userId") Integer id)
	{
		User u=userDao.getUserById(id);
		Location l=userDao.getLocationByUser1(u);
		Interest i=new Interest(user,l,"Not Accepted");
		userDao.saveInterest(i);
		userDao.update(i,u);
		return new ModelAndView("find");
	}
	@RequestMapping("/mybooking")
	public ModelAndView mybooking(@ModelAttribute("user") User user)
	{
		List<Interest> l=userDao.getInterest(user);
		if (l.isEmpty())
			return new ModelAndView("findDetails","status","No results found!");
		else
			return new ModelAndView("findDetails","interestList",l);
	}
	@RequestMapping("/request")
	public ModelAndView request(@ModelAttribute("user") User user)
	{
		List<User> l=userDao.getListByUser(user);
		for(User u:l)
			System.out.println("Username"+u.getUserName());
		if (l.isEmpty())
			return new ModelAndView("offer","status","No results found!");
		else
			return new ModelAndView("request","list",l);
		
	}
	@RequestMapping("/accept")
	public String accept(@ModelAttribute("user") User user)
	{
		userDao.updateInterest(user,"Accepted");
		return "offer";
	}
	@RequestMapping("/deny")
	public String deny(@ModelAttribute("user") User user)
	{
		userDao.updateInterest(user,"Denied");
		return "offer";
	}
}
