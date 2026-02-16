package stima;

import java.util.ArrayList;

public class App{
    public static void main(String[] args) throws Exception{
        matrix mat= the_io.read_file("test/test.txt");
        ArrayList<Character> seen = new ArrayList<Character>();
        mat.print_matrix();
        mat.find_uniques();
        // matrix test=new matrix(mat.row,mat.col);
        // test.copy(mat);
        // test.print_matrix();
        System.out.println();
        long start = System.currentTimeMillis();
        mat.test(seen);
        long end = System.currentTimeMillis();
        System.out.println("time taken: " +(end-start) + "ms");
    }

    
}