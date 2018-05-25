package com.fineframework.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fineframework.persistence.dao.UserMapper;
import com.fineframework.persistence.domain.User;
import com.fineframework.util.ResultCodeVo;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper ;
	
	@Transactional(rollbackFor = {Exception.class})
	public ResultCodeVo create(String json)  {
		User user = new User();
		user.setName("niceman");
		userMapper.insert(user);	
		return new ResultCodeVo(true,0,"success",null);
	}

	
	
	public ResultCodeVo getSingle(String json) {	
		return new ResultCodeVo(true,0,"success",userMapper.selectByPrimaryKey(1));
	}

}
