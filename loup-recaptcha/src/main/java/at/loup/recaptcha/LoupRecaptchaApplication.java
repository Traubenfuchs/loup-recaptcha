package at.loup.recaptcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ComponentScan(basePackages = { "at.loup" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoupRecaptchaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LoupRecaptchaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LoupRecaptchaApplication.class);
	}
}
