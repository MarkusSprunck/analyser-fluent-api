import java.util.List;
import java.util.stream.Collectors;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MyAnalyser {

    private List<MyPoint> points;

    private int noiseWidth;

    private String name;

    // fluent API change parameter
    public MyAnalyser noiseWidth(int noiseWidth) {
        this.noiseWidth = noiseWidth;
        return this;
    }

    // fluent API run analysis
    public MyAnalyser run() {
        points.forEach(
                myPoint -> {
                    int id = myPoint.id;
                    myPoint.peak = (id == 5);
                    myPoint.noise = (id != 5 && Math.abs(id - 5) <= noiseWidth);
                    myPoint.invalid = (id == 9 || id == 7);
                    myPoint.important = (id == 5);
                });
        return this;
    }

    // Filter
    public List<MyPoint> peaks() {
        return points.stream().filter(myPoint -> myPoint.peak).collect(Collectors.toList());
    }

    public List<MyPoint> noise() {
        return points.stream().filter(myPoint -> myPoint.noise).collect(Collectors.toList());
    }

    public List<MyPoint> important() {
        return points.stream().filter(myPoint -> myPoint.important).collect(Collectors.toList());
    }

    public List<MyPoint> invalid() {
        return points.stream().filter(myPoint -> myPoint.invalid).collect(Collectors.toList());
    }

    public List<MyPoint> invalidAndNoise() {
        return points.stream().filter(myPoint -> myPoint.invalid && myPoint.noise).collect(Collectors.toList());
    }

}
