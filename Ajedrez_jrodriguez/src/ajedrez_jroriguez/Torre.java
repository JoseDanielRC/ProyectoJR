package ajedrez_jroriguez;

public class Torre extends Pieza {

    public Torre(int x, int y, char letra, boolean white) {
        super(x, y, letra, white);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    @Override
    public boolean movimiento(int x, int y, int x2, int y2) {
        if (x == x2 || y == y2) {
            return true;
        } else {
            return false;
        }

    }

}
