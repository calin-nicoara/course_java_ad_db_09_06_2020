package ro.esolacad.javaad;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("ro.esolacad.javaad.unittest")
public class TestSuiteByPackage {
}
