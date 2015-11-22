package com.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.struts.bean.User;

public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = 5283017925296746927L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		User user = (User) session.get("user");
		if(user == null){
			return ActionSupport.LOGIN;
		}
		
		return actionInvocation.invoke();
	}

}
