package Visao.Cadastrar;
import Principal.Menu;
import DAO.CDDAO;
import DAO.Conexao;
import Modelo.CD;
import java.util.List;
import DAO.MusicaDAO;
import Modelo.Musica;
import Visao.Excluir.ExcluirCD;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CadastrarPromocao extends javax.swing.JFrame {
PromocaoCD codigocd;
    public CadastrarPromocao() {
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
tabela.setValueAt(tab.getTitulo(), i,0);
tabela.setValueAt(tab.getDisponibilidade(),i,1);
tabela.setValueAt(tab.getPreco(),i,2);
i++;
}
Conexao.FecharConexao(con);
}    
    
public void Pesquisar_Nome_CD(){
 Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String titulo = cd.getText();
if(titulo.equals("")){
Listar_Todas_Musicas();
Listar_Todos_CD();
}
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
tabela.setValueAt(tab.getTitulo(), i,0);
tabela.setValueAt(tab.getDisponibilidade(),i,1);
tabela.setValueAt(tab.getPreco(),i,2);
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
tabela.setValueAt(tab.getTitulo(), i,0);
tabela.setValueAt(tab.getDisponibilidade(),i,1);
tabela.setValueAt(tab.getPreco(),i,2);
jTextField2.setText("");
i++;
}
Conexao.FecharConexao(con);
}


public void Pesquisar_Musica_CD(){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String nome = jTextField3.getText();
if(nome.equals("")){
Listar_Todas_Musicas();
Listar_Todos_CD();
}
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
tabela.setValueAt(tab.getTitulo(), i,0);
tabela.setValueAt(tab.getDisponibilidade(),i,1);
tabela.setValueAt(tab.getPreco(),i,2);
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
}    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cd = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Musica :");

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
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Duração", "Compositor", "Genero"
            }
        ));
        jScrollPane2.setViewportView(tabela2);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Disponibilidade", "Preço"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("ATIVAR PROMOÇÃO");

        jButton3.setText("P");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome do CD");

        jLabel5.setText("Artista :");

        jLabel7.setText("INFORMAÇÕES DO DVD");

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("OBS : SELECIONE O CD NA TABELA PARA ATIVAR  A PROMOÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane2)))
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(232, 232, 232)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton4)))
                        .addGap(0, 331, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(281, 281, 281)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addComponent(jButton2)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jButton3)
                    .addGap(36, 36, 36)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(78, 78, 78)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addGap(40, 40, 40)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addContainerGap(372, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new Menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      String veri = cd.getText();
        if(veri.equals("")){
         Listar_Todos_CD();
        Listar_Todas_Musicas();
        }else{
        Pesquisar_Nome_CD();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String veri = jTextField2.getText();
        if(veri.equals("")){
         Listar_Todos_CD();
        Listar_Todas_Musicas();
        }else{
        Pesquisar_Artista_CD();}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String veri = jTextField3.getText();
        if(veri.equals("")){
         Listar_Todos_CD();
        Listar_Todas_Musicas();
        }else{
        Pesquisar_Musica_CD();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
int linha = tabela.getSelectedRow();
Object codigo =  tabela.getValueAt(linha, 0);
String codigodocd = String.valueOf(codigo);
 if(codigocd == null){
codigocd = new PromocaoCD();
codigocd.setVisible(true);
codigocd.receber(codigodocd);
dispose();
}else{
codigocd.setVisible(true);
codigocd.setState(PromocaoCD.NORMAL);
codigocd.receber(codigodocd);
dispose();
}

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
            java.util.logging.Logger.getLogger(CadastrarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarPromocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela2;
    // End of variables declaration//GEN-END:variables
}
