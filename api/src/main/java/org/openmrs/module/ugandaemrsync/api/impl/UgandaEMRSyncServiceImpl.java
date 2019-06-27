/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ugandaemrsync.api.impl;

import org.openmrs.api.UserService;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ugandaemrsync.api.UgandaEMRSyncService;
import org.openmrs.module.ugandaemrsync.api.dao.UgandaEMRSyncDao;

import java.util.List;

public class UgandaEMRSyncServiceImpl extends BaseOpenmrsService implements UgandaEMRSyncService {
	
	UgandaEMRSyncDao dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(UgandaEMRSyncDao dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public List getDatabaseRecord(String query) {
		return dao.getDatabaseRecord(query);
	}
	
	@Override
	public List getFinalList(List<String> columns, String finalQuery) {
		return dao.getFinalResults(columns, finalQuery);
	}
}
