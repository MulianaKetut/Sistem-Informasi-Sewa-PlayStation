/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Penyewaan;
import pojos.Playstation;
import util.PsHibernateUtil;

/**
 *
 * @author danielbram
 */
public class PenyewaanHelper {
     public  PenyewaanHelper(){
        
    }
    public List<Penyewaan> getAllPenyewaan(){
        List<Penyewaan> result = null;
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        String query = "from Penyewaan w";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
     public void addNewPenyewaan(int nik, String nama, int noHP, String alamat, Date tglSewa, Date tglKembali){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                                        
        Penyewaan sewa = new Penyewaan(nik, nama, noHP, alamat, tglSewa, tglKembali);
        session.save(sewa);
        transaction.commit();
        session.close();
    }
}
