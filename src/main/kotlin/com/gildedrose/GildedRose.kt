package com.gildedrose

const val QUALITY_LIMIT = 50

class GildedRose(val items: List<Item>) {
    /**
     * Solution 1: Leaving item untouched
     */
    fun updateQuality() = items.forEach {
        when (it) {
            is ConjuredItem -> it.decreaseQuality().decreaseSellIn()
            is AgingItem -> it.increaseQuality()
            is BackstagePassItem -> it.increaseOrDropQuality().decreaseSellIn()
            is LegendaryItem -> it.update()
            else -> {
                it.quality = if (it.sellIn <= 0) it.quality - 2 else it.quality - 1
                it.sellIn -= 1

                if (it.quality < 0) {
                    it.quality = 0
                }
            }
        }
    }

    /**
     * Solution 2: Extending item class
     */
    fun updateQualityExtended() = items.onEach(Item::updateQuality).onEach(Item::decrementSellIn)
}

