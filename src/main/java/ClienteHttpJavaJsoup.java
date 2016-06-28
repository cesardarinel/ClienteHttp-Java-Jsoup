/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author acap1831
 */
public class ClienteHttpJavaJsoup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Hola Mundo");
        Scanner input = new Scanner(System.in);
        String URL;
        utiliti valida = new utiliti();
        do {
            System.out.print("Digitar URL...: ");
            URL = input.nextLine();
        } while (!valida.isValidURL(URL));
    }

}
