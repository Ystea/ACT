Adrien Agez <br/>
Sarah Wissocq

# TP Heuristiques : Pizza Regina

## Certificat
Une part est représentée par 4 entiers `r1`, `r2`, `c1`, `c2`. La part est délimitée par les lignes `r1` et `r2`, ainsi que par les colonnes `c1` et `c2`.
Un certificat correspondra à une liste de parts représentant une découpe possible de la pizza.

La taille du certificat est bornée par le nombre de cases : il ne peut pas y avoir plus de parts que de cases.

### Algorithme de vérification
O(n) avec n le nombre de cases de la pizza
Le problème de la pizza regina est NP


## Solution aléatoire
Il est possible de tomber sur l'optimale, mais les chances sont extremement faibles !

## Heuristique de pavage glouton
On peut tenter de placer d'abord les parts les plus grandes possibles pour ensuite compléter avec des parts plus petites