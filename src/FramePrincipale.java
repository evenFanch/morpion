import javax.swing.*;
import java.awt.event.*;

public class FramePrincipale extends JFrame
{
	private Controleur 		ctrl;
	private PanelPrincipale panel;

	public FramePrincipale (Controleur ctrl)
	{
		this.ctrl=ctrl;

		this.setTitle   ("Morpion" );
		this.setSize    ( 610,640  );
		this.setLocation(  150, 50 );

		this.panel = new PanelPrincipale(ctrl);

		this.add (this.panel);

		this.setVisible(true);
	}

	public PanelPrincipale getPanelPrincipale() {return this.panel;}
}