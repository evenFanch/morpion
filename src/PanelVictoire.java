import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class PanelVictoire extends JPanel implements ActionListener
{
	private Controleur 	ctrl	;
	private char 		gagnant	;
	private JButton 	btn		;

	private Graphics2D 	g2		;

	public PanelVictoire (Controleur ctrl, char gagnant)
	{

		this.ctrl= ctrl ;
		this.gagnant=gagnant;

		this.btn = new JButton ("Rejouer");

		this.btn.addActionListener(this);

		this.add(this.btn);

		this.repaint()	;

	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(this.btn))
		{
			this.ctrl.rejouer();
		}
	}

	public void paintComponent(Graphics g)
	{

		this.g2 = (Graphics2D) g;
		
		if (this.gagnant=='x')
		{
			this.g2.drawString ("Bravo au joueur de la Croix d'avoir gagné", 100, 50);
			this.g2.drawImage( getToolkit().getImage("images/croix.png")  , 150,150,this);
		}
			
		if (this.gagnant=='o')
		{
			this.g2.drawString ("Bravo au joueur du cercle d'avoir gagné",100, 50);
			this.g2.drawImage( getToolkit().getImage("images/cercle.png") , 150,150,this);
		}

		
	}

}