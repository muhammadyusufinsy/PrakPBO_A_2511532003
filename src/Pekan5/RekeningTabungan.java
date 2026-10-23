package Pekan5;


public class RekeningTabungan extends Rekening {
	
	// atribut spesifik yang hanya dimiliki oleh tabungan
	private double sukuBunga;
	
	//construktor subclass
	public RekeningTabungan (String nomor, String nama, double saldoAwal, String pinAwal, double sukuBunga) {
		//super () memanggil construktor kelas induk (rekening) wajib berada di baris pertama 
		super(nomor, nama, saldoAwal, pinAwal);
		this.sukuBunga= sukuBunga;	
		}
	public void tambahBungaAkhirBulan() {
		// menghitung bunga
		// mengopa bisa mengalkses saldo secara langsung dari kelas rekeningTabungan
		double nominalBunga = saldo * (sukuBunga / 100);
		saldo += nominalBunga;
		
		// mencatat riwayat transaksi 
		String idTRX = "TRX-B-" + System.currentTimeMillis();
		riwayatTransaksi.add(new Transaksi(idTRX, "bunga", nominalBunga));
		
		System.out.println("Bunga" + sukuBunga + "% berhasil ditambahkan: Rp" + nominalBunga);
		
	}

}
