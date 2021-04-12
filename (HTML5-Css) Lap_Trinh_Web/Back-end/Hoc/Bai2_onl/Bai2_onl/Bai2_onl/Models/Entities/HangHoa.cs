namespace Bai2_onl.Models.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("HangHoa")]
    public partial class HangHoa
    {
        [Key]
        public int MaHang { get; set; }

        public int MaLoai { get; set; }

        [Required]
        [StringLength(50)]
        public string TenHang { get; set; }

        public virtual LoaiHang LoaiHang { get; set; }
    }
}
