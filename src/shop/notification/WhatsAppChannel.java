package shop.notification;

public class WhatsAppChannel extends AbstractChannel {

    @Override
    public String channelName() {
        return "WhatsApp";
    }

    @Override
    protected String findDestination(CustomerContact contact) {
        String phone = contact.GetPhone();

        boolean validPrefix = phone.startsWith("08")
                || phone.startsWith("+62");

        if (validPrefix && phone.length() >= 10) {
            return phone;
        }

        return null;
    }

    @Override
    protected String prepareMessege(String message) {
        return "[Toko UMKM] " + message;
    }

    @Override
    protected boolean deliver(String destination, String message) {
        System.out.println("WhatsApp ke: " + destination);
        System.out.println("Pesan: " + message);
        return true;
    }
}
