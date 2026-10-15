package karakter2;

import game.Karakter;
import game.BenangPenghubung;
import game.Musuh;
import karakter1.Karakter1;

public class Karakter2 extends Karakter {

    public Karakter2(String nama) {
        super(nama);
    }

    // Overloading: lari dengan jarak default 2 langkah.
    public boolean lari(
            Karakter1 partner,
            BenangPenghubung benang) {
        return lari(2, partner, benang);
    }

    // Overloading: lari dengan jarak yang ditentukan.
    public boolean lari(
            int jarak,
            Karakter1 partner,
            BenangPenghubung benang) {

        if (jarak <= 0) {
            System.out.println(
                "Jarak lari harus positif."
            );
            return false;
        }

        if (!gunakanStamina(jarak)) {
            return false;
        }

        int tujuan = getPosisi() + jarak;

        if (benang == null
                || !benang.izinkanGerak(
                    this, partner, tujuan)) {
            pulihkanStamina(jarak);
            return false;
        }

        setPosisi(tujuan);

        System.out.println(
            getNama() + " berlari ke posisi "
            + getPosisi() + "."
        );

        return true;
    }

    public void injakMusuh(Musuh musuh) {
        if (musuh == null || !musuh.masihHidup()) {
            System.out.println(
                "Musuh sudah dikalahkan atau tidak ditemukan."
            );
            return;
        }

        musuh.terimaSerangan(1);

        System.out.println(
            getNama() + " menginjak musuh!"
        );
    }

    @Override
    public void tampilkanStatus() {
        System.out.println(
            "[Karakter 2] " + getNama()
            + " | Posisi: " + getPosisi()
            + " | Nyawa: " + getNyawa()
            + " | Stamina: " + getStamina()
        );
    }
}
