package com.icc.dls;

import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

public class dlcalc extends JFrame implements ActionListener, TextListener, FocusListener, KeyListener,
		MouseMotionListener, MouseListener, WindowListener {
    
	protected mkeOtble otblfrm;  // Table of over-by-over Par Scores
	protected mkeBtble btblfrm;  // Table of ball-by-ball Par Scores
	protected mkeORtble oresfrm; //Table of over-by-over resource percentages
	protected mkeBRtble bresfrm;  //Table of ball-by-ball resource percentages
	protected mkeRS RSfrm;        //DLS Match Report
	protected String dirnme;
	protected String dirnmeb;
	protected String dirnmeRS;
	protected String dirnmeT2;
	protected Object[] options11 = new Object[] { "50 overs/innings; min. 10 overs/side",
			"45 overs/innings; min. 20 overs/side", "40 overs/innings; min. 10 overs/side",
			"Custom (user-chosen overs/innings and min. overs/side values)" };

	protected String[] maxotyp = new String[] { "50", "45", "40" };
	protected int[] minotyp = new int[] { 10, 20, 10 };
	protected int optnum = this.minotyp.length + 1;
	
	
	
	
	protected TextField team1OversInnigsAtStartOfMatch;

	
	//protected TextField b3;
	protected TextField team1FinalScore;
	protected TextField g3;
	protected TextField i39;
	protected TextField[] tbs = new TextField[30];
	protected TextField[] tcs = new TextField[30];
	protected TextField[] tc1s = new TextField[30];
	protected TextField[] tds = new TextField[30];
	protected TextField[] tgs = new TextField[30];
	protected TextField[] ths = new TextField[30];
	protected TextField[] th1s = new TextField[30];
	protected TextField[] tis = new TextField[30];
	
	protected boolean allowprj = true;
	protected boolean allowfullprj = false;
	protected boolean resfeature = false;
	protected boolean bAT = false;
	protected boolean bSplt = false;
	protected String wmark = "DLS1c";
	protected String PRGMname = "DLS 1.0";
	protected String PRGMno = "(dls1.0)";
	protected String qmname = "qm.png";
	protected String errname = "err.png";
	protected String wrnname = "wrn.gif";
	protected String logofilename = "icclogo.png";
	protected String logofilename1 = "icclogo1.png";
	protected double[] g50pr = new double[] { 248.8D, 248.8D };
	protected double[] lprior = new double[] { 1.0D, 1.0D };
	protected double lmbcap = 9.9999D;

	protected ImageIcon icon;
	protected Object mprbx;
	public static final Color ltgreen = new Color(127, 254, 127);
	public static final Color aqua1 = new Color(191, 255, 255);
	public static final Color dkgreen = new Color(0, 127, 0);
	public static final Color dkpink = new Color(255, 50, 150);
	public static final Color ornge = new Color(185, 0, 0);
	public static final Color orng1 = new Color(254, 180, 50);
	public static final Color blu1 = new Color(50, 50, 240);
	public static final Color prple = new Color(80, 0, 80);
	public static final Color bcol = new Color(192, 192, 192);
	protected Color hiblue = new Color(0, 0, 0);
	protected Component lstfcs;
	protected Component mpress;
	protected Point center;
	protected JPanel jpmain;
	protected JPanel T2trgp;
	protected JPanel T2trgpp;
	protected JFrame sbresfrm;
	protected JFrame sbtblfrm;
	protected JFrame soresfrm;
	protected JFrame sotblfrm;
	protected JFrame splashf;
	protected JFrame T2trgf;
	protected JFrame T2trgfp;

	protected JLabel a4;
	protected JLabel a36;
	protected JLabel a37;
	protected JLabel a41;
	protected JLabel abc41a;
	protected JLabel abcde39;
	protected JLabel abcdefghi42a;
	protected JLabel abcdefghi42b;
	protected JLabel abcdefghij38;
	protected JLabel abcdefghij40;
	protected JLabel abcdefghij43;
	protected JLabel bc37;
	protected JLabel bcde41;
	protected JLabel cde3;
	protected JLabel cde4;
	protected JLabel d37;
	protected JLabel defghi42;
	protected JLabel defghij41a;
	protected JLabel ef37;
	protected JLabel f41;
	protected JLabel fgh39;
	protected JLabel g4;
	protected JLabel gh37;
	protected JLabel ghij41;
	protected JLabel i37;
	protected JLabel j36;
	protected JLabel j37;
	protected JLabel j39;
	protected JLabel k3;
	protected JLabel k4;
	protected JLabel ltmp2;
	protected JLabel T2trgl;
	protected JLabel T2trglp;
	protected JButton Btble;
	protected JButton ChngTyp;
	protected JButton NewStpRow;
	protected JButton ODIb;
	protected JButton Otble;
	protected JButton Othb;
	protected JButton RptSum;
	protected JButton RstAll;
	protected JButton T2prnt;
	protected JButton T2html;
	protected JButton T20b;
	protected JLabel[] las = new JLabel[30];
	protected JLabel[] les = new JLabel[30];
	protected JLabel[] lfs = new JLabel[30];
	protected JLabel[] ljs = new JLabel[30];


	protected int curpar;
	protected int curpar1;
	protected int home1;
	protected int horig;
	protected int g50typ;
	protected int iabnd;
	protected int iabnda;
	protected int icrt;
	protected int idrwcnt;
	protected int pdrwcnt;
	protected int iPtrg;
	protected int iPtrga;
	protected int itmp;
	protected int itmp1;
	protected int iT2trg;
	protected int lstrow1;
	protected int lstrow2;
	protected int maxrows;
	protected int maxtst;
	protected int minover;
	protected int mprx1;
	protected int mprx2;
	protected int mpry1;
	protected int mpry2;
	protected int mtyp;
	protected int nb3;
	protected int nb4;
	protected int ng3;
	protected int ni39;
	protected int nommaxo;
	protected int nstprow;
	protected int omtyp;
	protected int prjscr;
	protected int rsltcde;
	protected int rtoget;
	protected int rtoget1;
	protected int runs1a;
	protected int runs1;
	protected int runs2;
	protected int runs2a;
	protected int trgt;
	protected int trgttst1;
	protected int trgttst2;
	protected int winmarg;
	protected int wckt1;
	protected int wckt2;
	protected int wckt2a;
	protected int worig;
	protected int xorig;
	protected int yorig;
	protected int[] ncs = new int[31];
	protected int[] nc1s = new int[31];
	protected int[] nhs = new int[31];
	protected int[] nh1s = new int[31];
	protected int[] rowcnt1 = new int[30];
	protected int[] rowcnt2 = new int[30];
	protected int[][] impty = new int[61][4];
	protected int[][] slctd = new int[30][8];
	protected Integer ntmp;
	protected double[] rsrcpr = new double[3];
	protected double[] dbs = new double[31];
	protected double[] dds = new double[31];
	protected double[] dgs = new double[31];
	protected double[] dis = new double[31];
	protected double[] dbsd = new double[31];
	protected double[] ddsd = new double[31];
	protected double[] dgsd = new double[31];
	protected double[] disd = new double[31];
	protected double[] Fw = new double[10];
	protected double[] pw11 = new double[10];
	protected double[] nw = new double[10];
	protected double adjfct;
	protected double bb;
	protected double g50;
	protected double g50u;
	protected double z0u;
	protected double lmbdastar;
	protected double lmbfct;
	protected double lmbprj;
	protected double olft2;
	protected double oltot1;
	protected double oltot2;
	protected double omax1;
	protected double omax2;
	protected double oplyd1;
	protected double oplyd2;
	protected double opmax1a;
	protected double opmax2a;
	protected double stpint;
	protected double tmp;
	protected double tmpa;
	protected double z0;
	protected double lmbu;
	protected double R1;
	protected Double dtmp;
	protected StringBuilder btblstr;
	protected StringBuilder btblstr1;
	protected StringBuilder btblstrT;
	protected StringBuilder btblstrR;
	protected StringBuilder btblstr1R;
	protected StringBuilder btblstrTR;
	protected StringBuilder gcde;
	protected StringBuilder header;
	protected StringBuilder headerB;
	protected StringBuilder headerBR;
	protected StringBuilder headerR;
	protected StringBuilder otblstr;
	protected StringBuilder otblstr1;
	protected StringBuilder RSstr;
	protected StringBuilder RSstr1;
	protected StringBuilder otblstrR;
	protected StringBuilder otblstr1R;
	protected StringBuilder otblstrT;
	protected StringBuilder otblstrTR;
	protected StringBuilder T2trgb;
	protected StringBuilder T2trgbp;
	protected StringBuilder T2trgbpT;
	protected String ATname;
	protected String ATnameA;
	protected String ca41;
	protected String cabcdefghij43;
	protected String cbcde41;
	protected String cd37;
	protected String cf41;
	protected String cghij41;
	protected String ci37;
	protected String ci39;
	protected String compname;
	protected String ctmp;
	protected String ctmp1;
	protected String HTname;
	protected String HTnameA;
	protected String inpmax;
	protected String mdate;
	protected String ovrply;
	protected String ovrrem;
	protected String rsltdes;
	protected String T1name;
	protected String T2name;
	protected String Tname1;
	protected String Tname1A;
	protected String Tname2;
	protected String Tname2A;
	protected String Tname1B;
	protected GridBagLayout gridbag = new GridBagLayout();
	protected String Tname2B;
	protected String tmpTtl;
	protected String venue;
	protected boolean b100;
	protected boolean b100a;
	protected boolean babnd;
	protected boolean babnda;
	protected boolean babnd2;
	protected boolean babnd2a;
	protected boolean bbasic1;
	protected boolean bbasic2;
	protected boolean bincon;
	protected boolean bincon1;
	protected boolean bneg1;
	protected boolean bneg2;
	protected boolean bmaxo1;
	protected boolean bmaxo2;
	protected boolean bodb1;
	protected boolean bodb2;
	protected boolean boplyd1;
	protected boolean boplyd1a;
	protected boolean boplyd2;
	protected boolean boplyd2a;
	protected boolean bovers;
	protected boolean bovers2;
	protected boolean bovrm1;
	protected boolean bovrm1a;
	protected boolean bovrm2;
	protected boolean bovrm2a;
	protected boolean bresfrst;
	protected boolean bresopen;
	protected boolean brslt;
	protected boolean brunord1;
	protected boolean brunord1a;
	protected boolean brunord2;
	protected boolean brunord2a;
	protected boolean bruns;
	protected boolean brunsall;
	protected boolean bslctd;
	protected boolean binntrm;
	protected boolean bs1;
	protected boolean bs2;
	protected boolean bsplash;
	protected boolean bT2beforeT1;
	protected boolean bT2inp;
	protected boolean bT2open;
	protected boolean bT2frst;
	protected boolean bT2trg;
	protected boolean bT2trg1;
	protected boolean bT2trg2;
	protected boolean btblopen;
	protected boolean btblfrst;
	protected boolean btoofew;
	protected boolean btrgachd;
	protected boolean bwint1;
	protected boolean bwint2;
	protected boolean bword1;
	protected boolean bword1a;
	protected boolean bword2;
	protected boolean bword2a;
	protected boolean bw91;
	protected boolean bw92;
	protected boolean calclte;
	protected boolean calclte1;
	protected boolean calclte2;
	protected boolean chkallbut1;
	protected boolean chkallbut1a;
	protected boolean otblopen;
	protected boolean otblfrst;
	protected boolean oresopen;
	protected boolean oresfrst;
	protected boolean RSfrst;
	protected boolean RSopen;
	protected boolean usrmx2;
	protected boolean usrrn1;
	protected boolean weird;
	protected boolean bOBtble;
	protected boolean bRSbtn;
	protected GridBagConstraints c = new GridBagConstraints();
	protected GridBagLayout gbg = new GridBagLayout();
	protected GridBagConstraints c1 = new GridBagConstraints();
	protected GridBagLayout gbgT2 = new GridBagLayout();
	protected GridBagConstraints cT2 = new GridBagConstraints();
	protected GridBagLayout gbgT2p = new GridBagLayout();
	protected GridBagConstraints cT2p = new GridBagConstraints();
	protected GridBagLayout gbgspl = new GridBagLayout();
	protected GridBagConstraints cspl = new GridBagConstraints();
	protected URL url1;
	protected URL urlq;
	protected URL urle;
	protected URL urlw;
	protected ImageIcon icon1;
	protected ImageIcon iconq;
	protected ImageIcon iconq1;
	protected ImageIcon icone;
	protected ImageIcon icone1;
	protected ImageIcon iconw;
	protected ImageIcon iconw1;

    public void hiliteoff() {
        if (this.bslctd) {
            this.bslctd = false;
            for (int i = 0; i < this.nstprow; ++i) {
                this.tbs[i].setBackground(Color.white);
                this.tbs[i].setForeground(Color.black);
                this.slctd[i][0] = 0;
                this.tc1s[i].setBackground(Color.white);
                this.tc1s[i].setForeground(Color.black);
                this.slctd[i][1] = 0;
                this.tcs[i].setBackground(Color.white);
                this.tcs[i].setForeground(Color.black);
                this.slctd[i][2] = 0;
                this.tds[i].setBackground(Color.white);
                this.tds[i].setForeground(Color.black);
                this.slctd[i][3] = 0;
                this.tgs[i].setBackground(Color.white);
                this.tgs[i].setForeground(Color.black);
                this.slctd[i][4] = 0;
                this.th1s[i].setBackground(Color.white);
                this.th1s[i].setForeground(Color.black);
                this.slctd[i][5] = 0;
                this.ths[i].setBackground(Color.white);
                this.ths[i].setForeground(Color.black);
                this.slctd[i][6] = 0;
                this.tis[i].setBackground(Color.white);
                this.tis[i].setForeground(Color.black);
                this.slctd[i][7] = 0;
            }
        }
    }
	
    public void hiliteon() {
        for (int i = 0; i < this.nstprow; ++i) {
            if (this.tbs[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tbs[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tbs[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tbs[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tbs[i]) {
                    this.tbs[i].requestFocus();
                    this.tbs[i].selectAll();
                }
                else {
                    this.tbs[i].setBackground(this.hiblue);
                    this.tbs[i].setForeground(Color.white);
                }
                this.slctd[i][0] = 1;
            }
            else {
                this.tbs[i].setBackground(Color.white);
                this.tbs[i].setForeground(Color.black);
                this.slctd[i][0] = 0;
            }
            if (this.tc1s[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tc1s[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tc1s[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tc1s[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tc1s[i]) {
                    this.tc1s[i].requestFocus();
                    this.tc1s[i].selectAll();
                }
                else {
                    this.tc1s[i].setBackground(this.hiblue);
                    this.tc1s[i].setForeground(Color.white);
                }
                this.slctd[i][1] = 1;
            }
            else {
                this.tc1s[i].setBackground(Color.white);
                this.tc1s[i].setForeground(Color.black);
                this.slctd[i][1] = 0;
            }
            if (this.tcs[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tcs[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tcs[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tcs[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tcs[i]) {
                    this.tcs[i].requestFocus();
                    this.tcs[i].selectAll();
                }
                else {
                    this.tcs[i].setBackground(this.hiblue);
                    this.tcs[i].setForeground(Color.white);
                }
                this.slctd[i][2] = 1;
            }
            else {
                this.tcs[i].setBackground(Color.white);
                this.tcs[i].setForeground(Color.black);
                this.slctd[i][2] = 0;
            }
            if (this.tds[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tds[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tds[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tds[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tds[i]) {
                    this.tds[i].requestFocus();
                    this.tds[i].selectAll();
                }
                else {
                    this.tds[i].setBackground(this.hiblue);
                    this.tds[i].setForeground(Color.white);
                }
                this.slctd[i][3] = 1;
            }
            else {
                this.tds[i].setBackground(Color.white);
                this.tds[i].setForeground(Color.black);
                this.slctd[i][3] = 0;
            }
            if (this.tgs[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tgs[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tgs[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tgs[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tgs[i]) {
                    this.tgs[i].requestFocus();
                    this.tgs[i].selectAll();
                }
                else {
                    this.tgs[i].setBackground(this.hiblue);
                    this.tgs[i].setForeground(Color.white);
                }
                this.slctd[i][4] = 1;
            }
            else {
                this.tgs[i].setBackground(Color.white);
                this.tgs[i].setForeground(Color.black);
                this.slctd[i][4] = 0;
            }
            if (this.th1s[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.th1s[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.th1s[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.th1s[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.th1s[i]) {
                    this.th1s[i].requestFocus();
                    this.th1s[i].selectAll();
                }
                else {
                    this.th1s[i].setBackground(this.hiblue);
                    this.th1s[i].setForeground(Color.white);
                }
                this.slctd[i][5] = 1;
            }
            else {
                this.th1s[i].setBackground(Color.white);
                this.th1s[i].setForeground(Color.black);
                this.slctd[i][5] = 0;
            }
            if (this.ths[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.ths[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.ths[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.ths[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.ths[i]) {
                    this.ths[i].requestFocus();
                    this.ths[i].selectAll();
                }
                else {
                    this.ths[i].setBackground(this.hiblue);
                    this.ths[i].setForeground(Color.white);
                }
                this.slctd[i][6] = 1;
            }
            else {
                this.ths[i].setBackground(Color.white);
                this.ths[i].setForeground(Color.black);
                this.slctd[i][6] = 0;
            }
            if (this.tis[i].getX() >= Math.min(this.mprx1, this.mprx2) & this.tis[i].getX() <= Math.max(this.mprx1, this.mprx2) & this.tis[i].getY() >= Math.min(this.mpry1, this.mpry2) & this.tis[i].getY() <= Math.max(this.mpry1, this.mpry2)) {
                if (this.mprbx == this.tis[i]) {
                    this.tis[i].requestFocus();
                    this.tis[i].selectAll();
                }
                else {
                    this.tis[i].setBackground(this.hiblue);
                    this.tis[i].setForeground(Color.white);
                }
                this.slctd[i][7] = 1;
            }
            else {
                this.tis[i].setBackground(Color.white);
                this.tis[i].setForeground(Color.black);
                this.slctd[i][7] = 0;
            }
        }
    }
	
    
    
    
    
	public dlcalc() {
		
		
		this.dirnme = System.getProperty("user.home") + File.separator + "Desktop";
		this.dirnmeb = System.getProperty("user.home") + File.separator + "Desktop";
		this.dirnmeT2 = System.getProperty("user.home") + File.separator + "Desktop";
		this.dirnmeRS = System.getProperty("user.home") + File.separator + "Desktop";
		
		this.pw11[0] = 0.0D;
		this.pw11[1] = 0.121D;
		this.pw11[2] = 0.126D;
		this.pw11[3] = 0.128D;
		this.pw11[4] = 0.126D;
		this.pw11[5] = 0.121D;
		this.pw11[6] = 0.111D;
		this.pw11[7] = 0.098D;
		this.pw11[8] = 0.082D;
		this.pw11[9] = 0.06D;
		

		this.bb = 0.036D;
		this.g50 = 248.8D;
		this.z0 = this.g50 / (1.0D - Math.exp(-50.0D * this.bb));
		this.stpint = 1.0E-4D;
		this.lmbdastar = 1.0D;
		this.nstprow = 5;
					
		System.out.println("this.z0   -> "+this.z0);
		System.out.println("this.dirnme : "+this.dirnme  +"\nthis.dirnmeb : "+this.dirnmeb+"\nthis.dirnmeT2 : "+this.dirnmeT2+"\nthis.dirnmeRS : "+this.dirnmeRS);
		
		

		this.otblstr = new StringBuilder(" ");
		this.otblstr1 = new StringBuilder(" ");
		this.otblstrR = new StringBuilder(" ");
		this.otblstr1R = new StringBuilder(" ");
		this.otblstrT = new StringBuilder(" ");
		this.otblstrTR = new StringBuilder(" ");
		this.btblstr = new StringBuilder(" ");
		this.btblstr1 = new StringBuilder(" ");
		this.btblstrT = new StringBuilder(" ");
		this.btblstrR = new StringBuilder(" ");
		this.btblstr1R = new StringBuilder(" ");
		this.btblstrTR = new StringBuilder(" ");
		this.T2trgb = new StringBuilder(" ");
		this.T2trgbp = new StringBuilder(" ");
		this.T2trgbpT = new StringBuilder(" ");
		this.RSstr = new StringBuilder(" ");
		this.RSstr1 = new StringBuilder(" ");

		
		this.usrmx2 = false;
		this.usrrn1 = false;
		this.otblopen = false;
		this.oresopen = false;
		this.btblopen = false;
		this.bresopen = false;
		this.RSopen = false;
		this.otblfrst = true;
		this.oresfrst = true;
		this.btblfrst = true;
		this.bresfrst = true;
		this.bT2open = false;
		this.bT2frst = true;
		this.RSfrst = true;
		this.maxrows = 30;
		this.bslctd = false;
		this.weird = false;
		for (byte b = 0; b < 30; b++) {
			for (byte b1 = 0; b1 < 8; b1++) {
				this.slctd[b][b1] = 0;
			}
		}
		
		
		this.header = new StringBuilder(
				"<hr width=\"520\"><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"60\">");
		this.header.append(
				" <center><font size=\"2\"><b>overs<br>bowled</b></font></center></td><td rowspan=\"2\" width=\"60\"><center>");
		this.header.append(
				" <font size=\"2\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"2\">");
		this.header.append(
				" <b>wickets down</b></font></center><hr></td></tr><tr><td width=\"40\"><center><font size=\"2\"><b>0</b></font></center>");
		this.header.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>1</b></font></center></td><td width=\"40\"><center><font size=\"2\">");
		this.header.append(
				" <b>2</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>3</b></font></center></td><td width=\"40\">");
		this.header.append(
				" <center><font size=\"2\"><b>4</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>5</b></font>");
		this.header.append(
				" </center></td><td width=\"40\"><center><font size=\"2\"><b>6</b></font></center></td><td width=\"40\"><center>");
		this.header.append(
				" <font size=\"2\"><b>7</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>8</b></font></center>");
		this.header.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>9</b></font></center></td></tr></table><hr width=\"520\"></center><center>");
		this.headerB = new StringBuilder(
				"<hr width=\"520\"><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"60\">");
		this.headerB.append(
				" <center><font size=\"2\"><b>overs.balls<br>bowled</b></font></center></td><td rowspan=\"2\" width=\"60\"><center>");
		this.headerB.append(
				" <font size=\"2\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"2\">");
		this.headerB.append(
				" <b>wickets down</b></font></center><hr></td></tr><tr><td width=\"40\"><center><font size=\"2\"><b>0</b></font></center>");
		this.headerB.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>1</b></font></center></td><td width=\"40\"><center><font size=\"2\">");
		this.headerB.append(
				" <b>2</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>3</b></font></center></td><td width=\"40\">");
		this.headerB.append(
				" <center><font size=\"2\"><b>4</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>5</b></font>");
		this.headerB.append(
				" </center></td><td width=\"40\"><center><font size=\"2\"><b>6</b></font></center></td><td width=\"40\"><center>");
		this.headerB.append(
				" <font size=\"2\"><b>7</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>8</b></font></center>");
		this.headerB.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>9</b></font></center></td></tr></table><hr width=\"520\"></center><center>");

		this.headerR = new StringBuilder(
				"<hr width=\"460\"><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"60\"><center>");
		this.headerR.append(
				" <font size=\"2\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"2\">");
		this.headerR.append(
				" <b>wickets down</b></font></center><hr></td></tr><tr><td width=\"40\"><center><font size=\"2\"><b>0</b></font></center>");
		this.headerR.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>1</b></font></center></td><td width=\"40\"><center><font size=\"2\">");
		this.headerR.append(
				" <b>2</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>3</b></font></center></td><td width=\"40\">");
		this.headerR.append(
				" <center><font size=\"2\"><b>4</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>5</b></font>");
		this.headerR.append(
				" </center></td><td width=\"40\"><center><font size=\"2\"><b>6</b></font></center></td><td width=\"40\"><center>");
		this.headerR.append(
				" <font size=\"2\"><b>7</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>8</b></font></center>");
		this.headerR.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>9</b></font></center></td></tr></table><hr width=\"460\"></center><center>");
		this.headerBR = new StringBuilder(
				"<hr width=\"460\"><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"60\"><center>");
		this.headerBR.append(
				" <font size=\"2\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"2\">");
		this.headerBR.append(
				" <b>wickets down</b></font></center><hr></td></tr><tr><td width=\"40\"><center><font size=\"2\"><b>0</b></font></center>");
		this.headerBR.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>1</b></font></center></td><td width=\"40\"><center><font size=\"2\">");
		this.headerBR.append(
				" <b>2</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>3</b></font></center></td><td width=\"40\">");
		this.headerBR.append(
				" <center><font size=\"2\"><b>4</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>5</b></font>");
		this.headerBR.append(
				" </center></td><td width=\"40\"><center><font size=\"2\"><b>6</b></font></center></td><td width=\"40\"><center>");
		this.headerBR.append(
				" <font size=\"2\"><b>7</b></font></center></td><td width=\"40\"><center><font size=\"2\"><b>8</b></font></center>");
		this.headerBR.append(
				" </td><td width=\"40\"><center><font size=\"2\"><b>9</b></font></center></td></tr></table><hr width=\"460\"></center><center>");
		this.urlq = getClass().getResource(this.qmname);
		this.urle = getClass().getResource(this.errname);
		this.urlw = getClass().getResource(this.wrnname);
		System.out.println(this.urlq);
		this.iconq = new ImageIcon(this.urlq);
		Image image1 = this.iconq.getImage();
		Image image2 = image1.getScaledInstance(48, 48, 4);
		this.iconq1 = new ImageIcon(image2);
		System.out.println(this.errname);
		this.icone = new ImageIcon(this.urle);
		image1 = this.icone.getImage();
		image2 = image1.getScaledInstance(56, 48, 4);
		this.icone1 = new ImageIcon(image2);
		System.out.println(this.wrnname);
		this.iconw = new ImageIcon(this.urlw);
		image1 = this.iconw.getImage();
		image2 = image1.getScaledInstance(48, 48, 4);
		this.iconw1 = new ImageIcon(image2);
		this.url1 = getClass().getResource(this.logofilename1);
		this.icon1 = new ImageIcon(this.url1);
		setIconImage(this.icon1.getImage());
		this.jpmain = new JPanel();
		this.jpmain.setBackground(Color.lightGray);
		this.jpmain.setOpaque(true);
		HashSet<? extends AWTKeyStroke> hashSet1 = new HashSet();
		HashSet<? extends AWTKeyStroke> hashSet2 = new HashSet();
		hashSet1.clear();
		hashSet2.clear();
		this.jpmain.setFocusTraversalKeys(0, hashSet1);
		this.jpmain.setFocusTraversalKeys(1, hashSet2);

		InputMap inputMap = this.jpmain.getInputMap(1);
		KeyStroke keyStroke1 = KeyStroke.getKeyStroke(9, 0);
		System.out.println(keyStroke1); //  pressed TAB
		KeyStroke keyStroke2 = KeyStroke.getKeyStroke(9, 1);
		System.out.println(keyStroke2); //shift pressed TAB
		KeyStroke keyStroke3 = KeyStroke.getKeyStroke(80, 2);
		System.out.println(keyStroke3); //  ctrl pressed P
		KeyStroke keyStroke4 = KeyStroke.getKeyStroke(76, 2);
		System.out.println(keyStroke4); //  ctrl pressed L
		KeyStroke keyStroke5 = KeyStroke.getKeyStroke(82, 2);
		System.out.println(keyStroke5); //  ctrl pressed R
		KeyStroke keyStroke6 = KeyStroke.getKeyStroke(82, 3);
		System.out.println(keyStroke6); //  shift ctrl pressed R
		KeyStroke keyStroke7 = KeyStroke.getKeyStroke(65, 2);
		System.out.println(keyStroke7); //  ctrl pressed A
		KeyStroke keyStroke8 = KeyStroke.getKeyStroke(71, 2);
		System.out.println(keyStroke8); //  ctrl pressed G
		KeyStroke keyStroke9 = KeyStroke.getKeyStroke(72, 2);
		System.out.println(keyStroke9); //  ctrl pressed H
		KeyStroke keyStroke10 = KeyStroke.getKeyStroke(83, 2);
		System.out.println(keyStroke10); //  ctrl pressed S
		this.hiblue = UIManager.getColor("textHighlight");
		this.HTname = "Home Team";
		this.ATname = "Away Team";
		this.HTnameA = "Home Team";
		this.ATnameA = "Away Team";
		this.venue = "Venue";
		this.compname = "Tournament Name";
		this.home1 = 0;
		this.mdate = "";


		AbstractAction abstractAction = new AbstractAction() {
			public void actionPerformed(ActionEvent param1ActionEvent) {
				System.out.println(" ------ "+param1ActionEvent);
			}
		};

		inputMap.put(keyStroke1, "newtab");
		this.jpmain.getActionMap().put("newtab", abstractAction);
		inputMap.put(keyStroke2, "newstab");
		this.jpmain.getActionMap().put("newstab", abstractAction);
		inputMap.put(keyStroke3, "newctrlp");
		this.jpmain.getActionMap().put("newctrlp", abstractAction);
		inputMap.put(keyStroke4, "newctrll");
		this.jpmain.getActionMap().put("newctrll", abstractAction);
		inputMap.put(keyStroke5, "newctrlr");
		this.jpmain.getActionMap().put("newctrlr", abstractAction);
		inputMap.put(keyStroke6, "newctrlsr");
		this.jpmain.getActionMap().put("newctrlsr", abstractAction);
		inputMap.put(keyStroke7, "newctrla");
		this.jpmain.getActionMap().put("newctrla", abstractAction);
		inputMap.put(keyStroke7, "newctrlg");
		this.jpmain.getActionMap().put("newctrlg", abstractAction);
		inputMap.put(keyStroke7, "newctrlh");
		this.jpmain.getActionMap().put("newctrlh", abstractAction);
		inputMap.put(keyStroke7, "newctrls");
		this.jpmain.getActionMap().put("newctrls", abstractAction);
		this.jpmain.setLayout(this.gridbag);

		draw0();

		setDefaultCloseOperation(3);
		setResizable(false);
		add(new JScrollPane(this.jpmain, 22, 31));
		pack();
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.center = graphicsEnvironment.getCenterPoint();
		Rectangle rectangle = graphicsEnvironment.getMaximumWindowBounds();
		int i = rectangle.height;
		this.worig = Math.min(getWidth(), rectangle.width);
		System.out.println("this.worig"+this.worig);
		this.horig = Math.min(getHeight(), i);
		System.out.println("this.horig"+this.horig);
		this.xorig = this.center.x - this.worig / 2;
		this.yorig = this.center.y - this.horig / 2;
		setBounds(this.xorig, this.yorig, this.worig, this.horig);
		setVisible(false);

		drawsplsh();
		this.splashf.requestFocus();
	}

	public void drawsplsh() {
		URL uRL = getClass().getResource(this.logofilename);
		ImageIcon imageIcon = new ImageIcon(uRL);
		JLabel jLabel1 = new JLabel(
				"<html><center><br><b>The ICC Duckworth-Lewis-Stern Calculator</b><br><font size=\"6\" face=\"Times New Roman\">DLS Edition 2014</font><br><font size=\"4\" face=\"Times New Roman\">(Version 1.0)</font></center>",
				imageIcon, 0);
		jLabel1.setFont(new Font("Sans Serif", 0, 28));
		jLabel1.setVerticalTextPosition(3);
		jLabel1.setHorizontalTextPosition(0);
		JLabel jLabel2 = new JLabel("<html><br>select match type", 0);
		jLabel2.setFont(new Font("Serif", 1, 18));
		JPanel jPanel = new JPanel();
		this.splashf = new JFrame(this.PRGMname);
		this.splashf.setIconImage(this.icon1.getImage());
		this.splashf.addKeyListener(this);
		this.splashf.setDefaultCloseOperation(3);
		jPanel.setLayout(this.gbgspl);
		this.cspl.fill = 1;
		this.cspl.gridwidth = 6;
		this.cspl.gridx = 0;
		this.cspl.gridy = 0;
		this.cspl.weightx = 1.0D;
		this.cspl.weighty = 0.9D;
		this.gbgspl.setConstraints(jLabel1, this.cspl);
		jPanel.add(jLabel1);
		this.cspl.gridwidth = 6;
		this.cspl.gridx = 0;
		this.cspl.gridy = 1;
		this.cspl.weightx = 1.0D;
		this.cspl.weighty = 0.025D;
		this.gbgspl.setConstraints(jLabel2, this.cspl);
		jPanel.add(jLabel2);
		jLabel2.addKeyListener(this);
		JLabel jLabel3 = new JLabel(" ");
		this.cspl.gridwidth = 1;
		this.cspl.gridx = 0;
		this.cspl.gridy = 2;
		this.cspl.weightx = 0.33D;
		this.cspl.weighty = 0.05D;
		this.gbgspl.setConstraints(jLabel3, this.cspl);
		jPanel.add(jLabel3);
		this.ODIb = new JButton("<html><center>ODI: 50 overs/innings<br><font size=\"3\">(min. 20 overs/side)");
		this.ODIb.setOpaque(false);
		this.ODIb.setBackground(aqua1);
		this.ODIb.setFont(new Font("Serif", 1, 16));
		this.cspl.gridwidth = 1;
		this.cspl.gridheight = 3;
		this.cspl.gridx = 1;
		this.cspl.gridy = 2;
		this.cspl.weightx = 0.11D;
		this.cspl.weighty = 0.05D;
		this.cspl.insets = new Insets(2, 2, 2, 2);
		this.gbgspl.setConstraints(this.ODIb, this.cspl);
		jPanel.add(this.ODIb);

		this.ODIb.addActionListener(this);
		this.ODIb.addKeyListener(this);

		this.T20b = new JButton(
				"<html><center>Twenty20<br><font size=\"3\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; (min. 5 overs/side)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		this.T20b.setOpaque(false);
		this.T20b.setBackground(aqua1);
		this.T20b.setFont(new Font("Serif", 1, 16));
		this.cspl.gridwidth = 1;
		this.cspl.gridheight = 3;
		this.cspl.gridx = 2;
		this.cspl.gridy = 2;
		this.cspl.weightx = 0.11D;
		this.cspl.weighty = 0.05D;
		this.gbgspl.setConstraints(this.T20b, this.cspl);
		jPanel.add(this.T20b);
		this.T20b.addActionListener(this);
		this.T20b.addKeyListener(this);

		this.Othb = new JButton("<html><center>&nbsp; other match types&nbsp");
		this.Othb.setOpaque(false);
		this.Othb.setBackground(aqua1);
		this.Othb.setFont(new Font("Serif", 1, 16));
		this.cspl.gridwidth = 2;
		this.cspl.gridheight = 1;
		this.cspl.gridx = 3;
		this.cspl.gridy = 2;
		this.cspl.weightx = 0.11D;
		this.cspl.weighty = 0.05D;
		this.gbgspl.setConstraints(this.Othb, this.cspl);
		jPanel.add(this.Othb);
		this.Othb.addActionListener(this);
		this.Othb.addKeyListener(this);

		JLabel jLabel4 = new JLabel(" ");
		this.cspl.gridwidth = 1;
		this.cspl.gridheight = 3;
		this.cspl.gridx = 5;
		this.cspl.gridy = 2;
		this.cspl.weightx = 0.33D;
		this.cspl.weighty = 0.05D;
		this.cspl.insets = new Insets(0, 0, 0, 0);
		this.gbgspl.setConstraints(jLabel4, this.cspl);
		jPanel.add(jLabel4);
		this.cspl.gridwidth = 6;
		this.cspl.gridheight = 1;
		this.cspl.gridx = 0;
		this.cspl.gridy = 5;
		this.cspl.weightx = 1.0D;
		this.cspl.weighty = 0.025D;

		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");

		JLabel jLabel5 = new JLabel(
				"<html>&copy; " + simpleDateFormat.format(date) + " International Cricket Council &nbsp;", 4);
		jLabel5.setFont(new Font("Serif", 0, 10));
		this.gbgspl.setConstraints(jLabel5, this.cspl);
		jPanel.add(jLabel5);
		this.splashf.setSize(new Dimension(780, 550));
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point point = graphicsEnvironment.getCenterPoint();
		Rectangle rectangle = graphicsEnvironment.getMaximumWindowBounds();
		int i = Math.max(rectangle.width / 2, Math.min(this.splashf.getWidth(), rectangle.width));
		int j = Math.max(rectangle.height / 2, Math.min(this.splashf.getHeight(), rectangle.height));
		int k = point.x - i / 2, m = point.y - j / 2;
		this.splashf.setBounds(k, m, i, j);
		if (i == rectangle.width && j == rectangle.height)
			this.splashf.setExtendedState(6);
		this.splashf.add(jPanel);
		jPanel.setBackground(aqua1);
		jPanel.setOpaque(true);
		this.splashf.setVisible(true);
		this.splashf.setResizable(false);
		this.splashf.validate();
		this.splashf.requestFocus();
		this.bsplash = true;
	}

	public void draw0() {
		this.c.fill = 1;
		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 0;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jlabel1");
			JLabel jLabel1 = new JLabel(" ", 0);
		jLabel1.setOpaque(false);
		jLabel1.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel1, this.c);
		this.jpmain.add(jLabel1);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
	System.out.println("jlabel2");
		JLabel jLabel2 = new JLabel(" ", 0);
		jLabel2.setFont(new Font("Serif", 1, 18));
		jLabel2.setOpaque(false);
		jLabel2.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel2, this.c);
		this.jpmain.add(jLabel2);

		this.c.gridwidth = 4;
		this.c.gridx = 1;
		this.c.gridy = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jlabel3");
		JLabel jLabel3 = new JLabel("Team 1's innings", 0);
		jLabel3.setFont(new Font("Serif", 1, 18));
		jLabel3.setOpaque(false);
		jLabel3.setBackground(Color.lightGray);
		jLabel3.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel3, this.c);
		this.jpmain.add(jLabel3);

		this.c.gridwidth = 2;
		this.c.gridx = 5;
		this.c.gridy = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jlabel4");
		JLabel jLabel4 = new JLabel(" ", 0);
		jLabel4.setFont(new Font("Serif", 1, 18));
		jLabel4.setOpaque(false);
		jLabel4.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel4, this.c);
		this.jpmain.add(jLabel4);

		this.c.gridwidth = 4;
		this.c.gridx = 7;
		this.c.gridy = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jlabel5");
		JLabel jLabel5 = new JLabel("Team 2's innings", 0);
		jLabel5.setFont(new Font("Serif", 1, 18));
		jLabel5.setOpaque(false);
		jLabel5.setBackground(Color.lightGray);
		jLabel5.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel5, this.c);
		this.jpmain.add(jLabel5);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jlabel6");
		JLabel jLabel6 = new JLabel(" ", 0);
		jLabel6.setFont(new Font("Serif", 1, 18));
		jLabel6.setOpaque(false);
		jLabel6.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel6, this.c);
		this.jpmain.add(jLabel6);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("jLabel7 overs/innings&nbsp; <br> at start of match:  ");
		JLabel jLabel7 = new JLabel("<html><p align=\"right\">&nbsp;  overs/innings&nbsp; <br> at start of match: ", 4);
		jLabel7.setFont(new Font("Serif", 0, 12));
		jLabel7.setOpaque(false);
		jLabel7.setBackground(Color.lightGray);
		jLabel7.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel7, this.c);
		this.jpmain.add(jLabel7);

		this.c.fill = 0;
		this.c.anchor = 15;
		this.c.gridwidth = 1;
		this.c.gridx = 1;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println(" this.team1OversInnigsAtStartOfMatch");
		this.team1OversInnigsAtStartOfMatch = new TextField(4);
		this.team1OversInnigsAtStartOfMatch.setFont(new Font("Serif", 0, 14));
		this.team1OversInnigsAtStartOfMatch.setBackground(Color.white);
		this.team1OversInnigsAtStartOfMatch.setForeground(Color.black);
		this.gridbag.setConstraints(this.team1OversInnigsAtStartOfMatch, this.c);
		this.jpmain.add(this.team1OversInnigsAtStartOfMatch);
		this.team1OversInnigsAtStartOfMatch.addTextListener(this);
		
		
		System.out.println(" this.team1OversInnigsAtStartOfMatch.addTextListener(this);");
		this.team1OversInnigsAtStartOfMatch.addFocusListener(this);
		System.out.println(" this.team1OversInnigsAtStartOfMatch.addFocusListener(this);");
		this.team1OversInnigsAtStartOfMatch.addKeyListener(this);
		System.out.println(" this.team1OversInnigsAtStartOfMatch.addKeyListener(this);");

		this.c.fill = 1;
		this.c.gridwidth = 4;
		this.c.gridx = 2;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println("this.cde3 jlabel");
		this.cde3 = new JLabel(" ", 2);
		this.cde3.setOpaque(false);
		this.cde3.setFont(new Font("Serif", 1, 14));
		this.cde3.setForeground(Color.yellow);
		this.cde3.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.cde3, this.c);
		this.jpmain.add(this.cde3);

		this.c.gridwidth = 1;
		this.c.gridx = 6;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		System.out.println(" overs at&nbsp; <br> start of innings: ");
		JLabel jLabel8 = new JLabel("<html><p align=\"right\">&nbsp; overs at&nbsp; <br> start of innings: ", 4);
		jLabel8.setFont(new Font("Serif", 0, 12));
		jLabel8.setOpaque(false);
		jLabel8.setBackground(Color.lightGray);
		jLabel8.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel8, this.c);
		this.jpmain.add(jLabel8);

		this.c.fill = 0;
		this.c.anchor = 15;
		this.c.gridwidth = 1;
		this.c.gridx = 7;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.g3 = new TextField(4);
		this.g3.setFont(new Font("Serif", 0, 14));
		this.g3.setBackground(Color.white);
		this.g3.setForeground(Color.black);
		this.gridbag.setConstraints(this.g3, this.c);
		this.jpmain.add(this.g3);
		this.g3.addFocusListener(this);
		this.g3.addKeyListener(this);

		this.c.fill = 1;
		this.c.gridwidth = 1;
		this.c.gridx = 8;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel9 = new JLabel(" ", 0);
		jLabel9.setOpaque(false);
		jLabel9.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel9, this.c);
		this.jpmain.add(jLabel9);

		this.c.fill = 2;
		this.c.anchor = 15;
		this.c.gridwidth = 3;
		this.c.gridx = 9;
		this.c.gridy = 2;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.k3 = new JLabel(" ", 2);
		this.k3.setOpaque(true);
		this.k3.setFont(new Font("Serif", 1, 14));
		this.k3.setBackground(Color.lightGray);
		this.k3.setForeground(Color.yellow);
		this.k3.setPreferredSize(new Dimension(178, 19));
		this.gridbag.setConstraints(this.k3, this.c);
		this.jpmain.add(this.k3);

		this.c.fill = 1;
		this.c.gridwidth = 1;
		this.c.gridx = 12;
		this.c.gridy = 2;
		this.c.weightx = 0.1D;
		this.c.weighty = 1.0D;
		JLabel jLabel10 = new JLabel(" ", 0);
		jLabel10.setOpaque(false);
		jLabel10.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel10, this.c);
		this.jpmain.add(jLabel10);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.a4 = new JLabel("<html><p align=\"right\">&nbsp; Team 1's&nbsp; <br> final score: ", 4);
		this.a4.setFont(new Font("Serif", 0, 12));
		this.a4.setOpaque(false);
		this.a4.setBackground(Color.lightGray);
		this.a4.setForeground(Color.black);
		this.gridbag.setConstraints(this.a4, this.c);
		this.jpmain.add(this.a4);

		this.c.fill = 0;
		this.c.anchor = 15;
		this.c.gridwidth = 1;
		this.c.gridx = 1;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.team1FinalScore = new TextField(4);
		this.team1FinalScore.setFont(new Font("Serif", 0, 14));
		this.team1FinalScore.setBackground(Color.white);
		this.team1FinalScore.setForeground(Color.black);
		this.gridbag.setConstraints(this.team1FinalScore, this.c);
		this.jpmain.add(this.team1FinalScore);
		this.team1FinalScore.addFocusListener(this);
		this.team1FinalScore.addKeyListener(this);

		this.c.fill = 1;
		this.c.gridwidth = 4;
		this.c.gridx = 2;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.cde4 = new JLabel(" ", 2);
		this.cde4.setOpaque(true);
		this.cde4.setFont(new Font("Serif", 1, 14));
		this.cde4.setForeground(Color.yellow);
		this.cde4.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.cde4, this.c);
		this.jpmain.add(this.cde4);

		this.c.fill = 2;
		this.c.anchor = 15;
		this.c.gridwidth = 1;
		this.c.gridx = 6;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel11 = new JLabel("<html><font size=\"6\">T</font>ARGET:&nbsp</html>", 4);
		jLabel11.setFont(new Font("Serif", 1, 16));
		jLabel11.setOpaque(false);
		jLabel11.setBackground(Color.lightGray);
		jLabel11.setForeground(Color.red);
		this.gridbag.setConstraints(jLabel11, this.c);
		this.jpmain.add(jLabel11);

		this.c.gridwidth = 1;
		this.c.gridx = 7;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.g4 = new JLabel(" ", 0);
		this.g4.setFont(new Font("Serif", 1, 18));
		this.g4.setOpaque(true);
		this.g4.setBackground(Color.pink);
		this.g4.setForeground(Color.red);
		this.g4.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.red));
		this.gridbag.setConstraints(this.g4, this.c);
		this.jpmain.add(this.g4);

		this.c.gridwidth = 1;
		this.c.gridx = 8;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel12 = new JLabel(" (to win)", 2);
		jLabel12.setFont(new Font("Serif", 0, 12));
		jLabel12.setOpaque(false);
		jLabel12.setBackground(Color.lightGray);
		jLabel12.setForeground(Color.red);
		this.gridbag.setConstraints(jLabel12, this.c);
		this.jpmain.add(jLabel12);

		this.c.anchor = 11;
		this.c.gridwidth = 3;
		this.c.gridx = 9;
		this.c.gridy = 3;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.k4 = new JLabel(" ", 2);
		this.k4.setFont(new Font("Serif", 1, 14));
		this.k4.setOpaque(true);
		this.k4.setBackground(Color.lightGray);
		this.k4.setForeground(Color.yellow);
		this.gridbag.setConstraints(this.k4, this.c);
		this.jpmain.add(this.k4);

		this.c.fill = 1;
		this.c.anchor = 15;
		this.c.gridwidth = 1;
		this.c.gridx = 12;
		this.c.gridy = 3;
		this.c.weightx = 0.1D;
		this.c.weighty = 1.0D;
		JLabel jLabel13 = new JLabel(" ", 0);
		jLabel13.setOpaque(false);
		jLabel13.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel13, this.c);
		this.jpmain.add(jLabel13);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel14 = new JLabel(" ", 4);
		jLabel14.setOpaque(false);
		jLabel14.setBackground(Color.lightGray);
		jLabel14.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel14, this.c);
		this.jpmain.add(jLabel14);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel15 = new JLabel(" ", 4);
		jLabel15.setFont(new Font("Serif", 0, 12));
		jLabel15.setOpaque(false);
		jLabel15.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel15, this.c);
		this.jpmain.add(jLabel15);

		this.c.gridwidth = 1;
		this.c.gridx = 1;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel16 = new JLabel("<html><center>overs.balls<br>bowled", 0);
		jLabel16.setFont(new Font("Serif", 0, 12));
		jLabel16.setOpaque(false);
		jLabel16.setBackground(Color.lightGray);
		jLabel16.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel16, this.c);
		this.jpmain.add(jLabel16);

		this.c.gridwidth = 1;
		this.c.gridx = 1;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel17 = new JLabel(" ", 0);
		jLabel17.setOpaque(false);
		jLabel17.setBackground(Color.lightGray);
		jLabel17.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel17, this.c);
		this.jpmain.add(jLabel17);

		this.c.gridwidth = 1;
		this.c.gridx = 2;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel18 = new JLabel("<html><center>runs<br>scored", 0);
		jLabel18.setFont(new Font("Serif", 0, 12));
		jLabel18.setOpaque(false);
		jLabel18.setBackground(Color.lightGray);
		jLabel18.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel18, this.c);
		this.jpmain.add(jLabel18);

		this.c.gridwidth = 1;
		this.c.gridx = 2;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel19 = new JLabel(" ", 0);
		jLabel19.setOpaque(false);
		jLabel19.setBackground(Color.lightGray);
		jLabel19.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel19, this.c);
		this.jpmain.add(jLabel19);

		this.c.gridwidth = 1;
		this.c.gridx = 3;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel20 = new JLabel("<html><center>wickets<br>down", 0);
		jLabel20.setFont(new Font("Serif", 0, 12));
		jLabel20.setOpaque(false);
		jLabel20.setBackground(Color.lightGray);
		jLabel20.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel20, this.c);
		this.jpmain.add(jLabel20);

		this.c.gridwidth = 1;
		this.c.gridx = 3;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel21 = new JLabel(" ", 0);
		jLabel21.setOpaque(false);
		jLabel21.setBackground(Color.lightGray);
		jLabel21.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel21, this.c);
		this.jpmain.add(jLabel21);

		this.c.gridwidth = 1;
		this.c.gridx = 4;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel22 = new JLabel("<html><center>overs<br>lost/side", 0);
		jLabel22.setFont(new Font("Serif", 0, 12));
		jLabel22.setOpaque(false);
		jLabel22.setBackground(Color.lightGray);
		jLabel22.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel22, this.c);
		this.jpmain.add(jLabel22);

		this.c.gridwidth = 1;
		this.c.gridx = 4;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel23 = new JLabel(" ", 0);
		jLabel23.setOpaque(false);
		jLabel23.setBackground(Color.lightGray);
		jLabel23.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel23, this.c);
		this.jpmain.add(jLabel23);

		this.c.gridwidth = 1;
		this.c.gridx = 5;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel24 = new JLabel(" ", 4);
		jLabel24.setOpaque(false);
		jLabel24.setBackground(Color.lightGray);
		jLabel24.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel24, this.c);
		this.jpmain.add(jLabel24);

		this.c.gridwidth = 1;
		this.c.gridx = 5;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel25 = new JLabel(" ", 4);
		jLabel25.setOpaque(false);
		jLabel25.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel25, this.c);
		this.jpmain.add(jLabel25);

		this.c.gridwidth = 1;
		this.c.gridx = 6;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel26 = new JLabel(" ", 4);
		jLabel26.setOpaque(false);
		jLabel26.setBackground(Color.lightGray);
		jLabel26.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel26, this.c);
		this.jpmain.add(jLabel26);

		this.c.gridwidth = 1;
		this.c.gridx = 6;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel27 = new JLabel(" ", 4);
		jLabel27.setFont(new Font("Serif", 0, 12));
		jLabel27.setOpaque(false);
		jLabel27.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel27, this.c);
		this.jpmain.add(jLabel27);

		this.c.gridwidth = 1;
		this.c.gridx = 7;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel28 = new JLabel("<html><center>overs.balls<br>bowled", 0);
		jLabel28.setFont(new Font("Serif", 0, 12));
		jLabel28.setOpaque(false);
		jLabel28.setBackground(Color.lightGray);
		jLabel28.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel28, this.c);
		this.jpmain.add(jLabel28);

		this.c.gridwidth = 1;
		this.c.gridx = 7;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel29 = new JLabel(" ", 0);
		jLabel29.setOpaque(false);
		jLabel29.setBackground(Color.lightGray);
		jLabel29.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel29, this.c);
		this.jpmain.add(jLabel29);

		this.c.gridwidth = 1;
		this.c.gridx = 8;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel30 = new JLabel("<html><center>runs<br>scored", 0);
		jLabel30.setFont(new Font("Serif", 0, 12));
		jLabel30.setOpaque(false);
		jLabel30.setBackground(Color.lightGray);
		jLabel30.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel30, this.c);
		this.jpmain.add(jLabel30);

		this.c.gridwidth = 1;
		this.c.gridx = 8;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel31 = new JLabel(" ", 0);
		jLabel31.setOpaque(false);
		jLabel31.setBackground(Color.lightGray);
		jLabel31.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel31, this.c);
		this.jpmain.add(jLabel31);

		this.c.gridwidth = 1;
		this.c.gridx = 9;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel32 = new JLabel("<html><center>wickets<br>down", 0);
		jLabel32.setFont(new Font("Serif", 0, 12));
		jLabel32.setOpaque(false);
		jLabel32.setBackground(Color.lightGray);
		jLabel32.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel32, this.c);
		this.jpmain.add(jLabel32);

		this.c.gridwidth = 1;
		this.c.gridx = 9;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel33 = new JLabel(" ", 0);
		jLabel33.setOpaque(false);
		jLabel33.setBackground(Color.lightGray);
		jLabel33.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel33, this.c);
		this.jpmain.add(jLabel33);

		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel34 = new JLabel("<html><center>overs<br>lost", 0);
		jLabel34.setFont(new Font("Serif", 0, 12));
		jLabel34.setOpaque(false);
		jLabel34.setBackground(Color.lightGray);
		jLabel34.setForeground(Color.black);
		this.gridbag.setConstraints(jLabel34, this.c);
		this.jpmain.add(jLabel34);

		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel35 = new JLabel(" ", 0);
		jLabel35.setOpaque(false);
		jLabel35.setBackground(Color.lightGray);
		jLabel35.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel35, this.c);
		this.jpmain.add(jLabel35);

		this.c.gridwidth = 1;
		this.c.gridx = 11;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel36 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ", 4);
		jLabel36.setOpaque(false);
		jLabel36.setBackground(Color.lightGray);
		jLabel36.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel36, this.c);
		this.jpmain.add(jLabel36);

		this.c.gridwidth = 1;
		this.c.gridx = 11;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel37 = new JLabel(" ", 4);
		jLabel37.setOpaque(false);
		jLabel37.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel37, this.c);
		this.jpmain.add(jLabel37);

		this.c.gridwidth = 1;
		this.c.gridx = 12;
		this.c.gridy = 4;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel38 = new JLabel(" ", 4);
		jLabel38.setOpaque(false);
		jLabel38.setBackground(Color.lightGray);
		jLabel38.setFont(new Font("Serif", 0, 6));
		this.gridbag.setConstraints(jLabel38, this.c);
		this.jpmain.add(jLabel38);

		this.c.gridwidth = 1;
		this.c.gridx = 12;
		this.c.gridy = 5;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel39 = new JLabel(" ", 2);
		jLabel39.setOpaque(false);
		jLabel39.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel39, this.c);
		this.jpmain.add(jLabel39);

		for (byte b = 0; b < this.nstprow; b++) {
			this.c.gridwidth = 1;
			this.c.gridx = 0;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.itmp = b + 1;
			this.ntmp = new Integer(this.itmp);
			this.las[b] = new JLabel(this.ntmp.toString(), 4);
			this.las[b].setFont(new Font("Serif", 0, 10));
			this.las[b].setOpaque(false);
			this.las[b].setBackground(Color.lightGray);
			this.las[b].setForeground(Color.black);
			this.gridbag.setConstraints(this.las[b], this.c);
			this.jpmain.add(this.las[b]);

			this.c.gridwidth = 1;
			this.c.gridx = 1;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.tbs[b] = new TextField(4);
			this.tbs[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tbs[b], this.c);
			this.jpmain.add(this.tbs[b]);
			this.tbs[b].addTextListener(this);
			this.tbs[b].addFocusListener(this);
			this.tbs[b].addKeyListener(this);
			this.tbs[b].addMouseListener(this);
			this.tbs[b].addMouseMotionListener(this);
			this.tbs[b].setBackground(Color.white);
			this.tbs[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 2;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.tc1s[b] = new TextField(4);
			this.tc1s[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tc1s[b], this.c);
			this.jpmain.add(this.tc1s[b]);
			this.tc1s[b].addTextListener(this);
			this.tc1s[b].addFocusListener(this);
			this.tc1s[b].addKeyListener(this);
			this.tc1s[b].addMouseListener(this);
			this.tc1s[b].addMouseMotionListener(this);
			this.tc1s[b].setBackground(Color.white);
			this.tc1s[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 3;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.tcs[b] = new TextField(4);
			this.tcs[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tcs[b], this.c);
			this.jpmain.add(this.tcs[b]);
			this.tcs[b].addTextListener(this);
			this.tcs[b].addFocusListener(this);
			this.tcs[b].addKeyListener(this);
			this.tcs[b].addMouseListener(this);
			this.tcs[b].addMouseMotionListener(this);
			this.tcs[b].setBackground(Color.white);
			this.tcs[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 4;
			this.c.gridy = 6 + b;
			this.c.weightx = 5.0D;
			this.c.weighty = 1.0D;
			this.tds[b] = new TextField(4);
			this.tds[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tds[b], this.c);
			this.jpmain.add(this.tds[b]);
			this.tds[b].addTextListener(this);
			this.tds[b].addFocusListener(this);
			this.tds[b].addKeyListener(this);
			this.tds[b].addMouseListener(this);
			this.tds[b].addMouseMotionListener(this);
			this.tds[b].setBackground(Color.white);
			this.tds[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 5;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.les[b] = new JLabel(" ", 4);
			this.les[b].setOpaque(false);
			this.les[b].setBackground(Color.lightGray);
			this.gridbag.setConstraints(this.les[b], this.c);
			this.jpmain.add(this.les[b]);

			this.c.gridwidth = 1;
			this.c.gridx = 6;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.lfs[b] = new JLabel(this.ntmp.toString(), 4);
			this.lfs[b].setFont(new Font("Serif", 0, 10));
			this.lfs[b].setOpaque(false);
			this.lfs[b].setBackground(Color.lightGray);
			this.lfs[b].setForeground(Color.black);
			this.gridbag.setConstraints(this.lfs[b], this.c);
			this.jpmain.add(this.lfs[b]);

			this.c.gridwidth = 1;
			this.c.gridx = 7;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.tgs[b] = new TextField(4);
			this.tgs[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tgs[b], this.c);
			this.jpmain.add(this.tgs[b]);
			this.tgs[b].addTextListener(this);
			this.tgs[b].addFocusListener(this);
			this.tgs[b].addKeyListener(this);
			this.tgs[b].addMouseListener(this);
			this.tgs[b].addMouseMotionListener(this);
			this.tgs[b].setBackground(Color.white);
			this.tgs[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 8;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.th1s[b] = new TextField(4);
			this.th1s[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.th1s[b], this.c);
			this.jpmain.add(this.th1s[b]);
			this.th1s[b].addTextListener(this);
			this.th1s[b].addFocusListener(this);
			this.th1s[b].addKeyListener(this);
			this.th1s[b].addMouseListener(this);
			this.th1s[b].addMouseMotionListener(this);
			this.th1s[b].setBackground(Color.white);
			this.th1s[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 9;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.ths[b] = new TextField(4);
			this.ths[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.ths[b], this.c);
			this.jpmain.add(this.ths[b]);
			this.ths[b].addTextListener(this);
			this.ths[b].addFocusListener(this);
			this.ths[b].addKeyListener(this);
			this.ths[b].addMouseListener(this);
			this.ths[b].addMouseMotionListener(this);
			this.ths[b].setBackground(Color.white);
			this.ths[b].setForeground(Color.black);

			this.c.gridwidth = 1;
			this.c.gridx = 10;
			this.c.gridy = 6 + b;
			this.c.weightx = 5.0D;
			this.c.weighty = 1.0D;
			this.tis[b] = new TextField(4);
			this.tis[b].setFont(new Font("Serif", 0, 14));
			this.gridbag.setConstraints(this.tis[b], this.c);
			this.jpmain.add(this.tis[b]);
			this.tis[b].addTextListener(this);
			this.tis[b].addFocusListener(this);
			this.tis[b].addKeyListener(this);
			this.tis[b].addMouseListener(this);
			this.tis[b].addMouseMotionListener(this);
			this.tis[b].setBackground(Color.white);
			this.tis[b].setForeground(Color.black);

			this.c.gridwidth = 2;
			this.c.gridx = 11;
			this.c.gridy = 6 + b;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.ljs[b] = new JLabel(" ", 2);
			this.ljs[b].setOpaque(false);
			this.ljs[b].setBackground(Color.lightGray);
			this.ljs[b].setForeground(ornge);
			this.ljs[b].setFont(new Font("Serif", 0, 11));
			this.gridbag.setConstraints(this.ljs[b], this.c);
			this.jpmain.add(this.ljs[b]);
		}

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 6 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.a36 = new JLabel(" ", 4);
		this.a36.setOpaque(false);
		this.a36.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.a36, this.c);
		this.jpmain.add(this.a36);

		this.c.gridwidth = 10;
		this.c.gridx = 1;
		this.c.gridy = 6 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.NewStpRow = new JButton("add further stoppage row");
		this.NewStpRow.setBackground(bcol);
		this.NewStpRow.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.NewStpRow, this.c);
		this.jpmain.add(this.NewStpRow);
		this.NewStpRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent param1ActionEvent) {
				System.out.println("Add Next stop row");
				dlcalc.this.nstprow++;
				if (dlcalc.this.nstprow < dlcalc.this.maxrows + 1) {
					dlcalc.this.cd37 = dlcalc.this.d37.getText();
					dlcalc.this.ci37 = dlcalc.this.i37.getText();
					dlcalc.this.ci39 = dlcalc.this.i39.getText();
					dlcalc.this.ca41 = dlcalc.this.a41.getText();
					dlcalc.this.cbcde41 = dlcalc.this.bcde41.getText();
					dlcalc.this.cf41 = dlcalc.this.f41.getText();
					dlcalc.this.cghij41 = dlcalc.this.ghij41.getText();
					dlcalc.this.cabcdefghij43 = dlcalc.this.abcdefghij43.getText();
					dlcalc.this.bOBtble = dlcalc.this.Otble.isEnabled();
					dlcalc.this.bRSbtn = dlcalc.this.RptSum.isEnabled();
					dlcalc.this.draw2();
					dlcalc.this.d37.setText(dlcalc.this.cd37);
					dlcalc.this.i37.setText(dlcalc.this.ci37);
					dlcalc.this.i39.setText(dlcalc.this.ci39);
					dlcalc.this.a41.setText(dlcalc.this.ca41);
					dlcalc.this.bcde41.setText(dlcalc.this.cbcde41);
					dlcalc.this.f41.setText(dlcalc.this.cf41);
					dlcalc.this.ghij41.setText(dlcalc.this.cghij41);
					dlcalc.this.abcdefghij43.setText(dlcalc.this.cabcdefghij43);
					dlcalc.this.pack();
					int i = dlcalc.this.getWidth();
					int j = Math.min(dlcalc.this.getHeight(), 700);
					int k = dlcalc.this.center.x - i / 2, m = dlcalc.this.center.y - j / 2;
					dlcalc.this.setBounds(k, m, i, j);
					dlcalc.this.validate();
					dlcalc.this.repaint();
				}
				dlcalc.this.lstfcs.requestFocus();
				if (dlcalc.this.lstfcs == dlcalc.this.team1OversInnigsAtStartOfMatch) {
					System.out.println("Line 1661"+dlcalc.this.icrt);
					dlcalc.this.team1OversInnigsAtStartOfMatch.setCaretPosition(dlcalc.this.icrt);
				} else if (dlcalc.this.lstfcs == dlcalc.this.team1FinalScore) {
					System.out.println(dlcalc.this.icrt);
					dlcalc.this.team1FinalScore.setCaretPosition(dlcalc.this.icrt);
				} else if (dlcalc.this.lstfcs == dlcalc.this.g3) {
					dlcalc.this.g3.setCaretPosition(dlcalc.this.icrt);
				} else if (dlcalc.this.lstfcs == dlcalc.this.i39) {
					dlcalc.this.i39.setCaretPosition(dlcalc.this.icrt);
				} else {
					for (byte b = 0; b < dlcalc.this.nstprow; b++) {
						if (dlcalc.this.lstfcs == dlcalc.this.tbs[b]) {
							dlcalc.this.tbs[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.tcs[b]) {
							dlcalc.this.tcs[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.tc1s[b]) {
							dlcalc.this.tc1s[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.tds[b]) {
							dlcalc.this.tds[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.tgs[b]) {
							dlcalc.this.tgs[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.ths[b]) {
							dlcalc.this.ths[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.th1s[b]) {
							dlcalc.this.th1s[b].setCaretPosition(dlcalc.this.icrt);
						} else if (dlcalc.this.lstfcs == dlcalc.this.tis[b]) {
							dlcalc.this.tis[b].setCaretPosition(dlcalc.this.icrt);
						}
					}
				}
			}
		});

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 6 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.j36 = new JLabel(" ", 4);
		this.j36.setOpaque(false);
		this.j36.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.j36, this.c);
		this.jpmain.add(this.j36);

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.a37 = new JLabel(" ", 4);
		this.a37.setOpaque(false);
		this.a37.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.a37, this.c);
		this.jpmain.add(this.a37);

		this.c.gridwidth = 3;
		this.c.gridx = 1;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.bc37 = new JLabel("total overs available: ", 4);
		this.bc37.setFont(new Font("Serif", 0, 12));
		this.bc37.setOpaque(false);
		this.bc37.setBackground(Color.lightGray);
		this.bc37.setForeground(Color.black);
		this.gridbag.setConstraints(this.bc37, this.c);
		this.jpmain.add(this.bc37);

		this.c.gridwidth = 1;
		this.c.gridx = 4;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.d37 = new JLabel(" ", 0);
		this.d37.setFont(new Font("Serif", 0, 12));
		this.d37.setOpaque(true);
		this.d37.setBackground(ltgreen);
		this.d37.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, dkgreen));
		this.gridbag.setConstraints(this.d37, this.c);
		this.jpmain.add(this.d37);

		this.c.gridwidth = 3;
		this.c.gridx = 5;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ef37 = new JLabel(" ", 4);
		this.ef37.setOpaque(false);
		this.ef37.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.ef37, this.c);
		this.jpmain.add(this.ef37);

		this.c.gridwidth = 2;
		this.c.gridx = 8;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.gh37 = new JLabel("total overs available: ", 4);
		this.gh37.setFont(new Font("Serif", 0, 12));
		this.gh37.setOpaque(false);
		this.gh37.setBackground(Color.lightGray);
		this.gh37.setForeground(Color.black);
		this.gridbag.setConstraints(this.gh37, this.c);
		this.jpmain.add(this.gh37);

		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.i37 = new JLabel(" ", 0);
		this.i37.setFont(new Font("Serif", 0, 12));
		this.i37.setOpaque(true);
		this.i37.setBackground(ltgreen);
		this.i37.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, dkgreen));
		this.gridbag.setConstraints(this.i37, this.c);
		this.jpmain.add(this.i37);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.j37 = new JLabel(" ", 2);
		this.j37.setOpaque(false);
		this.j37.setBackground(Color.lightGray);
		this.j37.setForeground(ornge);
		this.j37.setFont(new Font("Serif", 0, 11));
		this.gridbag.setConstraints(this.j37, this.c);
		this.jpmain.add(this.j37);

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 8 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghij38 = new JLabel(" ", 0);
		this.abcdefghij38.setOpaque(false);
		this.abcdefghij38.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij38, this.c);
		this.jpmain.add(this.abcdefghij38);

		this.c.gridwidth = 6;
		this.c.gridx = 0;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcde39 = new JLabel(" ", 0);
		this.abcde39.setOpaque(false);
		this.abcde39.setBackground(Color.lightGray);
		this.abcde39.setForeground(Color.black);
		this.abcde39.setFont(new Font("SanSerif", 0, 11));
		this.gridbag.setConstraints(this.abcde39, this.c);
		this.jpmain.add(this.abcde39);

		this.c.gridwidth = 4;
		this.c.gridx = 6;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.fgh39 = new JLabel(
				"<html><p align=\"right\">Penalty runs awarded to Team 1&nbsp;<br>while Team 2 are batting:&nbsp;", 4);
		this.fgh39.setFont(new Font("Serif", 0, 12));
		this.fgh39.setForeground(dkpink);
		this.fgh39.setOpaque(false);
		this.fgh39.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.fgh39, this.c);
		this.jpmain.add(this.fgh39);

		this.c.fill = 0;
		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.i39 = new TextField(4);
		this.i39.setFont(new Font("Serif", 0, 14));
		this.i39.setBackground(Color.white);
		this.i39.setForeground(dkpink);
		this.gridbag.setConstraints(this.i39, this.c);
		this.jpmain.add(this.i39);
		this.i39.addTextListener(this);
		this.i39.addFocusListener(this);
		this.i39.addKeyListener(this);

		this.c.fill = 1;
		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.j39 = new JLabel(" ", 0);
		this.j39.setOpaque(false);
		this.j39.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.j39, this.c);
		this.jpmain.add(this.j39);

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 10 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghij40 = new JLabel(" ", 0);
		this.abcdefghij40.setOpaque(false);
		this.abcdefghij40.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij40, this.c);
		this.jpmain.add(this.abcdefghij40);

		this.c.gridwidth = 1;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 5.0D;
		this.a41 = new JLabel(" ", 4);
		this.a41.setFont(new Font("Serif", 1, 12));
		this.a41.setForeground(Color.red);
		this.a41.setOpaque(false);
		this.a41.setBackground(Color.lightGray);
		this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
		this.gridbag.setConstraints(this.a41, this.c);
		this.jpmain.add(this.a41);

		this.c.gridwidth = 4;
		this.c.gridheight = 1;
		this.c.gridx = 1;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.bcde41 = new JLabel(" ", 2);
		this.bcde41.setFont(new Font("Serif", 0, 12));
		this.bcde41.setForeground(Color.red);
		this.bcde41.setOpaque(false);
		this.bcde41.setBackground(Color.lightGray);
		this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
		this.gridbag.setConstraints(this.bcde41, this.c);
		this.jpmain.add(this.bcde41);

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 5;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.f41 = new JLabel(" ", 4);
		this.f41.setFont(new Font("Serif", 1, 12));
		this.f41.setForeground(Color.red);
		this.f41.setOpaque(false);
		this.f41.setBackground(Color.lightGray);
		this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
		this.gridbag.setConstraints(this.f41, this.c);
		this.jpmain.add(this.f41);

		this.c.gridwidth = 4;
		this.c.gridheight = 1;
		this.c.gridx = 7;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ghij41 = new JLabel(" ", 2);
		this.ghij41.setFont(new Font("Serif", 0, 12));
		this.ghij41.setForeground(Color.red);
		this.ghij41.setOpaque(false);
		this.ghij41.setBackground(Color.lightGray);
		this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
		this.gridbag.setConstraints(this.ghij41, this.c);
		this.jpmain.add(this.ghij41);

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 11;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel40 = new JLabel(" ", 0);
		jLabel40.setOpaque(false);
		jLabel40.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel40, this.c);
		this.jpmain.add(jLabel40);

		this.c.gridwidth = 3;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 12 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abc41a = new JLabel("create Par Score tables:", 0);
		this.abc41a.setFont(new Font("Serif", 0, 14));
		this.abc41a.setOpaque(false);
		this.abc41a.setBackground(Color.lightGray);
		if (this.bOBtble) {
			this.abc41a.setForeground(Color.black);
		} else {
			this.abc41a.setForeground(Color.gray);
		}
		this.gridbag.setConstraints(this.abc41a, this.c);
		this.jpmain.add(this.abc41a);

		this.c.gridwidth = 10;
		this.c.gridheight = 1;
		this.c.gridx = 3;
		this.c.gridy = 12 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.defghij41a = new JLabel(" ", 0);
		this.defghij41a.setFont(new Font("Serif", 0, 12));
		this.defghij41a.setOpaque(false);
		this.defghij41a.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.defghij41a, this.c);
		this.jpmain.add(this.defghij41a);

		this.c.gridwidth = 1;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.Otble = new JButton("over-by-over");
		this.Otble.setOpaque(false);
		this.Otble.setBackground(bcol);
		this.Otble.setFont(new Font("Serif", 0, 12));
		this.Otble.setPreferredSize(new Dimension(104, 27));
		this.gridbag.setConstraints(this.Otble, this.c);
		this.jpmain.add(this.Otble);
		this.Otble.addActionListener(this);
		this.Otble.setEnabled(false);

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 1;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.Btble = new JButton("ball-by-ball");
		this.Btble.setOpaque(false);
		this.Btble.setBackground(bcol);
		this.Btble.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.Btble, this.c);
		this.jpmain.add(this.Btble);
		this.Btble.addActionListener(this);
		this.Btble.setEnabled(false);

		this.c.gridwidth = 8;
		this.c.gridheight = 1;
		this.c.gridx = 3;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.defghi42 = new JLabel(" ", 0) {
			protected void paintComponent(Graphics param1Graphics) {
				Graphics2D graphics2D = (Graphics2D) param1Graphics;
				graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				GradientPaint gradientPaint = new GradientPaint(0.0F, 0.0F, getBackground(), 0.0F, getHeight(),
						getBackground());

				graphics2D.setPaint(gradientPaint);
				graphics2D.fillRect(0, 0, getWidth(), getHeight());

				super.paintComponent(param1Graphics);
			}
		};
		this.defghi42.setFont(new Font("SansSerif", 0, 11));
		this.defghi42.setVisible(false);
		this.defghi42.setBackground(Color.lightGray);
		this.defghi42.setForeground(blu1);
		this.gridbag.setConstraints(this.defghi42, this.c);
		this.jpmain.add(this.defghi42);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.RstAll = new JButton("reset input fields");
		this.RstAll.setOpaque(false);
		this.RstAll.setBackground(bcol);
		this.RstAll.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.RstAll, this.c);
		this.jpmain.add(this.RstAll);
		this.RstAll.addActionListener(this);

		this.c.gridwidth = 11;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 14 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghi42a = new JLabel(" ", 0);
		this.abcdefghi42a.setOpaque(false);
		this.abcdefghi42a.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghi42a, this.c);
		this.jpmain.add(this.abcdefghi42a);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 14 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ChngTyp = new JButton("change match type");
		this.ChngTyp.setOpaque(false);
		this.ChngTyp.setBackground(bcol);
		this.ChngTyp.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.ChngTyp, this.c);
		this.jpmain.add(this.ChngTyp);
		this.ChngTyp.addActionListener(this);

		this.c.gridwidth = 11;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 15 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghi42b = new JLabel(" ", 0);
		this.abcdefghi42b.setOpaque(false);
		this.abcdefghi42b.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghi42b, this.c);
		this.jpmain.add(this.abcdefghi42b);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 15 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.RptSum = new JButton("create DLS match report");
		this.RptSum.setOpaque(false);
		this.RptSum.setBackground(bcol);
		this.RptSum.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.RptSum, this.c);
		this.jpmain.add(this.RptSum);
		this.RptSum.addActionListener(this);
		this.RptSum.setEnabled(false);

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 16 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 100.0D;
		this.c.fill = 0;
		this.c.anchor = 25;
		this.abcdefghij43 = new JLabel(" ", 2);
		this.abcdefghij43.setFont(new Font("Serif", 0, 10));
		this.abcdefghij43.setOpaque(false);
		this.abcdefghij43.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij43, this.c);
		this.jpmain.add(this.abcdefghij43);
		this.c.fill = 1;
		this.c.anchor = 10;
		this.ltmp2 = new JLabel(" ", 0);
		this.ltmp2.setOpaque(false);
		this.ltmp2.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.ltmp2, this.c);
		this.jpmain.add(this.ltmp2);
	}

	public void draw1() {
		if (this.otblopen) {
			this.otblopen = false;
			this.otblfrm.setVisible(false);
		}
		if (this.oresopen) {
			this.oresopen = false;
			this.oresfrm.setVisible(false);
		}
		if (this.btblopen) {
			this.btblopen = false;
			this.btblfrm.setVisible(false);
		}
		if (this.bresopen) {
			this.bresopen = false;
			this.bresfrm.setVisible(false);
		}
		if (this.RSopen) {
			this.RSopen = false;
			this.RSfrm.setVisible(false);
		}
		if (this.bT2open) {
			this.T2trgf.removeWindowListener(this);
			this.T2trgf.dispose();
			this.bT2open = false;
			if (this.iT2trg < 0) {
				if (this.g3.getText().trim().indexOf("?") == 0) {
					this.g3.setText("");
				}
			} else if (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0) {
				this.tis[this.iT2trg].setText("");
			}
		}

		this.jpmain.removeAll();
		this.nstprow = 5;
		this.usrmx2 = false;
		this.usrrn1 = false;
		this.bslctd = false;
		for (byte b = 0; b < 30; b++) {
			for (byte b1 = 0; b1 < 8; b1++) {
				this.slctd[b][b1] = 0;
			}
		}

		draw0();
		
		
		
		
		
		
		
		
		
		
		
		

		if (this.mtyp == 3) {
			if (this.omtyp < this.optnum) {
				this.nommaxo = (new Integer(this.maxotyp[this.omtyp - 1])).intValue();
				this.team1OversInnigsAtStartOfMatch.setText(this.maxotyp[this.omtyp - 1]);
			} else {
				this.nommaxo = (new Integer(this.inpmax)).intValue();
				this.team1OversInnigsAtStartOfMatch.setText(this.inpmax);
			}
			this.team1FinalScore.requestFocus();
			this.lstfcs = this.team1FinalScore;
		} else if (this.mtyp == 2) {
			this.nommaxo = 20;
			this.team1OversInnigsAtStartOfMatch.setText("20");
			this.team1FinalScore.requestFocus();
			this.lstfcs = this.team1FinalScore;
		} else if (this.mtyp == 1) {
			this.nommaxo = 50;
			this.team1OversInnigsAtStartOfMatch.setText("50");
			this.team1FinalScore.requestFocus();
			this.lstfcs = this.team1FinalScore;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		this.icrt = 0;
		pack();
		validate();
	}

	public void draw2() {
		this.jpmain.remove(this.abcdefghij43);
		this.jpmain.remove(this.RstAll);
		this.jpmain.remove(this.defghi42);
		this.jpmain.remove(this.Btble);
		this.jpmain.remove(this.Otble);
		this.jpmain.remove(this.abc41a);
		this.jpmain.remove(this.defghij41a);
		this.jpmain.remove(this.ghij41);
		this.jpmain.remove(this.f41);
		this.jpmain.remove(this.bcde41);
		this.jpmain.remove(this.a41);
		this.jpmain.remove(this.abcdefghij40);
		this.jpmain.remove(this.j39);
		this.jpmain.remove(this.i39);
		this.jpmain.remove(this.fgh39);
		this.jpmain.remove(this.abcde39);
		this.jpmain.remove(this.abcdefghij38);
		this.jpmain.remove(this.j37);
		this.jpmain.remove(this.i37);
		this.jpmain.remove(this.gh37);
		this.jpmain.remove(this.ef37);
		this.jpmain.remove(this.d37);
		this.jpmain.remove(this.bc37);
		this.jpmain.remove(this.a37);
		this.jpmain.remove(this.j36);
		this.jpmain.remove(this.NewStpRow);
		this.jpmain.remove(this.a36);
		this.jpmain.remove(this.ltmp2);
		this.jpmain.remove(this.abcdefghi42a);
		this.jpmain.remove(this.abcdefghi42b);
		this.jpmain.remove(this.RptSum);
		this.jpmain.remove(this.ChngTyp);
		this.c.gridwidth = 1;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.c.gridx = 0;
		this.c.gridy = this.nstprow + 5;
		this.itmp = this.nstprow;
		this.ntmp = new Integer(this.itmp);
		this.las[this.nstprow - 1] = new JLabel(this.ntmp.toString(), 4);
		this.las[this.nstprow - 1].setFont(new Font("Serif", 0, 10));
		this.las[this.nstprow - 1].setOpaque(false);
		this.las[this.nstprow - 1].setBackground(Color.lightGray);
		this.las[this.nstprow - 1].setForeground(Color.black);
		this.gridbag.setConstraints(this.las[this.nstprow - 1], this.c);
		this.jpmain.add(this.las[this.nstprow - 1]);
		this.c.gridx = 1;
		this.tbs[this.nstprow - 1] = new TextField(4);
		this.tbs[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tbs[this.nstprow - 1], this.c);
		this.jpmain.add(this.tbs[this.nstprow - 1]);
		this.tbs[this.nstprow - 1].addTextListener(this);
		this.tbs[this.nstprow - 1].addFocusListener(this);
		this.tbs[this.nstprow - 1].addKeyListener(this);
		this.tbs[this.nstprow - 1].addMouseListener(this);
		this.tbs[this.nstprow - 1].addMouseMotionListener(this);
		this.tbs[this.nstprow - 1].setBackground(Color.white);
		this.tbs[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 2;
		this.tc1s[this.nstprow - 1] = new TextField(4);
		this.tc1s[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tc1s[this.nstprow - 1], this.c);
		this.jpmain.add(this.tc1s[this.nstprow - 1]);
		this.tc1s[this.nstprow - 1].addTextListener(this);
		this.tc1s[this.nstprow - 1].addFocusListener(this);
		this.tc1s[this.nstprow - 1].addKeyListener(this);
		this.tc1s[this.nstprow - 1].addMouseListener(this);
		this.tc1s[this.nstprow - 1].addMouseMotionListener(this);
		this.tc1s[this.nstprow - 1].setBackground(Color.white);
		this.tc1s[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 3;
		this.tcs[this.nstprow - 1] = new TextField(4);
		this.tcs[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tcs[this.nstprow - 1], this.c);
		this.jpmain.add(this.tcs[this.nstprow - 1]);
		this.tcs[this.nstprow - 1].addTextListener(this);
		this.tcs[this.nstprow - 1].addFocusListener(this);
		this.tcs[this.nstprow - 1].addKeyListener(this);
		this.tcs[this.nstprow - 1].addMouseListener(this);
		this.tcs[this.nstprow - 1].addMouseMotionListener(this);
		this.tcs[this.nstprow - 1].setBackground(Color.white);
		this.tcs[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 4;
		this.tds[this.nstprow - 1] = new TextField(4);
		this.tds[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tds[this.nstprow - 1], this.c);
		this.jpmain.add(this.tds[this.nstprow - 1]);
		this.tds[this.nstprow - 1].addTextListener(this);
		this.tds[this.nstprow - 1].addFocusListener(this);
		this.tds[this.nstprow - 1].addKeyListener(this);
		this.tds[this.nstprow - 1].addMouseListener(this);
		this.tds[this.nstprow - 1].addMouseMotionListener(this);
		this.tds[this.nstprow - 1].setBackground(Color.white);
		this.tds[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 5;
		this.les[this.nstprow - 1] = new JLabel(" ", 4);
		this.les[this.nstprow - 1].setOpaque(false);
		this.les[this.nstprow - 1].setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.les[this.nstprow - 1], this.c);
		this.jpmain.add(this.les[this.nstprow - 1]);
		this.c.gridx = 6;
		this.lfs[this.nstprow - 1] = new JLabel(this.ntmp.toString(), 4);
		this.lfs[this.nstprow - 1].setFont(new Font("Serif", 0, 10));
		this.lfs[this.nstprow - 1].setOpaque(false);
		this.lfs[this.nstprow - 1].setBackground(Color.lightGray);
		this.lfs[this.nstprow - 1].setForeground(Color.black);
		this.gridbag.setConstraints(this.lfs[this.nstprow - 1], this.c);
		this.jpmain.add(this.lfs[this.nstprow - 1]);
		this.c.gridx = 7;
		this.tgs[this.nstprow - 1] = new TextField(4);
		this.tgs[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tgs[this.nstprow - 1], this.c);
		this.jpmain.add(this.tgs[this.nstprow - 1]);
		this.tgs[this.nstprow - 1].addTextListener(this);
		this.tgs[this.nstprow - 1].addFocusListener(this);
		this.tgs[this.nstprow - 1].addKeyListener(this);
		this.tgs[this.nstprow - 1].addMouseListener(this);
		this.tgs[this.nstprow - 1].addMouseMotionListener(this);
		this.tgs[this.nstprow - 1].setBackground(Color.white);
		this.tgs[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 8;
		this.th1s[this.nstprow - 1] = new TextField(4);
		this.th1s[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.th1s[this.nstprow - 1], this.c);
		this.jpmain.add(this.th1s[this.nstprow - 1]);
		this.th1s[this.nstprow - 1].addTextListener(this);
		this.th1s[this.nstprow - 1].addFocusListener(this);
		this.th1s[this.nstprow - 1].addKeyListener(this);
		this.th1s[this.nstprow - 1].addMouseListener(this);
		this.th1s[this.nstprow - 1].addMouseMotionListener(this);
		this.th1s[this.nstprow - 1].setBackground(Color.white);
		this.th1s[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 9;
		this.ths[this.nstprow - 1] = new TextField(4);
		this.ths[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.ths[this.nstprow - 1], this.c);
		this.jpmain.add(this.ths[this.nstprow - 1]);
		this.ths[this.nstprow - 1].addTextListener(this);
		this.ths[this.nstprow - 1].addFocusListener(this);
		this.ths[this.nstprow - 1].addKeyListener(this);
		this.ths[this.nstprow - 1].addMouseListener(this);
		this.ths[this.nstprow - 1].addMouseMotionListener(this);
		this.ths[this.nstprow - 1].setBackground(Color.white);
		this.ths[this.nstprow - 1].setForeground(Color.black);
		this.c.gridx = 10;
		this.tis[this.nstprow - 1] = new TextField(4);
		this.tis[this.nstprow - 1].setFont(new Font("Serif", 0, 14));
		this.gridbag.setConstraints(this.tis[this.nstprow - 1], this.c);
		this.jpmain.add(this.tis[this.nstprow - 1]);
		this.tis[this.nstprow - 1].addTextListener(this);
		this.tis[this.nstprow - 1].addFocusListener(this);
		this.tis[this.nstprow - 1].addKeyListener(this);
		this.tis[this.nstprow - 1].addMouseListener(this);
		this.tis[this.nstprow - 1].addMouseMotionListener(this);
		this.tis[this.nstprow - 1].setBackground(Color.white);
		this.tis[this.nstprow - 1].setForeground(Color.black);
		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.ljs[this.nstprow - 1] = new JLabel(" ", 4);
		this.ljs[this.nstprow - 1].setOpaque(false);
		this.ljs[this.nstprow - 1].setBackground(Color.lightGray);
		this.ljs[this.nstprow - 1].setForeground(ornge);
		this.ljs[this.nstprow - 1].setFont(new Font("Serif", 0, 11));
		this.gridbag.setConstraints(this.ljs[this.nstprow - 1], this.c);
		this.jpmain.add(this.ljs[this.nstprow - 1]);
		if (this.nstprow < this.maxrows) {
			this.c.gridwidth = 1;
			this.c.gridx = 0;
			this.c.gridy = 6 + this.nstprow;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.a36 = new JLabel(" ", 4);
			this.a36.setOpaque(false);
			this.a36.setBackground(Color.lightGray);
			this.gridbag.setConstraints(this.a36, this.c);
			this.jpmain.add(this.a36);

			this.c.gridwidth = 10;
			this.c.gridx = 1;
			this.c.gridy = 6 + this.nstprow;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.NewStpRow = new JButton("add further stoppage row");
			this.NewStpRow.setFont(new Font("Serif", 0, 12));
			this.NewStpRow.setBackground(bcol);
			this.gridbag.setConstraints(this.NewStpRow, this.c);
			this.jpmain.add(this.NewStpRow);
			this.NewStpRow.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent param1ActionEvent) {
					System.out.println("2411NewStpRow");
					dlcalc.this.nstprow++;
					if (dlcalc.this.nstprow < dlcalc.this.maxrows + 1) {
						dlcalc.this.cd37 = dlcalc.this.d37.getText();
						dlcalc.this.ci37 = dlcalc.this.i37.getText();
						dlcalc.this.ci39 = dlcalc.this.i39.getText();
						dlcalc.this.ca41 = dlcalc.this.a41.getText();
						dlcalc.this.cbcde41 = dlcalc.this.bcde41.getText();
						dlcalc.this.cf41 = dlcalc.this.f41.getText();
						dlcalc.this.cghij41 = dlcalc.this.ghij41.getText();
						dlcalc.this.cabcdefghij43 = dlcalc.this.abcdefghij43.getText();
						dlcalc.this.bOBtble = dlcalc.this.Otble.isEnabled();
						dlcalc.this.bRSbtn = dlcalc.this.RptSum.isEnabled();
						dlcalc.this.draw2();
						dlcalc.this.d37.setText(dlcalc.this.cd37);
						dlcalc.this.i37.setText(dlcalc.this.ci37);
						dlcalc.this.i39.setText(dlcalc.this.ci39);
						dlcalc.this.a41.setText(dlcalc.this.ca41);
						dlcalc.this.bcde41.setText(dlcalc.this.cbcde41);
						dlcalc.this.f41.setText(dlcalc.this.cf41);
						dlcalc.this.ghij41.setText(dlcalc.this.cghij41);
						dlcalc.this.abcdefghij43.setText(dlcalc.this.cabcdefghij43);
						dlcalc.this.pack();
						int i = dlcalc.this.getWidth();
						int j = Math.min(dlcalc.this.getHeight(), 700);
						int k = dlcalc.this.center.x - i / 2, m = dlcalc.this.center.y - j / 2;
						dlcalc.this.setBounds(k, m, i, j);
						dlcalc.this.validate();
						dlcalc.this.repaint();
					}
					dlcalc.this.lstfcs.requestFocus();
					if (dlcalc.this.lstfcs == dlcalc.this.team1OversInnigsAtStartOfMatch) {
						dlcalc.this.team1OversInnigsAtStartOfMatch.setCaretPosition(dlcalc.this.icrt);
					} else if (dlcalc.this.lstfcs == dlcalc.this.team1FinalScore) {
						dlcalc.this.team1FinalScore.setCaretPosition(dlcalc.this.icrt);
					} else if (dlcalc.this.lstfcs == dlcalc.this.g3) {
						dlcalc.this.g3.setCaretPosition(dlcalc.this.icrt);
					} else if (dlcalc.this.lstfcs == dlcalc.this.i39) {
						dlcalc.this.i39.setCaretPosition(dlcalc.this.icrt);
					} else {
						for (byte b = 0; b < dlcalc.this.nstprow; b++) {
							if (dlcalc.this.lstfcs == dlcalc.this.tbs[b]) {
								dlcalc.this.tbs[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.tc1s[b]) {
								dlcalc.this.tc1s[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.tds[b]) {
								dlcalc.this.tcs[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.tds[b]) {
								dlcalc.this.tds[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.tgs[b]) {
								dlcalc.this.tgs[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.ths[b]) {
								dlcalc.this.ths[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.th1s[b]) {
								dlcalc.this.th1s[b].setCaretPosition(dlcalc.this.icrt);
							} else if (dlcalc.this.lstfcs == dlcalc.this.tis[b]) {
								dlcalc.this.tis[b].setCaretPosition(dlcalc.this.icrt);
							}
						}
					}
				}
			});

			this.c.gridwidth = 2;
			this.c.gridx = 11;
			this.c.gridy = 6 + this.nstprow;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			this.j36 = new JLabel(" ", 4);
			this.j36.setOpaque(false);
			this.j36.setBackground(Color.lightGray);
			this.gridbag.setConstraints(this.j36, this.c);
			this.jpmain.add(this.j36);
		} else {
			this.c.gridwidth = 13;
			this.c.gridx = 0;
			this.c.gridy = 6 + this.nstprow;
			this.c.weightx = 1.0D;
			this.c.weighty = 1.0D;
			JLabel jLabel1 = new JLabel(" ", 0);
			jLabel1.setOpaque(false);
			jLabel1.setBackground(Color.lightGray);
			this.gridbag.setConstraints(jLabel1, this.c);
			this.jpmain.add(jLabel1);
		}

		this.c.gridwidth = 1;
		this.c.gridx = 0;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.a37 = new JLabel(" ", 4);
		this.a37.setOpaque(false);
		this.a37.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.a37, this.c);
		this.jpmain.add(this.a37);

		this.c.gridwidth = 3;
		this.c.gridx = 1;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.bc37 = new JLabel("total overs available: ", 4);
		this.bc37.setFont(new Font("Serif", 0, 12));
		this.bc37.setOpaque(false);
		this.bc37.setBackground(Color.lightGray);
		this.bc37.setForeground(Color.black);
		this.gridbag.setConstraints(this.bc37, this.c);
		this.jpmain.add(this.bc37);

		this.c.gridwidth = 1;
		this.c.gridx = 4;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.d37 = new JLabel(" ", 0);
		this.d37.setFont(new Font("Serif", 0, 12));
		this.d37.setOpaque(true);
		this.d37.setBackground(ltgreen);
		this.d37.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, dkgreen));
		this.gridbag.setConstraints(this.d37, this.c);
		this.jpmain.add(this.d37);

		this.c.gridwidth = 3;
		this.c.gridx = 5;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ef37 = new JLabel(" ", 4);
		this.ef37.setOpaque(false);
		this.ef37.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.ef37, this.c);
		this.jpmain.add(this.ef37);

		this.c.gridwidth = 2;
		this.c.gridx = 8;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.gh37 = new JLabel("total overs available: ", 4);
		this.gh37.setFont(new Font("Serif", 0, 12));
		this.gh37.setOpaque(false);
		this.gh37.setBackground(Color.lightGray);
		this.gh37.setForeground(Color.black);
		this.gridbag.setConstraints(this.gh37, this.c);
		this.jpmain.add(this.gh37);

		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.i37 = new JLabel(" ", 0);
		this.i37.setFont(new Font("Serif", 0, 12));
		this.i37.setOpaque(true);
		this.i37.setBackground(ltgreen);
		this.i37.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, dkgreen));
		this.gridbag.setConstraints(this.i37, this.c);
		this.jpmain.add(this.i37);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 7 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.j37 = new JLabel(" ", 2);
		this.j37.setOpaque(false);
		this.j37.setBackground(Color.lightGray);
		this.j37.setForeground(ornge);
		this.j37.setFont(new Font("Serif", 0, 11));
		this.gridbag.setConstraints(this.j37, this.c);
		this.jpmain.add(this.j37);

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 8 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghij38 = new JLabel(" ", 0);
		this.abcdefghij38.setOpaque(false);
		this.abcdefghij38.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij38, this.c);
		this.jpmain.add(this.abcdefghij38);

		this.c.gridwidth = 6;
		this.c.gridx = 0;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcde39 = new JLabel(" ", 0);
		this.abcde39.setOpaque(false);
		this.abcde39.setBackground(Color.lightGray);
		this.abcde39.setForeground(Color.black);
		this.abcde39.setFont(new Font("SanSerif", 0, 11));
		this.gridbag.setConstraints(this.abcde39, this.c);
		this.jpmain.add(this.abcde39);

		this.c.gridwidth = 4;
		this.c.gridx = 6;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.fgh39 = new JLabel(
				"<html><p align=\"right\">Penalty runs awarded to Team 1&nbsp;<br>while Team 2 are batting:&nbsp;", 4);
		this.fgh39.setFont(new Font("Serif", 0, 12));
		this.fgh39.setForeground(dkpink);
		this.fgh39.setOpaque(false);
		this.fgh39.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.fgh39, this.c);
		this.jpmain.add(this.fgh39);

		this.c.fill = 0;
		this.c.gridwidth = 1;
		this.c.gridx = 10;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.i39 = new TextField(4);
		this.i39.setFont(new Font("Serif", 0, 14));
		this.i39.setBackground(Color.white);
		this.i39.setForeground(dkpink);
		this.gridbag.setConstraints(this.i39, this.c);
		this.jpmain.add(this.i39);
		this.i39.addTextListener(this);
		this.i39.addFocusListener(this);
		this.i39.addKeyListener(this);

		this.c.fill = 1;
		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 9 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.j39 = new JLabel(" ", 0);
		this.j39.setOpaque(false);
		this.j39.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.j39, this.c);
		this.jpmain.add(this.j39);

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 10 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghij40 = new JLabel(" ", 0);
		this.abcdefghij40.setOpaque(false);
		this.abcdefghij40.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij40, this.c);
		this.jpmain.add(this.abcdefghij40);

		this.c.gridwidth = 1;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 5.0D;
		this.a41 = new JLabel(" ", 4);
		this.a41.setFont(new Font("Serif", 1, 12));
		this.a41.setForeground(Color.red);
		this.a41.setOpaque(false);
		this.a41.setBackground(Color.lightGray);
		this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
		this.gridbag.setConstraints(this.a41, this.c);
		this.jpmain.add(this.a41);

		this.c.gridwidth = 4;
		this.c.gridheight = 1;
		this.c.gridx = 1;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.bcde41 = new JLabel(" 2710", 2);
		this.bcde41.setFont(new Font("Serif", 0, 12));
		this.bcde41.setForeground(Color.red);
		this.bcde41.setOpaque(false);
		this.bcde41.setBackground(Color.lightGray);
		this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
		this.gridbag.setConstraints(this.bcde41, this.c);
		this.jpmain.add(this.bcde41);

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 5;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.f41 = new JLabel("2725", 4);
		this.f41.setFont(new Font("Serif", 1, 12));
		this.f41.setForeground(Color.red);
		this.f41.setOpaque(false);
		this.f41.setBackground(Color.lightGray);
		this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
		this.gridbag.setConstraints(this.f41, this.c);
		this.jpmain.add(this.f41);

		this.c.gridwidth = 4;
		this.c.gridheight = 1;
		this.c.gridx = 7;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ghij41 = new JLabel("2740", 2);
		this.ghij41.setFont(new Font("Serif", 0, 12));
		this.ghij41.setForeground(Color.red);
		this.ghij41.setOpaque(false);
		this.ghij41.setBackground(Color.lightGray);
		this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
		this.gridbag.setConstraints(this.ghij41, this.c);
		this.jpmain.add(this.ghij41);

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 11;
		this.c.gridy = 11 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		JLabel jLabel = new JLabel(" ", 0);
		jLabel.setOpaque(false);
		jLabel.setBackground(Color.lightGray);
		this.gridbag.setConstraints(jLabel, this.c);
		this.jpmain.add(jLabel);

		this.c.gridwidth = 3;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 12 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abc41a = new JLabel("create Par Score tables:", 0);
		this.abc41a.setFont(new Font("Serif", 0, 14));
		this.abc41a.setOpaque(false);
		if (this.bOBtble) {
			this.abc41a.setForeground(Color.black);
		} else {
			this.abc41a.setForeground(Color.gray);
		}
		this.gridbag.setConstraints(this.abc41a, this.c);
		this.jpmain.add(this.abc41a);

		this.c.gridwidth = 10;
		this.c.gridheight = 1;
		this.c.gridx = 3;
		this.c.gridy = 12 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.defghij41a = new JLabel(" ", 0);
		this.defghij41a.setFont(new Font("Serif", 0, 12));
		this.defghij41a.setOpaque(false);
		this.defghij41a.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.defghij41a, this.c);
		this.jpmain.add(this.defghij41a);

		this.c.gridwidth = 1;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.Otble = new JButton("over-by-over");
		this.Otble.setOpaque(false);
		this.Otble.setBackground(bcol);
		this.Otble.setFont(new Font("Serif", 0, 12));
		this.Otble.setPreferredSize(new Dimension(104, 27));
		this.gridbag.setConstraints(this.Otble, this.c);
		this.jpmain.add(this.Otble);
		this.Otble.addActionListener(this);
		if (this.bOBtble) {
			this.Otble.setEnabled(true);
		} else {
			this.Otble.setEnabled(false);
		}

		this.c.gridwidth = 2;
		this.c.gridheight = 1;
		this.c.gridx = 1;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.Btble = new JButton("ball-by-ball");
		this.Btble.setOpaque(false);
		this.Btble.setBackground(bcol);
		this.Btble.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.Btble, this.c);
		this.jpmain.add(this.Btble);
		this.Btble.addActionListener(this);
		if (this.bOBtble) {
			this.Btble.setEnabled(true);
		} else {
			this.Btble.setEnabled(false);
		}

		this.c.gridwidth = 8;
		this.c.gridheight = 1;
		this.c.gridx = 3;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.defghi42 = new JLabel(" ", 0);
		this.defghi42.setFont(new Font("SansSerif", 0, 11));
		this.defghi42.setOpaque(false);
		this.defghi42.setBackground(Color.lightGray);
		this.defghi42.setForeground(blu1);
		this.gridbag.setConstraints(this.defghi42, this.c);
		this.jpmain.add(this.defghi42);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 13 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.RstAll = new JButton("reset input fields");
		this.RstAll.setOpaque(false);
		this.RstAll.setBackground(bcol);
		this.RstAll.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.RstAll, this.c);
		this.jpmain.add(this.RstAll);
		this.RstAll.addActionListener(this);

		this.c.gridwidth = 11;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 14 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghi42a = new JLabel(" ", 0);
		this.abcdefghi42a.setOpaque(false);
		this.abcdefghi42a.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghi42a, this.c);
		this.jpmain.add(this.abcdefghi42a);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 14 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.ChngTyp = new JButton("change match type");
		this.ChngTyp.setOpaque(false);
		this.ChngTyp.setBackground(bcol);
		this.ChngTyp.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.ChngTyp, this.c);
		this.jpmain.add(this.ChngTyp);
		this.ChngTyp.addActionListener(this);

		this.c.gridwidth = 11;
		this.c.gridheight = 1;
		this.c.gridx = 0;
		this.c.gridy = 15 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.abcdefghi42b = new JLabel(" ", 0);
		this.abcdefghi42b.setOpaque(false);
		this.abcdefghi42b.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghi42b, this.c);
		this.jpmain.add(this.abcdefghi42b);

		this.c.gridwidth = 2;
		this.c.gridx = 11;
		this.c.gridy = 15 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 1.0D;
		this.RptSum = new JButton("create DLS match report");
		this.RptSum.setOpaque(false);
		this.RptSum.setBackground(bcol);
		this.RptSum.setFont(new Font("Serif", 0, 12));
		this.gridbag.setConstraints(this.RptSum, this.c);
		this.jpmain.add(this.RptSum);
		this.RptSum.addActionListener(this);
		if (this.bRSbtn) {
			this.RptSum.setEnabled(true);
		} else {
			this.RptSum.setEnabled(false);
		}

		this.c.gridwidth = 13;
		this.c.gridx = 0;
		this.c.gridy = 16 + this.nstprow;
		this.c.weightx = 1.0D;
		this.c.weighty = 100.0D;
		this.c.fill = 0;
		this.c.anchor = 25;
		this.abcdefghij43 = new JLabel(" ", 2);
		this.abcdefghij43.setFont(new Font("Serif", 0, 10));
		this.abcdefghij43.setOpaque(false);
		this.abcdefghij43.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.abcdefghij43, this.c);
		this.jpmain.add(this.abcdefghij43);
		this.c.fill = 1;
		this.c.anchor = 10;
		this.ltmp2 = new JLabel(" ", 0);
		this.ltmp2.setOpaque(false);
		this.ltmp2.setBackground(Color.lightGray);
		this.gridbag.setConstraints(this.ltmp2, this.c);
		this.jpmain.add(this.ltmp2);
	}

	
	public void odi50Min20(){
		System.out.println("ODI -first screen");
		this.bsplash = false;
		this.team1OversInnigsAtStartOfMatch.setText("50");
		this.minover = 20;
	
		
	}
	
	public boolean chkOdB(String paramString) {
		int i = paramString.indexOf(".");
		boolean bool = true;
		if (i < 0) {
			bool = false;
		} else {
			if (i == paramString.length() - 1) {
				bool = false;
			}
			if (i == paramString.length() - 2) {
				String str = paramString.substring(i + 1);
				Integer integer = Integer.valueOf(str);
				int j = integer.intValue();
				if ((((j > -1) ? 1 : 0) & ((j < 7) ? 1 : 0)) != 0) {
					bool = false;
				}
			}
		}
		return bool;
	}

	public double odbTodec(double paramDouble) {
		double d1 = Math.floor(paramDouble);
		double d2 = paramDouble - Math.floor(paramDouble);
		return d1 + d2 / 0.6D;
	}

	public String decToodb(double paramDouble) {
		String str2;
		int i = (int) Math.floor(paramDouble);
		int j = (int) Math.round(6.0D * (paramDouble - Math.floor(paramDouble)));
		if (j == 6) {
			j = 0;
			i++;
		}
		Integer integer2 = new Integer(j);
		String str1 = integer2.toString();
		Integer integer1 = new Integer(i);
		if (j == 0) {
			str2 = integer1.toString();
		} else {
			str2 = integer1.toString();
			str2 = str2 + "." + str1;
		}
		return str2;
	}

	public String parscore(double paramDouble, int paramInt) {
		double d1 = this.Fw[paramInt];
		double d2 = this.nw[paramInt];
		int j = (int) Math.round(this.adjfct * this.z0 * d1 * Math.pow(this.lmbfct, d2 + 1.0D) * (1.0D
				- Math.exp(-paramDouble * this.bb * gufun(paramDouble, this.lmbfct) / d1 * Math.pow(this.lmbfct, d2))));
		int i = this.trgt - 1 - j;
		if ((((this.nb4 == 0) ? 1 : 0) & ((i < 0) ? 1 : 0)) != 0)
			i = 0;
		Integer integer = new Integer(i);
		return integer.toString();
	}

	public String resrem(double paramDouble1, int paramInt, double paramDouble2) {
		String str;
		double d4 = this.nb4;
		if (this.nb4 == 0)
			d4 = 1.0D;
		double d1 = this.Fw[paramInt];
		double d2 = this.nw[paramInt];
		int i = (int) Math.round(this.adjfct * this.z0 * d1 * Math.pow(this.lmbfct, d2 + 1.0D) * (1.0D - Math
				.exp(-paramDouble1 * this.bb * gufun(paramDouble1, this.lmbfct) / d1 * Math.pow(this.lmbfct, d2))));
		double d3 = i * paramDouble2 / d4;
		int j = (int) Math.floor(d3 * 100.0D);
		int k = (int) Math.round(d3 * 10000.0D) - j * 100;
		if (k > 99) {
			k = 0;
			j++;
		}
		if (k < 10) {
			str = "" + j + ".0" + k;
		} else {
			str = "" + j + "." + k;
		}
		return str;
	}

	public double resR1() {
		int i = (int) Math.round(this.adjfct * this.z0 * Math.pow(this.lmbfct, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-50.0D * this.bb / Math.pow(this.lmbfct, this.nw[0]))));
		return this.nb4 / i;
	}

	public double adjfun(double paramDouble) {
		double d2 = this.nb3;
		double d3 = this.nb4;
		double d1 = this.z0 * Math.pow(paramDouble, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d2 * this.bb * gufun(d2, paramDouble) / Math.pow(paramDouble, this.nw[0])));
		double d4 = d2;
		double d5 = d2;
		for (byte b = 0; b < this.nstprow; b++) {
			if ((((this.impty[b][0] == 0) ? 1 : 0) & ((this.ncs[b + 1] < 10) ? 1 : 0)) != 0) {
				int i = this.ncs[b + 1];
				double d6 = this.Fw[i];
				double d7 = this.nw[i];
				d5 = d4 - this.dbsd[b + 1];
				d1 -= this.z0 * d6 * Math.pow(paramDouble, d7 + 1.0D)
						* (1.0D - Math.exp(-d5 * this.bb * gufun(d5, paramDouble) / d6 * Math.pow(paramDouble, d7)));
				d5 -= this.ddsd[b + 1];
				d4 -= this.ddsd[b + 1];
				d1 += this.z0 * d6 * Math.pow(paramDouble, d7 + 1.0D)
						* (1.0D - Math.exp(-d5 * this.bb * gufun(d5, paramDouble) / d6 * Math.pow(paramDouble, d7)));
			}
		}
		if (this.nb4 == 0)
			d3 = 1.0D;
		return d3 / d1;
	}

	public int trgfun(double paramDouble1, double paramDouble2) {
		double d1 = this.ng3;
		int i = (int) Math.round(paramDouble1 * this.z0 * Math.pow(paramDouble2, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d1 * this.bb * gufun(d1, paramDouble2) / Math.pow(paramDouble2, this.nw[0]))));
		int j = i;
		double d2 = d1;
		double d3 = d1;
		for (byte b = 0; b < this.nstprow; b++) {
			if (this.impty[b + 30][0] == 0) {
				int k = this.nhs[b + 1];
				if (k < 10) {
					double d4 = this.Fw[k];
					double d5 = this.nw[k];
					d3 = d2 - this.dgsd[b + 1];
					i = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					j -= i;
					d3 -= this.disd[b + 1];
					d2 -= this.disd[b + 1];
					i = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					j += i;
				}
			}
		}
		if ((((this.nb4 == 0) ? 1 : 0) & ((j > 0) ? 1 : 0)) != 0)
			j--;
		j = j + 1 + this.ni39;
		return j;
	}

	public int trgfuntst1(double paramDouble1, double paramDouble2, int paramInt) {
		double d1 = this.ng3;
		int j = (int) Math.round(paramDouble1 * this.z0 * Math.pow(paramDouble2, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d1 * this.bb * gufun(d1, paramDouble2) / Math.pow(paramDouble2, this.nw[0]))));
		int i = j;
		double d2 = d1;
		double d3 = d1;
		for (byte b = 0; b < paramInt; b++) {
			if (this.impty[b + 30][0] == 0) {
				int k = this.nhs[b + 1];
				if (k < 10) {
					double d4 = this.Fw[k];
					double d5 = this.nw[k];
					d3 = d2 - this.dgsd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i -= j;
					d3 -= this.disd[b + 1];
					d2 -= this.disd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i += j;
				}
			}
		}
		if ((((this.nb4 == 0) ? 1 : 0) & ((i > 0) ? 1 : 0)) != 0)
			i--;
		i = i + 1 + this.ni39;
		return i;
	}

	public int parfuntst1(double paramDouble1, double paramDouble2, int paramInt) {
		double d1 = this.ng3;
		int j = (int) Math.round(paramDouble1 * this.z0 * Math.pow(paramDouble2, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d1 * this.bb * gufun(d1, paramDouble2) / Math.pow(paramDouble2, this.nw[0]))));
		int i = j;
		double d2 = d1;
		double d3 = d1;
		for (byte b = 0; b < paramInt; b++) {
			if (this.impty[b + 30][0] == 0) {
				int k = this.nhs[b + 1];
				if (k < 10) {
					double d4 = this.Fw[k];
					double d5 = this.nw[k];
					d3 = d2 - this.dgsd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i -= j;
					d3 -= this.disd[b + 1];
					d2 -= this.disd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i += j;
				}
			}
		}
		if ((((this.nb4 == 0) ? 1 : 0) & ((i > 0) ? 1 : 0)) != 0)
			i--;
		i = i - j + this.ni39;
		return i;
	}

	public int trgfuntst2(double paramDouble1, double paramDouble2, int paramInt) {
		double d1 = this.ng3;
		int j = (int) Math.round(paramDouble1 * this.z0 * Math.pow(paramDouble2, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d1 * this.bb * gufun(d1, paramDouble2) / Math.pow(paramDouble2, this.nw[0]))));
		int i = j;
		double d2 = d1;
		double d3 = d1;
		for (byte b = 0; b < paramInt - 1; b++) {
			if (this.impty[b + 30][0] == 0) {
				int k = this.nhs[b + 1];
				if (k < 10) {
					double d4 = this.Fw[k];
					double d5 = this.nw[k];
					d3 = d2 - this.dgsd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i -= j;
					d3 -= this.disd[b + 1];
					d2 -= this.disd[b + 1];
					j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D) * (1.0D
							- Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
					i += j;
				}
			}
		}
		if (this.impty[paramInt + 29][0] == 0) {
			int k = this.nhs[paramInt];
			if (k < 10) {
				double d4 = this.Fw[k];
				double d5 = this.nw[k];
				d3 = d2 - this.dgsd[paramInt];
				j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D)
						* (1.0D - Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
				i -= j;
				d3 = d3 - Math.ceil(this.disd[paramInt]) + 1.0D;
				d2 = d2 - Math.ceil(this.disd[paramInt]) + 1.0D;
				j = (int) Math.round(paramDouble1 * this.z0 * d4 * Math.pow(paramDouble2, d5 + 1.0D)
						* (1.0D - Math.exp(-d3 * this.bb * gufun(d3, paramDouble2) / d4 * Math.pow(paramDouble2, d5))));
				i += j;
			}
		}
		if ((((this.nb4 == 0) ? 1 : 0) & ((i > 0) ? 1 : 0)) != 0)
			i--;
		i = i + 1 + this.ni39;
		return i;
	}

	public double lmbfunpr(double paramDouble, int paramInt) {
		double d2 = this.nb3;
		double d1 = this.lmbdastar;
		if (this.nb3 > 0) {
			double d3 = 0.0D;
			double d5 = this.z0 * Math.pow(d1, this.nw[0] + 1.0D)
					* (1.0D - Math.exp(-d2 * this.bb * gufun(d2, d1) / Math.pow(d1, this.nw[0])));
			double d4 = d5 - paramDouble;
			double d6 = d2;
			double d7 = d2;
			byte b;
			for (b = 0; b < paramInt; b++) {
				if ((((this.impty[b][0] == 0) ? 1 : 0) & ((this.ncs[b + 1] < 10) ? 1 : 0)) != 0) {
					int i = this.ncs[b + 1];
					double d8 = this.Fw[i];
					double d9 = this.nw[i];
					d7 = d6 - this.dbsd[b + 1];
					d4 -= this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
							* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
					d7 -= this.ddsd[b + 1];
					d6 -= this.ddsd[b + 1];
					d4 += this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
							* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
				}
			}
			if ((((this.impty[paramInt][0] == 0) ? 1 : 0) & ((this.ncs[paramInt + 1] < 10) ? 1 : 0)) != 0) {
				int i = this.ncs[paramInt + 1];
				double d8 = this.Fw[i];
				double d9 = this.nw[i];
				d7 = d6 - this.dbsd[paramInt + 1];
				d4 -= this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
						* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
			}
			if (d4 < 0.0D) {
				while (true) {
					if ((((d4 < 0.0D) ? 1 : 0) & ((d1 < this.lmbcap) ? 1 : 0)) != 0) {
						d1 += this.stpint;
						d3 = d4;
						d5 = this.z0 * Math.pow(d1, this.nw[0] + 1.0D)
								* (1.0D - Math.exp(-d2 * this.bb * gufun(d2, d1) / Math.pow(d1, this.nw[0])));
						d4 = d5 - paramDouble;
						d6 = d2;
						d7 = d2;
						for (b = 0; b < paramInt; b++) {
							if ((((this.impty[b][0] == 0) ? 1 : 0) & ((this.ncs[b + 1] < 10) ? 1 : 0)) != 0) {
								int i = this.ncs[b + 1];
								double d8 = this.Fw[i];
								double d9 = this.nw[i];
								d7 = d6 - this.dbsd[b + 1];
								d4 -= this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
										* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
								d7 -= this.ddsd[b + 1];
								d6 -= this.ddsd[b + 1];
								d4 += this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
										* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
							}
						}
						if ((((this.impty[paramInt][0] == 0) ? 1 : 0) & ((this.ncs[paramInt + 1] < 10) ? 1 : 0)) != 0) {
							int i = this.ncs[paramInt + 1];
							double d8 = this.Fw[i];
							double d9 = this.nw[i];
							d7 = d6 - this.dbsd[paramInt + 1];
							d4 -= this.z0 * d8 * Math.pow(d1, d9 + 1.0D)
									* (1.0D - Math.exp(-d7 * this.bb * gufun(d7, d1) / d8 * Math.pow(d1, d9)));
						}
						continue;
					}
					break;
				}
				if (d4 >= Math.abs(d3)) {
					d1 -= this.stpint;
				}
			}

		}
		d1 = Math.round(10000.0D * d1) / 10000.0D;
		return d1;
	}

	public double[] rsrcprj(double paramDouble, int paramInt) {
		double[] arrayOfDouble = new double[3];
		double d1 = this.nb3;
		double d2 = this.z0 * Math.pow(paramDouble, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-50.0D * this.bb / Math.pow(paramDouble, this.nw[0])));
		double d3 = this.z0u * Math.pow(this.lmbu, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-50.0D * this.bb / Math.pow(this.lmbu, this.nw[0])));
		double d4 = this.z0 * Math.pow(paramDouble, this.nw[0] + 1.0D)
				* (1.0D - Math.exp(-d1 * this.bb * gufun(d1, paramDouble) / Math.pow(paramDouble, this.nw[0])));
		double d5 = d4;
		double d6 = 0.0D;
		double d7 = 0.0D;
		double d8 = d1;
		double d9 = d1;
		int i = -1;
		double d10 = -1.0D;
		double d11 = -1.0D;
		for (byte b = 0; b < paramInt; b++) {
			if (this.impty[b][0] == 0) {
				i = this.ncs[b + 1];
				d10 = this.Fw[i];
				d11 = this.nw[i];
				d9 = d8 - this.dbsd[b + 1];
				d5 -= this.z0 * d10 * Math.pow(paramDouble, d11 + 1.0D)
						* (1.0D - Math.exp(-d9 * this.bb * gufun(d9, paramDouble) / d10 * Math.pow(paramDouble, d11)));
				d9 -= this.ddsd[b + 1];
				d8 -= this.ddsd[b + 1];
				d5 += this.z0 * d10 * Math.pow(paramDouble, d11 + 1.0D)
						* (1.0D - Math.exp(-d9 * this.bb * gufun(d9, paramDouble) / d10 * Math.pow(paramDouble, d11)));
			}
		}
		i = this.ncs[paramInt + 1];
		d10 = this.Fw[i];
		d11 = this.nw[i];
		d9 = d8 - this.dbsd[paramInt + 1];
		d5 -= this.z0 * d10 * Math.pow(paramDouble, d11 + 1.0D)
				* (1.0D - Math.exp(-d9 * this.bb * gufun(d9, paramDouble) / d10 * Math.pow(paramDouble, d11)));
		if (this.impty[paramInt][2] == 0) {
			d9 -= this.ddsd[paramInt + 1];
		}
		d5 /= d2;
		d6 = this.z0 * d10 * Math.pow(paramDouble, d11 + 1.0D)
				* (1.0D - Math.exp(-d9 * this.bb * gufun(d9, paramDouble) / d10 * Math.pow(paramDouble, d11))) / d2;
		d7 = this.z0u * d10 * Math.pow(this.lmbu, d11 + 1.0D)
				* (1.0D - Math.exp(-d9 * this.bb * gufun(d9, this.lmbu) / d10 * Math.pow(this.lmbu, d11))) / d3;
		arrayOfDouble[0] = d5;
		arrayOfDouble[1] = d6;
		arrayOfDouble[2] = d7;
		return arrayOfDouble;
	}

	public double gufun(double paramDouble1, double paramDouble2) {
		double d;
		if ((((paramDouble1 > 0.0D) ? 1 : 0) & ((paramDouble2 > 1.0D) ? 1 : 0)) != 0) {
			double d1 = -1.0D / (1.0D + 1.7D * (paramDouble2 - 1.0D) * Math.exp(7.0D * (1.0D - paramDouble2)));
			double d2 = -0.3D * (paramDouble2 - 1.0D) * Math.exp(15.0D * (1.0D - paramDouble2));
			if (paramDouble1 > 50.0D) {
				d = ((paramDouble1 - 50.0D) * (d1 + 50.0D * d2) + 50.0D) / paramDouble1;
			} else {
				double d3 = -1.0D - d1 - d2 * paramDouble1;
				d = Math.pow(paramDouble1 / 50.0D, d3);
			}
		} else {
			d = 1.0D;
		}
		return d;
	}

	public double lmbfun() {
		double d2 = this.nb3;
		double d3 = this.nb4;
		double d1 = this.lmbdastar;
		if (this.nb3 > 0) {
			double d4 = 0.0D;
			double d6 = this.z0 * Math.pow(d1, this.nw[0] + 1.0D)
					* (1.0D - Math.exp(-d2 * this.bb * gufun(d2, d1) / Math.pow(d1, this.nw[0])));
			double d5 = d6 - d3;
			double d7 = d2;
			double d8 = d2;
			byte b;
			for (b = 0; b < this.nstprow; b++) {
				if ((((this.impty[b][0] == 0) ? 1 : 0) & ((this.ncs[b + 1] < 10) ? 1 : 0)) != 0) {
					int i = this.ncs[b + 1];
					double d9 = this.Fw[i];
					double d10 = this.nw[i];
					d8 = d7 - this.dbsd[b + 1];
					d5 -= this.z0 * d9 * Math.pow(d1, d10 + 1.0D)
							* (1.0D - Math.exp(-d8 * this.bb * gufun(d8, d1) / d9 * Math.pow(d1, d10)));
					d8 -= this.ddsd[b + 1];
					d7 -= this.ddsd[b + 1];
					d5 += this.z0 * d9 * Math.pow(d1, d10 + 1.0D)
							* (1.0D - Math.exp(-d8 * this.bb * gufun(d8, d1) / d9 * Math.pow(d1, d10)));
				}
			}
			if (d5 < 0.0D) {
				while (true) {
					if ((((d5 < 0.0D) ? 1 : 0) & ((d1 < this.lmbcap) ? 1 : 0)) != 0) {
						d1 += this.stpint;
						d4 = d5;
						d6 = this.z0 * Math.pow(d1, this.nw[0] + 1.0D)
								* (1.0D - Math.exp(-d2 * this.bb * gufun(d2, d1) / Math.pow(d1, this.nw[0])));
						d5 = d6 - d3;
						d7 = d2;
						d8 = d2;
						for (b = 0; b < this.nstprow; b++) {
							if ((((this.impty[b][0] == 0) ? 1 : 0) & ((this.ncs[b + 1] < 10) ? 1 : 0)) != 0) {
								int i = this.ncs[b + 1];
								double d9 = this.Fw[i];
								double d10 = this.nw[i];
								d8 = d7 - this.dbsd[b + 1];
								d5 -= this.z0 * d9 * Math.pow(d1, d10 + 1.0D)
										* (1.0D - Math.exp(-d8 * this.bb * gufun(d8, d1) / d9 * Math.pow(d1, d10)));
								d8 -= this.ddsd[b + 1];
								d7 -= this.ddsd[b + 1];
								d5 += this.z0 * d9 * Math.pow(d1, d10 + 1.0D)
										* (1.0D - Math.exp(-d8 * this.bb * gufun(d8, d1) / d9 * Math.pow(d1, d10)));
							}
						}
						continue;
					}
					break;
				}
				if (d5 >= Math.abs(d4)) {
					d1 -= this.stpint;
				}
			}

		}
		d1 = Math.round(10000.0D * d1) / 10000.0D;
		return d1;
	}

	public void setFw() {
		
		System.out.println("setFW");
		double[] arrayOfDouble = new double[11];
		arrayOfDouble[0] = this.pw11[0];
		System.out.println(this.pw11[0]);
		arrayOfDouble[1] = this.pw11[1];
		arrayOfDouble[2] = this.pw11[2];
		arrayOfDouble[3] = this.pw11[3];
		arrayOfDouble[4] = this.pw11[4];
		arrayOfDouble[5] = this.pw11[5];
		arrayOfDouble[6] = this.pw11[6];
		arrayOfDouble[7] = this.pw11[7];
		arrayOfDouble[8] = this.pw11[8];
		arrayOfDouble[9] = this.pw11[9];
		arrayOfDouble[10] = 1.0D;
		byte b;
		for (b = 0; b < 10; b++) {
			arrayOfDouble[10] = arrayOfDouble[10] - arrayOfDouble[b];
			System.out.println(arrayOfDouble[b]+"   -"+arrayOfDouble[10]);
		}
		arrayOfDouble[10] = (int) Math.round(1000.0D * arrayOfDouble[10]) / 1000.0D;
		
		System.out.println("4521"+arrayOfDouble[10]);
		this.Fw[0] = 1.0D;
		this.nw[0] = 10.5D;
		for (b = 1; b < 10; b++) {
			this.Fw[b] = this.Fw[b - 1] - arrayOfDouble[b];
			this.nw[b] = this.nw[0] * this.Fw[b];
		}
	}



	
	public void windowActivated(WindowEvent paramWindowEvent) {
		if (paramWindowEvent.getWindow() == this) {
			this.lstfcs.requestFocus();
			if (this.lstfcs == this.team1OversInnigsAtStartOfMatch) {
				this.team1OversInnigsAtStartOfMatch.setCaretPosition(this.icrt);
			} else if (this.lstfcs == this.team1FinalScore) {
				this.team1FinalScore.setCaretPosition(this.icrt);
			} else if (this.lstfcs == this.g3) {
				this.g3.setCaretPosition(this.icrt);
			} else if (this.lstfcs == this.i39) {
				this.i39.setCaretPosition(this.icrt);
			} else {
				for (byte b = 0; b < this.nstprow; b++) {
					if (this.lstfcs == this.tbs[b]) {
						this.tbs[b].setCaretPosition(this.icrt);
					} else if (this.lstfcs == this.tcs[b]) {
						this.tcs[b].setCaretPosition(this.icrt);
					} else if (this.lstfcs == this.tds[b]) {
						this.tds[b].setCaretPosition(this.icrt);
					} else if (this.lstfcs == this.tgs[b]) {
						this.tgs[b].setCaretPosition(this.icrt);
					} else if (this.lstfcs == this.ths[b]) {
						this.ths[b].setCaretPosition(this.icrt);
					} else if (this.lstfcs == this.tis[b]) {
						this.tis[b].setCaretPosition(this.icrt);
					}
				}
			}
		}
	}


	public void windowClosing(WindowEvent paramWindowEvent) {
		if (paramWindowEvent.getSource() == this.otblfrm) {
			this.otblopen = false;
		}
		if (paramWindowEvent.getSource() == this.RSfrm) {
			this.RSopen = false;
		}
		if (paramWindowEvent.getSource() == this.btblfrm) {
			this.btblopen = false;
		}
		if (paramWindowEvent.getSource() == this.T2trgf) {
			this.T2trgf.removeWindowListener(this);
			this.T2prnt.removeActionListener(this);
			this.T2html.removeActionListener(this);
			this.T2trgf.dispose();
			this.bT2open = false;
			if (this.iT2trg < 0) {
				if (this.g3.getText().trim().indexOf("?") == 0) {
					this.g3.setText("");
				}
			} else if (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0) {
				this.tis[this.iT2trg].setText("");
			}
		}
	}


	public void windowClosed(WindowEvent paramWindowEvent) {
	}

	public void windowDeactivated(WindowEvent paramWindowEvent) {
	}

	public void windowDeiconified(WindowEvent paramWindowEvent) {
	}

	public void windowIconified(WindowEvent paramWindowEvent) {
	}

	public void windowOpened(WindowEvent paramWindowEvent) {
	}
	public void mouseReleased(MouseEvent paramMouseEvent) {
	}

	public void mouseClicked(MouseEvent paramMouseEvent) {
	}

	public void mouseEntered(MouseEvent paramMouseEvent) {
	}

	public void mouseExited(MouseEvent paramMouseEvent) {
	}

	public void mouseMoved(MouseEvent paramMouseEvent) {
	}
	public void mousePressed(MouseEvent paramMouseEvent) {
		if (this.bslctd) {
			hiliteoff();
		}
		this.mpress = paramMouseEvent.getComponent();
		this.mprbx = paramMouseEvent.getSource();
		this.mprx1 = this.mpress.getX();
		this.mpry1 = this.mpress.getY();
	}

	public void mouseDragged(MouseEvent paramMouseEvent) {
		this.mprx2 = this.mprx1 + paramMouseEvent.getX();
		this.mpry2 = this.mpry1 + paramMouseEvent.getY();
		if (this.mpress.contains(paramMouseEvent.getPoint())) {
			hiliteoff();
			this.mpress.requestFocus();
		} else {
			this.bslctd = true;
			Runnable runnable = new Runnable() {
				public void run() {
					dlcalc.this.hiliteon();
				}
			};
			SwingUtilities.invokeLater(runnable);
		}
	}


    
	
	public void keyTyped(KeyEvent paramKeyEvent) {
		System.out.println("keyTyped"+paramKeyEvent);
	}

	public void keyReleased(KeyEvent paramKeyEvent) {
		System.out.println("keyReleased"+paramKeyEvent);
		
		
		if ((((paramKeyEvent.getKeyCode() == 86) ? 1 : 0) & (this.bsplash ? 1 : 0)) != 0) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Shift")) {
				this.splashf.setTitle(this.PRGMname);
			}
		}
		if (paramKeyEvent.getKeyCode() == 76) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Ctrl")) {
				this.abcde39.setText("");
			}
		}
		if (paramKeyEvent.getKeyCode() == 71) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Ctrl")) {
				this.abcde39.setText("");
			}
		}
		if (paramKeyEvent.getKeyCode() == 74) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Ctrl")) {
				this.abcde39.setText("");
			}
		}
		if (paramKeyEvent.getKeyCode() == 80) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Ctrl")) {
				this.cde4.setBackground(Color.lightGray);
				this.cde4.setText(" ");
				if (this.allowfullprj) {
					this.abcde39.setText("");
				}
			}
		}
	}



	public void keyPressed(KeyEvent paramKeyEvent) {
		System.out.println("Key Event "+paramKeyEvent);
		if (paramKeyEvent.getKeyCode() == 40) {
			if (this.bslctd) {
				hiliteoff();
			}
			if (paramKeyEvent.getSource() == this.team1OversInnigsAtStartOfMatch) {
				this.team1FinalScore.requestFocus();
				this.team1FinalScore.setCaretPosition(this.team1FinalScore.getText().length());
			} else if (paramKeyEvent.getSource() == this.team1FinalScore) {
				this.tbs[0].requestFocus();
				this.tbs[0].setCaretPosition(this.tbs[0].getText().length());
			} else if (paramKeyEvent.getSource() == this.g3) {
				this.tgs[0].requestFocus();
				this.tgs[0].setCaretPosition(this.tgs[0].getText().length());
			} else if (paramKeyEvent.getSource() == this.tis[this.nstprow - 1]) {
				this.i39.requestFocus();
				this.i39.setCaretPosition(this.i39.getText().length());
			} else {
				for (byte b = 0; b < this.nstprow - 1; b++) {
					if (paramKeyEvent.getSource() == this.tbs[b]) {
						this.tbs[b + 1].requestFocus();
						this.tbs[b + 1].setCaretPosition(this.tbs[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tcs[b]) {
						this.tcs[b + 1].requestFocus();
						this.tcs[b + 1].setCaretPosition(this.tcs[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tc1s[b]) {
						this.tc1s[b + 1].requestFocus();
						this.tc1s[b + 1].setCaretPosition(this.tc1s[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tds[b]) {
						this.tds[b + 1].requestFocus();
						this.tds[b + 1].setCaretPosition(this.tds[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tgs[b]) {
						this.tgs[b + 1].requestFocus();
						this.tgs[b + 1].setCaretPosition(this.tgs[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.ths[b]) {
						this.ths[b + 1].requestFocus();
						this.ths[b + 1].setCaretPosition(this.ths[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.th1s[b]) {
						this.th1s[b + 1].requestFocus();
						this.th1s[b + 1].setCaretPosition(this.th1s[b + 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tis[b]) {
						this.tis[b + 1].requestFocus();
						this.tis[b + 1].setCaretPosition(this.tis[b + 1].getText().length());
					}
				}
			}
		}
		if (paramKeyEvent.getKeyCode() == 38) {
			if (this.bslctd) {
				hiliteoff();
			}
			if (paramKeyEvent.getSource() == this.team1FinalScore) {
				this.team1OversInnigsAtStartOfMatch.requestFocus();
				this.team1OversInnigsAtStartOfMatch.setCaretPosition(this.team1OversInnigsAtStartOfMatch.getText().length());
			} else if (paramKeyEvent.getSource() == this.tbs[0]) {
				this.team1FinalScore.requestFocus();
				this.team1FinalScore.setCaretPosition(this.team1FinalScore.getText().length());
			} else if (paramKeyEvent.getSource() == this.tgs[0]) {
				this.g3.requestFocus();
				this.g3.setCaretPosition(this.g3.getText().length());
			} else if (paramKeyEvent.getSource() == this.i39) {
				this.tis[this.nstprow - 1].requestFocus();
				this.tis[this.nstprow - 1].setCaretPosition(this.tis[this.nstprow - 1].getText().length());
			} else {
				for (byte b = 1; b < this.nstprow; b++) {
					if (paramKeyEvent.getSource() == this.tbs[b]) {
						this.tbs[b - 1].requestFocus();
						this.tbs[b - 1].setCaretPosition(this.tbs[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tcs[b]) {
						this.tcs[b - 1].requestFocus();
						this.tcs[b - 1].setCaretPosition(this.tcs[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tc1s[b]) {
						this.tc1s[b - 1].requestFocus();
						this.tc1s[b - 1].setCaretPosition(this.tc1s[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tds[b]) {
						this.tds[b - 1].requestFocus();
						this.tds[b - 1].setCaretPosition(this.tds[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tgs[b]) {
						this.tgs[b - 1].requestFocus();
						this.tgs[b - 1].setCaretPosition(this.tgs[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.ths[b]) {
						this.ths[b - 1].requestFocus();
						this.ths[b - 1].setCaretPosition(this.ths[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.th1s[b]) {
						this.th1s[b - 1].requestFocus();
						this.th1s[b - 1].setCaretPosition(this.th1s[b - 1].getText().length());
					} else if (paramKeyEvent.getSource() == this.tis[b]) {
						this.tis[b - 1].requestFocus();
						this.tis[b - 1].setCaretPosition(this.tis[b - 1].getText().length());
					}
				}
			}
		}
		if (paramKeyEvent.getKeyCode() == 39) {
			if (this.bslctd) {
				hiliteoff();
			}
			if (paramKeyEvent.getSource() == this.team1OversInnigsAtStartOfMatch) {
				this.itmp = this.team1OversInnigsAtStartOfMatch.getCaretPosition();
				this.itmp1 = this.team1OversInnigsAtStartOfMatch.getText().length();
				if (this.itmp == this.itmp1) {
					this.g3.requestFocus();
					this.g3.setCaretPosition(this.g3.getText().length());
				} else {
					this.team1OversInnigsAtStartOfMatch.setCaretPosition(this.itmp + 1);
				}
			} else if (paramKeyEvent.getSource() == this.g3) {
				this.itmp = this.g3.getCaretPosition();
				this.itmp1 = this.g3.getText().length();
				if (this.itmp != this.itmp1) {
					this.g3.setCaretPosition(this.itmp + 1);
				}
			} else if (paramKeyEvent.getSource() == this.team1FinalScore) {
				this.itmp = this.team1FinalScore.getCaretPosition();
				this.itmp1 = this.team1FinalScore.getText().length();
				if (this.itmp != this.itmp1) {
					this.team1FinalScore.setCaretPosition(this.itmp + 1);
				}
			} else if (paramKeyEvent.getSource() == this.i39) {
				this.itmp = this.i39.getCaretPosition();
				this.itmp1 = this.i39.getText().length();
				if (this.itmp != this.itmp1) {
					this.i39.setCaretPosition(this.itmp + 1);
				}
			} else {
				for (byte b = 0; b < this.nstprow; b++) {
					if (paramKeyEvent.getSource() == this.tbs[b]) {
						this.itmp = this.tbs[b].getCaretPosition();
						this.itmp1 = this.tbs[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.tc1s[b].requestFocus();
							this.tc1s[b].setCaretPosition(this.tc1s[b].getText().length());
						} else {
							this.tbs[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.tc1s[b]) {
						this.itmp = this.tc1s[b].getCaretPosition();
						this.itmp1 = this.tc1s[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.tcs[b].requestFocus();
							this.tcs[b].setCaretPosition(this.tcs[b].getText().length());
						} else {
							this.tc1s[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.tcs[b]) {
						this.itmp = this.tcs[b].getCaretPosition();
						this.itmp1 = this.tcs[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.tds[b].requestFocus();
							this.tds[b].setCaretPosition(this.tds[b].getText().length());
						} else {
							this.tcs[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.tds[b]) {
						this.itmp = this.tds[b].getCaretPosition();
						this.itmp1 = this.tds[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.tgs[b].requestFocus();
							this.tgs[b].setCaretPosition(this.tgs[b].getText().length());
						} else {
							this.tds[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.tgs[b]) {
						this.itmp = this.tgs[b].getCaretPosition();
						this.itmp1 = this.tgs[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.th1s[b].requestFocus();
							this.th1s[b].setCaretPosition(this.th1s[b].getText().length());
						} else {
							this.tgs[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.ths[b]) {
						this.itmp = this.ths[b].getCaretPosition();
						this.itmp1 = this.ths[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.tis[b].requestFocus();
							this.tis[b].setCaretPosition(this.tis[b].getText().length());
						} else {
							this.ths[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.th1s[b]) {
						this.itmp = this.th1s[b].getCaretPosition();
						this.itmp1 = this.th1s[b].getText().length();
						if (this.itmp == this.itmp1) {
							this.ths[b].requestFocus();
							this.ths[b].setCaretPosition(this.ths[b].getText().length());
						} else {
							this.th1s[b].setCaretPosition(this.itmp + 1);
						}
					} else if (paramKeyEvent.getSource() == this.tis[b]) {
						this.itmp = this.tis[b].getCaretPosition();
						this.itmp1 = this.tis[b].getText().length();
						if (this.itmp != this.itmp1) {
							this.tis[b].setCaretPosition(this.itmp + 1);
						}
					}
				}
			}
		}
		if (paramKeyEvent.getKeyCode() == 37) {
			if (this.bslctd) {
				hiliteoff();
			}
			if (paramKeyEvent.getSource() == this.team1OversInnigsAtStartOfMatch) {
				this.itmp = this.team1OversInnigsAtStartOfMatch.getCaretPosition();
				if (this.itmp != 0) {
					this.team1OversInnigsAtStartOfMatch.setCaretPosition(this.itmp - 1);
				}
			} else if (paramKeyEvent.getSource() == this.g3) {
				this.itmp = this.g3.getCaretPosition();
				if (this.itmp == 0) {
					this.team1OversInnigsAtStartOfMatch.requestFocus();
					this.team1OversInnigsAtStartOfMatch.setCaretPosition(this.team1OversInnigsAtStartOfMatch.getText().length());
				} else {
					this.g3.setCaretPosition(this.itmp - 1);
				}
			} else if (paramKeyEvent.getSource() == this.team1FinalScore) {
				this.itmp = this.team1FinalScore.getCaretPosition();
				if (this.itmp != 0) {
					this.team1FinalScore.setCaretPosition(this.itmp - 1);
				}
			} else if (paramKeyEvent.getSource() == this.i39) {
				this.itmp = this.i39.getCaretPosition();
				if (this.itmp != 0) {
					this.i39.setCaretPosition(this.itmp - 1);
				}
			} else {
				for (byte b = 0; b < this.nstprow; b++) {
					if (paramKeyEvent.getSource() == this.tbs[b]) {
						this.itmp = this.tbs[b].getCaretPosition();
						if (this.itmp != 0) {
							this.tbs[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.tc1s[b]) {
						this.itmp = this.tc1s[b].getCaretPosition();
						if (this.itmp == 0) {
							this.tbs[b].requestFocus();
							this.tbs[b].setCaretPosition(this.tbs[b].getText().length());
						} else {
							this.tc1s[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.tcs[b]) {
						this.itmp = this.tcs[b].getCaretPosition();
						if (this.itmp == 0) {
							this.tc1s[b].requestFocus();
							this.tc1s[b].setCaretPosition(this.tc1s[b].getText().length());
						} else {
							this.tcs[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.tds[b]) {
						this.itmp = this.tds[b].getCaretPosition();
						if (this.itmp == 0) {
							this.tcs[b].requestFocus();
							this.tcs[b].setCaretPosition(this.tcs[b].getText().length());
						} else {
							this.tds[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.tgs[b]) {
						this.itmp = this.tgs[b].getCaretPosition();
						if (this.itmp == 0) {
							this.tds[b].requestFocus();
							this.tds[b].setCaretPosition(this.tds[b].getText().length());
						} else {
							this.tgs[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.ths[b]) {
						this.itmp = this.ths[b].getCaretPosition();
						if (this.itmp == 0) {
							this.th1s[b].requestFocus();
							this.th1s[b].setCaretPosition(this.th1s[b].getText().length());
						} else {
							this.ths[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.th1s[b]) {
						this.itmp = this.th1s[b].getCaretPosition();
						if (this.itmp == 0) {
							this.tgs[b].requestFocus();
							this.tgs[b].setCaretPosition(this.tgs[b].getText().length());
						} else {
							this.th1s[b].setCaretPosition(this.itmp - 1);
						}
					} else if (paramKeyEvent.getSource() == this.tis[b]) {
						this.itmp = this.tis[b].getCaretPosition();
						if (this.itmp == 0) {
							this.ths[b].requestFocus();
							this.ths[b].setCaretPosition(this.ths[b].getText().length());
						} else {
							this.tis[b].setCaretPosition(this.itmp - 1);
						}
					}
				}
			}
		}
		if ((((paramKeyEvent.getKeyCode() == 127) ? 1 : 0) & (this.bslctd ? 1 : 0))  != 0) {
			for (byte b = 0; b < this.nstprow; b++) {
				if (this.slctd[b][0] == 1) {
					this.tbs[b].setText("");
				}
				if (this.slctd[b][1] == 1) {
					this.tc1s[b].setText("");
				}
				if (this.slctd[b][2] == 1) {
					this.tcs[b].setText("");
				}
				if (this.slctd[b][3] == 1) {
					this.tds[b].setText("");
				}
				if (this.slctd[b][4] == 1) {
					this.tgs[b].setText("");
				}
				if (this.slctd[b][5] == 1) {
					this.th1s[b].setText("");
				}
				if (this.slctd[b][6] == 1) {
					this.ths[b].setText("");
				}
				if (this.slctd[b][7] == 1) {
					this.tis[b].setText("");
				}
			}
		}
		 if ((((paramKeyEvent.getKeyCode() == 8) ? 1 : 0) & (this.bslctd ? 1 : 0 )) != 0) {
			for (byte b = 0; b < this.nstprow; b++) {
				if (this.slctd[b][0] == 1) {
					this.tbs[b].setText("");
				}
				if (this.slctd[b][1] == 1) {
					this.tc1s[b].setText("");
				}
				if (this.slctd[b][2] == 1) {
					this.tcs[b].setText("");
				}
				if (this.slctd[b][3] == 1) {
					this.tds[b].setText("");
				}
				if (this.slctd[b][4] == 1) {
					this.tgs[b].setText("");
				}
				if (this.slctd[b][5] == 1) {
					this.th1s[b].setText("");
				}
				if (this.slctd[b][6] == 1) {
					this.ths[b].setText("");
				}
				if (this.slctd[b][7] == 1) {
					this.tis[b].setText("");
				}
			}
		}
		if (paramKeyEvent.getKeyCode() == 9) {
			if (this.bslctd) {
				hiliteoff();
			}
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (paramKeyEvent.getSource() == this.team1OversInnigsAtStartOfMatch) {
				if (str.contains("Shift")) {
					this.tis[this.nstprow - 1].requestFocus();
					this.tis[this.nstprow - 1].selectAll();
				} else {
					this.team1FinalScore.requestFocus();
					this.team1FinalScore.selectAll();
				}
			} else if (paramKeyEvent.getSource() == this.g3) {
				if (str.contains("Shift")) {
					this.tds[this.nstprow - 1].requestFocus();
					this.tds[this.nstprow - 1].selectAll();
				} else {
					this.tgs[0].requestFocus();
					this.tgs[0].selectAll();
				}
			} else if (paramKeyEvent.getSource() == this.team1FinalScore) {
				if (str.contains("Shift")) {
					this.team1OversInnigsAtStartOfMatch.requestFocus();
					this.team1OversInnigsAtStartOfMatch.selectAll();
				} else {
					this.tbs[0].requestFocus();
					this.tbs[0].selectAll();
				}
			} else if (paramKeyEvent.getSource() == this.i39) {
				this.g3.requestFocus();
				this.g3.selectAll();
			} else {
				for (byte b = 0; b < this.nstprow; b++) {
					if (paramKeyEvent.getSource() == this.tbs[b]) {
						if (str.contains("Shift")) {
							if (b > 0) {
								this.tds[b - 1].requestFocus();
								this.tds[b - 1].selectAll();
							} else {
								this.team1FinalScore.requestFocus();
								this.team1FinalScore.selectAll();
							}
						} else {
							this.tc1s[b].requestFocus();
							this.tc1s[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.tc1s[b]) {
						if (str.contains("Shift")) {
							this.tbs[b].requestFocus();
							this.tbs[b].selectAll();
						} else {
							this.tcs[b].requestFocus();
							this.tcs[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.tcs[b]) {
						if (str.contains("Shift")) {
							this.tc1s[b].requestFocus();
							this.tc1s[b].selectAll();
						} else {
							this.tds[b].requestFocus();
							this.tds[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.tds[b]) {
						if (str.contains("Shift")) {
							this.tcs[b].requestFocus();
							this.tcs[b].selectAll();
						} else if (b == this.nstprow - 1) {
							this.g3.requestFocus();
							this.g3.selectAll();
						} else {
							this.tbs[b + 1].requestFocus();
							this.tbs[b + 1].selectAll();
						}

					} else if (paramKeyEvent.getSource() == this.tgs[b]) {
						if (str.contains("Shift")) {
							if (b > 0) {
								this.tis[b - 1].requestFocus();
								this.tis[b - 1].selectAll();
							} else {
								this.g3.requestFocus();
								this.g3.selectAll();
							}
						} else {
							this.th1s[b].requestFocus();
							this.th1s[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.ths[b]) {
						if (str.contains("Shift")) {
							this.th1s[b].requestFocus();
							this.th1s[b].selectAll();
						} else {
							this.tis[b].requestFocus();
							this.tis[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.th1s[b]) {
						if (str.contains("Shift")) {
							this.tgs[b].requestFocus();
							this.tgs[b].selectAll();
						} else {
							this.ths[b].requestFocus();
							this.ths[b].selectAll();
						}
					} else if (paramKeyEvent.getSource() == this.tis[b]) {
						if (str.contains("Shift")) {
							this.ths[b].requestFocus();
							this.ths[b].selectAll();
						} else if (b == this.nstprow - 1) {
							this.team1OversInnigsAtStartOfMatch.requestFocus();
							this.team1OversInnigsAtStartOfMatch.selectAll();
						} else {
							this.tgs[b + 1].requestFocus();
							this.tgs[b + 1].selectAll();
						}
					}
				}
			}
		}

		if ((((paramKeyEvent.getKeyCode() == 86) ? 1 : 0) & (this.bsplash ? 1 : 0)) != 0) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Shift")) {
				this.splashf.setTitle(this.PRGMname + " (" + this.wmark + ")");
			}
		}
		if ((((paramKeyEvent.getKeyCode() == 82) ? 1 : 0) & (this.calclte1 ? 1 : 0)  & ((this.impty[60][2] == 0) ? 1 : 0) & (this.resfeature ? 1 : 0)) != 0) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (((str.contains("Ctrl") ? 1 : 0) & (str.contains("Shift")  ? 1 : 0)) != 0) {

				if (this.bresfrst) {
					this.sbresfrm = new JFrame("Processing table of ball-by-ball resource percentages . . .");
					this.sbresfrm.setLocationRelativeTo(this.a4);
					this.sbresfrm.setDefaultCloseOperation(1);
					this.sbresfrm.setSize(620, 0);
					this.sbresfrm.setIconImage(this.icon1.getImage());
					this.sbresfrm.setVisible(true);
				} else {
					this.sbresfrm.setVisible(true);
				}

				this.gcde = new StringBuilder("TableID" + this.PRGMno + ": ");
				this.gcde.append(this.team1OversInnigsAtStartOfMatch.getText().trim());
				this.gcde.append("-");
				this.gcde.append(this.team1FinalScore.getText().trim());
				int j;
				for (j = 0; j < this.nstprow; j++) {
					if (this.impty[j][0] == 0) {
						this.gcde.append("-");
						this.gcde.append(this.tbs[j].getText().trim());
						this.gcde.append("-");
						this.gcde.append(this.tcs[j].getText().trim());
						this.gcde.append("-");
						this.gcde.append(this.tds[j].getText().trim());
					}
				}

				this.bresopen = true;
				this.btblstrR.delete(0, this.btblstr.length());
				this.btblstrR.setLength(0);
				this.btblstrR.append(
						"<html><body><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"90\"><center>");
				this.btblstrR.append(
						" <font size=\"3\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"3\">");
				this.btblstrR.append(
						" <b>wickets down</b></font></center></td></tr><tr><td width=\"50\"><center><font size=\"3\"><b>0</b></font></center>");
				this.btblstrR.append(
						" </td><td width=\"50\"><center><font size=\"3\"><b>1</b></font></center></td><td width=\"50\"><center><font size=\"3\">");
				this.btblstrR.append(
						" <b>2</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>3</b></font></center></td><td width=\"50\">");
				this.btblstrR.append(
						" <center><font size=\"3\"><b>4</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>5</b></font>");
				this.btblstrR.append(
						" </center></td><td width=\"50\"><center><font size=\"3\"><b>6</b></font></center></td><td width=\"50\"><center>");
				this.btblstrR.append(
						" <font size=\"3\"><b>7</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>8</b></font></center>");
				this.btblstrR
						.append(" </td><td width=\"50\"><center><font size=\"3\"><b>9</b></font></center></td></tr>");
				this.R1 = resR1();
				j = (int) Math.floor(100.0D * this.R1);
				int k = (int) Math.round(10000.0D * this.R1) - j * 100;
				if (k > 99) {
					k = 0;
					j++;
				}

				this.btblstr1R.delete(0, this.btblstr1R.length());
				this.btblstr1R.setLength(0);
				this.btblstrTR.delete(0, this.btblstrTR.length());
				this.btblstrTR.setLength(0);
				if (k < 10) {
					this.btblstr1R.append(
							"<html><body><center><font size=\"3\"><b>Table of ball-by-ball resource percentages <font size=\"2\">(R1 = "
									+ j + ".0" + k + "%)</font></b></font></center>");
				} else {
					this.btblstr1R.append(
							"<html><body><center><font size=\"3\"><b>Table of ball-by-ball resource percentages <font size=\"2\">(R1 = "
									+ j + "." + k + "%)</font></b></font></center>");
				}
				this.btblstr1R.append(this.headerBR);
				this.btblstr1R.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
				this.idrwcnt = 0;
				this.pdrwcnt = 1;
				for (byte b = 0; b < this.nommaxo * 6 + 1; b++) {
					this.tmp = (this.nommaxo * 6 - b) / 6.0D;
					this.ovrrem = decToodb(this.tmp);
					if (this.tmp <= this.nommaxo) {
						this.idrwcnt++;
						this.ovrply = decToodb(this.nommaxo - this.tmp);
						this.btblstrR.append("<tr><td width=\"90\"><center><font size=\"3\"><b>");
						this.btblstrR.append(this.ovrrem);
						this.btblstrR.append("</b></font></center></td>");
						if (this.ovrrem.length() < 2) {
							this.btblstrTR.append("|     " + this.ovrrem + "     |");
						} else if (this.ovrrem.length() < 3) {
							this.btblstrTR.append("|    " + this.ovrrem + "     |");
						} else if (this.ovrrem.length() < 4) {
							this.btblstrTR.append("|    " + this.ovrrem + "    |");
						} else {
							this.btblstrTR.append("|   " + this.ovrrem + "    |");
						}
						if (this.idrwcnt == 56) {
							this.idrwcnt = 1;
							this.btblstr1R.append("<tr><td colspan=\"11\"><hr><font size=\"1\"><b>");
							if (this.pdrwcnt > 1) {
								this.btblstr1R.append(this.gcde.substring(0, this.gcde.length())
										+ "&nbsp;&nbsp;&nbsp;&mdash;&nbsp;&nbsp;&nbsp;Page " + this.pdrwcnt);
							} else {
								this.btblstr1R.append(this.gcde.substring(0, this.gcde.length()));
							}
							if (k < 10) {
								this.btblstr1R.append(
										"<html><body><center><font size=\"3\"><b>Table of ball-by-ball resource percentages <font size=\"2\">(R1 = "
												+ j + ".0" + k + "%)</font></b></font></center>");
							} else {
								this.btblstr1R.append(
										"<html><body><center><font size=\"3\"><b>Table of ball-by-ball resource percentages <font size=\"2\">(R1 = "
												+ j + "." + k + "%)</font></b></font></center>");
							}
							this.btblstr1R.append(this.headerBR);
							this.btblstr1R.append("<center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
							this.pdrwcnt++;
						}
						if ((this.nommaxo * 6 - b) % 6 == 0) {
							this.btblstr1R
									.append("<tr bgcolor=\"#DDDDDD\"><td width=\"60\"><center><font size=\"2\"><b>");
						} else {
							this.btblstr1R.append("<tr><td width=\"60\"><center><font size=\"2\"><b>");
						}
						this.btblstr1R.append(this.ovrrem);
						this.btblstr1R.append("</b></font></center></td>");
						for (byte b1 = 0; b1 < 10; b1++) {
							this.btblstrR.append("<td width=\"50\"><center><font size=\"2\">");
							this.btblstr1R.append("<td width=\"40\"><center><font size=\"2\">");
							if ((((b1 >= 0) ? 1 : 0) & ((this.tmp <= this.nommaxo) ? 1 : 0)) != 0) {
								this.btblstrR.append(resrem(this.tmp, b1, this.R1));
								this.btblstr1R.append(resrem(this.tmp, b1, this.R1));
								if (resrem(this.tmp, b1, this.R1).length() < 5) {
									this.btblstrTR.append("  " + resrem(this.tmp, b1, this.R1));
								} else if (resrem(this.tmp, b1, this.R1).length() < 6) {
									this.btblstrTR.append(" " + resrem(this.tmp, b1, this.R1));
								} else {
									this.btblstrTR.append(" 100.0");
								}
							} else {
								this.btblstrR.append("--");
								this.btblstr1R.append("--");
								this.btblstrTR.append("  --  ");
							}
							this.btblstrR.append("</font></center></td>");
							this.btblstr1R.append("</font></center></td>");
						}
						this.btblstrR.append("</tr>");
						this.btblstr1R.append("</tr>");
						this.btblstrTR.append(" |</tr>");
					}
				}

				this.btblstrR.append(
						"<tr><td colspan=\"11\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
				this.btblstrR.append(this.gcde.substring(0, this.gcde.length()));
				this.btblstrR.append("</b></font></td><td align=\"right\"><font size=\"1\">");
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
				this.btblstrR.append(date.toString());
				this.btblstrR.append("</font></td></tr></table></td></tr></table></center><font size=\"1\">");
				this.btblstrR.append(
						"<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
				this.btblstrR.append("</font></body></html>");
				this.btblstr1R.append(
						"<tr><td colspan=\"11\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
				this.btblstr1R.append(this.gcde.substring(0, this.gcde.length())
						+ "&nbsp;&nbsp;&nbsp;&mdash;&nbsp;&nbsp;&nbsp;Page " + this.pdrwcnt);
				this.btblstr1R.append("</b></font></td><td align=\"right\"><font size=\"1\">");
				this.btblstr1R.append(date.toString());
				this.btblstr1R
						.append("</font></td></tr></table><hr></td></tr><tr><td colspan=\"11\"><font size=\"1\">");
				this.btblstr1R.append(
						"<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
				this.btblstr1R.append("</font></td></tr></table></center></body></html>");
				this.btblstrTR.append(this.gcde.toString() + "  (" + date.toString() + ")");
				if (this.bresfrst) {
					this.bresfrm = new mkeBRtble(this.dirnmeb, this.btblstrTR);
					this.bresfrm.drawTable(this.btblstrR, this.btblstr1R, this.R1);
					this.bresfrst = false;
					this.bresfrm.addWindowListener(this);
					this.bresfrm.setDefaultCloseOperation(1);
					this.bresfrm.pack();
					this.bresfrm.setIconImage(this.icon1.getImage());
					int m = this.bresfrm.getWidth();
					GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
					int n = Math.min(this.bresfrm.getHeight(),
							(graphicsEnvironment.getMaximumWindowBounds()).height - 72);
					boolean bool = false;
					this.bresfrm.setBounds(0, 0, m, n);
					this.bresfrm.validate();
					this.bresfrm.setTitle(this.PRGMname + ": Table of ball-by-ball resource percentages");
					this.bresfrm.setVisible(true);
				} else {
					this.bresfrm.drawTable(this.btblstrR, this.btblstr1R, this.R1);
					this.bresfrm.setVisible(true);
				}
				this.sbresfrm.setVisible(false);

			} else if (str.contains("Ctrl")) {

				if (this.oresfrst) {
					this.soresfrm = new JFrame("Processing table of over-by-over resource percentages . . .");
					this.soresfrm.setLocationRelativeTo(this.a4);
					this.soresfrm.setDefaultCloseOperation(1);
					this.soresfrm.setSize(620, 0);
					this.soresfrm.setIconImage(this.icon1.getImage());
					this.soresfrm.setVisible(true);
				} else {
					this.soresfrm.setVisible(true);
				}

				this.gcde = new StringBuilder("TableID" + this.PRGMno + ": ");
				this.gcde.append(this.team1OversInnigsAtStartOfMatch.getText().trim());
				this.gcde.append("-");
				this.gcde.append(this.team1FinalScore.getText().trim());
				int j;
				for (j = 0; j < this.nstprow; j++) {
					if (this.impty[j][0] == 0) {
						this.gcde.append("-");
						this.gcde.append(this.tbs[j].getText().trim());
						this.gcde.append("-");
						this.gcde.append(this.tcs[j].getText().trim());
						this.gcde.append("-");
						this.gcde.append(this.tds[j].getText().trim());
					}
				}
				this.oresopen = true;
				this.otblstrR.delete(0, this.otblstr.length());
				this.otblstrR.setLength(0);
				this.otblstrR.append(
						"<html><body><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"90\"><center>");
				this.otblstrR.append(
						" <font size=\"3\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"3\">");
				this.otblstrR.append(
						" <b>wickets down</b></font></center></td></tr><tr><td width=\"50\"><center><font size=\"3\"><b>0</b></font></center>");
				this.otblstrR.append(
						" </td><td width=\"50\"><center><font size=\"3\"><b>1</b></font></center></td><td width=\"50\"><center><font size=\"3\">");
				this.otblstrR.append(
						" <b>2</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>3</b></font></center></td><td width=\"50\">");
				this.otblstrR.append(
						" <center><font size=\"3\"><b>4</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>5</b></font>");
				this.otblstrR.append(
						" </center></td><td width=\"50\"><center><font size=\"3\"><b>6</b></font></center></td><td width=\"50\"><center>");
				this.otblstrR.append(
						" <font size=\"3\"><b>7</b></font></center></td><td width=\"50\"><center><font size=\"3\"><b>8</b></font></center>");
				this.otblstrR
						.append(" </td><td width=\"50\"><center><font size=\"3\"><b>9</b></font></center></td></tr>");
				this.R1 = resR1();
				j = (int) Math.floor(100.0D * this.R1);
				int k = (int) Math.round(10000.0D * this.R1) - j * 100;
				if (k > 99) {
					k = 0;
					j++;
				}

				this.otblstr1R.delete(0, this.otblstr1R.length());
				this.otblstr1R.setLength(0);
				this.otblstrTR.delete(0, this.otblstrTR.length());
				this.otblstrTR.setLength(0);
				if (k < 10) {
					this.otblstr1R.append(
							"<html><body><center><font size=\"3\"><b>Table of over-by-over resource percentages <font size=\"2\">(R1 = "
									+ j + ".0" + k + "%)</font></b></font></center>");
				} else {
					this.otblstr1R.append(
							"<html><body><center><font size=\"3\"><b>Table of over-by-over resource percentages <font size=\"2\">(R1 = "
									+ j + "." + k + "%)</font></b></font></center>");
				}
				this.otblstr1R.append(this.headerR);
				this.otblstr1R.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
				this.idrwcnt = 0;
				for (byte b = 0; b < this.nommaxo + 1; b++) {
					Integer integer = new Integer(this.nommaxo - b);
					this.ovrrem = integer.toString();
					this.tmp = (this.nommaxo - b);
					if (this.tmp <= this.nommaxo) {
						this.idrwcnt++;
						this.ovrply = decToodb(this.nommaxo - this.tmp);
						this.otblstrR.append("<tr><td width=\"90\"><center><font size=\"3\"><b>");
						this.otblstrR.append(this.ovrrem);
						this.otblstrR.append("</b></font></center></td>");
						if (this.ovrrem.length() < 2) {
							this.otblstrTR.append("|     " + this.ovrrem + "     |");
						} else {
							this.otblstrTR.append("|    " + this.ovrrem + "     |");
						}
						if (this.idrwcnt == 56) {
							this.idrwcnt = 1;
							this.otblstr1R.append("<tr><td colspan=\"11\"><hr><font size=\"1\">");
							this.otblstr1R.append(this.gcde.toString());
							this.otblstr1R.append(
									"</font></td></tr></table></center><center><font size=\"3\"><b>Table of over-by-over Par Scores</b></font></center>");
							this.otblstr1R.append(this.header);
							this.otblstr1R.append("<center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
						}
						if (b % 5 == 0) {
							this.otblstr1R
									.append("<tr bgcolor=\"#DDDDDD\"><td width=\"60\"><center><font size=\"2\"><b>");
						} else {
							this.otblstr1R.append("<tr><td width=\"60\"><center><font size=\"2\"><b>");
						}
						this.otblstr1R.append(this.ovrrem);
						this.otblstr1R.append("</b></font></center></td>");
						for (byte b1 = 0; b1 < 10; b1++) {
							this.otblstrR.append("<td width=\"50\"><center><font size=\"2\">");
							this.otblstr1R.append("<td width=\"40\"><center><font size=\"2\">");
							if ((((b1 >= 0) ? 1 : 0) & ((this.tmp <= this.nommaxo) ? 1 : 0)) != 0) {
								this.otblstrR.append(resrem(this.tmp, b1, this.R1));
								this.otblstr1R.append(resrem(this.tmp, b1, this.R1));
								if (resrem(this.tmp, b1, this.R1).length() < 5) {
									this.otblstrTR.append("  " + resrem(this.tmp, b1, this.R1));
								} else if (resrem(this.tmp, b1, this.R1).length() < 6) {
									this.otblstrTR.append(" " + resrem(this.tmp, b1, this.R1));
								} else {
									this.otblstrTR.append(" 100.0");
								}
							} else {
								this.otblstrR.append("--");
								this.otblstr1R.append("--");
								this.otblstrTR.append("  --  ");
							}
							this.otblstrR.append("</font></center></td>");
							this.otblstr1R.append("</font></center></td>");
						}
						this.otblstrR.append("</tr>");
						this.otblstr1R.append("</tr>");
						this.otblstrTR.append(" |</tr>");
					}
				}

				this.otblstrR.append(
						"<tr><td colspan=\"11\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
				this.otblstrR.append(this.gcde.toString());
				this.otblstrR.append("</b></font></td><td align=\"right\"><font size=\"1\">");
				Date date = new Date();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
				this.otblstrR.append(date.toString());
				this.otblstrR.append("</font></td></tr></table></td></tr></table></center><font size=\"1\">");
				this.otblstrR.append(
						"<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
				this.otblstrR.append("</font></body></html>");
				this.otblstr1R.append(
						"<tr><td colspan=\"11\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
				this.otblstr1R.append(this.gcde.toString());
				this.otblstr1R.append("</b></font></td><td align=\"right\"><font size=\"1\">");
				this.otblstr1R.append(date.toString());
				this.otblstr1R
						.append("</font></td></tr></table><hr></td></tr><tr><td colspan=\"11\"><font size=\"1\">");
				this.otblstr1R.append(
						"<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
				this.otblstr1R.append("</font></td></tr></table></center></body></html>");
				this.otblstrTR.append(this.gcde.toString() + "  (" + date.toString() + ")");
				if (this.oresfrst) {
					this.oresfrm = new mkeORtble(this.dirnme, this.otblstrTR);
					this.oresfrm.drawTable(this.otblstrR, this.otblstr1R, this.R1);
					this.oresfrst = false;
					this.oresfrm.addWindowListener(this);
					this.oresfrm.addKeyListener(this);
					this.oresfrm.setFocusable(true);
					this.oresfrm.requestFocusInWindow();
					this.oresfrm.setDefaultCloseOperation(1);
					this.oresfrm.pack();
					this.oresfrm.setIconImage(this.icon1.getImage());
					int m = this.oresfrm.getWidth();
					GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
					int n = Math.min(this.oresfrm.getHeight(),
							(graphicsEnvironment.getMaximumWindowBounds()).height - 72);
					boolean bool = false;
					this.oresfrm.setBounds(0, 0, m, n);
					this.oresfrm.validate();
					this.oresfrm.setTitle(this.PRGMname + ": Table of over-by-over resource percentages");
					this.oresfrm.setVisible(true);
				} else {
					this.oresfrm.drawTable(this.otblstrR, this.otblstr1R, this.R1);
					this.oresfrm.setVisible(true);
				}
				this.soresfrm.setVisible(false);
			}
		}
		if (paramKeyEvent.getKeyCode() == 76) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (str.contains("Ctrl")) {

				if ((((this.nb4 > 0) ? 1 : 0) & (!this.bincon ? 1 : 0) & (!this.bincon1 ? 1 : 0)) != 0) {
					double d = Math
							.round(1000.0D * this.adjfct * this.z0 * Math.pow(this.lmbfct, this.nw[0] + 1.0D)
									* (1.0D - Math.exp(-50.0D * this.bb / Math.pow(this.lmbfct, this.nw[0]))))
							/ 1000.0D;
					this.abcde39.setText("λ = " + this.lmbfct + "; Z50 = " + d);
				} 
					else if (((this.calclte1 ? 1 : 0)  | (this.chkallbut1a ? 1 : 0)) != 0) {
					byte b1 = 0;
					for (byte b2 = 0; b2 < this.nstprow; b2++) {
						if (this.impty[b2][0] == 0) {
							b1 = b2;
						}
					}
					double d = this.nc1s[b1 + 1];
					if (this.impty[b1][3] == 0) {
						if (this.ncs[b1 + 1] == 10) {
							double d1 = Math
									.round(1000.0D * this.adjfct * this.z0 * Math.pow(this.lmbfct, this.nw[0] + 1.0D)
											* (1.0D - Math.exp(-50.0D * this.bb / Math.pow(this.lmbfct, this.nw[0]))))
									/ 1000.0D;
							this.abcde39.setText("λ = " + this.lmbfct + "; Z50 = " + d1);
						} else {
							if (this.dbsd[b1 + 1] == 0.0D) {
								this.lmbprj = this.lmbu;
							} else {
								this.lmbprj = lmbfunpr(d, b1);
							}
							this.abcde39.setText("λ = " + this.lmbprj);
						}
					} else {
						this.abcde39.setText("Insufficient input to calculate λ");
					}
				} else {
					this.abcde39.setText("Insufficient input to calculate λ");
				}
			}
		}

		if (paramKeyEvent.getKeyCode() == 71) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			if (((str.contains("Ctrl") ? 1 : 0) & (this.allowfullprj ? 1 : 0) ) != 0) {
				this.abcde39.setText("Base 1st Innings Score for Projection = " + this.g50u);
			}
		}
		if (paramKeyEvent.getKeyCode() == 72) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			 if (((str.contains("Ctrl") ? 1 : 0) & (this.allowfullprj ? 1 : 0)) != 0) {
				boolean bool1 = true;
				boolean bool2 = false;
				int j = (int) this.g50u;
				while (bool1) {
					String str1 = JOptionPane.showInputDialog(null, "Enter new base score for projection:", null, -1);
					if (str1 != null) {
						String str2 = str1.trim();
						try {
							if (str2.length() > 0) {
								Integer integer = Integer.valueOf(str2);
								j = integer.intValue();
								if (j <= 0) {
									JOptionPane.showMessageDialog(null, "Base score must be positive", "INVALID ENTRY:",
											0, this.icone1);
									continue;
								}
								bool1 = false;
							}

						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Base score must be whole number", "INVALID ENTRY:", 0,
									this.icone1);
						}
						continue;
					}
					bool1 = false;
					bool2 = true;
				}

				if (!bool2) {
					this.g50u = j;
				}
			}
		}
		if (paramKeyEvent.getKeyCode() == 80) {
			int i = paramKeyEvent.getModifiersEx();
			String str = KeyEvent.getModifiersExText(i);
			  if (((str.contains("Ctrl") ? 1 : 0) & (this.allowprj ? 1 : 0)) != 0) {
				if ((((this.nb4 > 0) ? 1 : 0) & (!this.bincon ? 1 : 0) & (!this.bincon1 ? 1 : 0)) != 0) {
					this.cde4.setBackground(prple);
					this.cde4.setText("  Innings Completed: " + this.nb4);
				 } else if (((this.calclte1 ? 1 : 0) | (this.chkallbut1a ? 1 : 0)) != 0) {
					byte b = -1;
					for (byte b1 = 0; b1 < this.nstprow; b1++) {
						if (this.impty[b1][0] == 0) {
							b = b1;
						}
					}
					double d = this.nc1s[b + 1];
					if (b > -1) {
						if (this.impty[b][3] == 0) {
							if (this.ncs[b + 1] == 10) {
								this.cde4.setText("  Innings Completed: " + this.nc1s[b + 1]);
							} else {
								if (this.dbsd[b + 1] == 0.0D) {
									this.lmbprj = this.lmbu;
								} else {
									this.lmbprj = lmbfunpr(d, b);
								}
								this.rsrcpr = rsrcprj(this.lmbprj, b);
								this.prjscr = this.nc1s[b + 1] + (int) Math.round((d + this.g50u * this.rsrcpr[2])
										* this.rsrcpr[1] / (this.rsrcpr[0] + this.rsrcpr[1]));
								this.cde4.setBackground(prple);
								this.cde4.setText("  Projected Score: " + this.prjscr);
								if (this.allowfullprj) {
									this.abcde39.setText("Base 1st Innings Score for Projection = " + this.g50u);
								}
							}
						} else {
							this.cde4.setBackground(prple);
							this.cde4.setText("  Insufficient input.");
						}
					} else {
						this.cde4.setBackground(prple);
						this.cde4.setText("  Insufficient input.");
					}
				} else {
					this.cde4.setBackground(prple);
					this.cde4.setText("  Insufficient input.");
				}
			}
		}
	}
	
	
	
	
	
	
	
	 @Override
	    public void actionPerformed(final ActionEvent actionEvent) {
		 System.out.println("");
		 System.out.println("--actionPerformed");
	        if (actionEvent.getSource() == this.ODIb) {
	            this.splashf.removeWindowListener(this);
	            this.splashf.removeKeyListener(this);
	            this.ODIb.removeActionListener(this);
	            this.T20b.removeActionListener(this);
	            this.Othb.removeActionListener(this);
	            this.splashf.dispose();
	            this.bsplash = false;
	            this.setVisible(true);
	            this.nommaxo = 50;
	            this.team1OversInnigsAtStartOfMatch.setText("50");
	            this.minover = 20;
	            this.team1FinalScore.requestFocus();
	            this.mtyp = 1;
	            this.g50typ = 0;
	            this.g50u = this.g50pr[this.g50typ];
	            this.lmbu = this.lprior[this.g50typ];
	            this.z0u = this.g50u / (1.0 - Math.exp(-50.0 * this.bb));
	            this.setTitle(this.PRGMname + " - match type: ODI regulations (50 overs/innings; min. 20 overs/side)");
	            this.setFw();
	        }
	        if (actionEvent.getSource() == this.T20b) {
	            this.splashf.removeWindowListener(this);
	            this.splashf.removeKeyListener(this);
	            this.ODIb.removeActionListener(this);
	            this.T20b.removeActionListener(this);
	            this.Othb.removeActionListener(this);
	            this.splashf.dispose();
	            this.bsplash = false;
	            this.setVisible(true);
	            this.nommaxo = 20;
	            this.team1OversInnigsAtStartOfMatch.setText("20");
	            this.minover = 5;
	            this.team1FinalScore.requestFocus();
	            this.mtyp = 2;
	            this.g50typ = 1;
	            this.g50u = this.g50pr[this.g50typ];
	            this.lmbu = this.lprior[this.g50typ];
	            this.z0u = this.g50u / (1.0 - Math.exp(-50.0 * this.bb));
	            this.setTitle(this.PRGMname + " - match type: Twenty20 (20 overs/innings; min. 5 overs/side)");
	            this.setFw();
	        }
	        if (actionEvent.getSource() == this.Othb) {
	            final Object showInputDialog = JOptionPane.showInputDialog(null, "select match type", "other match types", 3, this.iconq1, this.options11, this.options11[0]);
	            if (showInputDialog == this.options11[this.optnum - 1]) {
	                this.setFw();
	                this.omtyp = this.optnum;
	                this.mtyp = 3;
	                int n = 0;
	                this.maxtst = 0;
	                this.inpmax = "";
	                int i = 1;
	                while (i != 0) {
	                    final String showInputDialog2 = JOptionPane.showInputDialog(null, "Enter overs/innings:", null, -1);
	                    if (showInputDialog2 != null) {
	                        this.inpmax = showInputDialog2.trim();
	                        try {
	                            if (this.inpmax.length() <= 0) {
	                                continue;
	                            }
	                            this.ntmp = Integer.valueOf(this.inpmax);
	                            this.maxtst = this.ntmp;
	                            if (this.maxtst <= 0) {
	                                JOptionPane.showMessageDialog(null, "Overs must be positive", "INVALID ENTRY:", 0, this.icone1);
	                            }
	                            else if (this.maxtst > 99) {
	                                JOptionPane.showMessageDialog(null, "Overs/innings must be < 100", "INVALID ENTRY:", 0, this.icone1);
	                            }
	                            else {
	                                i = 0;
	                            }
	                        }
	                        catch (Exception ex) {
	                            JOptionPane.showMessageDialog(null, "Overs must be whole numbers", "INVALID ENTRY:", 0, this.icone1);
	                        }
	                    }
	                    else {
	                        i = 0;
	                        n = 1;
	                    }
	                }
	                if (n == 0) {
	                    int j = 1;
	                    while (j != 0) {
	                        final String showInputDialog3 = JOptionPane.showInputDialog(null, "Enter min. overs/side:", null, -1);
	                        if (showInputDialog3 != null) {
	                            final String trim = showInputDialog3.trim();
	                            try {
	                                if (trim.length() <= 0) {
	                                    continue;
	                                }
	                                this.ntmp = Integer.valueOf(trim);
	                                this.minover = this.ntmp;
	                                if (this.minover < 0) {
	                                    JOptionPane.showMessageDialog(null, "Overs must non-negative", "INVALID ENTRY:", 0, this.icone1);
	                                }
	                                else if (this.minover > this.maxtst) {
	                                    JOptionPane.showMessageDialog(null, "Min. overs/side must not exceed overs/innings (" + this.maxtst + ")", "INVALID ENTRY:", 0, this.icone1);
	                                }
	                                else {
	                                    j = 0;
	                                }
	                            }
	                            catch (Exception ex2) {
	                                JOptionPane.showMessageDialog(null, "Overs must be whole numbers", "INVALID ENTRY:", 0, this.icone1);
	                            }
	                        }
	                        else {
	                            j = 0;
	                            n = 1;
	                        }
	                    }
	                }
	                if (n == 0) {
	                    this.splashf.removeWindowListener(this);
	                    this.splashf.removeKeyListener(this);
	                    this.ODIb.removeActionListener(this);
	                    this.T20b.removeActionListener(this);
	                    this.Othb.removeActionListener(this);
	                    this.splashf.dispose();
	                    this.bsplash = false;
	                    this.draw1();
	                    this.setVisible(true);
	                    this.setTitle(this.PRGMname + " - match type: Custom (" + this.maxtst + " overs/innings; min. " + this.minover + " overs/side)");
	                    if (Integer.valueOf(this.inpmax) <= 20) {
	                        this.g50typ = 1;
	                        this.g50u = this.g50pr[this.g50typ];
	                        this.lmbu = this.lprior[this.g50typ];
	                        this.z0u = this.g50u / (1.0 - Math.exp(-50.0 * this.bb));
	                    }
	                    else {
	                        this.g50typ = 0;
	                        this.g50u = this.g50pr[this.g50typ];
	                        this.lmbu = this.lprior[this.g50typ];
	                        this.z0u = this.g50u / (1.0 - Math.exp(-50.0 * this.bb));
	                    }
	                    this.nommaxo = new Integer(this.inpmax);
	                    this.team1OversInnigsAtStartOfMatch.setText(this.inpmax);
	                    this.team1FinalScore.requestFocus();
	                }
	            }
	            else if (showInputDialog != null) {
	                this.setFw();
	                for (int k = 0; k < this.optnum - 1; ++k) {
	                    if (showInputDialog == this.options11[k]) {
	                        this.omtyp = k + 1;
	                        this.mtyp = 3;
	                        this.splashf.removeWindowListener(this);
	                        this.splashf.removeKeyListener(this);
	                        this.ODIb.removeActionListener(this);
	                        this.T20b.removeActionListener(this);
	                        this.Othb.removeActionListener(this);
	                        this.splashf.dispose();
	                        this.bsplash = false;
	                        this.setVisible(true);
	                        this.setTitle(this.PRGMname + " - match type: " + this.options11[k]);
	                        this.minover = this.minotyp[k];
	                        this.g50typ = 0;
	                        this.g50u = this.g50pr[this.g50typ];
	                        this.lmbu = this.lprior[this.g50typ];
	                        this.z0u = this.g50u / (1.0 - Math.exp(-50.0 * this.bb));
	                        this.nommaxo = new Integer(this.maxotyp[k]);
	                        this.team1OversInnigsAtStartOfMatch.setText(this.maxotyp[k]);
	                        this.team1FinalScore.requestFocus();
	                    }
	                }
	            }
	        }
	        if (actionEvent.getSource() == this.ChngTyp) {
	            final Object[] array = { "OK", "CANCEL" };
	            if (JOptionPane.showOptionDialog(null, "<html><center>Changing match type will reset all entry cells.<br>Do you wish to continue?", "Warning", -1, 2, this.iconw1, array, array[0]) == 0) {
	                this.HTname = "Home Team";
	                this.ATname = "Away Team";
	                this.HTnameA = "Home Team";
	                this.ATnameA = "Away Team";
	                this.venue = "Venue";
	                this.compname = "Tournament Name";
	                this.home1 = 0;
	                this.mdate = "";
	                if (!this.RSfrst) {
	                    this.RSfrm.clearComm();
	                }
	                this.draw1();
	                this.setVisible(false);
	                this.drawsplsh();
	            }
	        }
	        if (actionEvent.getSource() == this.RptSum & !this.RSopen) {
	            this.binntrm = false;
	            final String string = JOptionPane.showInputDialog(null, "Enter name of competition:", null, -1, null, null, this.compname).toString();
	            if (string != null) {
	                this.compname = string.trim();
	                final String string2 = JOptionPane.showInputDialog(null, "Enter first-named ('home') team:", null, -1, null, null, this.HTname).toString();
	                if (string2 != null) {
	                    this.Tname1 = string2.trim();
	                    this.HTname = this.Tname1;
	                    this.Tname1A = this.Tname1;
	                    this.Tname1B = this.Tname1;
	                    final String string3 = JOptionPane.showInputDialog(null, "Enter second-named ('away') team:", null, -1, null, null, this.ATname).toString();
	                    if (string3 != null) {
	                        this.Tname2 = string3.trim();
	                        this.ATname = this.Tname2;
	                        this.Tname2A = this.Tname2;
	                        this.Tname2B = this.Tname2;
	                        final String string4 = JOptionPane.showInputDialog(null, "Enter venue name:", null, -1, null, null, this.venue).toString();
	                        if (string4 != null) {
	                            this.venue = string4.trim();
	                            if (this.mdate.length() == 0) {
	                                this.mdate = new SimpleDateFormat("dd MMM yyyy").format(new Date());
	                            }
	                            final String string5 = JOptionPane.showInputDialog(null, "Enter Match Date:", null, -1, null, null, this.mdate).toString();
	                            if (string5 != null) {
	                                this.mdate = string5.trim();
	                                final Object[] array2 = { this.Tname1B, this.Tname2B };
	                                final Object showInputDialog4 = JOptionPane.showInputDialog(null, "Which team batted first?", null, 3, this.iconq1, array2, array2[this.home1]);
	                                if (showInputDialog4 != null) {
	                                    if (showInputDialog4.equals(this.Tname1B)) {
	                                        this.T1name = this.Tname1A;
	                                        this.T2name = this.Tname2A;
	                                        this.home1 = 0;
	                                    }
	                                    else {
	                                        this.T1name = this.Tname2A;
	                                        this.T2name = this.Tname1A;
	                                        this.home1 = 1;
	                                    }
	                                    this.RSopen = true;
	                                    this.RSstr.delete(0, this.RSstr.length());
	                                    this.RSstr.setLength(0);
	                                    this.RSstr1.delete(0, this.RSstr1.length());
	                                    this.RSstr1.setLength(0);
	                                    this.RSstr.append("<html><body>");
	                                    this.RSstr1.append("<html><body><font size=\"3\"><b>" + this.PRGMname + " Match Report:</b><br>");
	                                    this.RSstr.append(" <br>Competition: " + this.compname + "<br>");
	                                    this.RSstr.append(this.HTname + " vs. " + this.ATname + " at " + this.venue + " on " + this.mdate + "<br> <br>");
	                                    this.RSstr.append("Overs/innings at start of match: " + this.nb3 + "<br>");
	                                    for (int l = 0; l < this.nstprow; ++l) {
	                                        if (this.impty[l][2] == 0 & this.ddsd[l + 1] > 0.1) {
	                                            if (this.tds[l].getText().trim().indexOf("a") == 0 | this.tds[l].getText().trim().indexOf("A") == 0 | (this.omax1 - this.oltot1 < this.minover - 0.01 & l == this.lstrow1)) {
	                                                if (this.impty[l][3] == 0) {
	                                                    if (this.dbsd[l + 1] > 1.1) {
	                                                        this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " overs; Innings terminated.<br>");
	                                                    }
	                                                    else {
	                                                        this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " over; Innings terminated.<br>");
	                                                    }
	                                                }
	                                                else if (this.dbsd[l + 1] > 1.1) {
	                                                    this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " overs; Innings terminated.<br>");
	                                                }
	                                                else {
	                                                    this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " over; Innings terminated.<br>");
	                                                }
	                                            }
	                                            else if (this.impty[l][3] == 0) {
	                                                if (this.dbsd[l + 1] > 1.1 & this.ddsd[l + 1] > 1.1) {
	                                                    this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " overs; " + this.decToodb(this.ddsd[l + 1]) + " overs lost/side.<br>");
	                                                }
	                                                else if (this.ddsd[l + 1] > 1.1) {
	                                                    this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " over; " + this.decToodb(this.ddsd[l + 1]) + " overs lost/side.<br>");
	                                                }
	                                                else if (this.dbsd[l + 1] > 1.1) {
	                                                    this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " overs; " + this.decToodb(this.ddsd[l + 1]) + " over lost/side.<br>");
	                                                }
	                                                else {
	                                                    this.RSstr.append(this.T1name + " " + this.nc1s[l + 1] + "/" + this.ncs[l + 1] + " from " + this.decToodb(this.dbsd[l + 1]) + " over; " + this.decToodb(this.ddsd[l + 1]) + " over lost/side.<br>");
	                                                }
	                                            }
	                                            else if (this.dbsd[l + 1] > 1.1 & this.ddsd[l + 1] > 1.1) {
	                                                this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " overs; " + this.decToodb(this.ddsd[l + 1]) + " overs lost/side.<br>");
	                                            }
	                                            else if (this.ddsd[l + 1] > 1.1) {
	                                                this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " over; " + this.decToodb(this.ddsd[l + 1]) + " overs lost/side.<br>");
	                                            }
	                                            else if (this.dbsd[l + 1] > 1.1) {
	                                                this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " overs; " + this.decToodb(this.ddsd[l + 1]) + " over lost/side.<br>");
	                                            }
	                                            else {
	                                                this.RSstr.append(this.T1name + " " + this.ncs[l + 1] + " down from " + this.decToodb(this.dbsd[l + 1]) + " over; " + this.decToodb(this.ddsd[l + 1]) + " over lost/side.<br>");
	                                            }
	                                        }
	                                    }
	                                    if (!this.babnd & this.omax1 - this.oltot1 > this.minover - 0.01) {
	                                        if (Double.valueOf(this.d37.getText()) > 1.1) {
	                                            this.RSstr.append(this.T1name + " total: " + this.nb4 + " from (maximum of) " + this.d37.getText() + " overs.<br>");
	                                        }
	                                        else {
	                                            this.RSstr.append(this.T1name + " total: " + this.nb4 + " from (maximum of) " + this.d37.getText() + " over.<br>");
	                                        }
	                                    }
	                                    final int trgfuntst1 = this.trgfuntst1(this.adjfct, this.lmbfct, 0);
	                                    this.parfuntst1(this.adjfct, this.lmbfct, 0);
	                                    if (this.ng3 > this.minover - 0.01) {
	                                        this.RSstr.append(" <br>Overs at start of 2nd innings: " + this.ng3 + "; Target: " + trgfuntst1 + "<br>");
	                                        for (int n2 = 0; n2 < this.nstprow; ++n2) {
	                                            if (this.impty[30 + n2][2] == 0 & (this.odbTodec(this.dis[n2 + 1]) > 0.1 || this.babnda)) {
	                                                final int trgfuntst2 = this.trgfuntst1(this.adjfct, this.lmbfct, n2 + 1);
	                                                final int parfuntst1 = this.parfuntst1(this.adjfct, this.lmbfct, n2 + 1);
	                                                if (n2 < this.lstrow2) {
	                                                    if (this.impty[30 + n2][3] == 0) {
	                                                        if (this.dgsd[n2 + 1] > 1.1 & this.disd[n2 + 1] > 1.1) {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " overs (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " overs lost.  Target: " + trgfuntst2 + "<br>");
	                                                        }
	                                                        else if (this.disd[n2 + 1] > 1.1) {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " over (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " overs lost.  Target: " + trgfuntst2 + "<br>");
	                                                        }
	                                                        else if (this.dgsd[n2 + 1] > 1.1) {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " overs (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " over lost.  Target: " + trgfuntst2 + "<br>");
	                                                        }
	                                                        else {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " over (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " over lost.  Target: " + trgfuntst2 + "<br>");
	                                                        }
	                                                    }
	                                                    else if (this.dgsd[n2 + 1] > 1.1 & this.disd[n2 + 1] > 1.1) {
	                                                        this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " overs (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " overs lost.  Target: " + trgfuntst2 + "<br>");
	                                                    }
	                                                    else if (this.disd[n2 + 1] > 1.1) {
	                                                        this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " over (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " overs lost.  Target: " + trgfuntst2 + "<br>");
	                                                    }
	                                                    else if (this.dgsd[n2 + 1] > 1.1) {
	                                                        this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " overs (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " over lost.  Target: " + trgfuntst2 + "<br>");
	                                                    }
	                                                    else {
	                                                        this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " over (Par Score: " + parfuntst1 + "); " + this.decToodb(this.odbTodec(this.dis[n2 + 1])) + " over lost.  Target: " + trgfuntst2 + "<br>");
	                                                    }
	                                                }
	                                                else if (this.impty[30 + n2][3] == 0) {
	                                                    if (this.dgsd[n2 + 1] > 1.1) {
	                                                        if (this.rsltcde > 0) {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " overs; Innings terminated (" + this.rsltdes.substring(this.rsltdes.indexOf(";") + 2) + ").<br>");
	                                                        }
	                                                        else {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " overs; Innings terminated.<br>");
	                                                        }
	                                                        this.binntrm = true;
	                                                    }
	                                                    else {
	                                                        if (this.rsltcde > 0) {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " over; Innings terminated (" + this.rsltdes.substring(this.rsltdes.indexOf(";") + 2) + ").<br>");
	                                                        }
	                                                        else {
	                                                            this.RSstr.append(this.T2name + " " + this.nh1s[n2 + 1] + "/" + this.nhs[n2 + 1] + " from " + this.decToodb(this.dgsd[n2 + 1]) + " over; Innings terminated.<br>");
	                                                        }
	                                                        this.binntrm = true;
	                                                    }
	                                                }
	                                                else if (this.dgsd[n2 + 1] > 1.1) {
	                                                    this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " overs; Innings terminated (" + this.rsltdes.substring(this.rsltdes.indexOf(";") + 2) + ").<br>");
	                                                    this.binntrm = true;
	                                                }
	                                                else {
	                                                    this.RSstr.append(this.T2name + " " + this.nhs[n2 + 1] + " down from " + this.decToodb(this.dgsd[n2 + 1]) + " over; Innings terminated (" + this.rsltdes.substring(this.rsltdes.indexOf(";") + 2) + ").<br>");
	                                                    this.binntrm = true;
	                                                }
	                                            }
	                                        }
	                                        if ((this.impty[30 + this.lstrow2][2] == 1 || this.odbTodec(this.dis[this.lstrow2 + 1]) < 0.01) & this.impty[30 + this.lstrow2][1] == 0 & !this.babnda) {
	                                            if (this.impty[30 + this.lstrow2][3] == 0) {
	                                                if (this.dgsd[this.lstrow2 + 1] > 1.1) {
	                                                    this.RSstr.append(this.T2name + " " + this.nh1s[this.lstrow2 + 1] + "/" + this.nhs[this.lstrow2 + 1] + " from " + this.decToodb(this.dgsd[this.lstrow2 + 1]) + " overs.<br>");
	                                                }
	                                                else {
	                                                    this.RSstr.append(this.T2name + " " + this.nh1s[this.lstrow2 + 1] + "/" + this.nhs[this.lstrow2 + 1] + " from " + this.decToodb(this.dgsd[this.lstrow2 + 1]) + " over.<br>");
	                                                }
	                                            }
	                                            else if (this.dgsd[this.lstrow2 + 1] > 1.1) {
	                                                this.RSstr.append(this.T2name + " " + this.nhs[this.lstrow2 + 1] + " down from " + this.decToodb(this.dgsd[this.lstrow2 + 1]) + " overs.<br>");
	                                            }
	                                            else {
	                                                this.RSstr.append(this.T2name + " " + this.nhs[this.lstrow2 + 1] + " down from " + this.decToodb(this.dgsd[this.lstrow2 + 1]) + " over.<br>");
	                                            }
	                                        }
	                                    }
	                                    else {
	                                        this.RSstr.append(" <br>No 2nd innings play possible.<br>");
	                                    }
	                                    if (this.rsltcde == 0) {
	                                        this.RSstr.append(" <br>" + this.rsltdes.substring(0, this.rsltdes.indexOf(";")) + "<br>");
	                                    }
	                                    else if (this.rsltcde == 1) {
	                                        if (this.binntrm) {
	                                            this.RSstr.append(" <br>RESULT: " + this.T1name + " " + this.rsltdes.substring(0, this.rsltdes.indexOf(";")) + "<br>");
	                                        }
	                                        else {
	                                            this.RSstr.append(" <br>RESULT: " + this.T1name + " " + this.rsltdes.substring(0, this.rsltdes.indexOf(";")) + "<br>");
	                                        }
	                                    }
	                                    else if (this.rsltcde == 2) {
	                                        if (this.binntrm) {
	                                            this.RSstr.append(" <br>RESULT: " + this.T2name + " " + this.rsltdes.substring(0, this.rsltdes.indexOf(";")) + "<br>");
	                                        }
	                                        else {
	                                            this.RSstr.append(" <br>RESULT: " + this.T2name + " " + this.rsltdes + "<br>");
	                                        }
	                                    }
	                                    this.RSstr1.append(this.RSstr.toString());
	                                    this.RSstr.append("</html>");
	                                    if (this.RSfrst) {
	                                        (this.RSfrm = new mkeRS(this.dirnmeRS)).drawTable(this.RSstr, this.RSstr1, this.iconw1);
	                                        this.RSfrm.pname(this.PRGMname);
	                                        this.RSfrst = false;
	                                        this.RSfrm.addWindowListener((WindowListener)this);
	                                        this.RSfrm.setDefaultCloseOperation(1);
	                                        this.RSfrm.pack();
	                                        this.RSfrm.nameFocus();
	                                        this.RSfrm.setIconImage(this.icon1.getImage());
	                                        this.RSfrm.setBounds(0, 0, this.RSfrm.getWidth() + 20, this.RSfrm.getHeight() + 20);
	                                        this.RSfrm.validate();
	                                        this.RSfrm.setTitle(this.PRGMname + ": Match Report");
	                                        this.RSfrm.setVisible(true);
	                                    }
	                                    else {
	                                        this.RSfrm.drawTable(this.RSstr, this.RSstr1, this.iconw1);
	                                        this.RSfrm.pack();
	                                        this.RSfrm.nameFocus();
	                                        this.RSfrm.setBounds(0, 0, this.RSfrm.getWidth() + 20, this.RSfrm.getHeight() + 20);
	                                        this.RSfrm.setVisible(true);
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        if (actionEvent.getSource() == this.RstAll) {
	            this.HTname = "Home Team";
	            this.ATname = "Away Team";
	            this.HTnameA = "Home Team";
	            this.ATnameA = "Away Team";
	            this.venue = "Venue";
	            this.compname = "Tournament Name";
	            this.home1 = 0;
	            this.mdate = "";
	            if (!this.RSfrst) {
	                this.RSfrm.clearComm();
	            }
	            this.draw1();
	        }
	        if (actionEvent.getSource() == this.Otble & this.otblopen) {
	            this.otblfrm.setVisible(true);
	        }
	        if (actionEvent.getSource() == this.Btble & this.btblopen) {
	            this.btblfrm.setVisible(true);
	        }
	        if (actionEvent.getSource() == this.Otble & !this.otblopen) {
	            if (this.otblfrst) {
	                (this.sotblfrm = new JFrame("Processing table of over-by-over Par Scores . . .")).setLocationRelativeTo(this.a4);
	                this.sotblfrm.setDefaultCloseOperation(1);
	                this.sotblfrm.setSize(620, 0);
	                this.sotblfrm.setIconImage(this.icon1.getImage());
	                this.sotblfrm.setVisible(true);
	            }
	            else {
	                this.sotblfrm.setVisible(true);
	            }
	            (this.gcde = new StringBuilder("TableID" + this.PRGMno + ": ")).append(this.team1OversInnigsAtStartOfMatch.getText().trim());
	            this.gcde.append("-");
	            this.gcde.append(this.team1FinalScore.getText().trim());
	            for (int n3 = 0; n3 < this.nstprow; ++n3) {
	                if (this.impty[n3][0] == 0) {
	                    this.gcde.append("-");
	                    this.gcde.append(this.tbs[n3].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tcs[n3].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tds[n3].getText().trim());
	                }
	            }
	            this.gcde.append("/");
	            this.gcde.append(this.g3.getText().trim());
	            for (int n4 = 0; n4 < this.nstprow; ++n4) {
	                if (this.impty[n4 + 30][0] == 0) {
	                    this.gcde.append("-");
	                    this.gcde.append(this.tgs[n4].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.ths[n4].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tis[n4].getText().trim());
	                }
	            }
	            if (this.i39.getText().trim().length() > 0) {
	                this.gcde.append("/");
	                this.gcde.append(this.i39.getText().trim());
	            }
	            this.ctmp = this.i37.getText();
	            if (this.ctmp.trim().length() > 0) {
	                this.dtmp = Double.valueOf(this.ctmp);
	            }
	            else {
	                this.dtmp = 0.0;
	            }
	            this.tmpa = this.odbTodec(this.dtmp);
	            this.olft2 = this.tmpa - this.oplyd2;
	            this.otblopen = true;
	            this.otblstr.delete(0, this.otblstr.length());
	            this.otblstr.setLength(0);
	            this.otblstr.append("<html><body><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"70\">");
	            this.otblstr.append(" <center><font size=\"3\"><b>overs<br>bowled</b></font></center></td><td rowspan=\"2\" width=\"70\"><center>");
	            this.otblstr.append(" <font size=\"3\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"3\">");
	            this.otblstr.append(" <b>wickets down</b></font></center></td></tr><tr><td width=\"45\"><center><font size=\"3\"><b>0</b></font></center>");
	            this.otblstr.append(" </td><td width=\"45\"><center><font size=\"3\"><b>1</b></font></center></td><td width=\"45\"><center><font size=\"3\">");
	            this.otblstr.append(" <b>2</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>3</b></font></center></td><td width=\"45\">");
	            this.otblstr.append(" <center><font size=\"3\"><b>4</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>5</b></font>");
	            this.otblstr.append(" </center></td><td width=\"45\"><center><font size=\"3\"><b>6</b></font></center></td><td width=\"45\"><center>");
	            this.otblstr.append(" <font size=\"3\"><b>7</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>8</b></font></center>");
	            this.otblstr.append(" </td><td width=\"45\"><center><font size=\"3\"><b>9</b></font></center></td></tr>");
	            this.otblstr1.delete(0, this.otblstr1.length());
	            this.otblstr1.setLength(0);
	            this.otblstrT.delete(0, this.otblstrT.length());
	            this.otblstrT.setLength(0);
	            this.otblstr1.append("<html><body><center><font size=\"3\"><b>Table of over-by-over Par Scores</b></font></center>");
	            this.otblstr1.append((CharSequence)this.header);
	            this.otblstr1.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
	            this.idrwcnt = 0;
	            for (int n5 = 0; n5 < this.nb3 + 1; ++n5) {
	                this.ovrrem = new Integer(this.nb3 - n5).toString();
	                this.tmp = this.nb3 - n5;
	                if (this.tmp <= this.olft2) {
	                    ++this.idrwcnt;
	                    this.ovrply = this.decToodb(this.tmpa - this.tmp);
	                    this.otblstr.append("<tr><td width=\"70\"><center><font size=\"3\"><b>");
	                    this.otblstr.append(this.ovrply);
	                    this.otblstr.append("</b></font></center></td><td width=\"70\"><center><font size=\"3\"><b>");
	                    this.otblstr.append(this.ovrrem);
	                    this.otblstr.append("</b></font></center></td>");
	                    if (this.ovrply.length() < 2) {
	                        if (this.ovrrem.length() < 2) {
	                            this.otblstrT.append("|   " + this.ovrply + "   |    " + this.ovrrem + "    |");
	                        }
	                        else {
	                            this.otblstrT.append("|   " + this.ovrply + "   |   " + this.ovrrem + "    |");
	                        }
	                    }
	                    else if (this.ovrrem.length() < 2) {
	                        this.otblstrT.append("|  " + this.ovrply + "   |    " + this.ovrrem + "    |");
	                    }
	                    else {
	                        this.otblstrT.append("|  " + this.ovrply + "   |   " + this.ovrrem + "    |");
	                    }
	                    if (this.idrwcnt == 56) {
	                        this.idrwcnt = 1;
	                        this.otblstr1.append("<tr><td colspan=\"12\"><hr><font size=\"1\">");
	                        this.otblstr1.append(this.gcde.toString());
	                        this.otblstr1.append("</font></td></tr></table></center><center><font size=\"3\"><b>Table of over-by-over Par Scores</b></font></center>");
	                        this.otblstr1.append((CharSequence)this.header);
	                        this.otblstr1.append("<center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
	                    }
	                    if (((int)this.tmpa - this.nb3 + n5) % 5 == 0) {
	                        this.otblstr1.append("<tr bgcolor=\"#DDDDDD\"><td width=\"60\"><center><font size=\"2\"><b>");
	                    }
	                    else {
	                        this.otblstr1.append("<tr><td width=\"60\"><center><font size=\"2\"><b>");
	                    }
	                    this.otblstr1.append(this.ovrply);
	                    this.otblstr1.append("</b></font></center></td><td width=\"60\"><center><font size=\"2\"><b>");
	                    this.otblstr1.append(this.ovrrem);
	                    this.otblstr1.append("</b></font></center></td>");
	                    for (int n6 = 0; n6 < 10; ++n6) {
	                        this.otblstr.append("<td width=\"45\"><center><font size=\"2\">");
	                        this.otblstr1.append("<td width=\"40\"><center><font size=\"2\">");
	                        if (n6 >= this.wckt2 & this.tmp <= this.olft2) {
	                            this.otblstr.append(this.parscore(this.tmp, n6));
	                            this.otblstr1.append(this.parscore(this.tmp, n6));
	                            if (this.parscore(this.tmp, n6).length() < 2) {
	                                this.otblstrT.append("   " + this.parscore(this.tmp, n6) + " ");
	                            }
	                            else if (this.parscore(this.tmp, n6).length() < 3) {
	                                this.otblstrT.append("  " + this.parscore(this.tmp, n6) + " ");
	                            }
	                            else {
	                                this.otblstrT.append(" " + this.parscore(this.tmp, n6) + " ");
	                            }
	                        }
	                        else {
	                            this.otblstr.append("--");
	                            this.otblstr1.append("--");
	                            this.otblstrT.append("  -- ");
	                        }
	                        this.otblstr.append("</font></center></td>");
	                        this.otblstr1.append("</font></center></td>");
	                    }
	                    this.otblstr.append("</tr>");
	                    this.otblstr1.append("</tr>");
	                    this.otblstrT.append("|</tr>");
	                }
	            }
	            this.otblstr.append("<tr><td colspan=\"12\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
	            this.otblstr.append(this.gcde.toString());
	            this.otblstr.append("</b></font></td><td align=\"right\"><font size=\"1\">");
	            final Date date = new Date();
	            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
	            this.otblstr.append(date.toString());
	            this.otblstr.append("</font></td></tr></table></td></tr></table></center><font size=\"1\">");
	            this.otblstr.append("<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
	            this.otblstr.append("</font></body></html>");
	            this.otblstr1.append("<tr><td colspan=\"12\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
	            this.otblstr1.append(this.gcde.toString());
	            this.otblstr1.append("</b></font></td><td align=\"right\"><font size=\"1\">");
	            this.otblstr1.append(date.toString());
	            this.otblstr1.append("</font></td></tr></table><hr></td></tr><tr><td colspan=\"12\"><font size=\"1\">");
	            this.otblstr1.append("<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
	            this.otblstr1.append("</font></td></tr></table></center></body></html>");
	            this.otblstrT.append(this.gcde.toString() + "  (" + date.toString() + ")");
	            if (this.otblfrst) {
	                (this.otblfrm = new mkeOtble(this.dirnme, this.otblstrT)).drawTable(this.otblstr, this.otblstr1, this.iconw1);
	                this.otblfrst = false;
	                this.otblfrm.addWindowListener((WindowListener)this);
	                this.otblfrm.addKeyListener((KeyListener)this);
	                this.otblfrm.setFocusable(true);
	                this.otblfrm.setDefaultCloseOperation(1);
	                this.otblfrm.pack();
	                this.otblfrm.setIconImage(this.icon1.getImage());
	                final int width = this.otblfrm.getWidth();
	                final int min = Math.min(this.otblfrm.getHeight(), GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 72);
	                int n7 = 0;
	                if (this.btblopen) {
	                    n7 += 18;
	                }
	                if (this.bT2open) {
	                    n7 += 18;
	                }
	                this.otblfrm.setBounds(n7, n7, width, min);
	                this.otblfrm.setTitle(this.PRGMname + ": Table of over-by-over Par Scores");
	                this.otblfrm.validate();
	            }
	            else {
	                this.otblfrm.drawTable(this.otblstr, this.otblstr1, this.iconw1);
	                this.otblfrm.pack();
	                this.otblfrm.validate();
	            }
	            this.sotblfrm.setVisible(false);
	            
	            final dlcalc monitor = this;
                Runnable runnable = new Runnable() {
    				public void run() {
    					monitor.otblfrm.setVisible(true);
    				}
    			};
    			SwingUtilities.invokeLater(runnable);
	            
	           // SwingUtilities.invokeLater((Runnable)new dlcalc.dlcalc$5(this));
	        }
	        if (actionEvent.getSource() == this.Btble & !this.btblopen) {
	            if (this.btblfrst) {
	                (this.sbtblfrm = new JFrame("Processing table of ball-by-ball Par Scores . . .")).setLocationRelativeTo(this.a4);
	                this.sbtblfrm.setDefaultCloseOperation(1);
	                this.sbtblfrm.setSize(620, 0);
	                this.sbtblfrm.setIconImage(this.icon1.getImage());
	                this.sbtblfrm.setVisible(true);
	            }
	            else {
	                this.sbtblfrm.setVisible(true);
	            }
	            (this.gcde = new StringBuilder("TableID" + this.PRGMno + ": ")).append(this.team1OversInnigsAtStartOfMatch.getText().trim());
	            this.gcde.append("-");
	            this.gcde.append(this.team1FinalScore.getText().trim());
	            for (int n8 = 0; n8 < this.nstprow; ++n8) {
	                if (this.impty[n8][0] == 0) {
	                    this.gcde.append("-");
	                    this.gcde.append(this.tbs[n8].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tcs[n8].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tds[n8].getText().trim());
	                }
	            }
	            this.gcde.append("/");
	            this.gcde.append(this.g3.getText().trim());
	            for (int n9 = 0; n9 < this.nstprow; ++n9) {
	                if (this.impty[n9 + 30][0] == 0) {
	                    this.gcde.append("-");
	                    this.gcde.append(this.tgs[n9].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.ths[n9].getText().trim());
	                    this.gcde.append("-");
	                    this.gcde.append(this.tis[n9].getText().trim());
	                }
	            }
	            if (this.i39.getText().trim().length() > 0) {
	                this.gcde.append("/");
	                this.gcde.append(this.i39.getText().trim());
	            }
	            this.ctmp = this.i37.getText();
	            if (this.ctmp.trim().length() > 0) {
	                this.dtmp = Double.valueOf(this.ctmp);
	            }
	            else {
	                this.dtmp = 0.0;
	            }
	            this.tmpa = this.odbTodec(this.dtmp);
	            this.olft2 = this.tmpa - this.oplyd2;
	            this.btblopen = true;
	            this.btblstr.delete(0, this.btblstr.length());
	            this.btblstr.setLength(0);
	            this.btblstr.append("<html><body><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tr><td rowspan=\"2\" width=\"70\">");
	            this.btblstr.append(" <center><font size=\"3\"><b>overs.balls<br>bowled</b></font></center></td><td rowspan=\"2\" width=\"70\"><center>");
	            this.btblstr.append(" <font size=\"3\"><b>overs<br>remaining</b></font></center></td><td colspan=\"10\"><center><font size=\"3\">");
	            this.btblstr.append(" <b>wickets down</b></font></center></td></tr><tr><td width=\"45\"><center><font size=\"3\"><b>0</b></font></center>");
	            this.btblstr.append(" </td><td width=\"45\"><center><font size=\"3\"><b>1</b></font></center></td><td width=\"45\"><center><font size=\"3\">");
	            this.btblstr.append(" <b>2</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>3</b></font></center></td><td width=\"45\">");
	            this.btblstr.append(" <center><font size=\"3\"><b>4</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>5</b></font>");
	            this.btblstr.append(" </center></td><td width=\"45\"><center><font size=\"3\"><b>6</b></font></center></td><td width=\"45\"><center>");
	            this.btblstr.append(" <font size=\"3\"><b>7</b></font></center></td><td width=\"45\"><center><font size=\"3\"><b>8</b></font></center>");
	            this.btblstr.append(" </td><td width=\"45\"><center><font size=\"3\"><b>9</b></font></center></td></tr>");
	            this.btblstr1.delete(0, this.btblstr1.length());
	            this.btblstr1.setLength(0);
	            this.btblstrT.delete(0, this.btblstrT.length());
	            this.btblstrT.setLength(0);
	            this.btblstr1.append("<html><body><center><font size=\"3\"><b>Table of ball-by-ball Par Scores</b></font></center>");
	            this.btblstr1.append((CharSequence)this.headerB);
	            this.btblstr1.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
	            this.idrwcnt = 0;
	            this.pdrwcnt = 1;
	            for (int n10 = 0; n10 < this.nb3 * 6 + 1; ++n10) {
	                this.tmp = (this.nb3 * 6 - n10) / 6.0;
	                this.ovrrem = this.decToodb(this.tmp);
	                if (this.tmp <= this.olft2) {
	                    ++this.idrwcnt;
	                    this.ovrply = this.decToodb(this.tmpa - this.tmp);
	                    this.btblstr.append("<tr><td width=\"70\"><center><font size=\"3\"><b>");
	                    this.btblstr.append(this.ovrply);
	                    this.btblstr.append("</b></font></center></td><td width=\"70\"><center><font size=\"3\"><b>");
	                    this.btblstr.append(this.ovrrem);
	                    this.btblstr.append("</b></font></center></td>");
	                    if (this.ovrply.length() < 2) {
	                        if (this.ovrrem.length() < 2) {
	                            this.btblstrT.append("|   " + this.ovrply + "   |    " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 3) {
	                            this.btblstrT.append("|   " + this.ovrply + "   |   " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 4) {
	                            this.btblstrT.append("|   " + this.ovrply + "   |    " + this.ovrrem + "  |");
	                        }
	                        else {
	                            this.btblstrT.append("|   " + this.ovrply + "   |   " + this.ovrrem + "  |");
	                        }
	                    }
	                    else if (this.ovrply.length() < 3) {
	                        if (this.ovrrem.length() < 2) {
	                            this.btblstrT.append("|  " + this.ovrply + "   |    " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 3) {
	                            this.btblstrT.append("|  " + this.ovrply + "   |   " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 4) {
	                            this.btblstrT.append("|  " + this.ovrply + "   |    " + this.ovrrem + "  |");
	                        }
	                        else {
	                            this.btblstrT.append("|  " + this.ovrply + "   |   " + this.ovrrem + "  |");
	                        }
	                    }
	                    else if (this.ovrply.length() < 4) {
	                        if (this.ovrrem.length() < 2) {
	                            this.btblstrT.append("|   " + this.ovrply + " |    " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 3) {
	                            this.btblstrT.append("|   " + this.ovrply + " |   " + this.ovrrem + "    |");
	                        }
	                        else if (this.ovrrem.length() < 4) {
	                            this.btblstrT.append("|   " + this.ovrply + " |    " + this.ovrrem + "  |");
	                        }
	                        else {
	                            this.btblstrT.append("|   " + this.ovrply + " |   " + this.ovrrem + "  |");
	                        }
	                    }
	                    else if (this.ovrrem.length() < 2) {
	                        this.btblstrT.append("|  " + this.ovrply + " |    " + this.ovrrem + "    |");
	                    }
	                    else if (this.ovrrem.length() < 3) {
	                        this.btblstrT.append("|  " + this.ovrply + " |   " + this.ovrrem + "    |");
	                    }
	                    else if (this.ovrrem.length() < 4) {
	                        this.btblstrT.append("|  " + this.ovrply + " |    " + this.ovrrem + "  |");
	                    }
	                    else {
	                        this.btblstrT.append("|  " + this.ovrply + " |   " + this.ovrrem + "  |");
	                    }
	                    if (this.idrwcnt == 56) {
	                        this.idrwcnt = 1;
	                        this.btblstr1.append("<tr><td colspan=\"12\"><hr><font size=\"1\"><b>");
	                        if (this.pdrwcnt > 1) {
	                            this.btblstr1.append(this.gcde.substring(0, this.gcde.length()) + "&nbsp;&nbsp;&nbsp;&mdash;&nbsp;&nbsp;&nbsp;Page " + this.pdrwcnt);
	                        }
	                        else {
	                            this.btblstr1.append(this.gcde.substring(0, this.gcde.length()));
	                        }
	                        this.btblstr1.append("</b></font></td></tr></table></center><center><font size=\"3\"><b>Table of ball-by-ball Par Scores</b></font></center>");
	                        this.btblstr1.append((CharSequence)this.headerB);
	                        this.btblstr1.append("<center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
	                        ++this.pdrwcnt;
	                    }
	                    if ((this.nb3 * 6 - n10) % 6 == 0) {
	                        this.btblstr1.append("<tr bgcolor=\"#DDDDDD\"><td width=\"60\"><center><font size=\"2\"><b>");
	                    }
	                    else {
	                        this.btblstr1.append("<tr><td width=\"60\"><center><font size=\"2\"><b>");
	                    }
	                    this.btblstr1.append(this.ovrply);
	                    this.btblstr1.append("</b></font></center></td><td width=\"60\"><center><font size=\"2\"><b>");
	                    this.btblstr1.append(this.ovrrem);
	                    this.btblstr1.append("</b></font></center></td>");
	                    for (int n11 = 0; n11 < 10; ++n11) {
	                        this.btblstr.append("<td width=\"45\"><center><font size=\"2\">");
	                        this.btblstr1.append("<td width=\"40\"><center><font size=\"2\">");
	                        if (n11 >= this.wckt2 & this.tmp <= this.olft2) {
	                            this.btblstr.append(this.parscore(this.tmp, n11));
	                            this.btblstr1.append(this.parscore(this.tmp, n11));
	                            if (this.parscore(this.tmp, n11).length() < 2) {
	                                this.btblstrT.append("   " + this.parscore(this.tmp, n11) + " ");
	                            }
	                            else if (this.parscore(this.tmp, n11).length() < 3) {
	                                this.btblstrT.append("  " + this.parscore(this.tmp, n11) + " ");
	                            }
	                            else {
	                                this.btblstrT.append(" " + this.parscore(this.tmp, n11) + " ");
	                            }
	                        }
	                        else {
	                            this.btblstr.append("--");
	                            this.btblstr1.append("--");
	                            this.btblstrT.append("  -- ");
	                        }
	                        this.btblstr.append("</font></center></td>");
	                        this.btblstr1.append("</font></center></td>");
	                    }
	                    this.btblstr.append("</tr>");
	                    this.btblstr1.append("</tr>");
	                    this.btblstrT.append("|</tr>");
	                }
	            }
	            this.btblstr.append("<tr><td colspan=\"12\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
	            this.btblstr.append(this.gcde.substring(0, this.gcde.length()));
	            this.btblstr.append("</b></font></td><td align=\"right\"><font size=\"1\">");
	            final Date date2 = new Date();
	            final SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy");
	            this.btblstr.append(date2.toString());
	            this.btblstr.append("</font></td></tr></table></td></tr></table></center><font size=\"1\">");
	            this.btblstr.append("<center>&copy; " + simpleDateFormat2.format(date2) + " International Cricket Council</center>");
	            this.btblstr.append("</font></body></html>");
	            this.btblstr1.append("<tr><td colspan=\"12\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
	            this.btblstr1.append(this.gcde.substring(0, this.gcde.length()) + "&nbsp;&nbsp;&nbsp;&mdash;&nbsp;&nbsp;&nbsp;Page " + this.pdrwcnt);
	            this.btblstr1.append("</b></font></td><td align=\"right\"><font size=\"1\">");
	            this.btblstr1.append(date2.toString());
	            this.btblstr1.append("</font></td></tr></table><hr></td></tr><tr><td colspan=\"12\"><font size=\"1\">");
	            this.btblstr1.append("<center>&copy; " + simpleDateFormat2.format(date2) + " International Cricket Council</center>");
	            this.btblstr1.append("</font></td></tr></table></center></body></html>");
	            this.btblstrT.append(this.gcde.toString() + "  (" + date2.toString() + ")");
	            if (this.btblfrst) {
	                (this.btblfrm = new mkeBtble(this.dirnmeb, this.btblstrT)).drawTable(this.btblstr, this.btblstr1, this.iconw1);
	                this.btblfrst = false;
	                this.btblfrm.addWindowListener((WindowListener)this);
	                this.btblfrm.setDefaultCloseOperation(1);
	                this.btblfrm.pack();
	                this.btblfrm.setIconImage(this.icon1.getImage());
	                final int width2 = this.btblfrm.getWidth();
	                final int min2 = Math.min(this.btblfrm.getHeight(), GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 72);
	                int n12 = 0;
	                if (this.otblopen) {
	                    n12 += 18;
	                }
	                if (this.bT2open) {
	                    n12 += 18;
	                }
	                this.btblfrm.setBounds(n12, n12, width2, min2);
	                this.btblfrm.validate();
	                this.btblfrm.setTitle(this.PRGMname + ": Table of ball-by-ball Par Scores");
	            }
	            else {
	                this.btblfrm.drawTable(this.btblstr, this.btblstr1, this.iconw1);
	                this.btblfrm.pack();
	                this.btblfrm.validate();
	            }
	            this.sbtblfrm.setVisible(false);
	            final dlcalc monitor = this;
                Runnable runnable = new Runnable() {
    				public void run() {
    					monitor.btblfrm.setVisible(true);
    				}
    			};
    			SwingUtilities.invokeLater(runnable);
	            
//	            SwingUtilities.invokeLater((Runnable)new dlcalc.dlcalc$6(this));
	        }
	        if (actionEvent.getSource() == this.T2prnt) {
	            this.T2trglp.setText(this.T2trgbp.toString());
	            this.T2trglp.setHorizontalAlignment(0);
	            this.T2trglp.setVerticalAlignment(1);
	            this.T2trgfp.pack();
	            PParTable.printComponent((Component)this.T2trglp);
	        }
	        if (actionEvent.getSource() == this.T2html) {
	            try {
	                String absolutePath = new String("");
	                String description = null;
	                int n13 = 0;
	                boolean b = false;
	                while (n13 == 0) {
	                    final JFileChooser fileChooser = new JFileChooser(this.dirnmeT2);
	                    fileChooser.setFileSelectionMode(0);
	                    fileChooser.setSelectedFile(new File("Team2targets"));
	                    fileChooser.setAcceptAllFileFilterUsed(false);
	                    fileChooser.addChoosableFileFilter((FileFilter)new TXTFileFilter());
	                    fileChooser.addChoosableFileFilter((FileFilter)new HTMLFileFilter());
	                    if (fileChooser.showDialog(null, "Save") == 0) {
	                        File selectedFile;
	                        final File file = selectedFile = fileChooser.getSelectedFile();
	                        description = fileChooser.getFileFilter().getDescription();
	                        if (!file.getName().toLowerCase().endsWith(".html") & description.indexOf("html") > -1) {
	                            selectedFile = new File(file.getAbsolutePath() + ".html");
	                        }
	                        if (!file.getName().toLowerCase().endsWith(".txt") & description.indexOf("txt") > -1) {
	                            selectedFile = new File(file.getAbsolutePath() + ".txt");
	                        }
	                        absolutePath = selectedFile.getAbsolutePath();
	                        this.dirnmeT2 = absolutePath;
	                        if (selectedFile.exists()) {
	                            if (JOptionPane.showConfirmDialog(null, "Overwrite existing file?", null, 0, 2, this.iconw1) == 0) {
	                                n13 = 1;
	                            }
	                            else {
	                                n13 = 0;
	                                b = true;
	                            }
	                        }
	                        else {
	                            n13 = 1;
	                        }
	                    }
	                    else {
	                        n13 = 1;
	                        b = true;
	                    }
	                }
	                if (!b) {
	                    final PrintStream printStream = new PrintStream(new FileOutputStream(absolutePath));
	                    if (description.indexOf("html") > -1) {
	                        printStream.println(this.T2trgbp.toString());
	                    }
	                    else {
	                        printStream.println("              Table of possible Targets              ");
	                        printStream.println("+----------------+-------------+-----------+--------+");
	                        printStream.println("|  overs lost in | total overs |   overs   |        |");
	                        printStream.println("|current stoppage| in innings  | remaining | Target |");
	                        printStream.println("+----------------+-------------+-----------+--------+");
	                        String s = this.T2trgbpT.substring(0, this.T2trgbpT.length());
	                        for (int n14 = s.indexOf("</tr>"); n14 >= 0; n14 = s.indexOf("</tr>")) {
	                            printStream.println(s.substring(0, n14));
	                            s = s.substring(n14 + 5);
	                        }
	                        printStream.println("+----------------+-------------+-----------+--------+");
	                        final Date date3 = new Date();
	                        final SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy");
	                        if (s.indexOf("<br>") < 0) {
	                            printStream.println(s);
	                        }
	                        else {
	                            printStream.println(s.substring(0, s.indexOf("<br>")));
	                            printStream.println(s.substring(s.indexOf("<br>") + 4));
	                        }
	                        printStream.println("        (c) " + simpleDateFormat3.format(date3) + " International Cricket Council       ");
	                    }
	                    printStream.close();
	                }
	            }
	            catch (Exception ex3) {}
	        }
	    }
	    
	    
    @Override
    public void textValueChanged(final TextEvent textEvent) {
    	System.out.println("  ");
    	System.out.println(" **textValueChanged");
        if (this.bslctd) {
            this.hiliteoff();
        }
        this.bruns = false;
        this.bovers = false;
        this.bovers2 = false;
        System.out.println(textEvent.getSource());
        if (textEvent.getSource() == this.team1OversInnigsAtStartOfMatch || textEvent.getSource() == this.g3) {
            this.bovers = true;
        }
        for (int i = 0; i < this.nstprow; ++i) {
            if (textEvent.getSource() == this.tc1s[i] || textEvent.getSource() == this.th1s[i]) {
                this.bruns = true;
            }
            if (textEvent.getSource() == this.tbs[i] || textEvent.getSource() == this.tds[i]) {
                this.bovers = true;
            }
            if (textEvent.getSource() == this.tgs[i] || textEvent.getSource() == this.tis[i]) {
                this.bovers = true;
                this.bovers2 = true;
            }
        }
        this.a41.setText(" ");
        this.a41.setOpaque(false);
        this.a41.setBackground(Color.lightGray);
        this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
        this.bcde41.setText(" ");
        this.bcde41.setOpaque(false);
        this.bcde41.setBackground(Color.lightGray);
        this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
        this.f41.setText(" ");
        this.f41.setOpaque(false);
        this.f41.setBackground(Color.lightGray);
        this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.lightGray));
        this.ghij41.setText(" ");
        this.ghij41.setOpaque(false);
        this.ghij41.setBackground(Color.lightGray);
        this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.lightGray));
        this.g4.setForeground(Color.lightGray);
        if (textEvent.getSource() == this.team1FinalScore) {
            this.g4.setForeground(Color.pink);
        }
        this.d37.setText(" ");
        this.i37.setText(" ");
        if (!this.weird) {
            this.k3.setText(" ");
            this.k3.setBackground(Color.lightGray);
            this.k3.setForeground(Color.yellow);
            this.k4.setText(" ");
            this.k4.setBackground(Color.lightGray);
            this.k4.setForeground(Color.yellow);
            this.k4.setFont(new Font("Serif", 1, 14));
            this.RptSum.setEnabled(false);
        }
        else {
            this.weird = false;
        }
        this.defghi42.setText(" ");
        this.defghi42.setVisible(false);
        this.defghi42.setBackground(Color.lightGray);
        for (int j = 0; j < this.nstprow; ++j) {
            this.ljs[j].setText(" ");
        }
        this.j37.setText(" ");
        this.f41.setFont(new Font("Serif", 1, 12));
        this.abc41a.setForeground(Color.gray);
        this.Otble.setEnabled(false);
        this.Btble.setEnabled(false);
        this.bbasic1 = false;
        this.bbasic2 = false;
        this.b100 = false;
        this.b100a = false;
        this.bneg1 = false;
        this.bneg2 = false;
        this.bmaxo1 = false;
        this.bmaxo2 = false;
        this.bodb1 = false;
        this.bodb2 = false;
        this.boplyd1 = false;
        this.boplyd1a = false;
        this.boplyd2 = false;
        this.boplyd2a = false;
        this.brunord1 = false;
        this.brunord1a = false;
        this.brunord2 = false;
        this.brunord2a = false;
        this.bs1 = false;
        this.bs2 = false;
        this.bw91 = false;
        this.bw92 = false;
        this.bwint1 = false;
        this.bwint2 = false;
        this.bword1 = false;
        this.bword1a = false;
        this.bword2 = false;
        this.bword2a = false;
        this.bT2beforeT1 = false;
        this.babnd = false;
        this.babnd2 = false;
        this.babnda = false;
        this.babnd2a = false;
        this.bT2trg = false;
        this.bT2trg2 = false;
        this.bT2trg1 = false;
        this.bovrm1 = false;
        this.bovrm2 = false;
        this.bovrm1a = false;
        this.bovrm2a = false;
        this.bincon = false;
        this.bincon1 = false;
        this.bT2inp = false;
        this.calclte = true;
        this.calclte1 = true;
        this.calclte2 = true;
        this.chkallbut1 = false;
        this.chkallbut1a = false;
        this.btoofew = false;
        this.brslt = false;
        for (int k = 0; k < 61; ++k) {
            for (int l = 0; l < 4; ++l) {
                this.impty[k][l] = 0;
            }
        }
        if (this.otblopen & !this.bruns) {
            this.otblopen = false;
            this.otblfrm.setVisible(false);
        }
        if (this.btblopen & !this.bruns) {
            this.btblopen = false;
            this.btblfrm.setVisible(false);
        }
        if (this.RSopen) {
            this.RSopen = false;
            this.RSfrm.setVisible(false);
        }
        if (this.bT2open & !this.bruns) {
            this.T2trgf.removeWindowListener(this);
            this.T2trgf.dispose();
            this.abcdefghij43.setText(" ");
            this.bT2open = false;
            if (this.iT2trg < 0) {
                if (this.g3.getText().trim().indexOf("?") == 0) {
                    this.g3.setText("");
                }
            }
            else if (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0) {
                this.tis[this.iT2trg].setText("");
                final dlcalc monitor = this;
                Runnable runnable = new Runnable() {
    				public void run() {
    					 if (monitor.defghi42.getText().contains("?")) {
    						 monitor.defghi42.setText(" ");
    						 monitor.defghi42.setBackground(Color.lightGray);
    						 monitor.defghi42.setVisible(false);
    				        }
    				}
    			};
    			SwingUtilities.invokeLater(runnable);
    			
//                SwingUtilities.invokeLater((Runnable)new dlcalc.dlcalc$7(this));
            }
        }
        else if ((!this.bruns & this.iT2trg > -1) && (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0 & textEvent.getSource() != this.tis[this.iT2trg])) {
            this.tis[this.iT2trg].setText("");
        //    SwingUtilities.invokeLater((Runnable)new dlcalc.dlcalc$8(this));
            final dlcalc monitor = this;
            Runnable runnable = new Runnable() {
				public void run() {
					 if (monitor.defghi42.getText().contains("?")) {
						 monitor.defghi42.setText(" ");
						 monitor.defghi42.setBackground(Color.lightGray);
						 monitor.defghi42.setVisible(false);
				        }
				}
			};
			SwingUtilities.invokeLater(runnable);
        }
        try {
            this.ctmp1 = this.team1OversInnigsAtStartOfMatch.getText();
            this.ctmp = this.ctmp1.trim();
            if (this.ctmp.length() > 0) {
                if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                    this.bmaxo1 = true;
                    this.bbasic1 = true;
                }
                else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                    this.bneg1 = true;
                    this.bbasic1 = true;
                }
                else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                    this.bmaxo1 = true;
                    this.bbasic1 = true;
                }
                else {
                    this.dtmp = Double.valueOf(this.ctmp);
                    if (this.ctmp.indexOf(".") > -1) {
                        this.bmaxo1 = true;
                        this.bbasic1 = true;
                    }
                    else {
                        this.ntmp = Integer.valueOf(this.ctmp);
                        this.nb3 = this.ntmp;
                        if (this.nb3 < 0) {
                            this.bneg1 = true;
                            this.bbasic1 = true;
                        }
                        else if (this.nb3 > 99) {
                            this.b100 = true;
                            this.bbasic1 = true;
                        }
                    }
                }
            }
            else {
                this.nb3 = 0;
                this.impty[60][0] = 1;
                this.g4.setText(" ");
            }
            this.ctmp1 = this.g3.getText();
            this.ctmp = this.ctmp1.trim();
            if (this.ctmp.length() > 0) {
                if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                    this.bmaxo2 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                    this.bneg2 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                    this.bmaxo2 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 1 & this.ctmp.indexOf("?") == 0) {
                    this.bT2trg1 = true;
                    this.iT2trg = -1;
                    this.usrmx2 = true;
                    if (this.team1FinalScore.getText().trim().length() == 0) {
                        this.bT2beforeT1 = true;
                    }
                    this.ng3 = this.nb3;
                }
                else {
                    this.dtmp = Double.valueOf(this.ctmp);
                    if (this.ctmp.indexOf(".") > -1) {
                        this.bmaxo2 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.ntmp = Integer.valueOf(this.ctmp);
                        this.ng3 = this.ntmp;
                        if (this.ng3 > 99) {
                            this.b100a = true;
                            this.bbasic2 = true;
                        }
                        else if (textEvent.getSource() == this.g3) {
                            this.usrmx2 = true;
                        }
                    }
                }
            }
            else {
                this.ng3 = 0;
                this.impty[60][1] = 1;
                if (textEvent.getSource() == this.g3) {
                    this.usrmx2 = true;
                }
            }
            this.ctmp1 = this.team1FinalScore.getText();
            this.ctmp = this.ctmp1.trim();
            if (this.ctmp.length() > 0) {
                if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                    this.bs1 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                    this.bneg1 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                    this.bs1 = true;
                    this.bbasic2 = true;
                }
                else {
                    this.dtmp = Double.valueOf(this.ctmp);
                    if (this.ctmp.indexOf(".") > -1) {
                        this.bs1 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.ntmp = Integer.valueOf(this.ctmp);
                        this.nb4 = this.ntmp;
                        if (this.nb4 < 0) {
                            this.bneg1 = true;
                            this.bbasic2 = true;
                        }
                        else if (textEvent.getSource() == this.team1FinalScore) {
                            this.usrrn1 = true;
                        }
                    }
                }
            }
            else {
                this.nb4 = 0;
                this.impty[60][2] = 1;
                if (textEvent.getSource() == this.team1FinalScore) {
                    this.usrrn1 = true;
                }
                this.g4.setText(" ");
            }
            this.ctmp1 = this.i39.getText();
            this.ctmp = this.ctmp1.trim();
            if (this.ctmp.length() > 0) {
                if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                    this.bs2 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                    this.bneg2 = true;
                    this.bbasic2 = true;
                }
                else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                    this.bs2 = true;
                    this.bbasic2 = true;
                }
                else {
                    this.dtmp = Double.valueOf(this.ctmp);
                    if (this.ctmp.indexOf(".") > -1) {
                        this.bs2 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.ntmp = Integer.valueOf(this.ctmp);
                        this.ni39 = this.ntmp;
                        if (this.ni39 < 0) {
                            this.bneg2 = true;
                            this.bbasic2 = true;
                        }
                    }
                }
            }
            else {
                this.ni39 = 0;
            }
            this.dbs[0] = 0.0;
            this.dbsd[0] = 0.0;
            this.oplyd1 = 0.0;
            this.ncs[0] = 0;
            this.wckt1 = 0;
            this.nc1s[0] = 0;
            this.runs1 = 0;
            this.runs1a = 0;
            this.dds[0] = 0.0;
            this.ddsd[0] = 0.0;
            this.dgs[0] = 0.0;
            this.dgsd[0] = 0.0;
            this.oplyd2 = 0.0;
            this.nhs[0] = 0;
            this.wckt2 = 0;
            this.wckt2a = 0;
            this.nh1s[0] = 0;
            this.runs2 = 0;
            this.runs2a = 0;
            this.dis[0] = 0.0;
            this.disd[0] = 0.0;
            this.oltot1 = 0.0;
            this.oltot2 = 0.0;
            for (int iabnda = 0; iabnda < this.nstprow; ++iabnda) {
                this.ctmp1 = this.tbs[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.babnd) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.itmp = this.tbs[iabnda].getCaretPosition();
                        this.tbs[iabnda].setText(this.ctmp1.substring(0, this.ctmp1.indexOf(".")) + "0" + this.ctmp1.substring(this.ctmp1.indexOf(".")));
                        this.tbs[iabnda].setCaretPosition(this.itmp + 1);
                        this.dbs[iabnda + 1] = 0.0;
                        this.dbsd[iabnda + 1] = 0.0;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        this.dbs[iabnda + 1] = this.dtmp;
                        this.dbsd[iabnda + 1] = this.odbTodec(this.dbs[iabnda + 1]);
                        if (!this.bodb1 & this.chkOdB(this.ctmp)) {
                            this.bodb1 = true;
                            this.bbasic1 = true;
                        }
                        if (this.dbs[iabnda + 1] < 0.0) {
                            this.bneg1 = true;
                            this.bbasic1 = true;
                        }
                        if (this.dbsd[iabnda + 1] < this.oplyd1) {
                            this.bbasic1 = true;
                            if (textEvent.getSource() == this.tbs[iabnda]) {
                                if (!this.boplyd1a) {
                                    this.boplyd1 = true;
                                }
                            }
                            else {
                                this.boplyd1a = true;
                                this.boplyd1 = false;
                            }
                        }
                        else {
                            this.oplyd1 = this.dbsd[iabnda + 1];
                        }
                    }
                }
                else if (this.ctmp.length() > 0) {
                    this.babnd2 = true;
                    this.bbasic1 = true;
                }
                else {
                    this.dbs[iabnda + 1] = 0.0;
                    this.dbsd[iabnda + 1] = 0.0;
                    this.impty[iabnda][0] = 1;
                }
                this.ctmp1 = this.tcs[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.babnd) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.bwint1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bwint1 = true;
                        this.bbasic1 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        if (this.ctmp.indexOf(".") > -1) {
                            this.bwint1 = true;
                            this.bbasic1 = true;
                        }
                        else {
                            this.ntmp = Integer.valueOf(this.ctmp);
                            this.ncs[iabnda + 1] = this.ntmp;
                            if (this.ncs[iabnda + 1] < 0) {
                                this.bneg1 = true;
                                this.bbasic1 = true;
                            }
                            else if (this.ncs[iabnda + 1] > 10) {
                                this.bw91 = true;
                                this.bbasic1 = true;
                            }
                        }
                        if (this.ncs[iabnda + 1] < this.wckt1) {
                            this.bbasic1 = true;
                            if (textEvent.getSource() == this.tcs[iabnda]) {
                                if (!this.bword1a) {
                                    this.bword1 = true;
                                }
                            }
                            else {
                                this.bword1a = true;
                                this.bword1 = false;
                            }
                        }
                        else if (this.ncs[iabnda + 1] == 10 & this.wckt1 == 10) {
                            this.bword1a = true;
                            this.bbasic1 = true;
                        }
                        else {
                            this.wckt1 = this.ncs[iabnda + 1];
                        }
                    }
                }
                else if (this.ctmp.length() > 0) {
                    this.babnd2 = true;
                    this.bbasic1 = true;
                }
                else {
                    this.ncs[iabnda + 1] = 0;
                    this.impty[iabnda][1] = 1;
                }
                this.ctmp1 = this.tc1s[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.babnd) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.bwint1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bwint1 = true;
                        this.bbasic1 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        if (this.ctmp.indexOf(".") > -1) {
                            this.bwint1 = true;
                            this.bbasic1 = true;
                        }
                        else {
                            this.ntmp = Integer.valueOf(this.ctmp);
                            this.nc1s[iabnda + 1] = this.ntmp;
                            if (this.nc1s[iabnda + 1] < 0) {
                                this.bneg1 = true;
                                this.bbasic1 = true;
                            }
                        }
                        if (this.nc1s[iabnda + 1] < this.runs1) {
                            this.bbasic1 = true;
                            if (textEvent.getSource() == this.tc1s[iabnda]) {
                                if (!this.brunord1a) {
                                    this.brunord1 = true;
                                }
                            }
                            else {
                                this.brunord1a = true;
                                this.brunord1 = false;
                            }
                        }
                        else {
                            this.runs1 = this.nc1s[iabnda + 1];
                        }
                    }
                }
                else {
                    this.nc1s[iabnda + 1] = 0;
                    this.impty[iabnda][3] = 1;
                }
                this.ctmp1 = this.tds[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.babnd) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.itmp = this.tds[iabnda].getCaretPosition();
                        this.tds[iabnda].setText(this.ctmp1.substring(0, this.ctmp1.indexOf(".")) + "0" + this.ctmp1.substring(this.ctmp1.indexOf(".")));
                        this.tds[iabnda].setCaretPosition(this.itmp + 1);
                        this.dds[iabnda + 1] = 0.0;
                        this.ddsd[iabnda + 1] = 0.0;
                        this.oltot1 += this.ddsd[iabnda + 1];
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bneg1 = true;
                        this.bbasic1 = true;
                    }
                    else if (this.ctmp.length() == 1 & (this.ctmp.indexOf("a") == 0 || this.ctmp.indexOf("A") == 0)) {
                        this.ddsd[iabnda + 1] = this.nb3 - this.dbsd[iabnda + 1];
                        for (int n = 0; n < iabnda + 1; ++n) {
                            this.ddsd[iabnda + 1] -= this.ddsd[n];
                        }
                        if (this.ddsd[iabnda + 1] > 0.01) {
                            this.babnd = true;
                        }
                        else {
                            this.babnd = true;
                            this.babnd2 = true;
                            this.bbasic1 = true;
                        }
                        this.iabnd = iabnda;
                        this.oltot1 += this.ddsd[iabnda + 1];
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        this.dds[iabnda + 1] = this.dtmp;
                        this.ddsd[iabnda + 1] = this.odbTodec(this.dds[iabnda + 1]);
                        if (!this.bodb1 & this.chkOdB(this.ctmp)) {
                            this.bodb1 = true;
                            this.bbasic1 = true;
                        }
                        if (this.dds[iabnda + 1] < 0.0) {
                            this.bneg1 = true;
                            this.bbasic1 = true;
                        }
                        this.oltot1 += this.ddsd[iabnda + 1];
                    }
                }
                else if (this.ctmp.length() > 0) {
                    this.babnd2 = true;
                    this.bbasic1 = true;
                }
                else {
                    this.dds[iabnda + 1] = 0.0;
                    this.ddsd[iabnda + 1] = 0.0;
                    this.impty[iabnda][2] = 1;
                }
                this.ctmp1 = this.tgs[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.bT2trg1 & !this.babnda & !this.bT2trg) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.itmp = this.tgs[iabnda].getCaretPosition();
                        this.tgs[iabnda].setText(this.ctmp1.substring(0, this.ctmp1.indexOf(".")) + "0" + this.ctmp1.substring(this.ctmp1.indexOf(".")));
                        this.tgs[iabnda].setCaretPosition(this.itmp + 1);
                        this.dgs[iabnda + 1] = 0.0;
                        this.dgsd[iabnda + 1] = 0.0;
                        if (this.team1FinalScore.getText().trim().length() == 0) {
                            this.bT2beforeT1 = true;
                        }
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        this.dgs[iabnda + 1] = this.dtmp;
                        this.dgsd[iabnda + 1] = this.odbTodec(this.dgs[iabnda + 1]);
                        if (!this.bodb2 & this.chkOdB(this.ctmp)) {
                            this.bodb2 = true;
                            this.bbasic2 = true;
                        }
                        else if (this.dgs[iabnda + 1] < 0.0) {
                            this.bneg2 = true;
                            this.bbasic2 = true;
                        }
                        else if (this.team1FinalScore.getText().trim().length() == 0) {
                            this.bT2beforeT1 = true;
                        }
                        if (this.dgsd[iabnda + 1] < this.oplyd2) {
                            this.bbasic2 = true;
                            if (textEvent.getSource() == this.tgs[iabnda]) {
                                if (!this.boplyd2a) {
                                    this.boplyd2 = true;
                                }
                            }
                            else {
                                this.boplyd2a = true;
                                this.boplyd2 = false;
                            }
                        }
                        else {
                            this.oplyd2 = this.dgsd[iabnda + 1];
                        }
                    }
                }
                else if (this.ctmp.length() > 0) {
                    if (this.babnda) {
                        this.babnd2a = true;
                    }
                    else {
                        this.bT2trg2 = true;
                    }
                    this.bbasic2 = true;
                }
                else {
                    this.dgs[iabnda + 1] = 0.0;
                    this.dgsd[iabnda + 1] = 0.0;
                    this.impty[iabnda + 30][0] = 1;
                }
                this.ctmp1 = this.ths[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.bT2trg1) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.bwint2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bwint2 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        if (this.ctmp.indexOf(".") > -1) {
                            this.bwint2 = true;
                            this.bbasic2 = true;
                        }
                        else {
                            this.ntmp = Integer.valueOf(this.ctmp);
                            this.nhs[iabnda + 1] = this.ntmp;
                            if (this.nhs[iabnda + 1] < 0) {
                                this.bneg2 = true;
                                this.bbasic2 = true;
                            }
                            else if (this.nhs[iabnda + 1] > 10) {
                                this.bw92 = true;
                                this.bbasic2 = true;
                            }
                            else if (this.team1FinalScore.getText().trim().length() == 0) {
                                this.bT2beforeT1 = true;
                            }
                        }
                        if (this.nhs[iabnda + 1] < this.wckt2) {
                            this.bbasic2 = true;
                            if (textEvent.getSource() == this.ths[iabnda]) {
                                if (!this.bword2a) {
                                    this.bword2 = true;
                                }
                            }
                            else {
                                this.bword2a = true;
                                this.bword2 = false;
                            }
                        }
                        else if (this.nhs[iabnda + 1] == 10 & this.wckt2 == 10) {
                            this.bword2a = true;
                            this.bbasic2 = true;
                        }
                        else {
                            this.wckt2 = this.nhs[iabnda + 1];
                        }
                    }
                }
                else if (this.ctmp.length() > 0) {
                    if (this.babnda) {
                        this.babnd2a = true;
                    }
                    else {
                        this.bT2trg2 = true;
                    }
                    this.bbasic2 = true;
                }
                else {
                    this.nhs[iabnda + 1] = 0;
                    this.impty[iabnda + 30][1] = 1;
                }
                this.ctmp1 = this.th1s[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.bT2trg1 & !this.babnda & !this.bT2trg) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.bwint2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bwint2 = true;
                        this.bbasic2 = true;
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        if (this.ctmp.indexOf(".") > -1) {
                            this.bwint2 = true;
                            this.bbasic2 = true;
                        }
                        else {
                            this.ntmp = Integer.valueOf(this.ctmp);
                            this.nh1s[iabnda + 1] = this.ntmp;
                            if (this.nh1s[iabnda + 1] < 0) {
                                this.bneg2 = true;
                            }
                            else if (this.team1FinalScore.getText().trim().length() == 0) {
                                this.bT2beforeT1 = true;
                            }
                        }
                        if (this.nh1s[iabnda + 1] < this.runs2) {
                            this.bbasic2 = true;
                            if (textEvent.getSource() == this.th1s[iabnda]) {
                                if (!this.brunord2a) {
                                    this.brunord2 = true;
                                }
                            }
                            else {
                                this.brunord2a = true;
                                this.brunord2 = false;
                            }
                        }
                        else {
                            this.runs2 = this.nh1s[iabnda + 1];
                        }
                    }
                }
                else if (this.ctmp.length() > 0) {
                    if (this.babnda) {
                        this.babnd2a = true;
                    }
                    else {
                        this.bT2trg2 = true;
                    }
                    this.bbasic2 = true;
                }
                else {
                    this.nh1s[iabnda + 1] = 0;
                    this.impty[iabnda + 30][3] = 1;
                }
                this.ctmp1 = this.tis[iabnda].getText();
                this.ctmp = this.ctmp1.trim();
                if (this.ctmp.length() > 0 & !this.bT2trg1 & !this.babnda & !this.bT2trg) {
                    if (this.ctmp.length() == 1 & this.ctmp.indexOf(".") == 0) {
                        this.itmp = this.tis[iabnda].getCaretPosition();
                        this.tis[iabnda].setText(this.ctmp1.substring(0, this.ctmp1.indexOf(".")) + "0" + this.ctmp1.substring(this.ctmp1.indexOf(".")));
                        this.tis[iabnda].setCaretPosition(this.itmp + 1);
                        this.dis[iabnda + 1] = 0.0;
                        this.disd[iabnda + 1] = 0.0;
                        this.oltot2 += this.disd[iabnda + 1];
                        if (this.team1FinalScore.getText().trim().length() == 0) {
                            this.bT2beforeT1 = true;
                        }
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("-") == 0) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 2 & this.ctmp.indexOf("-") == 0 & this.ctmp.indexOf(".") == 1) {
                        this.bneg2 = true;
                        this.bbasic2 = true;
                    }
                    else if (this.ctmp.length() == 1 & this.ctmp.indexOf("?") == 0) {
                        this.disd[iabnda + 1] = 0.0;
                        this.bT2trg = true;
                        this.iT2trg = iabnda;
                        if (this.team1FinalScore.getText().trim().length() == 0) {
                            this.bT2beforeT1 = true;
                        }
                        this.oltot2 += this.disd[iabnda + 1];
                    }
                    else if (this.ctmp.length() == 1 & (this.ctmp.indexOf("a") == 0 || this.ctmp.indexOf("A") == 0)) {
                        this.disd[iabnda + 1] = this.ng3 - this.dgsd[iabnda + 1];
                        for (int n2 = 0; n2 < iabnda + 1; ++n2) {
                            this.disd[iabnda + 1] -= this.disd[n2];
                        }
                        if (this.disd[iabnda + 1] > 0.01) {
                            this.babnda = true;
                        }
                        else {
                            this.babnda = true;
                            this.babnd2a = true;
                            this.bbasic2 = true;
                        }
                        this.iabnda = iabnda;
                        this.oltot2 += this.disd[iabnda + 1];
                    }
                    else {
                        this.dtmp = Double.valueOf(this.ctmp);
                        this.dis[iabnda + 1] = this.dtmp;
                        this.disd[iabnda + 1] = this.odbTodec(this.dis[iabnda + 1]);
                        if (!this.bodb2 & this.chkOdB(this.ctmp)) {
                            this.bodb2 = true;
                            this.bbasic2 = true;
                        }
                        else if (this.dis[iabnda + 1] < 0.0) {
                            this.bneg2 = true;
                            this.bbasic2 = true;
                        }
                        else if (this.team1FinalScore.getText().trim().length() == 0) {
                            this.bT2beforeT1 = true;
                        }
                        this.oltot2 += this.disd[iabnda + 1];
                    }
                }
                else if (this.ctmp.length() > 0) {
                    if (this.babnda) {
                        this.babnd2a = true;
                    }
                    else {
                        this.bT2trg2 = true;
                    }
                    this.bbasic2 = true;
                }
                else {
                    this.dis[iabnda + 1] = 0.0;
                    this.disd[iabnda + 1] = 0.0;
                    this.impty[iabnda + 30][2] = 1;
                }
            }
            if (!this.bbasic1) {
                this.omax1 = this.nb3;
                if (this.oltot1 + this.oplyd1 > this.omax1 + 0.01) {
                    this.bovrm1 = true;
                    this.bovrm1a = false;
                    if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch) {
                        this.bovrm1a = true;
                        this.bovrm1 = false;
                    }
                    this.bbasic1 = true;
                    this.calclte = false;
                    this.calclte1 = false;
                }
                if (!this.bovrm1 & !this.bovrm1a) {
                    if (this.team1OversInnigsAtStartOfMatch.getText().trim().length() > 0) {
                        this.d37.setText(this.decToodb(this.omax1 - this.oltot1));
                        if (this.omax1 - this.oltot1 < this.minover) {
                            this.calclte = false;
                            if (textEvent.getSource() == this.team1OversInnigsAtStartOfMatch) {
                                this.btoofew = true;
                            }
                            else {
                                this.btoofew = true;
                                this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                this.k3.setBackground(dlcalc.ornge);
                                this.k4.setText("<html>&nbsp; No Result");
                                this.k4.setBackground(dlcalc.ornge);
                                this.RptSum.setEnabled(true);
                                this.rsltcde = 0;
                                this.rsltdes = "NO RESULT; Par Score: ";
                            }
                        }
                    }
                    else {
                        this.d37.setText(" ");
                    }
                }
                else {
                    this.d37.setText(" ");
                }
            }
            if (!this.bbasic1 && (this.runs1 > (double)this.nb4 & this.impty[60][2] == 0 & this.usrrn1)) {
                this.bbasic1 = true;
                this.calclte = false;
                this.calclte1 = false;
                boolean b = true;
                if (this.runs1 > 99 & this.nb4 == this.runs1 / 100) {
                    b = false;
                }
                else if (this.runs1 > 9 & this.nb4 == this.runs1 / 10) {
                    b = false;
                }
                else if (this.omax1 - this.oplyd1 - this.oltot1 > 0.01) {
                    if (this.runs1 > 99) {
                        if (this.nb4 < 10) {
                            if (this.nb4 >= this.runs1 / 100) {
                                b = false;
                            }
                        }
                        else if (this.nb4 < 100) {
                            if (this.nb4 >= this.runs1 / 10) {
                                b = false;
                            }
                        }
                        else if (this.nb4 >= this.runs1) {
                            b = false;
                        }
                    }
                    else {
                        b = false;
                    }
                }
                if (textEvent.getSource() != this.team1FinalScore || b) {
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Max. runs scored < T1 final score");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (textEvent.getSource() == this.team1FinalScore) {
                    if (!this.brunord1a) {
                        this.brunord1 = true;
                    }
                }
                else {
                    this.brunord1a = true;
                    this.brunord1 = false;
                    this.calclte1 = false;
                }
            }
            if (!this.bbasic2) {
                this.omax2 = this.ng3;
                if (this.usrmx2 & !this.bT2trg1) {
                    if (!this.bSplt && this.omax1 - this.oltot1 < this.omax2) {
                        this.ctmp1 = this.team1OversInnigsAtStartOfMatch.getText();
                        this.ctmp = this.ctmp1.trim();
                        if (this.ctmp.length() > 0) {
                            this.ctmp1 = this.decToodb(Math.floor(this.omax1 - this.oltot1));
                            if (textEvent.getSource() == this.g3) {
                                this.f41.setText("ERROR: ");
                                this.f41.setOpaque(true);
                                this.f41.setBackground(Color.yellow);
                                this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                                this.ghij41.setText("2nd inn. max. > 1st inn. available overs");
                                this.ghij41.setOpaque(true);
                                this.ghij41.setBackground(Color.yellow);
                                this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                                this.bbasic2 = true;
                                this.calclte2 = false;
                                this.calclte = false;
                            }
                            else {
                                if (Double.valueOf(this.ctmp1) > 99.0) {
                                    this.g3.setText("");
                                }
                                else {
                                    this.g3.setText(this.ctmp1);
                                }
                                this.ntmp = Integer.valueOf(this.ctmp);
                                this.ng3 = this.ntmp;
                                this.omax2 = this.ng3;
                                this.usrmx2 = false;
                                this.impty[60][1] = 0;
                                if (this.babnda & !this.babnd2a) {
                                    this.disd[this.iabnda + 1] = this.ng3 - this.dgsd[this.iabnda + 1];
                                    for (int n3 = 0; n3 < this.iabnda + 1; ++n3) {
                                        this.disd[this.iabnda + 1] -= this.disd[n3];
                                    }
                                    if (this.disd[this.iabnda + 1] <= 0.01) {
                                        this.babnd2a = true;
                                        this.bbasic2 = true;
                                    }
                                    this.oltot2 = this.ng3 - this.oplyd2;
                                }
                            }
                        }
                        else if (textEvent.getSource() == this.g3) {
                            this.f41.setText("WARNING: ");
                            this.f41.setOpaque(true);
                            this.f41.setBackground(Color.yellow);
                            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                            this.ghij41.setText("no first innings overs/side entered");
                            this.ghij41.setOpaque(true);
                            this.ghij41.setBackground(Color.yellow);
                            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                            if (this.team1FinalScore.getText().trim().length() == 0) {
                                this.bT2beforeT1 = true;
                            }
                        }
                        else {
                            this.g3.setText("");
                            this.ng3 = 0;
                            this.omax2 = this.ng3;
                            this.usrmx2 = false;
                            this.impty[60][1] = 1;
                        }
                    }
                }
                else if (!this.bT2trg1) {
                    this.ctmp1 = this.team1OversInnigsAtStartOfMatch.getText();
                    this.ctmp = this.ctmp1.trim();
                    if (this.ctmp.length() > 0) {
                        this.ctmp1 = this.decToodb(Math.floor(this.omax1 - this.oltot1));
                        if (Double.valueOf(this.ctmp1) > 99.0) {
                            this.g3.setText("");
                        }
                        else {
                            this.g3.setText(this.ctmp1);
                        }
                        this.ng3 = (int)Math.floor(this.omax1 - this.oltot1);
                        this.omax2 = this.ng3;
                        this.impty[60][1] = 0;
                        if (this.babnda & !this.babnd2a) {
                            this.disd[this.iabnda + 1] = this.ng3 - this.dgsd[this.iabnda + 1];
                            for (int n4 = 0; n4 < this.iabnda + 1; ++n4) {
                                this.disd[this.iabnda + 1] -= this.disd[n4];
                            }
                            if (this.disd[this.iabnda + 1] <= 0.01) {
                                this.babnd2a = true;
                                this.bbasic2 = true;
                            }
                            this.oltot2 = this.ng3 - this.oplyd2;
                        }
                    }
                    else {
                        this.g3.setText("");
                        this.ng3 = 0;
                        this.omax2 = this.ng3;
                        this.impty[60][1] = 1;
                    }
                }
                if (this.oltot2 + this.oplyd2 > this.omax2 + 0.01) {
                    this.bovrm2 = true;
                    this.bovrm2a = false;
                    if (textEvent.getSource() != this.g3 & textEvent.getSource() != this.team1OversInnigsAtStartOfMatch) {
                        this.bovrm2a = true;
                        this.bovrm2 = false;
                        this.f41.setText("ERROR: ");
                        this.f41.setOpaque(true);
                        this.f41.setBackground(Color.yellow);
                        this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                        this.ghij41.setText("Overs bowled + lost > max. overs");
                        this.ghij41.setOpaque(true);
                        this.ghij41.setBackground(Color.yellow);
                        this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                    }
                    this.bbasic2 = true;
                    this.calclte = false;
                    this.calclte2 = false;
                }
                if (!this.bovrm2 & !this.bovrm2a) {
                    if (this.g3.getText().trim().length() > 0) {
                        if (this.g3.getText().trim().indexOf("?") == 0) {
                            this.i37.setText("?");
                        }
                        else {
                            this.i37.setText(this.decToodb(this.omax2 - this.oltot2));
                            if (this.omax2 - this.oltot2 < this.minover) {
                                if (textEvent.getSource() == this.team1OversInnigsAtStartOfMatch || textEvent.getSource() == this.g3) {
                                    this.btoofew = true;
                                }
                                else {
                                    this.btoofew = true;
                                }
                            }
                        }
                    }
                    else {
                        this.i37.setText(" ");
                    }
                }
            }
            if (this.bbasic1 || this.bbasic2) {
                this.calclte = false;
                if (this.bneg1) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Negative values not allowed");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.b100) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Overs/innings must be < 100");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.babnd2) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Improper use of 'a' or 'A'");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bs1) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Score must be whole number");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bodb1) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Invalid 'overs.balls' entry");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bwint1) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Wickets/runs must be whole numbers");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bw91) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Wickets down must be 10 or less");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bmaxo1) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Overs/innings must be whole number");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.boplyd1a) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("'Overs.balls bowled' values out of order");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bword1a) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Wicket values out of order");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.brunord1a) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("'Runs scored' values out of order");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bovrm1a) {
                    this.calclte1 = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Overs bowled + lost > max. overs");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.boplyd1 || this.brunord1 || this.bovrm1) {
                    this.calclte1 = false;
                }
                if (this.bneg2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Negative values not allowed");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.b100a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Overs/innings must be < 100");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bT2trg2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Improper use of '?'");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.babnd2a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Improper use of 'a' or 'A'");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bs2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Runs must be whole number");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bodb2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Invalid 'overs.balls' entry");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bwint2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Wicket/runs must be whole numbers");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bw92) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Wickets down must be 10 or less");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bmaxo2) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Overs/innings must be whole number");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.boplyd2a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("'Overs.balls bowled' values out of order");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bword2a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Wicket values out of order");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.brunord2a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("'Runs scored' values out of order");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.bovrm2a) {
                    this.calclte2 = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Overs bowled + lost > max. overs");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
                else if (this.boplyd2 || this.brunord2 || this.bovrm2 || this.bword1 || this.bword2) {
                    this.calclte2 = false;
                }
            }
            if (this.calclte) {
                this.itmp = this.impty[60][0] + this.impty[60][1] + this.impty[60][2];
                if (this.itmp > 0) {
                    this.calclte = false;
                }
                this.iPtrg = 0;
                this.iPtrga = 0;
                for (int n5 = 0; n5 < this.nstprow; ++n5) {
                    this.itmp = this.impty[n5][0] + this.impty[n5][1] + this.impty[n5][2];
                    this.rowcnt1[n5] = this.itmp;
                    if (this.itmp == 1) {
                        this.calclte = false;
                        this.calclte1 = false;
                    }
                    else if (this.itmp == 2) {
                        this.calclte = false;
                        this.calclte1 = false;
                    }
                    this.itmp = this.impty[n5 + 30][0] + this.impty[n5 + 30][1] + this.impty[n5 + 30][2];
                    this.rowcnt2[n5] = this.itmp;
                    if (this.itmp == 1) {
                        this.calclte = false;
                        this.calclte2 = false;
                    }
                    else if (this.itmp == 2) {
                        this.calclte = false;
                        this.calclte2 = false;
                    }
                    if (this.itmp + this.impty[n5 + 30][3] < 4) {
                        this.bT2inp = true;
                    }
                }
                int nstprow = this.nstprow;
                int nstprow2 = this.nstprow;
                for (int n6 = 0; n6 < this.nstprow; ++n6) {
                    if (nstprow == this.nstprow & this.rowcnt2[n6] > 0) {
                        nstprow = n6;
                    }
                    if (nstprow2 == this.nstprow & this.rowcnt1[n6] > 0) {
                        nstprow2 = n6;
                    }
                }
                if (nstprow < this.nstprow & this.rowcnt2[nstprow] == 1 & this.impty[nstprow + 30][2] == 1) {
                    this.chkallbut1 = true;
                    if ((this.iPtrg = nstprow) < this.nstprow - 1) {
                        for (int n7 = nstprow + 1; n7 < this.nstprow; ++n7) {
                            if (this.rowcnt2[n7] < 3) {
                                this.chkallbut1 = false;
                            }
                        }
                    }
                }
                if (nstprow2 < this.nstprow & this.rowcnt1[nstprow2] == 1 & this.impty[nstprow2][2] == 1) {
                    this.chkallbut1a = true;
                    if ((this.iPtrga = nstprow2) < this.nstprow - 1) {
                        for (int n8 = nstprow2 + 1; n8 < this.nstprow; ++n8) {
                            if (this.rowcnt1[n8] < 3) {
                                this.chkallbut1a = false;
                            }
                        }
                    }
                }
                if ((this.chkallbut1 & this.calclte1 & textEvent.getSource() == this.tis[this.iPtrg]) && (this.tis[this.iPtrg].getText().trim().length() == 0 & this.wckt2 < 10 & !this.bT2beforeT1 & this.impty[30 + this.iPtrg][0] + this.impty[30 + this.iPtrg][1] == 0) && (this.omax2 - this.oltot2 - this.oplyd2 > 0.01 & !this.bslctd)) {
                    this.defghi42.setText("<html><b>NOTE:</b> Enter '<b>a</b>' to abandon innings or '<b>?</b>' for table of possible Targets");
                    this.defghi42.setVisible(true);
                    this.defghi42.setBackground(dlcalc.orng1);
                }
                if ((this.chkallbut1a & textEvent.getSource() == this.tds[this.iPtrga]) && (this.tds[this.iPtrga].getText().trim().length() == 0 & this.wckt1 < 10 & this.impty[this.iPtrg][0] + this.impty[this.iPtrg][1] == 0) && (this.omax1 - this.oltot1 - this.oplyd1 > 0.01 & !this.bslctd)) {
                    this.defghi42.setText("<html><b>NOTE:</b> Enter '<b>a</b>' to abandon innings");
                    this.defghi42.setVisible(true);
                    this.defghi42.setBackground(dlcalc.orng1);
                }
            }
            if (textEvent.getSource() == this.g3 & this.calclte1 & this.impty[60][0] + this.impty[60][2] == 0 & this.g3.getText().trim().length() == 0 & !this.bT2inp & !this.bslctd) {
                this.defghi42.setText("<html><b>NOTE:</b> Enter '<b>?</b>' for table of possible Targets");
                this.defghi42.setVisible(true);
                this.defghi42.setBackground(dlcalc.orng1);
            }
            if (this.d37.getText().trim().length() > 0 || this.wckt1 == 10) {
                double odbTodec = 0.0;
                if (this.d37.getText().trim().length() > 0) {
                    odbTodec = this.odbTodec(Double.valueOf(this.d37.getText()));
                }
                if ((Math.abs(odbTodec - this.oplyd1) < 0.01 & textEvent.getSource() != this.team1OversInnigsAtStartOfMatch) || this.wckt1 == 10) {
                    int n9 = 0;
                    for (int n10 = 0; n10 < this.nstprow; ++n10) {
                        if (this.impty[n10][0] == 0) {
                            n9 = n10;
                        }
                    }
                    int n11 = 0;
                    for (int n12 = 0; n12 < this.nstprow; ++n12) {
                        if (this.impty[n12][1] == 0) {
                            n11 = n12;
                        }
                    }
                    if (!this.usrrn1 & textEvent.getSource() != this.team1FinalScore) {
                        if ((this.tc1s[n9].getText().trim().length() > 0 & this.wckt1 < 10) || (this.tc1s[n11].getText().trim().length() > 0 & this.wckt1 == 10)) {
                            this.team1FinalScore.setText(new Integer(this.runs1).toString());
                            this.bT2beforeT1 = false;
                            this.nb4 = this.runs1;
                            this.impty[60][2] = 0;
                            if (this.calclte2 & this.impty[60][0] + this.impty[60][1] == 0 & (this.calclte1 || this.chkallbut1a)) {
                                this.calclte = true;
                            }
                        }
                        else {
                            this.team1FinalScore.setText("");
                            this.nb4 = this.runs1;
                            this.impty[60][2] = 1;
                            this.calclte = false;
                            for (int n13 = 0; n13 < this.nstprow; ++n13) {
                                for (int n14 = 0; n14 < 4; ++n14) {
                                    if (this.impty[30 + n13][n14] == 0) {
                                        this.bT2beforeT1 = true;
                                    }
                                }
                            }
                        }
                    }
                    else if (this.team1FinalScore.getText().trim().length() > 0 & this.nb4 < this.runs1) {
                        boolean b2 = true;
                        if (this.runs1 > 99 & this.nb4 == this.runs1 / 100) {
                            b2 = false;
                        }
                        else if (this.runs1 > 9 & this.nb4 == this.runs1 / 10) {
                            b2 = false;
                        }
                        else if (this.omax1 - this.oplyd1 - this.oltot1 > 0.01) {
                            if (this.runs1 > 99) {
                                if (this.nb4 < 10) {
                                    if (this.nb4 >= this.runs1 / 100) {
                                        b2 = false;
                                    }
                                }
                                else if (this.nb4 < 100) {
                                    if (this.nb4 >= this.runs1 / 10) {
                                        b2 = false;
                                    }
                                }
                                else if (this.nb4 >= this.runs1) {
                                    b2 = false;
                                }
                            }
                            else {
                                b2 = false;
                            }
                        }
                        if (textEvent.getSource() != this.team1FinalScore || b2) {
                            this.a41.setText("ERROR: ");
                            this.a41.setOpaque(true);
                            this.a41.setBackground(Color.yellow);
                            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                            this.bcde41.setText("Max. runs scored < T1 final score");
                            this.bcde41.setOpaque(true);
                            this.bcde41.setBackground(Color.yellow);
                            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                            this.calclte = false;
                        }
                    }
                    else if (this.team1FinalScore.getText().trim().length() > 0 & this.nb4 > this.runs1 & this.impty[n9][3] == 0) {
                        this.a41.setText("ERROR: ");
                        this.a41.setOpaque(true);
                        this.a41.setBackground(Color.yellow);
                        this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                        this.bcde41.setText("Inconsistency in input values");
                        this.bcde41.setOpaque(true);
                        this.bcde41.setBackground(Color.yellow);
                        this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                        this.calclte = false;
                        this.calclte1 = false;
                        this.bincon = true;
                        this.bincon1 = true;
                    }
                    else if ((this.team1FinalScore.getText().trim().length() > 0 & this.nb4 == this.runs1 & this.impty[n9][3] == 0) && (this.calclte2 & this.impty[60][0] + this.impty[60][1] == 0 & (this.calclte1 || this.chkallbut1a))) {
                        this.calclte = true;
                    }
                }
                else if (Math.abs(odbTodec - this.oplyd1) >= 0.01 & !this.usrrn1) {
                    this.team1FinalScore.setText("");
                    this.nb4 = 0;
                    this.impty[60][2] = 1;
                    this.calclte = false;
                    for (int n15 = 0; n15 < this.nstprow; ++n15) {
                        for (int n16 = 0; n16 < 4; ++n16) {
                            if (this.impty[30 + n15][n16] == 0) {
                                this.bT2beforeT1 = true;
                            }
                        }
                    }
                }
            }
            else if (!this.usrrn1 & !this.calclte1) {
                this.team1FinalScore.setText("");
                this.nb4 = 0;
                this.impty[60][2] = 1;
                this.calclte = false;
                for (int n17 = 0; n17 < this.nstprow; ++n17) {
                    for (int n18 = 0; n18 < 4; ++n18) {
                        if (this.impty[30 + n17][n18] == 0) {
                            this.bT2beforeT1 = true;
                        }
                    }
                }
            }
            if (this.bT2beforeT1 & textEvent.getSource() != this.team1FinalScore) {
                this.defghi42.setText("<html><b>WARNING:</b> Team 1's final score is not yet entered");
                this.defghi42.setVisible(true);
                this.defghi42.setBackground(dlcalc.orng1);
                this.calclte = false;
            }
            if ((this.calclte1 || this.chkallbut1a) & this.wckt1 == 10) {
                int n19 = 0;
                for (int n20 = 0; n20 < this.nstprow; ++n20) {
                    if (this.impty[n20][1] == 0) {
                        n19 = n20;
                    }
                }
                if (this.ddsd[n19 + 1] > 0.01) {
                    this.calclte1 = false;
                    this.calclte = false;
                    this.a41.setText("ERROR: ");
                    this.a41.setOpaque(true);
                    this.a41.setBackground(Color.yellow);
                    this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.bcde41.setText("Inconsistency in input values");
                    this.bcde41.setOpaque(true);
                    this.bcde41.setBackground(Color.yellow);
                    this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                }
            }
            if (this.calclte) {
                this.lstrow2 = -1;
                for (int lstrow2 = 0; lstrow2 < this.nstprow; ++lstrow2) {
                    if (this.impty[30 + lstrow2][2] == 0) {
                        this.lstrow2 = lstrow2;
                    }
                }
                this.lstrow1 = -1;
                for (int lstrow3 = 0; lstrow3 < this.nstprow; ++lstrow3) {
                    if (this.impty[lstrow3][2] == 0) {
                        this.lstrow1 = lstrow3;
                    }
                }
                if (this.lstrow2 > -1) {
                    this.lmbfct = this.lmbfun();
                    this.adjfct = this.adjfun(this.lmbfct);
                    for (int n21 = 0; n21 < this.lstrow2 + 1; ++n21) {
                        if (this.impty[30 + n21][3] == 0) {
                            this.trgttst1 = this.trgfuntst1(this.adjfct, this.lmbfct, n21);
                            if (this.nh1s[n21 + 1] >= this.trgttst1 & (n21 < this.lstrow2 || this.wckt2 == 10 || this.disd[n21 + 1] > 0.01)) {
                                this.bincon = true;
                                this.calclte = false;
                            }
                            else if (this.nh1s[n21 + 1] >= this.trgttst1 || this.wckt2 == 10) {
                                this.brslt = true;
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                            if (n21 < this.lstrow2) {
                                this.trgttst2 = this.trgfuntst1(this.adjfct, this.lmbfct, n21 + 1);
                                if (this.nh1s[n21 + 1] >= this.trgttst2) {
                                    this.bincon = true;
                                    this.calclte = false;
                                }
                            }
                            else if (!this.babnda & this.bAT) {
                                this.trgttst2 = this.trgfuntst2(this.adjfct, this.lmbfct, n21 + 1);
                                if (this.nh1s[n21 + 1] >= this.trgttst2) {
                                    final double n22 = this.disd[this.lstrow2 + 1];
                                    double n23 = 0.0;
                                    for (int n24 = 1; n24 < (int)Math.ceil(this.olft2 + n22); ++n24) {
                                        this.disd[this.lstrow2 + 1] = n24;
                                        if (this.nh1s[this.lstrow2 + 1] < this.trgfun(this.adjfct, this.lmbfct)) {
                                            n23 = this.disd[this.lstrow2 + 1];
                                        }
                                    }
                                    double n25;
                                    if (n23 < n22 - 1.0) {
                                        n25 = n23 + 1.0;
                                    }
                                    else {
                                        n25 = n22;
                                    }
                                    if (this.omax2 - this.oltot2 + n22 - n25 < this.minover - 0.01) {
                                        this.btoofew = true;
                                        this.disd[this.lstrow2 + 1] = n22;
                                    }
                                    else {
                                        this.disd[this.lstrow2 + 1] = n25;
                                        this.oltot2 = this.oltot2 - n22 + n25;
                                        this.i37.setText(this.decToodb(this.omax2 - this.oltot2));
                                        this.btoofew = false;
                                    }
                                }
                            }
                            else if (this.bAT) {
                                final double n26 = this.disd[this.lstrow2 + 1];
                                double n27 = 0.0;
                                for (int n28 = 1; n28 < (int)Math.ceil(this.olft2 + n26); ++n28) {
                                    this.disd[this.lstrow2 + 1] = n28;
                                    if (this.nh1s[this.lstrow2 + 1] < this.trgfun(this.adjfct, this.lmbfct)) {
                                        n27 = this.disd[this.lstrow2 + 1];
                                    }
                                }
                                double n29;
                                if (n27 < n26 - 1.0) {
                                    n29 = n27 + 1.0;
                                }
                                else {
                                    n29 = n26;
                                }
                                if (this.omax2 - this.oltot2 + n26 - n29 < this.minover) {
                                    this.btoofew = true;
                                    this.disd[this.lstrow2 + 1] = n26;
                                }
                                else {
                                    this.disd[this.lstrow2 + 1] = n29;
                                    this.oltot2 = this.oltot2 - n26 + n29;
                                    this.i37.setText(this.decToodb(this.omax2 - this.oltot2));
                                    this.btoofew = false;
                                }
                            }
                        }
                    }
                }
                int n30 = 0;
                for (int n31 = 0; n31 < this.nstprow; ++n31) {
                    if (this.impty[30 + n31][1] == 0) {
                        n30 = n31;
                    }
                }
                if (this.disd[n30 + 1] > 0.01 & this.wckt2 == 10) {
                    this.calclte2 = false;
                    this.calclte = false;
                    this.f41.setText("ERROR: ");
                    this.f41.setOpaque(true);
                    this.f41.setBackground(Color.yellow);
                    this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                    this.ghij41.setText("Inconsistency in input values");
                    this.ghij41.setOpaque(true);
                    this.ghij41.setBackground(Color.yellow);
                    this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                    this.bincon = true;
                }
            }
            if (this.chkallbut1 & this.team1FinalScore.getText().trim().length() > 0) {
                this.lstrow2 = -1;
                for (int lstrow4 = 0; lstrow4 < this.nstprow; ++lstrow4) {
                    if (this.impty[30 + lstrow4][1] == 0) {
                        this.lstrow2 = lstrow4;
                    }
                }
                this.lstrow1 = -1;
                for (int lstrow5 = 0; lstrow5 < this.nstprow; ++lstrow5) {
                    if (this.impty[lstrow5][2] == 0) {
                        this.lstrow1 = lstrow5;
                    }
                }
                if (this.lstrow2 > -1) {
                    this.lmbfct = this.lmbfun();
                    this.adjfct = this.adjfun(this.lmbfct);
                    for (int n32 = 0; n32 < this.lstrow2 + 1; ++n32) {
                        if (this.impty[30 + n32][3] == 0) {
                            this.trgttst1 = this.trgfuntst1(this.adjfct, this.lmbfct, n32);
                            if (this.nh1s[n32 + 1] >= this.trgttst1 & (n32 < this.lstrow2 || this.wckt2 == 10)) {
                                this.bincon = true;
                                this.chkallbut1 = false;
                            }
                            if (n32 < this.lstrow2) {
                                this.trgttst2 = this.trgfuntst1(this.adjfct, this.lmbfct, n32 + 1);
                                if (this.nh1s[n32 + 1] >= this.trgttst2) {
                                    this.bincon = true;
                                    this.chkallbut1 = false;
                                    this.brslt = false;
                                }
                            }
                            if (n32 == this.lstrow2 & !this.bincon) {
                                this.g4.setText("" + this.trgttst1);
                            }
                        }
                    }
                }
            }
            if (this.chkallbut1a & (this.omax1 - this.oplyd1 - this.oltot1 < 0.01 || this.wckt1 == 10)) {
                this.calclte1 = true;
                this.chkallbut1a = false;
                if (this.calclte2 & this.impty[60][0] + this.impty[60][1] + this.impty[60][2] == 0) {
                    if (this.bincon) {
                        this.calclte = false;
                    }
                    else {
                        this.calclte = true;
                    }
                }
            }
            if (this.bT2trg & !this.calclte) {
                this.defghi42.setText("<html><b>WARNING:</b> Incomplete information for '<b>?</b>' option");
                this.defghi42.setVisible(true);
                this.defghi42.setBackground(dlcalc.orng1);
            }
            if (this.calclte) {
                this.tmp = this.nb3;
                this.tmpa = this.ng3;
                for (int n33 = 0; n33 < this.nstprow; ++n33) {
                    this.tmp -= this.ddsd[n33 + 1];
                    this.tmpa -= this.disd[n33 + 1];
                }
                if (this.bT2trg || this.bT2trg1) {
                    int n34 = 0;
                    for (int n35 = this.iT2trg + 1; n35 < this.nstprow; ++n35) {
                        n34 += 1 - this.impty[n35 + 30][2];
                    }
                    if (n34 > 0 || this.brslt) {
                        this.f41.setText("ERROR: ");
                        this.f41.setOpaque(true);
                        this.f41.setBackground(Color.yellow);
                        this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                        this.ghij41.setText("Improper use of '?'");
                        this.ghij41.setOpaque(true);
                        this.ghij41.setBackground(Color.yellow);
                        this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
                        this.calclte = false;
                    }
                    else {
                        (this.gcde = new StringBuilder("TableID" + this.PRGMno + ": ")).append(this.team1OversInnigsAtStartOfMatch.getText().trim());
                        this.gcde.append("-");
                        this.gcde.append(this.team1FinalScore.getText().trim());
                        for (int n36 = 0; n36 < this.nstprow; ++n36) {
                            if (this.impty[n36][0] == 0) {
                                this.gcde.append("-");
                                this.gcde.append(this.tbs[n36].getText().trim());
                                this.gcde.append("-");
                                this.gcde.append(this.tcs[n36].getText().trim());
                                this.gcde.append("-");
                                this.gcde.append(this.tds[n36].getText().trim());
                            }
                        }
                        this.gcde.append("/");
                        this.gcde.append(this.g3.getText().trim());
                        for (int n37 = 0; n37 < this.nstprow; ++n37) {
                            if (this.impty[n37 + 30][0] == 0) {
                                this.gcde.append("-");
                                this.gcde.append(this.tgs[n37].getText().trim());
                                this.gcde.append("-");
                                this.gcde.append(this.ths[n37].getText().trim());
                                this.gcde.append("-");
                                this.gcde.append(this.tis[n37].getText().trim());
                            }
                        }
                        if (this.i39.getText().trim().length() > 0) {
                            this.gcde.append("/");
                            this.gcde.append(this.i39.getText().trim());
                        }
                        if (this.bT2trg1) {
                            this.ctmp = this.d37.getText();
                        }
                        else {
                            this.ctmp = this.i37.getText();
                        }
                        if (this.ctmp.trim().length() > 0) {
                            this.dtmp = Double.valueOf(this.ctmp);
                        }
                        else {
                            this.dtmp = 0.0;
                        }
                        this.tmpa = this.odbTodec(this.dtmp);
                        this.olft2 = this.tmpa - this.oplyd2;
                        if (this.bT2trg1) {
                            this.tmpa = Math.floor(this.tmpa);
                            this.olft2 = this.tmpa - this.oplyd2;
                            this.ng3 = (int)this.olft2;
                            this.impty[30][0] = 0;
                            this.impty[30][1] = 0;
                            this.impty[30][2] = 0;
                        }
                        final JLabel label = new JLabel("<html><body><font size=\"5\"><b><center>Table of possible Targets</center></b></font></html>", 0);
                        if (!this.bT2open) {
                            this.T2trgp = new JPanel();
                            this.T2trgpp = new JPanel();
                            this.T2trgl = new JLabel();
                            this.T2trglp = new JLabel();
                            (this.T2prnt = new JButton("print table")).addActionListener(this);
                            (this.T2html = new JButton("save table")).addActionListener(this);
                            this.T2trgl.setBackground(Color.white);
                            this.T2trglp.setBackground(Color.white);
                            (this.T2trgf = new JFrame("Processing table of possible Targets . . .")).setLocationRelativeTo(this.las[0]);
                            this.T2trgfp = new JFrame();
                            this.T2trgf.addWindowListener(this);
                            this.T2trgf.setDefaultCloseOperation(2);
                            this.T2trgf.setSize(500, 0);
                            this.T2trgf.setIconImage(this.icon1.getImage());
                            this.T2trgf.setVisible(true);
                        }
                        this.T2trgb.delete(0, this.T2trgb.length());
                        this.T2trgb.setLength(0);
                        this.T2trgb.append("<html><body><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\"><tr><td>");
                        this.T2trgb.append(" <center><font size=\"3\"><b>overs&nbsp;lost&nbsp;in<br>&nbsp;current&nbsp;stoppage&nbsp;</b></font></center></td><td><center>");
                        this.T2trgb.append(" <font size=\"3\"><b>total&nbsp;overs<br>&nbsp;in&nbsp;innings&nbsp;</b></font></center></td><td><center><font size=\"3\"><b>overs<br>&nbsp;remaining&nbsp;</b></font></center></td><td>");
                        this.T2trgb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=45><font size=\"3\"><b><br>&nbsp;Target&nbsp;</b></font></td><td></td></table>");
                        this.T2trgb.append("</td></tr>");
                        this.T2trgbp.delete(0, this.T2trgb.length());
                        this.T2trgbp.setLength(0);
                        this.T2trgbpT.delete(0, this.T2trgb.length());
                        this.T2trgbpT.setLength(0);
                        this.T2trgbp.append("<html><body><center><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
                        this.T2trgbp.append(" <tr><td colspan=\"5\"><center><font size=\"3\"><b>Table of possible Targets</b></font></center><hr></td></tr><tr><td>");
                        this.T2trgbp.append(" <center><font size=\"3\"><b>overs&nbsp;lost&nbsp;in<br>&nbsp;current&nbsp;stoppage&nbsp;<hr></b></font></center></td><td><center>");
                        this.T2trgbp.append(" <font size=\"3\"><b>total&nbsp;overs<br>&nbsp;in&nbsp;innings&nbsp;<hr></b></font></center></td><td><center><font size=\"3\"><b>overs<br>&nbsp;remaining&nbsp;<hr></b></font></center></td><td><center><font size=\"3\">");
                        this.T2trgbp.append(" <b><br>&nbsp;Target&nbsp;<hr></b></font></center></td><td><font size=\"3\"><br>&nbsp;<hr></font></td></tr>");
                        this.idrwcnt = 0;
                        this.lmbfct = this.lmbfun();
                        this.adjfct = this.adjfun(this.lmbfct);
                        this.btrgachd = false;
                        for (int n38 = 0; n38 < (int)Math.ceil(this.olft2) + 1; ++n38) {
                            ++this.idrwcnt;
                            if (n38 < (int)Math.ceil(this.olft2) & !this.btrgachd) {
                                final String string = new Integer(n38).toString();
                                if (this.iT2trg < 0) {
                                    this.disd[1] = n38;
                                }
                                else {
                                    this.disd[this.iT2trg + 1] = n38;
                                }
                                final Integer n39 = new Integer(this.trgfun(this.adjfct, this.lmbfct));
                                this.T2trgb.append("<tr><td><center><font size=\"2\">");
                                this.T2trgb.append(string);
                                this.T2trgb.append("</font></center></td><td><center><font size=\"2\">");
                                this.T2trgb.append(this.decToodb(this.tmpa - n38));
                                this.T2trgb.append("</font></center></td><td><center><font size=\"2\">");
                                this.T2trgb.append(this.decToodb(this.olft2 - n38));
                                this.T2trgb.append("</font></center></td><td><font size=\"2\">");
                                if (this.tmpa - n38 < this.minover) {
                                    this.T2trgb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=45><center><font size=\"2\">NR</font></center></td><td></td></table>");
                                    this.T2trgb.append("</font></td>");
                                    this.btrgachd = true;
                                }
                                else if (this.impty[30 + this.iT2trg][3] == 0 & this.iT2trg >= 0) {
                                    if (this.nh1s[this.iT2trg + 1] >= n39) {
                                        this.T2trgb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=45><center><font size=\"2\">" + n39.toString() + "</font></center></td><td><font size=\"2\">(already achieved)</font></td></table>");
                                        this.T2trgb.append("</font></td>");
                                        this.btrgachd = true;
                                    }
                                    else {
                                        this.T2trgb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=45><center><font size=\"2\">" + n39.toString() + "</font></center></td><td></td></table>");
                                        this.T2trgb.append("</font></td>");
                                    }
                                }
                                else {
                                    this.T2trgb.append("<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td width=45><center><font size=\"2\">" + n39.toString() + "</font></center></td><td></td></table>");
                                    this.T2trgb.append("</font></td>");
                                }
                                this.T2trgb.append("</tr>");
                                if (n38 % 5 == 0) {
                                    this.T2trgbp.append("<tr bgcolor=\"#DDDDDD\"><td><center><font size=\"2\">");
                                }
                                else {
                                    this.T2trgbp.append("<tr><td><center><font size=\"2\">");
                                }
                                this.T2trgbp.append(string);
                                if (string.length() < 2) {
                                    this.T2trgbpT.append("|        " + string + "       |");
                                }
                                else {
                                    this.T2trgbpT.append("|       " + string + "       |");
                                }
                                this.T2trgbp.append("</font></center></td><td><center><font size=\"2\">");
                                this.T2trgbp.append(this.decToodb(this.tmpa - n38));
                                if (this.decToodb(this.tmpa - n38).length() < 2) {
                                    this.T2trgbpT.append("      " + this.decToodb(this.tmpa - n38) + "      |");
                                }
                                else {
                                    this.T2trgbpT.append("     " + this.decToodb(this.tmpa - n38) + "      |");
                                }
                                this.T2trgbp.append("</font></center></td><td><center><font size=\"2\">");
                                this.T2trgbp.append(this.decToodb(this.olft2 - n38));
                                if (this.decToodb(this.olft2 - n38).length() < 2) {
                                    this.T2trgbpT.append("     " + this.decToodb(this.olft2 - n38) + "     |");
                                }
                                else if (this.decToodb(this.olft2 - n38).length() < 3) {
                                    this.T2trgbpT.append("    " + this.decToodb(this.olft2 - n38) + "     |");
                                }
                                else if (this.decToodb(this.olft2 - n38).length() < 4) {
                                    this.T2trgbpT.append("    " + this.decToodb(this.olft2 - n38) + "    |");
                                }
                                else {
                                    this.T2trgbpT.append("   " + this.decToodb(this.olft2 - n38) + "    |");
                                }
                                this.T2trgbp.append("</font></center></td><td><center><font size=\"2\">");
                                if (this.tmpa - n38 < this.minover) {
                                    this.T2trgbp.append("NR");
                                    this.T2trgbp.append("</font></center></td><td><font size=\"2\"></font></td>");
                                    this.T2trgbpT.append("   NR   |");
                                    this.btrgachd = true;
                                }
                                else if (this.impty[30 + this.iT2trg][3] == 0 & this.iT2trg >= 0) {
                                    if (this.nh1s[this.iT2trg + 1] >= n39) {
                                        this.T2trgbp.append(n39.toString());
                                        this.T2trgbp.append("</font></center></td><td><font size=\"2\">(already achieved)</font></td>");
                                        if (n39.toString().length() < 2) {
                                            this.T2trgbpT.append("    " + n39.toString() + "   | (already achieved)");
                                        }
                                        else if (n39.toString().length() < 3) {
                                            this.T2trgbpT.append("   " + n39.toString() + "   | (already achieved)");
                                        }
                                        else {
                                            this.T2trgbpT.append("  " + n39.toString() + "   | (already achieved)");
                                        }
                                        this.btrgachd = true;
                                    }
                                    else {
                                        this.T2trgbp.append(n39.toString());
                                        this.T2trgbp.append("</font></center></td><td><font size=\"2\"></font></td>");
                                        if (n39.toString().length() < 2) {
                                            this.T2trgbpT.append("    " + n39.toString() + "   |");
                                        }
                                        else if (n39.toString().length() < 3) {
                                            this.T2trgbpT.append("   " + n39.toString() + "   |");
                                        }
                                        else {
                                            this.T2trgbpT.append("  " + n39.toString() + "   |");
                                        }
                                    }
                                }
                                else {
                                    this.T2trgbp.append(n39.toString());
                                    this.T2trgbp.append("</font></center></td><td><font size=\"2\"></font></td>");
                                    if (n39.toString().length() < 2) {
                                        this.T2trgbpT.append("    " + n39.toString() + "   |");
                                    }
                                    else if (n39.toString().length() < 3) {
                                        this.T2trgbpT.append("   " + n39.toString() + "   |");
                                    }
                                    else {
                                        this.T2trgbpT.append("  " + n39.toString() + "   |");
                                    }
                                }
                                this.T2trgbp.append("</tr>");
                                this.T2trgbpT.append("</tr>");
                            }
                        }
                        if (this.iT2trg < 0) {
                            this.disd[1] = 0.0;
                        }
                        else {
                            this.disd[this.iT2trg + 1] = 0.0;
                        }
                        this.T2trgb.append("<tr><td colspan=\"5\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
                        this.T2trgb.append(this.gcde.toString());
                        this.T2trgb.append("</b></font></td><td align=\"right\"><font size=\"1\">");
                        final Date date = new Date();
                        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
                        this.T2trgb.append(date.toString());
                        this.T2trgb.append("</font></td></tr></table></td></tr></table><font size=\"1\">");
                        if (this.tmpa - this.olft2 < this.minover) {
                            this.T2trgb.append("NR = No Result, available overs &lt; " + this.minover + ".<br>");
                        }
                        this.T2trgb.append("<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
                        this.T2trgb.append("</font></body></html>");
                        this.T2trgbp.append("<tr><td colspan=\"5\"><hr><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td><font size=\"1\"><b>");
                        this.T2trgbp.append(this.gcde.toString());
                        this.T2trgbp.append("</b></font></td><td align=\"right\"><font size=\"1\">");
                        this.T2trgbp.append(date.toString());
                        this.T2trgbp.append("</font></td></tr></table><hr></td></tr>");
                        if (this.tmpa - this.olft2 < this.minover) {
                            this.T2trgbp.append("<tr><td colspan=\"5\"><font size=\"1\">NR = No Result, available overs &lt; " + this.minover + ".</font></td></tr>");
                            this.T2trgbpT.append("NR = No Result, available overs < " + this.minover + ".<br>");
                        }
                        this.T2trgbp.append("</table></center><font size=\"1\">");
                        this.T2trgbp.append("<center>&copy; " + simpleDateFormat.format(date) + " International Cricket Council</center>");
                        this.T2trgbp.append("</font></body></html>");
                        this.T2trgbpT.append(this.gcde.toString() + " (" + date.toString() + ")");
                        this.T2trgl.setText(this.T2trgb.toString());
                        this.T2trglp.setText(this.T2trgbp.toString());
                        if (!this.bT2open) {
                            this.T2trgp.setLayout(this.gbgT2);
                            this.T2trgpp.setLayout(this.gbgT2p);
                            this.T2trgp.setBackground(Color.white);
                            this.T2trgpp.setBackground(Color.white);
                            this.cT2.fill = 0;
                            this.cT2.anchor = 17;
                            this.cT2.gridwidth = 1;
                            this.cT2.gridx = 0;
                            this.cT2.gridy = 0;
                            this.gbgT2.setConstraints(this.T2prnt, this.cT2);
                            this.T2prnt.setForeground(Color.black);
                            this.T2prnt.setBackground(new Color(255, 255, 240));
                            this.T2trgp.add(this.T2prnt);
                            this.cT2.anchor = 13;
                            this.cT2.gridwidth = 1;
                            this.cT2.gridx = 1;
                            this.cT2.gridy = 0;
                            this.T2html.setForeground(Color.black);
                            this.T2html.setBackground(new Color(255, 255, 240));
                            this.gbgT2.setConstraints(this.T2html, this.cT2);
                            this.cT2.fill = 1;
                            this.cT2.anchor = 10;
                            this.cT2.gridwidth = 2;
                            this.cT2.gridx = 0;
                            this.cT2.gridy = 1;
                            this.gbgT2.setConstraints(label, this.cT2);
                            label.setBackground(Color.white);
                            label.setForeground(Color.black);
                            label.setOpaque(true);
                            this.T2trgp.add(label);
                            this.T2trgp.add(this.T2html);
                            this.cT2.gridwidth = 2;
                            this.cT2.gridx = 0;
                            this.cT2.gridy = 2;
                            this.gbgT2.setConstraints(this.T2trgl, this.cT2);
                            this.T2trgl.setBackground(Color.white);
                            this.T2trgl.setForeground(Color.black);
                            this.T2trgl.setOpaque(true);
                            this.T2trgp.add(this.T2trgl);
                            this.cT2p.gridwidth = 1;
                            this.cT2p.gridx = 0;
                            this.cT2p.gridy = 0;
                            this.gbgT2p.setConstraints(this.T2trglp, this.cT2p);
                            this.T2trgpp.add(this.T2trglp);
                            this.T2trgf.add(new JScrollPane(this.T2trgp, 22, 30));
                            this.T2trgfp.add(new JScrollPane(this.T2trgpp, 20, 30));
                            this.T2trgfp.pack();
                            this.T2trgf.pack();
                            final int width = this.T2trgf.getWidth();
                            final int min = Math.min(this.T2trgf.getHeight(), GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 72);
                            int n40 = 0;
                            if (this.otblopen) {
                                n40 += 18;
                            }
                            if (this.btblopen) {
                                n40 += 18;
                            }
                            this.T2trgf.setBounds(n40, n40, width, min);
                            this.T2trgf.validate();
                            this.T2trgf.setTitle(this.PRGMname + ": Table of possible Targets");
                            this.T2trgf.setVisible(true);
                            label.requestFocus();
                            this.bT2open = true;
                        }
                        else {
                            this.T2trgf.pack();
                            final int width2 = this.T2trgf.getWidth();
                            final int min2 = Math.min(this.T2trgf.getHeight(), GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height - 72);
                            int n41 = 0;
                            if (this.otblopen) {
                                n41 += 18;
                            }
                            if (this.btblopen) {
                                n41 += 18;
                            }
                            this.T2trgf.setBounds(n41, n41, width2, min2);
                            this.T2trgf.validate();
                            this.T2trgf.repaint();
                            this.T2trglp.repaint();
                        }
                    }
                }
                else {
                    this.Otble.setEnabled(true);
                    this.Btble.setEnabled(true);
                    this.abc41a.setForeground(Color.black);
                    this.tmp = this.nb3;
                    this.tmpa = this.ng3;
                    for (int n42 = 0; n42 < this.nstprow; ++n42) {
                        this.tmp -= this.ddsd[n42 + 1];
                        this.tmpa -= this.disd[n42 + 1];
                    }
                    this.lmbfct = this.lmbfun();
                    this.adjfct = this.adjfun(this.lmbfct);
                    this.trgt = this.trgfun(this.adjfct, this.lmbfct);
                    this.ntmp = new Integer(this.trgt);
                    if (this.ng3 >= this.minover) {
                        this.g4.setText(this.ntmp.toString());
                        this.g4.setForeground(Color.red);
                    }
                    else {
                        this.g4.setForeground(Color.lightGray);
                    }
                    if (this.bT2open) {
                        this.T2trgf.removeWindowListener(this);
                        this.T2prnt.removeActionListener(this);
                        this.T2html.removeActionListener(this);
                        this.T2trgf.dispose();
                        this.bT2open = false;
                        if (this.iT2trg < 0) {
                            if (this.g3.getText().trim().indexOf("?") == 0) {
                                this.g3.setText("");
                            }
                        }
                        else if (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0) {
                            this.tis[this.iT2trg].setText("");
                        }
                    }
                    this.brunsall = true;
                    this.lstrow2 = 0;
                    for (int lstrow6 = 0; lstrow6 < this.nstprow; ++lstrow6) {
                        if (this.impty[30 + lstrow6][2] == 0) {
                            this.lstrow2 = lstrow6;
                        }
                    }
                    this.lstrow1 = 0;
                    for (int lstrow7 = 0; lstrow7 < this.nstprow; ++lstrow7) {
                        if (this.impty[lstrow7][2] == 0) {
                            this.lstrow1 = lstrow7;
                        }
                    }
                    if (this.impty[this.lstrow2 + 30][3] == 1) {
                        this.brunsall = false;
                    }
                    if (this.brunsall & !this.brunord2) {
                        this.ctmp = this.i37.getText();
                        if (this.ctmp.trim().length() > 0) {
                            this.dtmp = Double.valueOf(this.ctmp);
                        }
                        else {
                            this.dtmp = 0.0;
                        }
                        this.tmpa = this.odbTodec(this.dtmp);
                        this.olft2 = this.tmpa - this.oplyd2;
                        this.disd[this.lstrow2 + 1] += this.olft2;
                        this.curpar = this.trgfun(this.adjfct, this.lmbfct);
                        this.curpar1 = this.curpar - 1;
                        if (this.nh1s[this.lstrow2 + 1] >= this.trgt) {
                            final int n43 = this.nh1s[this.lstrow2 + 1] - this.trgfuntst1(this.adjfct, this.lmbfct, this.lstrow2);
                            this.winmarg = this.nh1s[this.lstrow2 + 1] - this.curpar1;
                            if (n43 >= 0) {
                                final int n44 = 10 - this.wckt2;
                                if (!this.btoofew) {
                                    if (n44 == 1) {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + n44 + " wicket");
                                        this.rsltcde = 2;
                                        this.rsltdes = "win by " + n44 + " wicket; Par Score: " + this.curpar1;
                                    }
                                    else {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + n44 + " wickets");
                                        this.rsltcde = 2;
                                        this.rsltdes = "win by " + n44 + " wickets; Par Score: " + this.curpar1;
                                    }
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; (Par Score at end = " + this.curpar1 + ")");
                                    this.k4.setBackground(dlcalc.ornge);
                                    if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.lstrow2 + 1] > 0.01) {
                                        this.g4.setText(" ");
                                    }
                                    else {
                                        this.g4.setText("" + this.trgt);
                                        this.g4.setForeground(Color.red);
                                    }
                                }
                                else if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch & textEvent.getSource() != this.g3) {
                                    this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.rsltcde = 0;
                                    this.rsltdes = "NO RESULT; Par Score: " + this.curpar1;
                                    this.k4.setText("<html>&nbsp; No Result");
                                    this.k4.setBackground(dlcalc.ornge);
                                    this.g4.setText(" ");
                                }
                                this.brslt = true;
                                this.defghi42.setText(" ");
                                this.defghi42.setVisible(false);
                                this.defghi42.setBackground(Color.lightGray);
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                            else {
                                if (!this.btoofew) {
                                    if (this.winmarg > 1) {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + this.winmarg + " runs");
                                        this.rsltcde = 2;
                                        this.rsltdes = "win by " + this.winmarg + " runs; Par Score: " + this.curpar1;
                                    }
                                    else {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + this.winmarg + " run");
                                        this.rsltcde = 2;
                                        this.rsltdes = "win by " + this.winmarg + " run; Par Score: " + this.curpar1;
                                    }
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; (Par Score at end = " + this.curpar1 + ")");
                                    this.k4.setBackground(dlcalc.ornge);
                                    if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.lstrow2 + 1] > 0.01) {
                                        this.g4.setText(" ");
                                    }
                                    else {
                                        this.g4.setText("" + this.trgt);
                                        this.g4.setForeground(Color.red);
                                    }
                                    if (this.omax2 - this.oplyd2 - this.oltot2 > 0.01) {
                                        this.ljs[this.lstrow2].setText(" target (" + this.trgt + ") already achieved");
                                        if (this.bAT) {
                                            this.j37.setText(" (when target achieved)");
                                        }
                                        this.g4.setText(" ");
                                    }
                                }
                                else if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch & textEvent.getSource() != this.g3) {
                                    this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                    this.rsltcde = 0;
                                    this.rsltdes = "NO RESULT; Par Score: " + this.curpar1;
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; No Result");
                                    this.k4.setBackground(dlcalc.ornge);
                                    this.g4.setText(" ");
                                }
                                this.brslt = true;
                                this.defghi42.setText(" ");
                                this.defghi42.setVisible(false);
                                this.defghi42.setBackground(Color.lightGray);
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                        }
                        else {
                            this.rtoget = this.trgt - this.nh1s[this.lstrow2 + 1];
                            this.rtoget1 = this.rtoget - 1;
                            if (this.olft2 > 0.0 & this.wckt2 < 10) {
                                if (!this.btoofew) {
                                    if (this.dis[this.lstrow2 + 1] > 0.01) {
                                        this.k3.setText("<html><font size=\"2\">&nbsp;</font>Revised Target: " + this.g4.getText() + " <font size=\"3\">(" + this.i37.getText() + " overs)</font>");
                                        this.k3.setBackground(dlcalc.blu1);
                                        if (this.olft2 > 1.0) {
                                            if (this.rtoget > 1) {
                                                this.k4.setText("<html>&nbsp; (" + this.rtoget + " further runs in " + this.decToodb(this.olft2) + " overs)");
                                            }
                                            else {
                                                this.k4.setText("<html>&nbsp; T2 need " + this.rtoget + " more run <font size=\"2\">(" + this.decToodb(this.olft2) + " overs)</font>");
                                            }
                                        }
                                        else if (this.rtoget > 1) {
                                            this.k4.setText("<html>&nbsp; T2 need " + this.rtoget + " more runs <font size=\"2\">(" + this.decToodb(this.olft2) + " over)</font>");
                                        }
                                        else {
                                            this.k4.setText("<html>&nbsp; T2 need " + this.rtoget + " more run <font size=\"2\">(" + this.decToodb(this.olft2) + " over)</font>");
                                        }
                                        this.k4.setBackground(dlcalc.blu1);
                                        this.k4.setFont(new Font("Serif", 1, 12));
                                    }
                                }
                                else if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch & textEvent.getSource() != this.g3) {
                                    this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                    this.rsltcde = 0;
                                    this.rsltdes = "NO RESULT; Par Score: ";
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; No Result");
                                    this.k4.setBackground(dlcalc.ornge);
                                    this.g4.setText(" ");
                                }
                            }
                            else if (this.rtoget1 > 0) {
                                if (!this.btoofew) {
                                    if (this.rtoget1 > 1) {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 1</span> win by " + this.rtoget1 + " runs");
                                        this.rsltcde = 1;
                                        this.rsltdes = "win by " + this.rtoget1 + " runs; Par Score: " + this.curpar1;
                                    }
                                    else {
                                        this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 1</span> win by " + this.rtoget1 + " run");
                                        this.rsltcde = 1;
                                        this.rsltdes = "win by " + this.rtoget1 + " run; Par Score: " + this.curpar1;
                                    }
                                    this.RptSum.setEnabled(true);
                                    if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.lstrow2 + 1] > 0.01) {
                                        this.g4.setText(" ");
                                    }
                                    else {
                                        this.g4.setText("" + this.trgt);
                                        this.g4.setForeground(Color.red);
                                    }
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; (Par Score at end = " + this.curpar1 + ")");
                                    this.k4.setBackground(dlcalc.ornge);
                                }
                                else if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch & textEvent.getSource() != this.g3) {
                                    this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                    this.rsltcde = 0;
                                    this.rsltdes = "NO RESULT; Par Score: " + this.curpar1;
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; No Result");
                                    this.k4.setBackground(dlcalc.ornge);
                                    this.g4.setText(" ");
                                }
                                this.brslt = true;
                                this.defghi42.setText(" ");
                                this.defghi42.setVisible(false);
                                this.defghi42.setBackground(Color.lightGray);
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                            else {
                                if (!this.btoofew) {
                                    this.k3.setText("<html>&nbsp; Match <span style=\"color:white\">TIED</span>");
                                    this.rsltcde = 0;
                                    this.rsltdes = "RESULT: Match TIED; Par Score: " + this.curpar1;
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; (Par Score at end = " + this.curpar1 + ")");
                                    this.k4.setBackground(dlcalc.ornge);
                                    if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.lstrow2 + 1] > 0.01) {
                                        this.g4.setText(" ");
                                    }
                                    else {
                                        this.g4.setText("" + this.trgt);
                                        this.g4.setForeground(Color.red);
                                    }
                                }
                                else if (textEvent.getSource() != this.team1OversInnigsAtStartOfMatch & textEvent.getSource() != this.g3) {
                                    this.k3.setText("<html>&nbsp available overs &lt; " + this.minover);
                                    this.rsltcde = 0;
                                    this.rsltdes = "NO RESULT; Par Score: " + this.curpar1;
                                    this.RptSum.setEnabled(true);
                                    this.k3.setBackground(dlcalc.ornge);
                                    this.k4.setText("<html>&nbsp; No Result");
                                    this.k4.setBackground(dlcalc.ornge);
                                    this.g4.setText(" ");
                                }
                                this.brslt = true;
                                this.defghi42.setText(" ");
                                this.defghi42.setVisible(false);
                                this.defghi42.setBackground(Color.lightGray);
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                        }
                    }
                }
            }
            else if (this.chkallbut1 & this.team1FinalScore.getText().trim().length() > 0 & this.calclte1) {
                this.tmpa = this.ng3;
                for (int n45 = 0; n45 < this.nstprow; ++n45) {
                    this.tmpa -= this.disd[n45 + 1];
                }
                this.olft2 = this.tmpa - this.oplyd2;
                this.disd[this.iPtrg + 1] = this.olft2;
                this.lmbfct = this.lmbfun();
                this.adjfct = this.adjfun(this.lmbfct);
                final int n46 = this.trgfun(this.adjfct, this.lmbfct) - 1;
                if (this.tmpa < this.minover & this.g3.getText().trim().indexOf("?") != 0 & this.wckt2 < 10) {
                    this.k3.setText("<html> &nbsp; available overs &lt; " + this.minover);
                    this.rsltcde = 0;
                    this.rsltdes = "NO RESULT; Par Score: ";
                    this.RptSum.setEnabled(true);
                    this.k3.setBackground(dlcalc.ornge);
                    this.k4.setText("<html> &nbsp; No Result");
                    this.k4.setBackground(dlcalc.ornge);
                }
                else if (this.impty[30 + this.iPtrg][3] == 0 & !this.brunord2) {
                    if (this.nh1s[this.iPtrg + 1] > n46) {
                        final int n47 = this.nh1s[this.iPtrg + 1] - n46;
                        if (this.wckt2 < 10) {
                            if (this.nh1s[this.iPtrg + 1] - this.trgfuntst1(this.adjfct, this.lmbfct, this.iPtrg) < 0) {
                                this.k3.setText("<html> &nbsp;  Team 2 are ahead by " + n47);
                                this.k3.setBackground(dlcalc.orng1);
                                this.k3.setForeground(dlcalc.blu1);
                                this.k4.setText("<html> &nbsp;  (Par Score = " + n46 + ")");
                                this.k4.setBackground(dlcalc.orng1);
                                this.k4.setForeground(dlcalc.blu1);
                            }
                            else {
                                if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.iPtrg + 1] > 0.01) {
                                    this.g4.setText(" ");
                                }
                                else {
                                    this.g4.setText("" + this.trgfuntst1(this.adjfct, this.lmbfct, this.iPtrg));
                                    this.g4.setForeground(Color.red);
                                }
                                final int n48 = 10 - this.wckt2;
                                if (n48 > 1) {
                                    this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + n48 + " wickets");
                                    this.rsltcde = 2;
                                    this.rsltdes = "win by " + n48 + " wickets; Par Score: " + n46;
                                }
                                else {
                                    this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 2</span> win by " + n48 + " wicket");
                                    this.rsltcde = 2;
                                    this.rsltdes = "win by " + n48 + " wicket; Par Score: " + n46;
                                }
                                this.RptSum.setEnabled(true);
                                this.k3.setBackground(dlcalc.ornge);
                                this.k4.setText("<html>&nbsp; (Par Score at end = " + n46 + ")");
                                this.k4.setBackground(dlcalc.ornge);
                                this.brslt = true;
                                this.defghi42.setText(" ");
                                this.defghi42.setVisible(false);
                                this.defghi42.setBackground(Color.lightGray);
                                this.Otble.setEnabled(false);
                                this.Btble.setEnabled(false);
                                this.abc41a.setForeground(Color.gray);
                            }
                        }
                    }
                    else if (this.nh1s[this.iPtrg + 1] < n46) {
                        final int n49 = n46 - this.nh1s[this.iPtrg + 1];
                        if (this.wckt2 < 10 & this.omax2 - this.oltot2 - this.oplyd2 > 0.01) {
                            this.k3.setText("<html> &nbsp;  Team 2 are behind by " + n49);
                            this.k3.setBackground(dlcalc.orng1);
                            this.k3.setForeground(dlcalc.blu1);
                            this.k4.setText("<html> &nbsp; (Par Score = " + n46 + ")");
                            this.k4.setBackground(dlcalc.orng1);
                            this.k4.setForeground(dlcalc.blu1);
                        }
                        else {
                            if (n49 > 1) {
                                this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 1</span> win by " + n49 + " runs");
                                this.rsltcde = 1;
                                this.rsltdes = "win by " + n49 + " runs; Par Score: " + n46;
                            }
                            else {
                                this.k3.setText("<html>&nbsp; <span style=\"color:white\">TEAM 1</span> win by " + n49 + " run");
                                this.rsltcde = 1;
                                this.rsltdes = "win by " + n49 + " run; Par Score: " + n46;
                            }
                            this.RptSum.setEnabled(true);
                            final int n50 = n46 + 1;
                            if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.iPtrg + 1] > 0.01) {
                                this.g4.setText(" ");
                            }
                            else {
                                this.g4.setText("" + n50);
                                this.g4.setForeground(Color.red);
                            }
                            this.k3.setBackground(dlcalc.ornge);
                            this.k4.setText("<html>&nbsp; (Par Score at end = " + n46 + ")");
                            this.k4.setBackground(dlcalc.ornge);
                            this.brslt = true;
                            this.defghi42.setText(" ");
                            this.defghi42.setVisible(false);
                            this.defghi42.setBackground(Color.lightGray);
                            this.Otble.setEnabled(false);
                            this.Btble.setEnabled(false);
                            this.abc41a.setForeground(Color.gray);
                        }
                    }
                    else if (this.wckt2 < 10 & this.omax2 - this.oltot2 - this.oplyd2 > 0.01) {
                        this.k3.setText("<html> &nbsp;  Team 2 are level with par");
                        this.k3.setBackground(dlcalc.orng1);
                        this.k3.setForeground(dlcalc.blu1);
                        this.k4.setText("<html> &nbsp; (Par Score = " + n46 + ")");
                        this.k4.setBackground(dlcalc.orng1);
                        this.k4.setForeground(dlcalc.blu1);
                    }
                    else {
                        this.k3.setText("<html>&nbsp; Match <span style=\"color:white\">TIED</span>");
                        this.rsltcde = 0;
                        this.rsltdes = "RESULT: Match TIED; Par Score: " + n46;
                        this.RptSum.setEnabled(true);
                        this.k3.setBackground(dlcalc.ornge);
                        this.k4.setText("<html>&nbsp; (Par Score at end = " + n46 + ")");
                        this.k4.setBackground(dlcalc.ornge);
                        final int n51 = n46 + 1;
                        if (this.omax2 - this.oplyd2 - this.oltot2 < 0.01 & this.disd[this.iPtrg + 1] > 0.01) {
                            this.g4.setText(" ");
                        }
                        else {
                            this.g4.setText("" + n51);
                            this.g4.setForeground(Color.red);
                        }
                        this.brslt = true;
                        this.defghi42.setText(" ");
                        this.defghi42.setVisible(false);
                        this.defghi42.setBackground(Color.lightGray);
                        this.Otble.setEnabled(false);
                        this.Btble.setEnabled(false);
                        this.abc41a.setForeground(Color.gray);
                    }
                }
                else if (!this.brunord2) {
                    this.k3.setText("<html> &nbsp; Team 2: ");
                    this.k3.setBackground(dlcalc.orng1);
                    this.k3.setForeground(dlcalc.blu1);
                    this.k4.setText("<html> &nbsp; current Par Score = " + n46);
                    this.k4.setBackground(dlcalc.orng1);
                    this.k4.setForeground(dlcalc.blu1);
                }
            }
            else if (this.bincon & !this.bincon1) {
                this.f41.setText("ERROR: ");
                this.f41.setOpaque(true);
                this.f41.setBackground(Color.yellow);
                this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
                this.ghij41.setText("Inconsistency in input values");
                this.ghij41.setOpaque(true);
                this.ghij41.setBackground(Color.yellow);
                this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
            }
            else if (this.g3.getText().trim().indexOf("?") == 0 & !this.calclte1) {
                this.defghi42.setText("<html><b>WARNING:</b> First innings information incomplete");
                this.defghi42.setVisible(true);
                this.defghi42.setBackground(dlcalc.orng1);
            }
        }
        catch (NumberFormatException ex) {
            this.a41.setText("ERROR: ");
            this.a41.setOpaque(true);
            this.a41.setBackground(Color.yellow);
            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.bcde41.setText("Invalid entry");
            this.bcde41.setOpaque(true);
            this.bcde41.setBackground(Color.yellow);
            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.red));
            this.f41.setText("Value = ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.red));
            this.ghij41.setText(this.ctmp1);
            this.ghij41.setOpaque(true);
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
            if (this.bT2open & !this.bruns) {
                this.T2trgf.removeWindowListener(this);
                this.T2prnt.removeActionListener(this);
                this.T2html.removeActionListener(this);
                this.T2trgf.dispose();
                this.bT2open = false;
                if (this.iT2trg < 0) {
                    if (this.g3.getText().trim().indexOf("?") == 0) {
                        this.g3.setText("");
                    }
                }
                else if (this.tis[this.iT2trg].getText().trim().indexOf("?") == 0) {
                    this.tis[this.iT2trg].setText("");
                }
            }
        }
    }
    
    @Override
    public void focusGained(final FocusEvent focusEvent) {
System.out.println("  ");
System.out.println("--**focusGained");
        if ((this.chkallbut1 & this.calclte1 & focusEvent.getSource() == this.tis[this.iPtrg] & this.tis[this.iPtrg].getText().trim().length() == 0 & this.wckt2 < 10 & !this.bT2beforeT1 & !this.brslt & !this.bslctd) && this.omax2 - this.oltot2 - this.oplyd2 > 0.01) {
            this.defghi42.setText("<html><b>NOTE:</b> Enter '<b>a</b>' to abandon innings or '<b>?</b>' to get table of possible Targets");
            this.defghi42.setVisible(true);
            this.defghi42.setBackground(dlcalc.orng1);
        }
        if ((this.chkallbut1a & focusEvent.getSource() == this.tds[this.iPtrga] & this.tds[this.iPtrga].getText().trim().length() == 0 & this.wckt1 < 10) && (this.omax1 - this.oltot1 - this.oplyd1 > 0.01 & !this.bslctd)) {
            this.defghi42.setText("<html><b>NOTE:</b> Enter '<b>a</b>' to abandon innings");
            this.defghi42.setVisible(true);
            this.defghi42.setBackground(dlcalc.orng1);
        }
        if (this.boplyd1) {
            this.a41.setText("ERROR: ");
            this.a41.setOpaque(true);
            this.a41.setBackground(Color.yellow);
            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.bcde41.setText("'Overs.balls bowled' values out of order");
            this.bcde41.setOpaque(true);
            this.bcde41.setBackground(Color.yellow);
            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.bovrm1) {
            this.a41.setText("ERROR: ");
            this.a41.setOpaque(true);
            this.a41.setBackground(Color.yellow);
            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.bcde41.setText("Overs bowled + lost > max. overs");
            this.bcde41.setOpaque(true);
            this.bcde41.setBackground(Color.yellow);
            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.bword1) {
            this.a41.setText("ERROR: ");
            this.a41.setOpaque(true);
            this.a41.setBackground(Color.yellow);
            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.bcde41.setText("Wicket values out of order");
            this.bcde41.setOpaque(true);
            this.bcde41.setBackground(Color.yellow);
            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.brunord1) {
            this.a41.setText("ERROR: ");
            this.a41.setOpaque(true);
            this.a41.setBackground(Color.yellow);
            this.a41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.bcde41.setText("'Runs scored' values out of order");
            this.bcde41.setOpaque(true);
            this.bcde41.setBackground(Color.yellow);
            this.bcde41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        if (this.boplyd2) {
            this.f41.setText("ERROR: ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.ghij41.setText("'Overs.balls bowled' values out of order");
            this.ghij41.setOpaque(true);
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.bovrm2) {
            this.f41.setText("ERROR: ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.ghij41.setText("Overs bowled + lost > max. overs");
            this.ghij41.setOpaque(true);
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.bword2) {
            this.f41.setText("ERROR: ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.ghij41.setText("Wicket values out of order");
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        else if (this.brunord2) {
            this.f41.setText("ERROR: ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.ghij41.setText("'Runs scored' values out of order");
            this.ghij41.setOpaque(true);
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        if (this.bincon & !this.bincon1) {
            this.f41.setText("ERROR: ");
            this.f41.setOpaque(true);
            this.f41.setBackground(Color.yellow);
            this.f41.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 0, Color.red));
            this.ghij41.setText("Inconsistency in input values");
            this.ghij41.setOpaque(true);
            this.ghij41.setBackground(Color.yellow);
            this.ghij41.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.red));
        }
        if (focusEvent.getSource() == this.g3) {
            this.g3.addTextListener(this);
        }
        if (focusEvent.getSource() == this.team1FinalScore) {
            this.team1FinalScore.addTextListener(this);
        }
        if (focusEvent.getOppositeComponent() == this.g3 & this.g3.getText().trim().indexOf("?") == 0) {
            this.usrmx2 = false;
            this.g3.setText("");
            this.team1OversInnigsAtStartOfMatch.setText(this.team1OversInnigsAtStartOfMatch.getText());
        }
        if ((this.iT2trg > -1 & !this.calclte) && (focusEvent.getOppositeComponent() == this.tis[this.iT2trg] & this.tis[this.iT2trg].getText().trim().indexOf("?") == 0)) {
            this.tis[this.iT2trg].setText("");
        }
    }
  
	  public void focusLost(final FocusEvent focusEvent) {
		  System.out.println("         ?.focusLost");
	        if (this.chkallbut1 & focusEvent.getSource() == this.tis[this.iPtrg] & !this.bT2beforeT1) {
	            this.defghi42.setText(" ");
	            this.defghi42.setVisible(true);
	            this.defghi42.setBackground(Color.lightGray);
	        }
	        if (this.chkallbut1a & focusEvent.getSource() == this.tds[this.iPtrga]) {
	            this.defghi42.setText(" ");
	            this.defghi42.setVisible(false);
	            this.defghi42.setBackground(Color.lightGray);
	        }
	        if (focusEvent.getSource() == this.team1FinalScore) {
	            this.team1FinalScore.removeTextListener(this);
	            if (this.team1FinalScore.getText().trim().length() == 0) {
	                this.usrrn1 = false;
	                if (this.calclte1 || this.chkallbut1a) {
	                    double odbTodec = 0.0;
	                    if (this.d37.getText().trim().length() > 0) {
	                        odbTodec = this.odbTodec(Double.valueOf(this.d37.getText()));
	                    }
	                    if (Math.abs(odbTodec - this.oplyd1) < 0.01 && this.tc1s[this.iPtrga].getText().trim().length() > 0) {
	                        this.team1FinalScore.setText(new Integer(this.runs1).toString());
	                    }
	                }
	            }
	            if (focusEvent.getOppositeComponent() == this.tc1s[0]) {
	                this.icrt = this.tc1s[0].getCaretPosition();
	            }
	            if (focusEvent.getOppositeComponent() != this.Otble & focusEvent.getOppositeComponent() != this.Btble) {
	                this.tc1s[0].setText(this.tc1s[0].getText());
	            }
	            if (focusEvent.getOppositeComponent() == this.tc1s[0]) {
	                this.tc1s[0].setCaretPosition(this.icrt);
	            }
	        }
	        if (focusEvent.getSource() == this.g3) {
	            this.g3.removeTextListener(this);
	            if (this.g3.getText().trim().length() == 0) {
	                this.usrmx2 = false;
	                if (this.btoofew) {
	                    this.weird = true;
	                }
	                this.team1OversInnigsAtStartOfMatch.setText(this.team1OversInnigsAtStartOfMatch.getText());
	            }
	        }
	        if ((focusEvent.getSource() == this.team1OversInnigsAtStartOfMatch || (focusEvent.getSource() == this.g3 & this.g3.getText().trim().indexOf("?") != 0)) & this.btoofew) {
	            this.k3.setText("<html>&nbsp; available overs &lt; " + this.minover);
	            this.rsltcde = 0;
	            this.rsltdes = "NO RESULT; Par Score: ";
	            this.RptSum.setEnabled(true);
	            this.k3.setBackground(dlcalc.ornge);
	            this.k4.setText("<html>&nbsp; No Result");
	            this.k4.setBackground(dlcalc.ornge);
	        }
	        this.lstfcs = focusEvent.getComponent();
	        if (this.lstfcs == this.team1OversInnigsAtStartOfMatch) {
	            this.icrt = this.team1OversInnigsAtStartOfMatch.getCaretPosition();
	        }
	        else if (this.lstfcs == this.team1FinalScore) {
	            this.icrt = this.team1FinalScore.getCaretPosition();
	        }
	        else if (this.lstfcs == this.g3) {
	            this.icrt = this.g3.getCaretPosition();
	        }
	        else if (this.lstfcs == this.i39) {
	            this.icrt = this.i39.getCaretPosition();
	        }
	        else {
	            for (int i = 0; i < this.nstprow; ++i) {
	                if (this.lstfcs == this.tbs[i]) {
	                    this.icrt = this.tbs[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.tcs[i]) {
	                    this.icrt = this.tcs[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.tds[i]) {
	                    this.icrt = this.tds[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.tgs[i]) {
	                    this.icrt = this.tgs[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.ths[i]) {
	                    this.icrt = this.ths[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.th1s[i]) {
	                    this.icrt = this.th1s[i].getCaretPosition();
	                }
	                else if (this.lstfcs == this.tis[i]) {
	                    this.icrt = this.tis[i].getCaretPosition();
	                }
	            }
	        }
	    }
	    
	    
	public static void main(String[] paramArrayOfString) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.getDefaults().put("Button.disabledShadow", bcol);
		}
//
		catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
//
		} catch (ClassNotFoundException classNotFoundException) {
//
		} catch (InstantiationException instantiationException) {
//
		} catch (IllegalAccessException illegalAccessException) {
		}

		dlcalc dlcalc1 = new dlcalc();
	}
}
