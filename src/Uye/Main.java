package Uye;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ElitUye> elitUyeler = new ArrayList<ElitUye>();
        ArrayList<GenelUye> genelUyeler = new ArrayList<GenelUye>();
        int secim;

        do {
            System.out.println("\n1 - Elit Üye Ekle");
            System.out.println("2 - Genel Üye Ekle");
            System.out.println("3 - Mail Gönderme");
            System.out.println("0 - Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Elit Üye için isim girin: ");
                    String elitIsim = scanner.next();
                    System.out.print("Elit Üye için soyisim girin: ");
                    String elitSoyisim = scanner.next();
                    System.out.print("Elit Üye için e-posta girin: ");
                    String elitEmail = scanner.next();
                    ElitUye elitUye = new ElitUye(elitIsim, elitSoyisim, elitEmail);
                    elitUyeler.add(elitUye);
                    System.out.println("Elit Üye başarıyla eklendi.");
                    break;
                case 2:
                    System.out.print("Genel Üye için isim girin: ");
                    String genelIsim = scanner.next();
                    System.out.print("Genel Üye için soyisim girin: ");
                    String genelSoyisim = scanner.next();
                    System.out.print("Genel Üye için e-posta girin: ");
                    String genelEmail = scanner.next();
                    GenelUye genelUye = new GenelUye(genelIsim, genelSoyisim, genelEmail);
                    genelUyeler.add(genelUye);
                    System.out.println("Genel Üye başarıyla eklendi.");
                    break;
                case 3:
                    System.out.println("\n1 - Sadece Elit Üyelere Mail Gönder");
                    System.out.println("2 - Sadece Genel Üyelere Mail Gönder");
                    System.out.println("3 - Tüm Üyelere Mail Gönder");
                    System.out.print("Seçiminiz: ");
                    int mailSecim = scanner.nextInt();
                    scanner.nextLine();  // dummy read
                    System.out.print("Mail Konusu: ");
                    String konu = scanner.nextLine();
                    System.out.print("Mail İçeriği: ");
                    String icerik = scanner.nextLine();
                    if (mailSecim == 1) {
                        mailGonder(elitUyeler, konu, icerik);
                    } else if (mailSecim == 2) {
                        mailGonder(genelUyeler, konu, icerik);
                    } else if (mailSecim == 3) {
                        ArrayList<Uye> tumUyeler = new ArrayList<Uye>();
                        tumUyeler.addAll(elitUyeler);
                        tumUyeler.addAll(genelUyeler);
                        mailGonder(tumUyeler, konu, icerik);
                    } else {
                        System.out.println("Geçersiz seçim!");
                    }
                    break;
                case 0:
                    System.out.println("Program sonlandırılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }
        } while (secim != 0);
    }

    public static void mailGonder(ArrayList<? extends Uye> uyeler, String konu, String icerik) throws IOException {
        FileWriter writer = new FileWriter("mailler.txt");
        for (Uye uye : uyeler) {
            writer.write(uye.getIsim() + "\t" + uye.getIsim() + "\t" + uye.getEmail() + "\n");
            System.out.println("Mail gönderildi: " + uye.getEmail());
        }
        writer.close();
    }
}