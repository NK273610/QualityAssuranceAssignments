package Question5.javaClass;

import Question5.Interface.Report;

public class CountryGDPReport {

    Report rep;

    public CountryGDPReport(Report rep) {
        this.rep = rep;
    }

    public void PrintCountryGDPReport()
    {
        System.out.println("GDP By Country:\n");
        rep.PrintGDPReport();
    }
}
