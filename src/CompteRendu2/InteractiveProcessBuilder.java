package CompteRendu2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InteractiveProcessBuilder {

    public static void main(String[] args) {
        // Créez une liste de chaînes pour stocker la commande système
        List<String> commands = new ArrayList<>();

        // Demandez à l'utilisateur d'entrer un paramètre
        System.out.println("Entrez un paramètre (par exemple, google.com) : ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String parameter = reader.readLine();
            // Ajoutez la commande système avec le paramètre à la liste
            commands.add("ping");
            commands.add(parameter);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Créez un bloc try-catch pour gérer les exceptions IOException et InterruptedException
        try {
            // Créez un objet ProcessBuilder en utilisant la liste de commandes
            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            
            // Démarrez le processus en utilisant la méthode start () de l'objet ProcessBuilder
            Process process = processBuilder.start();
            
            // Créez un objet BufferedReader pour lire la sortie standard du processus
            BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Lisez la sortie standard du processus ligne par ligne et affichez-la à l'utilisateur en temps réel
            String line;
            while ((line = processOutputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Attendez que le processus se termine en utilisant la méthode wait For () et affichez le code de sortie
            int exitCode = process.waitFor();
            System.out.println("Le processus s'est terminé avec le code de sortie : " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
