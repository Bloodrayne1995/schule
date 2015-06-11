package binBaum;

// package binBaum;


//Horst Gierhardt, Version vom 31.10.2004 //
// erweitert: PWE , 23.08.2007


import java.awt.*;

class Turtle  
{
  protected double posX, posY;        // Aktuelle Position der Turtle
  protected double winkel;            // Aktueller Blickwinkel
  protected Color farbe=Color.black;  // Standard-Zeichenfarbe
  protected Container c;			  // Der Zeichencontainer 
  protected double homeX, homeY;      // Home-Koordinaten
  protected boolean stiftUnten;
  protected int breiteX, hoeheY;
  protected Graphics g;

  public Turtle(Container cont)
  { 	  
	    winkel=0;
	    stiftUnten = true;
	    
	    c=cont;					// merken des Containers 
	    g=cont.getGraphics();	// und des GrafikObjektes
	    breiteX = c.getBounds().width;
	    hoeheY = c.getBounds().height;
	    posX = breiteX / 2; 
	    posY = hoeheY;		// positioniert die Turtle in die linke untere Ecke  
	    homeX = posX; 
	    homeY = posY;	  
	 
	    
	   

  }

  public void homePosition()
  {
    posX=homeX;
    posY=homeY;
    winkel=0;
  }

  public void bewege(double laenge)
  {
    g.setColor(farbe);
    double neuX = posX + Math.cos(bogen(winkel))*laenge;
    double neuY;
    neuY = posY - Math.sin(bogen(winkel))*laenge;
    if (stiftUnten) g.drawLine((int) posX, (int) posY, (int) neuX, (int) neuY);

    posX = neuX;
    posY = neuY;
  }

  public void dreheLinks(double grad)
  {
    winkel = winkel + grad;
    //   if (winkel > 360) winkel = winkel -360;
  }

  public void dreheRechts(double grad)
  {
    winkel = winkel - grad;
    //	if (winkel<0) winkel = 360+winkel ;  
    
  }

  public void back(int laenge){
	  dreheLinks(180); 
	  stiftHoch(); 
	  bewege(laenge); 	 
	  dreheRechts(180);
	  stiftRunter(); 
  }
  
  
  public void loesche()
  {
	homePosition();

    int x=c.getBounds().width;
    int y=c.getBounds().height;
    g.clearRect(0, 0, x, y);
  }

  public void setFarbe(Color c)
  {
    farbe = c;
  }

  public void stiftHoch()
  {
    stiftUnten=false;
  }

  public void stiftRunter()
  {
    stiftUnten=true;
  }


  public void zeichneNormal()
  {
    g.setPaintMode();
  }

  private double bogen(double winkel)
  {
    return winkel*Math.PI/180;
  }

}//Turtle.class

