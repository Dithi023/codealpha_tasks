import java.util.Scanner;
class Hotel
 {
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    public Hotel(String roomType, double pricePerNight)
     {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
     }
    public String getRoomType()
     {
        return roomType;
     }
    public double getPricePerNight()
     {
        return pricePerNight;
     }
    public boolean isAvailable() 
    {
        return isAvailable;
    }
    public void bookRoom() 
    {
        if (isAvailable) 
        {
            isAvailable = false;
            System.out.println("Booking successful for " + roomType);
        } else
        {
            System.out.println(roomType + " is already booked.");
        }
    }
    public void displayRoomDetails()
     {
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per night: $" + pricePerNight);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Booked"));
    }
    public void processPayment(int nights) 
    {
        if (!isAvailable) 
        {
            System.out.println("Payment for " + roomType + ": $" + (pricePerNight * nights));
        } else 
        {
            System.out.println("Cannot process payment, room is not booked.");
        }
    }
}

public class HotelReservation
{
    private static Scanner scanner = new Scanner(System.in);
    private static Hotel[] rooms =
     {
            new Hotel("Single Room", 100.00),
            new Hotel("Double Room", 150.00),
            new Hotel("Suite", 250.00)
    };
    public static void main(String[] args)
     {
        while (true) 
    {
            System.out.println("\n*** Hotel Reservation System ***");
            System.out.println("1. Book Room");
            System.out.println("2. View Room Details");
            System.out.println("3. Process Payment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice)
             {
                case 1:
                    bookRoom();
                    break;
                case 2:
                    viewRoomDetails();
                    break;
                case 3:
                    processPayment();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
    private static void bookRoom() {
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.length; i++) 
        {
            rooms[i].displayRoomDetails();
        }
        System.out.print("\nEnter room number to book (1-3): ");
        int roomNumber = scanner.nextInt();
        if (roomNumber >= 1 && roomNumber <= 3) 
        {
            rooms[roomNumber - 1].bookRoom();
        } else
        {
            System.out.println("Invalid room number.");
        }
    }
    private static void viewRoomDetails()
     {
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.length; i++) 
        {
            rooms[i].displayRoomDetails();
        }
    }
    private static void processPayment()
     {
        System.out.print("\nEnter room number to pay for (1-3): ");
        int roomNumber = scanner.nextInt();
        if (roomNumber >= 1 && roomNumber <= 3) {
            System.out.print("Enter number of nights: ");
            int nights = scanner.nextInt();
            rooms[roomNumber - 1].processPayment(nights);
        } else
        {
            System.out.println("Invalid room number.");
        }
    }
}