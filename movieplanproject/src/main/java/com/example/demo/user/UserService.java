package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
UserRepo userrepo;

public User insert(User user)
{
	return userrepo.save(user);
}
public List<User> viewall()
{
	return userrepo.findAll();
}
public User viewbyid(int userid)
{
	return userrepo.findById(userid).get();
}
public User delete(int userid)
{
	User user=new User();
	if(userrepo.findById(userid).isPresent())
	{
		userrepo.deleteById(userid);
	}
		return user;
	}
public User update(int userid,User newuser)
{
	User olduser=userrepo.findById(userid).get();
	if(olduser!=null)
	{
		olduser.setUsername(newuser.getUsername());
		olduser.setPassword(newuser.getPassword());
		olduser.setCity(newuser.getCity());
		olduser.setLogin(newuser.getLogin());
	}
	return userrepo.save(olduser);
}
public User viewUsername(String Username)
{
	return userrepo.findbyusername(Username);
}
}
