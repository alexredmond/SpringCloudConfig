package com.iva.server;

import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private ServletContext servletContext;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//  	http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();

		super.configure(http);
		String path = servletContext.getContextPath();
		http.authorizeRequests().antMatchers(path + "/decrypt").authenticated().and().csrf().disable();
		http.authorizeRequests().antMatchers(path + "/encrypt").authenticated().and().csrf().disable();
	}
}