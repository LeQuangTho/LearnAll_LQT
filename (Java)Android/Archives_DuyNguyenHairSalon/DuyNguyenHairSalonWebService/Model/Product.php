<?php
class Product
{
    function __construct(
        $id_product,
        $name_product,
        $price_product,
        $amount_product,
        $info_product,
        $description_product,
        $using_product,
        $image_product,
        $id_speciesProduct,
        $id_producer
    ) {
        $this->ID_Product = $id_product;
        $this->Name_Product = $name_product;
        $this->Price_Product = $price_product;
        $this->Amount_Product = $amount_product;
        $this->Info_Product = $info_product;
        $this->Description_Product = $description_product;
        $this->Using_Product = $using_product;
        $this->Image_Product = $image_product;
        $this->ID_SpeciesProduct = $id_speciesProduct;
        $this->ID_Producer = $id_producer;
    }
}
