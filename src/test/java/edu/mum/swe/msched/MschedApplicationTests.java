package edu.mum.swe.msched;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.swe.msched.service.UserService;
import edu.mum.swe.msched.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MschedApplicationTests {

	@Test
	public void contextLoads() {
		UserService userService = new UserServiceImpl();
		//System.out.println(userService.getAllUsers().toString());
		userService.getAllUsers().forEach(System.out::print);		
	}

}
