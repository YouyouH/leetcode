package main

import "testing"

func TestBestTimeToBuyAndSellStockWithCooldown(t *testing.T) {
	if 3 != maxProfit([]int{1, 2, 3, 0, 2}) {
		t.Fail()
	}

	if 0 != maxProfit(nil) {
		t.Fail()
	}

	if 0 != maxProfit([]int{}) {
		t.Fail()
	}
}
