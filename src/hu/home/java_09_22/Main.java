package hu.home.java_09_22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Festmeny> lista = new ArrayList<Festmeny>();
    public static void main(String[] args) {

        listaFeltoltes();
        fileBeolvas();

        /*f1.licit(30);
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit(30);
        System.out.println(f1.getLegmagasabbLicit());

        System.out.println(f1);*/


    }

    private static void fileBeolvas() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("./src/hu/home/java_09_22/festmenyek.csv"));
        } catch (FileNotFoundException e){
            System.out.println("Hibás filenév!");
        }
        sc.useDelimiter(";");
        int counter = 0;
        while (sc.hasNextLine()){
            System.out.println(counter++);
            String festo = sc.next();
            String cim = sc.next();
            String stilus = sc.next();
            Festmeny temp = new Festmeny(cim, festo, stilus);
            lista.add(temp);
        }
        sc.close();

    }

    public static void listaFeltoltes(){
        Festmeny f1 = new Festmeny("róka", "én", "absztrakt");
        Festmeny f2 = new Festmeny("gomba trip", "én", "kubista");

        lista.add(f1);
        lista.add(f2);

        Scanner sc = new Scanner(System.in);

        System.out.print("Adjon meg egy darabszámot: ");
        int darabSzam = sc.nextInt();
        String bekertCim;
        String bekertFesto;
        String bekertStilus;
        sc.nextLine();

        if (darabSzam <= 1){
            for (int i = 0; i < darabSzam; i++){
                System.out.println("Adja meg a festmény címét: ");
                bekertCim = sc.nextLine();
                System.out.println("Adja meg a festőt: ");
                bekertFesto = sc.nextLine();
                System.out.println("Adja meg a stílust: ");
                bekertStilus = sc.nextLine();
                lista.add(new Festmeny(bekertCim, bekertFesto, bekertStilus));
            }
        }

    }
}
