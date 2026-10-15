package game;

public class Musuh {
    private final String nama;
    private int hp;

    public Musuh(String nama, int hp) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama musuh tidak boleh kosong."
            );
        }

        if (hp <= 0) {
            throw new IllegalArgumentException(
                "HP musuh harus lebih dari 0."
            );
        }

        this.nama = nama;
        this.hp = hp;
    }

    public String getNama() {
        return nama;
    }

    public int getHp() {
        return hp;
    }

    public boolean masihHidup() {
        return hp > 0;
    }

    public void terimaSerangan(int damage) {
        if (damage <= 0) {
            System.out.println("Damage tidak valid.");
            return;
        }

        if (!masihHidup()) {
            System.out.println(
                nama + " sudah dikalahkan."
            );
            return;
        }

        hp = Math.max(0, hp - damage);

        System.out.println(
            nama + " terkena serangan. HP tersisa: " + hp
        );

        if (!masihHidup()) {
            System.out.println(
                nama + " berhasil dikalahkan!"
            );
        }
    }
}
