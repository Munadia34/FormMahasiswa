
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class HapusData extends JFrame{
    JLabel lnim,ljudul;
    JTextField txnim;
    JButton hapus,kembali;
    Statement statement;
    ResultSet resultset;
    
    
    public void HapusDatamhs (){
        
        setTitle("Form Hapus Data Mahasiswa");
        
        ljudul = new JLabel("Hapus Data Mahasiswa"); 
        lnim = new JLabel("NIM");
        
        txnim = new JTextField();
        
        hapus = new JButton("Hapus");
        kembali = new JButton("Back");

        
        setLayout(null);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(ljudul);
        add(lnim);
        add(txnim);
        add(hapus);
        add(kembali);
        
        ljudul.setBounds(50, 10, 150, 25);
        lnim.setBounds(50, 50, 100, 25);
        txnim.setBounds(100, 50, 100, 25);
        hapus.setBounds(140, 90, 100, 25);
        kembali.setBounds(30, 90, 100, 25);       
        
        setSize(300,200); 
        
        
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       System.out.println("Nim = "+txnim.getText());
        
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                formmhs fm = new formmhs();
                fm.tesformmhs();
            }
        });
        hapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDeleteactionListener();
            }
        });
    }
    private void btnDeleteactionListener(){
        KoneksiDB koneksi = new KoneksiDB();
        try {
            statement = koneksi.getKoneksi().createStatement();
            //perintah hapus
            statement.executeUpdate("DELETE FROM data_mhs WHERE nim='" + txnim.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data berhasil di Update","Hasil", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan ","Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal di Hapus!","Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
}

