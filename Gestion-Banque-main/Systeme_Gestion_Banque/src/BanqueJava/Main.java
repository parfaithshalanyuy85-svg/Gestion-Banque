package BanqueJava;

/**
 * Point d'entrée du programme
 */
public class Main {
    public static void main(String[] args) {
        Banque banque = new Banque();
        Menu menu = new Menu();
        int choix;

        System.out.println("=== BIENVENUE DANS LE SYSTÈME BANCAIRE ===");
        System.out.println("Les numéros de compte sont générés automatiquement");
        System.out.println("Chaque compte est protégé par un mot de passe");

        do {
            menu.afficherMenu();
            choix = menu.lireChoix();

            switch (choix) {
                case 1:
                    creerCompte(banque, menu);
                    break;

                case 2:
                    effectuerOperation(banque, menu, "depot");
                    break;

                case 3:
                    effectuerOperation(banque, menu, "retrait");
                    break;

                case 4:
                    consulterCompte(banque, menu);
                    break;

                case 5:
                    banque.afficherTousLesComptes();
                    break;

                case 6:
                    banque.afficherProchainNumero();
                    break;

                case 7:
                    transfererArgent(banque, menu);
                    break;

                case 8:
                    modifierCompte(banque, menu);
                    break;

                case 9:
                    supprimerCompte(banque, menu);
                    break;

                case 10:
                    banque.afficherStatistiques();
                    break;

                case 11:
                    modifierMotDePasse(banque, menu);
                    break;

                case 0:
                    System.out.println("Merci d'avoir utilisé notre système. Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez saisir un nombre entre 0 et 11.");
            }

        } while (choix != 0);
    }

    /**
     * Crée un nouveau compte avec mot de passe
     */
    private static void creerCompte(Banque banque, Menu menu) {
        System.out.println("\n--- Création d'un nouveau compte ---");

        String nom = menu.lireString("Nom du titulaire : ");
        if (nom.trim().isEmpty()) {
            System.out.println("Erreur : Le nom ne peut pas être vide.");
            return;
        }

        double soldeInitial = menu.lireDouble("Solde initial : ");
        if (soldeInitial < 0) {
            System.out.println("Erreur : Le solde initial ne peut pas être négatif.");
            return;
        }

        String motDePasse = menu.lireMotDePasse("Choisissez un mot de passe (min 4 caractères) : ");
        if (motDePasse.length() < 4) {
            System.out.println("Erreur : Le mot de passe doit contenir au moins 4 caractères.");
            return;
        }

        String confirmation = menu.lireMotDePasse("Confirmez le mot de passe : ");
        if (!motDePasse.equals(confirmation)) {
            System.out.println("Erreur : Les mots de passe ne correspondent pas.");
            return;
        }

        int numeroGenere = banque.ajouterCompte(nom, soldeInitial, motDePasse);
        System.out.println("Numéro de compte attribué : " + numeroGenere);
        System.out.println("IMPORTANT : Notez bien votre numéro de compte et votre mot de passe !");
    }

    /**
     * Effectue un dépôt ou un retrait avec vérification du mot de passe
     */
    private static void effectuerOperation(Banque banque, Menu menu, String typeOperation) {
        String operation = typeOperation.equals("depot") ? "dépôt" : "retrait";

        System.out.println("\n--- " + operation.toUpperCase() + " D'ARGENT ---");

        int numero = menu.lireInt("Numéro du compte : ");

        // Vérification du mot de passe
        System.out.println("Vérification d'accès...");
        String motDePasse = menu.demanderMotDePasse();
        if (!banque.verifierMotDePasse(numero, motDePasse)) {
            System.out.println("Erreur : Mot de passe incorrect. Opération annulée.");
            return;
        }

        Compte compte = banque.chercherCompte(numero);
        if (compte == null) {
            System.out.println("Erreur : Compte non trouvé.");
            return;
        }

        System.out.println("Accès autorisé. Titulaire : " + compte.getNomTitulaire());

        double montant = menu.lireDouble("Montant à " + operation + " : ");

        if (montant <= 0) {
            System.out.println("Erreur : Le montant doit être positif.");
            return;
        }

        if (typeOperation.equals("depot")) {
            compte.deposer(montant);
        } else {
            compte.retirer(montant);
        }
    }

    /**
     * Consulte un compte avec vérification du mot de passe
     */
    private static void consulterCompte(Banque banque, Menu menu) {
        System.out.println("\n--- CONSULTATION DE COMPTE ---");

        int numero = menu.lireInt("Numéro du compte : ");

        // Vérification du mot de passe
        String motDePasse = menu.demanderMotDePasse();
        if (!banque.verifierMotDePasse(numero, motDePasse)) {
            System.out.println("Erreur : Mot de passe incorrect. Consultation refusée.");
            return;
        }

        Compte compte = banque.chercherCompte(numero);
        if (compte == null) {
            System.out.println("Erreur : Compte non trouvé.");
        } else {
            System.out.println("\n=== INFORMATIONS DU COMPTE ===");
            compte.afficherCompte();
        }
    }

    /**
     * Transfère de l'argent d'un compte à un autre
     */
    private static void transfererArgent(Banque banque, Menu menu) {
        System.out.println("\n=== TRANSFERT D'ARGENT ===");

        banque.afficherResumeComptes();

        int numeroSource = menu.lireInt("\nNuméro du compte source : ");

        // Vérification du mot de passe source
        System.out.println("\n--- Vérification du compte source ---");
        String motDePasseSource = menu.demanderMotDePasse();

        int numeroDest = menu.lireInt("Numéro du compte destinataire : ");

        if (numeroSource == numeroDest) {
            System.out.println("Erreur : Vous ne pouvez pas transférer vers le même compte.");
            return;
        }

        double montant = menu.lireDouble("Montant à transférer : ");

        if (montant <= 0) {
            System.out.println("Erreur : Le montant doit être positif.");
            return;
        }

        Compte source = banque.chercherCompte(numeroSource);
        Compte dest = banque.chercherCompte(numeroDest);

        if (source != null && dest != null) {
            System.out.println("\nRécapitulatif du transfert :");
            System.out.println("De : Compte " + numeroSource + " (" + source.getNomTitulaire() + ")");
            System.out.println("Vers : Compte " + numeroDest + " (" + dest.getNomTitulaire() + ")");
            System.out.println("Montant : " + montant + " €");

            if (menu.confirmerAction("Confirmez-vous ce transfert ?")) {
                boolean succes = banque.effectuerTransfert(numeroSource, motDePasseSource, numeroDest, montant);
                if (succes) {
                    System.out.println("\nTransfert effectué avec succès !");
                }
            } else {
                System.out.println("Transfert annulé.");
            }
        }
    }

    /**
     * Modifie le nom du titulaire d'un compte
     */
    private static void modifierCompte(Banque banque, Menu menu) {
        System.out.println("\n=== MODIFICATION DE COMPTE ===");

        int numero = menu.lireInt("Numéro du compte à modifier : ");

        // Vérification du mot de passe
        String motDePasse = menu.demanderMotDePasse();

        String nouveauNom = menu.lireString("Nouveau nom du titulaire : ");
        if (nouveauNom.trim().isEmpty()) {
            System.out.println("Erreur : Le nouveau nom ne peut pas être vide.");
            return;
        }

        if (menu.confirmerAction("Confirmez-vous la modification du nom ?")) {
            boolean succes = banque.modifierCompte(numero, motDePasse, nouveauNom);
            if (succes) {
                System.out.println("Modification effectuée avec succès.");
            }
        } else {
            System.out.println("Modification annulée.");
        }
    }

    /**
     * Modifie le mot de passe d'un compte
     */
    private static void modifierMotDePasse(Banque banque, Menu menu) {
        System.out.println("\n=== MODIFICATION DE MOT DE PASSE ===");

        int numero = menu.lireInt("Numéro du compte : ");

        // Vérification avec l'ancien mot de passe
        String ancienMotDePasse = menu.demanderMotDePasse();

        String nouveauMotDePasse = menu.lireMotDePasse("Nouveau mot de passe (min 4 caractères) : ");
        if (nouveauMotDePasse.length() < 4) {
            System.out.println("Erreur : Le mot de passe doit contenir au moins 4 caractères.");
            return;
        }

        String confirmation = menu.lireMotDePasse("Confirmez le nouveau mot de passe : ");
        if (!nouveauMotDePasse.equals(confirmation)) {
            System.out.println("Erreur : Les mots de passe ne correspondent pas.");
            return;
        }

        if (menu.confirmerAction("Confirmez-vous la modification du mot de passe ?")) {
            boolean succes = banque.modifierMotDePasse(numero, ancienMotDePasse, nouveauMotDePasse);
            if (succes) {
                System.out.println("Mot de passe modifié avec succès.");
            }
        } else {
            System.out.println("Modification annulée.");
        }
    }

    /**
     * Supprime un compte
     */
    private static void supprimerCompte(Banque banque, Menu menu) {
        System.out.println("\n=== SUPPRESSION DE COMPTE ===");
        System.out.println("ATTENTION : Cette action est irréversible !");
        System.out.println("Conditions :");
        System.out.println("1. Le solde doit être à 0");
        System.out.println("2. Vous devez connaître le mot de passe");

        int numero = menu.lireInt("Numéro du compte à supprimer : ");

        Compte compte = banque.chercherCompte(numero);
        if (compte == null) {
            System.out.println("Erreur : Compte non trouvé.");
            return;
        }

        // Afficher les informations du compte
        System.out.println("\nInformations du compte :");
        compte.afficherResume();

        // Vérification du mot de passe
        String motDePasse = menu.demanderMotDePasse();

        // Double confirmation
        if (menu.confirmerAction("Êtes-vous sûr de vouloir supprimer ce compte ?")) {
            if (menu.confirmerAction("Cette action est irréversible. Confirmez à nouveau ?")) {
                boolean succes = banque.supprimerCompte(numero, motDePasse);
                if (succes) {
                    System.out.println("Le compte a été supprimé avec succès.");
                }
            } else {
                System.out.println("Suppression annulée.");
            }
        } else {
            System.out.println("Suppression annulée.");
        }
    }
}