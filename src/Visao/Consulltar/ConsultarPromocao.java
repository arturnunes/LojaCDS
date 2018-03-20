
package Visao.Consulltar;

import DAO.CDDAO;
import DAO.CarrinhoDAO;
import DAO.Conexao;
import DAO.UsuarioDAO;
import Modelo.CD;
import Modelo.Carrinho;
import Modelo.Usuario;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarPromocao extends javax.swing.JFrame {


    public ConsultarPromocao() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        Listar_Todos_CD();
    }

public void Listar_Todos_CD(){
Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
List<CD> lista = new ArrayList<>();
lista = bd.ListarCDPromocao();
DefaultTableModel tbm = (DefaultTableModel) tabela.getModel();
while(tbm.getRowCount() > 0){
tbm.removeRow(0);
}
int i = 0;
for(CD tab : lista){
tbm.addRow(new String[i]);
tabela.setValueAt(tab.getCodigo(), i,0);
tabela.setValueAt(tab.getTitulo(), i,1);
tabela.setValueAt(tab.getDisponibilidade(),i,2);
tabela.setValueAt(tab.getPreco(),i,3);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("LISTA DE PROMOÇÕES");

        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("OBS : SELECIONE O CD NA  TABELA PARA ADICIONAR AO CARRINHO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel9)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ConsultarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarPromocao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarPromocao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
