{-
 - Adrien Agez
 - Sarah Wissocq
 -}

 
type Point = (Integer, Integer)


-- Valeurs de test pour l'algorithme de fusion
test1 = [(1,10), (5,6), (8,0), (10,8), (12,0)]
test2 = [(2,12), (7,0), (9,4), (11,2), (14,0)]

-- Fonction auxiliaire pour la fusion
fusionA :: Integer -> Integer -> [Point] -> [Point] -> [Point]
fusionA _ _ [] [] = []
fusionA _ _ l [] = l
fusionA _ _ [] l = l
fusionA h1 h2 l1comp@((x1, y1) : l1) l2comp@((x2, y2) : l2)
	| x1 == x2	= (x1, max y1 y2) : fusionA y1 y2 l1 l2
	| x1 < x2	= (x1, max y1 h2) : fusionA y1 y2 l1 l2comp
	| x1 > x2	= (x2, max y2 h1) : fusionA y1 y2 l1comp l2 



fusion :: [Point] -> [Point] -> [Point]
fusion = fusionA 0 0