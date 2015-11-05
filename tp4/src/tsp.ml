


type tsp = {
    nbVilles : int;
    distances : int array array;
    distanceMax : int} ;;


type certificat = int list;;

let construitTsp nbVilles distances distanceMax =
    {nbVilles = nbVilles; distances = distances; distanceMax = distanceMax} ;;

 
 
let verifieCertificat prob certif = 
    let rec aux prob certif dist =
        match certif with
              (ville1 :: ville2 :: villes) -> 
                aux prob (ville2 :: villes) (dist + prob.distances.(ville1).(ville2))
             | _ -> dist in
    (aux prob certif 0) <= prob.distanceMax ;;




