package nawrus.myapplication.data;

public class MyClient {

    private String key;
    private String name1;
    private String phone1;
    private String email1;
    private String password1;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    @Override
    public String toString() {
        return "MyClient{" +
                "key='" + key + '\'' +
                ", name1='" + name1 + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", email1='" + email1 + '\'' +
                ", password1='" + password1 + '\'' +
                '}';
    }
}
