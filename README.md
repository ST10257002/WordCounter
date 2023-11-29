# WordCounter

> Java application to parse large volumes of text and analyse its contents.

## Credits

This software was created by *Matthew Pieterse (2023)*

**Connect with me:**

- [LinkedIn](https://www.linkedin.com/in/matthew-pieterse-183705254/)

## Versions

### (pre-0.1.0)

The aesthetic overhaul update.

**Added**

- GitHub integration using Git.
- Graphical user interface concept design.
    - Uses the FlatLaf IntelliJ themes to style native Swing components.

### (pre-0.2.0)

The stone-age update.

**Added**

- Menubar item to reset the textbox.
- Menubar item to copy textbox contents to system clipboard.
- Menubar item to open github repository in browser.
- Menubar item to display software information.
- Menubar item to open configuration dialog.
- Always on-top toggle button functionality.
- Dialog to configure application settings.
- Dynamic theme selection on application startup.
- Class: `Factor.java` to parse textbox contents and update table.
- Class: `Symbol.java` to define character codes of recognised symbols.
- Class: `IDefinition.java` interface to enforce code structure.

**Updated**

- Verbose import implementations.

**Documentation**

- JavaDoc: `Symbol.define()`
- JavaDoc: `Factor.calculateTime()`
- JavaDoc: `Factor.getTable()`

### (pre-0.3.0)

The iron-age advancement update.

**Added**

- `[MAJOR]` Class to handle interactions with configuration files.
- Configuration file to handle application settings for future launches.
- Configuration file to contain information regarding the current build.
- Configuration file to contain commonly accessed weblinks.

**Updated**

- Symbols class no longer implements an interface.
- `[MAJOR]` Vastly improved code structure and techniques.
- Increased adoption of inline javadocs.
- Improved gitignore implementation.