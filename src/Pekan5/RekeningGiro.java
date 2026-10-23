package Pekan5;


public class RekeningGiro extends Rekening{
	private double batasOverdraft;
	
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		// memanggil inisialisasi dasar dari superclass
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverdraft = batasOverdraft;
	}
	
	// implementasi polimorfisme (overriding)
	@Override
	public boolean tarikTunai(double nominal) {
		 if (nominal > 10000) {

	            if (nominal > (saldo + batasOverdraft)) {

	                System.out.println(
	                    "Transaksi gagal: melebihi batas overdraft!"
	                    + "maksimal penarikan : Rp" + (saldo + batasOverdraft)
	                );
	                return false;

	            } else {

	                saldo -= nominal;

	                String idTrx = "TRX-G-" + System.currentTimeMillis();

	                Transaksi trxBaru =
	                    new Transaksi(idTrx, "Debit Giro", nominal);

	                riwayatTransaksi.add(trxBaru);

	                System.out.println(
	                    "Tarik tunai Rp" + nominal
	                    + " berhasil. Saldo saat ini: Rp" + saldo
	                );
	                return true;
	            }
	            

	        } else {

	            System.out.println(
	                "Transaksi Gagal: Minimal nominal penarikan Rp10.000"
	            );
	            return false;
	        }
	}
	
	// Getter khusus giro
	public double getBatasOverdraft() {
		return batasOverdraft;
	}

}
