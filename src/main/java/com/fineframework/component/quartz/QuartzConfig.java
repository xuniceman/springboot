package com.fineframework.component.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
	
	@Autowired
	private CustomJobFactory customJobFactory;
	
	@Bean(name = "quartzScheduer")
	public SchedulerFactoryBean schedulerFactoryBean() {
		Resource quartzResource = new ClassPathResource("/quartz.properties");
		
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setJobFactory(customJobFactory);
		schedulerFactoryBean.setConfigLocation(quartzResource);
		return schedulerFactoryBean;
	}

	@Bean(name = "customJobFactory")
	public CustomJobFactory customJobFactory() {
		return new CustomJobFactory();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
