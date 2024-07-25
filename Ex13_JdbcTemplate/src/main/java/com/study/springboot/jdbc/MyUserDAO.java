package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository //컨포넌트. 스프링 컨테이너 시작시 자동으로 빈이 등록
public class MyUserDAO {
	//데이터베이스 사용하기 위한 코드
	//JDBC 작업을 위해 자동 주입 받는다.
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDTO> listForBeanPropertyRowMapper() {
		String query = "SELECT * FROM myuser";
		List<MyUserDTO> list = jdbcTemplate.query(
				query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class));
		
		//for(MyUserDTO : list) { //디버깅용
		// System.out.println(my);
		//}
		
		return list;
	}

}
