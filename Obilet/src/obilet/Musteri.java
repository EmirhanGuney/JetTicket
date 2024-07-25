/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package obilet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static obilet.Sirket.readFromFile;

/**
 *
 * @author Emirhan Guney
 */
public class Musteri {
     public static void main(String[] args) {
         JFrame frameAna=new JFrame();
         frameAna.setBounds(400, 100, 600, 600);
         frameAna.setLayout(null);
        JPanel panelAna=new JPanel();
        panelAna.setLayout(null);
        panelAna.setBounds(0,0,600,600);
        JButton planeB=new JButton("PLANE");
        planeB.setVisible(false);
        JButton busB=new JButton("BUS");
        busB.setVisible(false);
        JButton trainB=new JButton("TRAİN");
        trainB.setVisible(false);
         String[] locations = {"İstanbul","Kocaeli","Bilecik", "Ankara", "Eskişehir", "Konya"};
         
          JComboBox<String> arriveLocations = new JComboBox<>(locations);
       
       arriveLocations.setBackground(Color.LIGHT_GRAY);
         arriveLocations.setForeground(Color.DARK_GRAY);
         
          JComboBox<String> landingLocations = new JComboBox<>(locations);
       landingLocations.setBounds(0,90,250,30);
       landingLocations.setBackground(Color.LIGHT_GRAY);
         landingLocations.setForeground(Color.DARK_GRAY);
         
         JLabel arrive=new JLabel("Başlangıç:");
         JLabel landing=new JLabel("Bitiş:");
         arrive.setBounds(0,0,300,50);
         arriveLocations.setBounds(0,50,300,50);
         landing.setBounds(0,100,300,50);
         landingLocations.setBounds(0,150,300,50);
         JPanel loc=new JPanel();
         loc.setLayout(null);
         JButton butonOk=new JButton("Vasıta Seç");
         butonOk.setBounds(100,250,100,50);
          butonOk.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int l=landingLocations.getSelectedIndex();
        int a=arriveLocations.getSelectedIndex();
        if(l==a)
        {
             
               

                    // İşlem tamamlandı mesajını göster
                    JOptionPane.showMessageDialog(null, "Rota Oluşturulamadı!");
                   
                    
                
        }
        else
                {
                loc.setVisible(false);
              
        planeB.setVisible(true);
        
        busB.setVisible(true);
        
        trainB.setVisible(true);
       
                }
        
    }   
    });  
         loc.setBounds(200,100,300,300);
         loc.setBackground(Color.pink);
         loc.add(landingLocations);
         loc.add(arriveLocations);
         loc.add(arrive);
         loc.add(landing);
         loc.add(butonOk);
         panelAna.add(loc);
        planeB.setBounds(50,50,100,50);
         busB.setBounds(50,150,100,50);
          trainB.setBounds(50,250,100,50);
          
         JButton butonExit=new JButton("EXIT");
        butonExit.setBounds(450,500,100,50);
         butonExit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
               
             main(new String[]{});
       frameAna.setVisible(false);
       
    }   
    });  
         busB.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
        JButton butonA=new JButton("A firması");
        JButton butonB=new JButton("B firması");
        JButton butonC=new JButton("C firması");
        butonA.setBounds(50,50,100,50);
         butonB.setBounds(250,50,100,50);
          butonC.setBounds(450,50,100,50);
           JButton butonBiletBul=new JButton("Bilet Bul");
        butonBiletBul.setBounds(300,200,100,50);
        butonBiletBul.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        biletalma b=new biletalma();
        b.setVisible(true);
    }   
    });
           butonA.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt","AO");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
        
       
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
            butonB.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
          panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt","BO");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
        
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
             butonC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
          panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\buses.txt","CO");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
        
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
       
        panelAna.add(butonExit);
        panelAna.add(butonA);
         panelAna.add(butonB);
          panelAna.add(butonC);
          frameAna.validate(); // Frame'i güncelle
    }   
    });  
         
          planeB.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
        
        JButton butonC=new JButton("C firması");
        JButton butonF=new JButton("F firması");
        JButton butonBiletBul=new JButton("Bilet Bul");
        butonBiletBul.setBounds(300,200,100,50);
         butonBiletBul.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        biletalmaucak b=new biletalmaucak();
        b.setVisible(true);
    }   
    });
          butonC.setBounds(50,50,100,50);
           butonF.setBounds(250,50,100,50);
         butonC.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt","CU");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
        
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
          butonF.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\planes.txt","FU");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
       
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
        JButton butonExit=new JButton("EXIT");
        butonExit.setBounds(450,500,100,50);
        butonExit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         main(new String[]{});
       frameAna.setVisible(false);
    }   
    });  
        panelAna.add(butonExit);
         panelAna.add(butonF);
          panelAna.add(butonC);
        
        
          frameAna.validate(); // Frame'i güncelle
    }   
    });  
           trainB.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
        
        JButton butonD=new JButton("D firması");
       
          butonD.setBounds(50,50,100,50);
           JButton butonBiletBul=new JButton("Bilet Bul");
        butonBiletBul.setBounds(300,200,100,50);
         butonBiletBul.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         biletalmatren b=new biletalmatren();
        b.setVisible(true);
    }   
    });
           butonD.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            panelAna.removeAll(); // Paneli temizle
        panelAna.revalidate(); // Layout'u güncelle
        panelAna.repaint(); // Paneli yeniden çiz
       
          ArrayList<String> musteriList = readFromFileStartingWithValue("C:\\Users\\Emirhan Guney\\Documents\\NetBeansProjects\\Obilet\\src\\obilet\\trains.txt","DT");

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String data : musteriList) {
            listModel.addElement(data);
        }

        JList<String> jList = new JList<>(listModel);
        JScrollPane firmalarPane = new JScrollPane(jList);
        firmalarPane.setBounds(0, 0, 400, 200);
        
panelAna.add(butonBiletBul);
panelAna.add(firmalarPane);
panelAna.add(butonExit);
    }   
    });  
           JButton butonExit=new JButton("EXIT");
        butonExit.setBounds(450,500,100,50);
         butonExit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
         main(new String[]{});
       frameAna.setVisible(false);
    }   
    });  
        panelAna.add(butonExit);
         panelAna.add(butonD);
          frameAna.validate(); // Frame'i güncelle
    }   
    });  
         
         
         
         
         panelAna.add(busB);
         panelAna.add(planeB);
         panelAna.add(trainB);
         frameAna.add(panelAna);
     
         frameAna.setVisible(true);
         frameAna.setDefaultCloseOperation(EXIT_ON_CLOSE);
     }
    public static ArrayList<String> readFromFileStartingWithValue(String fileName,String startChar) {
    ArrayList<String> readList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.trim().startsWith(startChar)) {
                readList.add(line);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return readList;
}
    
public static JFrame ekranGoster(String tip)
{
    JFrame frameAna=new JFrame();
         frameAna.setBounds(1000, 100, 400, 600);
         frameAna.setLayout(null);
        JPanel panelAna=new JPanel();
        panelAna.setLayout(null);
        panelAna.setBounds(0,0,400,600);
        
         JButton butonExit=new JButton("EXIT");
         butonExit.setBounds(270,500,100,50);
         butonExit.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       frameAna.setVisible(false);
    }   
    });
         
         
         if(tip.equals("Bus"))
         {
             JPanel panelOtobüs=new JPanel();
             panelOtobüs.setBounds(5,5 ,300 ,450 );
             panelOtobüs.setBackground(Color.red);
             
             
             
             JButton butonOnayla=new JButton("Bilet Al");
             butonOnayla.setBounds(5,500,100,50);
             
             
             panelAna.add(butonOnayla);
             panelAna.add(panelOtobüs);
         }
         else if(tip.equals("Plane"))
         {
             JPanel panelUcak=new JPanel();
             panelUcak.setBounds(5,5 ,300 ,450 );
             panelUcak.setBackground(Color.red);
             JButton butonOnayla=new JButton("Bilet Al");
             butonOnayla.setBounds(5,500,100,50);
             panelAna.add(butonOnayla);
             panelAna.add(panelUcak);
         }
         else if(tip.equals("Train"))
         {
             JPanel panelTren=new JPanel();
             panelTren.setBounds(5,5 ,300 ,450 );
             panelTren.setBackground(Color.red);
             JButton butonOnayla=new JButton("Bilet Al");
             butonOnayla.setBounds(5,500,100,50);
             panelAna.add(butonOnayla);
             panelAna.add(panelTren);
         }
         panelAna.add(butonExit);
         frameAna.add(panelAna);
         frameAna.setVisible(true);
         return frameAna;
         
}
}
