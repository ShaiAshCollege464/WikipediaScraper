import org.json.JSONObject;

public class Challenge {
    public static void showInstructions () {
        JSONObject jsonObject = ApiUtil.sendApiGetRequest("/fm1/count-data-items");
        System.out.printf("There are currently %s rivers in the wiki list. Scrape as much as you can. ", jsonObject.getString(Constants.PARAM_VALUE));
    }
}
