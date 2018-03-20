
package DAO;

import Modelo.CD;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends ExecuteSQL{

    public UsuarioDAO(Connection con) {
        super(con);
    }
    
    
   public boolean Testar_CD(int CD , String nome){
    boolean teste = false;
    try {
        String sql = "SELECT * FROM carrinho  WHERE id_cd = '"+CD+"' AND nome = '"+nome+"' " ;
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if( rs!= null){
        while(rs.next()){
        teste = true;
        }
        }
        
        } catch (SQLException e) {
        }
        return teste;
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

public String Online(Usuario a){
String sql = "INSERT INTO online VALUES (?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getOnline());
   
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }

}
public String Excluir_Online(){
   String sql = "DELETE FROM online";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
  
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   }else{
   return "Erro ao Excluir";}
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }

public List<Usuario>  ListarOnline(){
    
    String sql = "SELECT * FROM online";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setOnline(rs.getString(1));
           
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
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
     ps.setInt(8,a.getCodigo());
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }
   
   
   public String Excluir_Usuario(Usuario a){
   String sql = "DELETE FROM usuario WHERE codigo =  ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ps.setInt(1, a.getCodigo());
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   }else{
   return "Erro ao Excluir";}
   }catch( SQLException e){
   return e.getMessage();
   }
   
   }
   

public List<Usuario>  ListarUsuario(){
    
    String sql = "SELECT * FROM usuario";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setCpf(rs.getInt(4));
            a.setTelefone(rs.getInt(5));
            a.setLogin(rs.getString(6));
            a.setSenha(rs.getString(7));
            a.setSenha2(rs.getString(8));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}

public List<Usuario>  Pesquisa_Nome_Usuario(String nome){
    
    String sql = "SELECT * FROM usuario WHERE nome LIKE '%"+nome+"%'";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setCpf(rs.getInt(4));
            a.setTelefone(rs.getInt(5));
            a.setLogin(rs.getString(6));
            a.setSenha(rs.getString(7));
            a.setSenha2(rs.getString(8));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}


public List<Usuario>  Pesquisa_Login_Usuario(String nome){
    
    String sql = "SELECT * FROM usuario WHERE login LIKE '%"+nome+"%'";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setCpf(rs.getInt(4));
            a.setTelefone(rs.getInt(5));
            a.setLogin(rs.getString(6));
            a.setSenha(rs.getString(7));
            a.setSenha2(rs.getString(8));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}


public List<Usuario>  Pesquisa_Cpf_Usuario(String cpf){
    
    String sql = "SELECT * FROM usuario WHERE cpf LIKE '%"+cpf+"%'";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setCpf(rs.getInt(4));
            a.setTelefone(rs.getInt(5));
            a.setLogin(rs.getString(6));
            a.setSenha(rs.getString(7));
            a.setSenha2(rs.getString(8));
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}
  

public List<Usuario>  Online(){
    
    String sql = "SELECT * FROM usuario";
    List<Usuario> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Usuario a = new Usuario();
            a.setCodigo(rs.getInt(1));
            a.setNome(rs.getString(2));
            a.setEmail(rs.getString(3));
            a.setCpf(rs.getInt(4));
            a.setTelefone(rs.getInt(5));
            a.setLogin(rs.getString(6));
            a.setSenha(rs.getString(7));
            a.setSenha2(rs.getString(8));
            a.getOnline();
            lista.add(a);
            }
        return lista;
    }else{
        return null;
        }
    
    }catch( SQLException e){
        return null;
    }
    
}



}
