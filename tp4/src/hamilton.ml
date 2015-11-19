open Tsp;;


type hamilton = {
        n : int;
        graphe : bool array array
    };;


let grapheToDistance distanceMax = 
    let f = function
        | true  -> 1;
        | false -> distanceMax in
    Array.map (Array.map f);;
    
    
let cycleToTsp ham =
    construitTsp ham.n (grapheToDistance (ham.n+1) ham.graphe) (ham.n+1);;


let pathToCycle path = 
    let tab  = path.graphe in
    for i = 0 to (Array.length tab) - 1 do
        tab.(i) <- Array.append tab.(i) [|true|];
    done;
    {n = path.n+1; graphe = Array.append tab [|(Array.make ((Array.length tab) +1) true)|]} ;;

(* -------------------------------------------------------------------------------------------- *)


let pathToTsp path = cycleToTsp (pathToCycle path);;


let test1 = {
    n = 7;      (* No solution for that *)
    graphe = [|
    [|false; true; false; false; false; false; false;|];
    [|true; false; false; false; false; false; false;|];
    [|false; true; false; false; true; false; false;|];
    [|false; true; false; false; true; false; false;|];
    [|false; true; false; false; true; false; false;|];
    [|false; true; false; false; true; false; false;|];
    [|false; true; false; false; true; false; false;|];|]
};;

let test2 = { 
    n = 7;      (* 0 1 2 4 3 5 6  *)
    graphe = [|
    [|false; true; false; false; false; false; false;|];
    [|true; false; true; false; false; false; false;|];
    [|false; true; false; false; true; false; false;|];
    [|false; true; false; false; true; true; false;|];
    [|false; true; false; true; true; false; false;|];
    [|false; true; false; false; true; false; true;|];
    [|true; true; false; false; true; true; false;|] |]
};;


    