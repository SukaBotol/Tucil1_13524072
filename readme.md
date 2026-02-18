# Queens Game Solver

## Penjelasan Singkat Program

Program ini adalah solver untuk permainan Queens Game, sebuah variasi dari masalah N-Queens klasik. Dalam permainan ini, pemain harus meletakkan queen (ratu catur) pada papan berukuran NxN dengan aturan:

1. Setiap warna/karakter unik harus memiliki tepat satu queen
2. Tidak boleh ada dua queen pada baris yang sama
3. Tidak boleh ada dua queen pada kolom yang sama
4. Tidak boleh ada dua queen yang bersebelahan (termasuk diagonal)

Program menyediakan tiga metode penyelesaian:
- **Bit-like Iteration**: Iterasi sistematis seperti penambahan bilangan biner
- **Clock-like Iteration**: Iterasi sistematis seperti jarum jam
- **Let It Ride!! (Bogo)**: Penyelesaian secara acak (random brute-force)

Fitur tambahan:
- Visualisasi papan permainan dengan warna
- Opsi untuk melihat proses iterasi secara real-time
- Input dari file atau manual
- Simpan hasil ke file

## Requirement Program

- Java Development Kit (JDK) 21 atau lebih baru
- Apache Maven 3.6 atau lebih baru
- JavaFX 21

## Cara Kompilasi

Jalankan perintah berikut di terminal pada direktori root proyek:

```bash
mvn clean compile
```

## Cara Menjalankan

Setelah dikompilasi, jalankan program dengan perintah:

```bash
mvn javafx:run
```

## Cara Menggunakan Program

1. **Input Papan**:
   - Klik tombol "Input File" untuk memilih file test case, atau
   - Ketik langsung pada text area kemudian klik "Create Board"

2. **Pilih Metode**:
   - Pilih metode penyelesaian dari dropdown menu

3. **Opsi Visualisasi**:
   - Centang "Show Iteration" jika ingin melihat proses pencarian solusi

4. **Solve**:
   - Klik tombol "Solve" untuk memulai pencarian solusi

5. **Simpan Hasil**:
   - Klik tombol "Save" untuk menyimpan hasil ke file

## Format Input

File input berisi karakter yang merepresentasikan warna/region pada papan:

```
AAAAAAA
BBBBBBB
BCBBDDD
CCBBDEE
FCBBDDD
FCBBDGD
CCCBDDD
```

Setiap karakter unik (A-Z) merepresentasikan satu warna/region.

## Author

I Gusti Ngurah Alit Dharma Yudha | 13524072