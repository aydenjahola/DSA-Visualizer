JAVAC = javac
JAVA  = java
SRC   = dsaVisualizer/*.java
BIN   = bin

MODULES = --module-path $(PATH_TO_FX) --add-modules javafx.controls

all:
	@echo "Compiling JavaFX sources..."
	mkdir -p $(BIN)
	$(JAVAC) $(MODULES) -d $(BIN) $(SRC)

run: all
	@echo "Running DSA Visualizer..."
	$(JAVA) $(MODULES) -cp $(BIN) dsaVisualizer.DSAVisualizer

clean:
	@echo "Cleaning up..."
	rm -rf $(BIN)

.PHONY: all run clean
