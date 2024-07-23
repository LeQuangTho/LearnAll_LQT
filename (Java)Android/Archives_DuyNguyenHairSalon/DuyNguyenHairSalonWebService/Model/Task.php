<?php
class Task
{
    function __construct(
        $id_task,
        $date_task,
        $sum_money_task,
        $is_save_photo,
        $is_consulting,
        $is_successful_task,
        $service_free,
        $id_user,
        $name_user,
        $phone_number_user,
        $array_service
    ) {
        $this->ID_Task = $id_task;
        $this->Date_Task = $date_task;
        $this->Sum_Money_Task = $sum_money_task;
        $this->Is_Save_Photo = $is_save_photo;
        $this->Is_Consulting = $is_consulting;
        $this->Is_Successful_Task = $is_successful_task;
        $this->Service_Free = $service_free;
        $this->ID_User = $id_user;
        $this->Name_User = $name_user;
        $this->Phone_Number_User = $phone_number_user;
        $this->Array_Service = $array_service;
    }
}