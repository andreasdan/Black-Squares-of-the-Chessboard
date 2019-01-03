import java.util.ArrayList;

public class Pawn
{
    private int xPos;
    private int yPos;
    private int moveCount;
    
    private ArrayList<Integer> xPath;
    private ArrayList<Integer> yPath;
    
    public Pawn()
    {
        //default start is top right corner (0 indexed)
        xPos = 1;
        yPos = 8;
        moveCount = 0;
        
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
        //loops until we have reached to correct square
        while (xPos != x || yPos != y)
        {
            //determine move on x-axis
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
            
            //determine move on y-axis
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
            moveCount++;
            
            System.out.println(moveCount + ". move to (" + xPos + "," + yPos + ")");
        }
    }
        
    private void savePosition()
    {
        xPath.add(xPos);
        yPath.add(yPos);
    }
    
    public void reset()
    {
        xPos = 1;
        yPos = 8;
        moveCount = 0;
        
        xPath = new ArrayList<Integer>();
        yPath = new ArrayList<Integer>();
        
        savePosition();
    }
}