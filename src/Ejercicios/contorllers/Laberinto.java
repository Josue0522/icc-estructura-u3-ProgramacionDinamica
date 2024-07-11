package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.List;

import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior derecha con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 *
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    public List<Celda> getPath(boolean[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        Boolean [][] cache = new Boolean[m][n];
        List <Celda> path = new ArrayList<>();
        if (findPath(grid,0,0,path,cache)) {
            return path;
        }
        return null;
    }

    private boolean findPath(boolean[][] grid, int x, int y, List<Celda> path, Boolean[][] cache){
        if (x>= grid.length || y>=grid[0].length || !grid[x][y]) {
            return false;
        }

        boolean end = (x==grid.length -1 ) && (y== grid[0].length -1 );
        if (end || findPath(grid, x+1, y, path, cache)) {
            path.add(new Celda(x, y));
            cache[x][y] = true;
            return false;
        }
        cache[x][y]= false;
        return false;
    }
}