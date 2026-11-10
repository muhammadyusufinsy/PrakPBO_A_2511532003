package shop.notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {

    private final List<NotificationChannel> channels = new ArrayList<>();

    public void register(NotificationChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Channel tidak boleh null!");
        }

        channels.add(channel);
    }

    public int broadcast(CustomerContact contact, String message) {

        int berhasil = 0;

        for (NotificationChannel channel : channels) {

            if (channel.send(contact, message)) {
                berhasil++;
            }
        }

        return berhasil;
    }
}
