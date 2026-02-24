# File Copier Utility

A Java command line application that securely copies the contents of a source file to a destination file using byte streams. 

## Features
* Validates the existence of the source file prior to execution.
* Utilizes Java byte streams for efficient data transfer.
* Implements try-with-resources for reliable memory and stream management.

## Prerequisites
* Java Development Kit (JDK) 17 or higher

## Usage

1. Compile the Java source file:
   ```bash
   javac FileCopier.java
   ```
2. Execute the compiled class:
   ```bash
   java FileCopier
   ```

3. Follow the interactive console prompts to provide the source and destination file paths.