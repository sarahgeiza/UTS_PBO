package game;

public class BenangPenghubung {
    private final int jarakMaksimal;

    public BenangPenghubung() {
        this(4);
    }

    public BenangPenghubung(int jarakMaksimal) {
        if (jarakMaksimal < 1) {
            throw new IllegalArgumentException(
                "Jarak maksimal minimal 1."
            );
        }

        this.jarakMaksimal = jarakMaksimal;
    }

    public boolean izinkanGerak(
            Karakter penggerak,
            Karakter partner,
            int posisiTujuan) {

        if (penggerak == null || partner == null) {
            System.out.println("Karakter tidak ditemukan.");
            return false;
        }

        if (!penggerak.masihHidup() || !partner.masihHidup()) {
            System.out.println(
                "Gerakan ditolak. Kedua karakter harus tetap hidup."
            );
            return false;
        }

        int jarak = Math.abs(
            posisiTujuan - partner.getPosisi()
        );

        if (jarak > jarakMaksimal) {
            System.out.println(
                "BENANG TEGANG! Jarak " + jarak
                + " melebihi batas " + jarakMaksimal
            );
            System.out.println(
                penggerak.getNama() + " harus mendekati "
                + partner.getNama() + "."
            );

            return false;
        }

        return true;
    }

    public int getJarakMaksimal() {
        return jarakMaksimal;
    }

    public void tampilkanStatus(Karakter a, Karakter b) {
        int jarak = Math.abs(
            a.getPosisi() - b.getPosisi()
        );

        System.out.println(
            "Jarak benang: " + jarak + "/" + jarakMaksimal
            + (jarak > jarakMaksimal ? " (TEGANG)" : " (AMAN)")
        );
    }
}
