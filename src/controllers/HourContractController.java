/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.HourContract;

/**
 *
 * @author dkaus
 */
public class HourContractController {
    
    public double totalValue(HourContract hourContract){
        return hourContract.getHours() * hourContract.getValuePerHour();
    }
    
}
