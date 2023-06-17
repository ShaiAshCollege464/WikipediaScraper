import java.util.List;

public class RiversResponseModel {
    private int matched;
    private List<River> riverList;

    public RiversResponseModel() {
    }

    public RiversResponseModel(List<River> riverList, int matched) {
        this.riverList = riverList;
        this.matched = matched;
    }

    public int getMatched() {
        return matched;
    }

    public void setMatched(int matched) {
        this.matched = matched;
    }

    public List<River> getRiverList() {
        return riverList;
    }

    public void setRiverList(List<River> riverList) {
        this.riverList = riverList;
    }
}
