import java.util.ArrayList;

public class MyImporter {


    public static MyAnalyser readFile() {

        // This should read from file
        ArrayList<MyPoint> importedPoints = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int value = 100 - (i - 5);
            MyPoint point = MyPoint.builder()
                    .id(i)
                    .value(value)
                    .build();
            importedPoints.add(point);
        }

        return MyAnalyser.builder()
                .noiseWidth(2)
                .name("my data #1")
                .points(importedPoints)
                .build();

    }

}
