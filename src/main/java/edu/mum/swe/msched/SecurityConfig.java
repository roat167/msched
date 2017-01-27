package edu.mum.swe.msched;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		  .antMatchers("/static/**", "/static/css/**", "/static/js/**").permitAll()
		  .antMatchers("/admin").access("hasRole('ADMIN')")  
		  //.hasAnyAuthority("ADMIN", "FACULTY", "STUDENT")
		  .anyRequest().permitAll()
		  .and()
		    .formLogin().loginPage("/login")
		    .usernameParameter("username").passwordParameter("password")		    
		    .successForwardUrl("/loginSucess").permitAll()			  
		  .and()
		    .logout().logoutSuccessUrl("/login?logout") 
		   .and()
		   .exceptionHandling().accessDeniedPage("/403")
		  .and()		  
		  .csrf();
		
//		 http.csrf().disable()
//		 .authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().antMatchers("/msched**")
//		.permitAll().antMatchers("/**")
//		.hasAnyAuthority("ADMIN", "FACULTY", "STUDENT")
//		.anyRequest()
//		.authenticated()
//		.and().
//		formLogin().loginPage("/login")
//		.successForwardUrl("/loginSucess").permitAll();
		
	}

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery("select username,password, enabled from users where username=?")
//			.authoritiesByUsernameQuery("select u.username, r.name from role r inner join r.users u where username=?");
		auth.inMemoryAuthentication().withUser("kloem").password("password").roles("ADMIN");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

}