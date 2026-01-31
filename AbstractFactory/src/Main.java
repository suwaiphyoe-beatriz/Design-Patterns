public class Main {
    public static void main(String[] args) {

        // choose
        UIFactory factory = new BFactory();   // B or A factory

        Button button = factory.createButton("OK");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("remember me");

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("\nUpdating textss...\n");

        button.setText("Submit");
        textField.setText("Email");
        checkbox.setText("Subscribe");

        button.display();
        textField.display();
        checkbox.display();
    }
}
