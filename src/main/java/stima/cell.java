package stima;

public class cell {
    public int r;
    public int c;
    public char character;

    public cell(int a, int b, char c){
        this.r = a;
        this.c = b;
        this.character = c;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof cell)) return false;
        cell other = (cell) o;
        return this.r == other.r && this.c == other.c && this.character == other.character;
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(r, c, character);
    }
}
