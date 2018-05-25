package com.fineframework.component.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class CustomJobFactory extends SpringBeanJobFactory {

	@Autowired
	private AutowireCapableBeanFactory capableBeanFacotry;
	
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object jobInstance = super.createJobInstance(bundle);
		this.capableBeanFacotry.autowireBean(jobInstance);
		return jobInstance;
	}

	
}
