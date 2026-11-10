package shop.notification;

public class SmsChannel extends AbstractChannel {

    private final int maxLength;

    public SmsChannel(int maxLength) {
        if (maxLength < 3) {
            throw new IllegalArgumentException(
                "Max length minimal 3!"
            );
        }

        this.maxLength = maxLength;
    }

    @Override
    public String channelName() {
        return "SMS";
    }

    @Override
    protected String findDestination(CustomerContact contact) {
        String phone = contact.GetPhone();

        if (phone.startsWith("08")) {
            return phone;
        }

        return null;
    }

    @Override
    protected String prepareMessege(String message) {
        if (message.length() > maxLength) {
            return message.substring(0, maxLength - 3) + "...";
        }

        return message;
    }

    @Override
    protected boolean deliver(String destination, String message) {
        System.out.println("SMS ke: " + destination);
        System.out.println("Pesan: " + message);
        return true;
    }
}
