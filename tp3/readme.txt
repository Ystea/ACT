AGEZ Adrien & WISSOCQ Sarah 

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

La complexité de l'algorithme naif est exponentielle, car pour chaque appel récursif, il faut résoudre n+m sous-problèmes

Question 4)
dynamique(100, 100, 50, 50) : -198   time = 27.7510 secondes
dynamique(100, 100, 48, 52) : 191    time = 27.6177 secondes


Question 8)
dynamique(100, 100, 50, 50) : -198   time = 8.8930 secondes






   ___  ___  ___  ___  ___.---------------.
  .'\__\'\__\'\__\'\__\'\__,`   .  ____ ___ \
  |\/ __\/ __\/ __\/ __\/ _:\   |`.  \  \___ \
   \\'\__\'\__\'\__\'\__\'\_`.__|""`. \  \___ \
    \\/ __\/ __\/ __\/ __\/ __:                \
     \\'\__\'\__\'\__\ \__\'\_;-----------------`
      \\/   \/   \/   \/   \/ :                h|
       \|______________________;________________|


