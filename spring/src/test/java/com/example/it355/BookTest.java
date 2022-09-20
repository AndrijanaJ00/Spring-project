package com.example.it355;

import com.example.it355.entity.Author;
import com.example.it355.entity.Book;
import com.example.it355.repository.BookRepository;
import com.example.it355.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookTest {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Test
	void findAllTest() {

	Set<Author> set = new HashSet<>();
	set.add(new Author(1,"Jelena", "Peric"));

		Book b1 = new Book(1, "test1", "https://resizing.flixster.com/w7oW9FQj1r-lvHn2aNpWEMbXqWc=/180x257/v2/https://resizing.flixster.com/m-_iSmK-QO9H2Iurcv7uu4TrxCM=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzYwZGZhODY3LTI2YzktNGVkYy05YWJlLTVmMGNmMTY2YWZhNS5qcGc=", 4, "proba",
				set);
		Book b2 = new Book(2, "test2", "https://resizing.flixster.com/w7oW9FQj1r-lvHn2aNpWEMbXqWc=/180x257/v2/https://resizing.flixster.com/m-_iSmK-QO9H2Iurcv7uu4TrxCM=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzYwZGZhODY3LTI2YzktNGVkYy05YWJlLTVmMGNmMTY2YWZhNS5qcGc=", 1, "proba123",
				set);
		List<Book> bookList = new ArrayList<>();
		bookList.add(b1);
		bookList.add(b2);

		when(bookRepository.findAll()).thenReturn(bookList);

		Integer expectedCount = 2;
		System.out.println(bookService.findAll());
		assertEquals(expectedCount, bookService.findAll().size());
		assertTrue(bookService.findAll().contains(b1));
	}

	@Test
	void saveTest() {
		Set<Author> set = new HashSet<>();
		set.add(new Author(1,"Jelena", "Peric"));

		Book b1 = new Book(1, "test1", "https://resizing.flixster.com/w7oW9FQj1r-lvHn2aNpWEMbXqWc=/180x257/v2/https://resizing.flixster.com/m-_iSmK-QO9H2Iurcv7uu4TrxCM=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzYwZGZhODY3LTI2YzktNGVkYy05YWJlLTVmMGNmMTY2YWZhNS5qcGc=", 4, "proba", set);

		when(bookRepository.save(b1)).thenReturn(b1);
		System.out.println(b1);
		assertEquals(b1, bookService.save(b1));

	}

	@Test
	void updateTest() {
		Set<Author> set = new HashSet<>();
		set.add(new Author(1,"Jelena", "Peric"));

		Book b1 = new Book(1, "test1", "https://resizing.flixster.com/w7oW9FQj1r-lvHn2aNpWEMbXqWc=/180x257/v2/https://resizing.flixster.com/m-_iSmK-QO9H2Iurcv7uu4TrxCM=/ems.ZW1zLXByZC1hc3NldHMvbW92aWVzLzYwZGZhODY3LTI2YzktNGVkYy05YWJlLTVmMGNmMTY2YWZhNS5qcGc=", 4, "proba", set);

		when(bookRepository.save(b1)).thenReturn(b1);

		Book actualBook = bookService.save(b1);
		assertEquals(b1, actualBook);
		assertEquals(b1.getName(), actualBook.getName());
		assertEquals(b1.getImage(), actualBook.getImage());
		assertEquals(b1.getRating(), actualBook.getRating());
		assertEquals(b1.getDescription(), actualBook.getDescription());
	}

	@Test
	public void deleteByIdTest(){

		bookService.deleteById(1);
		verify(bookRepository, times(1)).deleteById(1);
	}
}