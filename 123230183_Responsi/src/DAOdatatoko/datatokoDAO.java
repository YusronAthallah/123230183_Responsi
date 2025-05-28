package DAOdatatoko;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.toko;
import DAOImplement.datatokoimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
                
public class datatokoDAO implements datatokoimplement{
    private final Connection connection;
    
    private static final String SELECT_ALL = "SELECT * FROM toko";
    private static final String INSERT = "INSERT INTO toko (Nama, Barang, Harga, Cicilan, Bunga, Angsuran, Total) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE toko SET Nama=?, Barang=?, Harga=?, Cicilan=?, Bunga=?, Angsuran=?, Total=? WHERE id=?";
    private static final String DELETE = "DELETE FROM toko WHERE id=?";
    
    public datatokoDAO(){
        this.connection = connector.connection();
    }
    
    @Override
    public void insert(toko t){
        try (PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, t.getNama());
            statement.setString(2, t.getBarang());
            statement.executeUpdate();
            
            try(ResultSet rs = statement.getGeneratedKeys()){
                if (rs.next()){
                    t.setID(rs.getInt(1));
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(datatokoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}