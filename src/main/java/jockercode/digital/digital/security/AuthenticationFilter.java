package jockercode.digital.digital.security;

import jockercode.digital.digital.controller.UserController;
import jockercode.digital.digital.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class AuthenticationFilter implements Filter {

    @Autowired
    private UserController userController;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Authentication user = SecurityContextHolder.getContext().getAuthentication();

        if (user == null) {
            chain.doFilter(request, response);
            return;
        }
        if (user.isAuthenticated()) {
            Users users = userController.getByUser(user.getName());
            httpRequest.setAttribute("userObject", users);

        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
