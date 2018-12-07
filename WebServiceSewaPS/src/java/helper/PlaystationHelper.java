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
    
    public List<Playstation> searchStatus(String status){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Playstation where status=:status";
        Query q = session.createQuery(query);
        q.setParameter("status", status);
        List<Playstation> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
    
    public List<Playstation> searchIdPs(String idPs){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String query = "from Playstation where idPlayStation=:idPlayStation";
        Query q = session.createQuery(query);
        q.setParameter("idPlayStation", idPs);
        List<Playstation> list = q.list();
        tx.commit();
        session.close();
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
    
    public void updateStatus(String idPlayStation,
            String namaPlayStation,
            int hargaSewaPlayStation,
            String status){
        Session session = PsHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Playstation> list = searchStatus(status);
        Playstation ps = new Playstation();
        ps.setIdPlayStation(list.get(0).getIdPlayStation());
        ps.setNamaPlayStation(list.get(0).getNamaPlayStation());
        ps.setHargaSewaPlayStation(list.get(0).getHargaSewaPlayStation());
        ps.setStatus(status);
        session.update(ps);
        tx.commit();
        session.close();
        
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
