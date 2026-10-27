# Sorting-Algorithms-Benchmark

# Student Information:
 -Full name: جمانة عماد الدين محمد
 -Student ID: 3168053
 -Section number: Group "C"

# Execution time table:
RESULTS IN MICROSECONDS (N = 100000)
Algorithm               Random        Reversed      80% Sorted    Fully Sorted
Quick Sort              47,943          10,381           5,056           1,695
Bubble Sort         16,549,794       8,158,112       5,054,834              25

# Performance chart:


# Result analysis:
**Quick Sort** Demonstrates robust $O(N \log N)$ performance across all data distributions. Its execution time remains stable and fast (~10ms) whether the array is completely random, reversed, or partially sorted.

**Bubble Sort** Exhibits extreme performance variance. On random and reversed data, its $O(N^2)$ time complexity causes it to take several seconds (millions of microseconds). However, thanks to the **early-exit optimization flag** (`if (!swapped) break;`) implemented in the code, it detects that a **Fully Sorted** array requires no swaps and terminates instantly in $O(N)$ time.
