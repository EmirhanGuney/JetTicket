package obilet;

import com.sun.tools.javac.Main;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Emirhan Guney
 */
public class Admin {

    public static void main(String[] args) {
        JFrame girisEkran = new JFrame(); // Değişiklik burada yapıldı
        girisEkran.setLayout(null);
        girisEkran.setBounds(0, 0, 750, 600);
 JButton butonGiris = new JButton("Giriş Yap");
        butonGiris.setBounds(320, 450, 100, 50);
        JButton butonAktar = new JButton("AKTAR");
        butonAktar.setBounds(630, 510, 100, 50);
        butonAktar.addActionListener(new ActionListener(){
        @Override
         public void actionPerformed(ActionEvent e){
             
              Sirket ac = new Sirket();
                ac.main(new String[]{});
                girisEkran.setVisible(false);
         }

});

        butonGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Musteri mst=new Musteri();
               
               mst.main(new String[]{});
               girisEkran.setVisible(false);
            }
        });
        JPanel girisPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image imgANA = new ImageIcon(Admin.class.getResource("girispanel.png")).getImage();
                g.drawImage(imgANA, 0, 0, getWidth(), getHeight(), (ImageObserver) this);
                
            }
        };
        girisPanel.setBounds(0, 0, 750, 600);
        girisPanel.setLayout(null);

       JLabel label=new JLabel();
       label.setBounds(0,0,750,100);

        girisPanel.add(butonGiris);
         girisPanel.add(butonAktar);
        girisEkran.add(girisPanel);
        girisEkran.setVisible(true);

        // Set the default close operation here
        girisEkran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

               