package org.openmrs.module.ugandaemr.sync.ugserver;

import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.module.sync.api.SyncService;
import org.openmrs.module.sync.api.impl.SyncServiceImpl;

import java.io.BufferedReader;

/**
 * Created by lubwamasamuel on 27/10/16.
 */
public class SyncFacilitySettings {

    /**
     * This method Request for a Facility Sync ID from the Server based on the location
     * @throws Exception
     */
    public void requestForFacilityId() throws Exception {
        GlobalProperty globalProperty = new GlobalProperty();
        globalProperty = Context.getAdministrationService().getGlobalPropertyObject(SyncConstant.HEALTH_CENTER_NAME);

        String url = SyncConstant.SERVER_IP + "/";
        UgandaEMRHttpURLConnection httpURLConnection = new UgandaEMRHttpURLConnection();
        int responseCode = httpURLConnection.sendGet("getServerID", SyncConstant.HTTP_PROTOCOL).getResponseCode();
        BufferedReader bufferedReader = null;
        SyncService syncService=new SyncServiceImpl();
        if (responseCode == 200) {
            bufferedReader = httpURLConnection.getHttpResponse(httpURLConnection.sendPost(SyncConstant.XML_CONTENT_TYPE, "get facility Id", globalProperty.getValue().toString(), syncService.getGlobalProperty(SyncConstant.HEALTH_CENTER_SYNC_ID), url, SyncConstant.FACILITY_ID_REQUEST_TYPE));
        }
        httpURLConnection.getResponseString(bufferedReader);

    }

}
