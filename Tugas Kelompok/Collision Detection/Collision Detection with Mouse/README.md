# Collision Detection With Mouse
### Anggota Kelompok
1. Afifah Nur Sabrina Syamsudin 05111940000022
2. Vyra Fania Adelina 05111940000109
3. Abiya Sabitta Ragadani 05111940000166

## Perubahan
- Menggunakan Mouse Handling

Dalam aplikasi game yang telah dibuat terdapat 2 cara untuk *event handling* atau metode untuk menangani sebuah event/aksi 
yang diberikan user kepada komponen GUI. 2 *event handling* tersebut adalah: 
- **Keyboard Handling**
    Aplikasi Collision Detection menggunakan *keyboard handling*:<br> 
    [Link Collision Detection](https://github.com/abiyasabitta/PBO/tree/main/Tugas%20Kelompok/Collision%20Detection/CollisionDetection)
- **Mouse Handling**
    Method yang digunakan ditambahkan pada aplikasi Collision Detection ini yakni, ``mousePressed`` pada class ``SpaceShip``, ``MAdapter`` dan ``TAdapter`` dengan
    men **extends** ``MouseAdapter`` di dalam class ``Board``.

## Cara Kerja
berikut ini method yang ditambahkan pada class ``SpaceShip`` dan ``Board``.

### Board
Tiap class sudah meng **extends** ``MouseAdapter``.
``TAdapter`` berfungsi membaca input dari mouse, method ``mousePressed`` di *override* dari class ``SpaceShip``.
```hide
private class TAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e){ spaceship.mousePressed(e);}
    }
```
``MAdapter`` berfungsi membaca tiap gerakan mouse yang dilakukan.
```hide 
private class MAdapter extends MouseAdapter{
        @Override
        public void mouseMoved(MouseEvent e) { spaceship.move(e);}
    }
```
### SpaceShip
``mousePressed`` berfungsi membaca dan memberikan action berupa gerakan dari mouse user.
```hide
public void mousePressed(MouseEvent e) {

        int key = e.getButton();

        if (key == 1) {
            fire();
        }
    }
```

### ScreenShot Class Diagram
![classdiagram](https://github.com/abiyasabitta/PBO/blob/main/Tugas%20Kelompok/Collision%20Detection/Screenshot/CollisionDetectionWithMouse_Diagram.jpg)

### Screenshot Program
![programgif](https://github.com/abiyasabitta/PBO/blob/main/Tugas%20Kelompok/Collision%20Detection/Screenshot/CollisionDetectionWithMouse_Program.gif)
![programvid](https://www.youtube.com/watch?v=P2OqZse8u00&feature=youtu.be)
