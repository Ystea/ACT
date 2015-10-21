AGEZ Adrien & WISSOCQ Sarah 


Pour compiler : 
cd algo
make
Pour executer : 
java Game


Dans Game.java : 3 versions du main sont présentes, dont 2 commentées
La première affiche les valeurs et les temps d'execution sur différentes configurations pour chaque algo
La deuxième demande 4 paramètres sur la ligne de commande et affiche la valeur et le temps d'execution de l'algo dynamique pour le jeu correspondant
La troisième affiche tous les couples (i,j) pour lesquelles (127, 127, i, j) a une valeur de 127 (avec une trace d'execution, car elle peut prendre quelques minutes à s'executer)


Question 1)
Voir question1.png

Question 2)
si négatif -> position = -max(successeurs négatifs)+1
sinon      -> position = -min(successeurs)-1

Question 3)
naif(3,2,2,0)       = 3    time = 0.0006 secondes
naif(10,7,7,3)      = 11   time = 3.4228 secondes
naif(10,7,5,3)      = 15   time = 7.0178 secondes
dynamique(3,2,2,0)  = 3    time = 0.0004 secondes
dynamique(10,7,7,3) = 11   time = 0.0025 secondes
dynamique(10,7,5,3) = 15   time = 0.0013 secondes

La complexité de l'algorithme naif est exponentielle, car pour chaque appel récursif, il faut résoudre n+m sous-problèmes.
De plus, les sous problèmes peuvent être calculées de très nombreuses fois

Question 4)
dynamique(100, 100, 50, 50) : -198   time = 27.7510 secondes
dynamique(100, 100, 48, 52) : 191    time = 27.6177 secondes


Question 5)
(127, 127, 0, 63)
(127, 127, 63, 0)
(127, 127, 126, 63)
(127, 127, 63, 126)

Question 6)
O(m^2 * n^2)

Question 7)
Les 4 premières configurations sont des symétries et auront donc la même valeur, car le "sens" de la configuration
n'influe pas sur sa valeur
Les 4 configurations suivantes ne sont que des rotations des 4 premières


Question 8)
Après avoir pris en compte les symétries : 
dynamique(100, 100, 50, 50) : -198      time = 7.5037 secondes
dynamique(100,100,48,52)    : 191       time = 8.8422 secondes




   ___  ___  ___  ___  ___.---------------.
  .'\__\'\__\'\__\'\__\'\__,`   .  ____ ___ \
  |\/ __\/ __\/ __\/ __\/ _:\   |`.  \  \___ \
   \\'\__\'\__\'\__\'\__\'\_`.__|""`. \  \___ \
    \\/ __\/ __\/ __\/ __\/ __:                \
     \\'\__\'\__\'\__\ \__\'\_;-----------------`
      \\/   \/   \/   \/   \/ :                h|
       \|______________________;________________|
