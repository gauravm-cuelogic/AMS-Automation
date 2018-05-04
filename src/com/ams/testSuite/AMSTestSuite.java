package com.ams.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.ams.tests.CreateAssignmentTest;
import com.ams.tests.ProofReaderAssignmentTest;
import com.ams.tests.UpdateAssignmentTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	CreateAssignmentTest.class,
	UpdateAssignmentTest.class,
	ProofReaderAssignmentTest.class
})

public class AMSTestSuite {

}
