import static java.util.Objects.requireNonNull;

final public class SimpleRover implements Rover {

    final private Integer id;
    final private Integer x;
    final private Integer y;
    final private Heading heading;

    public SimpleRover(Integer id, Integer x, Integer y, Heading heading) {
        this.id = requireNonNull(id);
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
        this.heading = requireNonNull(heading);
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public Heading getHeading() {
        return heading;
    }

    @Override
    public SimpleRover move() {
        return new SimpleRover(
                this.id,
                this.x + this.heading.getDeltaForMoveX(),
                this.y + this.heading.getDeltaForMoveY(),
                this.heading);
    }

    @Override
    public SimpleRover turnRight() {
        return new SimpleRover(
                this.id,
                this.x,
                this.y,
                this.heading.getRightTurn());
    }

    @Override
    public SimpleRover turnLeft() {
        return new SimpleRover(
                this.id,
                this.x,
                this.y,
                this.heading.getLeftTurn());
    }
}
