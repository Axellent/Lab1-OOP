package source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Author: Gustav Ernstsson
public class Main {
    public static void main(String[] args) {
        System.out.println("Food4fun application created by Axel Sigl, Jesper Johansson and Gustav Ernstsson.");
        mainMenu();
    }
    
    //Author: Gustav Ernstsson & Axel Sigl
     private static void mainMenu(){
        boolean closeMenu = false;
        String consoleInputInt = "";
        Scanner in = new Scanner(System.in);
        Register register = new Register();
        
        register.loadProductRegistry();
        register.setTotalPurchases(register.getSavedPurchase().loadNPurchases());
        
        while(!closeMenu){
            //TODO: Clear console
            System.out.println("V�lj ett av f�ljande alternativ:");
            System.out.println("1. Registrera nytt k�p");
            System.out.println("2. Ber�kna total f�rs�ljning f�r period");
            System.out.println("3. Nollst�ll total f�rs�ljning");
            System.out.println("4. Spara och avsluta");

            try {
                consoleInputInt = in.next();
                if(consoleInputInt.equals("1")){
                    createNewPurchase(register);
                }
                else if(consoleInputInt.equals("2")){
                    calculateTotalSale(register);
                }
                else if(consoleInputInt.equals("3")){
                    resetTotalSales(register);
                }
                else if(consoleInputInt.equals("4")){
                    saveAndClose(register);
                    closeMenu = true;
                }
                else{
                    System.out.println("V�lj ett alternativ fr�n 1-4.");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
     
    //Author: Gustav Ernstsson & Axel Sigl
    private static void createNewPurchase(Register register) {
        Purchase purchase = new Purchase();
        Scanner in = new Scanner(System.in);
        boolean closeMenu = false;
        String consoleInputMenu;
        String consoleInput;
        int consoleInputInt = 0;
        
        while(!closeMenu){
            //Clearing console
            System.out.println("V�lj ett av f�ljande alternativ:");
            System.out.println("1. L�gg till en existerande produkt(kr�ver EAN) i k�pet.");
            System.out.println("2. Skapa en ny produkt och l�gg till i k�pet.");
            System.out.println("3. Skriv in en rabattkod till k�pet.");
            System.out.println("4. Avsluta k�p och �terg� till huvudmenyn.");

            try {
                consoleInputMenu = in.next();
                if(consoleInputMenu.equals("1")){
                    Product product = new Product();
                    
                    System.out.println("Skriv EAN-koden av produkten du vill l�gga till.");
                    consoleInputInt = in.nextInt();
                    product = register.getProductRegistry().getProductFromReg(consoleInputInt);
                    
                    if(product != null){
                        register.getPurchase().addProduct(product);
                        System.out.println("Har lagt till " + product.getDescr()+ " i k�pet.");
                    }
                    else{
                        System.out.println("Hittar ingen produkt med det EAN numret.");
                        closeMenu = true;
                    }
                }
                else if(consoleInputMenu.equals("2")){
                    Product product = new Product();
                    boolean closeEANMenu = false;
                    
                    while(!closeEANMenu){
                        System.out.println("Vilket EAN nummer ska produkten ha?");
                        consoleInputInt = in.nextInt();
                        
                        if(register.getProductRegistry().getProductFromReg(consoleInputInt) != null){
                            System.out.println("Finns redan en produkt med det EAN numret. Ange ett nytt nummer.");
                        }
                        else{
                            closeEANMenu = true;
                        }
                    }
                    product.setEAN(consoleInputInt);
                    
                    System.out.println("Vilken beskrivning ska produkten ha?");
                    consoleInput = in.next();
                    product.setDescr(consoleInput);           
                    
                    System.out.println("Vilket pris ska produkten ha?");
                    consoleInputInt = in.nextInt();
                    product.setPrice(consoleInputInt);
                    
                    register.getPurchase().addProduct(product);
                    System.out.println("Har lagt till " + product.getDescr()+ " i k�pet.");
                }
                else if(consoleInputMenu.equals("3")){
                    String code;
                    
                    System.out.println("Ange rabattkoden.");
                    code = in.next();
                    
                    register.getDiscountRegistry().calcDiscount(purchase, code);
                }
                else if(consoleInputMenu.equals("4")){
                    register.finishPurchase();
                    closeMenu = true;
                }
                else{
                    System.out.println("V�lj ett alternativ fr�n 1-3.");
                }
            } 
            catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    //Author: Gustav Ernstsson
    private static void calculateTotalSale(Register register) {
        if(register.getTotalPurchases() > 0){
            double totalSale = 0;
            Purchase[] purchases = register.getPurchases();
            for(Purchase p : purchases){
                totalSale += p.getTotalPrice();
            }
            System.out.println("Total f�rs�ljning f�r denna period �r: " + totalSale);
        }
        else{
            System.out.println("Finns inga k�p att r�kna f�r denna period.");
        }
    }

    //Author: Gustav Ernstsson & Axel Sigl
    private static void saveAndClose(Register register) {
        register.getSavedPurchase().saveNPurchases(register.getTotalPurchases());
        System.out.println("V�lkommen �ter");
    }

    //Author: Gustav Ernstsson
    private static void resetTotalSales(Register register) {
        register.resetPurchases();
        System.out.println("�terst�llt alla k�p f�r denna period.");
    }
}
