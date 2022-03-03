package com.example.HenryBookstrore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HenryBookstrore.domain.Book;
import com.example.HenryBookstrore.domain.BookRepository;
import com.example.HenryBookstrore.domain.Category;
import com.example.HenryBookstrore.domain.CategoryRepository;


@SpringBootApplication
public class HenryBookstroreApplication {
	private static final Logger log = LoggerFactory.getLogger(HenryBookstroreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HenryBookstroreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Education"));
			crepository.save(new Category("Romance"));
			
			brepository.save(new Book("Abc kirja", "Kate Johnson", 2000, "999-8-16-987654-1", 9.99, crepository.findByName("Horror").get(0)));
			brepository.save(new Book("Dev kirja", "Jon Kateson", 1999, "999-8-16-987654-2", 19.99, crepository.findByName("Education").get(0)));	
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
