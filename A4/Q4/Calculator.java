public class Calculator {

    public static int Divide(int left, int right)
    {
        MathOperation op = new DivideClass(left,right);
        return op.GetResult();
    }

    public static int Multiply(int left, int right)
    {
        MathOperation op = new MultiplyClass(left,right);
        return op.GetResult();
    }

    public static int Add(int left, int right)
    {
        MathOperation op = new AddClass(left,right);
        return op.GetResult();
    }

    public static int Subtract(int left, int right)
    {
        MathOperation op = new SubtractClass(left,right);
        return op.GetResult();
    }
}