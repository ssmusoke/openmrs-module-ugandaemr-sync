/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.ugandaemr.sync.api.ugserver;

import org.junit.Test;
import org.openmrs.module.ugandaemr.sync.ugserver.SyncConstant;
import org.openmrs.module.ugandaemr.sync.ugserver.UgandaEMRHttpURLConnection;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link ${UgandaEMRSyncService}}.
 */
public class HTTPURLConnectionTest extends BaseModuleContextSensitiveTest {

    @Test
    public void shouldSetupContext() throws Exception {
        UgandaEMRHttpURLConnection connectionRequest = new UgandaEMRHttpURLConnection();
        assertEquals(connectionRequest.sendGet("google.com/search?q=Samuel+Lubwama", SyncConstant.HTTP_PROTOCOL).getResponseCode(),200);
    }


}
