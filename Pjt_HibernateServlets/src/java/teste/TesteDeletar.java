package teste;

import dao.DAOTbCliente;
import vo.TbCliente;

public class TesteDeletar {
    public static void main(String[] args) throws Exception{
        //Id co cliente a ser deletado
        Integer id = Integer.parseInt("34");
        
        DAOTbCliente dao = new DAOTbCliente();
        TbCliente vo = dao.consultarPorId(id);
        
        //DAOTbCliente dao = new DAOTbCliente();
        if (dao.deletar(vo)) {
            System.out.println("Cliente deletado com sucesso!");
        } else{
            System.out.println("Erro ao tentar deletar cliente!");
        }
    }
}