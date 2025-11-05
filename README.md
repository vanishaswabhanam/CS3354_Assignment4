# CS3354 Assignment 4 - Automated Unit Test Generation Comparison

**Author:** Vanisha Swabhanam (VXS210083)

## Project Overview

This project compares three automated unit test generation approaches for a Java Stack implementation:
1. **EvoSuite** - Search-based test generation using evolutionary algorithms
2. **Randoop** - Random test generation through method call sequences
3. **ChatGPT** - AI-assisted test generation

## Directory Structure

```
├── pom.xml                    # Maven configuration with JaCoCo
├── README.md                  # This file
├── src/
│   └── Stack.java            # Stack implementation under test
└── test/
    ├── ChatGPTTest.java      # ChatGPT-generated tests
    ├── StackTest.java        # EvoSuite-generated tests
    ├── RegressionTest.java   # Randoop regression tests
    └── ErrorTest.java        # Randoop error tests
```

## Stack Implementation

The Stack class implements a fixed-size integer stack with the following methods:
- `push(int value)` - Add element to stack
- `pop()` - Remove and return top element
- `peek()` - Return top element without removing
- `isEmpty()` - Check if stack is empty
- `isFull()` - Check if stack is full
- `size()` - Return current number of elements

## Test Generation Methods

### 1. EvoSuite Tests (`StackTest.java`)

**Generation Command:**
```bash
java -jar evosuite.jar -class Stack -projectCP target/classes
```

**Characteristics:**
- Uses genetic algorithms to evolve test cases
- Automatically generates assertions
- Aims for maximum branch coverage
- Tests include timeout annotations (4000ms)
- 16 test methods covering various scenarios

### 2. Randoop Tests (`RegressionTest.java` + `ErrorTest.java`)

**Generation Command:**
```bash
java -classpath .:randoop-all-4.3.2.jar randoop.main.Main gentests --testclass=Stack
```

**Characteristics:**
- Random exploration of method call sequences
- Actually generated using Randoop 4.3.3
- 31 regression tests in RegressionTest0.java
- Tests boundary conditions and exception paths
- Uses method name ordering for deterministic execution

### 3. ChatGPT Tests (`ChatGPTTest.java`)

**Generation Prompt:**
```
Generate comprehensive JUnit test cases for a Stack implementation that test
all methods including edge cases, boundary conditions, exception scenarios,
and normal operations.
```

**Characteristics:**
- Human-readable test names and comments
- Organized by method being tested
- Comprehensive edge case coverage
- Integration tests for complex scenarios
- 37 test methods with clear assertions

## Running the Tests

### Using Maven (Recommended)

```bash
# Compile the project
mvn clean compile

# Run all tests
mvn test

# Generate JaCoCo coverage report
mvn jacoco:report
```

Coverage reports will be generated in `target/site/jacoco/index.html`

### Manual Compilation

```bash
# Compile source
javac -d target/classes src/Stack.java

# Compile tests (requires JUnit 4.13.2 in classpath)
javac -cp target/classes:junit-4.13.2.jar -d target/test-classes test/*.java

# Run tests with JaCoCo
java -javaagent:jacocoagent.jar -cp target/classes:target/test-classes:junit-4.13.2.jar org.junit.runner.JUnitCore ChatGPTTest StackTest RegressionTest ErrorTest
```

## Coverage Analysis

Expected coverage metrics for each test suite:

| Test Suite | Statement Coverage | Branch Coverage | Method Coverage |
|------------|-------------------|-----------------|-----------------|
| ChatGPT    | ~100%             | ~100%           | 100%            |
| EvoSuite   | ~95-100%          | ~95-100%        | 100%            |
| Randoop    | ~90-95%           | ~90-95%         | 100%            |

All three approaches should achieve high coverage due to the simplicity of the Stack class.

## Key Findings

### EvoSuite Strengths
- Excellent automated assertion generation
- High mutation score (tests detect defects well)
- Covers edge cases automatically
- Minimal manual effort required

### Randoop Strengths
- Very fast test generation
- Good at finding exception-throwing sequences
- Separates error and regression tests
- Simple to use and configure

### ChatGPT Strengths
- Most readable and maintainable tests
- Well-organized with clear test names
- Includes integration/scenario tests
- Easy to understand test intent
- Can incorporate domain knowledge

## References

- EvoSuite: https://www.evosuite.org/
- Randoop: https://randoop.github.io/randoop/
- JaCoCo: https://www.jacoco.org/
- JUnit 4: https://junit.org/junit4/