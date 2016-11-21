package org.openmrs.module.ugandaemr.sync.ugserver;

import org.openmrs.module.sync.SyncRecord;
import org.openmrs.module.sync.SyncRecordState;
import org.openmrs.module.sync.api.SyncService;
import org.openmrs.module.sync.api.impl.SyncServiceImpl;

import java.util.List;

/**
 * Created by lubwamasamuel on 27/10/16.
 */
public class UgandaEMRRecord {
    public UgandaEMRRecord() {
    }

    /**
     *
     * @return List<SyncRecord>
     */
    public List<SyncRecord> newSyncRecords(SyncRecordState syncRecordState) {
        List<SyncRecord> syncRecordList=null;
        SyncService syncService = new SyncServiceImpl();
        syncRecordList = syncService.getSyncRecords(syncRecordState);
        return syncRecordList;
    }

    public SyncRecord updateAllSyncedRecords(SyncRecord syncRecord){
        SyncService syncService = new SyncServiceImpl();
        syncService.updateSyncRecord(syncRecord);
        return syncRecord;
    }
}
