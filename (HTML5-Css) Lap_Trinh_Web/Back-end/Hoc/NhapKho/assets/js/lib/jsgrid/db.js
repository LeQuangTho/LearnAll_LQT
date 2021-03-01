(function() {

    var db = {

        loadData: function(filter) {
            return $.grep(this.clients, function(client) {
                return (!filter.Name || client.Name.indexOf(filter.Name) > -1) &&
                    (filter.Age === undefined || client.Age === filter.Age) &&
                    (!filter.Address || client.Address.indexOf(filter.Address) > -1) &&
                    (!filter.Country || client.Country === filter.Country) &&
                    (filter.Married === undefined || client.Married === filter.Married);
            });
        },

        insertItem: function(insertingClient) {
            this.clients.push(insertingClient);
        },

        updateItem: function(updatingClient) {},

        deleteItem: function(deletingClient) {
            var clientIndex = $.inArray(deletingClient, this.clients);
            this.clients.splice(clientIndex, 1);
        }

    };

    window.db = db;


    db.unit = [
        { Name: "", Id: 0 },
        { Name: "Cái", Id: 1 },
        { Name: "Bộ", Id: 2 },
        { Name: "Cặp", Id: 3 },
        { Name: "Tá", Id: 4 },
        { Name: "Hộp", Id: 5 },
        { Name: "Lít", Id: 6 },
        { Name: "Kg", Id: 7 },
        { Name: "Gram", Id: 8 },
        { Name: "Mét", Id: 9 }
    ];

    db.clients = [{
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },
        {
            "Mã hàng": "1",
            "Tên hàng": "Usb",
            "Số Lượng": 6,
            "Đơn vị tính": 1,
            "Trạng thái": false
        },

    ];

}());