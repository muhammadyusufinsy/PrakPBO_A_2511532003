package shop.notification;

public class EmailChannel extends AbstractChannel{

    @Override 
    public String channelName(){
        return "email";
    }

    @Override 
    protected String findDestination(CustomerContact contact){
        String email = contact.GetEmail();

        if(email.contains("@")){
            return email;
        }

        return null;

    }

    @Override 
    protected boolean deliver(String destination, String messege){
        System.out.println("email ke: " + destination);
        System.out.println("pesan: " + messege);
        return true;
    }

}
