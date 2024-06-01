import java.util.Map;
import java.util.Scanner;

public class AksiUser extends Aksi {
    @Override
    public void tampilanAksi() {
        System.out.println("Aksi User:");
        System.out.println("1. Pesan Film");
        System.out.println("2. Lihat List Film");
        System.out.println("3. Lihat Pesanan");
        System.out.println("4. Logout");
        System.out.println("5. Tutup Aplikasi");
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

            System.out.println(film.getName() + " - " + film.getDescription() + " - Harga: " + film.getPrice() + " - Stok: " + film.getStock());
        }
    }

    public void lihatSaldo() {
        // Implementasi lihat Saldo
        User user = Akun.getCurrentUser();
        System.out.println("Saldo anda: " + (int) user.getSaldo());
    }

    public void pesanFilm() {
        // Implementasi pemesanan film
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nama Film yang ingin dipesan: ");
        String namaFilm = scanner.nextLine();

        boolean isExist = false;
        Film selectedFilm = new Film("", "", 0, 0);

        for (Map.Entry<String, Film> entry : Film.getFilms().entrySet()) {
            Film film = entry.getValue();

            if (film.getName() == namaFilm) {
                selectedFilm = film;
                isExist = true;
                break;
            }   
        }

        if (!isExist)
            System.out.println("Film yang dicari tidak ditemukan");
        else {
            System.out.print("Jumlah tiket yang ingin dipesan: ");
            int jumlahTiket = scanner.nextInt();

            if (jumlahTiket > selectedFilm.getStock()) {
                System.out.println("Stok tiket tidak mencukupi.");
            } else {
                System.out.println("Harga satuan tiket " + selectedFilm.getPrice());
                System.out.println("Total harga " + (int) (selectedFilm.getPrice() * jumlahTiket));
                
                if (selectedFilm.getPrice() * jumlahTiket > Akun.getCurrentUser().getSaldo()) {
                    System.out.println("Saldo tiket tidak mencukupi.");
                } else {
                    System.out.println("Tiket berhasil dipesan");
                    Akun.getCurrentUser().addPesanan(selectedFilm, jumlahTiket);
                }
            }

        }

        // scanner.close();
    }

    public void lihatPesanan() {
        // Implementasi melihat pesanan
        if (Akun.getCurrentUser().getPesanan().size() < 1) {
            System.out.println("Kamu belum pernah melakukan pemesanan.");
        } else {
            for (Map.Entry<String, Pesanan> entry : Akun.getCurrentUser().getPesanan().entrySet()) {
                Pesanan pesanan = entry.getValue();

                System.out.println("Film: " + pesanan.getFilm().getName() + " - Jumlah: " + pesanan.getKuantitas() + " - Total Harga: " + (int) (pesanan.getFilm().getPrice() * pesanan.getKuantitas()));
            }
        }
    }
}
