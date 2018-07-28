public class DivideClass extends MathOperation {


    public DivideClass(int leftoprand, int rightoperand) {
        super(leftoprand, rightoperand);
    }

    @Override
    public int GetResult() {
        return this.leftoprand/this.rightoperand;
    }


}