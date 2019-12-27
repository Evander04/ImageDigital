package jockercode.digital.digital.security;

import jockercode.digital.digital.controller.UserController;
import jockercode.digital.digital.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class config extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserController userController;

    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService((String username) -> {

            Users user = userController.getByUser(username);

            if (user == null)
            {
                throw new UsernameNotFoundException(username);
            }
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority(user.getRole().get(0)));

            return new User(user.getUsername(), user.getPassword(),true,true,true,true, authorities);

        }).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*TODO: Review Security Info*/

        http.addFilterAfter(authenticationFilter, ChannelProcessingFilter.class).authorizeRequests()
                .antMatchers("/css/**","/js/**","/img/**","/fonts/**","/favicon.ico","/test").permitAll()
                .antMatchers("/branch/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/home").permitAll()
                .and()
                .logout().permitAll();

        http.httpBasic().and().csrf().disable();

    }


}
