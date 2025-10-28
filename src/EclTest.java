import java.util.Scanner;

public class EclTest {

    public static void main(String[] args) {
        // Si des arguments sont fournis -> on les traite un par un
        if (args.length > 0) {
            System.out.println("Traitement des arguments passés en ligne de commande :");
            for (int i = 0; i < args.length; i++) {
                String token = args[i];
                System.out.print("Argument #" + (i + 1) + " = \"" + token + "\" -> ");
                traiterToken(token);
            }
        } 
        // Sinon -> interaction clavier (demande une seule valeur)
        else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Aucun argument fourni. Entrez un nombre entier : ");
            if (sc.hasNextInt()) {
                int nombre = sc.nextInt();
                afficherResultat(nombre);
            } else {
                System.out.println("Erreur : vous devez entrer un nombre entier !");
            }
            sc.close();
        }
    }

    // Tente de convertir et traiter un token reçu (ex: "5", "bonjour", "12")
    private static void traiterToken(String token) {
        try {
            int nombre = Integer.parseInt(token);
            afficherResultat(nombre);
        } catch (NumberFormatException e) {
            System.out.println("valeur invalide (pas un entier)");
        }
    }

    // Affiche si le nombre est positif/négatif/nul et pair/impair
    private static void afficherResultat(int nombre) {
        if (nombre > 0) {
            System.out.print("valeur positive");
        } else if (nombre < 0) {
            System.out.print("valeur negative");
        } else {
            System.out.print("valeur nulle");
        }

        if (nombre != 0) {
            if (nombre % 2 == 0) {
                System.out.println(" et paire");
            } else {
                System.out.println(" et impair");
            }
        } else {
            System.out.println();
        }
    }
}
