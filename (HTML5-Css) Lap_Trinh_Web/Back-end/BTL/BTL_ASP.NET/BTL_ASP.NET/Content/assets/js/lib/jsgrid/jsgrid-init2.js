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
                    { name: "Mã hóa đơn", type: "Text", width: 70 },
                    { name: "Nhân viên lập", type: "Text", width: 120 },
                    { name: "Ngày lập", type: "Text", width: 70 },
                    { name: "Loại hóa đơn", type: "Text", width: 70 },
                    { name: "Ghi chú", type: "Text",width: 120 },
                    { type: "control" }
                ]
            });

        });