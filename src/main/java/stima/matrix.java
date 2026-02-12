package stima;

public class matrix {
    private int row;
    private int col;
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
}
