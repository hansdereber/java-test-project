public abstract class ForwardingRover implements Rover {
    protected final Rover rover;

    protected ForwardingRover(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Integer getId() {
        return rover.getId();
    }

    @Override
    public Integer getX() {
        return rover.getX();
    }

    @Override
    public Integer getY() {
        return rover.getY();
    }

    @Override
    public Heading getHeading() {
        return rover.getHeading();
    }

    @Override
    public Rover move() {
        return rover.move();
    }

    @Override
    public Rover turnRight() {
        return rover.turnRight();
    }

    @Override
    public Rover turnLeft() {
        return rover.turnLeft();
    }
}
