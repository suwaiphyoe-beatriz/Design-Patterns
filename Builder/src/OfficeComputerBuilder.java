public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Apple M2 Chip");
    }

    @Override
    public void buildRAM() {
        computer.setRam(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512GB SSD Storage");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Apple GPU");
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