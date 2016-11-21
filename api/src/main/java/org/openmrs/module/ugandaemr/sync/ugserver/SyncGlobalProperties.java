package org.openmrs.module.ugandaemr.sync.ugserver;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.api.context.Context;
import org.openmrs.module.sync.api.SyncService;
import org.openmrs.module.sync.api.impl.SyncServiceImpl;

import static org.openmrs.module.ugandaemr.sync.ugserver.SyncConstant.*;

/**
 * Created by lubwamasamuel on 10/11/2016.
 */
public class SyncGlobalProperties {
    public SyncGlobalProperties() {
    }

    protected Log log = LogFactory.getLog(getClass());

    public void setSyncFacilityProperties() {
        /**
         * Setting Server IP Address
         */

        if (getGlobalProperty(SERVER_IP) == null) {
            setGlobalProperty(SERVER_IP, SERVER_IP_PLACE_HOLDER);
            log.info("Default Server IP is Set");
        }


        if (getGlobalProperty(HEALTH_CENTER_SYNC_ID) == null) {
            setGlobalProperty(HEALTH_CENTER_SYNC_ID, HEALTH_CENTER_SYNC_ID_PLACE_HOLDER);
            log.info("Place Holder for HC Sync ID is set");
        }


        if (getGlobalProperty(HEALTH_CENTER_LOCATION_NAME) == null) {
            setGlobalProperty(HEALTH_CENTER_LOCATION_NAME, HEALTH_CENTER_LOCATION_NAME_PLACE_HOLDER);
            log.info("Place Holder for HC District is Sent");
        }
        if (getGlobalProperty(HEALTH_CENTER_LOCATION_NAME) == null) {
            setGlobalProperty(HEALTH_CENTER_UUID, HEALTH_CENTER_UUID_PLACE_HOLDER);
            log.info("Place Holder for Sync UUID is set");
        }
    }


    public GlobalProperty setGlobalProperty(String property, String propertyValue) {
        GlobalProperty globalProperty = new GlobalProperty();

        globalProperty.setProperty(property);
        globalProperty.setPropertyValue(propertyValue);


        return Context.getAdministrationService().saveGlobalProperty(globalProperty);
    }

    public String getGlobalProperty(String property) {
        GlobalProperty globalProperty = new GlobalProperty();
        return Context.getAdministrationService().getGlobalProperty(property);
    }

}
