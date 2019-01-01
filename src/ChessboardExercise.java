public class ChessboardExercise
{    
    public static void main(String[] args)
    {
        Chessboard board = new Chessboard();
        Pawn pawn1 = new Pawn();
        Pawn pawn2 = new Pawn();
        
        //exercise 1
        System.out.println("Exercise 1 test (3,2):\n");
        pawn1.findPath(3, 2);
        board.printBoard(pawn1.getXPath(), pawn1.getYPath());
        
        //exercise 2
        System.out.println("Exercise 2 test (8,8) with 13 moves:\n");
        pawn2.findPath(7,8);
        pawn2.findPath(8,1);
        board.printBoard(pawn2.getXPath(), pawn2.getYPath());
    }
}