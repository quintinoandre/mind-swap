package academy.mindswap;

public class Player {
    private String name;
    private Tool tool;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    private static int getRandomNumber() {
        return (int) (Math.random() * 3);
    }

    public void pickRandomTool() {
        Tool picketTool = Tool.values()[getRandomNumber()];

        System.out.printf("%s tool: %s%n", getName(), picketTool.getFormatedName());

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
