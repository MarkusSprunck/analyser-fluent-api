import java.util.List;

public class Main {

    public static void main(String[] args) {

        MyAnalyser analyser = MyImporter.readFile();

        System.out.println("\n" + analyser.getName());
        analyser.run();

        System.out.println("\nPoints:");
        plotAllPoints(analyser.getPoints());

        System.out.println("\nPeaks:");
        plotAllPoints(analyser.peaks());

        System.out.println("\nNoise:");
        plotAllPoints(analyser.noise());

        System.out.println("\nImportant:");
        plotAllPoints(analyser.important());

        System.out.println("\nInvalid:");
        plotAllPoints(analyser.invalid());

        System.out.println("\nInvalid and Noise:");
        plotAllPoints(analyser.invalidAndNoise());

        System.out.println("\n\nChange setNoiseWidth() to 1 and run() => \nNoise:");
        analyser.noiseWidth(1).run();
        plotAllPoints(analyser.noise());

    }

    private static void plotAllPoints(List<MyPoint> points) {
        points.forEach(p -> {
            System.out.println("   " + p.id + " " + p.value);
        });
    }

}
