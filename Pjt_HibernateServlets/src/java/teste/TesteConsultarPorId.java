package teste;

import dao.DAOTbCliente;
import vo.TbCliente;

public class TesteConsultarPorId {
    public static void main(String[] args) throws Exception{
        DAOTbCliente dao = new DAOTbCliente();
        TbCliente cliente = dao.consultarPorId(1);

        System.out.println("Cod: " + cliente.getIdCliente());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: 0" + cliente.getTelefone());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("DN: " + cliente.getDatanascimento());
    }
}