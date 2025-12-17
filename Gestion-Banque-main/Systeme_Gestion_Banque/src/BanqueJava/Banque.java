package BanqueJava;

import java.util.ArrayList;

/**
 * Gère la collection de comptes bancaires
 */
public class Banque {
    private ArrayList<Compte> comptes;
    private int dernierNumeroCompte;

    /**
     * Constructeur
     */
    public Banque() {
        this.comptes = new ArrayList<>();
        this.dernierNumeroCompte = 1000;
    }

    /**
     * Génère un nouveau numéro de compte unique
     */
    private int genererNumeroCompte() {
        dernierNumeroCompte++;
        return dernierNumeroCompte;
    }

    /**
     * Ajouter un nouveau compte à la banque
     */
    public int ajouterCompte(String nomTitulaire, double soldeInitial, String motDePasse) {
        int nouveauNumero = genererNumeroCompte();
        Compte nouveauCompte = new Compte(nouveauNumero, nomTitulaire, soldeInitial, motDePasse);
        comptes.add(nouveauCompte);

        System.out.println("Compte créé avec succès !");
        nouveauCompte.afficherCompte();

        return nouveauNumero;
    }

    /**
     * Rechercher un compte par son numéro
     */
    public Compte chercherCompte(int numeroCompte) {
        for (Compte compte : comptes) {
            if (compte.getNumeroCompte() == numeroCompte) {
                return compte;
            }
        }
        return null;
    }

    /**
     * Supprimer un compte
     */
    public boolean supprimerCompte(int numeroCompte, String motDePasse) {
        for (int i = 0; i < comptes.size(); i++) {
            Compte compte = comptes.get(i);
            if (compte.getNumeroCompte() == numeroCompte) {
                // Vérifier le mot de passe
                if (compte.verifierMotDePasse(motDePasse)) {
                    // Vérifier que le solde est à 0
                    if (compte.getSolde() == 0) {
                        comptes.remove(i);
                        System.out.println("Compte " + numeroCompte + " supprimé avec succès.");
                        return true;
                    } else {
                        System.out.println("Erreur : Impossible de supprimer le compte. Le solde doit être à 0.");
                        System.out.println("Solde actuel : " + compte.getSolde() + " €");
                        return false;
                    }
                } else {
                    System.out.println("Erreur : Mot de passe incorrect.");
                    return false;
                }
            }
        }
        System.out.println("Erreur : Compte non trouvé.");
        return false;
    }

    /**
     * Modifier le nom du titulaire d'un compte
     */
    public boolean modifierCompte(int numeroCompte, String motDePasse, String nouveauNom) {
        Compte compte = chercherCompte(numeroCompte);
        if (compte != null) {
            if (compte.verifierMotDePasse(motDePasse)) {
                if (compte.modifierTitulaire(nouveauNom)) {
                    System.out.println("Nom du titulaire modifié avec succès.");
                    System.out.println("Nouveau nom : " + nouveauNom);
                    return true;
                } else {
                    System.out.println("Erreur : Le nouveau nom ne peut pas être vide.");
                    return false;
                }
            } else {
                System.out.println("Erreur : Mot de passe incorrect.");
                return false;
            }
        }
        System.out.println("Erreur : Compte non trouvé.");
        return false;
    }

    /**
     * Modifier le mot de passe d'un compte
     */
    public boolean modifierMotDePasse(int numeroCompte, String ancienMotDePasse, String nouveauMotDePasse) {
        Compte compte = chercherCompte(numeroCompte);
        if (compte != null) {
            if (compte.modifierMotDePasse(ancienMotDePasse, nouveauMotDePasse)) {
                System.out.println("Mot de passe modifié avec succès.");
                return true;
            } else {
                System.out.println("Erreur : Ancien mot de passe incorrect ou nouveau mot de passe trop court (min 4 caractères).");
                return false;
            }
        }
        System.out.println("Erreur : Compte non trouvé.");
        return false;
    }

    /**
     * Vérifier le mot de passe d'un compte
     */
    public boolean verifierMotDePasse(int numeroCompte, String motDePasse) {
        Compte compte = chercherCompte(numeroCompte);
        if (compte != null) {
            return compte.verifierMotDePasse(motDePasse);
        }
        return false;
    }

    /**
     * Effectuer un transfert entre deux comptes
     */
    public boolean effectuerTransfert(int numeroSource, String motDePasseSource, int numeroDestinataire, double montant) {
        Compte compteSource = chercherCompte(numeroSource);
        Compte compteDestinataire = chercherCompte(numeroDestinataire);

        if (compteSource == null) {
            System.out.println("Erreur : Compte source (" + numeroSource + ") non trouvé.");
            return false;
        }

        if (compteDestinataire == null) {
            System.out.println("Erreur : Compte destinataire (" + numeroDestinataire + ") non trouvé.");
            return false;
        }

        // Vérifier le mot de passe du compte source
        if (!compteSource.verifierMotDePasse(motDePasseSource)) {
            System.out.println("Erreur : Mot de passe incorrect pour le compte source.");
            return false;
        }

        System.out.println("\n=== TRANSFERT EN COURS ===");
        System.out.println("Compte source :");
        compteSource.afficherResume();
        System.out.println("Compte destinataire :");
        compteDestinataire.afficherResume();
        System.out.println("Montant : " + montant + " €");
        System.out.println("--------------------------");

        return compteSource.transferer(compteDestinataire, montant);
    }

    /**
     * Afficher tous les comptes de la banque
     */
    public void afficherTousLesComptes() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte n'a été créé.");
        } else {
            System.out.println("\n=== LISTE DE TOUS LES COMPTES ===");
            for (Compte compte : comptes) {
                compte.afficherCompte();
            }
        }
    }

    /**
     * Afficher un résumé de tous les comptes
     */
    public void afficherResumeComptes() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte n'a été créé.");
        } else {
            System.out.println("\n=== RÉSUMÉ DES COMPTES ===");
            for (Compte compte : comptes) {
                compte.afficherResume();
            }
        }
    }

    /**
     * Afficher le prochain numéro de compte disponible
     */
    public void afficherProchainNumero() {
        System.out.println("Prochain numéro de compte disponible : " + (dernierNumeroCompte + 1));
    }

    /**
     * Afficher les statistiques bancaires
     */
    public void afficherStatistiques() {
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte pour calculer les statistiques.");
            return;
        }

        System.out.println("\n=== STATISTIQUES BANCAIRES ===");

        // Calculs de base
        int nombreComptes = comptes.size();
        double totalSolde = 0;
        double soldeMax = Double.MIN_VALUE;
        double soldeMin = Double.MAX_VALUE;
        Compte comptePlusRiche = null;
        Compte comptePlusPauvre = null;

        for (Compte compte : comptes) {
            double solde = compte.getSolde();
            totalSolde += solde;

            if (solde > soldeMax) {
                soldeMax = solde;
                comptePlusRiche = compte;
            }

            if (solde < soldeMin) {
                soldeMin = solde;
                comptePlusPauvre = compte;
            }
        }

        double moyenneSolde = totalSolde / nombreComptes;

        // Statistiques détaillées
        System.out.println("Nombre total de comptes : " + nombreComptes);
        System.out.println("Solde total de la banque : " + String.format("%.2f", totalSolde) + " €");
        System.out.println("Solde moyen par compte : " + String.format("%.2f", moyenneSolde) + " €");
        System.out.println("\n--- Comptes avec le plus gros solde ---");
        if (comptePlusRiche != null) {
            System.out.print("Compte n°" + comptePlusRiche.getNumeroCompte());
            System.out.println(" - " + comptePlusRiche.getNomTitulaire() + " : " + String.format("%.2f", soldeMax) + " €");
        }

        System.out.println("\n--- Comptes avec le plus petit solde ---");
        if (comptePlusPauvre != null) {
            System.out.print("Compte n°" + comptePlusPauvre.getNumeroCompte());
            System.out.println(" - " + comptePlusPauvre.getNomTitulaire() + " : " + String.format("%.2f", soldeMin) + " €");
        }

        // Catégories de comptes
        int comptesNegatifs = 0;
        int comptesPositifs = 0;
        int comptesNuls = 0;
        int comptesMillionnaires = 0;

        for (Compte compte : comptes) {
            double solde = compte.getSolde();
            if (solde < 0) comptesNegatifs++;
            else if (solde == 0) comptesNuls++;
            else comptesPositifs++;

            if (solde >= 1000000) comptesMillionnaires++;
        }

        System.out.println("\n--- Répartition des soldes ---");
        System.out.println("Comptes à solde positif : " + comptesPositifs);
        System.out.println("Comptes à solde nul : " + comptesNuls);
        System.out.println("Comptes à solde négatif : " + comptesNegatifs);

        if (comptesMillionnaires > 0) {
            System.out.println("Comptes millionnaires (≥ 1M €) : " + comptesMillionnaires);
        }

        // Pourcentage des soldes
        System.out.println("\n--- Pourcentages ---");
        System.out.println("Comptes positifs : " + String.format("%.1f", (comptesPositifs * 100.0 / nombreComptes)) + "%");
        System.out.println("Comptes nuls : " + String.format("%.1f", (comptesNuls * 100.0 / nombreComptes)) + "%");
        System.out.println("Comptes négatifs : " + String.format("%.1f", (comptesNegatifs * 100.0 / nombreComptes)) + "%");
    }
}