/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.ugandaemrsync.fragment.controller;

import org.openmrs.module.appui.UiSessionContext;
import org.openmrs.module.ugandaemrsync.server.SyncConstant;
import org.openmrs.module.ugandaemrsync.server.SyncDataRecord;
import org.openmrs.module.ugandaemrsync.server.UgandaEMRHttpURLConnection;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;
import org.openmrs.ui.framework.page.PageModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  * Controller for a fragment that shows all users  
 */
public class GenerateInitialDataFragmentController {
	
	SyncDataRecord syncDataRecord = new SyncDataRecord();
	
	UgandaEMRHttpURLConnection ugandaEMRHttpURLConnection = new UgandaEMRHttpURLConnection();
	
	Integer max = 500;
	
	public void controller(UiSessionContext sessionContext, FragmentModel model) {
	}
	
	public void get(@SpringBean PageModel pageModel) throws Exception {
		
		List totals = syncDataRecord.getDatabaseRecord(SyncConstant.TABLES_TOTAL_QUERY);
		
		Map<String, Integer> numbers = convertListToMap(totals);
		
		Integer encounters = numbers.get("encounter");
		Integer obs = numbers.get("obs");
		Integer persons = numbers.get("person");
		Integer person_names = numbers.get("person_name");
		Integer person_addresses = numbers.get("person_address");
		Integer person_attributes = numbers.get("person_attribute");
		Integer patients = numbers.get("patient");
		Integer patient_identifiers = numbers.get("patient_identifier");
		Integer visits = numbers.get("visit");
		Integer encounter_providers = numbers.get("encounter_provider");
		Integer providers = numbers.get("provider");
		Integer encounter_roles = numbers.get("encounter_role");
		Integer fingerprints = numbers.get("fingerprint");

		processData(encounters, "api/encounters", SyncConstant.ENCOUNTER_QUERY, SyncConstant.ENCOUNTER_COLUMNS);
		processData(obs, "api/obs", SyncConstant.OBS_QUERY, SyncConstant.OBS_COLUMNS);
		processData(persons, "api/persons", SyncConstant.PATIENT_QUERY, SyncConstant.PATIENT_COLUMNS);
		processData(person_names, "api/person_names", SyncConstant.PERSON_NAME_QUERY, SyncConstant.PERSON_NAME_COLUMNS);
		processData(person_addresses, "api/person_addresses", SyncConstant.PERSON_ADDRESS_QUERY,
		    SyncConstant.PERSON_ADDRESS_COLUMNS);
		processData(person_attributes, "api/person_attributes", SyncConstant.PERSON_ATTRIBUTE_QUERY,
		    SyncConstant.PERSON_ATTRIBUTE_COLUMNS);
		processData(patients, "api/patients", SyncConstant.PATIENT_QUERY, SyncConstant.PATIENT_COLUMNS);
		processData(patient_identifiers, "api/patient_identifiers", SyncConstant.PATIENT_IDENTIFIER_QUERY,
		    SyncConstant.PATIENT_IDENTIFIER_COLUMNS);
		processData(visits, "api/visits", SyncConstant.VISIT_QUERY, SyncConstant.VISIT_COLUMNS);
		processData(encounter_providers, "api/encounter_providers", SyncConstant.ENCOUNTER_PROVIDER_QUERY,
		    SyncConstant.ENCOUNTER_PROVIDER_COLUMNS);
		processData(providers, "api/providers", SyncConstant.PROVIDER_QUERY, SyncConstant.PROVIDER_COLUMNS);
		processData(encounter_roles, "api/fingerprints", SyncConstant.FINGERPRINT_QUERY,
		    SyncConstant.FINGERPRINT_COLUMNS);
		
		pageModel.put("persons", totals);
		
	}
	
	private Map<String, Integer> convertListToMap(List list) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object rows[] = (Object[]) it.next();
			result.put(String.valueOf(rows[1]), Integer.valueOf(String.valueOf(rows[0])));
		}
		return result;
	}
	
	private void processData(Integer mySize, String url, String query, List<String> columns) throws Exception {
		
		int startIndex = 0;
		boolean entireListNotProcessed = true;
		int offset = 0;
		while (entireListNotProcessed) {
			List records = syncDataRecord.getDatabaseRecord(query, String.valueOf(offset), String.valueOf(max), columns);
			String json = SyncDataRecord.convertListOfMapsToJsonString(records, columns);
			Map response = ugandaEMRHttpURLConnection.sendPostBy(url, json);
			if (offset >= mySize || mySize <= max) {
				entireListNotProcessed = false;
			} else {
				startIndex = startIndex + 1;
			}
			offset = (startIndex * max) + 1;
		}
	}
	
}
