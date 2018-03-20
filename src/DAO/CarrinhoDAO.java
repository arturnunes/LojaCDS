package DAO;

import Modelo.CD;
import Modelo.Carrinho;
import Modelo.Musica;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDAO extends ExecuteSQL{
    
    public CarrinhoDAO(Connection con) {
        super(con);
    }
    

  public  String Cadastrar_Carrinho(Carrinho a){

String sql = "INSERT INTO carrinho VALUES (?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getNome());
    ps.setInt(2,a.getCodigo_cd());
    
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}  
        
//  
//   public List<Carrinho> Quantidade ( String nome){
//   String sql = "SELECT COUNT(*) FROM `carrinho` WHERE nome= '"+nome+"'";
//   List<Carrinho> lista = new ArrayList<>();
//    
//    try{
//    PreparedStatement ps = getCon().prepareStatement(sql);
//    ResultSet rs =  ps.executeQuery();
//    
//    if(rs != null){
//        while(rs.next()){
//            Carrinho a = new Carrinho();
//           a.setQuantidade(rs.getInt(1));
//                lista.add(a);
//            }
//        return lista;
//    }else{
//        return null;
//        }
//    
//    }catch( SQLException e){
//        return null;
//    }
    
  
public List<CD>  ListarCarrinho(String nome){
    
    String sql = "SELECT * FROM `carrinho` JOIN `cd` WHERE nome =  '"+nome+"'AND carrinho.id_cd = cd.codigo";
    List<CD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            CD a = new CD();
            a.setTitulo(rs.getString(4));
            a.setCodigo(rs.getInt(3));
           a.setDisponibilidade(rs.getString(5));
           a.setPreco(rs.getInt(6));
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

  
   public String Excluir_Carrinho(Carrinho a){
   String sql = "DELETE FROM carrinho WHERE  id_cd = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   
   ps.setInt(1,a.getCodigo_cd());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }

   }
    
   
   
   public String Excluir_Nome(Carrinho a){
   String sql = "DELETE FROM carrinho WHERE  nome = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   
   ps.setString(1,a.getNome());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   }

   }
}    
    

