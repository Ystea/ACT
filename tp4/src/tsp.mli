(** Module pour la manipulation du {e Traveling Salesman Problem} 
@author Adrien Agez
*)

(** Le type [tsp] est un enregistrement contenant toutes les données d'un {e Traveling Salesman Problem} : 
	- [nbVilles] correspond au nombre total de villes dans le problème
	- [distances] est une matrice carrée de taille [nbVilles] contenant les distances entre les villes
	- [distanceMax] est la distance maximale autorisée pour répondre au problème
*)
type tsp;;

(** Un certificat est une liste d'entiers représantant l'ordre des villes. 

/!\ : Un certificat ne doit contenir qu'une seule fois chaque ville. Le retour à la ville de départ est automatiquement pris en compte !*)
type certificat;;

(** Construit un nouveau [tsp] à partir des données fournies 
@param 1 nombre de villes
@param 2 matrice carrée de taille [nbVilles] contenant les distances entre les villes
@param 3 distance maximale autorisée 
@return le [tsp] correspondant *)
val construitTsp : int -> int array array -> int -> tsp;;

(** Vérifie que le certificat répond bien au problème passé en paramètre *)
val verifieCertificat : tsp -> certificat -> bool;;

(** Génére un certificat aléatoire correspondant au [tsp] passé en paramètre *)
val genereCertificat : tsp -> certificat;;

(** Algorithme {e non déterministe} pour tester si le problème a une solution *)
val tspNonDeterministe : tsp -> bool;;

(** Algorithme {e exponentiel} pour  tester si le problème a une solution *)
val verifieTout : tsp -> bool;;

