CAMLC = ocamlc
CAMLDOC = ocamldoc
FLAGS =
EXEC = tsp

all : $(EXEC)

%.cmi : %.mli
	$(CAMLC) $(FLAGS) -c $<

tsp : tsp.ml tsp.cmi 
	$(CAMLC) $(FLAGS) -o $@ $<


.PHONY : clean doc all

clean : 
	rm -rf *.cmi *.cmo *~ $(EXEC)

doc : tsp.mli
	$(CAMLDOC) -charset utf-8 -d doc/ -html tsp.mli