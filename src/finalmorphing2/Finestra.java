package finalmorphing2;

import java.awt.Dimension;


public class Finestra extends javax.swing.JFrame {

    Editor editorSorgente;
    Editor editorDestinazione;
    
    public Finestra() 
    {
        initComponents();
        
        Dimension d = this.getContentPane().getSize();
        int w = d.width;
        int h = d.height;
        Griglia g=new Griglia(this.getSize());
        editorSorgente = new Editor(0);
        this.getContentPane().add(editorSorgente);
        editorSorgente.setBounds(0,28,w/2,-30);
        editorSorgente.init(g);
        editorSorgente.setPreferredSize(d);
        
        editorDestinazione = new Editor(1);
        this.getContentPane().add(editorDestinazione);
        editorDestinazione.setBounds(w/2,28,w/2,h-30);
        editorDestinazione.init(g);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        action = new javax.swing.JToggleButton();
        remove = new javax.swing.JToggleButton();
        Process = new javax.swing.JButton();
        Percelab = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jToolBar1.setRollover(true);

        action.setText("Edit");
        action.setFocusable(false);
        action.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        action.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionActionPerformed(evt);
            }
        });
        jToolBar1.add(action);

        remove.setText("Delete");
        remove.setFocusable(false);
        remove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        remove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jToolBar1.add(remove);

        Process.setText("Elaborate");
        Process.setFocusable(false);
        Process.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Process.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessActionPerformed(evt);
            }
        });
        jToolBar1.add(Process);

        Percelab.setText("0");
        Percelab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PercelabActionPerformed(evt);
            }
        });
        jToolBar1.add(Percelab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionActionPerformed
        if (action.isSelected())
        {
            if(remove.isSelected())
                remove.doClick();
            editorSorgente.modalitaMovimentoAttiva=false; 
            editorDestinazione.modalitaMovimentoAttiva=false;
            editorSorgente.modalitaInserimentoAttiva=true; 
            editorDestinazione.modalitaInserimentoAttiva=true;
            editorSorgente.modalitaRimozioneAttiva=false; 
            editorDestinazione.modalitaRimozioneAttiva=false; 
            
        }
        else
        {
            editorSorgente.modalitaMovimentoAttiva=true; 
            editorDestinazione.modalitaMovimentoAttiva=true;
            editorSorgente.modalitaInserimentoAttiva=false; 
            editorDestinazione.modalitaInserimentoAttiva=false;
            editorSorgente.modalitaRimozioneAttiva=false; 
            editorDestinazione.modalitaRimozioneAttiva=false; 
        }
    }//GEN-LAST:event_actionActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        if (remove.isSelected())
        {
            if(action.isSelected())
                action.doClick();
            editorSorgente.modalitaMovimentoAttiva=false; 
            editorDestinazione.modalitaMovimentoAttiva=false;
            editorSorgente.modalitaInserimentoAttiva=false; 
            editorDestinazione.modalitaInserimentoAttiva=false;
            editorSorgente.modalitaRimozioneAttiva=true; 
            editorDestinazione.modalitaRimozioneAttiva=true; 
        }
        else
        {
            editorSorgente.modalitaMovimentoAttiva=true; 
            editorDestinazione.modalitaMovimentoAttiva=true;
            editorSorgente.modalitaInserimentoAttiva=false; 
            editorDestinazione.modalitaInserimentoAttiva=false;
            editorSorgente.modalitaRimozioneAttiva=false; 
            editorDestinazione.modalitaRimozioneAttiva=false;  
        }
        
    }//GEN-LAST:event_removeActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Dimension d = this.getContentPane().getSize();
        int w = d.width;
        int h = d.height;
        if(editorSorgente==null)
            return;
        editorSorgente.setBounds(0,28,w/2,h-30);
        editorDestinazione.setBounds(w/2,28,w/2,h-30);
    }//GEN-LAST:event_formComponentResized

    private void ProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessActionPerformed
        editorDestinazione.mot.elaborate(new Double(Percelab.getText()));
	Immagine fi=new Immagine(editorDestinazione.mot.result.larghezza, editorDestinazione.mot.result.altezza);
	DisplayFinal f=new DisplayFinal(fi);
	f.setVisible(true);
    }//GEN-LAST:event_ProcessActionPerformed

    private void PercelabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PercelabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PercelabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Percelab;
    private javax.swing.JButton Process;
    private javax.swing.JToggleButton action;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToggleButton remove;
    // End of variables declaration//GEN-END:variables
}
