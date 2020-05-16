package com.icc.dls;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.RepaintManager;

public class PParTable implements Printable {
	public static void printComponent(Component paramComponent) {
		(new PParTable(paramComponent)).print();
	}

	private Component componentToBePrinted;

	public PParTable(Component paramComponent) {
		this.componentToBePrinted = paramComponent;
	}

	public void print() {
		PrinterJob printerJob = PrinterJob.getPrinterJob();
		printerJob.setPrintable(this);
		if (printerJob.printDialog())
			try {
				printerJob.print();
			} catch (PrinterException printerException) {
				System.out.println("Error printing: " + printerException);
			}
	}

	public int print(Graphics paramGraphics, PageFormat paramPageFormat, int paramInt) {
		boolean bool1 = true;
		boolean bool2 = false;

		Graphics2D graphics2D = (Graphics2D) paramGraphics;

		disableDoubleBuffering(this.componentToBePrinted);

		Dimension dimension = this.componentToBePrinted.getSize();
		double d1 = dimension.width;
		double d2 = dimension.height;
		double d3 = paramPageFormat.getImageableHeight();
		double d4 = paramPageFormat.getImageableWidth();
		double d5 = 798.0D;
		double d6 = 1.0D;
		double d7 = d3 - 30.0D;
		if (d3 - 30.0D < d5) {
			d6 = (d3 - 30.0D) / d5;
		} else {
			d7 = d5;
		}
		if (d4 < d6 * d1) {
			d6 = d4 / d1;
		}
		int i = (int) Math.ceil(d2 / d5);
		if ((int) d2 - (int) ((i - 1) * d5) < 31)
			bool2 = true;

		if (paramInt >= i) {
			bool1 = true;
		} else if (paramInt == i - 1) {
			if (((bool2 ? 1 : 0) & ((i > 1) ? 1 : 0)) != 0) {
				bool1 = true;
			} else {
				graphics2D.setClip(new Rectangle(0, (int) paramPageFormat.getImageableY() + 15, (int) d4, (int) d7));
				graphics2D.scale(d6, d6);
				graphics2D.translate(paramPageFormat.getImageableX() + 30.0D, paramPageFormat.getImageableY() + 15.0D);
				graphics2D.translate(0.0D, -paramInt * d5);

				this.componentToBePrinted.paint(graphics2D);

				enableDoubleBuffering(this.componentToBePrinted);
				bool1 = false;
			}
		} else if (paramInt == i - 2) {
			if (bool2) {
				graphics2D.setClip(
						new Rectangle(0, (int) paramPageFormat.getImageableY() + 15, (int) d4, (int) (d7 + 30.0D)));
				graphics2D.scale(d6, d6);
				graphics2D.translate(paramPageFormat.getImageableX() + 30.0D, paramPageFormat.getImageableY() + 15.0D);
				graphics2D.translate(0.0D, -paramInt * d5);

				this.componentToBePrinted.paint(graphics2D);

				enableDoubleBuffering(this.componentToBePrinted);
				bool1 = false;
			} else {
				graphics2D.setClip(new Rectangle(0, (int) paramPageFormat.getImageableY() + 15, (int) d4, (int) d7));
				graphics2D.scale(d6, d6);
				graphics2D.translate(paramPageFormat.getImageableX() + 30.0D, paramPageFormat.getImageableY() + 15.0D);
				graphics2D.translate(0.0D, -paramInt * d5);

				this.componentToBePrinted.paint(graphics2D);

				enableDoubleBuffering(this.componentToBePrinted);
				bool1 = false;
			}
		} else {
			graphics2D.setClip(new Rectangle(0, (int) paramPageFormat.getImageableY() + 15, (int) d4, (int) d7));
			graphics2D.scale(d6, d6);
			graphics2D.translate(paramPageFormat.getImageableX() + 30.0D, paramPageFormat.getImageableY() + 15.0D);
			graphics2D.translate(0.0D, -paramInt * d5);

			this.componentToBePrinted.paint(graphics2D);

			enableDoubleBuffering(this.componentToBePrinted);
			bool1 = false;
		}
	
		return bool1 ? 1:0;

		// return bool1;
	}

	public static void disableDoubleBuffering(Component paramComponent) {
		RepaintManager repaintManager = RepaintManager.currentManager(paramComponent);
		repaintManager.setDoubleBufferingEnabled(false);
	}

	public static void enableDoubleBuffering(Component paramComponent) {
		RepaintManager repaintManager = RepaintManager.currentManager(paramComponent);
		repaintManager.setDoubleBufferingEnabled(true);
	}
}
