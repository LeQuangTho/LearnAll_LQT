namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("DeliveryBill")]
    public partial class DeliveryBill
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public DeliveryBill()
        {
            DetailDeliveries = new HashSet<DetailDelivery>();
        }

        [Key]
        [StringLength(50)]
        public string IdDeliveryBill { get; set; }

        [Required]
        [StringLength(20)]
        public string IdUser { get; set; }

        [Column(TypeName = "date")]
        public DateTime DateCreate { get; set; }

        public long? Total { get; set; }

        public string Note { get; set; }

        public virtual User User { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DetailDelivery> DetailDeliveries { get; set; }
    }
}
