using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace TestModel.Models.Entity
{
    public partial class QLHangHoa_Context : DbContext
    {
        public QLHangHoa_Context()
            : base("name=MyModel")
        {
        }

        public virtual DbSet<HangHoa> HangHoas { get; set; }
        public virtual DbSet<LoaiHang> LoaiHangs { get; set; }
        public virtual DbSet<tblAccount> tblAccounts { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<LoaiHang>()
                .HasMany(e => e.HangHoas)
                .WithRequired(e => e.LoaiHang)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<tblAccount>()
                .Property(e => e.Username)
                .IsFixedLength();

            modelBuilder.Entity<tblAccount>()
                .Property(e => e.Password)
                .IsFixedLength();
        }
    }
}
