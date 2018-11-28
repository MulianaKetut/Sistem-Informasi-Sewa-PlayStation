/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Playstation;
import util.PsHibernateUtil;

/**
 *
 * @author danielbram
 */
public class PlaystationHelper {
    public  PlaystationHelper(){
        
    }
    public List<Playstation> getAllPlaystation(){
        List<Playstation> result = null;
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        String query = "from Playstation p";
        Query q = session.createQuery(query);
        result = q.list();
        session.close();
        return result;
    }
     public void addNewPlaystation(String idPlayStation, String namaPlayStation, int hargaSewaPlayStation, String status){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();                                
        Playstation ps = new Playstation(idPlayStation, namaPlayStation, hargaSewaPlayStation, status);
        session.save(ps);
        transaction.commit();
        session.close();
    }
}
