package nawrus.myapplication.data;

public class MyTurn {
    private String key;
    private String beginHour;
    private String finishHour;
    private String date;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getFinishHour() {
        return finishHour;
    }

    public void setFinishHour(String finishHour) {
        this.finishHour = finishHour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MyTurn{" +
                "key='" + key + '\'' +
                ", beginHour='" + beginHour + '\'' +
                ", finishHour='" + finishHour + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
