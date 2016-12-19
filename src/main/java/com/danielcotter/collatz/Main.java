package com.danielcotter.collatz;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.danielcotter.collatz.thread.ThreadController;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Main {

	public static void main(String args[]) throws BeansException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class);
		((ThreadController) context.getBean("threadController")).init();
	}
}