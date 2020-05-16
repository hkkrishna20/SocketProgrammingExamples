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

 import javax.swing.JButton;
 import javax.swing.JFileChooser;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
import javax.swing.JOptionPane;
 import javax.swing.JPanel;
import javax.swing.JScrollPane;


 public class mkeORtble extends JFrame implements ActionListener {
	 private JPanel otblpnl = new JPanel();
	 private JPanel otblpnlp = new JPanel();
	 private JFrame otblfrmp = new JFrame();
	 private JLabel otbllbl = new JLabel();
	 private JLabel otbllblp = new JLabel();
	 private JLabel otbllblT = new JLabel();
	 private JButton Oprnt = new JButton("print table");
	 private GridBagConstraints c1 = new GridBagConstraints();
	 private GridBagLayout gbg = new GridBagLayout();
	 private JButton OprntT = new JButton("save table");
	 private GridBagLayout gbgp = new GridBagLayout();
	 private GridBagConstraints c1p = new GridBagConstraints();
	private String drnm1;
	 private String R1t;
	 private StringBuilder strbld3a;

	
	 public mkeORtble(String paramString, StringBuilder paramStringBuilder) {
		 this.strbld3a = paramStringBuilder;
		 this.drnm1 = paramString;
		 this.Oprnt.addActionListener(this);
		 this.OprntT.addActionListener(this);
		 this.otbllbl.setBackground(Color.white);
		 this.otbllblp.setBackground(Color.white);
		 this.otblpnl.setLayout(this.gbg);
		 this.otblpnlp.setLayout(this.gbgp);
		 this.c1.anchor = 17;
		 this.c1.gridwidth = 1;
		 this.c1.gridx = 0;
		 this.c1.gridy = 0;
		 this.c1.weightx = 0.25D;
		 this.gbg.setConstraints(this.Oprnt, this.c1);
		 this.otblpnl.add(this.Oprnt);
		 this.c1.anchor = 10;
		 this.c1.gridwidth = 1;
		 this.c1.gridx = 1;
		 this.c1.gridy = 0;
		 this.c1.weightx = 0.5D;
		 this.gbg.setConstraints(this.otbllblT, this.c1);
		 this.otblpnl.add(this.otbllblT);
		 this.c1.anchor = 13;
		 this.c1.gridwidth = 1;
		 this.c1.gridx = 2;
		 this.c1.gridy = 0;
		 this.c1.weightx = 0.25D;
		 this.gbg.setConstraints(this.OprntT, this.c1);
		 this.otblpnl.add(this.OprntT);
		 this.c1.anchor = 10;
		 this.c1.gridwidth = 3;
		 this.c1.gridx = 0;
		 this.c1.gridy = 1;
		 this.c1.weightx = 1.0D;
		 this.gbg.setConstraints(this.otbllbl, this.c1);
		 this.otblpnl.add(this.otbllbl);
		 this.c1p.gridwidth = 1;
		 this.c1p.gridx = 0;
		 this.c1p.gridy = 0;
		 this.gbgp.setConstraints(this.otbllblp, this.c1p);
		 this.otblpnlp.add(this.otbllblp);
		 add(new JScrollPane(this.otblpnl, 22, 31));
		 this.otblfrmp.add(new JScrollPane(this.otblpnlp, 20, 31));
		 this.otblfrmp.pack();
		 }

	
	 public void drawTable(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2,
			double paramDouble) {
		 String str1 = paramStringBuilder1.substring(0, paramStringBuilder1.length());
		 String str2 = paramStringBuilder2.substring(0, paramStringBuilder2.length());
		 this.otbllbl.setText(str1);
		 this.otbllblp.setText(str2);
		 this.otblfrmp.pack();
		 str1 = null;
		 str2 = null;
		 int i = (int) Math.floor(100.0D * paramDouble);
		 int j = (int) Math.round(10000.0D * paramDouble) - i * 100;
		 if (j > 99) {
			 j = 0;
			 i++;
			 }
		 if (j < 10) {
			 this.R1t = "(R1 = " + i + ".0" + j + "%)";
			 this.otbllblT.setText(
					"<html><body><font size=\"4\"><b><center> Table of over-by-over resource percentages <font size=\"2\">(R1 = "
							+ i + ".0" + j + "%) </font></center></b></font></html>");
			 } else {
			 this.R1t = "(R1 = " + i + "." + j + "%)";
			 this.otbllblT.setText(
					"<html><body><font size=\"4\"><b><center> Table of over-by-over resource percentages <font size=\"2\">(R1 = "
							+ i + "." + j + "%) </font></center></b></font></html>");
			 }
		 }

	
	 public void actionPerformed(ActionEvent paramActionEvent) {
		 if (paramActionEvent.getSource() == this.Oprnt) {
			 PParTable.printComponent(this.otbllblp);
			 }
		 if (paramActionEvent.getSource() == this.OprntT)
			
			 try {
				
				 String str1 = new String("");
				 String str2 = null;
				 boolean bool1 = false;
				 boolean bool2 = false;
				 int i = 0;
				 while (!bool1) {
					 JFileChooser jFileChooser = new JFileChooser(this.drnm1);
					 jFileChooser.setFileSelectionMode(0);
					 jFileChooser.setSelectedFile(new File("ResPct OO"));
					 jFileChooser.setAcceptAllFileFilterUsed(false);
					 jFileChooser.addChoosableFileFilter(new TXTFileFilter());
					 jFileChooser.addChoosableFileFilter(new HTMLFileFilter());
					 int j = jFileChooser.showDialog(null, "Save");
					 if (j == 0) {
						 File file1 = jFileChooser.getSelectedFile();
						 File file2 = file1;
						 str2 = jFileChooser.getFileFilter().getDescription();
						 if (((!file1.getName().toLowerCase().endsWith(".html") ? 1 : 0)
								& ((str2.indexOf("html") > -1) ? 1 : 0)) != 0) {
							 file2 = new File(file1.getAbsolutePath() + ".html");
							 }
						 if (((!file1.getName().toLowerCase().endsWith(".txt") ? 1 : 0)
								& ((str2.indexOf("txt") > -1) ? 1 : 0)) != 0) {
							 file2 = new File(file1.getAbsolutePath() + ".txt");
							 }
						 str1 = file2.getAbsolutePath();
						 this.drnm1 = str1;
						 if (file2.exists()) {
							 i = JOptionPane.showConfirmDialog(null, "Overwrite existing file?", null, 0);
							 if (i == 0) {
								 bool1 = true;
								continue;
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
						 printStream.println(this.otbllblp.getText());
						 } else {
						 printStream.println(
								"              Over-by-over resource percentages " + this.R1t + "             ");
						 printStream
								.println("+-----------+-------------------------------------------------------------+");
						 printStream
								.println("|   overs   |                         wickets down                        |");
						 printStream
								.println("| remaining |   0     1     2     3     4     5     6     7     8     9   |");
						 printStream
								.println("+-----------+-------------------------------------------------------------+");
						 String str = this.strbld3a.substring(0, this.strbld3a.length());
						 int j = str.indexOf("</tr>");
						 while (j >= 0) {
							 printStream.println(str.substring(0, j));
							 str = str.substring(j + 5);
							 j = str.indexOf("</tr>");
							 }
						 printStream
								.println("+-----------+-------------------------------------------------------------+");
						 Date date = new Date();
						 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
						 printStream.println(str);
						 printStream.println("                (c) " + simpleDateFormat.format(date)
								+ " International Cricket Council");
						 str = null;
						 }
					 printStream.close();
					 }
				 } catch (Exception exception) {
			}
		 }
	 }

