package ajedrez_jroriguez;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ajedrez_jrodriguez {

    public static int x;
    public static int y;
    public static int x2;
    public static int y2;
    public static Scanner read = new Scanner(System.in);
    public static int cont = 2;
    public static boolean bandera = true;

    public static void main(String[] args) {
        Pieza[][] tablero = new Pieza[8][8];
        boolean blanco = true;
//llenando piezas negras
    String nombre1=JOptionPane.showInputDialog("Ingrese su nombre jugador1");
    String nombre2=JOptionPane.showInputDialog("Ingrese su nombre jugador1");
    
        tablero[0][0] = new Torre(0, 0, 'T', false);
        tablero[0][1] = new Caballo(0, 1, 'C', false);
        tablero[0][2] = new Alfil(0, 2, 'A', false);
        tablero[0][3] = new Rey(0, 3, 'R', false);
        tablero[0][4] = new Reina(0, 4, 'Q', false);
        tablero[0][5] = new Alfil(0, 5, 'A', false);
        tablero[0][6] = new Caballo(0, 6, 'C', false);
        tablero[0][7] = new Torre(0, 7, 'T', false);
        //llenando peones negros
        for (int i = 0; i < tablero[1].length; i++) {
            tablero[1][i] = new Peon(1, i, 'P', false);
        }
        //llenando espacios
        for (int i = 2; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = new Pieza(i, j, ' ', false);
            }
        }

        //llenando peones blancos
        for (int i = 0; i < tablero[6].length; i++) {
            tablero[6][i] = new Peon(1, i, 'P', true);
        }
        //llenando piezas blancas
        tablero[7][0] = new Torre(7, 0, 'T', true);
        tablero[7][1] = new Caballo(7, 1, 'C', true);
        tablero[7][2] = new Alfil(7, 2, 'A', true);
        tablero[7][3] = new Rey(7, 3, 'R', true);
        tablero[7][4] = new Reina(7, 4, 'Q', true);
        tablero[7][5] = new Alfil(7, 5, 'A', true);
        tablero[7][6] = new Caballo(7, 6, 'C', true);
        tablero[7][7] = new Torre(7, 7, 'T', true);
        Imprimir(tablero, 0, 0);
        int turno = 1;
        System.out.println("");
        System.out.println("");
        System.out.println("");
        while (bandera) {
            while (turno == 1) {
                for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (tablero[i][j].getLetra() == 'R') {
                                cont++;
                            }
                        }
                    }
                    if (cont <2) {
                                bandera= false;
                                turno=0;
                                System.out.println("JAQUE MATE");
                            }
                        cont=0;
                x = Integer.parseInt(JOptionPane.showInputDialog(null, nombre1+" ingrese x de la posicion de la pieza"));
                y = Integer.parseInt(JOptionPane.showInputDialog(null, nombre1+" ingrese y de la posicion de la pieza"));

                x2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese x de la posicion a mover"));
                y2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese y de la posicion a mover"));
                if (tablero[x][y].getLetra() == 'T') {
                    if (((Torre) tablero[x][y]).movimiento(x, y, x2, y2) &&  (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y]=new Torre(x, y,' ', false);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                        turno=2;
                    }

                } else if (tablero[x][y].getLetra() == 'A') {
                    if (((Alfil) tablero[x][y]).movimiento(x, y, x2, y2) && (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {//&&tablero[x+1][y+1].getLetra()==' '){

                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Alfil(x, y, ' ', false);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                        turno=2;
                    }
                } else if (tablero[x][y].getLetra() == 'C') {
                    if (((Caballo) tablero[x][y]).movimiento(x, y, x2, y2) && (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Caballo(x, y, ' ', false);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                        turno=2;
                    }
                } else if (tablero[x][y].getLetra() == 'P') {
                    if ((tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Peon(x, y, ' ', false);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    } else if (((Peon) tablero[x][y]).movimiento(x, y, x2, y2) && (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Peon(x, y, ' ', false);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                        turno=2;
                    }

                } else if (tablero[x][y].getLetra() == 'Q') {
                    if (((Reina) tablero[x][y]).movimiento(x, y, x2, y2) && (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Reina(x, y, ' ', true);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    }

                }else if (tablero[x][y].getLetra() == 'R') {
                    if (((Rey) tablero[x][y]).movimiento(x, y, x2, y2) && (tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Rey(x, y, ' ', true);
                        Imprimir(tablero, 0, 0);
                        turno = 2;
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                    }

                }
                System.out.println("");
                System.out.println("");
                System.out.println("");
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero[i].length; j++) {
                        if (tablero[i][j].getLetra() == ' ') {
                            tablero[i][j] = new Pieza(i, j, ' ', true);
                        }

                    }
                }
                while (turno == 2) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (tablero[i][j].getLetra() == 'R') {
                                cont++;
                            }
                        }
                    }
                    if (cont <2) {
                                bandera= false;
                                turno=20;
                                System.out.println("JAQUE MATE");
                            }
                        
                    x = Integer.parseInt(JOptionPane.showInputDialog(null, nombre2+" ingrese x de la posicion de la pieza"));
                    y = Integer.parseInt(JOptionPane.showInputDialog(null, nombre2+" ingrese y de la posicion de la pieza"));

                    x2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese x de la posicion a mover"));
                    y2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese y de la posicion a mover"));
                    if (tablero[x][y].getLetra() == 'T') {
                        if (((Torre) tablero[x][y]).movimiento(x, y, x2, y2)  && (!tablero[x][y].isWhite()) && (!tablero[x2][y2].isWhite())) {
                            tablero[x2][y2] = tablero[x][y];
                            tablero[x][y]=new Torre(x, y,' ', false);
                            Imprimir(tablero, 0, 0);
                            turno = 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                        }

                    } else if (tablero[x][y].getLetra() == 'A') {
                        if (((Alfil) tablero[x][y]).movimiento(x, y, x2, y2) && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {//&&tablero[x+1][y+1].getLetra()==' '){

                            tablero[x2][y2] = tablero[x][y];
                            tablero[x][y] = new Alfil(x, y, ' ', false);
                            Imprimir(tablero, 0, 0);
                            turno = 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                        }
                    } else if (tablero[x][y].getLetra() == 'C') {
                        if (((Caballo) tablero[x][y]).movimiento(x, y, x2, y2) && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {
                            tablero[x2][y2] = tablero[x][y];
                            tablero[x][y] = new Caballo(x, y, ' ', false);
                            Imprimir(tablero, 0, 0);
                            turno = 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                        }
                    } else if (tablero[x][y].getLetra() == 'P') {
                        if (tablero[x + 1][y + 1].getLetra() != ' ' && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {
                            tablero[x2][y2] = tablero[x][y];
                            tablero[x][y] = new Peon(x, y, ' ', false);
                            Imprimir(tablero, 0, 0);
                            turno = 1;
                        } else if (((Peon) tablero[x][y]).movimiento(x, y, x2, y2) && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {
                            tablero[x2][y2] = tablero[x][y];
                            tablero[x][y] = new Peon(x, y, ' ', false);
                            Imprimir(tablero, 0, 0);
                            turno = 1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                        }

                    }else if (tablero[x][y].getLetra() == 'Q') {
                    if (((Reina) tablero[x][y]).movimiento(x, y, x2, y2) && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Reina(x, y, ' ', true);
                        Imprimir(tablero, 0, 0);
                        turno = 1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                    }

                }else if (tablero[x][y].getLetra() == 'R') {
                    if (((Rey) tablero[x][y]).movimiento(x, y, x2, y2) && (!tablero[x][y].isWhite()) && (tablero[x2][y2].isWhite())) {
                        tablero[x2][y2] = tablero[x][y];
                        tablero[x][y] = new Rey(x, y, ' ', true);
                        Imprimir(tablero, 0, 0);
                        turno = 1;
                    }else{
                        JOptionPane.showMessageDialog(null, "Movimiento invalido");
                            turno=1;
                    }

                }

                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    for (int i = 0; i < tablero.length; i++) {
                        for (int j = 0; j < tablero[i].length; j++) {
                            if (tablero[i][j].getLetra() == ' ') {
                                tablero[i][j] = new Pieza(i, j, ' ', false);
                            }
                            
                        }
                        
                    }
                   
                }
                if (cont <2) {
                                bandera= false;
                                turno=20;
                                
                            }
                        cont=0;

            }
        }
    }

    public static void Imprimir(Pieza[][] matriz, int filas, int cols) {
        if (filas == matriz.length - 1 && cols == matriz[0].length - 1) {
            System.out.print("[" + matriz[filas][cols].getLetra() + "]" + "    \n");
        } else {
            if (cols == matriz[0].length - 1) {
                System.out.println("[" + matriz[filas][cols].getLetra() + "]");
                Imprimir(matriz, filas + 1, 0);
            } else {
                System.out.print("[" + matriz[filas][cols].getLetra() + "]" + "   ");
                Imprimir(matriz, filas, cols + 1);
            }
        }
    }

}
