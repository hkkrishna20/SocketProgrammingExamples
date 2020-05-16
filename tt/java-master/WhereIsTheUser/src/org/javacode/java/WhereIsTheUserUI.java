package org.javacode.java;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author SARKARA1
 */
public class WhereIsTheUserUI extends javax.swing.JFrame {

	private static final long serialVersionUID = -1795080926752613727L;

	/**
	 * Creates new form WhereIsTheUserUI
	 */
	public WhereIsTheUserUI() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup = new javax.swing.ButtonGroup();
		GUIPanel = new javax.swing.JPanel();
		ptButton = new javax.swing.JRadioButton();
		prodButton = new javax.swing.JRadioButton();
		submitButton = new javax.swing.JButton();
		usernameField = new javax.swing.JTextField();
		outputScrollPane = new javax.swing.JScrollPane();
		outputArea = new javax.swing.JTextArea();

		buttonGroup.add(ptButton);
		buttonGroup.add(prodButton);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Where Is the User");
		setResizable(false);

		ptButton.setSelected(true);
		ptButton.setText("PT");

		prodButton.setText("PROD");

		submitButton.setText("Where is the User?");
		submitButton.setEnabled(false);
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitButtonActionPerformed(evt);
			}
		});

		usernameField.setForeground(DEFAULT_FOREGROUND_COLOR);
		usernameField.setText(DEFAULT_TEXT);
//		usernameField.addMouseListener(this.new UsernameFieldMouseListener());
		usernameField.addKeyListener(this.new UsernameFieldKeyListener());
		usernameField.getDocument().addDocumentListener(
				this.new UsernameFieldDocumentListener());

		outputArea.setEditable(false);
		outputArea.setColumns(20);
		outputArea.setLineWrap(true);
		outputArea.setRows(5);
		outputArea.setWrapStyleWord(true);
		outputScrollPane.setViewportView(outputArea);

		javax.swing.GroupLayout GUIPanelLayout = new javax.swing.GroupLayout(
				GUIPanel);
		GUIPanel.setLayout(GUIPanelLayout);
		GUIPanelLayout
				.setHorizontalGroup(GUIPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								GUIPanelLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(outputScrollPane))
						.addGroup(
								GUIPanelLayout
										.createSequentialGroup()
										.addGap(90, 90, 90)
										.addGroup(
												GUIPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																submitButton,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																193,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																GUIPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				ptButton)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				prodButton))
														.addComponent(
																usernameField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																193,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 97, Short.MAX_VALUE)));
		GUIPanelLayout
				.setVerticalGroup(GUIPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								GUIPanelLayout
										.createSequentialGroup()
										.addGap(12, 12, 12)
										.addComponent(
												usernameField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												32,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												GUIPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(ptButton)
														.addComponent(
																prodButton))
										.addGap(16, 16, 16)
										.addComponent(
												submitButton,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												89, Short.MAX_VALUE)
										.addGap(18, 18, 18)
										.addComponent(
												outputScrollPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(7, 7, 7)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(GUIPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				GUIPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
		submitButton.setEnabled(false); // prevent multiple clicks

		String outputText = null;

		try {
			outputText = "Test";
		} finally {
			outputArea.setText(outputText);
			submitButton.setEnabled(true);
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger
					.getLogger(WhereIsTheUserUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(WhereIsTheUserUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(WhereIsTheUserUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(WhereIsTheUserUI.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				WhereIsTheUserUI gui = new WhereIsTheUserUI();
				/* Position the frame in the center of the screen */
				gui.setLocationRelativeTo(null);
				gui.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel GUIPanel;
	private javax.swing.ButtonGroup buttonGroup;
	private javax.swing.JTextArea outputArea;
	private javax.swing.JScrollPane outputScrollPane;
	private javax.swing.JRadioButton prodButton;
	private javax.swing.JRadioButton ptButton;
	private javax.swing.JButton submitButton;
	private javax.swing.JTextField usernameField;
	// End of variables declaration
	private static final String DEFAULT_TEXT = "NWIE ID";
	private static final Color DEFAULT_FOREGROUND_COLOR = new java.awt.Color(
			153, 153, 153);
	private static final Color FOREGROUND_COLOR = Color.BLACK;

	private class UsernameFieldKeyListener extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent ke) {
			manageUsernameFieldText();
		}
	}

	private void manageUsernameFieldText() {
		final String text = usernameField.getText();

		if (text.equalsIgnoreCase(DEFAULT_TEXT)) {
			usernameField.setText(null);
		} else if (text.isEmpty()) {
			usernameField.setText(DEFAULT_TEXT);
		} else if (text.toUpperCase().startsWith(DEFAULT_TEXT.toUpperCase())) {
			final String pastedText = text.substring(DEFAULT_TEXT.length());

			usernameField.setText(pastedText);
		} else if (text.toUpperCase().endsWith(DEFAULT_TEXT.toUpperCase())) {
			final String pastedText = text.substring(0, text.toUpperCase()
					.indexOf(DEFAULT_TEXT.toUpperCase()));

			usernameField.setText(pastedText);
		}
	}

	private class UsernameFieldDocumentListener implements DocumentListener {

		@Override
		public void insertUpdate(DocumentEvent de) {
			enableDisableSubmitButton();
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			enableDisableSubmitButton();
		}

		@Override
		public void changedUpdate(DocumentEvent de) {
			enableDisableSubmitButton();
		}

		private void enableDisableSubmitButton() {
			final String text = usernameField.getText();

			if (text.isEmpty() || text.equalsIgnoreCase(DEFAULT_TEXT)) {
				usernameField.setForeground(DEFAULT_FOREGROUND_COLOR);
				submitButton.setEnabled(false);
			} else {
				usernameField.setForeground(FOREGROUND_COLOR);
				submitButton.setEnabled(true);
			}
		}
	}
}