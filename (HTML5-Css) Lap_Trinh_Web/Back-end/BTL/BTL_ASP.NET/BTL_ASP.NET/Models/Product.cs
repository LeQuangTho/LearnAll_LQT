namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Product")]
    public partial class Product
    {
        [Key]
        [StringLength(20)]
        public string IdProduct { get; set; }

        [Required]
        public string ProductName { get; set; }

        [StringLength(10)]
        public string ProductStatus { get; set; }

        public string Img { get; set; }

        public long? IdProductList { get; set; }

        public virtual ProductList ProductList { get; set; }
    }
}
