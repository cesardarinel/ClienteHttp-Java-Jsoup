/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ListIterator;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


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
       // System.out.print("Hola Mundo");
        Scanner input = new Scanner(System.in);
        String URL;
        utiliti valida = new utiliti();
        do {
            System.out.print("Digitar URL...: ");
            URL = input.nextLine();

        } while (!valida.isValidURL(URL));
        URL = valida.completaURL(URL);
        //ejemplo de la pagina
        Document documento = null;

        try {
            /**
             * ejemplo de prueba
            Document doc = Jsoup.connect("http://jsoup.org").get();

            Element link = doc.select("a").first();
            String relHref = link.attr("href"); // == "/"
            String absHref = link.attr("abs:href"); // "http://jsoup.org/"
            */
            documento = Jsoup.connect(URL).get();

            System.out.println("Cantidad de lineas : " + documento.html().split("\\r?\\n").length);
            System.out.println("Cantidad de parrafos(p): " + documento.select("p").size());
            System.out.println("Cantidad de imagenes(img): " + documento.select("img").size());
            System.out.println("Cantidad de formularios(form): " +documento.select("form").size());

            Elements form = documento.select("form");

           // ListIterator<Element> imput = form.select("input").listIterator();
            for (Element Entrada : form.select("input")) {
                System.out.println("\tInput de tipo: " + Entrada.attr("type"));
            }

        } catch (IOException e) {
            System.out.println("Tenemos un error al procesar \n");
            System.out.println("Puede que la URL no exista");
        }



    }

}
