
import java.util.*;

public class NQueens1 {

    public static int solve(int n) {
        Stack<Integer> s = new Stack<Integer>(); //initialize stack to store the columns

        int  current = 0; //current column position
        int numSolutions = 0;
        while(current<=n) {
            if (s.size() == n) {        //solution has been found
                printSolution(s);       //print the solution
                numSolutions++;         //increase number of solutions
                current = s.pop()+1;    //go on to find more solutions as if no solution has been found
            }
            if (current == n) {         //ran out of columns and need to backtrack
                if(s.isEmpty())
                    break;
                if ((s.peek() == n) && (s.size() == 1)) {
                    break;
                }
                if (s.peek() == n) {
                    s.pop();
                    current = s.pop() + 1;
                } else {
                    current = s.pop() + 1;
                }
            } else if (isSafe(s, current)) {  //check if position is safe
                s.push(current);              //is safe, place queen here
                current = 0;                 // reset column to 0
            } else {
                current++;                  //not safe, go onto next column
            }
        }
        return numSolutions;
    }


        public static boolean isSafe(Stack<Integer> s, int currentPosition) {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i) == currentPosition){
                    return false;
                }
                if ((s.get(i) - currentPosition) == (s.size() - i)){
                    return false;
                }
                if ((currentPosition - s.get(i)) == (s.size() - i)){
                    return false;
                }
            }
            return true;
        }


        private static void printSolution(Stack<Integer> s) {
            for (int i = 0; i < s.size(); i ++) {
                for (int j = 0; j < s.size(); j ++) {
                    if (j == s.get(i))
                        System.out.print("Q ");
                    else
                        System.out.print("- ");
                }
                System.out.println();
            }
            System.out.println();
        }


        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter integer");
            int n = scan.nextInt();
            if (n <= 3){
                System.out.println("There are 0 solutions");
            }
            else {
                int number = solve(n);
                System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
            }
        }
}

