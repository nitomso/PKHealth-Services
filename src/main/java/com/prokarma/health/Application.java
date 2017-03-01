package com.prokarma.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 

@SpringBootApplication
public class Application implements CommandLineRunner
{
	/*@Autowired
	private PostRepository postRepository;*/
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void run(String... arg0) throws Exception {
		for (int i = 0; i < 5; i++) {
			postRepository.save(new Post("Post "+i));
		}
		
	}*/
}
