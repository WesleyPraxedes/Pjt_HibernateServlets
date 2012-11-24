package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vo.TbCliente;

/**
 *
 * @author Wesley
 */
public class DAOTbCliente {
    private Session session;

    public DAOTbCliente() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<TbCliente> listarClientes(){
        Transaction t = session.beginTransaction();
        List<TbCliente> lista = session.createQuery("FROM TbCliente ORDER BY nome").list();
        t.commit();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }

    public boolean adicionar(TbCliente vo) {
        Transaction t = session.beginTransaction();
        session.save(vo);
        t.commit();
        return true;
    }

    public boolean alterar(TbCliente vo) {
        Transaction t = session.beginTransaction();
        session.update(vo);
        t.commit();
        return true;
    }

    public boolean deletar(TbCliente vo) {
        Transaction t = session.beginTransaction();
        session.delete(vo);
        t.commit();
        return true;
    }

    public TbCliente consultarPorId(Integer id) {
        Transaction t =session.beginTransaction();
        List lista = session.createQuery("FROM TbCliente WHERE idCliente=" +id.intValue()).list();

        if (lista.isEmpty()) {
            return null;
        } else {
            return (TbCliente) lista.get(0);
        }
    }
}