package org.openmrs.module.ugandaemrsync.tasks;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SendRecencyDataToCentralServerTaskTest {
	
	private SendRecencyDataToCentralServerTask sendRecencyDataToCentralServerTask;
	
	@Before
	public void setUp() {
		sendRecencyDataToCentralServerTask = new SendRecencyDataToCentralServerTask();
	}
	
	@Test
	public void testTaskSending() throws Exception {
		sendRecencyDataToCentralServerTask.execute();
		assertTrue(true);
		
	}
	
}
