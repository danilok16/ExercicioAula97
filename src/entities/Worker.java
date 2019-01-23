/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author dkaus
 */
public class Worker {
    private String id;
    private String name;
    private Double baseSalary;
    private WorkerLevel level;
    private Department department;
    public ArrayList<HourContract> hourContract = new ArrayList();

    public Worker() {
    }

    public Worker(String id, String name, Double baseSalary, WorkerLevel level, Department department) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    

    public Worker(String id, String name, Double baseSalary, WorkerLevel level, Department department, ArrayList<HourContract> hourContract) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
        this.hourContract = hourContract;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public ArrayList<HourContract> getHourContract() {
        return hourContract;
    }

    public void setHourContract(ArrayList<HourContract> hourContract) {
        this.hourContract.add(hourContract.get(0));
    }
    
    
}


