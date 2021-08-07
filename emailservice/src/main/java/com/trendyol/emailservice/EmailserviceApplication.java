package com.trendyol.emailservice;

import com.trendyol.emailservice.EmailConfig.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailserviceApplication {

	@Autowired
	private EmailSenderService service;



	public static void main(String[] args) {
		SpringApplication.run(EmailserviceApplication.class, args);
	}

//		@EventListener(ApplicationReadyEvent.class)
//		public void triggerMail(){
//			service.sendSimpleEmail("fsefaokumus@gmail.com","Body-1","Subject-1");
//		}

}
