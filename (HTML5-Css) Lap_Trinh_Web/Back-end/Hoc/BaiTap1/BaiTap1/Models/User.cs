using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaiTap1.Models
{
    public class User
    {
        public User(int ID, string Name, string Address, string Email, string Password, string ReenterPassword)
        {
            this.id = ID;
            this.name = Name;
            this.address = Address;
            this.email = Email;
            this.password = Password;
            this.reenterpassword = ReenterPassword;
        }

        public User()
        {
            
        }
        [Required]
        public int id { get; set; }
        [Required]
        public string name { get; set; }
        [DataType(DataType.MultilineText),Required]
        public string address { get; set; }
        [RegularExpression(@"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,4}")]
        public string email { get; set; }
        [Required]
        public string password { get; set; }
        [Compare("password", ErrorMessage = "aaaa")]
        public string reenterpassword { get; set; }
    }
}