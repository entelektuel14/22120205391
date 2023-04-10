package Uye;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailGonderme {
    private ArrayList<ElitUye> elitUyeler;
    private ArrayList<GenelUye> genelUyeler;

    public MailGonderme(ArrayList<ElitUye> elitUyeler, ArrayList<GenelUye> genelUyeler) {
        this.elitUyeler = elitUyeler;
        this.genelUyeler = genelUyeler;
    }

    public void mailGonder(int choice) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mail içeriği: ");
        String mailIcerigi = scanner.nextLine();

        String host = "smtp.office365.com"; // Mail sunucusu (Outlook kullanıldı)
        String kullaniciAdi = "deneme@outlook.com"; // Mail adresi
        String sifre = "denemesifre"; // Mail şifresi
        int port = 587; // Mail sunucusunun portu (Outlook için 587 kullanılır)

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(kullaniciAdi, sifre);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(kullaniciAdi));
            message.setSubject("Ödev Maili");

            switch (choice) {
                case 1:
                    for (ElitUye elitUye : elitUyeler) {
                        String email = elitUye.getEmail();
                        if (email != null && email.length() > 0) {
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                            message.setText(mailIcerigi);
                            Transport.send(message);
                        }
                    }
                    break;
                case 2:
                    for (GenelUye genelUye : genelUyeler) {
                        String email = genelUye.getEmail();
                        if (email != null && email.length() > 0) {
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                            message.setText(mailIcerigi);
                            Transport.send(message);
                        }
                    }
                    break;
                case 3:
                    for (ElitUye elitUye : elitUyeler) {
                        String email = elitUye.getEmail();
                        if (email != null && email.length() > 0) {
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                            message.setText(mailIcerigi);
                            Transport.send(message);
                        }
                    }
                    for (GenelUye genelUye : genelUyeler) {
                        String email = genelUye.getEmail();
                        if (email != null && email.length() > 0) {
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
message.setText(mailIcerigi);
Transport.send(message);
}
}
break;
default:
System.out.println("Geçersiz seçim!");
}
System.out.println("Mail başarıyla gönderildi!");
    } catch (MessagingException e) {
        System.out.println("Mail gönderilirken hata oluştu!");
        e.printStackTrace();
    }
}
    }