package com.icc.dls;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CutAction extends AbstractAction {
	public CutAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic) {
		super(name, icon);
		putValue(SHORT_DESCRIPTION, shortDescription);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	public CutAction() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(" ------ CUACTION" + e);
		JOptionPane.showMessageDialog(null, "Would have done the 'Cut' action.");
	}
}