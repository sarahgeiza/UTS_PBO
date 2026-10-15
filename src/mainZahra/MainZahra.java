package mainZahra;

import game.BenangPenghubung;
import game.Musuh;
import karakter1.Karakter1;
import karakter2.Karakter2;

public class MainZahra {

    public static void main(String[] args) {
        Karakter1 geiza = new Karakter1("Geiza");
        Karakter2 zahra = new Karakter2("Zahra");

        BenangPenghubung benang = new BenangPenghubung(4);

        Musuh penjaga = new Musuh("Penjaga Hutan", 3);

        System.out.println("==================================");
        System.out.println(" UNRAVEL TWO: THE FORGOTTEN FOREST");
        System.out.println(" Skenario Zahra");
        System.out.println("==================================");

        System.out.println("\n[MISI 1] Menguji batas benang");

        // Menguji lari terlalu jauh.
        zahra.lari(5, geiza, benang);

        // Lari dengan jarak yang aman.
        zahra.lari(2, geiza, benang);

        System.out.println("\n[MISI 2] Geiza melompat");
        geiza.melompat(1, zahra, benang);

        System.out.println("\n[MISI 3] Bergerak bersama");
        zahra.lari(geiza, benang);

        benang.tampilkanStatus(geiza, zahra);

        System.out.println("\n[MISI 4] Mengalahkan musuh");

        if (penjaga.masihHidup()) {
            zahra.injakMusuh(penjaga);
        }

        if (penjaga.masihHidup()) {
            zahra.injakMusuh(penjaga);
        }

        if (penjaga.masihHidup()) {
            zahra.injakMusuh(penjaga);
        }

        System.out.println("\n--- STATUS AKHIR ---");
        geiza.tampilkanStatus();
        zahra.tampilkanStatus();
        benang.tampilkanStatus(geiza, zahra);

        if (!penjaga.masihHidup()
                && geiza.masihHidup()
                && zahra.masihHidup()
                && Math.abs(
                        geiza.getPosisi() - zahra.getPosisi()) <= benang.getJarakMaksimal()) {

            System.out.println("MISI BERHASIL!");
        } else {
            System.out.println("MISI BELUM BERHASIL.");
        }
    }
}