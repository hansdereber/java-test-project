import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

    private SimpleRover simpleRover1;
    private SimpleRover simpleRover2;
    private Controller controller;

    @Test
    public void shouldMoveRoverWithCommand() {
        simpleRover1 = new SimpleRover(1, 1, 2, Rover.Heading.NORTH);
        simpleRover2 = new SimpleRover(2, 3, 3, Rover.Heading.EAST);
        controller = new Controller(Arrays.asList(simpleRover1, simpleRover2));

        Controller resultController = controller
                .processCommand(1, "LMLMLMLMM")
                .processCommand(2, "MMRMMRMRRM");

        Rover simpleRover1 = resultController.getRoverMap().get(1);
        Rover simpleRover2 = resultController.getRoverMap().get(2);


        assertThat(simpleRover1.getHeading()).isEqualTo(Rover.Heading.NORTH);
        assertThat(simpleRover1.getX()).isEqualTo(1);
        assertThat(simpleRover1.getY()).isEqualTo(3);

        assertThat(simpleRover2.getHeading()).isEqualTo(Rover.Heading.EAST);
        assertThat(simpleRover2.getX()).isEqualTo(5);
        assertThat(simpleRover2.getY()).isEqualTo(1);
    }

}