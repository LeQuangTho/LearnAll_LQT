package com.lqt.duynguyenhairsalon.Model;

public class ProductDuyNguyenHairSalon {
    private int ID_Product;
    private String Name_Product;
    private int Price_Product;
    private int Amount_Product;
    private String Info_Product;
    private String Description_Product;
    private String Using_Product;
    private String Image_Product;
    private int ID_Species_Product;
    private String ID_Producer;

    public ProductDuyNguyenHairSalon(int ID_Product, String name_Product, int price_Product, int amount_Product, String info_Product, String description_Product, String using_Product, String image_Product, int ID_Species_Product, String ID_Producer) {
        this.ID_Product = ID_Product;
        Name_Product = name_Product;
        Price_Product = price_Product;
        Amount_Product = amount_Product;
        Info_Product = info_Product;
        Description_Product = description_Product;
        Using_Product = using_Product;
        Image_Product = image_Product;
        this.ID_Species_Product = ID_Species_Product;
        this.ID_Producer = ID_Producer;
    }

    public int getID_Product() {
        return ID_Product;
    }

    public void setID_Product(int ID_Product) {
        this.ID_Product = ID_Product;
    }

    public String getName_Product() {
        return Name_Product;
    }

    public void setName_Product(String name_Product) {
        Name_Product = name_Product;
    }

    public int getPrice_Product() {
        return Price_Product;
    }

    public void setPrice_Produce(int price_Product) {
        Price_Product = price_Product;
    }

    public int getAmount_Product() {
        return Amount_Product;
    }

    public void setAmount_Product(int amount_Product) {
        Amount_Product = amount_Product;
    }

    public String getInfo_Product() {
        return Info_Product;
    }

    public void setInfo_Product(String info_Product) {
        Info_Product = info_Product;
    }

    public String getDescription_Product() {
        return Description_Product;
    }

    public void setDescription_Product(String description_Product) {
        Description_Product = description_Product;
    }

    public String getUsing_Product() {
        return Using_Product;
    }

    public void setUsing_Product(String using_Product) {
        Using_Product = using_Product;
    }

    public String getImage_Product() {
        return Image_Product;
    }

    public void setImage_Product(String image_Product) {
        Image_Product = image_Product;
    }

    public int getID_Species_Product() {
        return ID_Species_Product;
    }

    public void setID_Species_Product(int ID_Species_Product) {
        this.ID_Species_Product = ID_Species_Product;
    }

    public String getID_Producer() {
        return ID_Producer;
    }

    public void setID_Producer(String ID_Producer) {
        this.ID_Producer = ID_Producer;
    }
}
