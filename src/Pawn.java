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
    
    public int getXPos()
    {
        return xPos;
    }
    
    public int getYPos()
    {
        return yPos;
    }
    
    public ArrayList<Integer> getXPath()
    {
        return xPath;
    }
    
    public ArrayList<Integer> getYPath()
    {
        return yPath;
    }
    
    private void move(Move move)
    {
        switch (move)
        {
            case UPPERLEFT:
                xPos--;
                yPos++;
                break;
            case UPPERRIGHT:
                xPos++;
                yPos++;
                break;
            case LOWERLEFT:
                xPos--;
                yPos--;
                break;
            case LOWERRIGHT:
                xPos++;
                yPos--;
                break;
        }
        
        savePosition();
        
        //check if pawn is out of bounds
        if (xPos < 1 || xPos > 8 || yPos < 1 || yPos > 8)
        {
            System.out.println("Warning: Pawn moved out of bounds (" + xPos + "," + yPos + ")");
        }
    }
    
    public void findPath(int x, int y)
    {
        System.out.println("Finding path to (" + x + "," + y + ")");
        System.out.println("Pawn moved to (" + xPos + "," + yPos + ")");
        
        while (xPos != x || yPos != y)
        {
            if (xPos <= x && yPos <= y)
            {
                move(Move.UPPERRIGHT);
            }
            else if (xPos <= x && yPos >= y)
            {
                move(Move.LOWERRIGHT);
            }
            else if (xPos >= x && yPos <= y)
            {
                move(Move.UPPERLEFT);
            }
            else if (xPos >= x && yPos >= y)
            {
                move(Move.LOWERLEFT);
            }
            else
            {
                System.out.println("WARNING: Pawn stuck not able to calculate next move.");
            }
        }
    }
    
    private void savePosition()
    {
        xPath.add(xPos);
        yPath.add(yPos);
    }
}