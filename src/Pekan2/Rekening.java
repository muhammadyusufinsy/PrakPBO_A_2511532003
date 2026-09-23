package Pekan2;

import java.util.ArrayList;
import java.util.Scanner;

public class Rekening {

    String nomorRekening;
    String namaPemilik;
    double saldo;

    ArrayList<Transaksi> riwayatTransaksi;

    public Rekening(String nomor, String nama, double saldoAwal) {

        nomorRekening = nomor;
        namaPemilik = nama;
        saldo = saldoAwal;

        // Inisialisasi ArrayList
        this.riwayatTransaksi = new ArrayList<>();

        System.out.println(
            "Rekening atas nama " + namaPemilik
            + " berhasil dibuat dengan saldo Rp" + saldo
        );
    }

    public void setorTunai(double nominal) {

        if (nominal > 0) {

            saldo += nominal;

            String idTrx = "TRX-S-" + System.currentTimeMillis();

            Transaksi trxBaru =
                new Transaksi(idTrx, "Kredit", nominal);

            riwayatTransaksi.add(trxBaru);

            System.out.println(
                "Setor tunai Rp" + nominal
                + " berhasil. Saldo saat ini: Rp" + saldo
            );

        } else {

            System.out.println(
                "Gagal: nominal setor harus lebih dari 0!"
            );
        }
    }

    public void tarikTunai(double nominal) {

        if (nominal > 10000) {

            if (nominal > saldo) {

                System.out.println(
                    "Transaksi Gagal: Saldo tidak mencukupi. "
                    + "Saldo Anda: Rp" + saldo
                );

            } else {

                saldo -= nominal;

                String idTrx = "TRX-T-" + System.currentTimeMillis();

                Transaksi trxBaru =
                    new Transaksi(idTrx, "Debit", nominal);

                riwayatTransaksi.add(trxBaru);

                System.out.println(
                    "Tarik tunai Rp" + nominal
                    + " berhasil. Saldo saat ini: Rp" + saldo
                );
            }

        } else {

            System.out.println(
                "Transaksi Gagal: Minimal nominal penarikan Rp10.000"
            );
        }
    }

    public void cetakMutasi() {

        if (riwayatTransaksi.isEmpty()) {

            System.out.println(
                "Belum ada transaksi pada rekening ini"
            );

        } else {

            for (Transaksi n : riwayatTransaksi) {
                n.cetakDetail();
            }
        }
    }

    public Rekening gantiAkun(
        ArrayList<Rekening> daftarRekening,
        Scanner input
    ) {

        System.out.println("Masukkan nomor rekening");
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