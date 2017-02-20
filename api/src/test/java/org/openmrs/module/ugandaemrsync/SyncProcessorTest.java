/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ugandaemrsync;

import org.junit.Test;
import org.openmrs.module.ugandaemrsync.initialsync.SyncProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * This is a unit test, which verifies logic in UgandaEMRSyncService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class SyncProcessorTest {

	
	@Test
	public void shouldConvertListToJsonString() throws IOException {
		List<Object[]> objects=new ArrayList<Object[]>();

		Object[] encounters = {"1",2,"7"};
		objects.add(encounters);
		List<String> columns = Arrays.asList("encounter_id","person_id","value_text");

		String result = SyncProcessor.listmap_to_json_string(objects,columns);

		assertNotNull(result.contains("1"));

	}
}
