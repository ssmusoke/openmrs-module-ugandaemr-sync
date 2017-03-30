package org.openmrs.module.ugandaemrsync;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.ugandaemrsync.server.SyncConstant;
import org.openmrs.module.ugandaemrsync.server.SyncDataRecord;
import org.openmrs.module.ugandaemrsync.server.SyncGlobalProperties;
import org.openmrs.scheduler.tasks.AbstractTask;

import java.util.List;
import java.util.Map;

/**
 * Created by lubwamasamuel on 21/02/2017.
 */
public class SyncTask extends AbstractTask {
	
	public void execute() {
		Context.openSession();
		if (!Context.isAuthenticated()) {
			authenticate();
		}
		
		SyncGlobalProperties syncGlobalProperties = new SyncGlobalProperties();
		
		Session session = Context.getRegisteredComponent("sessionFactory", SessionFactory.class).getCurrentSession();
		String sql = "SELECT record_id,payload FROM sync_record WHERE state = 'NEW'";
		SQLQuery query = session.createSQLQuery(sql);
		List results = query.list();
		
		SyncDataRecord syncDataRecord = new SyncDataRecord();
		
		int numberSynced = syncDataRecord.syncRecords(results);
		
		List totals = syncDataRecord.getDatabaseRecord(SyncConstant.TABLES_TOTAL_QUERY);
		
		Map<String, Integer> numbers = syncDataRecord.convertListToMap(totals);
		
		Integer fingerprints = numbers.get("fingerprint");
		Integer max = 500;
		
		try {
			syncDataRecord.processData(fingerprints, "api/fingerprints", SyncConstant.FINGERPRINT_QUERY,
			    SyncConstant.FINGERPRINT_COLUMNS, max);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
