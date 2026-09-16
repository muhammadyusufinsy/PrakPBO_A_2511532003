package pekan1;
import java.util.ArrayList;
import java.util.Scanner;

public class Rekening {
	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public Rekening (String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal ;
		System.out.println("rekening atas nama " + namaPemilik + "berhasil dibuat dengan saldo RP" + saldo );
	}
	
	public void setorTunai (double nominal) {
		if (nominal > 10000) {
			saldo += nominal;
			System.out.println("setor tunai Rp" + nominal + "berhasil. saldo saat ini: Rp" + saldo);
		}
		else {
			System.out.println("gagal: nominal setor harus lebih dari 10000!");
		}
	}
	
	public void tarikTunai (double nominal) {
		if (nominal > 10000) {
			
			if (nominal > saldo) {
				System.out.println("Transaksi Gagal: Saldo tidak mencukupi. Saldo Anda: " + saldo);
			}else {
				saldo -= nominal;
			System.out.println("tarik tunai Rp" + nominal + "berhasil. saldo saat ini: Rp" + saldo);
			}
		}
		else {
			System.out.println("Transaksi Gagal :  Minimal nomonal penarikan 10.000");
		}
	}
	
	public Rekening gantiAkun(ArrayList<Rekening> daftarRekening, Scanner input) {
	    System.out.println("Masukan nomor rekening");
	    String nomor = input.nextLine();

	    for (Rekening rekening : daftarRekening) {
	        if (rekening.nomorRekening.equals(nomor)) {
	            System.out.println("Akun ditemukan");
	            rekening.cekInformasi();
	            return rekening;
	        }
	    }

	    System.out.println("Rekening tidak ditemukan");
	    return null;
	}
	
	public void cekInformasi() {
		System.out.println("___ INFO REKENING ___");
		System.out.println("No. Rekening : " + nomorRekening);
		System.out.println("Nama Pemilik : " + namaPemilik);
		System.out.println("Saldo Akhir  : Rp" + saldo);
		System.out.println("----------------------");
		
	}
}
