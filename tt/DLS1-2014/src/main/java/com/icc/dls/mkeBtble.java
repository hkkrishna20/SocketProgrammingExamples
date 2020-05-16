package com.icc.dls;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
 public class mkeBtble extends JFrame implements ActionListener {
   private JPanel btblpnl = new JPanel();
   private JPanel btblpnlp = new JPanel();
   private JFrame btblfrmp = new JFrame();
   private JLabel btbllbl = new JLabel();
   private JLabel btbllblp = new JLabel();
   private JLabel btbllblT = new JLabel("<html><body><font size=\"4\"><b><center>Table of ball-by-ball Par Scores</center></b></font></html>");
   private JButton Bprnt = new JButton("print table");
   private GridBagConstraints c2 = new GridBagConstraints();
   private GridBagLayout gbg1 = new GridBagLayout();
   private JButton BprntT = new JButton("save table");
   private GridBagLayout gbg1p = new GridBagLayout();
   private GridBagConstraints c2p = new GridBagConstraints();
   private String drnmb1;
   private StringBuilder strbld3a;
   private ImageIcon icnw;
   
   public mkeBtble(String paramString, StringBuilder paramStringBuilder) {
     this.strbld3a = paramStringBuilder;
     this.drnmb1 = paramString;
     this.Bprnt.addActionListener(this);
     this.BprntT.addActionListener(this);
     this.btblpnl.setLayout(this.gbg1);
     this.btblpnlp.setLayout(this.gbg1p);
     this.btblpnl.setBackground(Color.white);
     this.c2.anchor = 17;
     this.c2.gridwidth = 1;
     this.c2.gridx = 0;
     this.c2.gridy = 0;
     this.c2.weightx = 0.25D;
     this.gbg1.setConstraints(this.Bprnt, this.c2);
     this.Bprnt.setForeground(Color.black);
     this.Bprnt.setBackground(new Color(255, 255, 240));
     this.btblpnl.add(this.Bprnt);
     this.c2.anchor = 10;
     this.c2.gridwidth = 1;
     this.c2.gridx = 1;
     this.c2.gridy = 0;
     this.c2.weightx = 0.5D;
     this.gbg1.setConstraints(this.btbllblT, this.c2);
     this.btbllblT.setForeground(Color.black);
     this.btbllblT.setBackground(Color.white);
     this.btbllblT.setOpaque(true);
     this.btblpnl.add(this.btbllblT);
     this.c2.anchor = 13;
     this.c2.gridwidth = 1;
     this.c2.gridx = 2;
     this.c2.gridy = 0;
     this.c2.weightx = 0.25D;
     this.gbg1.setConstraints(this.BprntT, this.c2);
     this.BprntT.setForeground(Color.black);
     this.BprntT.setBackground(new Color(255, 255, 240));
     this.btblpnl.add(this.BprntT);
     this.c2.anchor = 10;
     this.c2.gridwidth = 3;
     this.c2.gridx = 0;
     this.c2.gridy = 1;
     this.c2.weightx = 1.0D;
     this.gbg1.setConstraints(this.btbllbl, this.c2);
     this.btblpnl.add(this.btbllbl);
     this.c2p.gridwidth = 1;
     this.c2p.gridx = 0;
     this.c2p.gridy = 0;
     this.gbg1p.setConstraints(this.btbllblp, this.c2p);
     this.btblpnlp.add(this.btbllblp);
     add(new JScrollPane(this.btblpnl, 22, 31));
     this.btblfrmp.add(new JScrollPane(this.btblpnlp, 20, 31));
     this.btblfrmp.pack();
   }
   
   public void drawTable(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, ImageIcon paramImageIcon) {
     String str1 = paramStringBuilder1.substring(0, paramStringBuilder1.length());
     String str2 = paramStringBuilder2.substring(0, paramStringBuilder2.length());
     this.btbllbl.setText(str1);
     this.btbllblp.setText(str2);
     this.btbllbl.setForeground(Color.black);
     this.btbllbl.setBackground(Color.white);
     this.btbllblp.setForeground(Color.black);
     this.btbllblp.setBackground(Color.white);
     this.btbllbl.setOpaque(true);
     this.btblfrmp.pack();
     str1 = null;
     str2 = null;
     this.icnw = paramImageIcon;
   }
   
   public void actionPerformed(ActionEvent paramActionEvent) {
     if (paramActionEvent.getSource() == this.Bprnt) {
       PParTable.printComponent(this.btbllblp);
     }
     if (paramActionEvent.getSource() == this.BprntT)
       
       try {
         
         String str1 = new String("");
         String str2 = null;
         boolean bool1 = false;
         boolean bool2 = false;
         int i = 0;
         while (!bool1) {
           JFileChooser jFileChooser = new JFileChooser(this.drnmb1);
           jFileChooser.setFileSelectionMode(0);
           jFileChooser.setSelectedFile(new File("ParScores BB"));
           jFileChooser.setAcceptAllFileFilterUsed(false);
           jFileChooser.addChoosableFileFilter(new TXTFileFilter());
           jFileChooser.addChoosableFileFilter(new HTMLFileFilter());
           int j = jFileChooser.showDialog(null, "Save");
           if (j == 0) {
             File file1 = jFileChooser.getSelectedFile();
             File file2 = file1;
             str2 = jFileChooser.getFileFilter().getDescription();
             if (((!file1.getName().toLowerCase().endsWith(".html") ? 1 : 0) & ((str2.indexOf("html") > -1) ? 1 : 0)) != 0) {
               file2 = new File(file1.getAbsolutePath() + ".html");
             }
             if (((!file1.getName().toLowerCase().endsWith(".txt") ? 1 : 0) & ((str2.indexOf("txt") > -1) ? 1 : 0)) != 0) {
               file2 = new File(file1.getAbsolutePath() + ".txt");
             }
             str1 = file2.getAbsolutePath();
             this.drnmb1 = str1;
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
           FileOutputStream fileOutputStream = new FileOutputStream(str1);
           PrintStream printStream = new PrintStream(fileOutputStream);
           if (str2.indexOf("html") > -1) {
             printStream.println(this.btbllblp.getText());
           } else {
             printStream.println("                   Table of ball-by-ball Par Scores                   ");
             printStream.println("+-------+---------+--------------------------------------------------+");
             printStream.println("| overs |  overs  |                     wickets down                 |");
             printStream.println("|bowled |remaining|  0    1    2    3    4    5    6    7    8    9  |");
             printStream.println("+-------+---------+--------------------------------------------------+");
             String str = this.strbld3a.substring(0, this.strbld3a.length());
             int j = str.indexOf("</tr>");
             Date date = new Date();
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
             int k = 0;
             int m = 2;
             while (j >= 0) {
               printStream.println(str.substring(0, j));
               str = str.substring(j + 5);
               j = str.indexOf("</tr>");
               k++;
               if (k == 51) {
                 k = 0;
                 printStream.println("+-------+---------+--------------------------------------------------+");
                 printStream.println(str.substring(str.indexOf("TableID")));
                 printStream.println("                (c) " + simpleDateFormat.format(date) + " International Cricket Council                ");
                 if (j >= 0) {
                   printStream.println(" ");
                   if (m < 10) {
                     printStream.println("                   Table of ball-by-ball Par Scores           (Page " + m + ")");
                   } else {
                     printStream.println("                   Table of ball-by-ball Par Scores          (Page " + m + ")");
                   } 
                   printStream.println("+-------+---------+--------------------------------------------------+");
                   printStream.println("| overs |  overs  |                     wickets down                 |");
                   printStream.println("|bowled |remaining|  0    1    2    3    4    5    6    7    8    9  |");
                   printStream.println("+-------+---------+--------------------------------------------------+");
                   m++;
                 } 
               } 
             } 
             printStream.println("+-------+---------+--------------------------------------------------+");
             printStream.println(str);
             printStream.println("                (c) " + simpleDateFormat.format(date) + " International Cricket Council                ");
             str = null;
           } 
           printStream.close();
         } 
       } catch (Exception exception) {} 
   }
 }


