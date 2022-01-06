package com.lalit.core;

import static org.junit.Assert.*;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lalit.core.services.PaymentService;
import com.lalit.core.services.PaymentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTests {
	

	@Autowired
	PaymentServiceImpl service;
	
	@Test
	public void testDependencyInjection() {
		assertNotNull(service.getDao());
		
	}

}
