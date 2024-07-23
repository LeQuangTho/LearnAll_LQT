<?php
class SpeciesProduct
{
    function __construct($id_speciesproduct, $name_speciesproduct, $image_speciesproduct)
    {
        $this->ID_SpeciesProduct = $id_speciesproduct;
        $this->Name_SpeciesProduct = $name_speciesproduct;
        $this->Image_SpeciesProduct = $image_speciesproduct;
    }
}