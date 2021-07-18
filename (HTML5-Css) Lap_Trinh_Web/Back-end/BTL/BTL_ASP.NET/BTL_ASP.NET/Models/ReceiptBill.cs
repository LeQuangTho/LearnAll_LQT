namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ReceiptBill")]
    public partial class ReceiptBill
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public ReceiptBill()
        {
            DetailReceipts = new HashSet<DetailReceipt>();
        }

        [Key]
        [StringLength(50)]
        public string IdReceiptBill { get; set; }

        [Required]
        [StringLength(20)]
        public string IdUser { get; set; }

        public int? IdSupplier { get; set; }

        [Column(TypeName = "date")]
        public DateTime DateCreate { get; set; }

        public long? Total { get; set; }

        public string Note { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DetailReceipt> DetailReceipts { get; set; }

        public virtual Supplier Supplier { get; set; }

        public virtual User User { get; set; }
    }
}
