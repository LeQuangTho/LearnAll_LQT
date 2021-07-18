namespace LeQuangTho181202289_2.Models.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("tblAccount")]
    public partial class tblAccount
    {
        [Key]
        public int Uid { get; set; }

        [StringLength(10)]
        public string Username { get; set; }

        [StringLength(10)]
        public string Password { get; set; }
    }
}
