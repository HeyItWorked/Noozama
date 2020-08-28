package group7.noozama.dso;

import group7.noozama.database.StubDatabase;

public interface Global {
    int dataSwitch = 0;
    ShoppingCart cart = new ShoppingCart();
    StubDatabase stubDatabase = new StubDatabase();
}