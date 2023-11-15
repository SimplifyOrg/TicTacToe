public class Player {
    String name;
    int age;
    Mark playerType;

    public Player(String name, int age, Mark playerType) {
        this.name = name;
        this.age = age;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public Mark getPlayerType() {
        return playerType;
    }
}
