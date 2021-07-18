namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("DetailDelivery")]
    public partial class DetailDelivery
    {
        [Key]
        public int IdDetailDelivery { get; set; }

        [Required]
        [StringLength(50)]
        public string IdDeliveryBill { get; set; }

        public long IdProductList { get; set; }

        public int DeliveryCount { get; set; }

        public virtual DeliveryBill DeliveryBill { get; set; }

        public virtual ProductList ProductList { get; set; }
    }
}
