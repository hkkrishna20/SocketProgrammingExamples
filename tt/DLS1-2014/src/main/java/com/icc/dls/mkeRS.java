package com.icc.dls;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 public class mkeRS extends JFrame implements ActionListener {
   private JPanel RSpnl = new JPanel();
   private JPanel RSpnlp = new JPanel();
   private JFrame RSfrmp = new JFrame();
   private JLabel RSlbl = new JLabel();
   private JLabel RSlblp = new JLabel();
   private JLabel RSlblpp = new JLabel();
   private JLabel RSlblT = new JLabel("<html><body><font size=\"4\"><b><center>&nbsp; DLS Match Report &nbsp;</center></b></font></html>");
   private JButton RSprnt = new JButton("print");
   private TextField RSname = new TextField(30);
   private TextField RSemail = new TextField(30);
   private TextField RSphone = new TextField(30);
   private TextArea RScomm = new TextArea(null, 4, 30, 0);
   private GridBagConstraints c1 = new GridBagConstraints();
   private GridBagLayout gbg = new GridBagLayout();
   private JButton RSprntT = new JButton("save");
   private JButton RSmail = new JButton("Email report");
   private GridBagLayout gbgp = new GridBagLayout();
   private GridBagConstraints c1p = new GridBagConstraints(); private String drnm1;
   private String prgnm;
   private StringBuilder RStmp = new StringBuilder("");
   private boolean dsktopsup;
   private Desktop desktop;
   private ImageIcon icnw;
   
   public mkeRS(String paramString) {
     this.dsktopsup = false;
     if (Desktop.isDesktopSupported()) {
       this.desktop = Desktop.getDesktop();
       if (this.desktop.isSupported(Desktop.Action.MAIL)) {
         this.dsktopsup = true;
       }
     } 
     this.drnm1 = paramString;
     this.RSprnt.addActionListener(this);
     this.RSprntT.addActionListener(this);
     this.RSmail.addActionListener(this);
     this.RSlbl.setBackground(Color.white);
     this.RSlblp.setBackground(Color.white);
     this.RSpnl.setLayout(this.gbg);
     this.RSpnl.setBackground(Color.white);
     this.RSpnlp.setLayout(this.gbgp);
     this.RSpnlp.setBackground(Color.white);
     this.c1.anchor = 17;
     this.c1.gridwidth = 1;
     this.c1.gridx = 0;
     this.c1.gridy = 0;
     this.c1.weightx = 0.25D;
     this.gbg.setConstraints(this.RSprnt, this.c1);
     this.RSprnt.setForeground(Color.black);
     this.RSprnt.setBackground(new Color(255, 255, 240));
     this.RSpnl.add(this.RSprnt);
     this.c1.anchor = 10;
     this.c1.gridwidth = 1;
     this.c1.gridx = 1;
     this.c1.gridy = 0;
     this.c1.weightx = 0.5D;
     this.gbg.setConstraints(this.RSlblT, this.c1);
     this.RSlblT.setForeground(Color.black);
     this.RSlblT.setBackground(Color.white);
     this.RSlblT.setOpaque(true);
     this.RSpnl.add(this.RSlblT);
     this.c1.anchor = 13;
     this.c1.gridwidth = 1;
     this.c1.gridx = 2;
     this.c1.gridy = 0;
     this.c1.weightx = 0.25D;
     this.gbg.setConstraints(this.RSprntT, this.c1);
     this.RSprntT.setForeground(Color.black);
     this.RSprntT.setBackground(new Color(255, 255, 240));
     this.RSpnl.add(this.RSprntT);
     this.c1.anchor = 17;
     this.c1.gridwidth = 3;
     this.c1.gridx = 0;
     this.c1.gridy = 1;
     this.c1.weightx = 1.0D;
     this.gbg.setConstraints(this.RSlbl, this.c1);
     this.RSpnl.add(this.RSlbl);
     
     JLabel jLabel1 = new JLabel("<html><br><br>Scorer's details", 2);
     this.c1.gridwidth = 3;
     this.c1.gridx = 0;
     this.c1.gridy = 2;
     this.c1.weightx = 1.0D;
     this.gbg.setConstraints(jLabel1, this.c1);
     this.RSpnl.add(jLabel1);
     
     this.c1.anchor = 13;
     JLabel jLabel2 = new JLabel("Name: ", 4);
     this.c1.gridwidth = 1;
     this.c1.gridx = 0;
     this.c1.gridy = 3;
     this.c1.weightx = 0.1D;
     this.gbg.setConstraints(jLabel2, this.c1);
     this.RSpnl.add(jLabel2);
     
     this.c1.fill = 2;
     this.c1.gridwidth = 2;
     this.c1.gridx = 1;
     this.c1.gridy = 3;
     this.c1.weightx = 0.9D;
     this.gbg.setConstraints(this.RSname, this.c1);
     this.RSpnl.add(this.RSname);
     
     this.c1.fill = 0;
     JLabel jLabel3 = new JLabel("Email: ", 4);
     this.c1.gridwidth = 1;
     this.c1.gridx = 0;
     this.c1.gridy = 4;
     this.c1.weightx = 0.1D;
     this.gbg.setConstraints(jLabel3, this.c1);
     this.RSpnl.add(jLabel3);
     
     this.c1.fill = 2;
     this.c1.gridwidth = 2;
     this.c1.gridx = 1;
     this.c1.gridy = 4;
     this.c1.weightx = 0.9D;
     this.gbg.setConstraints(this.RSemail, this.c1);
     this.RSpnl.add(this.RSemail);
     
     this.c1.fill = 0;
     JLabel jLabel4 = new JLabel("Phone: ", 4);
     this.c1.gridwidth = 1;
     this.c1.gridx = 0;
     this.c1.gridy = 5;
     this.c1.weightx = 0.1D;
     this.gbg.setConstraints(jLabel4, this.c1);
     this.RSpnl.add(jLabel4);
     
     this.c1.fill = 2;
     this.c1.gridwidth = 2;
     this.c1.gridx = 1;
     this.c1.gridy = 5;
     this.c1.weightx = 0.9D;
     this.gbg.setConstraints(this.RSphone, this.c1);
     this.RSpnl.add(this.RSphone);
     
     this.c1.anchor = 17;
     this.c1.fill = 0;
     JLabel jLabel5 = new JLabel("<html><br>Additional comments (if any):", 2);
     this.c1.gridwidth = 3;
     this.c1.gridx = 0;
     this.c1.gridy = 6;
     this.c1.weightx = 1.0D;
     this.gbg.setConstraints(jLabel5, this.c1);
     this.RSpnl.add(jLabel5);
 
     
     this.c1.fill = 1;
     this.c1.gridwidth = 3;
     this.c1.gridx = 0;
     this.c1.gridy = 7;
     this.c1.weightx = 1.0D;
     this.gbg.setConstraints(this.RScomm, this.c1);
     this.RSpnl.add(this.RScomm);
     
     this.c1.fill = 0;
     this.c1.anchor = 10;
     this.c1.gridwidth = 3;
     this.c1.gridx = 0;
     this.c1.gridy = 8;
     this.c1.weightx = 1.0D;
     this.c1.weighty = 1.1D;
     this.gbg.setConstraints(this.RSmail, this.c1);
     this.RSmail.setForeground(Color.black);
     this.RSmail.setBackground(new Color(255, 255, 240));
     this.RSpnl.add(this.RSmail);
     this.RSmail.setEnabled(this.dsktopsup);
     if (!this.dsktopsup) {
       this.RSmail.setText("Email option unavailable");
     }
     
     this.c1p.gridwidth = 1;
     this.c1p.gridx = 0;
     this.c1p.gridy = 0;
     this.gbgp.setConstraints(this.RSlblpp, this.c1p);
     this.RSpnlp.add(this.RSlblpp);
     add(new JScrollPane(this.RSpnl, 22, 30));
     this.RSfrmp.add(new JScrollPane(this.RSpnlp, 20, 31));
     this.RSfrmp.pack();
   }
   
   public void drawTable(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, ImageIcon paramImageIcon) {
     String str1 = paramStringBuilder1.substring(0, paramStringBuilder1.length());
     String str2 = paramStringBuilder2.substring(0, paramStringBuilder2.length());
     this.RSlbl.setText(str1);
     this.RSlblp.setText(str2);
     this.RSlbl.setForeground(Color.black);
     this.RSlbl.setBackground(Color.white);
     this.RSlblp.setForeground(Color.black);
     this.RSlblp.setBackground(Color.white);
     this.RSlbl.setOpaque(true);
     str1 = null;
     str2 = null;
     this.icnw = paramImageIcon;
   }
   
   public void nameFocus() {
     this.RSname.requestFocusInWindow();
   }
   
   public void pname(String paramString) {
     this.prgnm = paramString;
   }
   
   public void clearComm() {
     this.RScomm.setText(null);
   }
 
   
   public void actionPerformed(ActionEvent paramActionEvent) {
     if (paramActionEvent.getSource() == this.RSmail) {
       StringBuffer stringBuffer = new StringBuffer("");
       String str = this.RSlblp.getText().substring(71);
       int i = str.indexOf("<br>");
       while (i >= 0) {
         stringBuffer.append(str.substring(0, i) + "\r\n");
         str = str.substring(i + 4);
         i = str.indexOf("<br>");
       } 
       stringBuffer.append("\r\n");
       stringBuffer.append("\r\n");
       stringBuffer.append("Scorer's details\r\n");
       stringBuffer.append("Name: " + this.RSname.getText().trim() + "\r\n");
       stringBuffer.append("Email: " + this.RSemail.getText().trim() + "\r\n");
       stringBuffer.append("Phone: " + this.RSphone.getText().trim() + "\r\n");
       if (this.RScomm.getText().trim().length() > 0) {
         stringBuffer.append("\r\n");
         stringBuffer.append("Additional comments:\r\n");
         BufferedReader bufferedReader = new BufferedReader(new StringReader(this.RScomm.getText()));
         try {
           String str1;
           while ((str1 = bufferedReader.readLine()) != null) {
             stringBuffer.append(str1 + "\r\n");
           }
         } catch (IOException iOException) {}
       } 
       
       try {
         URI uRI = new URI("mailto", "Steven.Stern@anu.edu.au?Subject=DLS Calculator report&Body=" + this.prgnm + " Match Report:\r\n" + stringBuffer.toString(), null);
         this.desktop.mail(uRI);
       } catch (IOException iOException) {
         JOptionPane.showMessageDialog(null, "Default Email Client Unavailable.\nPlease Save Report and Send Manually.", "Warning", -1);
       } catch (SecurityException securityException) {
         JOptionPane.showMessageDialog(null, "Access to Default Email Client Denied.\nPlease Save Report and Send Manually.", "Warning", -1);
       } catch (URISyntaxException uRISyntaxException) {}
     } 
     
     if (paramActionEvent.getSource() == this.RSprnt) {
       this.RStmp.delete(0, this.RStmp.length());
       this.RStmp.append(this.RSlblp.getText());
       this.RStmp.append("<br><br><b>Scorer's details</b><br>Name: " + this.RSname.getText().trim() + "<br>Email: " + this.RSemail.getText().trim() + "<br>Phone: " + this.RSphone.getText().trim() + "<br>");
       if (this.RScomm.getText().trim().length() == 0) {
         this.RStmp.append("</html>");
       } else {
         this.RStmp.append("<br><b>Additional comments:</b><br>");
         BufferedReader bufferedReader = new BufferedReader(new StringReader(this.RScomm.getText()));
         try {
           String str;
           while ((str = bufferedReader.readLine()) != null) {
             this.RStmp.append(str + "<br>");
           }
         } catch (IOException iOException) {}
         
         this.RStmp.append("</html>");
       } 
       this.RSlblpp.setText(this.RStmp.toString());
       this.RSfrmp.pack();
       PParTable.printComponent(this.RSlblpp);
     } 
     if (paramActionEvent.getSource() == this.RSprntT)
       
       try {
         
         String str = new String("");
         boolean bool1 = false;
         boolean bool2 = false;
         int i = 0;
         while (!bool1) {
           JFileChooser jFileChooser = new JFileChooser(this.drnm1);
           jFileChooser.setFileSelectionMode(0);
           jFileChooser.setSelectedFile(new File("DLreport"));
           jFileChooser.setAcceptAllFileFilterUsed(false);
           jFileChooser.setFileFilter(new TXTFileFilter());
           int j = jFileChooser.showDialog(null, "Save");
           if (j == 0) {
             File file1 = jFileChooser.getSelectedFile();
             File file2 = file1;
             if (!file1.getName().toLowerCase().endsWith(".txt")) {
               file2 = new File(file1.getAbsolutePath() + ".txt");
             }
             str = file2.getAbsolutePath();
             this.drnm1 = str;
             if (file2.exists()) {
               i = JOptionPane.showConfirmDialog(null, "Overwrite existing file?", null, 0, 2, this.icnw);
               if (i == 0) {
                 bool1 = true; continue;
               } 
               bool1 = false;
               bool2 = true;
               continue;
             } 
             bool1 = true;
             continue;
           } 
           bool1 = true;
           bool2 = true;
         } 
         
         if (!bool2) {
           FileOutputStream fileOutputStream = new FileOutputStream(str);
           PrintStream printStream = new PrintStream(fileOutputStream);
           printStream.println(this.prgnm + " Match Report:");
           String str1 = this.RSlblp.getText().substring(71);
           int j = str1.indexOf("<br>");
           while (j >= 0) {
             printStream.println(str1.substring(0, j));
             str1 = str1.substring(j + 4);
             j = str1.indexOf("<br>");
           } 
           printStream.println("");
           printStream.println("");
           printStream.println("Scorer's details");
           printStream.println("Name: " + this.RSname.getText().trim());
           printStream.println("Email: " + this.RSemail.getText().trim());
           printStream.println("Phone: " + this.RSphone.getText().trim());
           if (this.RScomm.getText().trim().length() > 0) {
             printStream.println("");
             printStream.println("Additional comments:");
             BufferedReader bufferedReader = new BufferedReader(new StringReader(this.RScomm.getText()));
             try {
               String str2;
               while ((str2 = bufferedReader.readLine()) != null) {
                 printStream.println(str2);
               }
             } catch (IOException iOException) {}
           } 
           
           printStream.close();
         } 
       } catch (Exception exception) {} 
   }
 }


