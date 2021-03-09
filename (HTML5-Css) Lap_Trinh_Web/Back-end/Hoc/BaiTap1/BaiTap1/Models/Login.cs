using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace BaiTap1.Models
{
    public class Login
    {
        [StringLength(16, MinimumLength = 8),
        Required(ErrorMessage ="Chưa nhập username")]
        public string username { get; set; }
        [Required(ErrorMessage = "Chưa nhập password")]
        public string password { get; set; }
    }
}