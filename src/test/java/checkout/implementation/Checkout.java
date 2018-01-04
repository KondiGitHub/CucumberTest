package checkout.implementation;


import java.util.HashMap;
import java.util.Map;

public class Checkout {

    Map<String,Integer> itemDetails = new HashMap<String,Integer>();
    Map<String,Integer> itemCountDetails = new HashMap<String,Integer>();
    public int getTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String,Integer> entry : itemDetails.entrySet()){
            int itemCount = itemCountDetails.get(entry.getKey());
            totalPrice = totalPrice + (itemCount * entry.getValue());
        }
        return totalPrice;
    }

    public int getTotalItemPrice(String itemName) {
        int totalPrice = 0;
        int itemCount = itemCountDetails.get(itemName);
        int itemPrice = itemDetails.get(itemName);
        totalPrice = totalPrice + (itemCount * itemPrice);
        return totalPrice;
    }
    public void addItem(String itemName, int itemPrice) {
        itemDetails.put(itemName,itemPrice);
    }

    public void add(int itemCount, String itemName) {
        itemCountDetails.put(itemName,itemCount);
    }

    public int getItemPrice(String itemName) {
        return itemDetails.get(itemName);
    }
}
