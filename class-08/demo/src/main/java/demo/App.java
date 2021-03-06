/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        for(String s : args) {
            System.out.println(s);
        }
        readSecret();
    }

    public static void unicornDemo() {
        Unicorn ransUnicorn = new Unicorn("green", false);
        // JSON.stringify(ransUnicorn);
        Gson gson = new Gson();
        System.out.println(ransUnicorn);
        System.out.println(gson.toJson(ransUnicorn));
        ransUnicorn.neigh();
        String unicornString = gson.toJson(ransUnicorn);
        Unicorn u = gson.fromJson(unicornString, Unicorn.class);
        u.neigh();
        Unicorn[] allTheUnicorns = new Unicorn[]{
                ransUnicorn,
//                new Unicorn("purple", true),
//                new Unicorn("rainbow", true)
        };
        String unicornsString = gson.toJson(allTheUnicorns);
        System.out.println(unicornsString);

        Unicorn[] unicornsConverted = gson.fromJson(unicornsString, Unicorn[].class);
        System.out.println(Arrays.toString(unicornsConverted));


        // classes are not safe anymore once JSON is involved!
        SillyPutty putty = gson.fromJson(unicornString, SillyPutty.class);
        System.out.println(putty);
    }

    public static void readSecret() {
        try {
            Scanner s = new Scanner(new File("src/main/resources/secret.txt"));
            System.out.println(s.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
