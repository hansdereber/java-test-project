import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

final public class Controller {

    final private Map<Integer, Rover> roverMap;

    public Controller(List<Rover> roverList) {
        this.roverMap = roverList.stream().collect(Collectors.toMap(Rover::getId, Function.identity()));
    }

    public Controller(Map<Integer, Rover> roverMap) {
        this.roverMap = roverMap;
    }

    public Map<Integer, Rover> getRoverMap() {
        return new HashMap<>(this.roverMap);
    }

    public Controller processCommand(Integer id, String command) {
        Map<Integer, Rover> resultMap = new HashMap<>(this.roverMap);
        resultMap.put(id, processCommand(this.roverMap.get(id), command));
        return new Controller(resultMap);
    }

    private Rover processCommand(Rover rover, String command) {
        for (Character singleCommand : command.toCharArray()) {
            rover = processSingleCommand(rover, singleCommand);
        }
        return rover;
    }

    private Rover processSingleCommand(Rover rover, Character singleCommand) {
        switch (singleCommand) {
            case 'R':
                return rover.turnRight();
            case 'L':
                return rover.turnLeft();
            case 'M':
                return rover.move();
            default:
                return rover;
        }
    }
}
