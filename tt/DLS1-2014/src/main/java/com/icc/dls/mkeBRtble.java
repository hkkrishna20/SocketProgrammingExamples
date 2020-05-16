package com.icc.dls;
/*     */ import java.awt.Color;
import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;

/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
import javax.swing.JScrollPane;
/*     */ 
/*     */ public class mkeBRtble extends JFrame implements ActionListener {
/*  15 */   private JPanel btblpnl = new JPanel();
/*  16 */   private JPanel btblpnlp = new JPanel();
/*  17 */   private JFrame btblfrmp = new JFrame();
/*  18 */   private JLabel btbllbl = new JLabel();
/*  19 */   private JLabel btbllblp = new JLabel();
/*  20 */   private JLabel btbllblT = new JLabel();
/*  21 */   private JButton Bprnt = new JButton("print table");
/*  22 */   private GridBagConstraints c2 = new GridBagConstraints();
/*  23 */   private GridBagLayout gbg1 = new GridBagLayout();
/*  24 */   private JButton BprntT = new JButton("save table");
/*  25 */   private GridBagLayout gbg1p = new GridBagLayout();
/*  26 */   private GridBagConstraints c2p = new GridBagConstraints(); private String drnmb1;
/*     */   private String R1t;
/*     */   private StringBuilder strbld3a;
/*     */   
/*     */   public mkeBRtble(String paramString, StringBuilder paramStringBuilder) {
/*  31 */     this.strbld3a = paramStringBuilder;
/*  32 */     this.drnmb1 = paramString;
/*  33 */     this.Bprnt.addActionListener(this);
/*  34 */     this.BprntT.addActionListener(this);
/*  35 */     this.btbllbl.setBackground(Color.white);
/*  36 */     this.btbllblp.setBackground(Color.white);
/*  37 */     this.btblpnl.setLayout(this.gbg1);
/*  38 */     this.btblpnlp.setLayout(this.gbg1p);
/*  39 */     this.c2.anchor = 17;
/*  40 */     this.c2.gridwidth = 1;
/*  41 */     this.c2.gridx = 0;
/*  42 */     this.c2.gridy = 0;
/*  43 */     this.c2.weightx = 0.25D;
/*  44 */     this.gbg1.setConstraints(this.Bprnt, this.c2);
/*  45 */     this.btblpnl.add(this.Bprnt);
/*  46 */     this.c2.anchor = 10;
/*  47 */     this.c2.gridwidth = 1;
/*  48 */     this.c2.gridx = 1;
/*  49 */     this.c2.gridy = 0;
/*  50 */     this.c2.weightx = 0.5D;
/*  51 */     this.gbg1.setConstraints(this.btbllblT, this.c2);
/*  52 */     this.btblpnl.add(this.btbllblT);
/*  53 */     this.c2.anchor = 13;
/*  54 */     this.c2.gridwidth = 1;
/*  55 */     this.c2.gridx = 2;
/*  56 */     this.c2.gridy = 0;
/*  57 */     this.c2.weightx = 0.25D;
/*  58 */     this.gbg1.setConstraints(this.BprntT, this.c2);
/*  59 */     this.btblpnl.add(this.BprntT);
/*  60 */     this.c2.anchor = 10;
/*  61 */     this.c2.gridwidth = 3;
/*  62 */     this.c2.gridx = 0;
/*  63 */     this.c2.gridy = 1;
/*  64 */     this.c2.weightx = 1.0D;
/*  65 */     this.gbg1.setConstraints(this.btbllbl, this.c2);
/*  66 */     this.btblpnl.add(this.btbllbl);
/*  67 */     this.c2p.gridwidth = 1;
/*  68 */     this.c2p.gridx = 0;
/*  69 */     this.c2p.gridy = 0;
/*  70 */     this.gbg1p.setConstraints(this.btbllblp, this.c2p);
/*  71 */     this.btblpnlp.add(this.btbllblp);
/*  72 */     add(new JScrollPane(this.btblpnl, 22, 31));
/*  73 */     this.btblfrmp.add(new JScrollPane(this.btblpnlp, 20, 31));
/*  74 */     this.btblfrmp.pack();
/*     */   }
/*     */   
/*     */   public void drawTable(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, double paramDouble) {
/*  78 */     String str1 = paramStringBuilder1.substring(0, paramStringBuilder1.length());
/*  79 */     String str2 = paramStringBuilder2.substring(0, paramStringBuilder2.length());
/*  80 */     this.btbllbl.setText(str1);
/*  81 */     this.btbllblp.setText(str2);
/*  82 */     this.btblfrmp.pack();
/*  83 */     str1 = null;
/*  84 */     str2 = null;
/*  85 */     int i = (int)Math.floor(100.0D * paramDouble);
/*  86 */     int j = (int)Math.round(10000.0D * paramDouble) - i * 100;
/*  87 */     if (j > 99) {
/*  88 */       j = 0;
/*  89 */       i++;
/*     */     } 
/*  91 */     if (j < 10) {
/*  92 */       this.R1t = "(R1 = " + i + ".0" + j + "%)";
/*  93 */       this.btbllblT.setText("<html><body><font size=\"4\"><b><center> Table of ball-by-ball resource percentages <font size=\"2\">(R1 = " + i + ".0" + j + "%) </font></center></b></font></html>");
/*     */     } else {
/*  95 */       this.R1t = "(R1 = " + i + "." + j + "%)";
/*  96 */       this.btbllblT.setText("<html><body><font size=\"4\"><b><center> Table of ball-by-ball resource percentages <font size=\"2\">(R1 = " + i + "." + j + "%) </font></center></b></font></html>");
/*     */     } 
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent paramActionEvent) {
/* 101 */     if (paramActionEvent.getSource() == this.Bprnt) {
/* 102 */       PParTable.printComponent(this.btbllblp);
/*     */     }
/* 104 */     if (paramActionEvent.getSource() == this.BprntT)
/*     */       
/*     */       try {
/*     */         
/* 108 */         String str1 = new String("");
/* 109 */         String str2 = null;
/* 110 */         boolean bool1 = false;
/* 111 */         boolean bool2 = false;
/* 112 */         int i = 0;
/* 113 */         while (!bool1) {
/* 114 */           JFileChooser jFileChooser = new JFileChooser(this.drnmb1);
/* 115 */           jFileChooser.setFileSelectionMode(0);
/* 116 */           jFileChooser.setSelectedFile(new File("ResPct BB"));
/* 117 */           jFileChooser.setAcceptAllFileFilterUsed(false);
/* 118 */           jFileChooser.addChoosableFileFilter(new TXTFileFilter());
/* 119 */           jFileChooser.addChoosableFileFilter(new HTMLFileFilter());
/* 120 */           int j = jFileChooser.showDialog(null, "Save");
/* 121 */           if (j == 0) {
/* 122 */             File file1 = jFileChooser.getSelectedFile();
/* 123 */             File file2 = file1;
/* 124 */             str2 = jFileChooser.getFileFilter().getDescription();
/* 125 */             if (((!file1.getName().toLowerCase().endsWith(".html") ? 1 : 0) & ((str2.indexOf("html") > -1) ? 1 : 0)) != 0) {
/* 126 */               file2 = new File(file1.getAbsolutePath() + ".html");
/*     */             }
/* 128 */             if (((!file1.getName().toLowerCase().endsWith(".txt") ? 1 : 0) & ((str2.indexOf("txt") > -1) ? 1 : 0)) != 0) {
/* 129 */               file2 = new File(file1.getAbsolutePath() + ".txt");
/*     */             }
/* 131 */             str1 = file2.getAbsolutePath();
/* 132 */             this.drnmb1 = str1;
/* 133 */             if (file2.exists()) {
/* 134 */               i = JOptionPane.showConfirmDialog(null, "Overwrite existing file?", null, 0);
/* 135 */               if (i == 0) {
/* 136 */                 bool1 = true; continue;
/*     */               } 
/* 138 */               bool1 = false;
/* 139 */               bool2 = true;
/*     */               continue;
/*     */             } 
/* 142 */             bool1 = true;
/*     */             continue;
/*     */           } 
/* 145 */           bool1 = true;
/* 146 */           bool2 = true;
/*     */         } 
/*     */         
/* 149 */         if (!bool2) {
/* 150 */           FileOutputStream fileOutputStream = new FileOutputStream(str1);
/* 151 */           PrintStream printStream = new PrintStream(fileOutputStream);
/* 152 */           if (str2.indexOf("html") > -1) {
/* 153 */             printStream.println(this.btbllblp.getText());
/*     */           } else {
/* 155 */             printStream.println("              Ball-by-ball resource percentages " + this.R1t + "             ");
/* 156 */             printStream.println("+-----------+-------------------------------------------------------------+");
/* 157 */             printStream.println("|overs.balls|                         wickets down                        |");
/* 158 */             printStream.println("| remaining |   0     1     2     3     4     5     6     7     8     9   |");
/* 159 */             printStream.println("+-----------+-------------------------------------------------------------+");
/* 160 */             String str = this.strbld3a.substring(0, this.strbld3a.length());
/* 161 */             int j = str.indexOf("</tr>");
/* 162 */             Date date = new Date();
/* 163 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
/* 164 */             int k = 0;
/* 165 */             int m = 2;
/* 166 */             while (j >= 0) {
/* 167 */               printStream.println(str.substring(0, j));
/* 168 */               str = str.substring(j + 5);
/* 169 */               j = str.indexOf("</tr>");
/* 170 */               k++;
/* 171 */               if (k == 51) {
/* 172 */                 k = 0;
/* 173 */                 printStream.println("+-----------+-------------------------------------------------------------+");
/* 174 */                 printStream.println(str.substring(str.indexOf("TableID")));
/* 175 */                 printStream.println("                (c) " + simpleDateFormat.format(date) + " International Cricket Council");
/* 176 */                 if (j >= 0) {
/* 177 */                   printStream.println(" ");
/* 178 */                   if (m < 10) {
/* 179 */                     printStream.println("              Ball-by-ball resource percentages " + this.R1t + "      (Page " + m + ")");
/*     */                   } else {
/* 181 */                     printStream.println("              Ball-by-ball resource percentages " + this.R1t + "     (Page " + m + ")");
/*     */                   } 
/* 183 */                   printStream.println("+-----------+-------------------------------------------------------------+");
/* 184 */                   printStream.println("|overs.balls|                         wickets down                        |");
/* 185 */                   printStream.println("| remaining |   0     1     2     3     4     5     6     7     8     9   |");
/* 186 */                   printStream.println("+-----------+-------------------------------------------------------------+");
/* 187 */                   m++;
/*     */                 } 
/*     */               } 
/*     */             } 
/* 191 */             printStream.println("+-----------+-------------------------------------------------------------+");
/* 192 */             printStream.println(str);
/* 193 */             printStream.println("                (c) " + simpleDateFormat.format(date) + " International Cricket Council                ");
/* 194 */             str = null;
/*     */           } 
/* 196 */           printStream.close();
/*     */         } 
/* 198 */       } catch (Exception exception) {} 
/*     */   }
/*     */ }


/* Location:              C:\Users\HDMI\Downloads\DLS 1-20200104T110120Z-001\DLS 1\DLS1-2014.jar!\mkeBRtble.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */