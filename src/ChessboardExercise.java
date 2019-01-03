public class ChessboardExercise
{    
    public static void main(String[] args)
    {
        Chessboard board = new Chessboard();
        Pawn pawn = new Pawn();
        
        //exercise 1
        System.out.println("Exercise 1 test (3,2):\n");
        pawn.findPath(3, 2);
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