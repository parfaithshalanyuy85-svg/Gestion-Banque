package BanqueJava;
/**
 * Représente un compte bancaire
 */
public class Compte {
    private int numeroCompte;
    private String nomTitulaire;
    private double solde;
    private String motDePasse; // Nouvel attribut pour le mot de passe

    /**
     * Constructeur pour créer un nouveau compte
     */
    public Compte(int numeroCompte, String nomTitulaire, double soldeInitial, String motDePasse) {
        this.numeroCompte = numeroCompte;
        this.nomTitulaire = nomTitulaire;
        this.solde = soldeInitial;
        this.motDePasse = motDePasse; // Stocker le mot de passe
    }

    /**
     * Déposer de l'argent sur le compte
     */
    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            System.out.println("Dépôt de " + montant + " € effectué avec succès.");
        } else {
            System.out.println("Erreur : Le montant du dépôt doit être positif.");
        }
    }

    /**
     * Retirer de l'argent du compte
     */
    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : Le montant du retrait doit être positif.");
        } else if (montant > solde) {
            System.out.println("Erreur : Solde insuffisant. Solde actuel : " + solde + " €");
        } else {
            solde -= montant;
            System.out.println("Retrait de " + montant + " € effectué avec succès.");
        }
    }

    /**
     * Transférer de l'argent vers un autre compte
     * Retourne true si le transfert a réussi
     */
    public boolean transferer(Compte compteDestinataire, double montant) {
        if (montant <= 0) {
            System.out.println("Erreur : Le montant du transfert doit être positif.");
            return false;
        } else if (montant > solde) {
            System.out.println("Erreur : Solde insuffisant pour le transfert. Solde actuel : " + solde + " €");
            return false;
        } else if (compteDestinataire == null) {
            System.out.println("Erreur : Le compte destinataire n'existe pas.");
            return false;
        } else if (this.numeroCompte == compteDestinataire.getNumeroCompte()) {
            System.out.println("Erreur : Vous ne pouvez pas transférer vers le même compte.");
            return false;
        } else {
            // Retirer du compte source
            this.solde -= montant;
            // Déposer sur le compte destinataire
            compteDestinataire.deposer(montant);
            System.out.println("Transfert de " + montant + " € effectué avec succès.");
            System.out.println("De : Compte " + this.numeroCompte + " (" + this.nomTitulaire + ")");
            System.out.println("Vers : Compte " + compteDestinataire.getNumeroCompte() + " (" + compteDestinataire.getNomTitulaire() + ")");
            return true;
        }
    }

    /**
     * Modifier le nom du titulaire
     */
    public boolean modifierTitulaire(String nouveauNom) {
        if (!nouveauNom.trim().isEmpty()) {
            this.nomTitulaire = nouveauNom;
            return true;
        }
        return false;
    }

    /**
     * Modifier le mot de passe
     */
    public boolean modifierMotDePasse(String ancienMotDePasse, String nouveauMotDePasse) {
        if (this.motDePasse.equals(ancienMotDePasse) && nouveauMotDePasse.length() >= 4) {
            this.motDePasse = nouveauMotDePasse;
            return true;
        }
        return false;
    }

    /**
     * Vérifie si le mot de passe fourni correspond au compte
     */
    public boolean verifierMotDePasse(String motDePasse) {
        return this.motDePasse.equals(motDePasse);
    }

    /**
     * Afficher les informations du compte (sans mot de passe)
     */
    public void afficherCompte() {
        System.out.println("----------------------------");
        System.out.println("Numéro de compte : " + numeroCompte);
        System.out.println("Titulaire : " + nomTitulaire);
        System.out.println("Solde : " + solde + " €");
        System.out.println("----------------------------");
    }

    /**
     * Afficher un résumé court du compte
     */
    public void afficherResume() {
        System.out.println("Compte " + numeroCompte + " - " + nomTitulaire + " (" + solde + " €)");
    }

    // Getters et Setters
    public int getNumeroCompte() {
        return numeroCompte;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    public double getSolde() {
        return solde;
    }

    /**
     * Obtenir le solde pour les statistiques
     */
    public double getSoldePourStatistiques() {
        return solde;
    }
}