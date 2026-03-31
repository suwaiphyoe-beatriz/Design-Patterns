public class Main {
    public static void main(String[] args) {

        // files create
        File file1 = new File("document.txt", 2.5);
        File file2 = new File("photo.jpg", 5.0);
        File file3 = new File("notes.txt", 1.2);

        // directories cr
        Directory root = new Directory("root");
        Directory subDir = new Directory("sub");

        // Build structure
        subDir.add(file3);
        root.add(file1);
        root.add(file2);
        root.add(subDir);

        //  Visitor1: CalculateSize
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        //  Visitor2: Search
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);

        System.out.println("Found files:");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println(f.getName());
        }
    }
}