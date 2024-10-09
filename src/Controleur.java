public class Controleur
{
	private boolean 		rondTour;

	private Pions[] 		tabPions;

	private FramePrincipale frame   ; 
	private FrameVictoire   frameVictoire ; 

	public Controleur()
	{
		this.rondTour = false;

		this.tabPions = new Pions[9];

		this.frame    = new FramePrincipale(this);

	}


	public boolean coo (int x, int y)
	{
	
		char type ;

		if (rondTour)   type = 'o';
		else 			type = 'x';
		int placement ;

		if (x<200 && y<200) 						{placement = 1;}
		else if (x>200 && x<400 &&  y<200) 			{placement = 2;}
		else if (x>400 && x<600 &&  y<200)  		{placement = 3;}

		else if (x<200 && y<400 &&  y>200) 			{placement = 4;}
		else if (x>200 && x<400 && y<400 &&  y>200) {placement = 5;}
		else if (x>400 && x<600 && y<400 &&  y>200) {placement = 6;}

		else if (x<200 && y>400 )		 			{placement = 7;}
		else if (x>200 && x<400 && y>400) 			{placement = 8;}
		else if (x>400 && x<600 && y>400)			{placement = 9;}

		else 
			placement =0;

		//System.out.println("x : "+x+"   y : "+y+"  placement : "+placement); 				//Test coordonées clique 

		for (int i=0; i<this.tabPions.length; i++)
		{

			if (this.tabPions[i] == null)
			{
			this.tabPions[i] = new Pions(placement, type);
				this.rondTour=!this.rondTour;
				this.frame.getPanelPrincipale().repaint();
				testVictoire();
				return true;
			}

			if (this.tabPions[i].getPlacement() == placement)
				return false;
		}
		return true ;
	}

	public void rejouer()
	{
		//System.out.println ("Rejouer"); Test fonctionnalité du bouton rejouer
		this.tabPions = new Pions[9];
		this.frame.getPanelPrincipale().repaint();
		this.frameVictoire.dispose();
		this.rondTour = false;

	}


	public char testVictoire ()
	{
		char[][] tabVictoire = {{'*','*','*'},{'*','*','*'},{'*','*','*'}};
		char gagnant='*';

		for (int i=0; i<this.tabPions.length; i++)
		{
			if (this.tabPions[i]!=null)
			{
				switch (this.tabPions[i].getPlacement())
				{
					case 1 : tabVictoire[0][0]= this.tabPions[i].getType();break;
					case 2 : tabVictoire[0][1]= this.tabPions[i].getType();break;
					case 3 : tabVictoire[0][2]= this.tabPions[i].getType();break;
					case 4 : tabVictoire[1][0]= this.tabPions[i].getType();break;
					case 5 : tabVictoire[1][1]= this.tabPions[i].getType();break;
					case 6 : tabVictoire[1][2]= this.tabPions[i].getType();break;
					case 7 : tabVictoire[2][0]= this.tabPions[i].getType();break;
					case 8 : tabVictoire[2][1]= this.tabPions[i].getType();break;
					case 9 : tabVictoire[2][2]= this.tabPions[i].getType();break;
				}
			}
		}

		for (int i=0; i<tabVictoire.length; i++)
		{
			System.out.print("\n|");
			for (int j=0; j<tabVictoire[0].length; j++)
			{
				System.out.print(tabVictoire[i][j]+"|"); // Affiche le tableau sur console
			}
		}

		for (int i=0; i<3;i++)
		{
			if ( tabVictoire[i][0]==tabVictoire[i][1] && tabVictoire[i][0]==tabVictoire[i][2] && tabVictoire[i][0]!='*')
				gagnant= tabVictoire[i][0];

			if ( tabVictoire[0][i]==tabVictoire[1][i] &&  tabVictoire[0][i]==tabVictoire[2][i] && tabVictoire[0][i]!='*')
				gagnant= tabVictoire[0][i];
		}

		if (tabVictoire[0][0]==tabVictoire[1][1] && tabVictoire[0][0]==tabVictoire[2][2] && tabVictoire[0][0]!='*')
			gagnant= tabVictoire[0][0];

		if (tabVictoire[0][2]==tabVictoire[1][1] && tabVictoire[0][2]==tabVictoire[2][0] && tabVictoire[2][0]!='*')
			gagnant= tabVictoire[2][0];


		if (gagnant=='o' || gagnant == 'x')
		{
			if (this.frameVictoire==null || !(this.frameVictoire.isVisible()))
				this.frameVictoire=new FrameVictoire(this, gagnant);
			return gagnant;
		}
		return '*';
			
	}

	public FrameVictoire getFrameVictoire() {return this.frameVictoire;}

	public void setFrameVictoire(FrameVictoire frame) { this.frameVictoire=frame;}

	public Pions[] getTabPions () {return this.tabPions;}

	public static void main (String[] a)
	{
		new Controleur();
		
	}
}