# BTime - Flexible Time Management Class

`BTime` is a Java class designed to facilitate flexible time management, allowing you to manipulate time by adding days,
hours, minutes, and seconds with customizable formatting. Whether you need to calculate elapsed time, set specific
durations, or display time in a particular format, `BTime` has you covered.

This code is built for Java 8, the latest LTS.
[Click to download](https://dev.java)

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
    - [Creating an Instance](#creating-an-instance)
    - [Manipulating Time](#manipulating-time)
    - [Formatting](#formatting)
- [Examples](#examples)
- [Contributing](#contributing)

## Installation

To use the `BTime` class in your Java project, you can simply copy the provided `BTime.java` file into your source code
directory.

## Usage

### Creating an Instance

You can create a `BTime` instance in multiple ways:

- Creating an instance initialized to zero:

```java
public class Main {
    public static void main(String[] args) {
        BTime myTime = BTime.ofZero();
    }
}
```

- Creating an instance with a specific duration in seconds, minutes, hours, or days:

```java
public class Main {
    public static void main(String[] args) {
        BTime myTime = BTime.ofSeconds(120);
    }
}
```

### Manipulating Time

BTime provides methods for adding and subtracting time in various units:

Adding and subtracting seconds, minutes, hours, and days:

```java
public class Main {
    public static void main(String[] args) {
        myTime.plusSeconds(30);
        myTime.minusMinutes(15);
    }
}
```

### Formatting

You can format the BTime instance as a string using a customizable pattern. Supported patterns include:

d: Days
h: Hours
m: Minutes
s: Seconds
Patterns with two characters (e.g., dd, hh) will add leading zeros for values below 10.

### Examples:

```java
public class Main {
    public static void main(String[] args) {
        String formattedTime = myTime.format("hh:mm:ss");
        System.out.println(formattedTime);  // Output: 00:02:05
    }
}
```

Here's an additional example where 8 days are added to a BTime instance, and the time is formatted as "hh:mm:ss":

```java
public class Main {
    public static void main(String[] args) {
        // Creating an instance
        BTime myTime = BTime.ofZero();

        // Adding 8 days
        myTime.plusDay(8);

        // Formatting as a string
        String formattedTime = myTime.format("hh:mm:ss");
        System.out.println(formattedTime);  // Output: 192:00:00
    }
}
```

Here are a few examples to illustrate the capabilities of the BTime class:

```java
public class Main {
    public static void main(String[] args) {
        // Creating an instance
        BTime myTime = BTime.ofMinutes(125);

        // Manipulating time
        myTime.plusSeconds(30);
        myTime.minusHours(1);

        // Formatting as a string
        String formattedTime = myTime.format("hh:mm:ss");
        System.out.println(formattedTime);  // Output: 01:05:30

    }
}
```

### Contributing

If you have suggestions, improvements, or find any issues, feel free to open an issue or submit a pull request. Your
contributions are highly appreciated!

<h1 align="center">
    💻 Technologies
</h1>

<div align="center">
    <img src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java"/>
</div>

<h1 align="center">
    🌟 Spread the word!
</h1>

If you want to say thank you:

- Add a GitHub Star to the project!
- Follow my GitHub [bardiademon](https://github.com/bardiademon)

<h1 align="center">
    ⚠️ License & 📝 Credits
</h1>

by bardiademon [https://bardiademon.com](https://www.bardiademon.com)