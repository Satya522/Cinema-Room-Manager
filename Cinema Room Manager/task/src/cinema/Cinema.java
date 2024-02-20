package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        char[][] cinema = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                cinema[i][j] = 'S';
            }
        }

        int totalSeats = rows * seats;
        int totalIncome = (totalSeats <= 60) ? totalSeats * 10 : (rows / 2 * seats * 10) + ((rows - rows / 2) * seats * 8);
        int currentIncome = 0;
        int purchasedTickets = 0;

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                printCinema(cinema);
            } else if (choice == 2) {
                while (true) {
                    System.out.println("Enter a row number:");
                    int chosenRow = scanner.nextInt();

                    System.out.println("Enter a seat number in that row:");
                    int chosenSeat = scanner.nextInt();

                    if (chosenRow > rows || chosenSeat > seats || chosenRow < 1 || chosenSeat < 1) {
                        System.out.println("Wrong input!");
                    } else if (cinema[chosenRow - 1][chosenSeat - 1] == 'B') {
                        System.out.println("That ticket has already been purchased!");
                    } else {
                        int ticketPrice = (totalSeats <= 60 || chosenRow <= rows / 2) ? 10 : 8;
                        System.out.println("Ticket price: $" + ticketPrice);

                        cinema[chosenRow - 1][chosenSeat - 1] = 'B';
                        currentIncome += ticketPrice;
                        purchasedTickets++;
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Number of purchased tickets: " + purchasedTickets);
                System.out.printf("Percentage: %.2f%%\n", (double) purchasedTickets / totalSeats * 100);
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income: $" + totalIncome);
            } else if (choice == 0) {
                break;
            }
        }
    }

    private static void printCinema(char[][] cinema) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= cinema[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < cinema.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }
}