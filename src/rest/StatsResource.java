package rest;

import data.Cache;
import data.Consumer;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;

@Path("events")
public class StatsResource {
    static Cache cache = new Cache();

    @GET
    @Path("/stats")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStats() {
        HashMap<String, Integer> keys = cache.getKeys();
        HashMap<String, Integer> values = cache.getValues();

        JSONObject jsonKeysObj = new JSONObject(keys);
        JSONObject jsonValuesObj = new JSONObject(values);

        return "{ " +
            "\"keysCount\": " + jsonKeysObj + ", " +
            "\"valuesCount\": " + jsonValuesObj +
        "}";
    }

    @GET
    @Path("/listen")
    public boolean startListen() {
        Consumer consumer = new Consumer(cache);

        try {
            consumer.consume();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
