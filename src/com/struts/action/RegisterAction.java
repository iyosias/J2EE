package com.struts.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts.bean.Account;
import com.struts.interf.IAccountServiceLib;
import com.struts.sl.AccountServiceLib;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = -2100394969594430739L;
	
	private Account accountBean;
	
	@Override
	public String execute() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		IAccountServiceLib asl = (AccountServiceLib) context.getBean("account");
		//IAccountServiceLib asl = AccountServiceLibFactory.getAccountService();
		asl.createAccount(getAccountBean());
		
		return SUCCESS;
	}

	public Account getAccountBean() {
		return accountBean;
	}
	
	public void setAccountBean(Account accountBean) {
		this.accountBean = accountBean;
	}
	
	@Override
	public void validate(){
		if (StringUtils.isEmpty(accountBean.getEmail())){
			addFieldError("accountBean.email", "Email cannnot be blank");
		}
		else{
			String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            CharSequence inputStr = accountBean.getEmail();
            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(inputStr);
            if(!matcher.matches())
                addFieldError("accountBean.email","Invalid email address");
		}
		if (StringUtils.isEmpty(accountBean.getPassword())){
			addFieldError("accountBean.password", "Password cannnot be blank");
		}
		else if (accountBean.getPassword().length() < 6){
			addFieldError("accountBean.password", "Password must be minimum of 6 characters");
		}
		if (StringUtils.isEmpty(accountBean.getFirstname())){
			addFieldError("accountBean.firstname", "First Name cannnot be blank");
		}
		if (StringUtils.isEmpty(accountBean.getLastname())){
			addFieldError("accountBean.lastname", "Last Name cannnot be blank");
		}
		if (accountBean.getGender().equals("-1")){
			addFieldError("accountBean.gender", "You have to specify gender");
		}
		
	}
	
	

}
