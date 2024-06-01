import java.util.Map;
import java.util.Scanner;

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
        for (Map.Entry<String, Film> entry : Film.getFilms().entrySet()) {
            Film film = entry.getValue();
            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + (int) film.getPrice() + " - Stok: " + film.getStock());
        }
    }

    public void tambahFilm() {
        // Implementasi menambahkan film
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Film: ");
        String namaFilm = scanner.nextLine();

        System.out.print("Deskripsi Film: ");
        String deskFilm = scanner.nextLine();

        
        System.out.print("Harga Tiket: ");
        int hargaTiket = scanner.nextInt();
        
        System.out.print("Stok Tiket: ");
        int stokTiket = scanner.nextInt();

        Film.addFilm(namaFilm, deskFilm, hargaTiket, stokTiket);
        
        // scanner.close();
    }
}
