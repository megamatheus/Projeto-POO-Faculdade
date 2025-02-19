/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.dao;

import br.com.sistema.jdbc.ConexaoBanco;
import br.com.sistema.model.Clientes;
import br.com.sistema.model.Funcionarios;
import br.com.sistema.view.AreaTrabalho;
import br.com.sistema.view.FormularioLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author charlie
 */
public class FuncionariosDAO {
  private Connection conn;
  
  public FuncionariosDAO(){
  this.conn = new ConexaoBanco().pegarConexao();
  }
  
  
  public void Salvar(Funcionarios obj){
      try {
          //1º criar o SQL
          String sql = "insert into tb_funcionarios (nome, rg, cpf, email,senha,cargo,nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                  + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          //2º preparar conexao SQL para se conectar com o banco
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,obj.getNome());
          stmt.setString(2,obj.getRg());
          stmt.setString(3,obj.getCpf());
          stmt.setString(4,obj.getEmail());
          stmt.setString(5,obj.getSenha());
          stmt.setString(6,obj.getCargo());
          stmt.setString(7,obj.getNivel_acesso());
          stmt.setString(8,obj.getTelefone());
          stmt.setString(9,obj.getCelular());
          stmt.setString(10,obj.getCep());
          stmt.setString(11,obj.getEndereco());
          stmt.setInt(12,obj.getNumero());
          stmt.setString(13,obj.getComplemento());
          stmt.setString(14,obj.getBairro());
          stmt.setString(15,obj.getCidade());
          stmt.setString(16,obj.getEstado());
          //3º executar sql
          stmt.execute();
          //4º fechar conexão
          stmt.close();
          JOptionPane.showMessageDialog(null, "funcionário salvo com sucesso!");
      } catch (SQLException erro) {
          JOptionPane.showMessageDialog(null,"erro ao salvar o funcionário"+ erro);
      }
  }
  public void Editar(Funcionarios obj){
      try {
          //1º criar o SQL
          String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,"
                  + "numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
          //2º preparar conexao SQL para se conectar com o banco
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1,obj.getNome());
          stmt.setString(2,obj.getRg());
          stmt.setString(3,obj.getCpf());
          stmt.setString(4,obj.getEmail());
          stmt.setString(5,obj.getSenha());
          stmt.setString(6,obj.getCargo());
          stmt.setString(7,obj.getNivel_acesso());
          stmt.setString(8,obj.getTelefone());
          stmt.setString(9,obj.getCelular());
          stmt.setString(10,obj.getCep());
          stmt.setString(11,obj.getEndereco());
          stmt.setInt(12,obj.getNumero());
          stmt.setString(13,obj.getComplemento());
          stmt.setString(14,obj.getBairro());
          stmt.setString(15,obj.getCidade());
          stmt.setString(16,obj.getEstado());
          stmt.setInt(17,obj.getId());
          //3º executar sql
          stmt.execute();
          //4º fechar conexão
          stmt.close();
          JOptionPane.showMessageDialog(null, "funcionário editado com sucesso!");
      } catch (SQLException erro) {
          JOptionPane.showMessageDialog(null,"erro ao editar o funcionário"+ erro);
      }
  }
    
    public void Excluir(Funcionarios obj){
        try {
            String sql = "delete from tb_funcionarios where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "funcionário excluído com sucesso");
            
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,"erro ao excluir o funcionário"+ e);
        }
    }
    
  public Funcionarios BuscarFuncionario(String nome){
      try {
          String sql = "select * from tb_funcionarios where nome = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setString(1, nome);
          ResultSet rs = stmt.executeQuery();
          Funcionarios obj = new Funcionarios();
          if(rs.next()){
              obj.setId(rs.getInt("id"));
              obj.setNome(rs.getString("nome"));
              obj.setRg(rs.getString("rg"));
              obj.setCpf(rs.getString("cpf"));
              obj.setEmail(rs.getString("email"));
              obj.setSenha(rs.getString("senha"));
              obj.setCargo(rs.getString("cargo"));
              obj.setNivel_acesso(rs.getString("nivel_acesso"));
              obj.setTelefone(rs.getString("telefone"));
              obj.setCelular(rs.getString("celular"));
              obj.setCep(rs.getString("cep"));
              obj.setEndereco(rs.getString("endereco"));
              obj.setNumero(rs.getInt("numero"));
              obj.setComplemento(rs.getString("complemento"));
              obj.setBairro(rs.getString("bairro"));
              obj.setCidade(rs.getString("cidade"));
              obj.setEstado(rs.getString("estado"));
                       
          }
          return obj;
          
      } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null,"erro ao buscar funcionário"+ erro);
      }
      return null;
  }
public List<Funcionarios>Listar(){
List<Funcionarios> lista = new ArrayList<>();
    try {
        String sql = "select * from tb_funcionarios";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Funcionarios obj = new Funcionarios();
             obj.setId(rs.getInt("id"));
              obj.setNome(rs.getString("nome"));
              obj.setRg(rs.getString("rg"));
              obj.setCpf(rs.getString("cpf"));
              obj.setEmail(rs.getString("email"));
              obj.setSenha(rs.getString("senha"));
              obj.setCargo(rs.getString("cargo"));
              obj.setNivel_acesso(rs.getString("nivel_acesso"));
              obj.setTelefone(rs.getString("telefone"));
              obj.setCelular(rs.getString("celular"));
              obj.setCep(rs.getString("cep"));
              obj.setEndereco(rs.getString("endereco"));
              obj.setNumero(rs.getInt("numero"));
              obj.setComplemento(rs.getString("complemento"));
              obj.setBairro(rs.getString("bairro"));
              obj.setCidade(rs.getString("cidade"));
              obj.setEstado(rs.getString("estado"));
              lista.add(obj);
            
        }
        return lista;
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "erro ao criar a lista: "+e);
    }
    return null;
}

public List<Funcionarios>Filtar(String nome){
List<Funcionarios> lista = new ArrayList<>();
    try {
        String sql = "select * from tb_funcionarios where nome like ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Funcionarios obj = new Funcionarios();
             obj.setId(rs.getInt("id"));
              obj.setNome(rs.getString("nome"));
              obj.setRg(rs.getString("rg"));
              obj.setCpf(rs.getString("cpf"));
              obj.setEmail(rs.getString("email"));
              obj.setSenha(rs.getString("senha"));
              obj.setCargo(rs.getString("cargo"));
              obj.setNivel_acesso(rs.getString("email"));
              obj.setTelefone(rs.getString("telefone"));
              obj.setCelular(rs.getString("celular"));
              obj.setCep(rs.getString("cep"));
              obj.setEndereco(rs.getString("endereco"));
              obj.setNumero(rs.getInt("numero"));
              obj.setComplemento(rs.getString("complemento"));
              obj.setBairro(rs.getString("bairro"));
              obj.setCidade(rs.getString("cidade"));
              obj.setEstado(rs.getString("estado"));
              lista.add(obj);
            
        }
        return lista;
    } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "erro ao criar a lista: "+e);
    }
    return null;
}
public void efetuarLogin(String email, String senha){
    try {
        String sql = "select * from tb_funcionarios where email=? and senha=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           if(rs.getString("nivel_acesso").equals("ADMINISTRADOR")){
            AreaTrabalho at = new AreaTrabalho();
            at.usuarioLogado = rs.getString("nome");
            JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!\n"+at.usuarioLogado);
            at.setVisible(true);
           }
           else  if(rs.getString("nivel_acesso").equals("USUÁRIO")){
            AreaTrabalho at = new AreaTrabalho();
            at.usuarioLogado = rs.getString("nome");
            at.menu_fornecedores.setVisible(false);
            at.menu_funcionario.setEnabled(false);
            at.menu_estoque.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!\n"+at.usuarioLogado);
            at.setVisible(true);
           }
        }else{
            FormularioLogin login = new FormularioLogin();
            JOptionPane.showMessageDialog(null,"dados inválidos!");
            login.setVisible(true);
        }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,"erro:"+e);
    }
}
}
