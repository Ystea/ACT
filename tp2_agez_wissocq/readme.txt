AGEZ Adrien & WISSOCQ Sarah

Q1)
- (2;0)(2;5)(4;4)(4;7)(5;7)(5;0) n'est pas une ligne de toits
- (2;0)(2;5)(4;5)(4;7)(5;7)(5;0) est une ligne de toits
- (2;0)(2;5)(4;5)(4;7)5;7)(6;7)(5;0) n'est pas une ligne de toits
- (2;0)(2;5)(4;5)(4;8)(4;7)(5;7)(5;0) n'est pas une ligne de toits



Q2)
Pour qu'une polyligne soit une ligne de toits, il faut que, pour 2 couples consécutifs :
- Si 2 abscisses sont différentes, la première doit être plus petite que la deuxième et les ordonnées 
doivent être identiques.
- Si les 2 ordonnées sont différentes, les 2 abscisses doivent être identiques. 


Q3)
(1;1)(1;13)(5;13)(5;20)(9;20)(9;27)(12;27)(12;3)(16;3)(16;0)(19;0)(19;3)(22;3)(22;0)(25;0)
voir 3.svg

Q4)
entrée : 
  tab, un tableau de booléens à 2 dimensions (m lignes et n colonnes)
   On considère que le premier point fait parti de la ligne

##### Analyse de la table de "pixels"
	list<int, int> l;
	x = 0;
	y = 0;
	while  x!=n do
		if tab[x][y+1] == 1
			y++;
		else if tab[x+1][y] == 1
			add (x, y) to l;
			x++;
			while tab[x+1][y] == 1 do
				x++;
			end while;
			add (x, y) to l
		else if tab[x][y-1] == 1
			y--;
		else
			
		end if;
	end while;
	return l;
#####

Complexité : O(n * m)

Q5)

entrée : l la liste des points de la ligne de toits
		 g, h et d le triplé définissant l'immeuble à ajouter
		 
##### Ajout d'un rectangle
	it = itérateur sur la liste l 
	while it(x) < g do
		it next;
	end while;
	if it(x) == g then
		if it(y) < h then
			remplacer dans la liste (x, y) par (x, h);
		end if;
	else
		it previous;
		if it(y) < h then
			ajouter le point (g, h) après l'itérateur;
		end if;
	end if;
	
	while it(x) < h do
		it next;
	end while;
	if it(x) == d then
		if it(y) < h then
			remplacer dans la liste (x, y) par (x, h);
		end if;
	else
		it previous;
		if it(y) < h then
			ajouter le point (d, h) après l'itérateur;
		end if;
	end if;

#####

Complexité : O(n)
Si on répète cet algo pour chaque rectangle, alors O(n*m) avec m le nombre de rectangles à ajouter à la ligne

Q6) voir dossier algo -> make
Pour executer, se rendre dans le dossier parent puis java algo.Main

Q7)
Nous n'avons pas réussi à implémenter l'algorithme de création de ligne de toits

