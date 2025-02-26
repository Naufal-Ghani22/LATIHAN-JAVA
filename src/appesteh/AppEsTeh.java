package appesteh;

import java.util.Scanner;
import java.util.ArrayList;

public class AppEsTeh {
    static int jumlahPesanan = 0;
    static final int HARGA_PER_ES_TEH = 3000;
    static int stokProduk = 100;
    static ArrayList<String> daftarKontenPromosi = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int mainChoice;
        System.out.println("Nama    : Naufal Ghani Bekti");
        System.out.println("NPM     : 24082010162");
        System.out.println("Matkul  : Bahasa Pemrograman 2");
        System.out.println("Tugas   : Tugas 2 - Menerapkan Modul 17");
        do {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Order");
            System.out.println("2. Stock");
            System.out.println("3. Promosi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    menuOrder(scanner);
                    break;
                case 2:
                    menuStock(scanner);
                    break;
                case 3:
                    menuPromosi(scanner);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (mainChoice != 4);

        scanner.close();
    }

    public static void menuOrder(Scanner scanner) {
        int subChoice;
        do {
            System.out.println("\nMenu Order:");
            System.out.println("1. Pembelian");
            System.out.println("2. Pilihan Pembayaran");
            System.out.println("3. Tampilkan Nota");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    prosesPembelian(scanner);
                    break;
                case 2:
                    pilihanPembayaran(scanner);
                    break;
                case 3:
                    tampilkanNota();
                    break;
                case 4:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (subChoice != 4);
    }

    public static void prosesPembelian(Scanner scanner) {
        System.out.print("Masukkan jumlah es teh yang ingin dibeli: ");
        int pesanan = scanner.nextInt();
        if (pesanan > stokProduk) {
            System.out.println("Maaf, stok tidak mencukupi.");
        } else {
            jumlahPesanan = pesanan;
            stokProduk -= pesanan;
            System.out.println("Anda telah membeli " + jumlahPesanan + " es teh.");
        }
    }

    public static void pilihanPembayaran(Scanner scanner) {
        System.out.println("\nPilih Metode Pembayaran:");
        System.out.println("1. Tunai");
        System.out.println("2. Kartu Kredit");
        System.out.println("3. E-Wallet");
        System.out.print("Pilih metode: ");
        int metode = scanner.nextInt();

        switch (metode) {
            case 1:
                System.out.println("Anda memilih pembayaran tunai.");
                break;
            case 2:
                System.out.println("Anda memilih pembayaran dengan kartu kredit.");
                break;
            case 3:
                System.out.println("Anda memilih pembayaran dengan E-Wallet.");
                break;
            default:
                System.out.println("Metode pembayaran tidak valid.");
        }
    }

    public static void tampilkanNota() {
        int totalHarga = jumlahPesanan * HARGA_PER_ES_TEH;
        System.out.println("\n--- Nota Pembelian ---");
        System.out.println("Jumlah Pesanan: " + jumlahPesanan + " Es Teh");
        System.out.println("Harga per Es Teh: Rp " + HARGA_PER_ES_TEH);
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("Terima kasih telah berbelanja!");
    }

    public static void menuStock(Scanner scanner) {
        int subChoice;
        do {
            System.out.println("\nMenu Stock:");
            System.out.println("1. Laporan Stok Produk");
            System.out.println("2. Penambahan Produk");
            System.out.println("3. Pengurangan Produk");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            subChoice = scanner.nextInt();

            switch (subChoice) {
                case 1:
                    System.out.println("Stok saat ini: " + stokProduk + " es teh.");
                    break;
                case 2:
                    tambahStok(scanner);
                    break;
                case 3:
                    kurangiStok(scanner);
                    break;
                case 4:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (subChoice != 4);
    }

    public static void tambahStok(Scanner scanner) {
        System.out.print("Masukkan jumlah stok yang ingin ditambahkan: ");
        int tambah = scanner.nextInt();
        stokProduk += tambah;
        System.out.println("Stok berhasil ditambahkan. Stok saat ini: " + stokProduk + " es teh.");
    }

    public static void kurangiStok(Scanner scanner) {
        System.out.print("Masukkan jumlah stok yang ingin dikurangi: ");
        int kurang = scanner.nextInt();
        if (kurang > stokProduk) {
            System.out.println("Pengurangan melebihi stok yang tersedia.");
        } else {
            stokProduk -= kurang;
            System.out.println("Stok berhasil dikurangi. Stok saat ini: " + stokProduk + " es teh.");
        }
    }

    public static void menuPromosi(Scanner scanner) {
        int subChoice;
        do {
            System.out.println("\nMenu Promosi:");
            System.out.println("1. Tambah List Konten");
            System.out.println("2. Tampilkan List Konten");
            System.out.println("3. Hapus Konten Promosi");
            System.out.println("4. Edit Konten Promosi");
            System.out.println("5. Kembali");
            System.out.print("Pilih opsi: ");
            subChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (subChoice) {
                case 1:
                    tambahKontenPromosi(scanner);
                    break;
                case 2:
                    tampilkanKontenPromosi();
                    break;
                case 3:
                    hapusKontenPromosi(scanner);
                    break;
                case 4:
                    editKontenPromosi(scanner);
                    break;
                case 5:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (subChoice != 5);
    }

    public static void tambahKontenPromosi(Scanner scanner) {
        System.out.print("Masukkan konten promosi baru: ");
        String konten = scanner.nextLine();
        daftarKontenPromosi.add(konten);
        System.out.println("Konten promosi berhasil ditambahkan.");
    }

    public static void tampilkanKontenPromosi() {
        System.out.println("\nDaftar Konten Promosi:");
        if (daftarKontenPromosi.isEmpty()) {
            System.out.println("Belum ada konten promosi yang tersedia.");
        } else {
            for (int i = 0; i < daftarKontenPromosi.size(); i++) {
                System.out.println((i + 1) + ". " + daftarKontenPromosi.get(i));
            }
        }
    }

    public static void hapusKontenPromosi(Scanner scanner) {
        tampilkanKontenPromosi();
        if (!daftarKontenPromosi.isEmpty()) {
            System.out.print("Masukkan nomor konten yang ingin dihapus: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= daftarKontenPromosi.size()) {
                daftarKontenPromosi.remove(index - 1);
                System.out.println("Konten promosi berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }

    public static void editKontenPromosi(Scanner scanner) {
        tampilkanKontenPromosi();
        if (!daftarKontenPromosi.isEmpty()) {
            System.out.print("Masukkan nomor konten yang ingin diedit: ");
            int index = scanner.nextInt();
            scanner.nextLine(); 
            if (index > 0 && index <= daftarKontenPromosi.size()) {
                System.out.print("Masukkan konten baru: ");
                String kontenBaru = scanner.nextLine();
                daftarKontenPromosi.set(index - 1, kontenBaru);
                System.out.println("Konten promosi berhasil diperbarui.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        }
    }
}
