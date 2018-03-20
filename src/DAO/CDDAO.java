
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


public class CDDAO extends  ExecuteSQL{
     
    public CDDAO(Connection con) {
        super(con);
    }
     
      public  String Cadastrar_CD(CD a){

String sql = "INSERT INTO cd  VALUES (0,?,?,?,?)";
try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getTitulo());
    ps.setString(2,a.getDisponibilidade());
    ps.setInt(3,a.getPreco());
    ps.setString(4,a.getCapa());
    
    if(ps.executeUpdate() > 0){
        return "Inserido com sucesso";
    }else{
        return "Erro ao Insessir";
                    }
    }catch(SQLException e){
        return e.getMessage();
    }
}  

      
      
   public String Cancelar_Cadastro(Musica a){
   String sql = "DELETE FROM musicas WHERE  codigocd = ?";
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
      
   
   
   
   public List<Musica> ATT_Faixa ( String cod){
   String sql = "SELECT COUNT(*) FROM `musicas` WHERE codigocd = '"+cod+"'";
   List<Musica> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            Musica a = new Musica();
           a.setFaixa(rs.getString(1));
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
    
    
   
public List<CD> Pesquisar_CD( String titulo){
   String sql = "SELECT * FROM `cd` WHERE titulo LIKE  '%"+titulo+"%'";
   List<CD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
           CD a = new CD();
            a.setCodigo(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            a.setDisponibilidade(rs.getString(3));
            a.setPreco(rs.getInt(4));
            a.setCapa(rs.getString(5));
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
   
   

public List<Musica> Pesquisar_CD_Musicas( String codigo){
   String sql = "SELECT * FROM musicas WHERE  codigocd LIKE'%"+codigo+"%'";
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
              a.setDescricao(rs.getString(6));
              a.setLancamento(rs.getString(7));
              a.setGenero(rs.getString(8));
              a.setProcedencia(rs.getString(9));
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
   
public List<CD> Pesquisar_Artista_CD( String nome){
   String sql = "SELECT * FROM `musicas` JOIN `cd` WHERE compositor LIKE '%"+nome+"%' AND cd.codigo = musicas.codigocd";
   List<CD> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    if(rs != null){
        while(rs.next()){
           CD a = new CD();
            a.setCodigo(rs.getInt(10));
            a.setTitulo(rs.getString(11));
            a.setDisponibilidade(rs.getString(12));
             a.setPreco(rs.getInt(13));
             
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
public List<CD> Pesquisar_Musica_CD( String nome){
   String sql = "SELECT * FROM `musicas` JOIN `cd` WHERE nome LIKE '%"+nome+"%' AND cd.codigo = musicas.codigocd";
   List<CD> lista = new ArrayList<>();
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    if(rs != null){
        while(rs.next()){
           CD a = new CD();
            a.setCodigo(rs.getInt(10));
            a.setTitulo(rs.getString(11));
            a.setDisponibilidade(rs.getString(12));
             a.setPreco(rs.getInt(13));
             
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
   


public List<CD>  ListarCD(){
    
    String sql = "SELECT * FROM cd";
    List<CD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            CD a = new CD();
            a.setCodigo(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            a.setDisponibilidade(rs.getString(3));
            a.setPreco(rs.getInt(4));
            a.setCapa(rs.getString(5));
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


public List<CD>  ListarCDPromocao(){
    
    String sql = "SELECT * FROM cd WHERE disponibilidade =  'PROMOÇÃO' ";
    List<CD> lista = new ArrayList<>();
    
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ResultSet rs =  ps.executeQuery();
    
    if(rs != null){
        while(rs.next()){
            CD a = new CD();
            a.setCodigo(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            a.setDisponibilidade(rs.getString(3));
            a.setPreco(rs.getInt(4));
            a.setCapa(rs.getString(5));
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


 public String Excluir_CD(CD a){
   String sql = "DELETE FROM cd WHERE codigo = ?";
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
 
 
   public String Alterar_Situacao( CD a){
    String sql = "UPDATE cd SET disponibilidade = ? , preco = ?  WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
  
    ps.setString(1,a.getDisponibilidade());
    ps.setInt(2,a.getPreco());
    ps.setInt(3,a.getCodigo());
    
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }


  public String Alterar_CD( CD a){
    String sql = "UPDATE cd SET titulo = ? , disponibilidade = ? , preco = ? , capa = ?  WHERE codigo = ? ";
    try{
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1,a.getTitulo());
    ps.setString(2,a.getDisponibilidade());
    ps.setInt(3,a.getPreco());
    ps.setString(4,a.getCapa());
     ps.setInt(5,a.getCodigo());
         if(ps.executeUpdate() > 0){
        return "Atualizado com sucesso";}else{ return "Erro ao Atualizar";}
    }catch(SQLException e){
    return e.getMessage();
    }
    
    }

   
 
   
}
