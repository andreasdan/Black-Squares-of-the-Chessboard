import java.util.Scanner;

public class ChessboardExercise
{    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Chessboard board = new Chessboard();
        Pawn pawn = new Pawn();
        
        int inputX = 0;
        int inputY = 0;
        
        //get coordinates from user
        boolean hasInput = false;
        while (!hasInput)
        {
            System.out.print("Insert coordinates to navigate pawn 'x,y' example: 3,2>");
            
            try
            {
                String[] input = scanner.nextLine().split(",");
                
                inputX = Integer.parseInt(input[0]);
                inputY = Integer.parseInt(input[1]);
                
                
                
                if (!board.isBlackSquare(inputX, inputY))
                {
                    System.out.println("The selected coordinates does not match a black square on the board. Try again.");
                }
                else
                {
                    hasInput = true;
                }
            }
            catch (Exception e)
            {
                System.out.println("Wrong input format. Try again.");
            }
        }
        
        //exercise 1
        System.out.println("Exercise 1 test (" + inputX + "," + inputY + "):\n");
        pawn.findPath(inputX, inputY);
        board.printBoard(pawn.getXPath(), pawn.getYPath());
        pawn.reset();
        
        //exercise 2
        System.out.println("Exercise 2 test (8,8) with 13 moves:\n");
        pawn.findPath(1,2);
        pawn.findPath(8,1);
        board.printBoard(pawn.getXPath(), pawn.getYPath());
        pawn.reset();
    }
}