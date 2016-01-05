package at.loup.recaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = { "at.loup" })
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class LoupRecaptchaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoupRecaptchaApplication.class, args);
	}
}
