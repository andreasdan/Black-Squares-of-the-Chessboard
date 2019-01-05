import java.util.ArrayList;

public class Chessboard
{
    private int[][] board; //board representation
    
    public Chessboard()
    {
        //1 = black square, 0 = white square
        //0 index means that the bottom row of the board is the top line (reversed view)
        board = new int[][] {
                                {0, 1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 1, 0},
                                {0, 1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 1, 0},
                                {0, 1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 1, 0},
                                {0, 1, 0, 1, 0, 1, 0, 1},
                                {1, 0, 1, 0, 1, 0, 1, 0}
                            };
    }
    
    public boolean isBlackSquare(int x, int y)
    {
        //1 is subtracted because the board is 0 indexed on both arrays
        return (board[x - 1][y - 1] > 0);
    }
    
    public void printBoard(ArrayList<Integer> xPath, ArrayList<Integer> yPath)
    {
        System.out.println("\nWhite square:\t[ ]\nBlack square:\t[O]\nPawn path:\t\t[X]\n");
        
        boolean isPath = false;
                
        for (int i = 7; i >= 0; i--)
        {
            System.out.print((i + 1) + " ");
            
            for (int j = 0; j < board.length; j++)
            {
                //check if square is a part of the pawns path (marked as [X])
                for (int k = 0; k < xPath.size(); k++)
                {
                    if (xPath.get(k) == (j + 1) && yPath.get(k) == (i + 1)) //1 is added because the board is 0 indexed
                    {
                        isPath = true;
                        System.out.print("[X]");
                    }
                }
                
                //if square is not a path, print white or black square
                if (!isPath)
                {            
                    //anything higher than 0 is considered a 1
                    if (board[i][j] == 0)
                    {
                        System.out.print("[ ]");
                    }
                    else
                    {
                        System.out.print("[O]");
                    }
                }
                
                isPath = false;
            }
            
            System.out.print("\n");
        }
        
        System.out.println("   1  2  3  4  5  6  7  8\n");
    }
}