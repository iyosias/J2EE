package com.struts.action;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.User;
import com.struts.interf.IAccountServiceLib;
import com.struts.sl.AccountServiceLib;


public class LoginAction extends ActionSupport implements SessionAware {


	private static final long serialVersionUID = 8262518988270204777L;
	
	private User user;
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public boolean isValidUser(User user){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAccountServiceLib asl = (AccountServiceLib) context.getBean("account");
		return asl.authenticate(user.getEmail(), user.getPassword());
		
	}
	
	@Override
	public String execute()throws Exception {
		clearFieldErrors();
		User user = (User) session.get("user");
		if (user != null){
			return SUCCESS;
		}
		else{
			User u = new User(this.user.getEmail(), this.user.getPassword());
			if(isValidUser(u)){
				session.put("user", u);
				return SUCCESS;
			}
			else{
				addFieldError("invalid", "Invalid email or password");
			}
			return INPUT;
		}
	}
	
	@Override
	public void validate(){
		if (StringUtils.isEmpty(user.getEmail())){
			addFieldError("user.email", "Email cannnot be blank");
		}
		if (StringUtils.isEmpty(user.getPassword())){
			addFieldError("user.password", "Password cannnot be blank");
		}
	}

}
