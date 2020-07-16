import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleRoverTest {

    private SimpleRover simpleRover;

    @Before
    public void initialize() {

    }

    @Test
    public void shouldBeConstructedWithAttributes() {
        this.simpleRover = new SimpleRover(42, 5, 3, Rover.Heading.EAST);

        Integer result = simpleRover.getX();

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldBeImmutable() {
        this.simpleRover = new SimpleRover(42, 5, 3, Rover.Heading.EAST);

        Integer x = simpleRover.getX();
        x = x+x;
        Integer result = simpleRover.getX();

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldHeadSouthAfterTurnRight() {
        this.simpleRover = new SimpleRover(42, 5, 3, Rover.Heading.EAST);

        SimpleRover simpleRover = this.simpleRover.turnRight();

        assertThat(simpleRover.getHeading()).isEqualTo(Rover.Heading.SOUTH);
    }

    @Test
    public void shouldHeadNorthAfterTurnLeft() {
        this.simpleRover = new SimpleRover(42, 5, 3, Rover.Heading.EAST);

        SimpleRover simpleRover = this.simpleRover.turnLeft();

        assertThat(simpleRover.getHeading()).isEqualTo(Rover.Heading.NORTH);
    }

    @Test
    public void shouldMove() {
        this.simpleRover = new SimpleRover(1, 1, 2, Rover.Heading.NORTH);

        SimpleRover simpleRover = this.simpleRover.turnLeft().move();

        assertThat(simpleRover.getHeading()).isEqualTo(Rover.Heading.WEST);
    }

}