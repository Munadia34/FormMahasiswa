
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


public class EditData extends JFrame{
    JLabel lnim,lnama,lalamat,ljudul;
    JTextField txnim,txnama,txalamat;
    JButton update,kembali;
    Statement statement;
    ResultSet resultset;
    
    
    public void EditDataForm (){
        
        setTitle("From Edit Mahasiswa");
        
        ljudul = new JLabel("MASUKKAN NIM YANG AKAN DI UPDATE"); 
        lnim = new JLabel("NIM");
        lnama = new JLabel("Nama");
        lalamat = new JLabel("Alamat");
        
        txnim = new JTextField("");
        txnama = new JTextField("");
        txalamat = new JTextField("");
        
        update = new JButton("Update");
        kembali = new JButton("Back");
        
        setLayout(null);
        ljudul.setHorizontalAlignment(SwingConstants.CENTER);
        add(ljudul);
        add(lnim);
        add(lnama);
        add(lalamat);
        add(txnim);
        add(txnama);
        add(txalamat);
        add(update);
        add(kembali);

        ljudul.setBounds(90, 10, 335, 20);
        lnim.setBounds(80, 50, 30, 20);
        lnama.setBounds(80, 75, 50, 20);
        lalamat.setBounds(80, 100, 50, 20);
        txnim.setBounds(150, 50, 250, 20);
        txnama.setBounds(150, 75, 250, 20);
        txalamat.setBounds(150, 100, 250, 100);
        update.setBounds(175, 230, 75, 20);
        kembali.setBounds(300, 230, 75, 20);
        
        
        setSize(500,400); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                formmhs fm = new formmhs();
                fm.tesformmhs();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUpdateactionListener();
            }
        });
        }
        private void btnUpdateactionListener(){
            KoneksiDB koneksi = new KoneksiDB();
            try {
                statement = koneksi.getKoneksi().createStatement();
                //perintah update
                statement.executeUpdate("UPDATE data_mhs SET nama= '" 
                        + txnama.getText() + "'," + " alamat='" + txalamat.getText() + "' WHERE nim='" + txnim.getText() + "'");
                JOptionPane.showMessageDialog(null, "Data berhasil di Update","Hasil", JOptionPane.INFORMATION_MESSAGE);
                statement.close();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan ","Hasil", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Data gagal di Update","Hasil", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

