namespace BTL_ASP.NET.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    public partial class User
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public User()
        {
            DeliveryBills = new HashSet<DeliveryBill>();
            ReceiptBills = new HashSet<ReceiptBill>();
        }

        [Key]
        [StringLength(20)]
        public string IdUser { get; set; }

        [Required]
        public string NameUser { get; set; }

        [Required]
        public string Email { get; set; }

        [Required]
        [StringLength(20)]
        public string PasswordUser { get; set; }

        [StringLength(10)]
        public string PhoneNumber { get; set; }

        public int IdRoleUser { get; set; }

        [StringLength(50)]
        public string UserStatus { get; set; }

        public bool? Gender { get; set; }

        public string Img { get; set; }

        public string Place { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DeliveryBill> DeliveryBills { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ReceiptBill> ReceiptBills { get; set; }

        public virtual RoleUser RoleUser { get; set; }
    }
}
