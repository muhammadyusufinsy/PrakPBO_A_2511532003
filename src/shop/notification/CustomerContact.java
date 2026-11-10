package shop.notification;

public final class CustomerContact {
    private final String name;
    private final String email;
    private final String phone;

    public CustomerContact (String name, String email, String phone){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name must not be blank");
        }
    

    this.name = name;
    this.email = (email == null) ? "" :  email;
    this.phone = (phone == null) ? "" : phone;
    }

    public String GetName(){
        return name;
    }

    public String GetEmail(){
        return email;
    }

    public String GetPhone(){
        return phone;
    }
}
