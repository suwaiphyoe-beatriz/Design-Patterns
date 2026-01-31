public class Main {
    public static void main(String[] args) {

        Department root = new Department("Head Office");

        Department itDept = new Department("IT Department");
        itDept.add(new Employee("Su Wai", 5000));
        itDept.add(new Employee("Phyoe", 4500));

        Department hrDept = new Department("HR Department");
        hrDept.add(new Employee("Xiang", 4000));

        Department subDept = new Department("Support Team");
        subDept.add(new Employee("Qian", 3500));
        itDept.add(subDept);

        root.add(itDept);
        root.add(hrDept);

        System.out.println("Total Salary: " + root.getSalary());
        System.out.println("\nOrganization Structure (XML):");
        root.printXML("");
    }
}
