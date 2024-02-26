import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Facade facade;

    // COURSE LIST MUST BE INITIALIZED BEFORE WE LOAD ANY STUDENTS WHAT SO EVER

    public void main(String[] args) {
        displayLoginMenu();
    }

    public void displayLoginMenu() {
        System.out.println("Hello DaVinci Academia Students!");
        System.out.println();
    }
}
