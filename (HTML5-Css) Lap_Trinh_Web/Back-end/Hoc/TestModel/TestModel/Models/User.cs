using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace TestModel.Models
{
    public class User
    {
        [Range(0,Int64.MaxValue,ErrorMessage = "Id must be greater than 0")]
        public int Id { get; set; }
        [Required(ErrorMessage = "Please enter Name attribute")]
        [StringLength(10,MinimumLength =1,ErrorMessage = "Your name must be between 1 and 10")]
        public String Name { get; set; }
        [Required(ErrorMessage = "Please enter Email attribute")]
        [DataType(DataType.Password)]
        public String Email { get; set; }
    }
}