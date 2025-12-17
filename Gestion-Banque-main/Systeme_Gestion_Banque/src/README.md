# Système de Gestion Bancaire en Java

## 📋 Description
Un système bancaire console développé en Java pur avec système de mot de passe et statistiques. Ce projet est conçu pour les développeurs Java débutants et sert d'exemple pédagogique.

## 🎯 Fonctionnalités
- ✅ **Création automatique de comptes** avec numéros uniques
- ✅ **Système de mot de passe** pour chaque compte
- ✅ **Dépôt et retrait d'argent** avec authentification
- ✅ **Transferts entre comptes** avec validation
- ✅ **Consultation de compte** avec mot de passe
- ✅ **Modification** du nom et du mot de passe
- ✅ **Suppression de comptes** avec conditions
- ✅ **Statistiques bancaires** détaillées
- ✅ **Affichage de tous les comptes**

## 🛠️ Prérequis
- Java Development Kit (JDK) 8 ou supérieur
- Un terminal/console
- Un éditeur de texte ou IDE

## 🚀 Installation et Exécution

### 1. Téléchargement
Placez les 4 fichiers .java dans un même dossier.

### 2. Compilation
```bash
  javac *.java
```
### 3. Execution
```bash
   java Main
```
## Menu Principal
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
10. Afficher les statistiques
11. Modifier le mot de passe
0. Quitter
```
### 🔐 Système de Sécurité
Création de compte
Mot de passe obligatoire (minimum 4 caractères)

Confirmation du mot de passe

Numéro généré automatiquement

Accès aux comptes
Toutes les opérations nécessitent le mot de passe

Vérification avant chaque transaction

Protection contre les accès non autorisés

### 📊 Statistiques Bancaires
Statistiques incluses :
Nombre total de comptes

Solde total de la banque

Solde moyen par compte

Compte le plus riche/le plus pauvre

Répartition des soldes (positifs, nuls, négatifs)

Pourcentages par catégorie

Comptes millionnaires (≥ 1M €)

#### Exemple de sortie :
```bash
 === STATISTIQUES BANCAIRES ===
Nombre total de comptes : 5
Solde total de la banque : 12500.50 €
Solde moyen par compte : 2500.10 €

--- Comptes avec le plus gros solde ---
Compte n°1003 - Jean Dupont : 5000.00 €

--- Répartition des soldes ---
Comptes à solde positif : 4
Comptes à solde nul : 0
Comptes à solde négatif : 1

--- Pourcentages ---
Comptes positifs : 80.0%
Comptes négatifs : 20.0%
```
### 🔄 Modification du Mot de Passe
Option 11 du menu

Vérification de l'ancien mot de passe

Confirmation du nouveau mot de passe

Minimum 4 caractères requis

## ⚠️ Sécurité Avancée
Pour les suppressions :
Solde doit être à 0

Mot de passe correct requis

Double confirmation obligatoire

Pour les transferts :
Authentification du compte source

Vérification du solde suffisant

Confirmation avant exécution

## 🎓 Objectifs Pédagogiques
Concepts Java illustrés :
Encapsulation : Attributs privés avec getters/setters

Collections : ArrayList pour gérer les comptes

Validation : Entrées utilisateur sécurisées

Statistiques : Calculs et analyses de données

Sécurité : Authentification par mot de passe

### Bonnes pratiques :
Séparation des responsabilités

Validation des entrées

Gestion des erreurs

Code modulaire et réutilisable

## 📈 Améliorations Possibles
Sécurité :
Chiffrement des mots de passe

Limitation des tentatives de connexion

Journal des opérations (log)

## 🐛 Dépannage
#### Problèmes courants :
Erreur "cannot find symbol" : Vérifiez que tous les fichiers sont dans le même dossier

Mot de passe non reconnu : Respectez la casse (majuscules/minuscules)

Solde insuffisant : Vérifiez le solde avant retrait/transfert

#### Solutions :
Recompilez tous les fichiers : javac *.java

Redémarrez le programme

Vérifiez les entrées utilisateur

## 📄 Licence
Projet éducatif - Libre d'utilisation pour l'apprentissage

