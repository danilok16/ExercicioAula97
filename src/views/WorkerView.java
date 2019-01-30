/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.WorkerController;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author dkaus
 */
public class WorkerView {
    Department department;
    String id, workerName, codeContract;
    Double baseSalary, valuePerHour;
    WorkerLevel level;
    Integer qtdContract, hours;
    Date date;
    Scanner sc = new Scanner(System.in);
    WorkerController workerController = new WorkerController();
    Worker worker;
    int year, month, day;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
   public void addWorkerView(){
        System.out.println("Enter department's name: "); department = new Department(sc.nextLine());
        System.out.println("ID: ");id = sc.nextLine();
        System.out.println("Name: "); workerName = sc.nextLine();
        System.out.println("Level: "); level = WorkerLevel.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Base salary"); baseSalary = sc.nextDouble();
        Worker worker = new Worker(id, workerName, baseSalary, level, department);
        this.workerController.addWorker(worker);
   }
   
   public void addContractView() throws ParseException{
        int cont = 0;
        
        sc.nextLine();
        System.out.println("Id Worker: ");
        worker = this.workerController.getWorker(sc.nextLine());
        if(worker == null){
            System.out.println("Not exists!");
        }
        else{
        System.out.println("How many contracts to this worker: ");  qtdContract = sc.nextInt();
        
        do{ 
            cont++;
            sc.nextLine();
            System.out.println("Enter contract code : ");
            codeContract = sc.nextLine();
            System.out.printf("Enter contract %d data: \n", cont);
            System.out.println("Date(dd/MM/YYYY)");
            date = sdf.parse(sc.next());
           
            System.out.println("Value per hour: ");
            valuePerHour = sc.nextDouble();
            System.out.println("Duration (hours): ");
            hours = sc.nextInt();
            HourContract hourContract = new HourContract(codeContract, date, valuePerHour, hours);
            this.workerController.addContract(worker, hourContract);
        }while(cont != qtdContract);
        }
   } 
   
   public void selectWorkerView(){
        sc.nextLine();
        System.out.println("Id Worker: ");
        worker = this.workerController.getWorker(sc.nextLine());
        if(worker == null){
            System.out.println("Not exists!");
        }
        else{
            System.out.println("Department: "+worker.getDepartment().getName());
            System.out.println("Name: "+worker.getName());
            System.out.println("Level: "+worker.getLevel().toString());
            System.out.println("Base salary: "+worker.getBaseSalary()+"\n");
            if(worker.getHourContract() != null){
            System.out.println("-----------CONTRACTS---------");
            for(HourContract obj: worker.getHourContract()){
                System.out.println("Date: "+obj.getDate());
                 System.out.println("Value per hour: "+obj.getValuePerHour());
                 System.out.println("Duration (hours): "+obj.getHours());
            }
            }
        }
       
   }
   
    public void incomeView(){
        double income; 
        sc.nextLine();
        System.out.println("Id Worker: ");
        worker = this.workerController.getWorker(sc.nextLine());
        if(worker == null){
            System.out.println("Not exists!");
        }
        else{
	System.out.println("Enter month and year to calculate income(MM/YYYY)");
	System.out.println("Month: ");
	month = sc.nextInt();
	System.out.println("Year: ");
	year = sc.nextInt();
	income = workerController.income(worker, year, month);
	System.out.println("Name: "+ worker.getName());
	System.out.println("Department:"+ worker.getDepartment());
	System.out.println("Income: "+ income );
    } 
    }
    
    public void removeContractView(){
        sc.nextLine(); 
        System.out.println("Id Worker: ");
        worker = this.workerController.getWorker(sc.nextLine());
        if(worker == null){
            System.out.println("Not exists!");
        }
        else{
            System.out.println("Enter contract code : ");
            codeContract = sc.nextLine();
            workerController.removeContract(worker, codeContract);
            System.out.println("Removido com sucesso!");
        }
    }
}
