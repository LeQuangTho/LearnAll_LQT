using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaiTap1.Models
{
    public class User
    {
        public User(int ID, string Name, string Address, string Email)
        {
            this.id = ID;
            this.name = Name;
            this.address = Address;
            this.email = Email;
        }

        public User()
        {
            
        }
        [Required]
        public int id { get; set; }
        [Required]
        public string name { get; set; }
        [Required]
        public string address { get; set; }
        [Required]
        public string email { get; set; }

    }
}