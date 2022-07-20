package academy.mindswap;

public class Player {
    private String name;
    private Tool tool;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min + 1) + min));
    }

    public void pickRandomTool() {
        Tool picketTool = Tool.values()[getRandomNumber(0, 2)];

        System.out.printf("%s tool: %s%n", getName(), picketTool);

        setTool(picketTool);
    }

    public String getName() {
        return name;
    }

    public Tool getTool() {
        return tool;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
