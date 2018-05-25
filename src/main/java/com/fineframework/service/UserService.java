package com.fineframework.service;

import com.fineframework.util.ResultCodeVo;

public interface UserService extends BaseService {

	public ResultCodeVo getSingle(String json);
}
