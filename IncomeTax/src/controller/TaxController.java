/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.ITaxRepository;
import repository.TaxRepository;
import view.Menu;

/**
 *
 * @author THAO LINH
 */
public class TaxController extends Menu<String> {

    private final ITaxRepository taxRepository;
    static String[] op = {"Calculate Tax", "Exit"};

    public TaxController() {
        super("Calculate", op);
        taxRepository = new TaxRepository();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.print("Tax income: " + taxRepository.calcalateTaxIncome());
                break;
            case 2:
                System.exit(0);
        }
    }

}
