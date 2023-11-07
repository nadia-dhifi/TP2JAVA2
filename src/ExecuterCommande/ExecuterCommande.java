package ExecuterCommande;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExecuterCommande {
    void executerCommande( String commande)
    {
        try {
            Process p= Runtime.getRuntime().exec(commande);
            if(!p.waitFor(5,TimeUnit.SECONDS))
            {
                System.out.println(p.waitFor(5,TimeUnit.SECONDS));
                p.destroy();
            }
            System.out.println(p.exitValue());





        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

    }
    }

    public static void main(String[] args) {

        ExecuterCommande commande =new ExecuterCommande();
        commande.executerCommande("Notepad.exe");
    }}