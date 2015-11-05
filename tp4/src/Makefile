CAMLC = ocamlc

EXEC = tsp

all : $(EXEC)

%.cmi : %.mli
	$(CAMLC) -c $<

tsp : tsp.ml tsp.cmi 
	$(CAMLC) -o $@ $<


.PHONY : clean

clean : 
	rm -rf *.cmi *.cmo $(EXEC)