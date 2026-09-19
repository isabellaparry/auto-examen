package cl.iplacex;

public class App {

    public static void main(String[] args) {

        if (args.length > 0) {

            if (args[0].equals("health")) {
                System.out.println("OK");
                return;
            }
        }

        System.out.println(
                "Aplicacion ejecutada correctamente"
        );
    }
}