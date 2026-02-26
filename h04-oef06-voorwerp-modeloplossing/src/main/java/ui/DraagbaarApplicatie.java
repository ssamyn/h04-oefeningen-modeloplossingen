package ui;

import domein.DomeinController;

import java.util.Scanner;

public class DraagbaarApplicatie {
    private final DomeinController dc;
    private Scanner invoer;
    private final static String[] KEUZES = {"Voeg wapen toe", "Voeg sleutel toe", "Voeg gebouw toe", "Toon huidig overzicht", "Beëindig deze applicatie"};

    public DraagbaarApplicatie(DomeinController dc) {
        this.dc = dc;
        invoer = new Scanner(System.in);
    }


    public void start() {
        int keuze;
        do {
            keuze = Menu.geefKeuze("MENU", KEUZES);
            boolean gegevensCorrect = false;
            do {
                try {
                    switch (keuze) {
                        case 1 -> voegWapenToe();
                        case 2 -> voegSleutelToe();
                        case 3 -> voegGebouwToe();
                        case 4 -> System.out.printf("%s", dc.geefOverzicht());
                    }
                    gegevensCorrect = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invoer van een ongeldig type!");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!gegevensCorrect);
        } while (keuze != 5);


    }

    private void voegGebouwToe() {
        String naam = vraagNaam();
        System.out.print("Geef de hoogte: ");
        double hoogte = Double.parseDouble(invoer.nextLine());
        dc.voegGebouwToe(naam, hoogte);
    }

    private void voegSleutelToe() {
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef het nummer van de deur: ");
        int deur = Integer.parseInt(invoer.nextLine());
        dc.voegSleutelToe(naam, gewicht, niveau, deur);
    }

    private void voegWapenToe() {
        String naam = vraagNaam();
        System.out.print("Geef het gewicht: ");
        double gewicht = Double.parseDouble(invoer.nextLine());
        System.out.print("Geef het niveau: ");
        int niveau = Integer.parseInt(invoer.nextLine());
        System.out.print("Geef de kracht: ");
        int kracht = Integer.parseInt(invoer.nextLine());
        System.out.print("Werd het wapen reeds gebruikt (true/false)? ");
        boolean gebruikt = Boolean.parseBoolean(invoer.nextLine());
        dc.voegWapenToe(naam, gewicht, niveau, kracht, gebruikt);
    }

    private String vraagNaam() {
        System.out.print("Geef een naam (zonder spaties): ");
        String naam = invoer.nextLine();
        if (naam.contains(" "))
            throw new IllegalArgumentException("Naam mag geen spaties bevatten.");
        return naam;
    }
}