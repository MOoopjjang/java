package com.mooop.def;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



/**
 * 
 * SpringBoot2 API Server Template Project
 * 
 *     DB Connection  (  MySQL + Common DBCP2.x + MyBatis + Transaction )
 *                  +
 *     ExceptionHandler  ( Custom Exception )
 *                  +
 *     HandlerInterceptor ( logging ) & AOP ( log , filter )
 *                  +
 *            CACHE ( EHCache )
 *                  +
 *           Worker ThreadPool 
 *                  +
 *               logback
 *                  +
 *        Dynamic I/F & Static I/f
 * 
 * 
 * @author MOoop
 *
 */


@EnableAspectJAutoProxy
@SpringBootApplication
public class MOoopDefApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MOoopDefApiProjectApplication.class, args);
	}

}
