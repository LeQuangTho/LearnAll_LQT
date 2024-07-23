package com.lqt.duynguyenhairsalon.Model;

import java.io.Serializable;

public class SpeciesProduct implements Serializable {
    private int ID_SpeciesProduct;
    private String Name_SpeciesProduct;
    private String Image_SpeciesProduct;

    public SpeciesProduct(int ID_SpeciesProduct, String name_SpeciesProduct, String image_SpeciesProduct) {
        this.ID_SpeciesProduct = ID_SpeciesProduct;
        Name_SpeciesProduct = name_SpeciesProduct;
        Image_SpeciesProduct = image_SpeciesProduct;
    }

    public int getID_SpeciesProduct() {
        return ID_SpeciesProduct;
    }

    public void setID_SpeciesProduct(int ID_SpeciesProduct) {
        this.ID_SpeciesProduct = ID_SpeciesProduct;
    }

    public String getName_SpeciesProduct() {
        return Name_SpeciesProduct;
    }

    public void setName_SpeciesProduct(String name_SpeciesProduct) {
        Name_SpeciesProduct = name_SpeciesProduct;
    }

    public String getImage_SpeciesProduct() {
        return Image_SpeciesProduct;
    }

    public void setImage_SpeciesProduct(String image_SpeciesProduct) {
        Image_SpeciesProduct = image_SpeciesProduct;
    }
}
