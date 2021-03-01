using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaiTap1.Models
{
    public class Login
    {
        [Required(ErrorMessage ="Chưa nhập username")]
        public string username { get; set; }
        [Required(ErrorMessage = "Chưa nhập password")]
        public string password { get; set; }
    }
}