<?php
class Service
{
    function __construct($id_service, $name_service, $description_service, $price_service, $id_species)
    {
        $this->ID_Service = $id_service;
        $this->Name_Service = $name_service;
        $this->Description_Service = $description_service;
        $this->Price_Service = $price_service;
        $this->ID_Species = $id_species;
    }
}