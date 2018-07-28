public class SubtractClass extends MathOperation {


    public SubtractClass(int leftoprand, int rightoperand) {
        super(leftoprand, rightoperand);
    }

    @Override
    public int GetResult() {
        return this.leftoprand-this.rightoperand;
    }


}
