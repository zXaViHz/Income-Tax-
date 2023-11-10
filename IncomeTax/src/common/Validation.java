/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author THAO LINH
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int getIntLimit(String mess, int n, int m) {
        int result;
        while (true) {
            System.out.println(mess + ": ");
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < n || result > m) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Please, enter a number between " + n + " and " + m);
            }
        }
    }

    public double getDouble(String mess) {
        double result;
        while (true) {
            try {
                System.out.println(mess + ": ");
                result = Double.parseDouble(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Input a number > 0");
            }
        }
    }

    public int getInt(String mess) {
        int result;
        while (true) {
            try {
                System.out.print(mess + ": ");
                result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Input a number > 0");
            }
        }
    }

    public String getString(String mess) {
        String result;
        while (true) {
            System.out.print(mess + ": ");
            result = sc.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            }
            System.out.print("Please, enter again(Can not blank)");
        }
    }

    public boolean checkYN(String mess) {
        String result;
        while (true) {
            System.out.print(mess + ": ");
            result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.print("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
}
