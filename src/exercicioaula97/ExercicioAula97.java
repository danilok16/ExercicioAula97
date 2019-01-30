/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicioaula97;

import java.text.ParseException;
import java.util.Scanner;
import views.MainMenuView;
import views.WorkerView;

/**
 *
 * @author dkaus
 */
public class ExercicioAula97 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        int resp;
        Scanner sc = new Scanner(System.in);
        MainMenuView mainMenu = new MainMenuView();
        WorkerView workerView = new WorkerView();
        
        do{
           mainMenu.mainMenu();
           resp = sc.nextInt();
           switch(resp){
               case 1: workerView.addWorkerView();
               break;
               case 2: workerView.addContractView();
               break;
               case 3: workerView.selectWorkerView();
               break;
               case 4: workerView.incomeView();
               break;
               case 5 : workerView.removeContractView();
               break;
           }
          sc.nextLine();
        }while(resp != 6);
     
    }
    
}
