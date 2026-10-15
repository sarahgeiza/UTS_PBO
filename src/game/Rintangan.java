package game;

public class Rintangan {
    public enum Jenis {
        JURANG,
        DURI
    }

    private final String nama;
    private final int posisi;
    private final Jenis jenis;

    public Rintangan(
            String nama,
            int posisi,
            Jenis jenis) {

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama rintangan tidak boleh kosong."
            );
        }

        if (posisi < 0 || jenis == null) {
            throw new IllegalArgumentException(
                "Posisi atau jenis rintangan tidak valid."
            );
        }

        this.nama = nama;
        this.posisi = posisi;
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public int getPosisi() {
        return posisi;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public boolean amanUntukLompatan() {
        return jenis == Jenis.JURANG;
    }

    public boolean amanUntukMerunduk() {
        return jenis == Jenis.DURI;
    }

    public void tampilkanInfo() {
        System.out.println(
            "Rintangan: " + nama
            + " | Posisi: " + posisi
            + " | Jenis: " + jenis
        );
    }
}
