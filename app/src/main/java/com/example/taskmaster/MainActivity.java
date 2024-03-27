package com.example.taskmaster;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper dbhelper = new DataBaseHelper(this);

        clientmod client1 = new clientmod("Ahmad Mustafa",1111,"amustafa@hotmail.com", "ahmad1111");
        clientmod client2 = new clientmod("Nora Ali",1112,"nali@gmail.com", "ahmad1111");
        clientmod client3 = new clientmod("Hamid Abdullah",1113,"habdullah@yahoo.com", "ahmad1111");
        clientmod client4 = new clientmod("Abbud Obeid",1114,"aobeid@hotmail.com", "ahmad1111");
        clientmod client5 = new clientmod("Arfa Ansari",1115,"ansari@gmail.com", "ahmad1111");
        clientmod client6 = new clientmod("Shireen Tamer",1116,"stamer@yahoo.com", "ahmad1111");
        clientmod client7 = new clientmod("Ayman Yousuf",1117,"ayousuf@hotmail.com", "ahmad1111");
        clientmod client8 = new clientmod("Dameer Sattar",1118,"dsattar@gmail.com", "ahmad1111");
        clientmod client9 = new clientmod("Ibrahim Khalil",1119,"ikhalil@yahoo.com", "ahmad1111");

        dbhelper.addClient(client1);
        dbhelper.addClient(client2);
        dbhelper.addClient(client3);
        dbhelper.addClient(client4);
        dbhelper.addClient(client5);
        dbhelper.addClient(client6);
        dbhelper.addClient(client7);
        dbhelper.addClient(client8);
        dbhelper.addClient(client9);

        servicemod service1 = new servicemod("Home Maintenance",123,"Electrical repairs",200,"");
        servicemod service2 = new servicemod("Home Maintenance",234,"Plumbing repairs",245,"");
        servicemod service3 = new servicemod("Home Maintenance",345,"Gutter cleaning",150,"");
        servicemod service4 = new servicemod("Utility Maintenance",456,"Leak detection and repair",500,"");
        servicemod service5 = new servicemod("Utility Maintenance",567,"Transformer maintenance",2000,"");
        servicemod service6 = new servicemod("Utility Maintenance",678,"Streetlight maintenance",2500,"");
        servicemod service7 = new servicemod("Vehicle Maintenance",789,"Engine maintenance and repair",245,"");
        servicemod service8 = new servicemod("Vehicle Maintenance",100,"Brake system maintenance",245,"");
        servicemod service9 = new servicemod("Vehicle Maintenance",101,"Oil change",245,"");
        servicemod service10 = new servicemod("Equipment Maintenance:",102,"Copier and printer maintenance",245,"");

        dbhelper.addService(service1);
        dbhelper.addService(service2);
        dbhelper.addService(service3);
        dbhelper.addService(service4);
        dbhelper.addService(service5);
        dbhelper.addService(service6);
        dbhelper.addService(service7);
        dbhelper.addService(service8);
        dbhelper.addService(service9);
        dbhelper.addService(service10);

        ordermod order1 = new ordermod(111, 123, 1119, "Riyadh City, P.O.Box: 55570", 50,"2 hours", "Khalid Batais","pending","051234567");
        ordermod order2 = new ordermod(112, 567, 1118,"3rd Industrial City, P.O.Box: 88910", 100, "3 hours","Muhammad Ashraf","Done","054567890");
        ordermod order3 = new ordermod(113,789,1113,"Derah Dist., P.O.Box: 21634",25,"2 days","Asif Hakeem","Pending","059378378");

        dbhelper.addOrder(order1);
        dbhelper.addOrder(order2);
        dbhelper.addOrder(order3);
    }
}