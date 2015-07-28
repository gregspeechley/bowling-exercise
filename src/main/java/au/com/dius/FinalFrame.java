package au.com.dius;

public class FinalFrame extends Frame {

    public FinalFrame() {
        super();
        this.rolls = new int[3];
    }

    @Override
    public boolean isComplete() {
        if (index == 2 && !(isStrike() || isSpare())) {
            return true;
        } else if (index == 3) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFinal() {
        return true;
    }
}
