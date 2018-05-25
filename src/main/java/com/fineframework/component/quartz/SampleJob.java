package com.fineframework.component.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fineframework.service.UserService;
@Component
public class SampleJob implements Job {

	@Autowired
	private UserService userService ;
	

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("hello my job --------------------"+userService);
	}

}
