package it.uniroma3.diadia;
import java.util.Scanner;
public class IOConsole implements IO {

    private Scanner scannerDiLinee;

    public IOConsole(Scanner scanner) {
        this.scannerDiLinee = scanner;
    }

    @Override
    public void mostraMessaggio(String msg) {
        System.out.println(msg);
    }

    @Override
    public String leggiRiga() {
        // NO cierro el Scanner aquí
        return this.scannerDiLinee.nextLine();
    }
}
