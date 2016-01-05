package at.loup.core.recaptcha;

// based on http://kielczewski.eu/2015/07/spring-recaptcha-v2-form-validation/
public interface RecaptchaValidator {
	boolean validate(String remoteIp, String response);
}
