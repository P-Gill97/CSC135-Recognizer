import java.util.Scanner;
import java.util.StringTokenizer;
public class Parser {
    String input;
    int index = 0;

    private void Start(){


    }
    // returns next token
    private char token(){
        return input.charAt(index);
    }
    private void incrementToken(){
        if(index <=input.length()) {
            index++;
        }
    }
    // DO BOTTOM UP.
    private void program(){

        match('S');


        // while loop with statement



    }

    private void statment() {
        b();
    }

    private void b() {
    }

    // matches
    private void match(char x){
        if(x == token()){
            incrementToken();
        }else{
            System.out.println("MATCH ERROR");
        }
    }
    public static void main(String[] args){
        Parser parser = new Parser();
        Scanner i = new Scanner(System.in);
        System.out.println("Enter the String: ");
        parser.input = i.nextLine();


    }






}
