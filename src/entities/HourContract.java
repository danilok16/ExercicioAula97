/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author dkaus
 */
public class HourContract {
    private String codigo;
    private Date date;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(String codigo, Date date, Double valuePerHour, Integer hours) {
        this.codigo = codigo;
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
    
    
    
    
}
