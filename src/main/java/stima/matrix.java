package stima;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class matrix {
    public int row;
    public int col;
    public char[][] data;
    public ArrayList<Character> unique;

    public matrix(int i, int j){
        if (i<=0 || j<=0){
            throw new IllegalArgumentException("NIGGA!\n");
        }
        this.row=i;
        this.col=j;
        this.data= new char[i][j];
    }

    public void find_uniques(){
        if (this.row<=0 || this.col<=0){
            throw new IllegalArgumentException("Empty Matrix NIGGAAA!\n");
        }
        ArrayList<Character> temp = new ArrayList<Character>();
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                char c = this.data[i][j];
                if(!temp.contains(c)){
                    temp.add(c);
                }
            }
        }
        this.unique = temp;
    }

    public void print_matrix(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                System.out.print(this.data[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void copy(matrix source){
        this.col = source.col;
        this.row = source.row;
        for(int i=0;i<source.row;i++){
            for(int j=0;j<source.col;j++){
                this.data[i][j] = source.data[i][j];
            }
        }
        this.unique = source.unique;
    }

    public boolean check(ArrayList<cell> arr){
        int x=0,y=0;
        Set<Character> set =new HashSet<>();
        //check if there are queens next to each other (including diagonal)
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.data[i][j]=='#'){
                    if(this.col-1 ==0 && this.row-1 == 0){
                        return true;
                    }
                    else if(j==0 && i==0){
                        if(this.data[i][j+1]=='#' || this.data[i+1][j+1]=='#' || this.data[i+1][j]=='#') return false;
                    }
                    else if(i==0 && j==this.col-1){
                        if(this.data[i][j-1]=='#' || this.data[i+1][j-1]=='#' || this.data[i+1][j]=='#')return false;
                    }
                    else if(i==this.row-1 && j==0){
                        if(this.data[i][j+1]=='#' || this.data[i-1][j+1]=='#' || this.data[i-1][j]=='#')return false;
                    }
                    else if(i==this.row-1 && j==this.col-1){
                        if(this.data[i][j-1]=='#' || this.data[i-1][j-1]=='#' || this.data[i-1][j]=='#') return false;
                    }
                    else if(i==0){
                        if(this.data[i][j-1]=='#' ||this.data[i+1][j-1]=='#' || this.data[i][j+1]=='#' || this.data[i+1][j+1]=='#' || this.data[i+1][j]=='#') return false;
                    }
                    else if(j==0){
                        if(this.data[i-1][j]=='#' ||this.data[i-1][j+1]=='#' || this.data[i][j+1]=='#' || this.data[i+1][j+1]=='#' || this.data[i+1][j]=='#') return false;
                    }
                    else if(i==this.row-1){
                        if(this.data[i][j-1]=='#' ||this.data[i-1][j-1]=='#' || this.data[i-1][j]=='#' || this.data[i-1][j+1]=='#' || this.data[i][j+1]=='#') return false;
                    }
                    else if(j==this.col-1){
                        if(this.data[i-1][j]=='#' ||this.data[i-1][j-1]=='#' || this.data[i][j-1]=='#' || this.data[i+1][j-1]=='#' || this.data[i+1][j]=='#') return false;
                    }
                    else{
                        if(this.data[i-1][j-1] =='#' || this.data[i-1][j] =='#' || this.data[i-1][j+1] =='#' || this.data[i][j-1] =='#' || this.data[i][j+1] =='#' || this.data[i+1][j-1] =='#' || this.data[i+1][j] =='#' || this.data[i+1][j+1] =='#') return false;
                    }
                }
            }
        }
        
        //check rows
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.data[i][j]=='#'){
                    x++;
                }
                if(x>1) return false;
            }
            x=0;
        }

        //check columns
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.data[j][i]=='#'){
                    y++;
                }
                if(y>1) return false;
            }
            y=0;
        }

        //check if all colour field has a queen and only 1 queen
        for(int i=0;i<arr.size();i++){
            if(set.contains(arr.get(i))){
                return false;
            }
            else{
                set.add(Character.valueOf(arr.get(i).character));
            }
        }
        if(arr.size()!=this.unique.size()) return false;
        for(int i=0;i<arr.size();i++){
            if(!this.unique.contains(arr.get(i).character)){
                return false;
            }
        }

        return true;
    }

    public int full_of_queens(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if(this.data[i][j]!='#'){
                    return 0;
                }
            }
        }
        return 1;
    }

    public boolean queens_allright(){
        for(int i=0;i<this.row;i++){
            if(this.data[i][this.col-1]!='#') return false;
        }
        return true;
    }

    public void reset_row(int x, matrix original, ArrayList<cell> arr, int index){
        for(int i=0;i<this.col;i++){
            if (i==0){
                this.data[x][i] = '#';
            }
            else{
                this.data[x][i] = original.data[x][i];
            }
        }
        arr.get(index).c = 0;
        arr.get(index).character = original.data[x][0];
    }

    public void move(int x, matrix original, ArrayList<cell> arr){
        int i;
        for(i=0;i<arr.size();i++){
            if(arr.get(i).r == x) break;
        }
        this.data[x][arr.get(i).c] = original.data[x][arr.get(i).c];
        if(arr.get(i).c==this.col-1){
            move(x+1, original, arr);
            reset_row(x, original, arr, i);
        }
        else{
            this.data[x][arr.get(i).c+1] = '#';
            arr.get(i).c +=1;
        }
    }

    public void test(ArrayList<cell> arr){
        int i=0,j=0,x=1;
        boolean solution_exists=false;
        matrix temp = new matrix(this.row, this.col);
        temp.copy(this);
        
        //init temp matrix with queens in each row
        for(int k=0;k<this.row;k++){
            cell tempcell = new cell(k,0, temp.data[k][0]);
            arr.add(tempcell);
            temp.data[k][0]='#';
        }

        while(!temp.queens_allright()){
            if(temp.check(arr)){
                solution_exists=true;
                break;
            }
            temp.move(0, this, arr);
            
            // System.out.println(x);
            // System.out.println(arr);
            // temp.print_matrix();
            // System.out.println("---------------");
            x++;
            // System.out.println("-------------");
            if(x%1000 ==0){
                temp.print_matrix();
                System.out.println("-------------");
            }
        }

        System.out.println(x + " configurations tested");
        if(solution_exists){
            System.out.println("Solution: ");
            temp.print_matrix();
        }
        else{
            System.out.println("No solution found!");
        }
    }

    public void bit_iteration(ArrayList<cell> arr){
        int i,j,x=1;
        boolean solution_exists=false;
        matrix temp = new matrix(this.row, this.col);
        temp.copy(this);
        while(temp.full_of_queens()==0){
            i=0;j=0;
            if(temp.data[i][j]!='#'){
                cell tempcell = new cell(i,j,this.data[i][j]);
                arr.add(tempcell);
                temp.data[i][j] = '#';
            }
            else{
                while(temp.data[i][j]=='#'){
                    temp.data[i][j]=this.data[i][j];
                    cell tempcell = new cell(i,j,this.data[i][j]);
                    arr.remove(tempcell);
                    j++;
                    if(j==col){
                        j=0;i++;
                    }
                }
                cell tempcell = new cell(i,j,this.data[i][j]);
                arr.add(tempcell);
                temp.data[i][j]='#';
            }
            // System.out.println(x);
            // temp.print_matrix();
            // System.out.println(arr);
            // System.out.println("-------------");
            x++;
            if(temp.check(arr)){
                solution_exists=true;
                break;
            }
            if(x%10000000 ==0){
                temp.print_matrix();
                System.out.println("-------------");
            }
        }
        System.out.println(x + " configurations tested");
        if(solution_exists){
            System.out.println("Solution: ");
            temp.print_matrix();
        }
        else{
            System.out.println("No solution found!");
        }
    }

    
}
