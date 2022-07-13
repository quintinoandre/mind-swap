package academy.mindswap;

public class Player {
    private String name;
    private String tool;

    private int score = 0;
    private String ROCK = "rock";
    private String PAPER = "paper";
    private String SCISSORS = "scissors";

    public Player(String name) {
        this.name = name;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min + 1) + min));
    }

    public void pickRandomTool() {
        String[] tools = {ROCK, PAPER, SCISSORS};

        String picketTool = tools[getRandomNumber(0, 2)];

        System.out.printf("%s tool: %s%n", getName(), picketTool);

        setTool(picketTool);
    }

    public String getName() {
        return name;
    }

    public String getTool() {
        return tool;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setTool(String tool) {
        this.tool = tool;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
