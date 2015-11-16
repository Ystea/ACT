
(* types*)
type tsp = {
    nbVilles : int;
    distances : int array array;
    distanceMax : int} ;;
type certificat = int list;;

exception Last_permutation ;;



let construitTsp nbVilles distances distanceMax =
    {nbVilles = nbVilles; 
    distances = distances; 
    distanceMax = distanceMax} ;;

 
 
let verifieCertificat prob certif = 
    let rec aux prob certif dist =
        match certif with
             | (ville1 :: ville2 :: villes) -> 
                aux prob (ville2 :: villes) (dist + prob.distances.(ville1).(ville2))
             | _                           -> 
                dist
    and l = certif @ [List.hd certif] in
    (aux prob l 0) <= prob.distanceMax ;;

(* Génération certificat aléatoire *)
let genereCertificat prob =
    let tab = Array.init prob.nbVilles (fun x -> x) in
    for i = 0 to (prob.nbVilles-1) do
        let rand = Random.int prob.nbVilles
        and temp = tab.(i) in
        tab.(i) <- tab.(rand);
        tab.(rand) <- temp;
    done;
    Array.to_list tab;;
 

let tspNonDeterministe prob = 
    verifieCertificat prob (genereCertificat prob);;

    
(*********************** FINDING NEXT PERMUTATION ****************************)

(* Trouver l'élément le plus à droite qui est plus petit que son prochain élément *)
let first tab = 
    let res = ref (Array.length tab - 1) in
    for i = 0 to Array.length tab - 2 do
        if tab.(i) < tab.(i + 1) then res := i
    done;
    !res;;

(* Trouver l'élément le plus petit à droite du `first` plus grand que le `first` *)
let last tab first =
    let res = ref (-1) in 
    for i = Array.length tab - 1 downto first + 1 do
        if tab.(i) > tab.(first) then
            if !res = (-1) || tab.(i) < tab.(!res) then
                res := i;
    done;
    !res;;
    
(* Trier une partie du tableau *)
let sort_sub tab i j =
    let sub = Array.sub tab i j in
    Array.sort compare sub;
    Array.blit sub 0 tab i j;;


let certificatSuivant certif = 
    let tab = Array.of_list certif in
    let f = first tab in
    let l = last tab f in
    if l = -1 then raise Last_permutation;
    let temp = tab.(f) in
    tab.(f) <- tab.(l);
    tab.(l) <- temp;
    sort_sub tab (f + 1) (Array.length tab - 1 - f);
    Array.to_list tab;;

(********************** NEXT PERMUTATION FOUND *******************************)

(* Permet de générer le premier certificat de tous les certificats possibles pour un problème, soit [1, ..., nbVilles] *)
let generePremierCertificat prob = 
    let rec aux = function
        | x, nbVilles when x = nbVilles -> [];
        | x, nbVilles -> x :: (aux (x+1, nbVilles)) in
    aux (0, prob.nbVilles);;
        
(* //!\\ Compléxité exponentielle *)
let verifieTout prob =
    let rec aux prob cert = 
        try
            match verifieCertificat prob cert with
                | false -> aux prob (certificatSuivant cert);
                | _ -> true;
        with 
            | Last_permutation -> false in
    aux prob (generePremierCertificat prob);;
