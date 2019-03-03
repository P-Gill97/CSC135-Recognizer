import java.util.Scanner;
import java.util.StringTokenizer;
public class Parser {
    private String input;
    private int index = 0;
    private int  errorf =0;

    private void Start(){
        input += '$';
        program();
        match('$');

        if(errorf==1){

        }else{
            System.out.println("Legal");
        }

    }
    private void error()
    {
        errorf = 1;
        System.out.print("Error at position: " + index);
        System.out.println("Token: "+token() + " did not work" );
        incrementToken();
    }

    // returns next token
    private char token(){
        return input.charAt(index);
    }

    private void incrementToken(){
        if(index <input.length()-1) {
            index++;
        }else{
            System.out.println(" Success Out of tokens or no tokens added.");
            System.exit(0);
        }
    }
    // DO BOTTOM UP.
    private void program(){

        match('S');
        while (token()=='W'||token()=='Y'||token()=='X'||token()=='Z'||token()=='I'
                || token()=='D'||token()=='R'||token()=='O'||token()=='C'){
            statemt();
        }
        // while loop with statement

    }
    private void statemt(){
        if(token()=='W'||token()=='X'||token()=='Y'||token()=='Z') {
            assmnt();
        }else if(token()=='I'){
            ifstmt();
        }else if(token()=='D'){
            doo();
        }else if(token() =='R'||token()=='O'){
            inout();
        }else if(token()=='C'){
            progCall();
        }
    }
    private void assmnt(){
        ident();
        match('~');
        exprsn();
        match(';');
    }
    private void ifstmt(){
        match('I');
        comprsn();
        match('@');
        while (token()=='W'||token()=='Y'||token()=='X'||token()=='Z'||token()=='I'
                || token()=='D'||token()=='R'||token()=='O'||token()=='C'){
            statemt();
        }
        if(token()=='%'){
            while (token()=='W'||token()=='Y'||token()=='X'||token()=='Z'||token()=='I'
                    || token()=='D'||token()=='R'||token()=='O'||token()=='C'){
                statemt();
            }
        }
        match('&');
    }
    private void doo(){
        match('D');
        while (token()=='W'||token()=='Y'||token()=='X'||token()=='Z'||token()=='I'
                || token()=='D'||token()=='R'||token()=='O'||token()=='C'){
            statemt();
        }
        match('U');
        comprsn();
        match('E');
    }
    private void inout(){
        iosys();
        ident();
        while (token()==','){
            match(',');
            ident();
        }
        match(';');
    }
    private void iosys(){
        if(token()=='R'|| token()=='O'){
            match(token());
        }
    }
    private void progCall(){
        match('C');
        program();
        match('G');
    }
    private void comprsn(){
        match('(');
        oprnd();
        opratr();
        oprnd();
        match(')');
    }
    private void exprsn(){
        factor();
        while(token()=='+'){
        match('+');
        factor();
        }


    }
    private void factor(){
        oprnd();
        while(token() == '*'){
            match('*');
            oprnd();
        }
    }
    private void oprnd(){
        if(token()=='('){
            match('(');
            exprsn();
            match(')');
        }else if(token()=='0'||token()=='1'){
            integer();
        }else if(token()=='T'||token()=='F') {
            bool();
        }else if(token()=='W'||token()=='X'||token()=='Y'||token()=='Z'){
            ident();
        }
    }
    private void opratr(){
        if(token()=='<'||token()=='^'||token()=='!'||token() =='>'||token() =='='){
            match(token());
        }else{
            error();
        }
    }
    private void ident(){
        letter();
        while(token()=='0'||token()=='1'||token()=='W'||token()=='X'||token()=='Y'||token()=='Z'){
            charec();
        }

    }
    private void charec(){
        if(token()=='W'||token()=='X'||token()=='Y'||token()=='Z'){
            letter();
        }else {
            digit();
        }
    }
    private void integer() {
        digit();
        while(token()=='0'|| token() == '1'){
            digit();
        }
    }
    private void letter() {
        if(token()=='W'|| token() == 'X' || token() == 'Y'|| token()=='Z'){
            match(token());
        }else {
            error();
        }
    }

    private void digit(){
        if(token()=='0'|| token() == '1'){
            match(token());
        }else {
            error();
        }
    }

    private void bool() {
        if(token()=='T'|| token() == 'F'){
             match(token());
        }else {
            error();
        }
    }

    // matches
    private void match(char x){
        if(x == token()){
            incrementToken();
        }else{
            error();
        }
    }

    public static void main(String[] args){
        Parser parser = new Parser();
        Scanner i = new Scanner(System.in);
        System.out.println("Enter the String: ");
        parser.input = i.nextLine();
        parser.Start();

    }

}
