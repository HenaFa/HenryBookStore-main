package com.example.HenryBookstrore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HenryBookstrore.domain.Book;
import com.example.HenryBookstrore.domain.BookRepository;


@SpringBootApplication
public class HenryBookstroreApplication {
	private static final Logger log = LoggerFactory.getLogger(HenryBookstroreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HenryBookstroreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Abc kirja", "Kate Johnson", 2000, "999-8-16-987654-1", 9.99));
			repository.save(new Book("Dev kirja", "Jon Kateson", 1999, "999-8-16-987654-2", 19.99));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
