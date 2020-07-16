final public class StepCountingRover extends ForwardingRover {
    private final int numOfPreviousSteps;

    public StepCountingRover(Rover rover, int numOfPreviousSteps) {
        super(rover);
        this.numOfPreviousSteps = numOfPreviousSteps;
    }

    @Override
    public StepCountingRover move() {
        return new StepCountingRover(rover.move(), numOfPreviousSteps + 1);
    }

    public int getNumOfPreviousSteps() {
        return numOfPreviousSteps;
    }
}
