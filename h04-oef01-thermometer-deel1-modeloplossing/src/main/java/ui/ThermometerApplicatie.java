package ui;

import domein.DomeinController;

import java.util.Scanner;

public class ThermometerApplicatie {
    private DomeinController dc;

    public ThermometerApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        final int lowest = 14;
        final int highest = 104;
        Scanner s = new Scanner(System.in);
        int tempF, tempC;
        boolean invoerOK = false;
        do {
            try {
                System.out.printf("Geef een gehele temperatuur in °F uit het interval [%d, %d]: ", lowest, highest);
                tempF = Integer.parseInt(s.nextLine());

                if (tempF < lowest || tempF > highest)
                    throw new IllegalArgumentException
                            (String.format("Waarde van temperatuur moet uit het interval [%d, %d] komen!", lowest, highest));

                dc.updateTemperatuur(tempF);
                tempC = dc.geefTemperatuurInCelsius();

                System.out.printf("De temperatuur in °C is %d%n", tempC);
                invoerOK = true;
            } catch (NumberFormatException nfe) {
                System.out.println("De invoer moet een geheel getal zijn!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while (!invoerOK);
    }
}