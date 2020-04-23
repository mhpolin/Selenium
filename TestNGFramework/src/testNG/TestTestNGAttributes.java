package testNG;

import org.testng.annotations.Test;

public class TestTestNGAttributes {
	
  @Test(priority=0)
  public void d() {
  }
  
  @Test(dependsOnMethods = {"f"}, alwaysRun = true)
  public void y() {
  }
  
  @Test(priority=78)
  public void o() {
  }
  
  @Test
  public void h() {
  }
  
  @Test(priority=34)
  public void f() {
  }
  
  @Test(enabled = false)
  public void m() {
  }
}
