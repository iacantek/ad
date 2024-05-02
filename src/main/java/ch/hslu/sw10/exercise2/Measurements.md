# Time Measurements

## Quick Sort (Character)

| Iteration | Items     | Duration    |
|-----------|-----------|-------------|
| 1         | 100'000   | 132.785 ms  |
| 2         | 100'000   | 87.499 ms   |
| 3         | 100'000   | 86.992 ms   |
| 1         | 500'000   | 2139.986 ms |
| 2         | 500'000   | 2132.663 ms |
| 3         | 500'000   | 2124.155 ms |
| 1         | 1'000'000 | 8508.656 ms |
| 2         | 1'000'000 | 8532.446 ms |
| 3         | 1'000'000 | 8527.942 ms |

## Improved Quick Sort (Character)

| Iteration | Items     | Duration  |
|-----------|-----------|-----------|
| 1         | 100'000   | 32.53 ms  |
| 2         | 100'000   | 19.701 ms |
| 3         | 100'000   | 6.397 ms  |
| 1         | 500'000   | 36.838 ms |
| 2         | 500'000   | 37.123 ms |
| 3         | 500'000   | 37.319 ms |
| 1         | 1'000'000 | 75.318 ms |
| 2         | 1'000'000 | 92.935 ms |
| 3         | 1'000'000 | 75.248 ms |

## Improved Quick Sort (Integer)

| Iteration | Items      | Range | Duration    |
|-----------|------------|-------|-------------|
| 1         | 10'000'000 | 0-999 | 1243.549 ms |
| 2         | 10'000'000 | 0-999 | 1265.425 ms |
| 3         | 10'000'000 | 0-999 | 1209.32 ms  |
| 1         | 20'000'000 | 0-999 | 2832.494 ms |
| 2         | 20'000'000 | 0-999 | 2776.552 ms |
| 3         | 20'000'000 | 0-999 | 2869.075 ms |
| 1         | 40'000'000 | 0-999 | 6670.561 ms |
| 2         | 40'000'000 | 0-999 | 6390.191 ms |
| 3         | 40'000'000 | 0-999 | 6516.999 ms |

<style>
    tr {
        color: black;
    }

    tr:nth-child(3n+1), tr:nth-child(3n+2), tr:nth-child(3n+3) {
        background-color: lightgreen;
    }

    tr:nth-child(3n+4), tr:nth-child(3n+5), tr:nth-child(3n+6) {
        background-color: lightblue;
    }

    tr:nth-child(3n+7), tr:nth-child(3n+8), tr:nth-child(3n+9) {
        background-color: lightsalmon;
    }
</style>