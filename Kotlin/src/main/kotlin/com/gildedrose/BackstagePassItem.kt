package com.gildedrose

class BackstagePassItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    /**
     * Solution 1: Leaving item untouched
     */
    fun increaseOrDropQuality() = apply {
        quality = when {
            sellIn < 1 -> 0
            sellIn < 6 -> quality + 3
            sellIn < 11 -> quality + 2
            else -> quality + 1
        }
    }

    fun decreaseSellIn() {
        sellIn -= 1
    }

    /**
     * Solution 2: Extending item class
     */
    override fun updateQuality() {
        increaseOrDropQuality()
    }
}