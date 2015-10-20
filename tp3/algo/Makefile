.PHONY: clean, run

#Passing arguments to run target
# ifeq (run,$(firstword $(MAKECMDGOALS)))
#   # use the rest as arguments for "run"
#   RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
#   # ...and turn them into do-nothing targets
#   $(eval $(RUN_ARGS):;@:)
# endif


all : Game.class

run : Game.class
	java Game

%.class : %.java
	javac $<


clean : 
	rm -rf *.class *~
