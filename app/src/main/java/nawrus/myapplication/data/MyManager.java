package nawrus.myapplication.data;

import nawrus.myapplication.SignIn;

public class MyManager {
    private String key;
    private String name;
    private String subject;
    private String phone;
    private String date;
    private String hour;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }


    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "MyManager{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}
