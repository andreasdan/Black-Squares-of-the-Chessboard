import java.util.ArrayList;

public class Pawn
{
    private int xPos;
    private int yPos;
    
    private ArrayList<Integer> xPath;
    private ArrayList<Integer> yPath;
    
    public Pawn()
    {
        //default start is top right corner (0 indexed)
        xPos = 1;
        yPos = 8;
        
        xPath = new ArrayList<Integer>();
        yPath = new ArrayList<Integer>();
        
        savePosition();
    }
    
    public ArrayList<Integer> getXPath()
    {
        return xPath;
    }
    
    public ArrayList<Integer> getYPath()
    {
        return yPath;
    }
    
    public void findPath(int x, int y)
    {
        System.out.println("Pawn position (" + xPos + "," + yPos + ")");
        
        while (xPos != x || yPos != y)
        {
            if (xPos == 8)
            {
	            xPos--;
            }
            else if (xPos == 1)
            {
	            xPos++;
            }
            else
            {
	            if (xPos <= x)
	            {
		            xPos++;
	            }
	            else
	            {
		            xPos--;
	            }	
            }

            if (yPos == 8)
            {
	            yPos--;
            }
            else if (yPos == 1)
            {
	            yPos++;
            }
            else
            {
	            if (yPos <= y)
	            {
		            yPos++;
	            }
	            else
	            {
		            yPos--;
	            }	
            }

            savePosition();
            System.out.println("Pawn position (" + xPos + "," + yPos + ")");
        }
    }
        
    private void savePosition()
    {
        xPath.add(xPos);
        yPath.add(yPos);
    }
}