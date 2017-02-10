package org.openmrs.module.ugandaemrsync.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.openmrs.Location;
import org.openmrs.api.LocationService;
import org.openmrs.api.context.Context;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.openmrs.module.ugandaemrsync.server.SyncConstant.HEALTH_CENTER_SYNC_ID;

/**
 * Created by lubwamasamuel on 07/11/2016.
 */
public class SyncDataRecord {

    UgandaEMRHttpURLConnection ugandaEMRHttpURLConnection = new UgandaEMRHttpURLConnection();

    Log log = LogFactory.getLog(getClass());

    public SyncDataRecord() {
    }

    public int syncRecords(List newSyncRecords) {
        int connectionStatus = 200;
        try {
            connectionStatus = ugandaEMRHttpURLConnection.getCheckConnection("google.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (connectionStatus == SyncConstant.CONNECTION_SUCCESS) {
            int size = 0;
            Iterator it = newSyncRecords.iterator();
            UgandaEMRRecord ugandaEMRRecord = new UgandaEMRRecord();
            while (it.hasNext()) {
                Object row[] = (Object[]) it.next();
                try {
                    Map response = syncData(String.valueOf(row[1]));
                    Integer uuid = Integer.valueOf(String.valueOf(row[0]));
                    String success = String.valueOf(response.get("response"));
                    if (success.equalsIgnoreCase("successful")) {
                        ugandaEMRRecord.updateSyncedRecord(uuid);
                        size += 1;
                    }
                } catch (Exception e) {
                    System.out.println("Why no ");
                    e.printStackTrace();
                }
            }
            return size;
        } else {
            log.info("Connection to internet was not Successful. Code: " + connectionStatus);
            return 0;
        }
    }

    /**
     * @param syncRecord
     * @return
     * @throws Exception
     */
    public Map syncData(String syncRecord) throws Exception {
        String contentTypeXML = SyncConstant.XML_CONTENT_TYPE;
        String contentTypeJSON = SyncConstant.JSON_CONTENT_TYPE;

        SyncGlobalProperties syncGlobalProperties = new SyncGlobalProperties();

        String serverIP = syncGlobalProperties.getGlobalProperty(SyncConstant.SERVER_IP);
        String serverProtocol = syncGlobalProperties.getGlobalProperty(SyncConstant.SERVER_PROTOCOL);
        String facilitySyncId = syncGlobalProperties.getGlobalProperty(HEALTH_CENTER_SYNC_ID);

        String url = serverProtocol + serverIP + "/api";
        String facilityURL = serverProtocol + serverIP + "/ugandaemr/facility";

        UgandaEMRHttpURLConnection ugandaEMRHttpURLConnection = new UgandaEMRHttpURLConnection();

        try {
            UUID uuid = UUID.fromString(facilitySyncId);

            facilitySyncId = uuid.toString();

            return ugandaEMRHttpURLConnection.sendPostBy(contentTypeXML, syncRecord, facilitySyncId, url);

        } catch (IllegalArgumentException exception) {
            LocationService service = Context.getLocationService();

            Location location = service.getLocation(Integer.valueOf(2));

            Facility facility = new Facility(location.getName());

            ObjectMapper mapper = new ObjectMapper();

            String jsonInString = mapper.writeValueAsString(facility);

            Map facilityMap = ugandaEMRHttpURLConnection.sendPostBy(contentTypeJSON, jsonInString, facilitySyncId,
                    facilityURL);

            String uuid = String.valueOf(facilityMap.get("uuid"));

            if (uuid != null) {
                syncGlobalProperties.setGlobalProperty(HEALTH_CENTER_SYNC_ID, uuid);
                facilitySyncId = uuid;
                return ugandaEMRHttpURLConnection.sendPostBy(contentTypeXML, syncRecord, facilitySyncId, url);
            }
            return null;
        }
    }
}
