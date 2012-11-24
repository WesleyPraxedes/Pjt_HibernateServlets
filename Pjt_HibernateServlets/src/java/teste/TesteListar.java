package teste;


import dao.DAOTbCliente;
import java.util.List;
import vo.TbCliente;

public class TesteListar {
    public static void main(String[] args) throws Exception {
        DAOTbCliente dao = new DAOTbCliente();
        List<TbCliente> clientes = dao.listarClientes();
        for(TbCliente cliente : clientes){
            System.out.println("Cod: " + cliente.getIdCliente());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());            
            System.out.println("DN: "+ cliente.getDatanascimento());
            System.out.println("");
        }
        System.out.println("Fim!");
    }
}