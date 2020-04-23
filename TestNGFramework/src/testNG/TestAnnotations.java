package testNG;

import org.testng.annotations.*;

public class TestAnnotations {
  @Test
  public void f1() {
	  System.out.println("Inside F1");
  }
  
  @Test
  public void f2() {
	  System.out.println("Inside F2");
  }
  
  @BeforeTest
  public void beforeAnyTest() {
	  System.out.println("Before Any Test");
  }
  
  @AfterTest
  public void afterAllTheTests() {
	  System.out.println("After All The Tests");
  }
  
  @BeforeMethod
  public void beforeEveryMethod() {
	  System.out.println("Before Every Test Method");
  }
  
  @AfterMethod
  public void afterEveryMethod() {
	  System.out.println("After Every Test Method");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class");
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }
}
