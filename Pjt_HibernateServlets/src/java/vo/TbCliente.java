package vo;
// Generated 16/10/2012 10:23:20 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * TbCliente generated by hbm2java
 */
public class TbCliente  implements java.io.Serializable {


     private Integer idCliente;
     private String nome;
     private String email;
     private Long telefone;
     private Double cpf;
     private String sexo;
     private BigDecimal salario;
     private Date datanascimento;
     private Date datacadastro;

    public TbCliente() {
    }

	
    public TbCliente(String nome) {
        this.nome = nome;
    }
    public TbCliente(String nome, String email, Long telefone, Double cpf, String sexo, BigDecimal salario, Date datanascimento, Date datacadastro) {
       this.nome = nome;
       this.email = email;
       this.telefone = telefone;
       this.cpf = cpf;
       this.sexo = sexo;
       this.salario = salario;
       this.datanascimento = datanascimento;
       this.datacadastro = datacadastro;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    public Double getCpf() {
        return this.cpf;
    }
    
    public void setCpf(Double cpf) {
        this.cpf = cpf;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public BigDecimal getSalario() {
        return this.salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    public Date getDatanascimento() {
        return this.datanascimento;
    }
    
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    public Date getDatacadastro() {
        return this.datacadastro;
    }
    
    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }




}


