package com.gildedrose

class AgingItem(name: String, quality: Int) : Item(name, 0, quality) {
    /**
     * Solution 1: Leaving item untouched
     */
    fun increaseQuality() = apply {
        quality = if (quality < QUALITY_LIMIT) quality + 1 else QUALITY_LIMIT
    }

    /**
     * Solution 2: Extending item class
     */
    override fun updateQuality() {
        increaseQuality()
    }
}