package com.training.educationsystem.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.training.educationsystem.entities.Admin;
import com.training.educationsystem.repositories.AdminRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= Replace.NONE)
@DataJpaTest
class AdminRepositoryTest {
	
	@Autowired
    private AdminRepository adminRepository;
	
	
	@Test
	public void testAdminLogin()	//test for admin login
	{
		Admin admin=new Admin();
		admin.setUserName("admin123");
		admin.setPassword("admin123");
		Admin expected=adminRepository.save(admin);
		Admin actual=adminRepository.findByUserNameAndPassword(admin.getUserName(), admin.getPassword());
		assertNotNull(actual);
		assertThat(actual).isEqualTo(expected);
	}
	
}
