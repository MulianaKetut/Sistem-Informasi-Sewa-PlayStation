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
    
    public List<Penyewaan> searchNikPenyewa(int nik){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Penyewaan where nik=:nik";
        Query q = session.createQuery(query);
        q.setParameter("nik", nik);
        List<Penyewaan> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
    
     public void addNewPenyewaan(int nik, String nama, int nomorHp, String alamat, Date tglSewa, Date tglKembali,  String idPlayStation){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                                        
        Penyewaan sewa = new Penyewaan(nik, nama, nomorHp, alamat, tglSewa, tglKembali, idPlayStation);
        session.save(sewa);
        transaction.commit();
        session.close();
    }
}
