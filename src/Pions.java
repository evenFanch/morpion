public class Pions
{
	private int    placement ; 
	private char   type		 ;

	public Pions (int placement, char type)
	{
		this.placement = placement  ;
		this.type	   = type		;
	}

	public int    getPlacement()  	{return this.placement 					;}
	public char   getType() 		{return this.type      					;}
	public String toString()  		{return this.type+"   "+this.placement	;}
}