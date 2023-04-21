import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int mainloop=0,mainloopcheck;

        while(mainloop!=1) {
            System.out.println("enter 2 to make new registration \n enter 3 to check how many cars have been registered till yet \n enter 4 to access parking space \n enter 5 to print all registerd cars \n enter 6 to know which cars have been parked till now");
            int ControleInput = sc.nextInt();
            int x;
            ReadFile3.readFromFile();
            //checking how many vaccant registrations are available
            if(ReadFile3.list3.size()>=250)
            {
                System.out.println("car registrations have been closed becaue parking slots have been full occupied"+ReadFile3.list3.size());
                break;
            }
            else {
                x=250-ReadFile3.list3.size();
            }



//control input 2 for new registrations

            if (ControleInput == 2)
            {

                NewRegistration ob1;

                int loop = 0, loopcheck;
                while (loop != 1) {
                    if(x>0)
                    {
                        x-=1;
                    }
                    else{
                        System.out.println("registrations full");
                        break;
                    }

                    sc.nextLine();
                    String OwnerName, RegNo;
                    System.out.println("Enter your Name: ");
                    OwnerName = sc.nextLine();
                    System.out.println("enter your cars Registration number: ");
                    RegNo = sc.nextLine();
                    LocalDateTime time_of_registration = LocalDateTime.now();
                    ob1 = new NewRegistration(OwnerName, RegNo, time_of_registration);
                    System.out.println("Do you have any further registrations?\n if yes enter 0 \nif no enter 1");
                    loopcheck = sc.nextInt();
                    if (loopcheck == 1) {
                        loop += 1;

                    }
                    ob1.add();


                }

                NewRegistration.writeToFile();
                //NewRegistration.DataofRegisterdCars.clear();


            }


//Control input 3 for how many cars have been parked till yet
            if (ControleInput == 3) {
                ReadFile.readFromFile();
                System.out.println("no of cars registered till now : " + ReadFile.list.size());
            }

//Control input 4 to access cara parking space
            if (ControleInput == 4) {
                ReadFile2.readFromFile();
                sc.nextLine();
                ForParking ob2;
                RegisterdOrNot.parked();
                String CheckRegNo, OwnerName;
                System.out.println("Enter Your car Regno to access parking space");
                CheckRegNo = sc.nextLine();
                if(ReadFile2.list12.contains(CheckRegNo))
                {
                    System.out.println("your car is already parked in the parking area at parking slot "+((ReadFile2.list12.indexOf(CheckRegNo)/3)+1));
                    System.out.println("Returning back to main menue\n\n");
                    continue;
                }
                if (RegisterdOrNot.carregisterd.contains(CheckRegNo)) {
                    int index = RegisterdOrNot.carregisterd.indexOf(CheckRegNo);
                    int indexincr = index - 1;

                    OwnerName = RegisterdOrNot.carregisterd.get(indexincr).toString();
                    System.out.println("you are allowed to park\n");
                    System.out.println("/nDo you want to park your car?\nif yes press 0 \nif not press any other number");
                    int parkcheck=sc.nextInt();
                    if(parkcheck==0) {
                        LocalDateTime time_of_Parked = LocalDateTime.now();
                        ob2 = new ForParking(OwnerName, CheckRegNo, time_of_Parked);
                        System.out.println("You have successfully parked your car in the parking area");
                    }
                    else {
                        System.out.println("Returning back to main menue\n\n");
                        continue;
                    }
                } else {
                    System.out.println("you are not registered in our system, please register first");
                    System.out.println("Returning back to main menue\n\n");
                    continue;
                }
                ForParking.writeToFile2();
            }


//Control input 5 to print all registered cars
            if(ControleInput==5)
            {
                ReadFile3.readFromFile();
                PrintAllRegisterdCars.Print();

            }

//Console input 6 to print all parked cars
            if(ControleInput==6)
            {
                ReadFile2.readFromFile();
                PrintAllParkedCars.Print();

            }

            System.out.println("\n\nenter 0 or any number to go to main menu\nenter 1 to exit carparking system");
            mainloopcheck=sc.nextInt();
            if(mainloopcheck==1)
            {
                mainloop=1;
            }

        }
    }
}
