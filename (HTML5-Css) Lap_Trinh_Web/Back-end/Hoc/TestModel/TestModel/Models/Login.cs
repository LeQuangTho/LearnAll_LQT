using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace TestModel.Models
{
    public class Login
    {
        [Required(ErrorMessage = "Please enter username")]
        public string username { get; set; }
        [Required]
        public string password { get; set; }
    }
}