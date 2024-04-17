SRC = $(wildcard *.java)
OBJ = $(subst .java,.class,$(SRC))

all: $(OBJ)

%.class: %.java
	javac -classpath /mayflower:mayflower3.3.7.jar $<

run: $(OBJ)
	java -cp mayflower3.3.7.jar Main

clean:
	rm *.class

.PHONY: all run clean
