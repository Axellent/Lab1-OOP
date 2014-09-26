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
            System.out.println("Välj ett av följande alternativ:");
            System.out.println("1. Registrera nytt köp");
            System.out.println("2. Beräkna total försäljning för period");
            System.out.println("3. Nollställ total försäljning");
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
                    System.out.println("Välj ett alternativ från 1-4.");
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
            System.out.println("Välj ett av följande alternativ:");
            System.out.println("1. Lägg till en existerande produkt(kräver EAN) i köpet.");
            System.out.println("2. Skapa en ny produkt och lägg till i köpet.");
            System.out.println("3. Skriv in en rabattkod till köpet.");
            System.out.println("4. Avsluta köp och återgå till huvudmenyn.");

            try {
                consoleInputMenu = in.next();
                if(consoleInputMenu.equals("1")){
                    Product product = new Product();
                    
                    System.out.println("Skriv EAN-koden av produkten du vill lägga till.");
                    consoleInputInt = in.nextInt();
                    product = register.getProductRegistry().getProductFromReg(consoleInputInt);
                    
                    if(product != null){
                        register.getPurchase().addProduct(product);
                        System.out.println("Har lagt till " + product.getDescr()+ " i köpet.");
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
                    System.out.println("Har lagt till " + product.getDescr()+ " i köpet.");
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
                    System.out.println("Välj ett alternativ från 1-3.");
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
            System.out.println("Total försäljning för denna period är: " + totalSale);
        }
        else{
            System.out.println("Finns inga köp att räkna för denna period.");
        }
    }

    //Author: Gustav Ernstsson & Axel Sigl
    private static void saveAndClose(Register register) {
        register.getSavedPurchase().saveNPurchases(register.getTotalPurchases());
        System.out.println("Välkommen åter");
    }

    //Author: Gustav Ernstsson
    private static void resetTotalSales(Register register) {
        register.resetPurchases();
        System.out.println("Återställt alla köp för denna period.");
    }
}
