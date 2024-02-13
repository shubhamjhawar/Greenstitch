# Parking Lot Controller

This project includes a simple parking lot controller implemented in Java. It allows users to interact with a parking lot through a console-based interface.

## How to Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/shubhamjhawar/Greenstitch.git
   cd Greenstitch

2.  javac -cp . src/main/java/com/example/greenstitch/Controller/ParkingLotController.java
3.  java -cp . src/main/java/com/example/greenstitch/Controller/ParkingLotController ```

   
## Follow Console Instructions:

The controller will prompt you with a $: symbol.
Enter commands following the specified format.

#### Available Commands:

  ###### a)create_parking_lot <capacity>: Create a parking lot with the specified capacity.
  ###### b)park <registrationNumber> <color>: Park a car with the given registration number and color.
  ###### c)leave <slotNumber>: Vacate the parking slot with the specified slot number.
  ###### d)status: View the current status of the parking lot.
  ###### e)registration_numbers_for_cars_with_colour <color>: Get registration numbers of cars with the specified color.
  ###### f)exit: Exit the program.
   
Note:

Ensure you have Java installed on your machine.
The program will continue to run until you enter the exit command

#### Dependencies
Java (JDK 8 or higher)

