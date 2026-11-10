
package shop.app;

import java.util.List;

import shop.StudentInfo;
import shop.model.Product;
import shop.model.PhysicalProduct;
import shop.model.DigitalProduct;
import shop.shipping.ShippingService;
import shop.shipping.ExpressShipping;
import shop.payment.PaymentMethod;
import shop.payment.CreditCardPayment;
import shop.payment.EWalletPayment;
import shop.payment.BankTransferPayment;
import shop.service.CheckoutService;
import shop.notification.*;

public class TugasApp {

    public static void main(String[] args) {

        // 1. Membuat keranjang contoh
        List<Product> items = List.of(
            new PhysicalProduct(
                "KOPI-001", "Kopi Arabika Gayo", 85_000, 300
            ),
            new PhysicalProduct(
                "RDG-002", "Rendang Kemasan", 120_000, 400
            ),
            new DigitalProduct(
                "EBK-003", "E-book Resep Kue",
                50_000, "https://toko.example/ebook"
            )
        );

        // 2. Membuat kurir Ekspres
        ShippingService shipping = new ExpressShipping();
        CheckoutService checkout = new CheckoutService();

        // 3. Membuat tiga metode pembayaran
        CreditCardPayment creditCard =
            new CreditCardPayment("Siti Rahma", 1_000_000);

        EWalletPayment eWallet =
            new EWalletPayment("GoPay", 500_000);

        PaymentMethod bankTransfer =
            new BankTransferPayment("BSI");

        // 4. Menampilkan grand total
        System.out.println("=== GRAND TOTAL KERANJANG ===");

        System.out.println("Kartu Kredit: Rp"
            + checkout.grandTotal(items, shipping, creditCard));

        System.out.println("E-Wallet: Rp"
            + checkout.grandTotal(items, shipping, eWallet));

        System.out.println("Bank Transfer: Rp"
            + checkout.grandTotal(items, shipping, bankTransfer));


        // 5. Menampilkan policy pembayaran
        System.out.println("\n=== PAYMENT POLICY ===");

        System.out.println("Kartu Kredit: "
            + creditCard.policy());

        System.out.println("E-Wallet: "
            + eWallet.policy());


        // 6. Membuat NotificationService
        NotificationService service = new NotificationService();

        service.register(new SmsChannel(StudentInfo.SMS_MAX_LENGTH));
        service.register(new EmailChannel());
        service.register(new WhatsAppChannel());

        // Anonymous class NotificationChannel
        service.register(new NotificationChannel() {

            @Override
            public String channelName() {
                return "Console Log";
            }

            @Override
            public boolean send(CustomerContact contact, String message) {
                System.out.println("[CONSOLE LOG] "
                    + contact.GetName() + ": " + message);
                return true;
            }
        });


        // 7. Membuat dua kontak
        CustomerContact customer1 = new CustomerContact(
            "Andi", "andi@gmail.com", "081234567890"
        );

        CustomerContact customer2 = new CustomerContact(
            "Budi", "", "+6281234567890"
        );


        // 8. Pesan lebih dari 200 karakter
        String message = "Halo pelanggan! Pesanan jus Anda sedang "
            + "diproses oleh toko kami. Kami akan memastikan bahwa "
            + "pesanan disiapkan dengan baik dan dikirim sesuai "
            + "dengan informasi yang telah Anda berikan. Terima kasih "
            + "telah mempercayakan kebutuhan Anda kepada toko kami. "
            + "Jika terdapat pertanyaan mengenai pesanan, silakan "
            + "menghubungi kami melalui kontak yang tersedia. "
            + "Semoga hari Anda menyenangkan!";


        // 9. Mengirim notifikasi ke dua kontak
        System.out.println("\n=== NOTIFICATION DEMO ===");

        System.out.println("\n--- Kontak 1 ---");
        System.out.println("Total berhasil: "
            + service.broadcast(customer1, message));

        System.out.println("\n--- Kontak 2 ---");
        System.out.println("Total berhasil: "
            + service.broadcast(customer2, message));
    }
}
