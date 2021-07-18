namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("DetailReceipt")]
    public partial class DetailReceipt
    {
        [Key]
        public int IdDetailReceipt { get; set; }

        [Required]
        [StringLength(50)]
        public string IdReceiptBill { get; set; }

        public long IdProductList { get; set; }

        public int ReceiptCount { get; set; }
       
        public long? Price { get; set; }

        public virtual ProductList ProductList { get; set; }

        public virtual ReceiptBill ReceiptBill { get; set; }
    }
}
