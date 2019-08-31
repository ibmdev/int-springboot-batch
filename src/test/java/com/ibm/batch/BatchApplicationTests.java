package com.ibm.batch;

import com.ibm.batch.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
public class BatchApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void contextLoads() {
		System.out.println("Nombre étudiants  : " +studentRepository.findAll().size());
		Assertions.assertEquals(3,studentRepository.findAll().size());


	}

}
