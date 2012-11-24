package teste;

import dao.DAOTbCliente;
import vo.TbCliente;

public class TesteAlterar {
    public static void main(String[] args) throws Exception{
        //Dados a ser alterado
        String nome = ("Rodrigo Mesquita");
        String email = ("Rodrigo@gmail.com");
        long telefone = Long.parseLong("6199991234");
        String data = ("01/01/2012");
        
        String auxDt = data;
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
        
        TbCliente vo = new TbCliente();
        vo.setNome(nome);
        vo.setEmail(email);
        vo.setTelefone(telefone);
        vo.setDatanascimento(dtSQL);
        
        //Id do cliente a ser alterado
        vo.setIdCliente(16);

        DAOTbCliente dao = new DAOTbCliente();
        if (dao.alterar(vo)) {
            System.out.println("Dados atualizado com sucesso!");
        } else{
            System.out.println("Erro ao tentar atualizar cliente!");
        }
    }
}