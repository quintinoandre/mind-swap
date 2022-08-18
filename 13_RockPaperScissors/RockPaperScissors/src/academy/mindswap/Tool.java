package academy.mindswap;

public enum Tool {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");

    private String formatedName;

    Tool(String formatedName) {
        this.formatedName = formatedName;
    }

    public String getFormatedName() {
        return formatedName;
    }
}
