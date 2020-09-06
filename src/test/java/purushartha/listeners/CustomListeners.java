package purushartha.listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;

import purushartha.base.TestBase;
import purushartha.utilities.MonitoringMail;
import purushartha.utilities.TestConfig;
import purushartha.utilities.TestUtil;



public class CustomListeners extends TestBase implements ITestListener , ISuiteListener {
    
	public String messageBody;
	public void onTestStart(ITestResult arg0) {
		test = rep.startTest(arg0.getName().toUpperCase());
		//runmodes -Y
		
		System.out.println(TestUtil.isTestRunnable(arg0.getName(), excel));
		
		
	}
		
	

	public void onTestSuccess(ITestResult arg0) {
		
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		
		
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><imgsrc= "+TestUtil.screenshotName+"height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+"Skipped the test as the Run mode is NO ");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	public void onStart(ITestContext arg0) {
		
		
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onFinish(ISuite suite) {
		MonitoringMail mail = new MonitoringMail();
		
		try {
			messageBody = "http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/DataDrivenLiveProject1/HTML_20Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(messageBody);
		
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}


