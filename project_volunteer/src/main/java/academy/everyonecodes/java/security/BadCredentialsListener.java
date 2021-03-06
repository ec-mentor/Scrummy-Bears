package academy.everyonecodes.java.security;

import academy.everyonecodes.java.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class BadCredentialsListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	@Autowired
	LoginService loginService;

	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureEvent) {
		loginService.runFailedAuthenticationProcedure(authenticationFailureEvent);
	}
}
