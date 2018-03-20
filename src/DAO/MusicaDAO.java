package DAO;

import Modelo.CD;
import Modelo.Musica;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaDAO  extends ExecuteSQL{

    public MusicaDAO(Connection con) {
        super(con);
    }
    
      public  String Cadastrar_Musica(Musica a){

String sql = "INSERT INTO musicas VALUES (0,?,?,?,?,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setInt(1,a.getCodigo_cd());
    ps.setString(2,a.getNome());
     ps.setInt(3,a.getDuracao());
      ps.setString(4,a.getCompositor());
       ps.setString(5,a.getDescricao());
        ps.setString(6,a.getLancamento());
         ps.setString(7,a.getGenero());
          ps.setString(8,a.getProcedencia());
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}  


 public List<Musica> ID_CD(){
   String sql = "SELECT MAX(codigo) FROM `cd`";
   List<Musica> lista = new ArrayList<>();
   try{
   PreparedStatement ps = getCon().prepareStatement(sql);
   ResultSet rs = ps.executeQuery();
   
   if(rs != null){
   while(rs.next()){
   Musica a = new Musica();
   a.setCodigo_cd(rs.getInt(1));
   lista.add(a);
   }
   return lista;
   }else{
   
   return null;}
   
   }catch(Exception e){
   return null;}
       
   }
      
      
 
 
public List<Musica>  ListarMusica(){
    
    String sql = "SELECT * FROM musicas";
    List<Musica> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Musica a = new Musica();
            a.setCodigo(rs.getInt(1));
            a.setCodigo_cd(rs.getInt(2));
            a.setNome(rs.getString(3));
            a.setDuracao(rs.getInt(4));
            a.setCompositor(rs.getString(5));
            a.setLancamento(rs.getString(6));
            a.setGenero(rs.getString(7));
            a.setProcedencia(rs.getString(8));
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

      
      
      

