package code.admin.lap4;

public class Restaurant {
    private String name="";
    private String address = "";
    private String type = "";



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String st=getName().toString();
        String ad=getAddress().toString();
        return(st+ad);
    }
}
