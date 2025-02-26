//========================================================
//========================================================
//Nama              : Naufal Ghani Bekti
//NPM               : 24082010162
//Paralel           : D
//Mata Kuliah       : Bahasa Pemrograman 2
//========================================================
//========================================================

import java.util.Scanner;

public class layananBank {
    // Atribut untuk menyimpan data rekening
    private String namaAkun; // Nama pemilik rekening
    private String nomorAkun; // Nomor rekening unik
    private double saldo; // Saldo dalam rekening
    private String statusAkun; // Status rekening (aktif/nonaktif)

    // Konstruktor untuk menginisialisasi data rekening
    public layananBank(String nm, String nmr, double sld) {
        this.namaAkun = nm;
        this.nomorAkun = nmr;
        this.saldo = sld;
        this.statusAkun = "Active"; // Default status adalah aktif
    }

    // Metode untuk membaca informasi rekening
    public void displayAccountInfo() {
        System.out.println("======= Account Information =======");
        System.out.println("Nama Akun Rekening  : " + namaAkun);
        System.out.println("Nomor Rekening      : " + nomorAkun);
        System.out.println("Saldo               : Rp. " + saldo);
        System.out.println("Status Akun         : " + statusAkun);
    }

    // Metode untuk menambah saldo
    public void deposit(double tambah) {
        if (tambah > 0) {
            saldo += tambah;
            System.out.println("$" + tambah + " deposited successfully. New balance: $" + saldo);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    // Metode untuk memperbarui status rekening
    public void updateAccountStatus(String newStatus) {
        if (newStatus.equalsIgnoreCase("Active") || newStatus.equalsIgnoreCase("Inactive")) {
            statusAkun = newStatus;
            System.out.println("Account status updated to: " + statusAkun);
        } else {
            System.out.println("Invalid status. Please use 'Active' or 'Inactive'.");
        }
    }

    // Getter untuk saldo (jika dibutuhkan untuk fitur tambahan di masa depan)
    public double getBalance() {
        return saldo;
    }

    // Main method
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);

        // Input data rekening
        System.out.println("Masukkan Nama Pemilik Rekening: ");
        String name = inputUser.nextLine();

        System.out.println("Masukkan Nomor Rekening: ");
        String accountNumber = inputUser.nextLine();

        System.out.println("Masukkan Saldo Awal: ");
        double initialBalance = inputUser.nextDouble();

        // Membuat objek rekening
        layananBank account = new layananBank(name, accountNumber, initialBalance);

        int pilihan; // Variabel untuk menyimpan pilihan menu

        do {
            // Menampilkan menu opsi
            System.out.println("===================================");
            System.out.println("=============== MENU ==============");
            System.out.println("===================================");
            System.out.println("1. Lihat Informasi Rekening");
            System.out.println("2. Tambah Saldo");
            System.out.println("3. Ubah Status Rekening");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = inputUser.nextInt();

            switch (pilihan) {
                case 1:
                    // Menampilkan informasi rekening
                    account.displayAccountInfo();
                    break;
                case 2:
                    // Menambah saldo
                    System.out.print("Masukkan jumlah saldo yang ingin ditambahkan: ");
                    double tambahSaldo = inputUser.nextDouble();
                    account.deposit(tambahSaldo);
                    break;
                case 3:
                    // Mengubah status rekening
                    System.out.print("Masukkan status baru (Active/Inactive): ");
                    inputUser.nextLine(); // Membersihkan newline character
                    String newStatus = inputUser.nextLine();
                    account.updateAccountStatus(newStatus);
                    break;
                case 4:
                    // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    // Pilihan tidak valid
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 4);

        inputUser.close();
    }
}
