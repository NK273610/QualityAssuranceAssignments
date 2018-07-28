public class MultiplyClass extends MathOperation {


    public MultiplyClass(int leftoprand, int rightoperand) {
        super(leftoprand, rightoperand);
    }

    @Override
    public int GetResult() {
        return this.leftoprand*this.rightoperand;
    }


}
