package it.neo7bf.springbootconjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * For use github with sts follow this guide:
 * 	https://www.youtube.com/watch?v=FPPpjQ7TG2w
 */


@SpringBootApplication
public class SpringBootConJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
