package org.openmrs.module.ugandaemr.sync.ugserver;

/**
 * Created by lubwamasamuel on 11/10/16.
 */

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UgandaEMRHttpURLConnection {

    public UgandaEMRHttpURLConnection() {
    }

    private final String USER_AGENT = "Mozilla/5.0";
    // HTTP GET request
    public HttpURLConnection sendGet(String content, String protocol) throws Exception {

        URL obj = new URL(protocol + content);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        return con;

    }

    /**
     * @param con
     * @return
     * @throws IOException
     */
    public BufferedReader getHttpResponse(HttpURLConnection con) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        in.close();

        return in;
    }

    public StringBuffer getResponseString(BufferedReader bufferedReader) throws IOException {
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
        }
        return response;
    }



    // HTTP POST request

    /**
     * @param contentType
     * @param content
     * @param facilityName
     * @param facilityId
     * @param url
     * @param requestType
     * @return
     * @throws Exception
     */
    public HttpsURLConnection sendPost(String contentType, String content, String facilityName, String facilityId, String url, String requestType) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("ContentType", contentType);
        con.setRequestProperty("ugandaemrsync.facilty.sync.facility.name", facilityName);
        con.setRequestProperty("ugandaemrsync.facilty.sync.facility.id", facilityId);
        con.setRequestProperty("ugandaemrsync.facilty.sync.facility.id", facilityId);
        con.setRequestProperty("ugandaemrsync.request.type", requestType);

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(content);
        wr.flush();
        wr.close();

        System.out.println("\nSending 'POST' request to URL : " + url);

        if (con.getResponseCode() == SyncConstant.CONNECTION_SUCCESS)
            return con;
        else
            return null;
    }

}