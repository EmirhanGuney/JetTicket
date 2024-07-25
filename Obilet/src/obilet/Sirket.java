/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package obilet;

import com.sun.tools.javac.Main;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Emirhan Guney
 */
public class Sirket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Frame anaEkran=new JFrame();
      anaEkran.setLayout(null);
      anaEkran.setBounds(0, 0, 800, 600);
      JPanel panelAna=new JPanel();
      panelAna.setBounds(0,0,800,600);
      panelAna.setLayout(null);
      JButton admin=new JButton();
      admin.setBounds(200,100,128,128);
      
      JButton firma=new JButton();
      firma.setBounds(400,100,128,128);
       Image foto1= new ImageIcon(Sirket.class.getResource("admn.png")).getImage();
       JLabel label1=new JLabel("YÖNETİCİ");
       label1.setBounds(235, 228, 128, 50);
        JLabel label2=new JLabel("FİRMA");
       label2.setBounds(445, 228, 128, 50);
       
         Image foto2= new ImageIcon(Sirket.class.getResource("frm.png")).getImage();
         admin.setIcon(new ImageIcon(foto1));
         admin.setBackground(Color.darkGray);
         firma.setIcon(new ImageIcon(foto2));
         firma.setBackground(Color.darkGray);
         anaEkran.add(label1);
         anaEkran.add(label2);
         panelAna.setBackground(Color.LIGHT_GRAY);
         
         
      firma.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz

        JPanel panelListe = new JPanel();

        panelListe.setBounds(0, 0, 400, 300);
        panelListe.setLayout(null);
        panelListe.setBackground(Color.red);

        ArrayList<String> musteriList = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmadlari.txt");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);

        JButton butonGir = new JButton("GIRIS");
        butonGir.setBounds(300, 250, 100, 50);

        butonGir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = jList.getSelectedIndex();
                
                int selectedIdx = jList.getSelectedIndex();
                if (selectedIdx != -1) {
                    String kullaniciAdi = jList.getSelectedValue();
                    String sifre = kullaniciAdi + ".S1";

                    // Şifre iste
                    String girilenSifre = JOptionPane.showInputDialog(panelListe, "Şifrenizi giriniz:", "Şifre Girişi", JOptionPane.PLAIN_MESSAGE);

                    if (girilenSifre != null && girilenSifre.equals(sifre)) {
                        
                        
                        panelAna.removeAll(); // Paneli temizle
                        panelAna.revalidate(); // Layout'u güncelle
                        panelAna.repaint(); // Paneli yeniden çiz
                        if(kullaniciAdi.equals("A"))
                        {
                             ArrayList<String> aracListOtobus = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt");

                  DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : aracListOtobus) {
            if (data.startsWith(kullaniciAdi+"O")) {
                listModel.addElement(data);
            }
        }
                     JList<String> jVehicle = new JList<>(listModel);    
                        JScrollPane otobusler = new JScrollPane(jVehicle);
                        otobusler.setBounds(0, 0, 300, 200);
                        JButton butonAracEkle=new JButton("Arac Ekle");
                        butonAracEkle.setBounds(20,250,100,50);
                        butonAracEkle.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});

                        JButton butonAracSil=new JButton("Arac Sil");
                        butonAracSil.setBounds(20,350,100,50);
                         butonAracSil.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        panelAna.add(butonAracEkle);
                        panelAna.add(butonAracSil);
                        JButton butonref=new JButton("REFRESH");
                        butonref.setBounds(20,500,100,50);
                         butonref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             anaEkran.setVisible(false);
                             Sirket.main(new String[]{});
                        }   
                        } );
                        panelAna.add(butonref);
                        panelAna.add(otobusler);
                       
                        }
                        else if(kullaniciAdi.equals("B"))
                                {
                                        ArrayList<String> aracListOtobus = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt");

                  DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : aracListOtobus) {
            if (data.startsWith(kullaniciAdi+"O")) {
                listModel.addElement(data);
            }
        }
                     JList<String> jVehicle = new JList<>(listModel);    
                        JScrollPane otobusler = new JScrollPane(jVehicle);
                        otobusler.setBounds(0, 0, 300, 200);
                        JButton butonAracEkle=new JButton("Arac Ekle");
                        butonAracEkle.setBounds(20,250,100,50);
                        butonAracEkle.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        JButton butonAracSil=new JButton("Arac Sil");
                        butonAracSil.setBounds(20,350,100,50);
                          butonAracSil.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        panelAna.add(butonAracEkle);
                        panelAna.add(butonAracSil);
                         JButton butonref=new JButton("REFRESH");
                        butonref.setBounds(20,500,100,50);
                         butonref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             anaEkran.setVisible(false);
                             Sirket.main(new String[]{});
                        }   
                        } );
                        panelAna.add(butonref);
                        panelAna.add(otobusler);
                                }
                        
                        else if(kullaniciAdi.equals("C"))
                        {
                                      ArrayList<String> aracListOtobus = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt");

                  DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : aracListOtobus) {
            if (data.startsWith(kullaniciAdi+"O")) {
                listModel.addElement(data);
            }
        }
        
                     JList<String> jVehicle = new JList<>(listModel);    
                        JScrollPane otobusler = new JScrollPane(jVehicle);
                        otobusler.setBounds(0, 0, 300, 200);
                        panelAna.add(otobusler);
                        
                        
                                     ArrayList<String> aracListUcak = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt");

                  DefaultListModel<String> listModelUcak = new DefaultListModel<>();
        for (String data : aracListUcak) {
            if (data.startsWith(kullaniciAdi+"U")) {
                listModelUcak.addElement(data);
            }
        }
        
                     JList<String> jVehicleUcak = new JList<>(listModelUcak);    
                        JScrollPane ucaklar = new JScrollPane(jVehicleUcak);
                        ucaklar.setBounds(300, 0, 300, 200);
                        JButton butonAracEkle=new JButton("Arac Ekle");
                        butonAracEkle.setBounds(20,250,100,50);
                         butonAracEkle.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();
if (aracId != null && aracId.length() >= 2 && aracId.substring(0, 2).equals("CO")) {
     addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);
} else {
     addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt", aracId);
}
                // Veriyi dosyaya ekleyebilirsiniz
               

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        JButton butonAracSil=new JButton("Arac Sil");
                        butonAracSil.setBounds(20,350,100,50);
                         butonAracSil.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt", aracId);
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        panelAna.add(butonAracEkle);
                        panelAna.add(butonAracSil);
                         JButton butonref=new JButton("REFRESH");
                        butonref.setBounds(20,500,100,50);
                          butonref.setBounds(20,500,100,50);
                          butonref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             anaEkran.setVisible(false);
                             Sirket.main(new String[]{});
                        }   
                        } );
                        panelAna.add(butonref);
                        panelAna.add(ucaklar);
                                     
                        }
                        else if(kullaniciAdi.equals("D"))
                        {
                                   ArrayList<String> aracListTren = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\trains.txt");

                  DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : aracListTren) {
            if (data.startsWith(kullaniciAdi+"T")) {
                listModel.addElement(data);
            }
        }
                     JList<String> jVehicleTen = new JList<>(listModel);    
                        JScrollPane trenler = new JScrollPane(jVehicleTen);
                        trenler.setBounds(0, 0, 300, 200);
                        JButton butonAracEkle=new JButton("Arac Ekle");
                        butonAracEkle.setBounds(20,250,100,50);
                        butonAracEkle.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\trains.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        JButton butonAracSil=new JButton("Arac Sil");
                        butonAracSil.setBounds(20,350,100,50);
                          butonAracSil.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\train.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        panelAna.add(butonAracEkle);
                        panelAna.add(butonAracSil);
                         JButton butonref=new JButton("REFRESH");
                        butonref.setBounds(20,500,100,50);
                          butonref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             anaEkran.setVisible(false);
                             Sirket.main(new String[]{});
                        }   
                        } );
                        panelAna.add(butonref);
                        panelAna.add(trenler); 
                        }
                        else if(kullaniciAdi.equals("F"))
                        {
                             ArrayList<String> aracListUcak = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt");

                  DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : aracListUcak) {
            if (data.startsWith(kullaniciAdi+"U")) {
                listModel.addElement(data);
            }
        }
                     JList<String> jVehicle = new JList<>(listModel);    
                        JScrollPane ucaklar = new JScrollPane(jVehicle);
                        ucaklar.setBounds(0, 0, 300, 200);
                        JButton butonAracEkle=new JButton("Arac Ekle");
                        butonAracEkle.setBounds(20,250,100,50);
                       butonAracEkle.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        JButton butonAracSil=new JButton("Arac Sil");
                        butonAracSil.setBounds(20,350,100,50);
                         butonAracSil.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // JDialog oluştur
        JDialog dialog = new JDialog();
        dialog.setTitle("Araç Bilgileri");
        dialog.setSize(300, 100);
        dialog.setLayout(new GridLayout(2, 2));

        // Araç ID
        JLabel idLabel = new JLabel("Araç ID Girin:");
        JTextField idField = new JTextField();
        dialog.add(idLabel);
        dialog.add(idField);

        // Onay Butonu
        JButton onayButon = new JButton("Onayla");
        onayButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kullanıcının girdiği araç ID'ye erişim
                String aracId = idField.getText();

                // Veriyi dosyaya ekleyebilirsiniz
                removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt", aracId);

                // Ekledikten sonra paneli güncelle
                panelAna.setVisible(false);
                panelAna.setVisible(true);
                dialog.dispose();
            }
        });
        dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
        dialog.add(onayButon);

        // Dialog'u görünür yap
        dialog.setVisible(true);
    }
});
                        panelAna.add(butonAracEkle);
                        panelAna.add(butonAracSil);
                         JButton butonref=new JButton("REFRESH");
                        butonref.setBounds(20,500,100,50);
                          butonref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                             anaEkran.setVisible(false);
                             Sirket.main(new String[]{});
                        }   
                        } );
                        panelAna.add(butonref);
                        panelAna.add(ucaklar);
                            
                        }
                       
                        
                    } else {
                        JOptionPane.showMessageDialog(panelListe, "Giriş Başarısız", "Başarısız", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panelListe, "Lütfen bir kullanıcı seçin", "Uyarı", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        panelListe.add(butonGir);
        panelListe.add(firmalarPane);
        panelAna.add(panelListe);
        anaEkran.validate(); // Frame'i güncelle
    }
        });

admin.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      
         // Kullanıcı adı ve şifre iste
                String kullaniciAdi = JOptionPane.showInputDialog(anaEkran, "Kullanıcı Adı:");
                JPasswordField passwordField = new JPasswordField();
                Object[] inputFields = {"Şifre:", passwordField};

                int option = JOptionPane.showConfirmDialog(anaEkran, inputFields, "Şifre Gir", JOptionPane.OK_CANCEL_OPTION);

                if (option == JOptionPane.OK_OPTION) {
                    String sifre = new String(passwordField.getPassword());

                    // Doğrulama işlemleri
                    String dogruAd = "1";
                    String dogruSifre = "1";

                    if (kullaniciAdi.equals(dogruAd) && sifre.equals(dogruSifre)) {
                        
                        panelAna.removeAll(); // Paneli temizle
                        panelAna.revalidate(); // Layout'u güncelle
                        panelAna.repaint(); // Paneli yeniden çiz
                        
                        JButton butonM=new JButton("Musteriler");
                        JButton butonS=new JButton("Sifreler");
                        JButton butonU=new JButton("Ucretler");
                        butonM.setBounds(20, 100, 100, 80);
                        butonS.setBounds(20, 200, 100, 80);
                        butonU.setBounds(20, 300, 100, 80);
  butonM.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JPanel panelListe = new JPanel();
        panelListe.setLayout(null);
        panelListe.setBounds(130, 100, 200, 200);
        panelListe.setBackground(Color.red);

        ArrayList<String> musteriList = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmadlari.txt");
       

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane musteriPane = new JScrollPane(jList);
        musteriPane.setBounds(0, 0, 200, 200);

        panelListe.add(musteriPane);
        panelAna.add(panelListe);

        // Yeniden düzenleme ve tekrar çizme işlemlerini gerçekleştir
        panelAna.revalidate();
        panelAna.repaint();
    }
});
    butonU.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      JPanel panelListe = new JPanel();
        panelListe.setLayout(null);
        panelListe.setBounds(530, 100, 200, 200);
        panelListe.setBackground(Color.red);

        ArrayList<String> musteriList = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmaucretleri.txt");
       

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane musteriPane = new JScrollPane(jList);
        musteriPane.setBounds(0, 0, 200, 200);

        panelListe.add(musteriPane);
        panelAna.add(panelListe);

        // Yeniden düzenleme ve tekrar çizme işlemlerini gerçekleştir
        panelAna.revalidate();
        panelAna.repaint();
    }
});                    
 

     butonS.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       JPanel panelListe = new JPanel();
        panelListe.setLayout(null);
        panelListe.setBounds(330, 100, 200, 200);
        panelListe.setBackground(Color.red);

        ArrayList<String> musteriList = readFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmasifreleri.txt");
       

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }
        
        JList<String> jList = new JList<>(listModel);
        JScrollPane musteriPane = new JScrollPane(jList);
        musteriPane.setBounds(0, 0, 200, 200);

        panelListe.add(musteriPane);
        panelAna.add(panelListe);

        // Yeniden düzenleme ve tekrar çizme işlemlerini gerçekleştir
        panelAna.revalidate();
        panelAna.repaint();
    }
});                     
                      JButton butonEkle=new JButton("Firma Ekle");
                      JButton butonSil= new JButton("Firma Sil");
                      JButton butonGeri=new JButton("REFRESH");
                      

        butonEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // JDialog oluştur
                JDialog dialog = new JDialog();
                dialog.setTitle("Firma Bilgileri");
                dialog.setSize(300, 200);
                dialog.setLayout(new GridLayout(4, 2));

                // Firma Adı
                JLabel isimLabel = new JLabel("Firma Adı Girin:");
                JTextField isimField = new JTextField();
                dialog.add(isimLabel);
                dialog.add(isimField);

                // Firma Şifresi
                JLabel sifreLabel = new JLabel("Firma için Şifre:");
                JTextField sifreField = new JTextField();
                dialog.add(sifreLabel);
                dialog.add(sifreField);

                // Firma Ücreti
                JLabel ucretLabel = new JLabel("Firma için Ücret:");
                JTextField ucretField = new JTextField();
                dialog.add(ucretLabel);
                dialog.add(ucretField);

                // Onay Butonu
                JButton onayButon = new JButton("Onayla");
                onayButon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Kullanıcının girdiği değerlere erişim
                        String isim = isimField.getText();
                        String sifre = sifreField.getText();
                        String ucret = ucretField.getText();

                        // Verileri kullanabilirsiniz, örneğin ekrana yazdırabilirsiniz
                        addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmadlari.txt", isim);
                        addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmasifreleri.txt", sifre);
                        addDataToFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmaucretleri.txt", ucret);
                        panelAna.setVisible(false);
                        panelAna.setVisible(true);
                        dialog.dispose();
                    }
                });
                dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
                dialog.add(onayButon);

                // Dialog'u görünür yap
                dialog.setVisible(true);
            }
        });
        
                       butonSil.addActionListener(new ActionListener() {
                       @Override
                      public void actionPerformed(ActionEvent e) {
                          
                        // JDialog oluştur
                JDialog dialog = new JDialog();
                dialog.setTitle("Firma Bilgileri");
                dialog.setSize(300, 200);
                dialog.setLayout(new GridLayout(4, 2));

                // Firma Adı
                JLabel isimLabel = new JLabel("Silinecek Firma:");
                JTextField isimField = new JTextField();
                dialog.add(isimLabel);
                dialog.add(isimField);

                // Firma Şifresi
                JLabel sifreLabel = new JLabel("Silinecek Sifre:");
                JTextField sifreField = new JTextField();
                dialog.add(sifreLabel);
                dialog.add(sifreField);

                // Firma Ücreti
                JLabel ucretLabel = new JLabel("Ücret:");
                JTextField ucretField = new JTextField();
                dialog.add(ucretLabel);
                dialog.add(ucretField);

                // Onay Butonu
                JButton onayButon = new JButton("Onayla");
                onayButon.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Kullanıcının girdiği değerlere erişim
                        String isim = isimField.getText();
                        String sifre = sifreField.getText();
                        String ucret = ucretField.getText();

                        // Verileri kullanabilirsiniz, örneğin ekrana yazdırabilirsiniz
                       removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmadlari.txt", isim);
                        removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmasifreleri.txt", sifre);
                       removeDataFromFile("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\firmaucretleri.txt", ucret);
                        panelAna.setVisible(false);
                        panelAna.setVisible(true);
                        dialog.dispose();
                    }
                });
                dialog.add(new JLabel()); // Boş bir label ekleyerek düzeni ayarla
                dialog.add(onayButon);

                // Dialog'u görünür yap
                dialog.setVisible(true);
                      }
                       });
                        butonGeri.setBounds(400, 330, 100, 50);
                      butonEkle.setBounds(150, 330, 100, 50);
                      butonSil.setBounds(280, 330, 100, 50);
                      panelAna.add(butonGeri);
                        butonGeri.addActionListener(new ActionListener() {
                       @Override
                      public void actionPerformed(ActionEvent e) {
                          anaEkran.setVisible(false);
                          Sirket.main(new String[]{});
                      }
                       });
                        panelAna.add(butonEkle);
                        panelAna.add(butonSil);
                        panelAna.add(butonU);
                        panelAna.add(butonM);
                        panelAna.add(butonS);
                        anaEkran.validate(); // Frame'i güncelle
} 
                    else {
                        JOptionPane.showMessageDialog(anaEkran, "Kullanıcı adı veya şifre yanlış!");
                    }
                }
          
    }
        });
          
      panelAna.add(firma);
      panelAna.add(admin);
      anaEkran.add(panelAna);
      anaEkran.setVisible(true);
     
      
    }
    
      public static ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> readList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                readList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readList;
    }
     public static void addDataToFile(String fileName, String newData) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
        writer.write(newData);
        writer.newLine();
        System.out.println("Veri dosyaya eklendi: " + newData);
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Hata oluştu: " + e.getMessage());
    }
}
    public static void removeDataFromFile(String fileName, String dataToRemove) {
        ArrayList<String> fileContents = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(dataToRemove)) {
                    fileContents.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Dosyaya güncellenmiş veriyi yazma işlemi
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : fileContents) {
                writer.write(line);
                writer.newLine(); // Her elemanın altına yeni bir satır ekler
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
     

     
}
 