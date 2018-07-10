package com.juniorro.jjwtimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.juniorro.jjwtimplementation.entities.AppRole;
import com.juniorro.jjwtimplementation.entities.AppUser;
import com.juniorro.jjwtimplementation.service.AccountService;

@SpringBootApplication
public class JjwtImplementationApplication implements CommandLineRunner {
	
	@Autowired
	AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JjwtImplementationApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*accountService.saveRole(new AppRole(null, "USER"));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		
		accountService.saveUser(new AppUser(null, "juniorro", "letmein", null));
		accountService.saveUser(new AppUser(null, "admin", "letmein", null));
		
		accountService.addRoleToUser("juniorro", "USER");
		accountService.addRoleToUser("admin", "ADMIN");*/
	}
}
