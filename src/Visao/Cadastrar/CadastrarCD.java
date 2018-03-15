package Visao.Cadastrar;

import DAO.CDDAO;
import DAO.Conexao;
import DAO.MusicaDAO;
import DAO.UsuarioDAO;
import Modelo.CD;
import Modelo.Musica;
import Modelo.Usuario;
import Principal.Login;
import Principal.Menu;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class CadastrarCD extends javax.swing.JFrame{

    CadastrarMusica  enviarcodigo;
    public CadastrarCD() {
        initComponents();
        codigo();
        setResizable(false);
        setLocationRelativeTo(this);
        
    }

public void Cancelar(String codigo){
int codig = Integer.parseInt(codigo);

Connection con = Conexao.AbrirConexao();
CDDAO sql = new CDDAO(con);
Musica a = new Musica();
 a.setCodigo_cd(codig);

sql.Cancelar_Cadastro(a);
Conexao.FecharConexao(con);
new Menu().setVisible(true);
dispose();
    }

    
public void codigo(){
Connection con = Conexao.AbrirConexao();
MusicaDAO sql  = new MusicaDAO(con);
List<Musica> lista = new ArrayList<>();
lista = sql.ID_CD();
for(Musica a : lista){
int cod = a.getCodigo_cd()+1;
String codigo = Integer.toString(cod);
    Numero_Faixa(codigo);

Conexao.FecharConexao(con);
}
}

public void Numero_Faixa(String codigo){
try { Thread.sleep (1000); 

 Connection con = Conexao.AbrirConexao();
CDDAO bd = new CDDAO(con);
String cod = codigo;
List<Musica> lista = new ArrayList<>();
lista = bd.ATT_Faixa(cod);

int i = 0;
for(Musica tab : lista){
tffaixa.setText(tab.getFaixa());
i++;
}
Conexao.FecharConexao(con);

} catch (InterruptedException ex) {}
} 

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tftitulo = new javax.swing.JTextField();
        tfdisponibilidade = new javax.swing.JTextField();
        tfpreco = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        tfcapa = new javax.swing.JTextField();
        tffaixa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLcapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Cadastrar CD");

        jLabel2.setText("Titulo");

        jLabel3.setText("Disponibilidade");

        jLabel4.setText("Preço");

        jLabel6.setText("Capa:");

        tfdisponibilidade.setEditable(false);
        tfdisponibilidade.setText("DISPONIVEL");

        jButton1.setText("selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cadastrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Adicionar Musicas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero de Faixas");

        jLcapa.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createEtchedBorder()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tftitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(38, 38, 38)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(tfcapa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jLcapa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(tffaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5))))
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tftitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfdisponibilidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tffaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfcapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLcapa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
String titulo = tftitulo.getText();
String disponibilidade = "DISPONIVEL";
String preco = tfpreco.getText();
String capa = tfcapa.getText();
String faixa = tffaixa.getText();
if(faixa.equals("0")){
JOptionPane.showMessageDialog(null, "Adicione pelo menos uma Musica" , "Loja de CD´s" , JOptionPane.WARNING_MESSAGE);}else{              
if( titulo.equals("") || capa.equals("") || preco.equals("")){
JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio" , "Loja de CD´s" , JOptionPane.WARNING_MESSAGE);

}else{
 Connection con = Conexao.AbrirConexao();
 CDDAO sql = new CDDAO(con);
 
 CD a  = new CD();
 int Preco = Integer.parseInt(preco);
 
 a.setTitulo(titulo);
 a.setDisponibilidade(disponibilidade);
 a.setPreco(Preco);
 a.setCapa(capa);
 sql.Cadastrar_CD(a);
 Conexao.FecharConexao(con);
 
 JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso","Loja de CD´s",JOptionPane.INFORMATION_MESSAGE);
  new Menu().setVisible(true);
 dispose();
}}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Connection con = Conexao.AbrirConexao();
MusicaDAO sql  = new MusicaDAO(con);
List<Musica> lista = new ArrayList<>();
lista = sql.ID_CD();
for(Musica a : lista){
int cod = a.getCodigo_cd()+1;
String codigo = Integer.toString(cod);
            
Numero_Faixa(codigo);
            
if(enviarcodigo == null){
enviarcodigo = new CadastrarMusica();
enviarcodigo .setVisible(true);
enviarcodigo .receber(codigo);

}else{
enviarcodigo .setVisible(true);
enviarcodigo .setState(CadastrarMusica.NORMAL);
enviarcodigo .receber(codigo);
 
}

}
Conexao.FecharConexao(con);

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

Connection con = Conexao.AbrirConexao();
MusicaDAO sql  = new MusicaDAO(con);
List<Musica> lista = new ArrayList<>();
lista = sql.ID_CD();
for(Musica a : lista){
   int cod = a.getCodigo_cd()+1;
String codigo = Integer.toString(cod);

Cancelar(codigo);    
}
Conexao.FecharConexao(con);

        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
// faill
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
//fail
    }//GEN-LAST:event_formMouseMoved

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
codigo();
    }//GEN-LAST:event_formMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

               //SISTEMA PARA FILTRA APENAS FOTO COM AS IXTENÇÕES JPJ E JPEG
        FileNameExtensionFilter filtro =  new FileNameExtensionFilter("Formatos de Arquivo JPEG(*.JPG;*.JPEG)","jpg","jpeg");
       
        JFileChooser arquivo = new JFileChooser();
        
        arquivo.addChoosableFileFilter(filtro);
        arquivo.setDialogTitle("Abrir arquivo");
        File rota = new File("C://Users/");
        arquivo.setCurrentDirectory(null);
        
        int option = arquivo.showOpenDialog(null);
      
        
        if (option == JFileChooser.APPROVE_OPTION) {
           File file = arquivo.getSelectedFile();
           tfcapa.setText(String.valueOf(file));
           Image  foto = getToolkit().getImage(tfcapa.getText());
           foto = foto.getScaledInstance(199, 199,Image.SCALE_DEFAULT);
           jLcapa.setIcon(new ImageIcon(foto));
           

        
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel carregar capa.");
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarCD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarCD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLcapa;
    private javax.swing.JTextField tfcapa;
    private javax.swing.JTextField tfdisponibilidade;
    private javax.swing.JTextField tffaixa;
    private javax.swing.JTextField tfpreco;
    private javax.swing.JTextField tftitulo;
    // End of variables declaration//GEN-END:variables
}
