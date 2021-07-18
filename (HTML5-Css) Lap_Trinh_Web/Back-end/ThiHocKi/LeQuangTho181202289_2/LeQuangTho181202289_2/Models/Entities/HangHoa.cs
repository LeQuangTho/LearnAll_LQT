namespace LeQuangTho181202289_2.Models.Entities
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

        [Column(TypeName = "numeric")]
        [RegularExpression(@"[1-9][0-9]*", ErrorMessage = "Nhập số")]
        [Range(100, 5000, ErrorMessage = "số lớn hơn 100 và nhỏ hơn 5000")]
        public decimal? Gia { get; set; }

        [StringLength(100)]
        public string Anh { get; set; }

        public virtual LoaiHang LoaiHang { get; set; }
    }
}
