CAMLC = ocamlc
CAMLDOC = ocamldoc
FLAGS = -c
CMO = tsp.cmo hamilton.cmo
.PRECIOUS : tsp.cmi

all : $(CMO)


.PHONY : clean doc all
clean : 
	rm -rf *.cmi *.cmo *~ $(EXEC)
doc : tsp.mli
	$(CAMLDOC) -charset utf-8 -d doc/ -html tsp.mli



#### CMI ####
hamilton.cmi : hamilton.mli tsp.cmo
	$(CAMLC) $(FLAGS) tsp.cmo $<
%.cmi : %.mli
	$(CAMLC) $(FLAGS) $<


#### CMO ####
hamilton.cmo : hamilton.ml hamilton.cmi tsp.cmo
	$(CAMLC) $(FLAGS) tsp.cmo $< -o $@



%.cmo : %.ml %.cmi
	$(CAMLC) $(FLAGS) $< -o $@

