package BanqueJava;

import java.util.Scanner;

/**
 * Gère l'affichage du menu et la lecture des choix utilisateur
 */
public class Menu {
    private Scanner scanner;

    /**
     * Constructeur
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Affiche le menu principal
     */
    public void afficherMenu() {
        System.out.println("\n=== SYSTÈME DE GESTION BANCAIRE ===");
        System.out.println("1. Créer un compte");
        System.out.println("2. Déposer de l'argent");
        System.out.println("3. Retirer de l'argent");
        System.out.println("4. Consulter un compte");
        System.out.println("5. Afficher tous les comptes");
        System.out.println("6. Afficher prochain numéro disponible");
        System.out.println("7. Transférer de l'argent");
        System.out.println("8. Modifier un compte");
        System.out.println("9. Supprimer un compte");
        System.out.println("10. Afficher les statistiques");
        System.out.println("11. Modifier le mot de passe");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Lit le choix de l'utilisateur
     */
    public int lireChoix() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lit une chaîne de caractères
     */
    public String lireString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    /**
     * Lit un mot de passe (masqué dans la console)
     */
    public String lireMotDePasse(String message) {
        System.out.print(message);
        // Note: En Java console, on ne peut pas masquer l'entrée facilement
        // Dans une vraie application, on utiliserait Console.readPassword()
        return scanner.nextLine();
    }

    /**
     * Lit un nombre entier
     */
    public int lireInt(String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Lit un nombre décimal
     */
    public double lireDouble(String message) {
        System.out.print(message);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Confirme une action avec l'utilisateur
     */
    public boolean confirmerAction(String message) {
        System.out.print(message + " (O/N) : ");
        String reponse = scanner.nextLine().toUpperCase();
        return reponse.equals("O") || reponse.equals("OUI");
    }

    /**
     * Demande le mot de passe pour vérification
     */
    public String demanderMotDePasse() {
        return lireMotDePasse("Mot de passe : ");
    }
}