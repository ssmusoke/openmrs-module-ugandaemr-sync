package org.openmrs.module.ugandaemrsync.server;

import org.openmrs.api.context.Context;
import org.openmrs.module.sync.SyncRecord;
import org.openmrs.module.sync.SyncRecordState;
import org.openmrs.module.sync.api.SyncService;

import java.util.List;

/**
 * Created by lubwamasamuel on 27/10/16.
 */
public class UgandaEMRRecord {
	
	public UgandaEMRRecord() {
	}
	
	/**
	 * @return List<SyncRecord>
	 */
	public List<SyncRecord> newSyncRecords(SyncRecordState syncRecordState) {
		SyncService syncService = Context.getService(SyncService.class);
		List<SyncRecord> syncRecordList = syncService.getSyncRecords(syncRecordState);
		return syncRecordList;
	}
	
	public SyncRecord updateSyncedRecord(SyncRecord syncRecord) {
		SyncService syncService = Context.getService(SyncService.class);
		syncService.updateSyncRecord(syncRecord);
		return syncRecord;
	}
}
