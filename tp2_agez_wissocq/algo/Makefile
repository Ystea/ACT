.PHONY: clean


all : 
	javac *.java

test : all
	cd ..
	java algo.Main

%.class : %.java
	javac $<



clean: 
	rm -rf *~ *.class