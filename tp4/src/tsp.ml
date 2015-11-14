
(* types*)
type tsp = {
    nbVilles : int;
    distances : int array array;
    distanceMax : int} ;;
type certificat = int list;;



(* Fonctions de manipulation *)
let construitTsp nbVilles distances distanceMax =
    {nbVilles = nbVilles; 
    distances = distances; 
    distanceMax = distanceMax} ;;

 
 
let verifieCertificat prob certif = 
    let rec aux prob certif dist =
        match certif with
              (ville1 :: ville2 :: villes) -> 
                aux prob (ville2 :: villes) (dist + prob.distances.(ville1).(ville2))
             | _                           -> 
                dist in
    (aux prob certif 0) <= prob.distanceMax ;;

let genereCertificat prob =
    let tab = Array.init prob.nbVilles (fun x -> x) in
    for i = 0 to (prob.nbVilles-1) do
        let rand = Random.int prob.nbVilles
        and temp = tab.(i) in
        tab.(i) <- tab.(rand);
        tab.(rand) <- temp;
    done;
    let l = Array.to_list tab in
    (List.nth l (prob.nbVilles-1)) :: l;;
        
let tspNonDeterministe prob = 
    verifieCertificat prob (genereCertificat prob);;

(*
let certificatSuivant certif = 
    let l = List.rev certif in
    let min = ref (hd l)
    and idx = ref 0 in
    for i = 0 to (length l) do
  *)      

let test = {
    nbVilles = 4;
    distances = [| 
    [|0; 2; 5; 7|];
    [|7; 0; 8; 1|];
    [|2; 1; 0; 9|];
    [|2; 2; 8; 0|]|];
    distanceMax = 20 };;

    
let _ =
    Random.self_init ();
    print_string (string_of_bool (tspNonDeterministe test));;
    

    