package y2021.Day4;

public class Number {
    private boolean active = false;
    private int num;

    public Number(int num) {
        this.num = num;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public int getNum() {
        return this.num;
    }

    public String toString() {
        if (this.active) {

            return "*" + String.valueOf(this.num) + "*";
        } else {
            return " " + String.valueOf(this.num) + " ";
        }

    }
}
