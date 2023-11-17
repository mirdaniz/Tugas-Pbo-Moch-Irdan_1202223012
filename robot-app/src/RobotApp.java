import java.util.Scanner;
import Model.Position;
import Model.Layout;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args){
        new RobotApp();
    }

    /*
     * Perintah Soal:
     * Anggap 'o' adalah sebuah robot yang berada didalam area permainan.
     * Buat robot dapat bergerak ke kiri/kanan/atas/bawah sesuai jumlah langkah yang diinstruksikan.
     * Format instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah} dan 'x' untuk keluar aplikasi *case sensitive
     * Robot tidak boleh keluar dari area permainan dan buat pesan kesalahannya.
     * Buat pesan kesalahan jika pengguna tidak menulis instruksi dengan benar.
     * Lanjut pada perintah soal dibawah.
     */

    private Layout layout;
    private Robot robot;
    private Scanner scanner;
    public RobotApp() {
        // contoh konfigurasi (inisiasi object layout) area permainan: X = 10, Y = 10, icon area yang tidak ditempati robot adalah '*'
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(1,1));
        this.scanner = new Scanner(System.in);
        String instruction = "";
        System.out.println("-------- Permainan Dimulai --------");
        do{
            draw();
            instruction = waitInstruction();
            executeInstruction(instruction);
        }while(!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < layout.getMaxX() && y >= 0 && y < layout.getMaxY();
    }
    private void executeInstruction(String instruction) {
        char arah = instruction.charAt(0);
        int langkah;
        try {
            langkah = Integer.parseInt(instruction.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid. Masukkan nomor step yang benar!");
            return;
        }
        int posisiX = robot.getPosition().getX();
        int posisiY = robot.getPosition().getY();
        switch (arah) {
            case 'w':
                robot.getPosition().setX(posisiX - langkah);
                break;
            case 'a':
                robot.getPosition().setY(posisiY - langkah);
                break;
            case 's':
                robot.getPosition().setX(posisiX + langkah);
                break;
            case 'd':
                robot.getPosition().setY(posisiY + langkah);
            default:
                System.out.println("Masukan Antara W,A,S,D");
                return;
        }
    //Robot tidak boleh keluar permainan
    if (!isValidPosition(robot.getPosition().getX(), robot.getPosition().getY())) {
        System.out.println("Robot tidak bisa keluar dari area permainan");
        robot.getPosition().setX(posisiX);
        robot.getPosition().setY(posisiY);
    }
    }
    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

        /*
        Gambar layout:
        Contoh:
        - Posisi robot di 1,1
        - Area permainan luasnya 10,10
        sehingga gambar layout akan menjadi:

            o*********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********

            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */
        private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        for(int y = 0; y < layout.getMaxY(); y++){
            for(int x = 0; x < layout.getMaxX(); x++){
                if( y == robot.getPosition().getX() && x == robot.getPosition().getY()){
                    System.out.print(robot.getIcon());
                }else {
                    System.out.print(layout.getArea()[y][x]);
                }
            }
            System.out.println();
        }

    }
}