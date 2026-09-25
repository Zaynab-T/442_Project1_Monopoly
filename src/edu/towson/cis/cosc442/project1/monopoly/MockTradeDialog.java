package edu.towson.cis.cosc442.project1.monopoly;

/**
 * MockTradeDialog is a mock implementation of the TradeDialog interface for testing purposes.
 * It simulates a trade dialog by providing a predefined trade deal without requiring user interaction.
 */
public class MockTradeDialog implements TradeDialog {

    /**
     * Executes getTradeDeal.
     * @return the result
     */
    public TradeDeal getTradeDeal() {
        TradeDeal deal = new TradeDeal();
        deal.setAmount(200);
        deal.setSellerIndex(0);
        deal.setPropertyName(GameMaster.instance().getGameBoard().getCell(1).toString());
        return deal;
    }
}
