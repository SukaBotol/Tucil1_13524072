package stima;

import java.io.File;
import java.util.Scanner;

public class the_io {

    public static matrix read_file(String source) throws Exception{
        File file = new File(source);
        Scanner sc = new Scanner(file);
        int i=0;
        int j=0;
        String line;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            if (j==0){
                j=line.length();
            }
            i++;
        }
        matrix mat = new matrix(i, j);
        sc.close();
        Scanner scr = new Scanner(file);
        int l=0;
        while(scr.hasNextLine()){
            line = scr.nextLine();
            for(int k=0;k<j;k++){
                mat.data[l][k]=line.charAt(k);
            }
            l++;
        }
        scr.close();
        return mat;
    }

    public static matrix parse_from_string(String input){
        int col=0, row=0;
        if (input.length()==0){
            throw new IllegalArgumentException("There is no Input");
        }
        String rows[] = input.split("\\n");
        col = rows[0].length();
        row = rows.length;
        for(int i=1;i<rows.length;i++){
            if(rows[i].length()!=col){
                throw new IllegalArgumentException("matrix size not NxN");
            }
        }
        if(col!=row){
            throw new IllegalArgumentException("matrix size not NxN");
        }

        matrix temp = new matrix(row, col);

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                temp.data[i][j]=rows[i].charAt(j);
            }
        }
        
        temp.find_uniques();
        if(temp.unique.size()!=row){
            throw new IllegalArgumentException("region count != N");
        }

        return temp;
    }
}
