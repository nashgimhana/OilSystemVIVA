/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import pojo.Bank;

/**
 *
 * @author suhada
 */
public class AssetControl {

    private AssetControl() {
    }
    private static AssetControl AssetControl = null;

    public static AssetControl getInstance() {
        if (AssetControl == null) {
            AssetControl = new AssetControl();
        }
        return AssetControl;
    }

    public String updateCashAsset(double amount, char c) {
        m.AssetStatus assetStatus = new m.AssetStatus();
        pojo.AssetStatus Cash = assetStatus.getById(1);
        if (c == '-') {
            Cash.setAmount(Cash.getAmount() - amount);
        } else if (c == '+') {
            Cash.setAmount(Cash.getAmount() + amount);
        }
        return assetStatus.updateAssetStatus(Cash);
    }

    public String updateBankAsset(String bankName, double amount, char c) {
        m.Bank bank = new m.Bank();
        System.out.println("Assest1 :" + amount);
        Bank Bank = bank.getBy(bankName);
        System.out.println("Assest2 :" + amount);
        if (c == '+') {
            Bank.setAmount(Bank.getAmount() + amount);
        } else if (c == '-') {
            Bank.setAmount(Bank.getAmount() - amount);
        }
        return bank.updateBank(Bank);
    }

    public String updateBankAsset(pojo.Bank Bank) {
        return new m.Bank().updateBank(Bank);
    }
}
