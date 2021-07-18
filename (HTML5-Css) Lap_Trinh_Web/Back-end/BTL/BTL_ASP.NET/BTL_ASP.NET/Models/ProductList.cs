namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ProductList")]
    public partial class ProductList
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public ProductList()
        {
            DetailDeliveries = new HashSet<DetailDelivery>();
            DetailReceipts = new HashSet<DetailReceipt>();
            Products = new HashSet<Product>();
        }

        [Key]
        public long IdProductList { get; set; }

        [Required]
        public string ProductName { get; set; }

        public string Detail { get; set; }

        public int? ProductCount { get; set; }

        [StringLength(10)]
        public string Unit { get; set; }

        public long IdProductCategory { get; set; }

        public virtual ClipboardDetailBill ClipboardDetailBill { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DetailDelivery> DetailDeliveries { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DetailReceipt> DetailReceipts { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<Product> Products { get; set; }

        public virtual ProductCategory ProductCategory { get; set; }
    }
}
