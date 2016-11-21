package org.openmrs.module.ugandaemr.sync.ugserver;

import org.openmrs.module.sync.SyncRecord;
import org.openmrs.module.sync.SyncRecordState;
import org.openmrs.module.sync.api.SyncService;
import org.openmrs.module.sync.api.impl.SyncServiceImpl;

import java.util.List;

/**
 * Created by lubwamasamuel on 07/11/2016.
 */
public class SyncDataRecord {

    public SyncDataRecord() {
    }

    public void syncRecord() {
        UgandaEMRRecord ugandaEMRRecord = new UgandaEMRRecord();

        List<SyncRecord> newSyncRecords = ugandaEMRRecord.newSyncRecords(SyncRecordState.NEW);

        for (SyncRecord syncRecord : newSyncRecords) {
            SyncService syncService = new SyncServiceImpl();
            syncRecord.getContainedClasses();
            SyncFacilitySettings syncFacilitySettings = new SyncFacilitySettings();

            try {
                syncData(syncService.getSyncRecords().get(1).getItems().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            syncRecord.setState(SyncRecordState.COMMITTED_AND_CONFIRMATION_SENT);
            syncService.updateSyncRecord(syncRecord);
        }


    }


    /**
     * @param syncRecord
     * @return
     * @throws Exception
     */
    public SyncRecord syncData(String syncRecord) throws Exception {
        String contecntType = SyncConstant.XML_CONTENT_TYPE;
        String facilitySyncId = new SyncGlobalProperties().getGlobalProperty(SyncConstant.HEALTH_CENTER_UUID);
        String facilityName = new SyncGlobalProperties().getGlobalProperty(SyncConstant.HEALTH_CENTER_NAME);
        String url = new SyncGlobalProperties().getGlobalProperty(SyncConstant.HEALTH_CENTER_LOCATION_NAME);
        String requestType = SyncConstant.SYNC_RECORD_REQUEST_TYPE;
        UgandaEMRHttpURLConnection ugandaEMRHttpURLConnection = new UgandaEMRHttpURLConnection();
        ugandaEMRHttpURLConnection.sendPost(contecntType, syncRecord, facilityName, facilitySyncId, url, requestType);
        return null;
    }


}
