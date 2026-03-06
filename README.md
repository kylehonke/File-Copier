# File Copier Utility

A Java command line application that securely copies the contents of a source file to a destination file using byte streams. 

---

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

## Technical Explanation

The program utilizes FileInputStream and FileOutputStream. In Java, these classes are classified as byte streams. Instead of reading the file as text characters, the program reads the raw binary data in chunks using a byte array (i.e. `byte[] buffer = new byte[1024];`). Because the program writes these raw bytes directly to the destination without attempting to interpret or encode them as text, it creates an exact bit-for-bit duplicate of the original file.

Due to this byte-level processing, the program can copy a wide array of file formats, including:

- Image files (.jpg, .jpeg, .png, .gif)
- Document files (.pdf, .doc, .xls, .txt, .csv, .json)
- Archive files (.zip, .tar, .rar, etc.)
- Audio files (.mp3, .wav, .flac)
- Video files (.mp4, .mov, .mkv)
- Executable files (.exe, .dll, .class, etc.)
- Other files (.srm, .z64, etc.)
- .webm and .webp files have not been tested, but should work as intended.

