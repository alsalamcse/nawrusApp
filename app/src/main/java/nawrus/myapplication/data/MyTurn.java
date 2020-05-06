package nawrus.myapplication.data;

public class MyTurn {
    private String key;
    private String beginHour;
    private String finishHour;
    private String date;
    private String name2;
    private String phone2;
    private String email2;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

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
                ", name2='" + name2 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email2='" + email2 + '\'' +
                '}';
    }
}
