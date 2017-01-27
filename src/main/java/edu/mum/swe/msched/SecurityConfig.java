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
//	@Autowired
//	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests()		  
//		  //.antMatchers("/admin").access("hasRole('ADMIN')")  
//		  .antMatchers("/admin").hasAnyAuthority("ADMIN", "FACULTY", "STUDENT")
//		  .anyRequest().authenticated()
//		  //.antMatchers("/resources/**", "/").permitAll()
//		  .and()
//		    .formLogin().loginPage("/login")
//		    .usernameParameter("username").passwordParameter("password")		    
//		    .successForwardUrl("/loginSucess").permitAll()			  
//		  .and()
//		    .logout().logoutSuccessUrl("/login?logout") 
//		   .and()
//		   .exceptionHandling().accessDeniedPage("/403")
//		  .and()		  
//		  .csrf();
//		
////		 http.csrf().disable()
////		 .authorizeRequests().antMatchers("/css/**", "/js/**").permitAll().antMatchers("/msched**")
////		.permitAll().antMatchers("/**")
////		.hasAnyAuthority("ADMIN", "FACULTY", "STUDENT")
////		.anyRequest()
////		.authenticated()
////		.and().
////		formLogin().loginPage("/login")
////		.successForwardUrl("/loginSucess").permitAll();
//		
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			//.antMatchers("/static/**", "/welcome" , "/")
			.antMatchers("/css/**", "/js/**", "/themes/**", "/welcome" , "/")
				.permitAll().anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").permitAll()
				.successForwardUrl("/loginSucess").permitAll()			  
			.and()
			 	.logout().logoutSuccessUrl("/login?logout") 
//		    .and()
//		     	.exceptionHandling().accessDeniedPage("/403")
		    .and()		  
		    .csrf();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.jdbcAuthentication().dataSource(dataSource)
//			.usersByUsernameQuery("select username,password, enabled from users where username=?")
//			.authoritiesByUsernameQuery("select u.username, r.name from role r inner join r.users u where username=?");
		auth.inMemoryAuthentication().withUser("kloem").password("password").roles("ADMIN");
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**");		
//	}

}