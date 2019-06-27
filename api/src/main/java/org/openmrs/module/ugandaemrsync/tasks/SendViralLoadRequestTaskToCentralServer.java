package org.openmrs.module.ugandaemrsync.tasks;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openmrs.api.AdministrationService;
import org.openmrs.module.ugandaemrsync.server.SyncConstant;
import org.openmrs.scheduler.tasks.AbstractTask;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Posts recency data to the central server
 */

public class SendViralLoadRequestTaskToCentralServer extends AbstractTask {
	
	public static final String SERVER_URL = "http://10.0.0.0.245:5000";
	
	public static final String END_POINT = "viral-load";
	
	public static final String HEADER_EMR_DATE = "x-emr-date";
	
	protected Log log = LogFactory.getLog(getClass());
	
	@Autowired
	AdministrationService administrationService;
	
	@Override
    public void execute() {
        log.info("Executing");
        System.out.println("Executing");
        try {
            // TODO: Add code to verify if there is internet connection and if MIRTH Server is available (log this if not)
            // Ensuring connectivity
            // Contacting MIRTH server
            // Uploading data....
            // Data Successfully uploaded
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(SERVER_URL);
            post.addHeader(HEADER_EMR_DATE, new Date().toString());

            UsernamePasswordCredentials credentials
                    = new UsernamePasswordCredentials("ugandaemr001", "Ugandaemr123");
            post.addHeader(new BasicScheme().authenticate(credentials, post, null));

            List<List<Object>> result = getRecencyData();

            for (List<Object> row : result) {
                MultipartEntityBuilder multipartbuilder = MultipartEntityBuilder.create();
                multipartbuilder.addTextBody("patient_id", row.get(0).toString());
                multipartbuilder.addTextBody("sample_id", row.get(0).toString());
                multipartbuilder.addTextBody("sample_type", row.get(0).toString());
                multipartbuilder.addTextBody("test_type", row.get(0).toString());
                multipartbuilder.addTextBody("collection_date", row.get(0).toString());
                multipartbuilder.addTextBody("requester_contact", row.get(0).toString());
                multipartbuilder.addTextBody("phlebotomist_contact", row.get(0).toString());
                multipartbuilder.addTextBody("destination_id", "UgandaEMR");
                multipartbuilder.addTextBody("patient_id", row.get(0).toString());
                post.setEntity(multipartbuilder.build());

                HttpResponse response = client.execute(post);
                System.out.println(response.toString());
            }

        } catch (IOException | AuthenticationException e) {
            e.printStackTrace();
        }

    }
	
	private List<List<Object>> getRecencyData() {
		return administrationService.executeSQL(SyncConstant.VIRAL_LOAD_ENCOUNTER_QUERY, true);
		
	}
}
