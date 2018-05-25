package com.fineframework.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fineframework.component.kafka.KafkaService;
import com.fineframework.component.quartz.QuartzTool;
import com.fineframework.component.quartz.SampleJob;
import com.fineframework.component.redis.RedisService;
import com.fineframework.service.UserService;
import com.fineframework.util.ResultCodeVo;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private KafkaService kafkaService;
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private QuartzTool quartzTool;

	@RequestMapping("/create")
	@ResponseBody
	public String create(HttpServletRequest request) {

		return "home2";

	}

	@RequestMapping("/query")
	@ResponseBody
	public ResultCodeVo query(HttpServletRequest request) {

		return this.userService.getSingle(null);

	}

	@RequestMapping("/kafka")
	@ResponseBody
	public String home(HttpServletRequest request) {
		kafkaService.send();
		return null;
	}

	@RequestMapping("/redis")
	@ResponseBody
	public String redis(HttpServletRequest request) {
		redisService.set("keys", "hello world");
		return null;
	}
	
	
	@RequestMapping("/session")
	@ResponseBody
	public String session(HttpServletRequest request) {
		
		request.getSession().setAttribute("test", "redis session");
		return (String)request.getSession().getAttribute("test");
	}
	
	@RequestMapping("/startjob")
	@ResponseBody
	public String quartz(HttpServletRequest request) {
		
		quartzTool.addJob("ip1", "ip", "ip1","ip", SampleJob.class, "0/1 * * * * ?");
		
		return null;
	}
	
	@RequestMapping(value = "/stopjob")
	@ResponseBody
	public String stopjob() {
		quartzTool.removeJob("ip1", "ip", "ip1","ip");		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
