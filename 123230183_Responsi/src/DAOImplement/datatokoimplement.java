package DAOImplement;

import java.util.List;
import model.*;

public interface datatokoimplement {
    public void insert(toko t);
    public void update(toko t);
    public void delete(int id);
    public List<toko> getAll();
}