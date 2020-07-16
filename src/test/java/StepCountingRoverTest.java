import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StepCountingRoverTest {

    private StepCountingRover stepCountingRover;

    @Test
    public void shouldCountFiveSteps() {
        this.stepCountingRover = new StepCountingRover(new SimpleRover(42, 5, 3, Rover.Heading.EAST),0);

        StepCountingRover resultRover = stepCountingRover.move().move().move().move().move();

        assertThat(resultRover.getNumOfPreviousSteps()).isEqualTo(5);
        assertThat(resultRover.getX()).isEqualTo(10);
    }

}