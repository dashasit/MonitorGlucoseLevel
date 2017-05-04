package sweety;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.codetheory.application.Application;
import com.codetheory.model.User;
import com.codetheory.model.UserGlucoseHistory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void adduser() {

		User user = new User("Code", "Theroy", new Date(), "demo", "demo");

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);

		ResponseEntity<User> response = restTemplate.exchange(
				createURLWithPort("/user/add"), HttpMethod.POST, entity,
				User.class);

		User actual = response.getBody();

	}

	@Test
	public void addUserGlucoseHistory() {

		UserGlucoseHistory history = new UserGlucoseHistory(1, 90, new Date());

		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserGlucoseHistory> entity = new HttpEntity<UserGlucoseHistory>(
				history, headers);

		ResponseEntity<UserGlucoseHistory> response = restTemplate.exchange(
				createURLWithPort("/user/glucoseHistory/add"), HttpMethod.POST,
				entity, UserGlucoseHistory.class);

		UserGlucoseHistory actual = response.getBody();

	}

}
