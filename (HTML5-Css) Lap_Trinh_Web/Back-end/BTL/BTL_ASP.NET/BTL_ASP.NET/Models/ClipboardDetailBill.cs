namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ClipboardDetailBill")]
    public partial class ClipboardDetailBill
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.None)]
        public long IdProductList { get; set; }

        public int? Amount { get; set; }

        [Column(TypeName = "money")]
        public decimal? Price { get; set; }

        public virtual ProductList ProductList { get; set; }
    }
}
