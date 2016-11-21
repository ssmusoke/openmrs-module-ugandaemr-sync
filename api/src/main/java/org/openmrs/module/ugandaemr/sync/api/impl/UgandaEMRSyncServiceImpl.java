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
package org.openmrs.module.ugandaemr.sync.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.APIException;
import org.openmrs.api.db.DAOException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.ugandaemr.sync.SyncSetting;
import org.openmrs.module.ugandaemr.sync.api.UgandaEMRSyncService;
import org.openmrs.module.ugandaemr.sync.api.db.UgandaEMRSyncDAO;
import org.openmrs.module.ugandaemr.sync.api.db.hibernate.HibernateUgandaEMRSyncDAO;

/**
 * It is a default implementation of {@link UgandaEMRSyncService}.
 */
public class UgandaEMRSyncServiceImpl extends BaseOpenmrsService implements UgandaEMRSyncService {
	
	protected final Log log = LogFactory.getLog(this.getClass());
	
	private UgandaEMRSyncDAO dao;
	
	/**
     * @param dao the dao to set
     */
    public void setDao(UgandaEMRSyncDAO dao) {
	    this.dao = dao;
    }
    
    /**
     * @return the dao
     */
    public UgandaEMRSyncDAO getDao() {
        HibernateUgandaEMRSyncDAO dao =new HibernateUgandaEMRSyncDAO();
	    return dao;
    }


    public void createSyncSetting(SyncSetting syncSetting) throws APIException {
        if(syncSetting!=null){
            try {
                UgandaEMRSyncDAO ugandaEMRSyncDAO =new HibernateUgandaEMRSyncDAO();
                ugandaEMRSyncDAO.createSyncSetting(syncSetting);
            } catch (DAOException e) {
                throw e;
            }
        }
    }

    public SyncSetting getSyncSettingByName(String name) {
        return dao.getSyncSettingByName(name);
    }
}