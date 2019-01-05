import java.util.Scanner;

public class Menu
{
    private Scanner scanner;
    private Chessboard board;
    private Pawn pawn;

    public Menu()
    {
        scanner = new Scanner(System.in);
        board = new Chessboard();
        pawn = new Pawn();
    }
    
    public void run()
    {
        //run program until the user exits
        boolean runProgram = true;
        while (runProgram)
        {
            System.out.print("Select one of the following options:\n0. Show board\n1. Run exercise 1\n2. Run exercise 2\n3. Exit\nInput>");
            
            //read userinput
            char option = scanner.nextLine().charAt(0);
            switch (option)
            {
                case '0':
                    board.printBoard();
                    break;
                case '1':
                    runExerciseOne();
                    break;
                case '2':
                    runExerciseTwo();
                    break;
                case '3':
                    runProgram = false;
                    break;
                default:
                    System.out.println("Invalid option input...");
                    break;
            }            
        }
    }
    
    public void runExerciseOne()
    {
        int inputX = 0;
        int inputY = 0;
        
        //get coordinates from user
        boolean hasInput = false;
        while (!hasInput)
        {
            System.out.print("Insert coordinates between 1-8 to navigate pawn: 'x,y' (example: 3,2)>");
            
            try
            {
                String[] input = scanner.nextLine().split(",");
                
                //attempt to parse input as integers
                inputX = Integer.parseInt(input[0]);
                inputY = Integer.parseInt(input[1]);
                
                //check if the input numbers are within the board
                if (inputX < 1 || inputX > 8 || inputY < 1 || inputY > 8)
                {
                    System.out.println("Coordinates are only allowed to be (including) 1-8. Try again.");
                }
                else
                {
                    //check if the coordinates match a black square
                    if (!board.isBlackSquare(inputX, inputY))
                    {
                        System.out.println("The selected coordinates does not match a black square on the board. Try again.");
                    }
                    else
                    {
                        hasInput = true;
                    }
                }
            }
            catch (Exception e)
            {
                System.out.println("Wrong input format. Try again.");
            }
        }
        
        //run exercise 1
        System.out.println("Exercise 1 test (" + inputX + "," + inputY + "):\n");
        pawn.findPath(inputX, inputY);
        board.printBoard(pawn.getXPath(), pawn.getYPath());
        pawn.reset();
    }
    
    public void runExerciseTwo()
    {
        System.out.println("Exercise 2 test (8,8) with 13 moves:\n");
        pawn.findPath(1,2);
        pawn.findPath(8,1);
        board.printBoard(pawn.getXPath(), pawn.getYPath());
        pawn.reset();
    }
}