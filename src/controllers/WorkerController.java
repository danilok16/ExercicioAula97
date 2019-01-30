/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.WorkerDao;
import entities.HourContract;
import entities.Worker;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author dkaus
 */
public class WorkerController {
    WorkerDao workerDao = new WorkerDao();
    HourContractController hourContractController = new HourContractController();
    ArrayList<HourContract> hourContract;
    
    public void addWorker(Worker worker){
        workerDao.insert(worker);
    }
    public void addContract(Worker worker, HourContract hourContract){
        this.hourContract = new ArrayList();
        this.hourContract.add(hourContract);
        worker.setHourContract(this.hourContract);
    }
    
    public Worker selectWorker(String id){
        return workerDao.select(id);
    }
    
    public void removeContract(Worker worker, String codeContract){
        for(HourContract obj : worker.getHourContract()){
            if( codeContract.equals(obj.getCodigo())){
                worker.getHourContract().remove(obj);
                return;
            }
        }
    }
    
    public double income(Worker worker, int year, int month){
        double sum = worker.getBaseSalary();
        Calendar cal = Calendar.getInstance();
 
        for(HourContract obj: worker.getHourContract()){
            cal.setTime(obj.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);  
            if(year == c_year && month == c_month)
                sum += hourContractController.totalValue(obj);
        }
        return sum;
    }
    
    public Worker getWorker(String id){
        return workerDao.select(id);
    }
}
