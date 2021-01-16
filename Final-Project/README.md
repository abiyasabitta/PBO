### ANGGOTA KELOMPOK
1. Afifah Nur Sabrina Syamsudin - 05111940000022
2. Vyra Fania Adelina - 05111940000109
3. Abiya Sabitta Ragadani - 05111940000166

# Hungry Creatures
Hungry Creatures adalah sebuah permainan sederhana yang terinspirasi dari video game klasik, Snake. Cara bermain nya adalah pemain harus mengontrol gerakan dari _creatures_ yang ada dan akan mendapatkan poin serta ukurannya bertambah panjang  jika berhasil memakan apel. Namun pemain juga harus menghindari _creatures_ dari tepi layar permainan dan gerakan tubuh dari _creatures_.

## Features
- [x] Memilih `Character`
  - Snake
  - Centipede
  - Worm
- [x] Memilih `Level`
  - Easy
  - Normal
  - Hard
- [x] Jenis `Snack`
  - Red Apple
  - Poison Apple
- [x] Menghitung `Score` per babak
- [x] Menyimpan `High Score`
- [x] Display `Game Over`
- [x] `Play Again`

## Class Description
Program ini terdiri dari 9 `class` yaitu `Main`, `GameFrame`, `GamePanel`, `Menu`, `Apple`, `Character`, `Snake`, `Centipede`, dan `Worm`.

### Main
`Class Main` merupakan `class` utama untuk menjalankan program permainan.

### GameFrame
`Class GameFrame` merupakan `class` yang berisikan objek - objek untuk membentuk jendela permainan.

### GamePanel
`Class GamePanel` difungsikan sebagai kontrol utama semua komponen permainan, seperti memunculkan permainan dengan method `draw(Graphics graphics)`, memunculkan teks `Score`, `HighScore` dan `Game Over`.

### Character
`Class Character` merupakan parent class dari objek-objek yang ada dalam game ini seperti Snake, Centipede, Worm, Red Apple, dan juga Rotten Apple. Pada class ini terdapat method untuk menentukan dan mengetahui warna objek tersebut.

#### Snake
`Class Snake` merupakan salah satu subclass dari parent `Class Character` yang akan menentukan warna objek yang memakan apple menjadi hijau

#### Centipede
`Class Centipede` merupakan salah satu subclass dari parent `Class Character` yang akan menentukan warna objek yang memakan apple menjadi merah

#### Worm
`Class Worm` merupakan salah satu subclass dari parent `Class Character` yang akan menentukan warna objek yang memakan apple menjadi coklat

#### Apple
`Class Apple` merupakan salah satu subclass dari parent `Class Character` untuk objek yang akan dimakan. Pada class ini terdapat constructor `Apple()` untuk menunjukkan objek Red Apple yang berwarna merah, sedangkan untuk objeck Poison Apple dapat ditentukan menggunakan constructor `Apple(Color color)` menjadi warna ungu. Selain itu, untuk Poison Apple, saat objek tersebut dimakan score pemain akan berkurang.

### Menu
`Class Menu` merupakan subclass dari GamePanel yang digunakan untuk menampilkan tampilan mulai dan tampilan ketika pemain kalah. Pada class ini terdapat constructor `Menu(int LEBAR, int PANJANG)`. Terdapat 2 buah method dan setter getter class. Method 1 adalah `menugame()` yang berfungsi untuk menampilkan tampilan awal sebelum game dimainkan yang berisi judul game dan tombol untuk memulai permainan. Method 2 adalah `gameOver()` yang berfungsi untuk menunjukan tampilan game over dan skor yang pemain telah capai serta tombol untuk kembali ke tampilan awal. 

# Perubahan
- Sistem `HighScore` menggunakan method
```createSaveData```, ```loadHighScore``` dan ```setHighScore```
- Memilih `Character` terdapat `Snake`, `Centipede`, dan `Worm` menggunakan method ```chooseCharacter``` yang akan diteruskan di method ```drawCharacter```
- Jenis `Snack` terdapat `Red Apple` dan `Poison Apple` menggunakan method `drawApple`
- Memilih `Level`: `Easy`, `Normal`, dan `Hard`.
- Menu dengan  `Play` button dan `GameOver`

# Demo
[Link](https://youtu.be/WO3C38nUOm4)

# Class Diagram
![ClassDiagram](https://github.com/abiyasabitta/PBO/blob/main/Final-Project/Source/ClassDiagram_HungryCreatures.jpg)

# References
[Video](https://www.youtube.com/watch?v=bI6e6qjJ8JQ)

[HighScore](https://www.youtube.com/watch?v=qVDi7tk-P-g)
