package com.lqt.duynguyenhairsalon.Model;

public class ItemFavorites {
    private int imageFavorites;
    private String nameFavorites;

    public ItemFavorites(int imageFavorites, String nameFavorites) {
        this.imageFavorites = imageFavorites;
        this.nameFavorites = nameFavorites;
    }

    public int getImageFavorites() {
        return imageFavorites;
    }

    public void setImageFavorites(int imageFavorites) {
        this.imageFavorites = imageFavorites;
    }

    public String getNameFavorites() {
        return nameFavorites;
    }

    public void setNameFavorites(String nameFavorites) {
        this.nameFavorites = nameFavorites;
    }
}
