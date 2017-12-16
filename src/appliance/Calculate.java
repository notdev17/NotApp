package appliance;

/**
 * Created by Devon on 12/9/2017
 */
/*DEVON
  Simulates a static class that will perform all necessary calculations on Appliance types
  for our application.
 */
/*
Declare your class final - Prevents extension of the class since extending a static class makes no sense
Make the constructor private - Prevents instantiation by client code as it makes no sense to instantiate a static class
Make all the members and functions of the class static - Since the class cannot be instantiated no instance methods can be called or instance fields accessed
Note that the compiler will not prevent you from declaring an instance (non-static) member. The issue will only show up if you attempt to call the instance member
*/
//Cooling_Capacity__BTU_Hour__d,Electrical_Power_Input__Watts__d,Combined_Energy_Efficiency_Ratio_d,Energy_Efficiency_Ratio_d
final public class Calculate {

    static double costPerYear(Appliance a, double hrsPerDay, double daysPerWeek) {
        double kwh = a.getEnergy();
        double hrsPerYear = hrsPerDay * daysPerWeek * 4 * 12; //(hr/day * day/week) * week/month * month/year
        return kwh * hrsPerYear;
    }
}
