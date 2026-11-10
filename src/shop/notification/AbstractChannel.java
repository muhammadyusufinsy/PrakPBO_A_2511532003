package shop.notification;



public abstract class AbstractChannel implements NotificationChannel{

    private int sentCount = 0;
    private String lastDelivered = "";

    protected abstract String findDestination(CustomerContact contact);

    protected String prepareMessege(String messege){
        return messege;
    }

    protected abstract boolean deliver(String contact, String messege);

    @Override 
    public final boolean send(CustomerContact contact, String messege){

        if (contact == null || messege == null || messege.isBlank()){
            return false;
        }

        String destination = findDestination(contact);

        if (destination == null || destination.isBlank()){
            return false;
        }

        String preapareMessege = prepareMessege(messege);

        boolean success = deliver(destination, preapareMessege);
            
        if(success){
            sentCount++;
            lastDelivered = preapareMessege;
        
        }
        return success;

    }

    public int getSentCount(){
        return sentCount;
    }

    public String getLastDelivered(){
        return lastDelivered;
    }
}
