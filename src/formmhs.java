import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class formmhs extends JFrame{
    JLabel lnim,lnama,lalamat,ljudul;
    //JLabel lnim,lnama,lalamat,lgender;
    JTextField txnim,txnama,txalamat;
    JButton cetak,lihat,update,hapus;
    //JRadioButton Laki,Perempuan;
    Statement statement;
    
    
    public void tesformmhs (){
        
        setTitle("From Pengisian Mahasiswa");
        
        ljudul = new JLabel("MASUKKAN DATA MAHASISWA"); 
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");        
        lalamat = new JLabel("Alamat");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txalamat = new JTextField("");
        
        cetak = new JButton("Kirim");
        lihat = new JButton("Lihat");
        hapus = new JButton("Hapus");
        update = new JButton("Edit");

        
        setLayout(null);
        add(lnim);
        add(lnama);
        add(lalamat);
        add(txnim);
        add(txnama);
        add(txalamat);
        add(cetak);
        add(hapus);
        add(update);
        add(lihat);
        add(ljudul);
        
        ljudul.setBounds(180, 10, 335, 20);
        lnim.setBounds(80, 50, 30, 20);
        lnama.setBounds(80, 75, 50, 20);
        lalamat.setBounds(80, 100, 50, 20);
        txnim.setBounds(150, 50, 250, 20);
        txnama.setBounds(150, 75, 250, 20);
        txalamat.setBounds(150, 100, 250, 100);
        cetak.setBounds(75, 240, 75, 20);
        lihat.setBounds(160, 240, 75, 20);
        update.setBounds(245, 240, 75, 20);
        hapus.setBounds(330, 240, 75, 20);
     
        
        setSize(500,400); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        cetak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int a1 =  Integer.parseInt(txnim.getText());
                    String a2 = txnama.getText();
                    String a3 = txalamat.getText();
//                

KoneksiDB koneksi = new KoneksiDB();
try {
    statement = koneksi.getKoneksi().createStatement();
    //perintah insert
    statement.executeUpdate("INSERT INTO data_mhs VALUES ('"
            + a2 + "','" + a1 + "','" + a3 + "')");
    JOptionPane.showMessageDialog(rootPane, "Data Tersimpan");
} catch (ClassNotFoundException ex) {
    Logger.getLogger(formmhs.class.getName()).log(Level.SEVERE, null, ex);
} catch (SQLException ex) {
    Logger.getLogger(formmhs.class.getName()).log(Level.SEVERE, null, ex);
}

System.out.println("NIM = "+a1);
System.out.println("Nama = "+a2);

System.out.println("Alamat = "+a3);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane,"TIPE DATA SALAH");
                } catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane,"SALAH");
                    
                }
            } 
        });
        
        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                HapusData dt = new HapusData();
                dt.HapusDatamhs();
                new formmhs();
            }
        });
        
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EditData dt = new EditData();
                dt.EditDataForm();
                new formmhs();
            }
        });
        
        lihat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LihatDataMahasiswa dt = new LihatDataMahasiswa();
                dt.Lihatdata();
                new formmhs();
            }
        });
    }
}
