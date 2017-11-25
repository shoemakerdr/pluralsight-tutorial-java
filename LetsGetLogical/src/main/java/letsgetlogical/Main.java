package main.java.letsgetlogical;

public class Main {

    public static void main(String[] args) {
        int students = 150;
        int rooms = 0;

        // will cause error because logical & runs both statements regardless of whether the first one is true or not
        if (rooms > 0 & students / rooms > 30)
            System.out.println("Crowded!!");

        // works
        if (rooms > 0 && students / rooms > 30)
            System.out.println("Crowded!!");

        System.out.println();
        System.out.println("** end program **");
    }
}
