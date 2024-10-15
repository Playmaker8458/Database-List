class MobilePhone:
    def __init__(self, model : str, price : float, amount : int, details : str):
        self.model_phone = model
        self.price_phone = price
        self.Remaining_Amount = amount
        self.detail_phone = details
        self.List_ALL = []
    
    def add_ListALL(self):
        List_input = [
            self.model_phone, 
            self.price_phone
        ]
        for item in range(len(List_input)):
            self.List_ALL.append(List_input[item])

        return self.List_ALL
    
    def Show_mobile_info(self):
        print(f"Model Phone : {self.model_phone}")
        print(f"Price Phone : {self.price_phone} bath")
        print(f"Detail Phone : {self.detail_phone}")
    
    def Update_remaining_quantity(self):
        print(f"Remaining Amount : {self.Remaining_Amount} piece")


class Customer:
    def __init__(self, name : str, phone_number : str, address : str):
        self.fullname = name
        self.Phone_number = phone_number
        self.Address = address

    def Customer_details(self):
        print(f"fullname : {self.fullname}")
        print(f"Phone number: {self.Phone_number}")
        print(f"Address: {self.Address}")

class Cart:
    def __init__(self, List_A: list):
        self.list_ALL = List_A
        self.ALL_item = []

    def add_product_info(self):
        # เพิ่มรายการสินค้าและราคาในรูปแบบดิกชันนารีลงใน ALL_item 
        product, price = self.list_ALL
        self.ALL_item.append({'product': product, 'price': price})
        return self.ALL_item

    def Cart_Product(self):
        # แสดงข้อมูลสินค้าในตะกร้าทั้งหมด
        for item in self.ALL_item:
            print(f"Product name : \"{item["product"]}\" number of {len(self.ALL_item)} box")
            print(f"Price Product: {item["price"]} bath")
    

class Discount:
    def __init__(self, price : int):
        self.price_discount = price
        self.discount = 0
    
    def discount_Process(self):
        price = self.price_discount
        if price >= 10000 and price < 15000:
            self.discount =  5
        elif price >= 15000 and price < 20000:
            self.discount =  10
        elif price >= 20000 and price < 25000:
            self.discount =  15
        else:
            self.discount = 20
        return self.discount
    
    def calculate_discount(self, discount : int):
        price = self.price_discount
        discount_price = round(price * (discount / 100))
        return price - discount_price


class Order:
    def __init__(self, number : str, date : str, status : str, Product : str, price : int):
        self.order_number = number
        self.order_date = date
        self.order_status = status 
        self.product_list = Product
        self.price_Product = price
        
    
    def Order_status(self):
        List_all = [
            [self.order_number], 
            [self.order_date],
            [self.order_status],
            [self.product_list], 
            [self.price_Product]
        ]
        for number, date, status, name, price in zip(List_all[0], List_all[1], List_all[2] ,List_all[3], List_all[4]):
            print(f"Order number: {number}")
            print(f"Order date: {date}")
            print(f"Order status: {status}")
            print(f"Product name : {name}")
            print(f"Discounted items: {price} bath")


class Payment:
    def __init__(self, Payment : str, total_amount : int, amount_paid  : int):
        self.Payment_Method = Payment
        self.total_amount = total_amount 
        self.amount_paid = amount_paid  
     
    def Make_payment_processs(self):
        if self.Payment_Method in ["Credit Card", "Bank Transfer", "Cash"]:
            change = self.amount_paid - self.total_amount
            if self.amount_paid >= self.total_amount:
                print("Payment completed successfully")
                print(f"Amount: {change} bath")
            else:
                print("Payment failed")
                print(f"Amount: {change} bath")
        else:
            print("Invalid payment method.")


class Product_History:
    def __init__(self, History : list):
        self.Order_History = History
    
    def Product_Order_History(self):
        print("Order History:")
        List_product = [self.Order_History[0]]
        for product in List_product:
            print(f"- {product}")


if "__main__" == __name__:
    Mobile_input = MobilePhone("Lenovo K13 Pro", 15000, 12, "\n- Type: IPS LCD, 90Hz\n- Size: 6.51 inches, 102.3 cm2")
    Customer_input = Customer("pongpol chaichavalitskul", "082-308-7808", "Pridi Banomyong 16")

    ALL_item = Mobile_input.add_ListALL()
    Cart_input = Cart(ALL_item)
    Cart_ALL = Cart_input.add_product_info()


    Price = Cart_ALL[0]["price"]
    discount_input = Discount(Price)
    discount_modulas = discount_input.discount_Process()
    discount_price = discount_input.calculate_discount(discount_modulas)

    order_input = Order("TH-435345AS", "10/5/2567", "pass", Mobile_input.model_phone, discount_price)
    payment_input = Payment("Cash", discount_price, 14000)
    history_input = Product_History(ALL_item)

    print("\n======== รายละเอียดสินค้ามือถือ ========")
    Mobile_input.Show_mobile_info()
    Mobile_input.Update_remaining_quantity()
    print("===============================")
    print("\n========== รายละเอียดลูกค้า ==========")
    Customer_input.Customer_details()
    print("===================================")
    print("\n================== ตะกร้าสินค้า ===================")
    Cart_input.Cart_Product()
    print("================================================")
    print("\n================== คำสั่งซื้อ ======================")
    order_input.Order_status()
    print("================================================")
    print("\n================== การชำระเงิน ====================")
    payment_input.Make_payment_processs()
    print("==================================================")
    print("\n=============== ประวัติการสั่งซื้อสินค้า =================")
    history_input.Product_Order_History()
    print("==================================================")