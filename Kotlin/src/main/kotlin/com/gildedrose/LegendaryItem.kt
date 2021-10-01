package com.gildedrose

class LegendaryItem(name: String) : Item(name, 0, 80) {
    // Stays constant

    /**
     * Solution 1: Leaving item untouched
     */
    fun update() {}

    /**
     * Solution 2: Extending item class
     */
    override fun decrementSellIn() {}
    override fun updateQuality() {}
}