package ucu.lab7.flower;

public enum FlowerType {
    ROSE("rose"), TULIP("tulip"), CHAMOMILE("chamomile"), CACTUS("cactus");

    private String type;

    FlowerType(String type) {
        this.type = type;
    }

    public String toString() {
        return this.type;
    }
}
