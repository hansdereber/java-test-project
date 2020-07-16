public interface Rover {

    Integer getId();

    Integer getX();

    Integer getY();

    Heading getHeading();

    Rover move();

    Rover turnRight();

    Rover turnLeft();

    enum Heading {
        NORTH {
            @Override
            public Heading getLeftTurn() {
                return Heading.WEST;
            }

            @Override
            public Heading getRightTurn() {
                return Heading.EAST;
            }

            @Override
            public int getDeltaForMoveX() {
                return 0;
            }

            @Override
            public int getDeltaForMoveY() {
                return 1;
            }
        },
        EAST {
            @Override
            public Heading getLeftTurn() {
                return Heading.NORTH;
            }

            @Override
            public Heading getRightTurn() {
                return Heading.SOUTH;
            }

            @Override
            public int getDeltaForMoveX() {
                return 1;
            }

            @Override
            public int getDeltaForMoveY() {
                return 0;
            }
        },
        SOUTH {
            @Override
            public Heading getLeftTurn() {
                return Heading.EAST;
            }

            @Override
            public Heading getRightTurn() {
                return Heading.WEST;
            }

            @Override
            public int getDeltaForMoveX() {
                return 0;
            }

            @Override
            public int getDeltaForMoveY() {
                return -1;
            }
        },
        WEST {
            @Override
            public Heading getLeftTurn() {
                return Heading.SOUTH;
            }

            @Override
            public Heading getRightTurn() {
                return Heading.NORTH;
            }

            @Override
            public int getDeltaForMoveX() {
                return -1;
            }

            @Override
            public int getDeltaForMoveY() {
                return 0;
            }
        };

        public abstract Heading getLeftTurn();
        public abstract Heading getRightTurn();
        public abstract int getDeltaForMoveX();
        public abstract int getDeltaForMoveY();
    }
}
