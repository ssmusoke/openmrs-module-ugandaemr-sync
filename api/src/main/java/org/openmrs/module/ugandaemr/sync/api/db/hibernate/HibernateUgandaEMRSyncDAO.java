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
package org.openmrs.module.ugandaemr.sync.api.db.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.impl.SessionImpl;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.ugandaemr.sync.SyncSetting;
import org.openmrs.module.ugandaemr.sync.api.db.UgandaEMRSyncDAO;

/**
 * It is a default implementation of  {@link UgandaEMRSyncDAO}.
 */
public class HibernateUgandaEMRSyncDAO implements UgandaEMRSyncDAO {
    protected final Log log = LogFactory.getLog(this.getClass());

    private SessionFactory sessionFactory;

    /**
     * @param sessionFactory the sessionFactory to set
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @return the sessionFactory
     */
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * @param syncSetting The SyncSetting To Create
     */
    public void createSyncSetting(SyncSetting syncSetting) throws DAOException {
        if (syncSetting.getUuid() == null) {
            throw new DAOException("SyncSetting Must have a UUID");
        }
        try {
            Session session;
            if (getSessionFactory().getCurrentSession() != null) {
                throw new DAOException("Hibernate Session Required");
            } else {
                session = getSessionFactory().getCurrentSession();
                session.save(syncSetting);
            }
        } catch (DAOException e) {
            throw e;
        }
    }

    /**
     * @param name The name of The SyncSetting
     * @return SyncSetting
     */
    public SyncSetting getSyncSettingByName(String name) throws DAOException {

        SyncSetting nameResult = null;
        if (name != "") {
            nameResult = (SyncSetting) sessionFactory.getCurrentSession().createCriteria(SyncSetting.class).add(Restrictions.eq("name", name)).uniqueResult();
        }

        return nameResult;
    }
}