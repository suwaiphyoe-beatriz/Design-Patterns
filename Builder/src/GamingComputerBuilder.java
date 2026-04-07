public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Apple M3 Max Chip");
    }

    @Override
    public void buildRAM() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1TB SSD Storage");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Apple GPU ");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("macOS Sonoma");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}