# 🏦 Système de Gestion Bancaire en Java

## 📋 Description
Un système bancaire **console** développé en **Java pur**, permettant de gérer des comptes bancaires avec des opérations de base.  
Ce projet est conçu pour les **développeurs Java débutants** et sert d'exemple pédagogique pour comprendre les concepts fondamentaux de la **programmation orientée objet (POO)**.

---

## 🎯 Fonctionnalités

✅ Création automatique de comptes avec **numéros uniques**  
✅ Dépôt et retrait d'argent avec **vérifications de sécurité**  
✅ Transferts entre comptes avec **validation complète**  
✅ Consultation de compte avec **vérification d'identité**  
✅ Modification des informations du titulaire  
✅ Suppression de comptes sous **conditions de sécurité**  
✅ Affichage de tous les comptes existants  
✅ Affichage du **prochain numéro de compte disponible**

---

## 🛠️ Prérequis

- Java Development Kit (**JDK 8 ou supérieur**)
- Un terminal / console
- Un éditeur de code ou IDE :
    - VS Code
    - IntelliJ IDEA
    - Eclipse
    - NetBeans

---


---

## 🚀 Installation et Exécution

### 1️⃣ Téléchargement
Clonez le projet ou téléchargez les **4 fichiers `.java`** dans un même dossier.

---

### 2️⃣ Compilation
Ouvrez un terminal dans le dossier du projet et exécutez :

```bash
  javac nom_du_projet.java
```
#### ️3⃣ Exécution

Après compilation réussie, lancez le programme avec :
```bash
  Java Main
  ```
# 📝 Utilisation du Programme
## 📌 Menu Principal

```bash 
  === SYSTÈME DE GESTION BANCAIRE ===
1. Créer un compte
2. Déposer de l'argent
3. Retirer de l'argent
4. Consulter un compte
5. Afficher tous les comptes
6. Afficher prochain numéro disponible
7. Transférer de l'argent
8. Modifier un compte
9. Supprimer un compte
0. Quitter
```
# 📖 Guide des Fonctionnalités
## 1️⃣ Création d'un compte

```bash 
Le système génère automatiquement un numéro de compte unique

Saisissez le nom du titulaire et le solde initial

 ⚠️ Important : Notez le numéro de compte attribué
```
### 2️⃣ Dépôt d'argent

Saisir le numéro de compte

Vérification de l'identité (nom du titulaire)

Entrer le montant à déposer

### 3️⃣ Retrait d'argent

Vérification de l'identité

Vérification du solde suffisant

Retrait sécurisé

### 4️⃣ Consultation de compte

Numéro de compte + nom du titulaire

Affichage complet des informations du compte

5️⃣ Affichage de tous les comptes

Liste de tous les comptes existants

Affiche : numéro, titulaire et solde

### 6️⃣ Prochain numéro disponible

Affiche le prochain numéro de compte qui sera attribué

### 7️⃣ Transfert d'argent

Vérification du compte source

Vérification d'identité

Sélection du compte destinataire

Montant à transférer

Double confirmation avant exécution

### 8️⃣ Modification d'un compte

Vérification avec l'ancien nom

Saisie du nouveau nom du titulaire

### 9️⃣ Suppression d'un compte

Conditions :

Solde égal à 0

Vérification d'identité

Confirmation obligatoire (action irréversible)

Affichage des informations avant suppression

# 🔒 Sécurité

Vérification du nom du titulaire pour chaque opération sensible

Impossible de supprimer un compte avec un solde non nul

Confirmation requise pour les actions critiques

Transferts sécurisés :

Comptes différents

Solde suffisant

# ⚠️ Limitations

Données stockées uniquement en mémoire

Données perdues à la fermeture du programme

Interface console uniquement

Pas de chiffrement des informations

Pas de base de données

# 🎓 Objectifs Pédagogiques

Ce projet permet de comprendre :

La programmation orientée objet en Java

La séparation des responsabilités (plusieurs classes)

L'utilisation des collections (ArrayList)

Les structures de contrôle (if, switch, while)

La validation des entrées utilisateur

La gestion simple des erreurs