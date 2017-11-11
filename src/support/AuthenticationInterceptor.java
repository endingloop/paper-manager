package support;


import com.opensymphony.xwork2.interceptor.Interceptor;

import model.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Action;
import java.util.Map;

public class AuthenticationInterceptor implements Interceptor  {

    public void destroy () {}

    public void init() {}

    public String intercept(ActionInvocation actionInvocation) throws Exception {

        Map session = actionInvocation.getInvocationContext().getSession();

        User user = (User) session.get(Constants.USER_KEY);

        boolean isAuthenticated = (null!=user);

        if (!isAuthenticated) {
            return Action.LOGIN;
        }
        else {
            return actionInvocation.invoke();
        }

    }
}
