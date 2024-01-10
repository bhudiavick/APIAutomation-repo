import org.testng.annotations.*;

public class SampleClass {
	
	@BeforeSuite
	public void beforeCodeRun() {
		System.out.println("run before");
	}
	@AfterSuite
	public void afterCodeRun() {
		System.out.println("after");
	}
	@BeforeMethod
	public void beforeTestRun() {
		System.out.println("run before test");
	}
	@AfterMethod
	public void afterTestRun() {
		System.out.println("after running test");
	}
}
