package com.example.fooddeleivery.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.fooddeleivery.Domain.FoodDomain;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);

    }

    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> ListFood = getListCart();
                boolean existAlready = false;
                int n=0;
                for(int i=0; i<ListFood.size();i++){
                    if(ListFood.get(i).getTitle().equals(item.getTitle())){
                        existAlready = true;
                        n=i;
                        break;
                    }
                }

                if(existAlready){
                    ListFood.get(n).setNumberInCart(item.getNumberInCart());
                }else{
                    ListFood.add(item);
                }
                tinyDB.putListObject("CardList" , ListFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }
}
