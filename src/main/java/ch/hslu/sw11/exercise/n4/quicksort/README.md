# Measurements

| Items      | Concurrent    | Recursive     | Java      |
|------------|---------------|---------------|-----------|
| 300'000    | 0.081 sec     | 0.11 sec      | 0.01 sec  |
| 1'000'000  | 0.306 sec     | 1.917 sec     | 0.039 sec |
| 1'170'000  | StackOverflow | 2.053 sec     | 0.04 sec  |
| 10'000'000 | StackOverflow | StackOverflow | 0.206 sec |