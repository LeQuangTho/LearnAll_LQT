<?php
class Producer
{
    function __construct(
        $id_producer,
        $name_brand,
        $origin
    ) {
        $this->ID_Producer = $id_producer;
        $this->Name_Brand = $name_brand;
        $this->Origin = $origin;
    }
}
