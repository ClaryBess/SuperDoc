package com.example.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class TestApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	public void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
