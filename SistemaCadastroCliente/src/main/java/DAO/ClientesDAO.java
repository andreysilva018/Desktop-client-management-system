/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import JDBC.ConnectionFactory;
import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
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
    
    public void excluirCliente(Clientes cliente){
        try {
            String sql = "delete from tb_cliente where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, cliente.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro para excluir cliente - Erro" + erro);
        }
    }
    
    public void alterarCliente(Clientes cliente){}
    
    public List<Clientes> listarClientes(){
        try {
            List<Clientes> lista = new ArrayList<>();
            
            String sql = "select * from tb_cliente";
            
            PreparedStatement stmt = conn.prepareCall(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes cliente = new Clientes();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                
                lista.add(cliente);
            }            
            
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro na lista de clientes - Erro: " + erro);
            return null;
        }
        
    }
}
