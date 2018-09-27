package com.spring.services;

import java.util.List;
import java.text.ParseException;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.*;

@SuppressWarnings("unused")
@Service
public class UserDAO {
	
	@Autowired
	 public SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	 }
	
	@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Transactional
	public void signup(User obj)
	{
		sessionFactory.getCurrentSession().save(obj);
	}
	@Transactional
	public User getUser(User obj)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.like("userName", obj.getUserName()));
		cr.add(Restrictions.like("password", obj.getPassword()));
		return (User) cr.uniqueResult();
	}
	@Transactional
	public void insert(Location obj)
	{
		sessionFactory.getCurrentSession().save(obj);
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Location> getLocation(String src,String des)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Location.class);
		cr.add(Restrictions.like("source",src));
		cr.add(Restrictions.like("destination",des));
		return cr.list();
	}
	@Transactional
	public User getUserById(Integer id)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.like("id",id));
		return (User) cr.uniqueResult();
	}
	@Transactional
	public Location getLocationByUser1(User u)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Location.class);
		cr.add(Restrictions.like("user",u));
		return (Location) cr.uniqueResult();
	}
	@Transactional
	public void saveInterest(Interest i)
	{
		sessionFactory.getCurrentSession().save(i);
	}
	@Transactional
	public void update(Interest i,User u)
	{
		User user=(User)sessionFactory.getCurrentSession().get(User.class, u.getId());
		user.setInterest(i);
		sessionFactory.getCurrentSession().update(user);
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Interest> getInterest(User obj)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Interest.class);
		cr.add(Restrictions.like("user",obj));
		return cr.list();
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<User> getListByUser(User u)
	{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(User.class);
		cr.add(Restrictions.like("id",u.getId()));
		return cr.list();
	}
	@Transactional
	public void updateInterest(User u,String status)
	{
		Interest i=(Interest)sessionFactory.getCurrentSession().get(Interest.class, u.getInterest().getId());
		i.setStatus(status);
		sessionFactory.getCurrentSession().update(i);
	}
	
}
