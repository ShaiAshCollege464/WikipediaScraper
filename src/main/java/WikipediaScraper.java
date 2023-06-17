import java.util.ArrayList;
import java.util.List;

public class WikipediaScraper {
    public static void main(String[] args) {
        try {
            Challenge.showInstructions();
            List<River> riverList = new ArrayList<>();
            //Write your code here
            ApiUtil.send(riverList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
