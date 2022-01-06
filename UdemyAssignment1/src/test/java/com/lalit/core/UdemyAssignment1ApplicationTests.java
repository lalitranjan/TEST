package com.lalit.core;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UdemyAssignment1ApplicationTests {
	
	
	@Autowired
	AddNumber number;

	@Test
	public void testAddNumber() {
		assertEquals(10,number.addTwoNumber(6, 4));
	}

}
