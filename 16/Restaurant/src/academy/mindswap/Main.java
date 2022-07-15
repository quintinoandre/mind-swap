package academy.mindswap;

public class Main {
  public static void main(String[] args) {

    // INDIVIDUAL CLIENTS

    Restaurant ginsu = new Restaurant(3);   //restaurant -> Table[] tables {null,null,null}

    Client mary = new Client();  //restaurant -> Table[] tables {null,null,null}
    mary.order("ss");
    mary.setRestaurant(ginsu);  //restaurant -> Table[] tables {null,null,null}
    mary.order("ss");
    // Ask for table && order
    mary.askForTable();  //restaurant -> Table[] tables {table,null,null}
    mary.order("Lobster"); //restaurant -> Table[] tables {table,null,null}

    // Ask for second table
    mary.askForTable(); //restaurant -> Table[] tables {table,null,null}

    // Ask for second plate
    mary.order("Carbonara"); //restaurant -> Table[] tables {table,null,null}

    // pay
    mary.pay(); //restaurant -> Table[] tables {table,null,null}

    // Check payment without table
    mary.pay(); //restaurant -> Table[] tables {table,null,null}

    // Check order without table
    mary.order("Soup"); //restaurant -> Table[] tables {table,null,null}

    // MULTIPLE CLIENTS
    Restaurant oceanAndSun = new Restaurant(5);
    Client[] clients = new Client[6]; //{null,null,null,null,null,null}


    for (int i = 0; i < clients.length; i++) {
      clients[i] = new Client();   //client[0] = new Client();  {0xFFF1,null,null,null,null,null}
      //client[1] = new Client();  {0xFFF1,0xFFF2,null,null,null,null}
      clients[i].setRestaurant(oceanAndSun); //0xFFF1.setRestaurant(oceanAndSun);
    }

    for (Client client : clients) {
      client.askForTable();
    }

    clients[1].order("Fried fish");
    clients[1].pay();

    clients[5].askForTable();
    clients[5].order("Salad");

    clients[4].pay();
  }
}
