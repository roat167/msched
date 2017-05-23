package edu.mum.swe.msched;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()			
			.antMatchers("/css/**", "/js/**", "/themes/**", "/welcome" , "/", "/aboutus").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll()
				.successForwardUrl("/loginSucess").permitAll()	
				.usernameParameter("username")
                .passwordParameter("password")
                .failureUrl("/login?error=true")
			.and()
			 	.logout().logoutSuccessUrl("/login?logout") 
		    .and()
		     	.exceptionHandling().accessDeniedPage("/403")
		    .and()		  
		    .csrf();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		StringBuilder qAuthorities = new StringBuilder();		
		qAuthorities.append("select u.username, u.role from account u ");
		qAuthorities.append("where u.username = ?");
		auth.jdbcAuthentication()
         .dataSource(dataSource)
         .usersByUsernameQuery(
                 "select username, password, enabled from account where username=?")
         .authoritiesByUsernameQuery(qAuthorities.toString());
	}

}