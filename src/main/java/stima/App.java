package stima;

public class App{
    public static void main(String[] args) throws Exception{
        matrix mat= the_io.read_file("test/test.txt");
        mat.print_matrix();
        mat.find_uniques();
    }
}