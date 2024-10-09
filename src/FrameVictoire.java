import javax.swing.*;
import java.awt.event.*;

public class FrameVictoire extends JFrame
{
	private Controleur 		ctrl	;
	private char 			gagnant	;
	private PanelVictoire	panel	;

	public FrameVictoire (Controleur ctrl, char gagnant)
	{
		this.ctrl=ctrl;

		this.gagnant=gagnant;

		this.setTitle   ("Bravo" );
		this.setSize    ( 500,500  );
		this.setLocation(  150, 50 );

		this.panel = new PanelVictoire( this.ctrl, this.gagnant);
		this.panel.repaint();

		this.add(this.panel);
	

		this.setVisible(true);
	}
}
