package Question5.javaClass;

import Question5.Interface.Report;

public class Canada implements Report {

    @Override
    public String getAgriculture()
{
    return "$50000000 CAD";
}

    public String getManufacturing()
    {
        return "$100000 CAD";
    }

    @Override
    public void PrintGDPReport() {
        System.out.println("- Canada:\n");
        System.out.println("   - Agriculture: " + getAgriculture());
        System.out.println("   - Manufacturing: " + getManufacturing());

    }
}
