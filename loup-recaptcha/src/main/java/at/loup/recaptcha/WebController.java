package at.loup.recaptcha;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import at.loup.core.recaptcha.RecaptchaProtected;

@Controller
public class WebController {

	@ModelAttribute("reCaptchaSiteKey")
	public String getRecaptchaSiteKey(@Value("${recaptcha.sitekey}") String reCaptchaSiteKey) {
		return reCaptchaSiteKey;
	}

	@RequestMapping(path = "/", method = { RequestMethod.GET })
	public String get() {
		return "recaptcha";
	}

	@RecaptchaProtected
	@RequestMapping(path = "/recaptcha-test", method = { RequestMethod.POST })
	public @ResponseBody String post() {
		return "recaptcha validated & POST request executed!";
	}
}
