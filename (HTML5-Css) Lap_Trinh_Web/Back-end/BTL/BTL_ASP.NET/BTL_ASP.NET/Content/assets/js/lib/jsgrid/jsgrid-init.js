        $(function() {

            $("#jsGrid").jsGrid({
                height: "100%",
                width: "100%",
                filtering: false,
                editing: true,
                inserting: true,
                sorting: true,
                paging: true,
                autoload: true,
                pageSize: 15,
                pageButtonCount: 5,
                deleteConfirm: "Bạn có muốn xác nhận xóa sản phẩm này không?",
                controller: db,
                fields: [
                    { name: "Mã hàng", type: "text", width: 50 },
                    { name: "Tên hàng", type: "Text", width: 150 },
                    { name: "Số Lượng", type: "number", width: 70 },
                    { name: "Đơn vị tính", type: "select", items: db.unit, valueField: "Id", textField: "Name" },
                    { name: "Trạng thái", type: "checkbox", title: "Sell", sorting: false },
                    { type: "control" }
                ]
            });

        });