package game;

public abstract class Karakter {
    private final String nama;
    private int posisi;
    private int nyawa;
    private int stamina;

    public Karakter(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        this.nama = nama;
        this.posisi = 0;
        this.nyawa = 3;
        this.stamina = 10;
    }

    public String getNama() {
        return nama;
    }

    public int getPosisi() {
        return posisi;
    }

    public int getNyawa() {
        return nyawa;
    }

    public int getStamina() {
        return stamina;
    }

    protected void setPosisi(int posisi) {
        if (posisi >= 0) {
            this.posisi = posisi;
        }
    }

    protected boolean gunakanStamina(int jumlah) {
        if (!masihHidup()) {
            System.out.println(nama + " sudah tumbang!");
            return false;
        }

        if (jumlah <= 0 || stamina < jumlah) {
            System.out.println(nama + " kehabisan stamina!");
            return false;
        }

        stamina -= jumlah;
        return true;
    }

    public void pulihkanStamina(int jumlah) {
        if (jumlah > 0 && masihHidup()) {
            stamina = Math.min(10, stamina + jumlah);
            System.out.println(
                nama + " memulihkan stamina menjadi " + stamina
            );
        }
    }

    public void terimaDamage(int jumlah) {
        if (jumlah <= 0 || !masihHidup()) {
            return;
        }

        nyawa = Math.max(0, nyawa - jumlah);

        System.out.println(
            nama + " kehilangan nyawa. Sisa: " + nyawa
        );

        if (!masihHidup()) {
            System.out.println(nama + " tumbang!");
        }
    }

    public boolean masihHidup() {
        return nyawa > 0;
    }

    public abstract void tampilkanStatus();
}
