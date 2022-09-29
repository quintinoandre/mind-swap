package academy.mindswap;

public enum DivisionType {
    LIVING_ROOM(15),
    KITCHEN(30),
    BEDROOM(10),
    BATHROOM(20),
    HOME_OFFICE(10);

    private final int dirtinessLevel;

    DivisionType(int dirtinessLevel) {
        this.dirtinessLevel = dirtinessLevel;
    }

    int getDirtinessLevel() {
        return dirtinessLevel;
    }

    @Override
    public String toString() {
        switch (this.name()) {
            case "LIVING_ROOM", "HOME_OFFICE":
                String[] stringArray = super.toString().split("_");

                return stringArray[0].toLowerCase().concat(" ").concat(stringArray[1].toLowerCase());
            default:
                return super.toString().toLowerCase();
        }
    }
}
