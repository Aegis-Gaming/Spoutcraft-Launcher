package org.spoutcraft.launcher.gui;

import java.awt.Frame;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class LoginWindowsButton extends ImageButton implements MouseListener {

	public String imageLocation = null;
	public String imageLocationHover = null;
	private String type;
	private MainForm mainForm;
	
	public LoginWindowsButton(String type, MainForm mainForm) {
		super(getImageType(type));
		this.type = type;
		loadImages(type);
		this.addMouseListener(this);
		this.mainForm = mainForm;
	}
	
	
	public static String getImageType(String type) {
		if (type.equals("close")) {
			return "/org/spoutcraft/launcher/WindowsButtons/closeButton.png";
		} else {
			return "/org/spoutcraft/launcher/WindowsButtons/miniButton.png";
		}
		
	}
	
	public String loadImages(String type) {
		if (type.equals("close")) {
			imageLocation = "/org/spoutcraft/launcher/WindowsButtons/closeButton.png";
			imageLocationHover = "/org/spoutcraft/launcher/WindowsButtons/closeButtonHover.png";
		} else {
			imageLocation = "/org/spoutcraft/launcher/WindowsButtons/miniButton.png";
			imageLocationHover = "/org/spoutcraft/launcher/WindowsButtons/miniButtonHover.png";
		}
		return imageLocation;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Window window = (Window) SwingUtilities.getRoot(e.getComponent());
		if (type.equals("close")) {
			window.dispatchEvent(new WindowEvent(
					window, WindowEvent.WINDOW_CLOSING
					));
			mainForm.getLoginButton().setEnabled(true);
			mainForm.getOptionsButton().setEnabled(true);
			mainForm.getModLeft().setEnabled(true);
			mainForm.getModRight().setEnabled(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		try {
			this.image = ImageIO.read(getClass().getResource(imageLocationHover));
			this.repaint();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		try {
			this.image = ImageIO.read(getClass().getResource(imageLocation));
			this.repaint();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
