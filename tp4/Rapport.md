Adrien Agez <br/>
Sarah Wissocq

----

# TP - La classe NP

## 1 - Qu'est-ce qu'une propiété NP ?

### Question 1
Un certificat est une tournée comprenant une fois chaque ville (sauf la ville de départ qui sera présente 2 fois : une fois au début et une fois à la fin)

La taille du certificat sera de n+1. Elle est donc bien bornée par la taille de l'entrée

Algorithme de vérification :
    l = distance maximale autorisée
    
    dist := 0
    Pour chaque ville de la tournée (en partant de la deuxième) faire
        dist += (distance entre la ville courante et la ville précédente)
    fin pour
    return dist <= l

Cet algorithme est bien polynomial, il est en θ(n) avec n le nombre de villes de la tournée

### Question 2.1
Génération aléatoire de certificat :
    `tab` = tableau contenant toues les villes
    Pour i allant de 0 à la taille de tab faire
        rdm := entier aléatoire entre 0 et la taille du tableau
        echanger `tab[i]` et `tab[rdm]`
    fin pour
    ajouter `tab[0]` à la fin du tableau


### Question 2.2
Algorithme non deterministe : 
    choisir un certificat aléatoire
    vérifier le certificat

### Question 3.1
Le nombre de certificats possibles correspond au nombre de permutations différentes pour l'ensemble des villes, soit n!

### Question 3.2
On utilisera l'ordre lexicographique (les villes seront représentées par des entiers)


### Question 3.3
Il suffirait d'appliquer l'algorithme de vérification sur chacun des certificats possibles. 
Cet algorithme aurait une compléxité en O(n!)

----

# Réductions polynomiales
