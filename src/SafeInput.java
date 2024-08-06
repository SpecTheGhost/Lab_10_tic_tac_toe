import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.println("\n" + prompt + " [Y or N] ");
            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must answer [Y or N]: " + response);
            }
        } while (!gotAVal);

        return retVal;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern) {
        String response = "";
        boolean gotAVal = false;

        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regExPattern)) {
                gotAVal = true;
            } else {
                System.out.println("\n" + response + "must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        } while (!gotAVal);

        return response;
    }

    public static void prettyHeader(String msg) {
        int starCount = 60;

        for (int c = 0; c < starCount; c++)
        {
            System.out.print("*");
        }
        System.out.println();
        int starsOnTheLeft = (60 - msg.length()) / 2;
        int spaces = starsOnTheLeft - 3;
        System.out.print("***");

        for (int c = 0; c < spaces; c++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        if (msg.length() % 2 == 0 )    // test to see if it is even so if this is true then it's even
        {
            for (int c = 0; c < spaces; c++)
            {
                System.out.print(" ");
            }
        }
        else
        {
            for (int c = 0; c <= spaces; c++)
            {
                System.out.print(" ");
            }
        }

        System.out.println("***");

        for (int c = 0; c < starCount; c++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}