package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `quality degrades twice as fast once sell date has passed`() {
        // Arrange
        val app = GildedRose(listOf(Item("Rogue River Blue Cheese", 2, 40)))
        val item = app.items[0]

        // Act
        repeat(2) {
            app.updateQuality()
        }

        // Assert
        assertEquals(0, item.sellIn)
        assertEquals(38, item.quality)

        // Act
        repeat(2) {
            app.updateQuality()
        }

        // Assert
        assertEquals(-2, item.sellIn)
        assertEquals(34, item.quality)
    }

    @Test
    fun `quality of an item is never negative`() {
        // Arrange
        val app = GildedRose(listOf(Item("Winnimere Cheese", 3, 2)))
        val item = app.items[0]

        // Act
        repeat(4) {
            app.updateQuality()
        }

        // Assert
        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

    @Test
    fun `quality of aged items increases the older they get`() {
        // Arrange
        val app = GildedRose(listOf(AgingItem("Aged Brie", 35)))
        val item = app.items[0]

        // Act
        repeat(3) {
            app.updateQuality()
        }

        // Assert
        assertEquals(38, item.quality)
    }

    @Test
    fun `quality of items cannot increase above limit`() {
        // Legendary items are above the quality limit, but are constant and will not increase in quality.

        // Arrange
        val app = GildedRose(listOf(AgingItem("Aged Brie", 45)))
        val item = app.items[0]

        // Act
        repeat(8) {
            app.updateQuality()
        }

        // Assert
        assertEquals(50, item.quality)
    }

    @Test
    fun `legendary item has a constant quality over time`() {
        // Arrange
        val app = GildedRose(listOf(LegendaryItem("Sulfuras, Hand of Ragnaros")))
        val item = app.items[0]

        // Act
        repeat(4) {
            app.updateQuality()
        }

        // Assert
        assertEquals(80, item.quality)
    }

    @Test
    fun `backstage passes increase in quality towards concert date, but lose all quality after it`() {
        //  Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
        //	Quality drops to 0 after the concert

        // Arrange
        val items = listOf(
            BackstagePassItem("Moderat Album Release concert", 11, 10),
            BackstagePassItem("Eminem on tour", 10, 10),
            BackstagePassItem("Tom Mitsch, Afas Live", 6, 20),
            BackstagePassItem("Black Sun Empire, All-nighter", 5, 20),
            BackstagePassItem("Amelie Lens b2b Charlotte de Witte", 1, 30),
            BackstagePassItem("Woodkid in convert", 0, 30),
        )
        val app = GildedRose(items)

        // Act
        app.updateQuality()

        // Assert
        assertEquals(11, app.items[0].quality)
        assertEquals(12, app.items[1].quality)
        assertEquals(22, app.items[2].quality)
        assertEquals(23, app.items[3].quality)
        assertEquals(33, app.items[4].quality)
        assertEquals(0, app.items[5].quality)
    }

    @Test
    fun `Conjured items degrade in Quality twice as fast as normal items`() {
        // Arrange
        val app = GildedRose(listOf(ConjuredItem("White Stilton Gold Cheese", 2, 40)))
        val item = app.items[0]

        // Act
        repeat(2) {
            app.updateQuality()
        }

        // Assert
        assertEquals(0, item.sellIn)
        assertEquals(36, item.quality)
    }

}


