package at.loup.core.recaptcha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Aspect
@Component
class RecaptchaAspect {
	@Autowired
	private RecaptchaValidator recaptchaValidatorImpl;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@Around("@annotation(at.loup.core.recaptcha.RecaptchaProtected)")
	public Object validateRecaptchaResponse(ProceedingJoinPoint joinPoint) throws Throwable {
		if (recaptchaValidatorImpl.validate(request.getRemoteAddr(), request.getHeader("recaptcha-response"))) {
			return joinPoint.proceed();
		} else {
			response.setStatus(HttpStatus.CONFLICT.value());
			response.getOutputStream().print("Recaptcha failed!");
			return null;
		}
	}
}