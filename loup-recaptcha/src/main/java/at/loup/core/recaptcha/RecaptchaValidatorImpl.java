package at.loup.core.recaptcha;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

// based on http://kielczewski.eu/2015/07/spring-recaptcha-v2-form-validation/
@Service
public class RecaptchaValidatorImpl implements RecaptchaValidator {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${recaptcha.secretkey}")
	private String recaptchaSecretKey;

	@Override
	public boolean validate(String remoteIp, String response) throws RestClientException {
		MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
		form.add("secret", recaptchaSecretKey);
		form.add("remoteip", remoteIp);
		form.add("response", response);

		RecaptchaResponse recaptchaResponse = restTemplate
				.postForEntity("https://www.google.com/recaptcha/api/siteverify", form, RecaptchaResponse.class)
				.getBody();
		
		return recaptchaResponse.getSuccess();
	}
}

class RecaptchaResponse {
	private boolean success;
	private Collection<String> errorCodes;

	public boolean getSuccess() {
		return success;
	}

	public Collection<String> getErrorCodes() {
		return errorCodes;
	}
}
