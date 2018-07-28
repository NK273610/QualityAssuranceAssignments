public abstract class MathOperation {

    public int leftoprand;
    public int rightoperand;

    public MathOperation(int leftoprand, int rightoperand) {
        this.leftoprand = leftoprand;
        this.rightoperand = rightoperand;
    }

    public abstract int GetResult();
}
