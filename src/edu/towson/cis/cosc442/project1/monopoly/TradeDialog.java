package edu.towson.cis.cosc442.project1.monopoly;

/**
 * This interface defines the contract for a trade dialog in the Monopoly game.
 * Implementing classes will provide the functionality to execute a trade deal between players.
 */
public interface TradeDialog {
    /**
     * Executes getTradeDeal.
     * @return the result
     */
    TradeDeal getTradeDeal();
}
