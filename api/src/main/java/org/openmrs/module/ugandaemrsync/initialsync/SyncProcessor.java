package org.openmrs.module.ugandaemrsync.initialsync;

import com.oracle.javafx.jmx.json.JSONException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.openmrs.module.ugandaemrsync.server.UgandaEMRRecord;

import java.io.IOException;
import java.util.*;

/**
 * Created by lubwamasamuel on 20/02/2017.
 */
public class SyncProcessor {

    public static String listmap_to_json_string(List list, List<String> columns) throws IOException {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object rows[] = (Object[]) it.next();
            Map<String, String> row = new HashMap<String, String>();

            for (int i = 0; i < columns.size(); i++) {
                row.put(columns.get(i), String.valueOf(rows[i]));
            }

            result.add(row);

        }

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = mapper.writeValueAsString(result);

        return jsonInString;
    }

}
