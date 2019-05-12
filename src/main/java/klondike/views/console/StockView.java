package klondike.views.console;

import klondike.models.Stock;
import klondike.utils.IO;

public class StockView {

    private final Stock stock;

    StockView(Stock stock) {
        this.stock = stock;
    }

    public void writeln() {
        IO.write(Message.STOCK_TITLE);
        if (this.stock.empty())
            IO.writeln(Message.EMPTY);
        else
            new CardView(this.stock.peek()).writeln();
    }
}
