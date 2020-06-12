package ro.esolacad.javaad;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import ro.esolacad.javaad.unittest.CarShopTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({CarShopTest.class})
@IncludeTags("exceptional")
public class TestSuiteByClass {
}
