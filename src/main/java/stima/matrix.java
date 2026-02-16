package stima;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class matrix {
    public int row;
    public int col;
    public char[][] data;
    public String unique;

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
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                char c = this.data[i][j];
                if(temp.indexOf(String.valueOf(c))==-1){
                    temp.append(c);
                }
            }
        }
        this.unique = temp.toString();
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

    public boolean check(ArrayList<Character> arr){
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
                set.add(arr.get(i));
            }
        }
        if(arr.size()!=unique.length()){
            return false;
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

    public void test(ArrayList<Character> arr){
        int i,j,x=1;
        boolean solution_exists=false;
        matrix temp = new matrix(this.row, this.col);
        temp.copy(this);
        while(temp.full_of_queens()==0){
            i=0;j=0;
            if(temp.data[i][j]!='#'){
                arr.add(this.data[i][j]);
                temp.data[i][j] = '#';
            }
            else{
                while(temp.data[i][j]=='#'){
                    temp.data[i][j]=this.data[i][j];
                    arr.remove((Character.valueOf(this.data[i][j])));
                    j++;
                    if(j==col){
                        j=0;i++;
                    }
                }
                arr.add(this.data[i][j]);
                temp.data[i][j]='#';
            }
            // System.out.println(x);
            // temp.print_matrix();
            // System.out.println(arr);
            x++;
            // System.out.println("-------------");
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
