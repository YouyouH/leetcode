package hash

import "testing"

func TestWordPattern(t *testing.T) {
	if wordPattern("abba", "dog cat cat fish") {
		t.Fatal(1)
	}

	if wordPattern("abba", "dog dog dog dog") {
		t.Fatal(2)
	}

	if wordPattern("a", "dog dog dog dog") {
		t.Fatal(3)
	}

	if wordPattern("abb", "dog dog dog dog") {
		t.Fatal(4)
	}

}
