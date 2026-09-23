package Pekan2;


import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		Rekening akunAktif = null; //objek belum di inisiasi (null)
		boolean isRunning = true;
		ArrayList <Rekening> daftarRekening = new ArrayList();
		
		
		System.out.println("=== SYSTEM PERBANKAN MINI ===");
		
		while (isRunning) {
			System.out.println("\nMenu Utama:");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik TUnai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.println("6. cetak riwayat transaksi");
			System.out.println("7. keluar");
			System.out.print("Pilih MENU:");
			
			int pilihan = input.nextInt();
			input.nextLine();
			
			switch (pilihan) {
			case 1:
				System.out.print("Masukan No Rekening: ");
				String no = input.nextLine();
				System.out.print("Masukan Nama Pemilik: ");
				String nama = input.nextLine();
				System.out.print("masukan saldo awal: ");
				double saldo = input.nextDouble();
				
				// installasi object / menjalankan construktor
				akunAktif = new Rekening (no, nama, saldo);
				daftarRekening.add(akunAktif);
				break;
				
			case 2:
				if (akunAktif == null) {
					System.out.println("Error: mohon maaf, anda belum memiliki nomor rekening! ");
				} else {
					System.out.print("masukan nominal setor");
					double setor = input.nextDouble();
					akunAktif.setorTunai(setor);
				}
				break;
				
			case 3:
				if (akunAktif == null) {
					System.out.println("Error: mohon maaf, anda belum memiliki nomor rekening! ");
				} else {
					System.out.print("masukan nominal tarik");
					double tarik = input.nextDouble();
					akunAktif.tarikTunai(tarik);
				}
				break;
				
			case 4:
				if (akunAktif == null) {
					System.out.println("Error : anda belum membuka rekening!");
				} else {
					akunAktif.cekInformasi();
				}
				break;
				
			case 5:
			    if (akunAktif == null) {
			        System.out.println("Error : anda belum memiliki nomor rekening");
			    } else {
			        Rekening akunBaru = akunAktif.gantiAkun(daftarRekening, input);

			        if (akunBaru != null) {
			            akunAktif = akunBaru;
			            System.out.println("Akun berhasil diganti.");
			        }
			    }
			    break;
			    
			case 6:
				if (akunAktif == null) {
					System.out.println("Error : anda belum meiliki akun");
				} else {
					akunAktif.cetakMutasi();
					
				}
				break;
				
			case 7:
				isRunning = false;
				System.out.println("Sistem ditutup. Terima Kasih");
				break;
				
				default :
					System.out.println("pilihan tidak valid!");
			}
		}
		input.close();
	}
	

}

