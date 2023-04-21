public class PrintAllRegisterdCars {
    public static void Print()
    {
        for(int i=0;i<ReadFile3.list3.size();i++)
        {
            System.out.println(ReadFile3.list3.get(i)+"\n\nRegistration No : "+(i+1)+"\n");
        }
    }
}
