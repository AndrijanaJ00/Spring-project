package com.example.it355;

import com.example.it355.entity.Author;
import com.example.it355.entity.Book;
import com.example.it355.entity.Role;
import com.example.it355.entity.User;
import com.example.it355.repository.BookRepository;
import com.example.it355.repository.UserRepository;
import com.example.it355.service.BookService;
import com.example.it355.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void findAllTest() {

	Set<Role> set = new HashSet<>();
	set.add(new Role(1,"user"));

		User u1 = new User(1, "ana", "ana123", set);
		User u2 = new User(1, "sanja", "sanja123", set);
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);

		when(userRepository.findAll()).thenReturn(userList);

		Integer expectedCount = 2;
		System.out.println(userService.findAll());
		assertEquals(expectedCount, userService.findAll().size());
		assertTrue(userService.findAll().contains(u1));
	}

	@Test
	void saveTest() {
		Set<Role> set = new HashSet<>();
		set.add(new Role(1,"user"));

		User u1 = new User(1, "ana", "ana123", set);

		when(userRepository.save(u1)).thenReturn(u1);
		System.out.println(u1);
		assertEquals(u1, userService.save(u1));

	}

	@Test
	void updateTest() {
		Set<Role> set = new HashSet<>();
		set.add(new Role(1,"user"));

		User u1 = new User(1, "ana", "ana123", set);

		when(userRepository.save(u1)).thenReturn(u1);

		User actualUser = userService.save(u1);
		assertEquals(u1, actualUser);
		assertEquals(u1.getUsername(), actualUser.getUsername());
		assertEquals(u1.getPassword(), actualUser.getPassword());
	}

	@Test
	public void deleteByIdTest(){

		userService.deleteById(1);
		verify(userRepository, times(1)).deleteById(1);
	}
}