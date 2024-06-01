public class AksiAdmin extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi Admin:");
        System.out.println("1. Tambah Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Logout");
        System.out.println("4. Tutup Aplikasi");
    }

    @Override
    public void keluar() {
        Akun.logout();
        System.out.println("Anda telah logout.");
    }

    @Override
    public void tutupAplikasi() {
        System.out.println("Aplikasi ditutup.");
        System.exit(0);
    }

    @Override
    public void lihatListFilm() {
        // Implementasi melihat list film
    }

    public void tambahFilm() {
        // Implementasi menambahkan film
    }
}
