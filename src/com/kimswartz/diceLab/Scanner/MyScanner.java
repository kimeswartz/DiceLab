package com.kimswartz.diceLab.Scanner;

/*
This scanner is used for user input inside GamePlay class
 */

import java.util.Scanner;

public class MyScanner
{
    public static Scanner scan = new Scanner(System.in);

    public static String scan()
    {
        return scan.next();
    }

    public static String scanLine()
    {
        return scan.nextLine();
    }

    public static int scanInt()
    {
        return scan.nextInt();
    }
}
