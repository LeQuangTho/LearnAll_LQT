using System;
using System.ComponentModel.DataAnnotations.Schema;
using System.Data.Entity;
using System.Linq;

namespace BTL_ASP.NET.Models
{
    public partial class ModelQuanLyKho : DbContext
    {
        public ModelQuanLyKho()
            : base("name=ModelQuanLyKho")
        {
        }

        public virtual DbSet<ClipboardDetailBill> ClipboardDetailBills { get; set; }
        public virtual DbSet<DeliveryBill> DeliveryBills { get; set; }
        public virtual DbSet<DetailDelivery> DetailDeliveries { get; set; }
        public virtual DbSet<DetailReceipt> DetailReceipts { get; set; }
        public virtual DbSet<Product> Products { get; set; }
        public virtual DbSet<ProductCategory> ProductCategories { get; set; }
        public virtual DbSet<ProductList> ProductLists { get; set; }
        public virtual DbSet<ReceiptBill> ReceiptBills { get; set; }
        public virtual DbSet<RoleUser> RoleUsers { get; set; }
        public virtual DbSet<Supplier> Suppliers { get; set; }
        public virtual DbSet<sysdiagram> sysdiagrams { get; set; }
        public virtual DbSet<User> Users { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ClipboardDetailBill>()
                .Property(e => e.Price)
                .HasPrecision(19, 4);

            modelBuilder.Entity<DeliveryBill>()
                .HasMany(e => e.DetailDeliveries)
                .WithRequired(e => e.DeliveryBill)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<ProductCategory>()
                .HasMany(e => e.ProductLists)
                .WithRequired(e => e.ProductCategory)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<ProductList>()
                .HasOptional(e => e.ClipboardDetailBill)
                .WithRequired(e => e.ProductList);

            modelBuilder.Entity<ProductList>()
                .HasMany(e => e.DetailDeliveries)
                .WithRequired(e => e.ProductList)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<ProductList>()
                .HasMany(e => e.DetailReceipts)
                .WithRequired(e => e.ProductList)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<ReceiptBill>()
                .HasMany(e => e.DetailReceipts)
                .WithRequired(e => e.ReceiptBill)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<RoleUser>()
                .HasMany(e => e.Users)
                .WithRequired(e => e.RoleUser)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<User>()
                .HasMany(e => e.DeliveryBills)
                .WithRequired(e => e.User)
                .WillCascadeOnDelete(false);

            modelBuilder.Entity<User>()
                .HasMany(e => e.ReceiptBills)
                .WithRequired(e => e.User)
                .WillCascadeOnDelete(false);
        }
    }
}
