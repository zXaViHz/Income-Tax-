/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.Validation;
import java.util.ArrayList;
import model.Children;
import model.Dependent;
import model.Parent;

/**
 *
 * @author THAO LINH
 */
public class TaxDao {

    private static TaxDao instance = null;

    public static TaxDao Instance() {
        if (instance == null) {
            synchronized (TaxDao.class) {
                if (instance == null) {
                    instance = new TaxDao();
                }
            }
        }
        return instance;
    }

    Validation va  = new Validation();

    ArrayList<Children> cList = new ArrayList<>();
    ArrayList<Parent> pList = new ArrayList<>();

    public Dependent inputDependent() {
        double income = va.getDouble("Input income");
        int numChildren = va.getInt("Input number of children");
        for (int i = 0; i < numChildren; i++) {
            int age = va.getInt("Input age");
            boolean n = va.checkYN("Are your children studing ?(Y||N)");
            Children c = new Children(age, n);
            cList.add(c);
        }
        int numParent = va.getInt("Input number of parentcare");
        for (int i = 0; i < numParent; i++) {
            int age = va.getInt("Input age");
            Parent p = new Parent(age);
            pList.add(p);
        }
        Dependent d = new Dependent(income, cList, pList);
        return d;
    }

    public double deductionChildren(ArrayList<Children> c) {
        int countBelow18 = 0;
        int countAbove18S = 0;
        int countAbove18NS = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i).getAge() < 18) {
                countBelow18++;
            } else if (c.get(i).getAge() > 18 && c.get(i).getStatus() == true) {
                countAbove18S++;
            } else {
                countAbove18NS++;
            }
        }
        if (c.size() == 1) {
            if (c.get(0).getAge() < 18) {
                return 4400000;
            } else {
                if (c.get(0).getStatus() == true) {
                    return 6000000;
                } else {
                    return 0;
                }
            }
        } else if (c.size() == 2) {
            if (countAbove18NS == 2) {
                return 0;
            } else if (countAbove18NS == 1 && countAbove18S == 1) {
                return 6000000;
            } else if (countAbove18S == 2) {
                return 12000000;
            }
        } else {
            return 0;
        }
        return 0;
    }

    public double deductionParent(ArrayList<Parent> p) {
        int count = 0;
        for (int idx = 0; idx < p.size(); idx++) {
            if (p.get(idx).getAge() < 60) {
                count++;
            }
        }
        count = count * 4400000;
        return count;
    }

    public double calcalateTaxIncome() {
        Dependent d = inputDependent();
        double income = d.getIncome();
        double incomeExempt;
        double deductionParent = deductionParent(d.getParent());
        double deductionChil = deductionChildren(d.getChildren());
        if (income > 110000) {
            incomeExempt = income - 11000000 - deductionParent - deductionChil;
            if (incomeExempt < 4000000) {
                return 0;
            } else if (incomeExempt > 4000000 && incomeExempt < 6000000) {
                return incomeExempt * 0.05;
            } else if (incomeExempt > 6000000 && incomeExempt < 10000000) {
                return incomeExempt * 0.1;
            } else {
                return incomeExempt * 0.2;
            }
        } else {
            return 0;
        }
    }
}
