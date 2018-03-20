
package Visao.Consulltar;

import DAO.CDDAO;
import DAO.CarrinhoDAO;
import DAO.Conexao;
import DAO.MusicaDAO;
import DAO.UsuarioDAO;
import Modelo.CD;
import Modelo.Carrinho;
import Modelo.Musica;
import Modelo.Usuario;
import Principal.Login;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ConsultarCD extends javax.swing.JFrame {

    public ConsultarCD() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        Listar_Todos_CD();
        Listar_Todas_Musicas();
        
    }

public void Listar_Todas_Musicas(){
Connection con = Conexao.AbrirConexao();
MusicaDAO bd = new MusicaDAO(con);
List<Musica> lista = new ArrayList<>();
lista = bd.ListarMusica();
DefaultTableModel tbm = (DefaultTableModel) tabela2.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(Musica tab : lista){
tbm.addRow(new String[i]);
tabela2.setValueAt(tab.getNome(), i,0);
tabela2.setValueAt(tab.getDuracao(),i,1);
tabela2.setValueAt(tab.getCompositor(),i,2);
tabela2.setValueAt(tab.getGenero(),i,3);
i++;
}
Conexao.FecharConexao(con);
}

public void Listar_Todos_CD(){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
List<CD> lista = new ArrayList<>();
lista = bd.ListarCD();
DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(CD tab : lista){
Listar_Musicas_Pesquisa(Integer.toString(tab.getCodigo()));
tbm.addRow(new String[i]);
tabela.setValueAt(tab.getCodigo(), i,0);
tabela.setValueAt(tab.getTitulo(), i,1);
tabela.setValueAt(tab.getDisponibilidade(),i,2);
tabela.setValueAt(tab.getPreco(),i,3);
i++;
}
Conexao.FecharConexao(con);
}    
    
public void Pesquisar_Nome_CD(){
 Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String titulo = cd.getText();
List<CD> lista = new ArrayList<>();
lista = bd.Pesquisar_CD(titulo);
DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(CD tab : lista){
Listar_Musicas_Pesquisa(Integer.toString(tab.getCodigo()));
tbm.addRow(new String[i]);
tabela.setValueAt(tab.getCodigo(), i,0);
tabela.setValueAt(tab.getTitulo(), i,1);
tabela.setValueAt(tab.getDisponibilidade(),i,2);
tabela.setValueAt(tab.getPreco(),i,3);
cd.setText("");
i++;
}
Conexao.FecharConexao(con);
}

public void Pesquisar_Artista_CD(){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String nome = jTextField2.getText();
List<CD> lista = new ArrayList<>();
lista = bd.Pesquisar_Artista_CD(nome);
DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(CD tab : lista){
Listar_Musicas_Pesquisa(Integer.toString(tab.getCodigo()));
tbm.addRow(new String[i]);
tabela.setValueAt(tab.getCodigo(), i,0);
tabela.setValueAt(tab.getTitulo(), i,1);
tabela.setValueAt(tab.getDisponibilidade(),i,2);
tabela.setValueAt(tab.getPreco(),i,3);
jTextField2.setText("");
i++;
}
Conexao.FecharConexao(con);
}


public void Pesquisar_Musica_CD(){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String nome = jTextField3.getText();
List<CD> lista = new ArrayList<>();
lista = bd.Pesquisar_Musica_CD(nome);
DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(CD tab : lista){
Listar_Musicas_Pesquisa(Integer.toString(tab.getCodigo()));
tbm.addRow(new String[i]);
tabela.setValueAt(tab.getCodigo(), i,0);
tabela.setValueAt(tab.getTitulo(), i,1);
tabela.setValueAt(tab.getDisponibilidade(),i,2);
tabela.setValueAt(tab.getPreco(),i,3);
jTextField3.setText("");
i++;
}
Conexao.FecharConexao(con);
}
        
public void Listar_Musicas_Pesquisa(String codiggo){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String codigo = codiggo;
List<Musica> lista = new ArrayList<>();
lista = bd.Pesquisar_CD_Musicas(codigo);
DefaultTableModel tbm = (DefaultTableModel) tabela2.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(Musica tab : lista){
tbm.addRow(new String[i]);
tabela2.setValueAt(tab.getNome(), i,0);
tabela2.setValueAt(tab.getDuracao(),i,1);
tabela2.setValueAt(tab.getCompositor(),i,2);
tabela2.setValueAt(tab.getGenero(),i,3);
i++;
}
Conexao.FecharConexao(con);
}

public  void Usuario_Oline() {
int linha2 = tabela.getSelectedRow();
Object codigo2 =  tabela.getValueAt(linha2, 0);
String codigocd = String.valueOf(codigo2);

int CD = Integer.parseInt(codigocd);
int linha = tabela.getSelectedRow();
Object codigo =  tabela.getValueAt(linha, 1);
String titulo = String.valueOf(codigo);

Connection con = Conexao.AbrirConexao();
UsuarioDAO bd = new UsuarioDAO(con);
 
List<Usuario> lista = new ArrayList<>();
lista = bd.ListarOnline();
int i = 0;
for(Usuario tab : lista){
   
 String nome =  tab.getOnline();

if(bd.Testar_CD(CD,nome)== true) {
 JOptionPane.showMessageDialog(null, "O cd ("+titulo+" já foi adicionado ao carrinho !","Alert !",JOptionPane.WARNING_MESSAGE);}else{
    int sair  = JOptionPane.showConfirmDialog(null,"Deseja adicionar o cd ("+titulo+") ao seu carrinho ?","Loda de CD's",JOptionPane.YES_NO_CANCEL_OPTION);
if(sair == 0){ Adicionar_Carrinho(nome);}
  }
 
 i++;
} 
Conexao.FecharConexao(con);

}

public void Adicionar_Carrinho(String usu){

int linha = tabela.getSelectedRow();
Object codigo =  tabela.getValueAt(linha, 0);
String codigodocd = String.valueOf(codigo);
int cod = Integer.parseInt(codigodocd);

Connection con = Conexao.AbrirConexao();
CarrinhoDAO sql = new CarrinhoDAO(con);
 
 Carrinho a  = new Carrinho();
 a.setCodigo_cd(cod);
 a.setNome(usu);
 
 sql.Cadastrar_Carrinho(a);
 Conexao.FecharConexao(con);
 int linhaa = tabela.getSelectedRow();
Object codigoo =  tabela.getValueAt(linha, 1);
String titulo = String.valueOf(codigoo);

JOptionPane.showMessageDialog(null,"O  cd ("+titulo+") foi adicionaado ao seu carrinho !");
}

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cd = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        ps = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("CONSULTAR CD");

        jLabel3.setText("Nome do CD");

        jLabel5.setText("Artista :");

        jLabel6.setText("Musica :");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Titulo", "Disponibilidade", "Preço"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("P");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("P");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("P");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setText("INFORMAÇÕES DO DVD");

        jLabel8.setText("INFORMAÇÕES DAS MUSICAS");

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Duração", "Compositor", "Genero"
            }
        ));
        jScrollPane2.setViewportView(tabela2);

        ps.setEditable(false);

        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("OBS : SELECIONE O CD NA  TABELA PARA ADICIONAR AO CARRINHO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
            .addComponent(jScrollPane1)
            .addComponent(jSeparator1)
            .addComponent(jScrollPane2)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(147, 147, 147)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel9)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ps, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String nome = cd.getText();
        if(nome.equals("")){
    Listar_Todos_CD();
        Listar_Todas_Musicas();
}else{
        Pesquisar_Nome_CD();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
 
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  new Menu().setVisible(true);
  dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String art = jTextField2.getText();
        if(art.equals("")){
    Listar_Todos_CD();
        Listar_Todas_Musicas();
}else{
        Pesquisar_Artista_CD();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
String music = jTextField3.getText();
        if(music.equals("")){
    Listar_Todos_CD();
        Listar_Todas_Musicas();
}else{
        Pesquisar_Musica_CD();}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked

    Usuario_Oline();


        
    }//GEN-LAST:event_tabelaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarCD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField ps;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela2;
    // End of variables declaration//GEN-END:variables
}
