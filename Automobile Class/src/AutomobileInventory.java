import java.util.ArrayList;
import java.util.List;

public class AutomobileInventory {
    private List<Automobile> automobiles;

    public AutomobileInventory() {
        this.automobiles = new ArrayList<>();
    }

    public void addAutomobile(Automobile automobile) {
        this.automobiles.add(automobile);
    }

    public void removeAutomobile(int index) {
        if (index >= 0 && index < this.automobiles.size()) {
            this.automobiles.remove(index);
        }
    }

    public int getAvailableAutomobiles() {
        return this.automobiles.size();
    }

    public String showAllVehiclesInformation() {
        StringBuilder allInformation = new StringBuilder();
        for (int i = 0; i < this.automobiles.size(); i++) {
            allInformation.append("Index [" + i + "]:\n" + this.automobiles.get(i).listVehicleInformation() + "\n");
        }
        return allInformation.toString();
    }

    public Automobile getAutomobile(int index) {
        if (index >= 0 && index < automobiles.size()) {
            return automobiles.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }

}
