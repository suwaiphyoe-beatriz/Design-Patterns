import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory;   // added for redo

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>(); // added for redo
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            redoHistory.add(model.createMemento()); // save current for redo
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    // redo
    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Redo");

            history.add(model.createMemento());

            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            model.restoreState(redoState);

            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        redoHistory.clear();
    }
    //history window
    public List<IMemento> getHistory() {
        return history;
    }
    public void restoreState(IMemento m) {
        saveToHistory();
        model.restoreState(m);
        gui.updateGui();
    }


}