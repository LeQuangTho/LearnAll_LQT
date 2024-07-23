<?php
class user
{
    function __construct($id_user, $name_user, $phone_number_user, $avatar_user, $username)
    {
        $this->ID_User = $id_user;
        $this->Name_User = $name_user;
        $this->Phone_Number_User = $phone_number_user;
        $this->Avatar_User = $avatar_user;
        $this->UserName  = $username ;
    }
}
