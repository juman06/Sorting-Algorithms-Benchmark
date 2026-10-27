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
Comparative performance analysis between O(N^2) and O(N log N) algorithms:
Quick Sort operates in O(N log N) time and scales exceptionally well for large datasets like N = 100,000, processing them quickly. In contrast, Bubble Sort has an O(N^2) time complexity and suffers from massive time degradation on large inputs due to its nested loops.

Identification of the optimal algorithm for sorted and partially sorted data, with detailed reasoning:
For fully sorted arrays, Bubble Sort is optimal in this specific implementation because its swapped flag enables early termination, reducing its best-case time complexity to linear O(N). However, for partially sorted (80% sorted) and reversed arrays, Quick Sort is the clear winner, as Bubble Sort's optimization fails when elements are out of place, pushing it back to O(N^2).

Explanation of Quick Sort behavior in reverse/fully sorted cases and the impact of pivot selection:
Naive pivot selections, such as choosing the first or last element, cause Quick Sort to degrade to O(N^2) performance and risk stack overflow on sorted or reversed data. However, your code uses a middle-element pivot strategy (a[left + (right - left) / 2]), which creates balanced partitions even on sorted inputs and preserves optimal O(N log N) performance.
