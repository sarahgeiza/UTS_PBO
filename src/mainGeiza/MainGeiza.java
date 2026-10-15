package mainGeiza;

import game.BenangPenghubung;
import game.Musuh;
import game.Rintangan;
import karakter1.Karakter1;
import karakter2.Karakter2;

public class MainGeiza {
    public static void main(String[] args) {
        Karakter1 geiza = new Karakter1("Geiza");
        Karakter2 zahra = new Karakter2("Zahra");

        BenangPenghubung benang = new BenangPenghubung(4);

        Musuh penjaga = new Musuh("Penjaga Hutan", 3);

        Rintangan jurang = new Rintangan(
            "Jurang Retak", 2, Rintangan.Jenis.JURANG
        );

        Rintangan duri = new Rintangan(
            "Duri Merambat", 3, Rintangan.Jenis.DURI
        );

        System.out.println("==================================");
        System.out.println(" UNRAVEL TWO: THE FORGOTTEN FOREST");
        System.out.println(" Skenario Geiza");
        System.out.println("==================================");

        System.out.println("\n[MISI 1] Menyeberangi jurang");
        jurang.tampilkanInfo();

        if (jurang.amanUntukLompatan()) {
            geiza.melompat(zahra, benang);
        }

        zahra.lari(geiza, benang);
        benang.tampilkanStatus(geiza, zahra);

        System.out.println("\n[MISI 2] Menghindari duri");
        duri.tampilkanInfo();

        geiza.merunduk();

        if (duri.amanUntukMerunduk()
                && geiza.isSedangMerunduk()) {
            System.out.println(
                "Geiza berhasil menghindari duri!"
            );
        } else {
            geiza.terimaDamage(1);
        }

        geiza.berdiri();

        System.out.println("\n[MISI 3] Mengalahkan penjaga hutan");
        zahra.injakMusuh(penjaga);
        zahra.injakMusuh(penjaga);
        zahra.injakMusuh(penjaga);

        System.out.println("\n[MISI 4] Membuka gerbang");

        if (penjaga.masihHidup()) {
            System.out.println(
                "Gerbang terkunci: musuh belum dikalahkan."
            );
        } else if (!geiza.masihHidup()
                || !zahra.masihHidup()) {
            System.out.println(
                "Misi gagal: salah satu karakter tumbang."
            );
        } else if (Math.abs(
                geiza.getPosisi() - zahra.getPosisi())
                > benang.getJarakMaksimal()) {
            System.out.println(
                "Misi gagal: benang terlalu tegang."
            );
        } else {
            System.out.println(
                "Kedua karakter berhasil membuka gerbang!"
            );
            System.out.println("MISI BERHASIL!");
        }

        System.out.println("\n--- STATUS AKHIR ---");
        geiza.tampilkanStatus();
        zahra.tampilkanStatus();
        benang.tampilkanStatus(geiza, zahra);

        System.out.println(
            "HP penjaga hutan: " + penjaga.getHp()
        );
    }
}
