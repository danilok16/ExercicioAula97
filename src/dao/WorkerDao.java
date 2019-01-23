/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Worker;
import java.util.ArrayList;

/**
 *
 * @author dkaus
 */
public class WorkerDao {
    ArrayList<Worker> workerList = new ArrayList();
    
    public void insert(Worker worker){
        workerList.add(worker);
       
    }
    
    public Worker select(String id){
        System.out.println(id);
         for(Worker obj: workerList){
            if(id.equals(obj.getId())){
                return obj;
            }
         }
         return null;
    }
   
}
    
