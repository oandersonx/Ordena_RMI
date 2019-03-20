
package server;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClientMain extends javax.swing.JFrame {

    ArrayList<Integer> listaNumeros = new ArrayList<>();
    String ip = "192.168.43.231", name = "SD";
    
    
    public ClientMain() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroAInserir = new javax.swing.JTextField();
        botaoAdicionar = new javax.swing.JButton();
        botaoEnviar = new javax.swing.JButton();
        lbOraganiza = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        botaoAdicionar.setText("Add");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoEnviar.setText("Send");
        botaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEnviarActionPerformed(evt);
            }
        });

        lbOraganiza.setFont(new java.awt.Font("Poetsen One", 0, 15)); // NOI18N
        lbOraganiza.setText("Organiza Números");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(txtNumeroAInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbOraganiza)
                        .addGap(131, 131, 131))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbOraganiza, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroAInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        
        
        if(txtNumeroAInserir.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Número adicionado!");
        } else{
        
            if(txtNumeroAInserir.getText().toString().equals("")){
                JOptionPane.showMessageDialog(null, "Insira um número!");
            } else{
                listaNumeros.add(Integer.parseInt(txtNumeroAInserir.getText().toString()));
                txtNumeroAInserir.setText("");
            }
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEnviarActionPerformed
     
        if(listaNumeros.size() == 0){
            JOptionPane.showMessageDialog(null, "Nenhum número adicionado!");
        } else{
                    
                ArrayList<Integer> numerosOrdenados = new ArrayList<>();
		try {
			Cliente<InterfaceOrdena> client = new Cliente<InterfaceOrdena>(ip, name);
			numerosOrdenados = client.getRemoteObj().ordenarNumeros(listaNumeros);
			
			System.out.println("Array Ordenado ");
			for(int i=0; i<numerosOrdenados.size(); i++) {
				System.out.print(numerosOrdenados.get(i) + "   ");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
                
                listaNumeros.clear();
        }
        
    }//GEN-LAST:event_botaoEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEnviar;
    private javax.swing.JLabel lbOraganiza;
    private javax.swing.JTextField txtNumeroAInserir;
    // End of variables declaration//GEN-END:variables
}
