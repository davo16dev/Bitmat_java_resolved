/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmap_java;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author David Ameijeiras S
 */
public class Bitmap_java {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {

        Scanner Leer = new Scanner(System.in);

        int t = Leer.nextInt();

        Queue<int[]> queue = new LinkedList<int[]>();

        //direcciones
        int[] dirx = {0, 0, 1, -1};
        int[] diry = {1, -1, 0, 0};

        for (int i = 0; i < t; i++) {

            //revisar si existe algún bit activo
            boolean one = false;

            int n = Leer.nextInt();
            int m = Leer.nextInt();

            int map[][] = new int[n][m];

            for (int j = 0; j < n; j++) {

                String pal = Leer.next();
                String[] num = pal.split("");

                for (int k = 0; k < m; k++) {
                    map[j][k] = Integer.valueOf(num[k]);
                    if (map[j][k] == 1) {
                        one = true;
                        queue.add(new int[]{j, k});
                    }
                }

            }

            int[] point = null;

            while (!queue.isEmpty()) {

                point = queue.poll();

                int x = point[0];
                int y = point[1];

                for (int j = 0; j < 4; j++) {
                    int x2 = x + dirx[j];
                    int y2 = y + diry[j];

                    if (x2 < 0 || x2 >= n || y2 >= m || y2 < 0 || map[x2][y2] != 0) {
                        continue;
                    }

                    int d = ((Math.abs(x - x2)) + (Math.abs(y - y2)));
                    map[x2][y2] = map[x][y] + d;

                    queue.add(new int[]{x2, y2});

                }

            }

            //salida
            int eone = 1;

            if (!one) {
                eone = 0;
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {

                    System.out.print(map[j][k] - eone + " ");

                }

                System.out.println("");

            }

        }
    }

}
