package org.openmrs.module.ugandaemrsync.server;

import com.google.common.base.Joiner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openmrs.api.context.Context;

import java.io.IOException;
import java.util.*;

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
		}
		catch (Exception e) {
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
				}
				catch (Exception e) {
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
		
		SyncGlobalProperties syncGlobalProperties = new SyncGlobalProperties();
		
		String serverIP = syncGlobalProperties.getGlobalProperty(SyncConstant.SERVER_IP);
		String serverProtocol = syncGlobalProperties.getGlobalProperty(SyncConstant.SERVER_PROTOCOL);
		String facilitySyncId = syncGlobalProperties.getGlobalProperty(HEALTH_CENTER_SYNC_ID);
		
		String url = serverProtocol + serverIP + "/api";
		
		UgandaEMRHttpURLConnection ugandaEMRHttpURLConnection = new UgandaEMRHttpURLConnection();
		
		try {
			UUID uuid = UUID.fromString(facilitySyncId);
			
			facilitySyncId = uuid.toString();
			
			return ugandaEMRHttpURLConnection.sendPostBy(contentTypeXML, syncRecord, facilitySyncId, url);
			
		}
		catch (IllegalArgumentException exception) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("message", "No valid facility Id Found");
			return map;
		}
	}
	
	public List getDatabaseRecord(String query, String from, String to, List<String> columns) {
		SyncGlobalProperties syncGlobalProperties = new SyncGlobalProperties();
		String finalQuery = String.format(query, syncGlobalProperties.getGlobalProperty(HEALTH_CENTER_SYNC_ID), from, to);
		Session session = Context.getRegisteredComponent("sessionFactory", SessionFactory.class).getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(finalQuery);
		for (String column : columns) {
			sqlQuery.addScalar(column, StringType.INSTANCE);
		}
		return sqlQuery.list();
	}
	
	public List getDatabaseRecord(String query) {
		Session session = Context.getRegisteredComponent("sessionFactory", SessionFactory.class).getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		return sqlQuery.list();
	}
	
	public int update(String query) {
		Session session = Context.getRegisteredComponent("sessionFactory", SessionFactory.class).getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(query);
		return sqlQuery.executeUpdate();
	}
	
	public static Map<String, String> convertListOfMapsToJsonString(List list, List<String> columns, String updateColumn)
	        throws IOException {
		JSONArray result = new JSONArray();
		Iterator it = list.iterator();
		List<String> valuesToBeUpdated = new ArrayList<String>();
		Map<String, String> vals = new HashMap<String, String>();
		while (it.hasNext()) {
			Object rows[] = (Object[]) it.next();
			JSONObject row = new JSONObject();
			
			for (int i = 0; i < columns.size(); i++) {
				if (updateColumn == null || !columns.get(i).equalsIgnoreCase(updateColumn)) {
					row.put(columns.get(i), rows[i]);
				} else {
					valuesToBeUpdated.add(String.valueOf(rows[i]));
				}
			}
			
			result.put(row);
		}
		vals.put("json", result.toString());
		vals.put("updateValues", Joiner.on(",").join(valuesToBeUpdated));
		return vals;
	}
	
	public void processData(Integer mySize, String url, String query, List<String> columns, Integer max,
	        String updateColumn, String table, String columnToUpdate, String value) throws Exception {
		int startIndex = 0;
		boolean entireListNotProcessed = true;
		int offset = 0;
		while (entireListNotProcessed) {
			List records = getDatabaseRecord(query, String.valueOf(offset), String.valueOf(max), columns);
			Map<String, String> data = SyncDataRecord.convertListOfMapsToJsonString(records, columns, updateColumn);
			String json = data.get("json");
			ugandaEMRHttpURLConnection.sendPostBy(url, json);
			if (offset >= mySize || mySize <= max) {
				entireListNotProcessed = false;
			} else {
				startIndex = startIndex + 1;
			}
			offset = (startIndex * max);
			
			if (updateColumn != null) {
				String conditions = data.get("updateValues");
				String realQuery = "UPDATE TABLE " + table + " SET " + columnToUpdate + " ='" + value + "' WHERE "
				        + updateColumn + " IN(" + conditions + ")";
				update(realQuery);
			}
		}
	}
	
	public Map<String, Integer> convertListToMap(List list) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object rows[] = (Object[]) it.next();
			result.put(String.valueOf(rows[1]), Integer.valueOf(String.valueOf(rows[0])));
		}
		return result;
	}
}
