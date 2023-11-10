/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.TaxDao;

/**
 *
 * @author THAO LINH
 */
public class TaxRepository implements ITaxRepository{

    @Override
    public double calcalateTaxIncome() {
        return TaxDao.Instance().calcalateTaxIncome();
    }
    
}
