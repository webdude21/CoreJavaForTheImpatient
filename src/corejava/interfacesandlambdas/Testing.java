package corejava.interfacesandlambdas;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Testing {

    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Measurable[] measurables = new Measurable[10];

        IntStream.range(0, measurables.length).forEach(i -> measurables[i] = new Employee(randomGenerator.nextDouble() * 100d));

        System.out.printf("Average wage: %f%n", Employee.average(measurables));
        System.out.printf("Largest wage: %f%n", Employee.largest(measurables));

        Sequence<Integer> intSequence = IntSequence.of(1, 2, 3, 4, 5, 6);

        while (intSequence.hasNext()) {
            System.out.println(intSequence.next());
        }

        LuckySort luckySort = new LuckySort();

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("pesho");
        arrayList.add("abv");
        arrayList.add("gosho");

        luckySort.sort(arrayList, String::compareTo);
        System.out.println(String.join(", ", arrayList));

        luckySort.sort(arrayList, (a, b) -> b.compareTo(a));
        System.out.println(String.join(", ", arrayList));

        Runnable goshoRunnable = new Greeter(10, "Gosho");
        Runnable peshoRunnable = new Greeter(10, "Pesho");

        new Thread(goshoRunnable).start();
        new Thread(peshoRunnable).start();

        System.out.printf("Running in order:%n");
        Greeter.runInOrder(goshoRunnable, peshoRunnable);
        System.out.printf("Running together:%n");
        Greeter.runTogether(goshoRunnable, peshoRunnable);

        /* List directories and files */
        Arrays.stream(getFolders("./")).forEach(f -> System.out.println(f.getName()));
        Arrays.stream(getFiles("./src/corejava/interfacesandlambdas/", "java")).forEach(f -> System.out.println(f.getName()));
    }

    private static File[] getFolders(String filePath) {
        File fileFolder = new File(filePath);
        return fileFolder.listFiles(File::isDirectory);
    }

    private static File[] getFiles(String path, String extension) {
        File file = new File(path);
        return file.listFiles((dir, name) -> name.endsWith(extension));
    }

    private Runnable getRunnable(Runnable... tasks) {
        return () -> Arrays.stream(tasks).forEach(Runnable::run);
    }
}
