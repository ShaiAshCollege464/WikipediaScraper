import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiUtil {
    public static void send(List<River> riverList) throws Exception {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(riverList);

            // The rest is the same as before
            URL url = new URL("http://localhost:9030/fm1/send-data");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Now we write the JSON string to the body
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();
            try {
                RiversResponseModel riversResponseModel = new ObjectMapper().readValue(content.toString(), RiversResponseModel.class);
                System.out.println("Total matches: " + riversResponseModel.getMatched());
                System.out.println("Non matched: ");
                int printSize = 10;
                riversResponseModel.getRiverList()
                        .stream()
                        .limit(printSize)
                        .forEach(river -> System.out.println(river.getName()));
                System.out.println("and " + (riversResponseModel.getRiverList().size() - printSize) + " more");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static JSONObject sendApiGetRequest(String path) {
        return sendApiGetRequest(path, new HashMap<>());
    }

    public static JSONObject sendApiGetRequest(String path, Map<String, String> params) {
        JSONObject jsonObject = null;
        StringBuilder result = new StringBuilder();
        try {
            if (params == null) {
                params = new HashMap<>();
            }
            StringBuilder paramBuilder = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (paramBuilder.length() != 0) paramBuilder.append(Constants.AND);
                paramBuilder.append(entry.getKey()).append(Constants.EQUALS).append(entry.getValue());
            }

            URL fullUrl = new URL(Constants.REST_DOMAIN + path + Constants.QUESTION_MARK + paramBuilder);
            HttpURLConnection conn = (HttpURLConnection) fullUrl.openConnection();

            conn.setRequestMethod(Constants.HTTP_REQUEST_GET);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            in.close();
            jsonObject = new JSONObject(result.toString());
        } catch (Exception ex) {
            jsonObject = new JSONObject();
            ex.printStackTrace();
        }
        return jsonObject;
    }
}
