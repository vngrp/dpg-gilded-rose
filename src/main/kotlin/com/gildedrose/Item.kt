package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    open fun updateQuality() {
        quality = if (sellIn <= 0) quality - 2 else quality - 1

        if (quality < 0) {
            quality = 0
        }
    }

    open fun decrementSellIn() {
        sellIn -= 1
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}