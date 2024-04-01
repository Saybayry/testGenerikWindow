package claasses;

import DAO.GenericDAO;

public class saleItem implements GenericItems {
    private warehouse Item;
    private int quality;

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public warehouse getItem() {
        return Item;
    }

    public void setItem(warehouse item) {
        Item = item;
    }


}
