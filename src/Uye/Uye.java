package Uye;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Uye {
    protected String isim;
    protected String soyisim;
    protected String email;
    protected String dosyaAdi = "uyeler.txt";
    protected String dosyaFormati = "\t";

    public Uye(String isim, String soyisim, String email) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.email = email;
    }

    public void yaz() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));
        writer.write(isim + dosyaFormati + soyisim + dosyaFormati + email + "\n");
        writer.close();
    }

    public void oku() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
        String satir = reader.readLine();
        while (satir != null) {
            String[] bilgiler = satir.split(dosyaFormati);
            String isim = bilgiler[0];
            String soyisim = bilgiler[1];
            String email = bilgiler[2];
            System.out.println(isim + " " + soyisim + " " + email);
            satir = reader.readLine();
        }
        reader.close();
    }

	public String getIsim() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
