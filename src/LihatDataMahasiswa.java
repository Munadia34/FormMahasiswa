
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;


public class LihatDataMahasiswa extends JFrame{
    String[][] data = new String [500][3];//buat variabel data bentuk array;
    String[] kolom = {"nim","nama","alamat"};
    JTable tabel ;
    JScrollPane scrollPane;
    JButton kembali;
    Statement statement;
    ResultSet resultSet;
    
    public void Lihatdata(){
        setTitle("Data Mahasiswa");
        
        try{
            KoneksiDB koneksi = new KoneksiDB();
            statement = koneksi.getKoneksi().createStatement();
            
            String sql = "SELECT * FROM data_mhs";//perintah mengambil data
            resultSet = statement.executeQuery(sql);
            
            int p = 0 ;
            while (resultSet.next()){
                //kolom sesuai dengan di DB
                data[p][0] = resultSet.getString("nim");
                data[p][1] = resultSet.getString("nama");
                data[p][2] = resultSet.getString("alamat");
                p++;
            }
            statement.close();
            koneksi.getKoneksi().close();
        } catch (SQLException sqle){
            JOptionPane.showMessageDialog(rootPane, "Data Gagal ditampilkan"+sqle);
        } catch (ClassNotFoundException classe){
            JOptionPane.showMessageDialog(rootPane, "Class tidak ditemukan"+classe);
        }
        
        tabel = new JTable(data,kolom);
        scrollPane = new JScrollPane(tabel);
        kembali = new JButton("Back");
        setLayout(new FlowLayout());
        add(scrollPane); add(kembali);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
        kembali.addActionListener((ActionEvent e) -> {
            setVisible(false);
            formmhs fm = new formmhs();
            fm.tesformmhs();
        });
    }
}
