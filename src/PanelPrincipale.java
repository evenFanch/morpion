import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class PanelPrincipale extends JPanel 
{
	private Controleur 	ctrl	;
	

	private Graphics2D g2	;

	public PanelPrincipale (Controleur ctrl)
	{

		this.ctrl= ctrl ;

		GereSouris gereSouris = new GereSouris();
		
		this.addMouseListener		( gereSouris );
		this.addMouseMotionListener ( gereSouris );

		
		this.setVisible(true);
	}

	public void paintComponent(Graphics g)
	{
		int x,y;

		this.g2 = (Graphics2D) g;

		this.g2.setBackground (Color.WHITE);
		this.g2.clearRect (0,0,600,600);
		this.g2.drawLine(0,200,600,200);
		this.g2.drawLine(0,400,600,400);
		this.g2.drawLine(200,0,200,600);
		this.g2.drawLine(400,0,400,600);

		x=y=0;
		
		for (int i=0; i<this.ctrl.getTabPions().length; i++)
		{
			if (this.ctrl.getTabPions()[i]!= null)
			{
				switch (this.ctrl.getTabPions()[i].getPlacement())
				{
					case 1 : x=0  ; y=0  ; break;
					case 2 : x=200; y=0  ; break;
					case 3 : x=400; y=0  ; break;
					case 4 : x=0  ; y=200; break;
					case 5 : x=200; y=200; break;
					case 6 : x=400; y=200; break;
					case 7 : x=0  ; y=400; break;
					case 8 : x=200; y=400; break;
					case 9 : x=400; y=400; break;
				}

				//System.out.println ("x="+x+"  y="+y); //Affiche le placement des images

				if (this.ctrl.getTabPions()[i].getType() == 'o')
					this.g2.drawImage( getToolkit().getImage("images/cercle.png"), x,y,this);
				else 
					this.g2.drawImage( getToolkit().getImage("images/croix.png") , x,y,this);
			}
		}
	}

	
	private class GereSouris extends MouseAdapter 
	{
		
		public void mousePressed( MouseEvent e)
		{
			ctrl.coo( e.getX(), e.getY() );
			/*else 
			{
				if (ctrl.getFrameVictoire()==null || !(ctrl.getFrameVictoire().isVisible()))
					new FrameVictoire(ctrl, ctrl.testVictoire());
			}*/
				
				
		}
	}

}