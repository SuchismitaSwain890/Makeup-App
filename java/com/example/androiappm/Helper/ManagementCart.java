package com.example.androiappm.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.androiappm.Domain.MakeupDomain;
import com.example.androiappm.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertMakeup(MakeupDomain item) {
        ArrayList<MakeupDomain> listMakeup = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listMakeup.size(); i++) {
            if (listMakeup.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listMakeup.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listMakeup.add(item);
        }

        tinyDB.putListObject("CardList", listMakeup);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<MakeupDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }

    public void minusNumberMakeup(ArrayList<MakeupDomain> listmakeup, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listmakeup.get(position).getNumberInCart() == 1) {
            listmakeup.remove(position);
        } else {
            listmakeup.get(position).setNumberInCart(listmakeup.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CardList", listmakeup);
        changeNumberItemsListener.changed();
    }

    public void plusNumberMakeup(ArrayList<MakeupDomain> listmakeup, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listmakeup.get(position).setNumberInCart(listmakeup.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CardList", listmakeup);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<MakeupDomain> listmakeup2 = getListCart();
        double fee = 0;
        for (int i = 0; i < listmakeup2.size(); i++) {
            fee = fee + (listmakeup2.get(i).getFee() * listmakeup2.get(i).getNumberInCart());
        }
        return fee;
    }
}
