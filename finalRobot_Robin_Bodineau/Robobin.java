
/**
 * Write a description of class rainbowRobot here.
 *
 * @author Robin Bodineau
 * @version 31/10/23
 */
public class Robobin extends RobotG
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Robobin
     */
    public Robobin(String nameRobot, int dir, int x, int y)
    {
        super(nameRobot,dir,x,y);
    }
    
    /**
     * fonction qui permet un déplacement en forme de R
     */
    public void avancer(){
        for (int i =0; i<2; i++){
            super.setDirection(3);
            super.avancer();Canvas.wait(200);}
        for (int j=0; j<3; j++){
        super.setDirection(j);
        super.avancer();Canvas.wait(200);}
        for (int k=0; k<2; k++){
            super.setDirection(k);
        super.avancer();Canvas.wait(200);}
        }
        }
        
    
   

