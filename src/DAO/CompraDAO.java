package DAO;

import Modelo.CD;
import Modelo.Compra;
import Modelo.Musica;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompraDAO extends ExecuteSQL{
    
    public CompraDAO(Connection con) {
        super(con);
    }
    
    
    
    
  public  String Cadastrar_Compra(Compra a){

String sql = "INSERT INTO compra VALUES (0,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getTitulo_cd());
    ps.setString(2,a.getNome());
    ps.setString(3,a.getFpagamento());
    ps.setString(4,a.getTpagamento());
    ps.setString(5,a.getEndereco());
   
   
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}  
     
public List<CD>  ListarTop(){
    
    String sql = " SELECT *, COUNT( * ) n FROM compra JOIN `cd`WHERE compra.titulo_cd = cd.titulo GROUP BY titulo_cd ORDER BY n DESC";
    List<CD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            CD a = new CD();
             a.setCodigo(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            a.setDisponibilidade(rs.getString(9));
            a.setPreco(rs.getInt(10));
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
      
   public String Excluir_Compra(Compra a){
   String sql = "DELETE FROM compra WHERE  titulo_cd  = ?";
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   
   ps.setString(1,a.getTitulo_cd());
   
   if(ps.executeUpdate() > 0){
   return "Excluido com Sucesso";
   
   }else{
   
   return "Erro ao Excluir";}
   
   }catch( SQLException e){
   return e.getMessage();
   } 
    
}
   
}