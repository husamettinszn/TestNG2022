package com.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Split_StringToInteger {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Bir String giriniz");
        String fiyat = scan.nextLine();

        String[] parca = fiyat.split("");
        System.out.println(Arrays.toString(parca));

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < parca.length; i++) {
            list.add(parca[i]);
        }
        System.out.println(list);
        list.remove("$");
        System.out.println(list);

        String son = "";

        for (String w : list) {

            son = son + w;
        }

        System.out.println(son);

        int sayi = Integer.parseInt(son);

        System.out.println("Bir String giriniz");
        String fiyat2 = scan.nextLine();

        String[] parca2 = fiyat2.split("");
        System.out.println(Arrays.toString(parca2));

        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < parca2.length; i++) {
            list2.add(parca2[i]);
        }
        System.out.println(list2);
        list2.remove("$");
        System.out.println(list2);

        String son2 = "";

        for (String w : list2) {

            son2 = son2 + w;
        }

        System.out.println(son2);

        int sayi2 = Integer.parseInt(son2);

        int toplam = sayi + sayi2;

        System.out.println(toplam);

    }
}