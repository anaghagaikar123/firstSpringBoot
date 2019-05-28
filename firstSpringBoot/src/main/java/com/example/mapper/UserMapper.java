package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper {

	@Select("select * from user")
	List<User> findAll();
	
	@Insert("insert into user(name) values(#{name})")
	@SelectKey(statement = "select LAST_INSERT_ID()" , keyProperty = "id" , before = false , resultType = Long.class)
	void insert(User user);

	@Select("select * from user where id = #{id}")
	User findOne(Long id);

	@Update("UPDATE user SET name=#{name} WHERE id =#{id}")
	void update(User user);
	
}
