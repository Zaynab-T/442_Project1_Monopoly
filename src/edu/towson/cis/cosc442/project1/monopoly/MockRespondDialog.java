package edu.towson.cis.cosc442.project1.monopoly;

/**
 * MockRespondDialog is a mock implementation of the RespondDialog interface for testing purposes.
 * It simulates a response dialog in the Monopoly game, allowing for controlled testing of trade deal responses.
 */
public class MockRespondDialog implements RespondDialog {
    /**
     * Constructs a MockRespondDialog with the specified trade deal to simulate a response dialog.
     * @param deal the trade deal involved in the dialog
     */
    public MockRespondDialog(TradeDeal deal) {
    }

    /**
     * Returns a simulated user response for the dialog, always true in this mock implementation.
     * @return the simulated boolean response from the dialog
     */
    public boolean getResponse() {
        return true;
    }
}
