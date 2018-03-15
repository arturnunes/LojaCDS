
package DAO;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends ExecuteSQL{

    public UsuarioDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar(String login, String senha){
        boolean finalResult = false;
        
        String consulta = "SELECT login,senha "
                + "FROM usuario WHERE "
                + "login = '"+login+"' AND "
                + "senha = '"+senha+"'";
        
        try {
            PreparedStatement ps = 
            getCon().prepareStatement(consulta);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Usuario a = new Usuario();
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                    finalResult = true;
                }
            }
            
        } catch (SQLException ex) {
           ex.getMessage();
        }
    return finalResult;
    }


    
    
    
  public  String Cadastrar_Usuario(Usuario a){

String sql = "INSERT INTO usuario VALUES (0,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    ps.setString(2,a.getEmail());
    ps.setInt(3,a.getCpf());
    ps.setInt(4,a.getTelefone());
    ps.setString(5,a.getLogin());
    ps.setString(6,a.getSenha());
    ps.setString(7,a.getSenha2());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}  
        
   public String Alterar_Usuario( Usuario a){
    String sql = "UPDATE usuario SET nome = ? , email = ? , cpf = ? , telefone = ?  , login = ? , senha= ?  , senha2 = ?  WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setString(1,a.getNome());
    ps.setString(2,a.getEmail());
    ps.setInt(3,a.getCpf());
    ps.setInt(4,a.getTelefone());
    ps.setString(5,a.getLogin());
    ps.setString(6,a.getSenha());
    ps.setString(7,a.getSenha2());
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }
   
  
}
