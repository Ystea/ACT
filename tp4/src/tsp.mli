type tsp;;

type certificat;;

(** Construit un nouveau [tsp] à partir des données fournies *)
val construitTsp : int -> int array array -> int -> tsp;;

(** Vérifie que le certificat répond bien au problèma passé en paramètre *)
val verifieCertificat : tsp -> certificat -> bool;;

(** Génére un certificat aléatoire *)
val genereCertificat : tsp -> certificat;;

(** Algorithme non déterministe pour tester si le problème a une solution *)
val tspNonDeterministe : tsp -> bool;;

(** Algorithme exponentiel pour  tester si le problème a une solution *)
val tspVerifieTout : tsp -> bool;;