import lombok.Builder;

@Builder
public class MyPoint {

    int id;

    double value;

    boolean peak;

    boolean noise;

    boolean invalid;

    boolean important;

}
