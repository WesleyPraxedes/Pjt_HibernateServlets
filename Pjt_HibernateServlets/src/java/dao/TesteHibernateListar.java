/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import vo.TbCliente;

/**
 *
 * @author Wesley
 */
public class TesteHibernateListar {
    public static void main (String[] args){        
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();        
        s.beginTransaction();        
        List<TbCliente> lista = (List<TbCliente>)s.createQuery("FROM TbCliente").list();  
        
        for(TbCliente cli :lista){
            System.out.println("Nome: "+cli.getNome());
        }        
        s.getTransaction().commit();        
        
    }    
}
