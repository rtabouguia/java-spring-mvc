/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.*;

/**
 *
 * @author RAISA
 */
public class UserBalanceForm {

    @Min(value=1, message="le montant que vous souhaitez ajouter doit être positif")
     @NotNull(message = "Le champs 'montant' est obligatoire")
    private Double balance;

   public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
        
    
}
