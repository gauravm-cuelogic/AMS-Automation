package com.ams.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.ams.tests.CreateAssignmentTest;
import com.ams.tests.PRFinancialDashboardTest;
import com.ams.tests.ProofReaderAssignmentTest;
import com.ams.tests.UpdateAssignmentTest;
import com.ams.tests.WRFinancialDashboardTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	CreateAssignmentTest.class,
	UpdateAssignmentTest.class,
	ProofReaderAssignmentTest.class,
	WRFinancialDashboardTest.class,
	PRFinancialDashboardTest.class
})

public class AMSTestSuite {

}
