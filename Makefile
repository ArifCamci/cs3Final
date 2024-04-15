SRC = $(wildcard *.java)
OBJ = $(subst .java,.class,$(SRC))

all: $(OBJ)

%.class: %.java
	javac $<

run: $(OBJ)
	java Main

clean:
	rm *.class

.PHONY: all run clean
