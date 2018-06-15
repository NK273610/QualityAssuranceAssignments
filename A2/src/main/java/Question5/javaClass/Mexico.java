package Question5.javaClass;

import Question5.Interface.Report;

public class Mexico implements Report {

    @Override
    public String getAgriculture()
    {
        return "$50000000 MXN";
    }

    public String getTourism()
    {
        return "$100000 MXN";
    }

    @Override
    public void PrintGDPReport() {

        System.out.println("- Mexico:\n");
        System.out.println("   - Agriculture: " + getAgriculture());
        System.out.println("   - Tourism: " + getTourism());
            }
}
