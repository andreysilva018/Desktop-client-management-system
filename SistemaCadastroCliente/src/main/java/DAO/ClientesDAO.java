/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author SOUZA
 */
public class ClientesDAO {
    private Connection conn;
    
    public ClientesDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCliente(Clientes cliente){
        try {
            String sql = "INSERT INTO tb_cliente(nome, cpf, rg, email, celular, cep, endereco, numero, bairro, complemento, cidade, estado)"
                    + "values(?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getRg());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCelular());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getEndereco());
            stmt.setInt(8, cliente.getNumero());
            stmt.setString(9, cliente.getBairro());
            stmt.setString(10, cliente.getComplemento());
            stmt.setString(11, cliente.getCidade());
            stmt.setString(12, cliente.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro do cliente - Erro:" + erro);
        }
    }
    
    public void alterarCliente(){}
    
    public void excluirCliente(){}
    
    public void listarCliente(){}
}
