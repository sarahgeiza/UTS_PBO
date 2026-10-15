package karakter1;

import game.Karakter;
import game.BenangPenghubung;
import karakter2.Karakter2;

public class Karakter1 extends Karakter {
    private boolean sedangMerunduk;

    public Karakter1(String nama) {
        super(nama);
        sedangMerunduk = false;
    }

    // Overloading: lompatan default 2 langkah.
    public boolean melompat(
            Karakter2 partner,
            BenangPenghubung benang) {

        return melompat(2, partner, benang);
    }

    // Overloading: jarak lompatan bisa ditentukan.
    public boolean melompat(
            int jarak,
            Karakter2 partner,
            BenangPenghubung benang) {

        if (jarak <= 0) {
            System.out.println(
                "Jarak lompatan harus positif."
            );
            return false;
        }

        if (!gunakanStamina(2)) {
            return false;
        }

        int tujuan = getPosisi() + jarak;

        if (benang == null
                || !benang.izinkanGerak(this, partner, tujuan)) {
            pulihkanStamina(2);
            return false;
        }

        setPosisi(tujuan);
        sedangMerunduk = false;

        System.out.println(
            getNama() + " melompat ke posisi " + getPosisi()
        );

        return true;
    }

    public void merunduk() {
        if (!masihHidup()) {
            System.out.println(
                getNama() + " tidak bisa bergerak."
            );
            return;
        }

        sedangMerunduk = true;

        System.out.println(
            getNama() + " merunduk menghindari jebakan."
        );
    }

    public boolean isSedangMerunduk() {
        return sedangMerunduk;
    }

    public void berdiri() {
        sedangMerunduk = false;

        System.out.println(
            getNama() + " kembali berdiri."
        );
    }

    @Override
    public void tampilkanStatus() {
        System.out.println(
            "[Karakter 1] " + getNama()
            + " | Posisi: " + getPosisi()
            + " | Nyawa: " + getNyawa()
            + " | Stamina: " + getStamina()
            + " | Merunduk: "
            + (sedangMerunduk ? "Ya" : "Tidak")
        );
    }
}
