# d), h) Time Measurements

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

# e) Maximum Depth of Java Call Stack

Determine maximum call stack size:

    public class RecursiveCallStackOverflow {
        static int depth = 0;
    
        private static void recursiveStackOverflow() {
            depth++;
            recursiveStackOverflow();
        }
        
        public static void main(String[] args) {
            try {
                recursiveStackOverflow();
            } catch (StackOverflowError e) {
                System.out.println("Maximum depth of the call stack is " + depth);
            }
        }
    }

## Call Stack Size

### My Call Stack Size

The call stack size can be fetched with the following command.

    $ java -XX:+PrintFlagsFinal -version | grep ThreadStackSize

In my case it's set at 2MB.

    intx ThreadStackSize = 2048 

Which leads to the following call stack size:

    Maximum depth of the call stack is 43445

### Default Call Stack Size

By default, the JVM allocates a 1MB thread stack size.

    intx ThreadStackSize = 1024

With a 1MB stack, approximately 10000 to 20000 method calls can be made before hitting the maximum depth, assuming each stack frame uses around 100 bytes.

    Maximum depth of the call stack is 21792

###  Increase Call Stack Size

The maximum depth can be increased by allocating more stack space for the thread using the -Xss JVM parameter:

    $ java -Xss2m RecursiveCallStackOverflow

With a 2MB thread stack size, here’s the output:

    Maximum depth of the call stack is 49522 

# i) Quicksort Ordnung

- Quicksort hat im Durchschnitt eine Ordnung von **O(n * log(n))**, im schlimmsten Fall **O(n<sup>2</sup>)**
- **O(n * log(n))** wächst schneller als **O(n)**
- Verdoppelung der Datenmenge => Verdoppelung der Zeit (d.h. 2s => ~ 4s)

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