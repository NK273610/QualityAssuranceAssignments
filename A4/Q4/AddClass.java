public class AddClass extends MathOperation {


    public AddClass(int leftoprand, int rightoperand) {
        super(leftoprand, rightoperand);
    }

    @Override
    public int GetResult() {
        return this.leftoprand+this.rightoperand;
    }


}
