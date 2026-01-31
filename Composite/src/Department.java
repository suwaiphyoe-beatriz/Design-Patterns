import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationComponent {
    private List<OrganizationComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent component) {
        children.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        children.remove(component);
    }

    @Override
    public double getSalary() {
        double total = 0;
        for (OrganizationComponent c : children) {
            total += c.getSalary();
        }
        return total;
    }

    @Override
    public void printXML(String indent) {
        System.out.println(indent + "<department name=\"" + name + "\">");
        for (OrganizationComponent c : children) {
            c.printXML(indent + "   ");
        }
        System.out.println(indent + "</department>");
    }
}
