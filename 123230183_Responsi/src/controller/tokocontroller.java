package controller;

import java.util.List;
import DAOdatatoko.datatokoDAO;
import DAOImplement.datatokoimplement;
import javax.swing.JOptionPane;
import model.toko;
import model.TabelDataToko;
import view.MainView;

public class tokocontroller {
    MainView frame;
    datatokoimplement impltoko;
    List<toko> dp;
    
    public tokocontroller(MainView frame){
        this.frame = frame;
        impltoko = new datatokoDAO();
        dp = impltoko.getAll();
    }
    
    public void isitable(){
        
    }
    
    public void insert(){
        try {
            toko db = new toko();
            db.setNama(frame.getNama().getText());
        } catch (Exception e) {
        }
    }
}