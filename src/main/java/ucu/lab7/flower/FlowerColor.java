package ucu.lab7.flower;

public enum FlowerColor {
    RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"),
    YELLOW("#F0F000"), PINK("#F000FF"), WHITE("#FFFFFF");

    private String hexColor;

    FlowerColor(String hexColor) {
        this.hexColor = hexColor;
    }

    public String toString() {
        return this.hexColor;
    }
}
