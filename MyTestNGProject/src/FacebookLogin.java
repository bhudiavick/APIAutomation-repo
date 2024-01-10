import org.testng.annotations.Test;

public class FacebookLogin {
	
	@Test
	public void loginWithValid() {
		System.out.println("valid");
	}
	@Test
	public void loginWithInValid() {
		System.out.println("negative");
	}
	
	@Test
	public void loginWithValidUser() {
		System.out.println("Positive");
	}
}
