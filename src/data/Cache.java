package data;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class Cache {
    private HashMap<String, Integer> keys = new HashMap<>();
    private HashMap<String, Integer> values = new HashMap<>();

    public HashMap<String, Integer> getKeys() {
        return keys;
    }

    public HashMap<String, Integer> getValues() {
        return values;
    }

    public void add(String jsonMsg) {
        try {
            JSONObject jsonObj = new JSONObject(jsonMsg);

            // Key
            String currKey = jsonObj.getString("event_type");
            Integer currKeyCount = keys.get(currKey);

            if (currKeyCount == null) {
                currKeyCount = 0;
            }

            currKeyCount += 1;

            keys.put(currKey, currKeyCount);

            // Value
            String currValue = jsonObj.getString("data");
            Integer currValueCount = values.get(currValue);

            if (currValueCount == null) {
                currValueCount = 0;
            }

            currValueCount += 1;

            values.put(currValue, currValueCount);

            System.out.println("*** KEYS " + keys.toString());
            System.out.println("*** VALUES " + values.toString());
        } catch (JSONException e) {
           // e.printStackTrace();
        }
    }
}
