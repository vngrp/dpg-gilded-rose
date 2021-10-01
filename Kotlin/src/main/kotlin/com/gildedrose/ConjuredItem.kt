package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    /**
     * Solution 1: Leaving item untouched
     */
    fun decreaseQuality() = apply {
        quality = if (quality <= 1) 0 else quality - 2
    }

    fun decreaseSellIn() {
        sellIn -= 1
    }

    /**
     * Solution 2: Extending item class
     */
    override fun updateQuality() {
        decreaseQuality()
    }
}