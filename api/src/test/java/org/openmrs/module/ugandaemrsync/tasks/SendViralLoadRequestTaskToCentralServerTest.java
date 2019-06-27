package org.openmrs.module.ugandaemrsync.tasks;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.module.ugandaemrsync.StandaloneContextSensitiveTest;

import static junit.framework.TestCase.assertTrue;

public class SendViralLoadRequestTaskToCentralServerTest extends StandaloneContextSensitiveTest {
	
	private SendViralLoadRequestTaskToCentralServer sendViralLoadRequestTaskToCentralServer;
	
	@Before
	public void setUp() {
		sendViralLoadRequestTaskToCentralServer = new SendViralLoadRequestTaskToCentralServer();
	}
	
	@Test
	public void testTaskSending() throws Exception {
		sendViralLoadRequestTaskToCentralServer.execute();
		assertTrue(true);
		
	}
	
}
