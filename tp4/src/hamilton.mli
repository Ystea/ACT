open Tsp;;
type hamilton;;




(* Réduction de HamiltonCycle dans TSP *)
(** Transforme un problème de HamiltonCycle en un problème TSP équivalent *)
val cycleToTsp : hamilton -> tsp ;;



(* Réduction de HamiltonPath dans HamiltonCycle *)
(** Transforme un problème de HamiltonPath en un problème HamiltonCycle équivalent *)
val pathToCycle : hamilton -> hamilton ;;


(*--------------------------------------------------------------------------------*)

(** Composition des 2 réductions : HamiltonPath vers TSP *)
val pathToTsp : hamilton -> tsp;;