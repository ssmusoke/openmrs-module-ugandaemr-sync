package org.openmrs.module.ugandaemr.sync.ugserver;

/**
 * Created by lubwamasamuel on 11/10/16.
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

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

    public int getCheckConnection(String url) throws Exception {
        return sendGet(url, SyncConstant.HTTPS_PROTOCOL).getResponseCode();
    }

    /**
     * @param con
     * @return
     * @throws IOException
     */
    public String getHttpResponse(URLConnection con) throws IOException {

        InputStreamReader reader = new InputStreamReader(con.getInputStream());
        StringBuilder buf = new StringBuilder();
        char[] cbuf = new char[2048];
        int num;
        while (-1 != (num = reader.read(cbuf))) {
            buf.append(cbuf, 0, num);
        }
        String result = buf.toString();

        return result;
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
    public HttpURLConnection sendPost(String contentType, String content, String facilityName, String facilityId, String url, String requestType) throws Exception {
        URL obj = new URL(url);


        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("ContentType", contentType);
        con.setRequestProperty("ugandaemrsync.facilty.sync.facility.name", facilityName);
        con.setRequestProperty("ugandaemrsync.facilty.sync.facility.id", facilityId);
        con.setRequestProperty("ugandaemrsync.request.type", requestType);
        con.setRequestProperty("ugandaemrsync.content.accepted", SyncConstant.XML_CONTENT_TYPE);


        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeChars(content);
        wr.flush();
        wr.close();

        if (con.getResponseCode() == SyncConstant.CONNECTION_SUCCESS)
            return con;
        else
            return null;
    }

    public URLConnection sendPostBy(String contentType, String content, String facilityName, String facilityId, String url, String requestType) throws Exception {

        try {
            URL url1 = new URL(url);
            URLConnection con = url1.openConnection();

            // specify that we will send output and accept input
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setConnectTimeout(20000);  // long timeout, but not infinite
            con.setReadTimeout(20000);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            // tell the web server what we are sending
            con.setRequestProperty("Content-Type", "application/xml");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("ContentType", contentType);
            con.setRequestProperty("ugandaemrsync.facilty.sync.facility.name", facilityName);
            con.setRequestProperty("ugandaemrsync.facilty.sync.facility.id", facilityId);
            con.setRequestProperty("ugandaemrsync.request.type", requestType);
            con.setRequestProperty("ugandaemrsync.content.accepted", SyncConstant.XML_CONTENT_TYPE);

            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(content);
            writer.flush();
            writer.close();
            // reading the response
            return con;
        } catch (Throwable t) {
            t.printStackTrace(System.out);
        }
        return null;
    }
}