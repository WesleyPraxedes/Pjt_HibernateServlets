package teste;

import dao.DAOTbCliente;
import vo.TbCliente;

public class TesteAdicionar {
     public static void main(String[] args){
        // GRAVANDO DADOS NAS VARIAVEIS
        String nome = ("Ricardo Chaves");
        String email = ("Ricardo@gmail.com.br");
        Long telefone = Long.parseLong("6198761234");
        String data = ("01/01/2008");

        // FORMATANDO DATA
        String auxDt = data;
        int ano=Integer.parseInt(auxDt.substring(6,10)) - 1900;
        int mes=Integer.parseInt(auxDt.substring(3,5)) - 1 ;
        int dia=Integer.parseInt(auxDt.substring(0,2));
        java.sql.Date dtSQL = new java.sql.Date(ano, mes, dia);
        
        //MONTANDO OBJETO VO
        TbCliente vo = new TbCliente();
        vo.setNome(nome);
        vo.setEmail(email);
        vo.setTelefone(telefone);
        vo.setDatanascimento(dtSQL);

        //grave nessa conexão!!!
        DAOTbCliente dao = new DAOTbCliente();
        if (dao.adicionar(vo)) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else{
            System.out.println("Erro ao tentar cadastrado cliente!");
        }
         
    }
}