/*
 * Pelmus Marian
 * My PC!
 */

package tictactoe;

import java.util.Scanner;

/**
 * @author marti
 */
public class TicTacToe {
    
    public static void printTable(int arr[][]){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    //function to generate random number between 0-2
    public static int random(int limit){
        int i =(int)Math.abs(Math.random()*10);
        while(i>limit)
            i =(int)Math.abs(Math.random()*10);
        return i;
    }
    
    //computer move
    public static void comMove(int[][] arr){ 
        int e=0, t=0, o=0, f=0, a=0;
        if(isTableEmpty(arr)){
            move(random(7)+1, arr, 1);
        }//end first if
        else{
            for(int i=1; i<=8; i++){
                if(arraySum(winningPosition(i, arr)) == 8)
                    e = i;
                if(arraySum(winningPosition(i, arr)) == 2)
                    t = i;
                if(arraySum(winningPosition(i, arr)) == 1)
                    o = i;
                if(arraySum(winningPosition(i, arr)) == 5)
                    f = i;
            }//end first for   
            
            if(t != 0){
                a = 0;
            }
            else{
                if(e != 0)
                    a = 1;
                else{
                    if (o != 0) {
                        a = 2;
                    }
                    else{
                        if(f != 0)
                            a = 3;
                    }
                        
                }
            }
            switch(a){
                case 0: move(t, arr, 1);
                    break;
                case 1: move(e, arr, 1);
                    break;
                case 2: move(o, arr, 1);
                    break;
                case 3: move(f, arr, 1);
                    break;
            }//end switch
        }//end first else
    }
    //check if table is empty
    public static boolean isTableEmpty(int[][] arr){
        boolean isEmpty = false;
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += arr[i][j];
            }//end for j
        }//end for i
        if(sum == 0){
            isEmpty = true;
        }            
        return isEmpty;
    }
    
    //complete you line to win
    public static void move(int a, int[][] arr, int yourPiece){
        switch(a){
            case 1: for(int i=0; i<3; i++){
                        if(arr[0][i] == 0){
                            arr[0][i] = yourPiece;
                            break;
                        }
                     }
            break;
            case 2: for(int i=0; i<3; i++){
                        if(arr[1][i] == 0){
                            arr[1][i] = yourPiece;
                            break;
                        }
                     }
            break;
            case 3: for(int i=0; i<3; i++){
                        if(arr[2][i] == 0){
                            arr[2][i] = yourPiece;
                            break;
                        }
                     }
            break;
            case 4: for(int i=0; i<3; i++){
                        if(arr[i][0] == 0){
                            arr[i][0] = yourPiece;
                            break;
                        }
                     }
            break;
            case 5: for(int i=0; i<3; i++){
                        if(arr[i][1] == 0){
                            arr[i][1] = yourPiece;
                            break;
                        }
                     }
            break;
            case 6: for(int i=0; i<3; i++){
                        if(arr[i][2] == 0){
                            arr[i][2] = yourPiece;
                            break;
                        }
                     }
            break;
            case 7: for(int i=0; i<3; i++){
                        if(arr[i][i] == 0){
                            arr[i][i] = yourPiece;
                            break;
                        }
                     }
            break;
            case 8: for(int i=0, j=2; i<3; i++,j--){
                        if(arr[i][j] == 0){
                            arr[i][j] = yourPiece;
                            break;
                        }
                     }
            break;
        }
    }
    //player move
    public static void playerMove(int arr[][]){
        Scanner scan = new Scanner(System.in);
        System.out.println("Position Value: ");
        int x = scan.nextInt(),
            y = scan.nextInt();
        if(arr[x][y] == 0)
            arr[x][y] = 4;
        else{
            System.out.println("Psition not valid!");
            playerMove(arr);
        }
    }
    
    //winning positions
    public static int[] winningPosition(int a, int arr[][]){
        int[] position = new int[3] ;
        switch(a){
            case 1: position = new int[]{arr[0][0], arr[0][1], arr[0][2]};
            break;
            case 2: position = new int[]{arr[1][0], arr[1][1], arr[1][2]};
            break;
            case 3: position = new int[]{arr[2][0], arr[2][1], arr[2][2]};
            break;
            case 4: position = new int[]{arr[0][0], arr[1][0], arr[2][0]};
            break;
            case 5: position = new int[]{arr[0][1], arr[1][1], arr[2][1]};
            break;
            case 6: position = new int[]{arr[0][2], arr[1][2], arr[2][2]};
            break;
            case 7: position = new int[]{arr[0][0], arr[1][1], arr[2][2]};
            break;
            case 8: position = new int[]{arr[0][2], arr[1][1], arr[2][0]};
            break;
        }
        return position;
    }
    
    //calculate sum for an array (winning position)
    public static int arraySum(int[] arr){
        int sum = 0;
        for(int i=0; i<3; i++)
            sum += arr[i];
        return sum;
    }
        
    //check for wins
    public static boolean checkIfWin(int arr[][]){
        boolean stop = false;
        int[] position;
        for(int i=1; i<=8; i++){
            position = winningPosition(i, arr);
            if(arraySum(position) == 3 || arraySum(position) == 12){
                stop = true;
                break;
            }
        }
        return stop;
    }
    
    //check if table is full
    public static boolean tableIsFull(int[][] arr){
        boolean isFull = false;
        int sum = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                sum += arr[i][j];
                if(sum >= 21)
                    isFull = true;
            }
        }
        return isFull;
    }

    public static void main(String[] args) 
    {
        int[][] arr = {{0,0,0},{0,0,0},{0,0,0}};
        while(true){
            
            System.out.println("Computer Move!");
            comMove(arr);
            printTable(arr);
            if(checkIfWin(arr)){
                System.out.println("Someone Wins!");
                break;
            }
            if(tableIsFull(arr)){
                System.out.println("Game Over!");
                break;
            }
            System.out.println("Your Move!");
            playerMove(arr);
            printTable(arr);
            if(checkIfWin(arr)){
                System.out.println("Someone Wins!");
                break;
            }
            if(tableIsFull(arr)){
                System.out.println("Game Over");
                break;
            }
        }
    }
}