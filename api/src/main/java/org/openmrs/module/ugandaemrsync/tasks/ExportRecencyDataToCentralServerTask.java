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
import org.openmrs.scheduler.tasks.AbstractTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Posts recency data to the central server
 */

public class ExportRecencyDataToCentralServerTask extends AbstractTask {

    public static final String MIRTH_URL = "http://mirth-tcp.globalhealthapp.net:6001";
    public static final String HEADER_EMR_DATE = "x-emr-date";
    protected Log log = LogFactory.getLog(getClass());

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

            if (netIsAvailable()) {
                System.out.println("Successful connection to the internet.");
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(MIRTH_URL);
                post.addHeader(HEADER_EMR_DATE, new Date().toString());

                UsernamePasswordCredentials credentials
                        = new UsernamePasswordCredentials("admin", "admin");
                post.addHeader(new BasicScheme().authenticate(credentials, post, null));

                String theRealShit = getRecencyData();

                HttpEntity multipart = MultipartEntityBuilder.create()
                        .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                        .addTextBody("facility_uuid", "93e74c67-f37f-40b8-af6c-94cdf0ea22bb")
                        .addTextBody("data", theRealShit, ContentType.TEXT_PLAIN)
                        .build();
                post.setEntity(multipart);

                HttpResponse response = client.execute(post);

                System.out.println(response.toString());
            }else{
                System.out.println("Cannot establish internet connectivity");
            }

        } catch (IOException | AuthenticationException e) {
            e.printStackTrace();
        }

    }

    private String getRecencyData() {
        return "patient_id, patient_creator, encounter_id, gravida, para$$$248,10,0,0,0$$$334,10,0,0,0$$$336,10,0,0,0$$$401,7,0,0,0$$$232,5,0,0,0$$$248,10,0,0,0$$$334,10,0,0,0$$$336,10,0,0,0$$$401,7,0,0,0$$$232,5,0,0,0$$$248,10,0,0,0$$$334,10,0,0,0$$$336,10,0,0,0$$$401,7,0,0,0$$$232,5,0,0,0$$$248,10,0,0,0$$$334,10,0,0,0$$$336,10,0,0,0$$$401,7,0,0,0$$$232,5,0,0,0$$$248,10,0,0,0$$$334,10,0,0,0$$$336,10,0,0,0$$$401,7,0,0,0";
    }

    private static boolean netIsAvailable() {
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            conn.getInputStream().close();
            return true;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return false;
        }
    }
}